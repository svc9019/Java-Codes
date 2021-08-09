package dragon;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class PojoApp {

    public static void main(String[] args) {
        String dbName = "upgrad";
        String connectionString = "mongo://ec2-54-81-159-93.compute-1.amazonaws.com";
        String collectionName = "students";
        MongoClient mongoClient = null;

        try {
            //Creating the Code Registry
            CodecRegistry pojoCodecRegistry = fromRegistries(
                    MongoClientSettings.getDefaultCodecRegistry(),
                    fromProviders(PojoCodecProvider.builder().automatic(true).build()));

            MongoClientSettings clientSettings = MongoClientSettings
                    .builder()
                    .applyConnectionString(new ConnectionString(connectionString))
                    .codecRegistry(pojoCodecRegistry)
                    .build();

            // Initialize the collection

            mongoClient = MongoClients.create(clientSettings);
            MongoDatabase db = mongoClient.getDatabase(dbName);
            MongoCollection<Student> collection = db.getCollection(collectionName,Student.class);

            //insert POJO and Previous Syntax

            collection.insertOne(new Student(131,"Warewolf",114,25));

            // Read Syntax
//            MongoCursor<Student> cursor = collection.find().cursor();
//            while (cursor.hasNext()){
//                System.out.println(cursor.next());
//            }
//
//            // Add Variation or Update
//
//            Student student = collection.find(eq("name","Vampire")).first();
//            student.setName("Dracula");



        } catch (Exception ex) {
            System.out.println("Got Exception");
        }
    }
}
