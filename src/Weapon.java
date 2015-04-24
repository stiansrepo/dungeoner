

 // @author laptopng34
import java.awt.event.KeyEvent;

public class Weapon {

    private int x;
    private int y;
    private int xs;
    private int ys;
    
    private int speed = 6;
    
    private Game game;

    public Weapon(Game game) {
        this.game = game;
    }
    
    public int getSpeed(){
        return speed;
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                xs = -game.getSpeed() - getSpeed();
            case KeyEvent.VK_RIGHT:
                xs = game.getSpeed() + getSpeed();
            case KeyEvent.VK_UP:
                ys = -game.getSpeed() - getSpeed();
            case KeyEvent.VK_DOWN:
                ys = game.getSpeed() + getSpeed();
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                xs = 0;
            case KeyEvent.VK_RIGHT:
                xs = 0;
            case KeyEvent.VK_UP:
                ys = 0;
            case KeyEvent.VK_DOWN:
                ys = 0;
        }
    }

}
