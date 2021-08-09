import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entities.Student;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.bitsAnySet;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

public class MongoApp {

    public static void main(String[] args) {
        //Create Mongo Client
        MongoClient mongoClient = MongoClients.create("mongodb://ec2-18-234-138-194.compute-1.amazonaws.com");
        System.out.println(mongoClient);
        //Create Database
        MongoDatabase db = mongoClient.getDatabase("Upgrad_demo");
        //Create Collection
        MongoCollection<Document> studentCollection = db.getCollection("students");
        System.out.println("Collection " + studentCollection);
//        // Insert Single Record
//        Student student = new Student(1,"Arjuna",356,28);
//        System.out.println(studentCollection.insertOne(student.createDBObject()));
//        // Multiple Record
//        Student student1 = new Student(1,"Cobra",356,28);
//        Student student2 = new Student(2,"Vampire",356,32);
//        Student student3 = new Student(3,"Dracula",359,28);
//        Student student4 = new Student(4,"Trolls",359,32);
//        Student student5 = new Student(5,"Vrolls",361,28);
//
//        // Add Students
//        List<Document> studentList = new ArrayList<>();
//        studentList.add(student1.createDBObject());
//        studentList.add(student2.createDBObject());
//        studentList.add(student3.createDBObject());
//        studentList.add(student4.createDBObject());
//        studentList.add(student5.createDBObject());
//        // Print Output
//        System.out.println(studentCollection.insertMany(studentList));
        // Finding the Record
//        for(Document document : studentCollection.find()){
//            System.out.println(document.toJson());
//           }
//        // Finding the One Record
//        Bson filter = eq("name","Arjuna");
//        System.out.println(studentCollection.find(filter).first().toJson());
//        //Updating the Record
//        Bson updateOperation = set("age",89);
//        System.out.println(studentCollection.updateOne(filter,updateOperation));
//        System.out.println(studentCollection.find(filter).first().toJson());
        // Deleting One Record
//        System.out.println(studentCollection.deleteOne(eq("name","Arjuna")));
        // Dropping the Collection
        studentCollection.drop();
    }
}