// File: MongoDBWriter.java
import com.mongodb.client.*;
import org.bson.Document;
import java.util.*;

public class MongoDBWriter {

    public static void saveFindings(List<Finding> findings) {
        String uri = "mongodb://localhost:27017";

        try (MongoClient client = MongoClients.create(uri)) {
            MongoDatabase db = client.getDatabase("LinterDB");
            MongoCollection<Document> collection = db.getCollection("findings");

            List<Document> docs = new ArrayList<>();

            for (Finding f : findings) {
                docs.add(new Document("ruleId", f.ruleId)
                        .append("message", f.message)
                        .append("filePath", f.filePath)
                        .append("line", f.line)
                        .append("severity", f.severity)
                        .append("timestamp", new Date()));
            }

            if (!docs.isEmpty()) {
                collection.insertMany(docs);
                System.out.println("✅ Stored " + docs.size() + " findings in MongoDB.");
            } else {
                System.out.println("✅ No lint issues found.");
            }

        }
    }
}
