package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage:");
            System.out.println("  -interactive : Start the game with a human player");
            System.out.println("  -auto number : Start the game with a computer player guessing number");
            return;
        }

        if ("-interactive".equals(args[0])) {
            Player humanPlayer = new HumanPlayer();
            Simulation simulation = new Simulation(humanPlayer);
            SecureRandom random = new SecureRandom();
            long randomNumber = random.nextInt(100);
            simulation.initialize(randomNumber);
            simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);
        } else if ("-auto".equals(args[0]) && args.length > 1) {
            try {
                long numberToGuess = Long.parseLong(args[1]);
                Player computerPlayer = new ComputerPlayer();
                Simulation simulation = new Simulation(computerPlayer);
                simulation.initialize(numberToGuess);
                simulation.loopUntilPlayerSucceed(1000);
            } catch (NumberFormatException e) {
                System.out.println("The second argument must be a valid number");
            }
        } else {
            System.out.println("Invalid arguments");
            System.out.println("Usage:");
            System.out.println("  interactive : Start the game with a human player");
            System.out.println("  auto number: Start the game with a computer player guessing <number>");
        }
    }
}

