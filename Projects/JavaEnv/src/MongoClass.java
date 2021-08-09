import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import org.bson.Document;

import javax.print.Doc;

import java.util.ArrayList;
import java.util.Arrays;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Sorts.ascending;
import static com.mongodb.client.model.Sorts.descending;

public class MongoClass {

    public static void main(String[] args) {

        MongoClient mongoClient = MongoClients.create("mongodb://ec2-3-87-19-128.compute-1.amazonaws.com");
        System.out.println(mongoClient);
        // Reading list of DB's
//        mongoClient.listDatabases().forEach(db-> System.out.println(db.toJson()));
        // Connecting to Database
        MongoDatabase db = mongoClient.getDatabase("products");
        // Connecting to Collection
        MongoCollection<Document> purchaseCollection = db.getCollection("purchase");
        // Printing Output
//        System.out.println(purchaseCollection);

        // Reading all the Data
//        for(Document document : purchaseCollection.find()){
//            System.out.println(document.toJson());
//        }
        // Read only three Data
//        for(Document document : purchaseCollection.find().limit(3)){
//            System.out.println(document.toJson());
//        }

        // Read Particular Data
//        Document document = purchaseCollection.find(eq("Order ID","IN-2014-76016")).first();
//        System.out.println(document.toJson());

        // Find Sales Value greater than 3000 and Profit Less than 2000
//        for(Document document : purchaseCollection.find(and(gte("Sales",3000),lte("Profit",2000)))){
//            System.out.println(document);
//        }

//        // Count Documents Profit Less than 200
//        long document = purchaseCollection.countDocuments(lt("Profit",200));
//        System.out.println(document);

//        // Get all the Documents where segment is either consumer / corporate
//        for(Document document : purchaseCollection.find(or(eq("Segment","Consumer"),eq("Segment","Corporate")))){
//            System.out.println(document.toJson());
//        }

//        // Sorting or Elements
//        for(Document document : purchaseCollection.find(gte("Sales",2000)).sort(ascending("Sales"))){
//            System.out.println(document.toJson());
//        }
//        // Sorting or Elements -- descending
//        for(Document document : purchaseCollection.find(gte("Sales",2000)).sort(descending("Sales"))){
//            System.out.println(document.toJson());
//        }
        //Aggregation Queries
        // Total Sales Based on Segments
//        for(Document document : purchaseCollection.aggregate(
//                Arrays.asList(Aggregates.group("$Segment",
//                        Accumulators.sum("Total Sales","$Sales"))))) {
//            System.out.println(document.toJson());
//        }
//        // Total Sales across all the Orders
//        for(Document document : purchaseCollection.aggregate(Arrays.asList(
//                Aggregates.group("null",Accumulators.sum("Total Sales","$Sales"))))){
//            System.out.println(document.toJson());
//        }
//        // Average Sales Across all the Orders
//        for(Document document : purchaseCollection.aggregate(Arrays.asList
//                (Aggregates.group(null,
//                        Accumulators.avg("Average Sales","$Sales"))))){
//            System.out.println(document.toJson());
//        }
    }
}
