import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JFrame implements KeyListener {
    Board board;
    static public JLabel text;

    public Window() {
        //@todo change the window title to Game
        this.setTitle("any name");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(800, 600));
        this.setVisible(true);
        this.setResizable(false);
        this.addKeyListener(this);
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        board = new Board();
        this.add(board);
        text = new JLabel();
        text.setBounds(10, 510, 790, 90);
        Window.text.setText("Game Speed is (" + Main.threadSpeed +  ")\t\tSnake Parts (" + Snake.partsCount + ")");
        this.add(text);
        this.pack();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // W37, N38, E39, S40
//        System.out.println(e.getKeyCode());
        Snake.direction = e.getKeyCode();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
