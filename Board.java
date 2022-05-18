import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class Board extends JPanel {
    Snake snake = new Snake();
    public Board(){
        this.setBounds(10,10,780,500);
        this.setBackground(Color.BLACK);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        snake.draw(g);
        snake.move();
    }
}
