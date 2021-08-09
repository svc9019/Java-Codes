package practise;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import org.bson.Document;

import java.util.Arrays;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Sorts.ascending;

public class JavaMongoPractise_V2 {

    public static void main(String[] args) {


        MongoClient mongoClient = MongoClients.create("mongodb://ec2-54-174-255-189.compute-1.amazonaws.com");
        MongoDatabase db = mongoClient.getDatabase("upgrad");
        MongoCollection<Document> col = db.getCollection("orders");


        System.out.println(" <-------- Find documents with Sales value greater than 200 ------------------>");

        for (Document document : col.find(gt("Sales", 200))) {
            System.out.println(document.toJson());
        }


        System.out.println("<------Find documents with Sales value greater than 200 and Profit value less than 800-------------------->");

        for (Document document : col.find(and(gt("Sales", 200), lt("Profit", 800)))) {
            System.out.println(document.toJson());
        }


        System.out.println(" <-------- Find documents with Profit value less than 800 ------------------>");

        for (Document document : col.find(lt("Profit", 800))) {
            System.out.println(document.toJson());
        }


        System.out.println(" <--------Find all the documents present in the 'orders' collection------------------>");
        for (Document document : col.find()) {
            System.out.println(document.toJson());
        }



        System.out.println(" <------Find documents present in the 'orders' collection whose pages is greater than 500------------------>");

        for (Document document : col.find(gt("pages", 500))) {
            System.out.println(document.toJson());
        }

        System.out.println("<------Find the documents that have a 'Sales' value greater than 500 and then sort the documents received in ascending order. --------->");

        for (Document document : col.find(gt("Sales", 500)).sort(ascending("Sales"))) {
            System.out.println(document.toJson());
        }


        System.out.println("<---------Find the first five documents of orders collection-----------------> ");

        for (Document document : col.find().limit(5)) {
            System.out.println(document.toJson());
        }


        System.out.println("<------ Average profit  across all the orders --------->");

        for(Document document : col.aggregate(Arrays.asList(
                Aggregates.group(null,
                        Accumulators.avg("averageProfitAcrossAllOrders", "$Profit"))
        ))){
            System.out.println(document.toJson());
        }






    }
}
