package byog.lab6;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void generateString () {
        int seed = 23752;
        MemoryGame game = new MemoryGame(40, 40, seed);
//        String str = game.generateRandomString(5);
//        System.out.println(str);
//        game.flashSequence("abdcf");
        game.startGame();
    }
}
