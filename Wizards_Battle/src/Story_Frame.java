
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Story_Frame extends JFrame {

    ImageIcon logo = new ImageIcon(getClass().getResource("logo.jpg"));
    ImageIcon logoha = new ImageIcon(getClass().getResource("HAPPY/HAPPY.jpg"));

    public Story_Frame() {
        super("Greeting");
        Story st = new Story(this);

        add(st);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setResizable(false);// maximais
        setIconImage(logoha.getImage());


    }

}
