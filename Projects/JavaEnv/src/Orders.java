import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import org.bson.Document;
import org.bson.conversions.Bson;
import static com.mongodb.client.model.Sorts.ascending;
import static com.mongodb.client.model.Sorts.descending;

import javax.print.Doc;
import java.util.Arrays;
import java.util.Collection;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.set;

public class Orders {
    public static void main(String[] args) {
        // Client Connection - Mongo
        MongoClient mongoClient = MongoClients.create("mongodb://ec2-3-87-19-128.compute-1.amazonaws.com");
        System.out.println(mongoClient);

        String dbName = "upgrad";
        String collectionName = "orders";

        // Connectivity to DB
        MongoDatabase db = mongoClient.getDatabase(dbName);
        MongoCollection<Document> orderCollection = db.getCollection(collectionName);

        // Insert to Collection Orders
//        Document document = new Document("Book ID","IN-2020-0006").append("Author","Arvind Adiga")
//                .append("Pages","802").append("Price",500).append("Genre","Thriller");
//        System.out.println(orderCollection.insertOne(document));

        // Read one value
//        Document document = orderCollection.find(eq("Book ID","IN-2020-0006")).first();
//        System.out.println(document.toJson());

//        // Update Value
//        Bson Filter = eq("Book ID","IN-2020-0006");
//        System.out.println(orderCollection.find(Filter).first().toJson());
//        Bson updateOperation = set("Price",600);
//        System.out.println(orderCollection.updateOne(Filter,updateOperation));
//        System.out.println(orderCollection.find(Filter).first().toJson());

//        // Find all the Sales greater than 200
//        for(Document document : orderCollection.find(gt("Sales",200))){
//            System.out.println(document.toJson());
//        }

//        //Find all the documents in the orders collection Sales > 200 and Profit < 800
//        for(Document document : orderCollection.find(and(gt("Sales",200)
//                ,lt("Profit",800)))){
//            System.out.println(document.toJson());
//        }
//        //orders collection, what is the total count of documents where Profit<800
//        long document = orderCollection.countDocuments(lt("Profit",800));
//            System.out.println(document);

//        // Read all the Documents
//        for(Document document : orderCollection.find()){
//            System.out.println(document.toJson());
//        }

//        // Print Doc with Page > 500
//        for(Document document : orderCollection.find(gte("Pages","500"))){
//            System.out.println(document.toJson());
//        }
//        // Sales > 500
//        for(Document document : orderCollection.find(gt("Sales",500))
//                .sort(ascending("Sales"))){
//            System.out.println(document.toJson());
//        }
//        // find first five docs in Collection
//        for(Document document : orderCollection.find().limit(5)){
//            System.out.println(document.toJson());
//        }
//        // find the Average Profit made across orders
//        for(Document document : orderCollection.aggregate(Arrays
//                .asList(Aggregates.group(null,Accumulators
//                        .avg("AvgProfit","$Profit"))))){
//            System.out.println(document.toJson());
//        }
    }
}