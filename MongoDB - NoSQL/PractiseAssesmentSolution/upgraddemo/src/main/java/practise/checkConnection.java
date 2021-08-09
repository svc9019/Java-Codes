package practise;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;


public class checkConnection {


    public static void main(String[] args){
        MongoClient mongoClient = MongoClients.create("mongodb://ec2-54-174-255-189.compute-1.amazonaws.com");
        MongoDatabase sampleTrainingDB = mongoClient.getDatabase("upgrad");
        System.out.println(sampleTrainingDB);
    }
}



