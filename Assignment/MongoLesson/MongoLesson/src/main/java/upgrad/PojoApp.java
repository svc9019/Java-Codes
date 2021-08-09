package upgrad;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
public class PojoApp {

    public static void main(String[] args){
        String dBName = "upgrad";
        String connectionString = "mongodb://127.0.0.1:27017";
        String collectionName = "students";
        MongoClient mongoClient = null;

        try {
            // Creating the Codec Registry
            CodecRegistry pojoCodecRegistry = fromRegistries(
                    MongoClientSettings.getDefaultCodecRegistry(),
                    fromProviders(PojoCodecProvider.builder().automatic(true).build()));

            MongoClientSettings clientSettings = MongoClientSettings
                                                .builder()
                                                .applyConnectionString(new ConnectionString(connectionString))
                                                .codecRegistry(pojoCodecRegistry)
                                                .build();

            // Initializing the collection
            mongoClient = MongoClients.create(clientSettings);
            MongoDatabase db = mongoClient.getDatabase(dBName);
            MongoCollection<Student> collection = db.getCollection(collectionName, Student.class);

            // insert POJO
            /* Previous Syntax:
                 collection.insertOne(new Student(131, "Deepak", 114, 25));
             */
            collection.insertOne(new Student(133, "Abhinav", 114, 25));

            // Read
            /* Previous Syntax:
                DBCursor cursor = col.find();
                while(cursor.hasNext()){
                    System.out.println(cursor.next());
                }
             */
            MongoCursor<Student> cursor = collection.find().cursor();
            while(cursor.hasNext()){
                System.out.println(cursor.next());
            }

            // Another variation for find
            Student student = collection.find(eq("name", "Abhinav")).first();
            student.setName("Jyoti");

            // Update
            /* Previous Syntax:
                DBObject query = BasicDBObjectBuilder.start().add("_id", student.getId()).get();
                collection.update(query, student.createDBObject());
             */
            Document query = new Document("_id", student.getId());
            collection.findOneAndReplace(query, student);

            // delete this student's record
            /*
                Previous Syntax:
                collection.remove(query);
             */
            collection.deleteOne(query);

        }
        catch(Exception ex) {
            System.out.println("Got other Exception.");
            ex.printStackTrace();
        }
        finally {
            if (null != mongoClient) {
                mongoClient.close();
            }
        }
    }
}
