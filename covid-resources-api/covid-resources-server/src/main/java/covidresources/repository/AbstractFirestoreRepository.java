package covidresources.repository;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.database.annotations.Nullable;
import covidresources.model.DocumentId;
import covidresources.model.documents.Lead;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.ParameterizedType;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Slf4j
public abstract class AbstractFirestoreRepository<T> {
    private final CollectionReference collectionReference;
    private final String collectionName;
    private final Class<T> parameterizedType;

    protected AbstractFirestoreRepository(Firestore firestore, String collection) {
        this.collectionReference = firestore.collection(collection);
        this.collectionName = collection;
        this.parameterizedType = getParameterizedType();
    }


    private Class<T> getParameterizedType() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        return (Class<T>) type.getActualTypeArguments()[0];
    }

    public String save(T model){
        String documentId = getDocumentId(model);
        ApiFuture<WriteResult> resultApiFuture = collectionReference.document(documentId).set(model);

        try {
            log.info("{}-{} saved at{}", collectionName, documentId, resultApiFuture.get().getUpdateTime());
            return documentId;
        } catch (InterruptedException | ExecutionException e) {
            log.error("Error saving {}={} {}", collectionName, documentId, e.getMessage());
        }

        return "false";
    }

    public String update(T model,String documentId){
        log.info("Update doc id is : "+documentId);
        ApiFuture<WriteResult> resultApiFuture = collectionReference.document(documentId).set(model, SetOptions.merge());

        try {
            log.info("{}-{} updated at{}", collectionName, documentId, resultApiFuture.get().getUpdateTime());
            return documentId;
        } catch (InterruptedException | ExecutionException e) {
            log.error("Error updating {}={} {}", collectionName, documentId, e.getMessage());
        }

        return "false";
    }

    public void delete(T model){
        String documentId = getDocumentId(model);
        ApiFuture<WriteResult> resultApiFuture = collectionReference.document(documentId).delete();

    }

    public void delete(String documentId){
        ApiFuture<WriteResult> resultApiFuture = collectionReference.document(documentId).delete();

    }

    public List<T> retrieveAll(){
        ApiFuture<QuerySnapshot> querySnapshotApiFuture = collectionReference.get();

        try {
            List<QueryDocumentSnapshot> queryDocumentSnapshots = querySnapshotApiFuture.get().getDocuments();

            return queryDocumentSnapshots.stream()
                    .map(queryDocumentSnapshot -> queryDocumentSnapshot.toObject(parameterizedType))
                    .collect(Collectors.toList());

        } catch (InterruptedException | ExecutionException e) {
            log.error("Exception occurred while retrieving all document for {}", collectionName);
        }
        return Collections.<T>emptyList();

    }

    public List<T> filterDocumentsForValue(String field, String value){
        ApiFuture<QuerySnapshot> querySnapshotApiFuture = collectionReference.whereEqualTo(field, value).get();

        try {
            List<QueryDocumentSnapshot> queryDocumentSnapshots = querySnapshotApiFuture.get().getDocuments();
            for (DocumentSnapshot document : queryDocumentSnapshots) {
                System.out.println(document.getId() + " => " + document.toObject(Lead.class));
            }

        } catch (InterruptedException | ExecutionException e) {
            log.error("Exception occurred while retrieving all document for {}", collectionName);
        }
        return Collections.<T>emptyList();
    }

    @SneakyThrows
    public Optional<T> filterDocumentsForValueInListObject(String field, String value){
        ApiFuture<QuerySnapshot> querySnapshotApiFuture = collectionReference.whereArrayContains(field, value).get();
        try {
            List<QueryDocumentSnapshot> queryDocumentSnapshots = querySnapshotApiFuture.get().getDocuments();
            for (DocumentSnapshot document : queryDocumentSnapshots) {
                System.out.println(document.getId() + " => " + document.toObject(Lead.class));
                return Optional.ofNullable(document.toObject(parameterizedType));
            }

        } catch (InterruptedException | ExecutionException e) {
            log.error("Exception occurred while retrieving all document for {}", collectionName);
        }
        return Optional.empty();
    }
    
    public List<T> filterDocumentsForValueInList(String field, List<String> list){
        ApiFuture<QuerySnapshot> querySnapshotApiFuture = collectionReference.whereIn(field, list).get();

        try {
            List<QueryDocumentSnapshot> queryDocumentSnapshots = querySnapshotApiFuture.get().getDocuments();
            for (DocumentSnapshot document : queryDocumentSnapshots) {
                System.out.println(document.getId() + " => " + document.toObject(Lead.class));
            }

        } catch (InterruptedException | ExecutionException e) {
            log.error("Exception occurred while retrieving all document for {}", collectionName);
        }
        return Collections.<T>emptyList();

    }

    public Optional<T> get(String documentId){
        DocumentReference documentReference = collectionReference.document(documentId);
        ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = documentReference.get();

        try {
            DocumentSnapshot documentSnapshot = documentSnapshotApiFuture.get();

            if(documentSnapshot.exists()){
                return Optional.ofNullable(documentSnapshot.toObject(parameterizedType));
            }

        } catch (InterruptedException | ExecutionException e) {
            log.error("Exception occurred retrieving: {} {}, {}", collectionName, documentId, e.getMessage());
        }

        return Optional.empty();

    }

    protected String getDocumentId(T t) {
        Object key;
        Class clzz = t.getClass();
        do{
            key = getKeyFromFields(clzz, t);
            clzz = clzz.getSuperclass();
        } while(key == null && clzz != null);

        if(key==null){
            return UUID.randomUUID().toString();
        }
        return String.valueOf(key);
    }

    private Object getKeyFromFields(Class<?> clazz, Object t) {

        return Arrays.stream(clazz.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(DocumentId.class))
                .findFirst()
                .map(field -> getValue(t, field))
                .orElse(null);
    }

    @Nullable
    private Object getValue(Object t, java.lang.reflect.Field field) {
        field.setAccessible(true);
        try {
            return field.get(t);
        } catch (IllegalAccessException e) {
            log.error("Error in getting documentId key", e);
        }
        return null;
    }

    protected CollectionReference getCollectionReference(){
        return this.collectionReference;
    }
    protected Class<T> getType(){ return this.parameterizedType; }


}
