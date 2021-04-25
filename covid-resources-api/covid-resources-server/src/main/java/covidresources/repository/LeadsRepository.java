package covidresources.repository;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

import covidresources.model.documents.Lead;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

@Repository
@Slf4j
public class LeadsRepository extends AbstractFirestoreRepository<Lead> {
	
	private Firestore firestore;

    protected LeadsRepository(Firestore firestore) {
        super(firestore, "Lead");
        this.firestore = firestore;
    }
    
    public List<Lead> filterLeadsForStatesAndCities(List<String> states, List<String> cities){
    	CollectionReference collectionReference = this.firestore.collection("Lead");
    	ApiFuture<QuerySnapshot> querySnapshotApiFuture;
    	if(CollectionUtils.isEmpty(states) && CollectionUtils.isEmpty(cities)) {
    		return retrieveAll();
    	}else if(CollectionUtils.isEmpty(states)){
    		querySnapshotApiFuture = collectionReference.whereIn("city", cities).get();
    	}else if(CollectionUtils.isEmpty(cities)) {
    		querySnapshotApiFuture = collectionReference.whereIn("state", states).get();
    	}else {
    		querySnapshotApiFuture = collectionReference.whereIn("state", states).whereIn("city", cities).get();
    	}

        try {
            List<QueryDocumentSnapshot> queryDocumentSnapshots = querySnapshotApiFuture.get().getDocuments();
            List<Lead> leadsList = new ArrayList<Lead>();
            for (DocumentSnapshot document : queryDocumentSnapshots) {
                leadsList.add(document.toObject(Lead.class));
            }
            return leadsList;

        } catch (InterruptedException | ExecutionException e) {
            log.error("Exception occurred while retrieving all document for {}", "Lead");
        }
        return Collections.<Lead>emptyList();

    }


}
