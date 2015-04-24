
 // @author laptopng34
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class Game extends JPanel {

    Player player = new Player(this, 5, 5, 0, 0, "player");
    Weapon weapon = new Weapon(this);
    Entity enemy = new Entity(this);
    MapGenerator map = new MapGenerator(50, 50);
    int speed;

    public Game() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                player.keyReleased(e);
                weapon.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                player.keyPressed(e);
                weapon.keyPressed(e);
            }
        });
        setFocusable(true);

    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int s) {
        speed = s;
    }

    public void move() {
        enemy.move();
        player.move();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Color.BLACK);        
        map.paint(g2d);
        player.paint(g2d);
    }

}
