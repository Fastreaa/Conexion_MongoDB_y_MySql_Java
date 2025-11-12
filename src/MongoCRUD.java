
import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;


public class MongoCRUD
{
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    
    // Constructor initializes the connection to the MongoDB database and selects the collection.
    public MongoCRUD()
    {
	this.mongoClient = MongoClients.create(
					       "mongodb+srv://linkpark182_db_user:avrUGEi06rs5GH58@cluster0.kjdptww.mongodb.net/?appName=Cluster0"
					       );
        this.database = mongoClient.getDatabase("customerDB");
        this.collection = database.getCollection("customers");
    }

    // Inserts a new customer document into the MongoDB collection.
    public void insertCustomer(Customer customer)
    {
        Document newCustomer = new Document("id", customer.getId())
	    .append("first_name", customer.getFirstName())
	    .append("last_name", customer.getLastName())
	    .append("age", customer.getAge())
	    .append("email", customer.getEmail());
        collection.insertOne(newCustomer);
        System.out.println("MongoDB: Inserted " + customer.getFirstName());
    }

    // Retrieves and prints all customers from the MongoDB collection.
    public void readCustomers()
    {
        System.out.println("\nCurrent Customers in MongoDB:");
        for (Document customer : collection.find())
	    {
		System.out.println(customer.toJson());
	    }
    }

    // Updates the first name of a customer in the MongoDB collection.
    public void updateCustomer(String oldFirstName, String newFirstName)
    {
        Document updatedCustomer = new Document("$set", new Document("first_name", newFirstName));
        collection.updateOne(new Document("first_name", oldFirstName), updatedCustomer);
        System.out.println("MongoDB: Updated " + oldFirstName + " to " + newFirstName);
    }

    // Deletes a customer document from the MongoDB collection based on the first name.
    public void deleteCustomer(String firstName)
    {
        collection.deleteOne(new Document("first_name", firstName));
        System.out.println("MongoDB: Deleted customer " + firstName);
    }

    // Optional: close client when you finish (si no es singleton)
    public void close()
    {
        if (mongoClient != null) mongoClient.close();
    }
}
