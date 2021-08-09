package practise;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;


import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

public class JavaMongoPractice {

    public static void main(String[] args){

        MongoClient mongoClient = MongoClients.create("mongodb://ec2-54-174-255-189.compute-1.amazonaws.com");
        MongoDatabase db = mongoClient.getDatabase("upgrad");
        MongoCollection<Document> col = db.getCollection("orders");

        /**
         * Write the code to ingest the data into mongodb
         */



        Books books = new Books(2, "Sydney Sheldon",900, 900,"Thriller");
        System.out.println(col.insertOne(books.createDBObject()));

/*


        /**
         * Write the code to update the data in mongodb


        Bson filter = eq("price", "500");
        Bson updateOperation = set("price", 600);
        System.out.println(col.updateOne(filter, updateOperation));
        System.out.println((col.find(filter)).first().toJson());


 */

}
}
