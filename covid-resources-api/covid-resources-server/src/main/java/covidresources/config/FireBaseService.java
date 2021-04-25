package covidresources.config;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.FirebaseDatabase;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class FireBaseService {

    Firestore db;
    private final String FIREBASE_CREDS_PATH = "src/main/resources/key.json";

    @PostConstruct
    public void initialize() {
        // Use a service account
        try {
            InputStream serviceAccount = new FileInputStream(FIREBASE_CREDS_PATH);
            GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(credentials)
                    .build();
            FirebaseApp.initializeApp(options);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}
