package covidresources;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import covidresources.config.FireBaseService;
import covidresources.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class DBService {
    FireBaseService fireBaseService = new FireBaseService();
    public void getPatientDetails() throws InterruptedException, ExecutionException {
        DatabaseReference dbRef = fireBaseService.getDb().getReference().child("users");
        System.out.println(dbRef.child("users").push().getKey());
//        DatabaseReference hopperRef = dbRef.child("gracehop");
//        Map<String, Object> hopperUpdates = new HashMap<>();
//        hopperUpdates.put("myname", "Amazing Raahul");
//
//        hopperRef.updateChildrenAsync(hopperUpdates);

        Map<String, String> users = new HashMap<>();
        users.put(dbRef.child("users").push().getKey(), "June 23, 1912");
        users.put(dbRef.child("users").push().getKey(), "December 9, 1906");

        dbRef.child("users").child(dbRef.child("users").push().getKey()).setValueAsync(users);

    }
}
