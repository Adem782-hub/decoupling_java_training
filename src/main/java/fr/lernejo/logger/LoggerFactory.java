package fr.lernejo.logger;

import java.util.function.Predicate;

public class LoggerFactory {
    public static Logger getLogger(String callerClass) {
        Logger consoleLogger = new ContextualLogger(callerClass, new ConsoleLogger());
        
        Predicate<String> playerCondition = message -> !message.contains("player");
        Logger fileLogger = new FilteredLogger(new ContextualLogger(callerClass, new FileLogger("target/captain.log")), playerCondition);

        return new CompositeLogger(consoleLogger, fileLogger);
    }
}

