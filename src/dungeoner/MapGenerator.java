package dungeoner;

 // @author laptopng34
import java.awt.Color;
import java.util.HashMap;

public class MapGenerator {

    private int width;
    private int height;

    private Map.     <Coordinate, TileType> map;

    public MapGenerator(int width, int height) {
        this.width=width;
        this.height=height;
        map = new Map<Coordinate, TileType>();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (x < 1) {
                    map.put(new Coordinate(x, y), TileType.FLOOR);
                } else {
                    map.put(new Coordinate(x, y), TileType.WALL);
                }
            }
        }
    }
    
    public HashMap getMap(){
        return map;
    }

    public enum TileType {

        FLOOR(Color.GRAY, true, 2),
        WALL(Color.BLACK, false, 0),
        GRASS(Color.GREEN, true, 1);

        private final Color c;
        private final boolean passable;
        private final int speed;

        TileType(Color c, boolean passable, int speed) {
            this.c = c;
            this.passable = passable;
            this.speed = speed;
        }

        private Color c() {
            return c;
        }

        private boolean passable() {
            return passable;
        }

        private int speed() {
            return speed;
        }

    }

}
