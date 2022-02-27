import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class TestOffByN {
    @Test
    public void testOffByN() {
        CharacterComparator cc = new OffByN(3);
        assertTrue(cc.equalChars('a', 'd'));
        assertTrue(cc.equalChars('d', 'a'));
        assertFalse(cc.equalChars('a', 'b'));
    }
}
