package upgrad;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.Arrays;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.excludeId;
import static com.mongodb.client.model.Projections.fields;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class DocumentApp {

    public static void main(String[] args){
        String dBName = "upgrad";
        String connectionString = "mongodb://127.0.0.1:27017";
        String collectionName = "students";
        MongoClient mongoClient = null;

        try {
            // Initializing the collection
            mongoClient = MongoClients.create(connectionString);
            MongoDatabase db = mongoClient.getDatabase(dBName);
            MongoCollection<Document> collection = db.getCollection(collectionName);

            // insert Document
            Document doc = new Document("_id", 141)
                                .append("name", "Rahul")
                                .append("courseId", 114)
                                .append("age", 28);
            collection.insertOne(doc);

            // Read Documents
            MongoCursor<Document> cursor = collection.find().cursor();
            while(cursor.hasNext()){
                System.out.println(cursor.next());
            }

            System.out.println("\n\n Printing all students in course 114");
            cursor = collection
                        .find(new Document("courseId", 114))
                        .projection(fields(excludeId()))
                        .cursor();
            while(cursor.hasNext()){
                System.out.println(cursor.next().toJson());
            }

            System.out.println("\n\n Printing average age of students in each course");
            cursor = collection.aggregate(
                    Arrays.asList(
                            Aggregates.group("$courseId",
                                    Accumulators.avg("averageAge", "$age"))
                    )).cursor();
            while(cursor.hasNext()){
                System.out.println(cursor.next().toJson());
            }
        }
        catch(Exception ex) {
            System.out.println("Got Exception.");
            ex.printStackTrace();
        }
        finally {
            if (null != mongoClient) {
                mongoClient.close();
            }
        }
    }
}
