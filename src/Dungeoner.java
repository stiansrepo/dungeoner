
import javax.swing.JFrame;
// @author laptopng34import javax.swing.JFrame;

public class Dungeoner extends JFrame {

    private Game game = new Game();
    private long lastFpsTime;
    private int fps;

    public static void main(String[] args) {
        Dungeoner dungeoner = new Dungeoner();
        dungeoner.gameRun();
    }

    public Dungeoner() {

    }

    private void gameRun() {
        
        game.setSize(600, 600);
        setSize(600, 600);
        add(game);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameLoop();

    }

    private void gameLoop() {

        long initialTime = System.nanoTime();
        final double timeU = 1000000000 / 120;
        final double timeF = 1000000000 / 60;
        double deltaU = 0, deltaF = 0;
        int frames = 0, ticks = 0;
        long timer = System.currentTimeMillis();

        while (true) {

            long currentTime = System.nanoTime();
            deltaU += (currentTime - initialTime) / timeU;
            deltaF += (currentTime - initialTime) / timeF;
            initialTime = currentTime;

            if (deltaU >= 1) {                
                game.move();
                ticks++;
                deltaU--;
            }

            if (deltaF >= 1) {
                game.repaint();
                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - timer > 1000) {
                if (true) {
                    System.out.println(String.format("UPS: %s, FPS: %s", ticks, frames));
                }
                frames = 0;
                ticks = 0;
                timer += 1000;
            }
        }
    }
}
