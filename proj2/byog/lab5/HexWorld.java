package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 * @author vingo
 */
public class HexWorld {

    /** Draws a black background. */
    private static void drawBackground(TETile[][] world) {
        int width = world.length;
        int height = world[0].length;
        for (int x = 0; x < width; x += 1) {
            for (int y = 0; y < height; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }
    }

    /** Draws a tesselation of hexagons with side 3. */
    private static void addTeHexagon(TETile[][] world) {
        int side = 3;
        int xOff;
        int yOff;

        for (int x = 0; x < 5; x += 1) {
            xOff = 5 * x; // the start position of the whole colum of hexagons
            if (x < 3) { // left side
                int num = x + 3;
                for (int y = 0; y < num; y += 1) {
                    yOff = (2 - x) * side + 2 * side * y ;
                    addHexagon(side, xOff, yOff,  world);
                }
            } else { // right side
                int num = 7 - x;
                for (int y = 0; y < num; y += 1) {
                    yOff = (x - 2) * side + 2 * side * y;
                    addHexagon(side, xOff, yOff,  world);
                }
            }
        }
    }

    /** Draws a hexagon with certain side.
     * @param size the side of the hexagon
     * */
    private static void addHexagon(int side, int xOff, int yOff, TETile[][] world) {
        int height = side * 2; // the height of the hexagon
        int longestSide = 3 * side - 2;
        int width; // the width in the row of a hexagon
        TETile pattern = randomTile();
        for (int y = yOff ; y < height + yOff; y += 1) {
            width = getWidth(y - yOff, side);
            int x0 = (longestSide - width) / 2;
            for (int x = x0 + xOff; x < x0 + width + xOff; x += 1) {
                world[x][y] = pattern;
            }
        }
    }

    /** Calculates the width in the ith row of a hexagon.
     * @param i row num of the hexagon, where i = 0 is the bottom
     * @param s side of rhe hexagon
     * @return
     */
    private static int getWidth(int i, int s) {
        int width = s;
        if (i < s) {
            return width + i * 2;
        }
        else {
            return width + (2 * s - i - 1) * 2;
        }
    }

    /** Picks a RANDOM tile with a 33% chance of being
     *  a wall, 33% chance of being a flower, and 33%
     *  chance of being water.
     *  @source RandomWorldDemo.java by JoshHug
     */
    private static TETile randomTile() {
        Random RANDOM = new Random(); // use RANDOM for it is built for static final
        int tileNum = RANDOM.nextInt(3); // generate a integer sequence 0 1 2
        switch (tileNum) {
            case 0: return Tileset.WALL;
            case 1: return Tileset.FLOWER;
            case 2: return Tileset.WATER;
            default: return Tileset.NOTHING;
        }
    }
    public static void main(String[] args) {
        // initialize the tile render engine with a window of size 9 * 9
        int width = 50;
        int height = 50;
        TERenderer ter = new TERenderer();
        ter.initialize(width, height, 0, 0);

        // initialize the tile
        TETile[][] world = new TETile[width][height];
        drawBackground(world);
//        addHexagon(3, 0, 0, world);
//        ter.renderFrame(world);

        // draw a tesselation of hexagon
        addTeHexagon(world);
        ter.renderFrame(world);
    }
}
