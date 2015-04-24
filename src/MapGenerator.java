
 // @author laptopng34
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;

public class MapGenerator {

    private final int width;
    private final int height;
    private final int scale = 50;

    private Map<Coordinate, TileType> map;

    public MapGenerator(int width, int height) {
        this.width = width;
        this.height = height;
        map = new HashMap<>();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (x > 5) {
                    map.put(new Coordinate(x, y), TileType.FLOOR);
                } else {
                    map.put(new Coordinate(x, y), TileType.WALL);
                }
            }
        }
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
    }

    public void paint(Graphics2D g2d) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                TileType t = map.get(new Coordinate(i, j));
                switch (t) {
                    case FLOOR:
                        g2d.setColor(t.c);
                        break;
                    case GRASS:
                        g2d.setColor(t.c);
                        break;
                    case WALL:
                        g2d.setColor(t.c);
                        break;
                    default:
                        g2d.setColor(Color.WHITE);
                        break;
                }
                g2d.fillRect(i, j, 1*scale, 1*scale);
            }
        }
    }

    public Map getMap() {
        return map;
    }

}
