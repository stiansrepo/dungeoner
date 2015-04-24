package dungeoner;

 // @author laptopng34
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Player {

    private int x = 0;
    private int y = 0;
    private int xs = 0;
    private int ys = 0;

    private int speed = 3;

    private final static int WIDTH = 30;
    private final static int HEIGHT = 10;

    private String name = "";

    private Game game;

    public Player(Game game, int x, int y, int xs, int ys, String name) {
        this.game = game;
        this.x = x;
        this.y = y;
        this.xs = xs;
        this.ys = ys;
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int s) {
        speed = s;
    }

    public void move() {
        if (x + xs > 0 && x + xs < (game.getWidth() - WIDTH)) {
            x = x + xs;
        }
        if (y + ys > 0 && y + ys < (game.getHeight() - HEIGHT)) {
            y = y + ys;
        }

    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                xs = -game.getSpeed() - getSpeed();
                break;
            case KeyEvent.VK_RIGHT:
                xs = game.getSpeed() + getSpeed();
                break;
            case KeyEvent.VK_UP:
                ys = -game.getSpeed() - getSpeed();
                break;
            case KeyEvent.VK_DOWN:
                ys = game.getSpeed() + getSpeed();
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                xs = 0;
                break;
            case KeyEvent.VK_RIGHT:
                xs = 0;
                break;
            case KeyEvent.VK_UP:
                ys = 0;
                break;
            case KeyEvent.VK_DOWN:
                ys = 0;
                break;
        }
    }

    public void paint(Graphics2D g) {
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

}
