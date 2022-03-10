package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
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
    /** Draws a hexagon with certain side. */
    private static void addHexagon(int side, int offX, int offY, TETile[][] world) {
        // the side of the hexagon
        int height = side * 2; // the height of the hexagon
        int longestSide = 3 * side - 2;
        int width = side; // the bottom width
        TETile pattern = randomTile();
        for (int y = offY ; y < height + offY; y += 1) {
            if (y - offY < height / 2) {
                if (y == offY) {
                    width -= 2; // keep the width when it comes to the bottom of th hexagon
                }
                width += 2;
            }
            else {
                if ( y - offY == height / 2) {
                    width += 2; // keep the width when it comes to the middle of th hexagon
                }
                width -= 2;
            }
            int x0 = (longestSide - width) / 2;
            for (int x = x0 + offX; x < x0 + width + offX; x += 1) {
                world[x][y] = pattern;
            }
        }
    }

    /** Picks a RANDOM tile with a 33% change of being
     *  a wall, 33% chance of being a flower, and 33%
     *  chance of being empty space.
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
        addHexagon(3, 10, 10, world);
        ter.renderFrame(world);
    }
}
