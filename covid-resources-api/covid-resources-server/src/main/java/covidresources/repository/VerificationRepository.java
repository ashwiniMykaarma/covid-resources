package covidresources.repository;

import org.springframework.stereotype.Repository;

import com.google.cloud.firestore.Firestore;

import covidresources.model.documents.Verification;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class VerificationRepository extends AbstractFirestoreRepository<Verification> {
	
	private Firestore firestore;

    protected VerificationRepository(Firestore firestore) {
        super(firestore, "Verification");
        this.firestore = firestore;
    }

}
