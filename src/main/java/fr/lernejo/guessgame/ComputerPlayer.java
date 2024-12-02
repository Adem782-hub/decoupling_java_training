package fr.lernejo.guessgame;
public class ComputerPlayer implements Player {
    private long min = 0, max = 100, lastGuess;

    @Override
    public long askNextGuess() {
        lastGuess = (min + max) / 2;
        logger.log("L'ordinateur devine : " + lastGuess);
        return lastGuess;
    }
    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater) {
            logger.log("L'ordinateur a ajusté la plage : " + min + " à " + (lastGuess - 1));
            max = lastGuess - 1;
        } else {
            logger.log("L'ordinateur a ajusté la plage : " + (lastGuess + 1) + " à " + max);
            min = lastGuess + 1;
        }
    }
}

