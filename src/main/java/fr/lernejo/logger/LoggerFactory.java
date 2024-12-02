package fr.lernejo.logger;

public class LoggerFactory {
    public static Logger getLogger(String callerClass) {
        return new ContextualLogger(callerClass, new FileLogger("target/captain.log"));
    }
}

