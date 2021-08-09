import com.mongodb.client.*;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import org.bson.Document;

import javax.print.Doc;
import java.util.Arrays;

public class DocumentDemo {
    public static void main(String[] args) {
        // Create Mongo Client
        MongoClient mongoClient = MongoClients.create("mongodb://ec2-18-234-138-194.compute-1.amazonaws.com");
        // DB and Collection
        String dbName = "Upgrad_doc_demo";
        String collectionName = "students";

        MongoDatabase db = mongoClient.getDatabase(dbName);
        MongoCollection<Document> collection = db.getCollection(collectionName);

        // Inserting the Record

//        Document doc = new Document("_id",123).append("name","Janaki")
//                .append("courseId",312).append("age",38);
//
//        System.out.println(collection.insertOne(doc));

        // Reading the Doc Back
        MongoCursor<Document> cursor = collection.find().cursor();

        while(cursor.hasNext()){
            System.out.println(cursor.next());
        }

        // Fetching Average Age
        cursor = collection.aggregate(
                Arrays.asList(Aggregates.group("$courseId",
                        Accumulators.avg("averageAge","$age")))).
                cursor();
        while(cursor.hasNext()){
            System.out.println(cursor.next().toJson());
        }
    }
}
