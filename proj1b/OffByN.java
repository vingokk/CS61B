/** Implements Interface CharacterComparator. */
public class OffByN implements CharacterComparator {
    private int diff;
    public OffByN(int N) {
        diff = N;
    }

    /** Returns true for characters that are off by N, false otherwise. */
    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == diff;
    }
}
