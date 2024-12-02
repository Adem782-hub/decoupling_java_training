package fr.lernejo.guessgame;
public class ComputerPlayer implements Player {
    private long min = 0, max = 100, lastGuess;

    @Override
    public long askNextGuess() {
        lastGuess = (min + max) / 2;
        return lastGuess;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater) {
            max = lastGuess - 1;
        } else {
            min = lastGuess + 1;
        }
    }
}

