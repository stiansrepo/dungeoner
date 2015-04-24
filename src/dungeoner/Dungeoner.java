package dungeoner;

// @author laptopng34
import javax.swing.JFrame;

public class Dungeoner extends JFrame {

    public static void main(String[] args) throws Exception {

        Dungeoner dungeoner = new Dungeoner();
        Game game = new Game();
        game.setSize(600, 600);
        dungeoner.setSize(600,600);
        dungeoner.add(game);
        dungeoner.setVisible(true);
        dungeoner.setResizable(false);
        dungeoner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            game.move();
            game.repaint();
            Thread.sleep(20);
        }

    }

}
