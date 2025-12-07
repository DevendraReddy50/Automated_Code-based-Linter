// File: Finding.java
public class Finding {
    public String ruleId, message, filePath, severity;
    public int line;

    public Finding(String ruleId, String message, String filePath, int line, String severity) {
        this.ruleId = ruleId;
        this.message = message;
        this.filePath = filePath;
        this.line = line;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return "[" + severity + "] (" + ruleId + ") " + message + " at line " + line;
    }
}
