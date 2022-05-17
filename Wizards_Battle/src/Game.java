import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game extends JFrame {

    JLabel lbl;
    JLabel btn;
    ImageIcon img = new ImageIcon(getClass().getResource("characters/interface.png"));
    JPanel pane = new JPanel();
    ImageIcon logo = new ImageIcon(getClass().getResource("logo.jpg"));

    JMenuBar bar = new JMenuBar(); // create menu bar
    JMenuItem Item = new JMenuItem("about"); // create exit item

    ImageIcon play = new ImageIcon(getClass().getResource("characters/button.png"));

    public Game() {
        super("Wizards Battle");
        setLayout(null);

        Image mg = img.getImage();
        img.setImage(mg.getScaledInstance(600, 700, Image.SCALE_SMOOTH));
        lbl = new JLabel(img, JLabel.CENTER);
        lbl.setBounds(0, 0, 600, 700);
        add(lbl);

        Image mge = play.getImage();
        play.setImage(mge.getScaledInstance(100, 50, Image.SCALE_SMOOTH));
        btn = new JLabel(play);
        btn.setBounds(280, 600, 100, 50);
        lbl.add(btn);

        setJMenuBar(bar);

        bar.add(Item);
        Item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(Game.this, "This game made by:\nArwa Alali \nIsraa Alsharit ", "About",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        });

        btn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                new Selection();
                new Story_Frame();
                dispose();

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(logo.getImage());
        setResizable(false);
        setSize(600, 750);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Game();

    }

}
