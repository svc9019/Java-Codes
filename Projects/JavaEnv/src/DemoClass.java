import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class DemoClass {

    public static void main(String[] args) {

        String dBName = "upgrad";
        String collectionName = "students";
        MongoClient mongoClient = null;
        String connectionString = "mongodb://ec2-34-230-12-57.compute-1.amazonaws.com";


        mongoClient = MongoClients.create(connectionString);
        MongoDatabase db = mongoClient.getDatabase(dBName);
        MongoCollection<Document> collection = db.getCollection(collectionName);

        Document doc = new Document("_id", 141)
                .append("name", "Rahul")
                .append("courseId", 114)
                .append("age", 28);
        collection.insertOne(doc);
    }
}
