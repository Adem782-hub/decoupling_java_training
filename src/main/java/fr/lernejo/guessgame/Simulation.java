package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {
    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    private boolean nextRound() {
        long guess = player.askNextGuess();
        if (guess == numberToGuess) {
            logger.log("Correct guess!");
            return true;
        }
        player.respond(guess > numberToGuess);  // Le joueur répond si le nombre est plus grand ou plus petit
        return false;
    }

    public void loopUntilPlayerSucceed(long maxIterations) {
        long startTime = System.currentTimeMillis();
        boolean success = false;

        for (long i = 0; i < maxIterations; i++) {
            if (nextRound()) {
                success = true;
                break;
            }
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        // Format du temps écoulé en mm:ss.SSS
        long minutes = (duration / 1000) / 60;
        long seconds = (duration / 1000) % 60;
        long milliseconds = duration % 1000;

        // Affichage du temps écoulé et du succès
        logger.log(String.format("Game duration: %02d:%02d.%03d", minutes, seconds, milliseconds));
        logger.log(success ? "The player succeeded!" : "The player failed to guess the number.");
    }
}

