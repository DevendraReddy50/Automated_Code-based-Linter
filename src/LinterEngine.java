// File: LinterEngine.java
import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class LinterEngine {

    public static List<Finding> scanJavaFiles(Path path) throws IOException {
        List<Finding> results = new ArrayList<>();
        JavaParser parser = new JavaParser();

        Files.walk(path)
                .filter(p -> p.toString().endsWith(".java"))
                .forEach(file -> {
                    try {
                        ParseResult<CompilationUnit> result = parser.parse(file);

                        if (result.isSuccessful() && result.getResult().isPresent()) {
                            CompilationUnit cu = result.getResult().get();

                            results.addAll(
                                    ImportRuleChecker.checkUnusedImports(cu, file)
                            );
                        }

                    } catch (Exception e) {
                        System.err.println("Error parsing " + file + ": " + e.getMessage());
                    }
                });

        return results;
    }
}
