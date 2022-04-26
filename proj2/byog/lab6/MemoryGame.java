package byog.lab6;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

public class MemoryGame {
    private int width;
    private int height;
    private int round;
    private Random rand;
    private boolean gameOver;
    private boolean playerTurn;
    private static final char[] CHARACTERS = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final String[] ENCOURAGEMENT = {"You can do this!", "I believe in you!",
                                                   "You got this!", "You're a star!", "Go Bears!",
                                                   "Too easy for you!", "Wow, so impressive!"};

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please enter a seed");
            return;
        }

        int seed = Integer.parseInt(args[0]);
        MemoryGame game = new MemoryGame(40, 40, seed);
        game.startGame();
    }

    public MemoryGame(int width, int height, int seed) {
        /* Sets up StdDraw so that it has a width by height grid of 16 by 16 squares as its canvas
         * Also sets up the scale so the top left is (0,0) and the bottom right is (width, height)
         */
        this.width = width;
        this.height = height;
        StdDraw.setCanvasSize(this.width * 16, this.height * 16);
        Font font = new Font("Monaco", Font.BOLD, 30);
        StdDraw.setFont(font);
        StdDraw.setXscale(0, this.width);
        StdDraw.setYscale(0, this.height);
        StdDraw.clear(Color.BLACK);
        StdDraw.enableDoubleBuffering();

        //TODO: Initialize random number generator
        rand = new Random(seed);
    }

    public String generateRandomString(int n) {
        // Generate random string of letters of length n
        StringBuilder str = new StringBuilder();
        while (str.length() < n) {
            int index = rand.nextInt(26);
            str.append(CHARACTERS[index]);
        }
        return str.toString();
    }

    public void drawFrame(String s) {
        // Take the string and display it in the center of the screen
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, this.width);
        StdDraw.setYscale(0, this.height);
        StdDraw.clear();
        Font font = new Font("Arial", Font.BOLD, 30);
        StdDraw.setFont(font);
        StdDraw.setPenColor(Color.RED);
        StdDraw.text(width / 2, height / 2, s);

        // If game is not over, display relevant game information at the top of the screen
        if (!isGameOver()) {
            String info1 = "Round: " + round;
            String info2 = "Watch!";
            String info3 = ENCOURAGEMENT[4];
            StdDraw.text(5, height - 5, info1);
            StdDraw.text(width / 2, height - 5, info2);
            StdDraw.text(width - 5, height - 5, info3);
        }

        StdDraw.show();

    }
    public boolean isGameOver() {
        return gameOver;
    }

    public void flashSequence(String letters) {
        // Display each character in letters, making sure to blank the screen between letters
        String[] substr = letters.split("");
        for (String s : substr) {
            drawFrame(s);
            StdDraw.pause(1000);
            drawFrame(" ");
            StdDraw.pause(500);
        }
    }

    public String solicitNCharsInput(int n) {
        StringBuilder str = new StringBuilder();
        while(str.length() < n) {
            if(!StdDraw.hasNextKeyTyped()) {
                continue;
            }
            char c = StdDraw.nextKeyTyped();
            str.append(c);
            drawFrame(str.toString());
        }
        return str.toString();
    }
    public void startGame() {
        // Set any relevant variables before the game starts
        round = 1;
        gameOver = false;
        int strLength = 4;
        // Establish Game loop
        while (round < 5) {
            StdDraw.pause(500);
            String expected = generateRandomString(strLength);
            flashSequence(expected);
            String actual = solicitNCharsInput(strLength);
            StdDraw.pause(500);
            if (expected.equals(actual)) {
                round += 1;
            } else {
                gameOver = true;
                drawFrame("Game Over! You made it to round: " + round);
                StdDraw.pause(1000);
                break;
            }
        }

        if (round == 5) {
            drawFrame("WIN!");
            StdDraw.pause(1000);
        }
    }
}
