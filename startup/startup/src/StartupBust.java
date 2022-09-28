import java.util.ArrayList;

public class StartupBust {
    private  GameHelper helper = new GameHelper();
    private  ArrayList<Startup> startups = new ArrayList<Startup>();
    private int numOfGuesses = 0;

    private void setUpGame() {
        Startup one = new Startup();
        one.setName("USS Voyager");
        Startup two = new Startup();
        two.setName("USS Raven");
        Startup three = new Startup();
        three.setName("USS Defiant");
        startups.add(one);
        startups.add(two);
        startups.add(three);

        System.out.println("Your goal is to destroy three Star Ships.");
        System.out.println("Voyager, Raven, Defiant");
        System.out.println("Try to destroy them all in the fewest number of guesses.");

        for (Startup startup : startups) {
            ArrayList<String> newLocation = helper.placeStartup(3);
            startup.setLocationCells(newLocation);
        }
    }

    private void startPlaying() {
        while (!startups.isEmpty()) {
            String userGuess = helper.getUserInput("Enter guess: ");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess){
        numOfGuesses++;
        String result = "miss";

        for (Startup startupToTest : startups) {
            result = startupToTest.checkYourself(userGuess);

            if (result.equals("hit")) {
                break;
            }
            if (result.equals("kill")) {
                startups.remove(startupToTest);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame() {
        System.out.println("All Starships are dead!");
        if (numOfGuesses <= 18) {
            System.out.println("It only took you " + numOfGuesses + " guesses.");
            System.out.println("I guess Resistance is futile.");
        } else {
            System.out.println("WOW It only took you " + numOfGuesses + " guesses.");
            System.out.println("You got out before the ship blew up.");
        }
    }
    public static void main(String[] args) {
        StartupBust game = new StartupBust();
        game.setUpGame();
        game.startPlaying();
    }
}




















