// File: AutomatedLinter.java
import java.nio.file.*;
import java.util.List;

public class AutomatedLinter {

    public static void main(String[] args) throws Exception {
        Path scanPath = Paths.get(args.length > 0 ? args[0] : "./");

        System.out.println("🔍 Scanning folder: " + scanPath.toAbsolutePath());

        List<Finding> findings = LinterEngine.scanJavaFiles(scanPath);

        findings.forEach(System.out::println);

        MongoDBWriter.saveFindings(findings);

        System.out.println("✅ Linting completed successfully!");
    }
}
