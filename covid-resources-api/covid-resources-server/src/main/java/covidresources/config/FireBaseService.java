package covidresources.config;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileInputStream;
import java.io.InputStream;

public class FireBaseService {

    FirebaseDatabase db;
    private final String FIREBASE_CREDS_PATH = "src/main/resources/key.json";

    public FireBaseService()  {
        // Use a service account
        InputStream serviceAccount = null;
        try {
            serviceAccount = new FileInputStream(FIREBASE_CREDS_PATH);

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://testcode-570c6-default-rtdb.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);

        } catch (Exception e) {
            e.printStackTrace();
        }

         db = FirebaseDatabase.getInstance();

    }

    public FirebaseDatabase getDb() {
        return db;
    }

}
