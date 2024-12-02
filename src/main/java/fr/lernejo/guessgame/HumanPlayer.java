package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Logger logger;
    private final Scanner scanner;

    public HumanPlayer() {
        this.logger = LoggerFactory.getLogger("player");
        this.scanner = new Scanner(System.in);
    }

    @Override
    public long askNextGuess() {
        logger.log("Veuillez entrer votre estimation (nombre) : ");
        long guess = scanner.nextLong(); // ou autre méthode pour récupérer l'estimation
        logger.log("Estimation soumise : " + guess);
        return guess;
    }
    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater) {
            logger.log("Le nombre à deviner est plus grand.");
        } else {
            logger.log("Le nombre à deviner est plus petit.");
        }
    }
}

