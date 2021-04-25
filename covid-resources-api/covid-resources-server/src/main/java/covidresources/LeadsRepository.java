package covidresources;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import covidresources.model.documents.Lead;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class LeadsRepository extends AbstractFirestoreRepository<Lead> {

    protected LeadsRepository(Firestore firestore) {
        super(firestore, "Lead");
    }


}
