package covidresources;

import com.google.cloud.firestore.*;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import covidresources.config.FireBaseService;
import covidresources.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.api.core.ApiFuture;
import com.google.firebase.cloud.FirestoreClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
public class DBService {
    Firestore fireBaseDB = null;

    public void getPatientDetails() throws InterruptedException, ExecutionException {
        fireBaseDB = FirestoreClient.getFirestore();
        Patient patient = new Patient();
        patient.setName("Ash");
        patient.setAge(13);
        patient.setCity("noida");
        System.out.println(fireBaseDB.collection("test").listDocuments().iterator().next());
   // Add new Document
  /*      ApiFuture<WriteResult> future = fireBaseService.getDb().collection("test").document("LA").set(patient);;
        System.out.println("Update time : " + future.get().getUpdateTime());*/

        // update doc, create the document if missing
/*        ApiFuture<WriteResult> writeResult = fireBaseService.getDb().collection("test").document("LA").set(patient, SetOptions.merge());
        System.out.println("Update time : " + writeResult.get().getUpdateTime());*/
        Map<String, Object> data = new HashMap<>();
        data.put("name", "himmat");
        data.put("country", "wala");
        ApiFuture<DocumentReference> addedDocRef = fireBaseDB.collection("test").add(data);
        System.out.println("Added document with ID: " + addedDocRef.get().getId());


    }
}
