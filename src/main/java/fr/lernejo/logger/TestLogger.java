package fr.lernejo.logger;

public class TestLogger {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("testLogger");
        logger.log("Ceci est un message de log.");
    }
}

