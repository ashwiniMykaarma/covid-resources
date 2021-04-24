package covidresources.covidresourcesserver;

import covidresources.DBService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Main {


    public static void main(String args[]) throws ExecutionException, InterruptedException, IOException {
        DBService dbService  =  new DBService();
        dbService.getPatientDetails();
    }
}
