// File: ImportRuleChecker.java
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ImportRuleChecker {

    public static List<Finding> checkUnusedImports(CompilationUnit cu, Path file) {
        List<Finding> findings = new ArrayList<>();
        String code = cu.toString();

        for (ImportDeclaration imp : cu.findAll(ImportDeclaration.class)) {
            String importName = imp.getNameAsString();
            String simpleName = importName.substring(importName.lastIndexOf('.') + 1);

            if (!code.replace(imp.toString(), "").contains(simpleName)) {
                findings.add(new Finding(
                        "unused-import",
                        "Unused import: " + importName,
                        file.toString(),
                        imp.getRange().map(r -> r.begin.line).orElse(0),
                        "INFO"
                ));
            }
        }
        return findings;
    }
}
