package covidresources.repository;

import org.springframework.stereotype.Repository;

import com.google.cloud.firestore.Firestore;

import covidresources.model.documents.User;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class UserRepository extends AbstractFirestoreRepository<User> {
	
	private Firestore firestore;

    protected UserRepository(Firestore firestore) {
        super(firestore, "User");
        this.firestore = firestore;
    }

}

