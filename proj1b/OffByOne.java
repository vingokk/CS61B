/** Implements Interface CharacterComparator. */
public class OffByOne implements CharacterComparator{
    /** Returns true for characters that are off by N, false otherwise. */
    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == 1;
    }
}
