
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

public class Start extends JFrame {

    ImageIcon logo = new ImageIcon(getClass().getResource("logo.jpg"));

    public Start(String f, String p1, String p2) {
        super(" Wizards Battle");
        setSize(1200, 700);

        JMenuBar bar = new JMenuBar(); // create menu bar
        JMenu Menu = new JMenu("Control");
        JMenuItem Item = new JMenuItem("Quit");
        JRadioButton ch = new JRadioButton("Mute", false);

        setJMenuBar(bar);
        Menu.add(Item);
        Menu.add(ch);

        Battlefield bf = new Battlefield(this, f, p1, p2);
       // add(new Battlefield(this, f, p1, p2));
        add(bf);

        Item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                int reply = JOptionPane.showConfirmDialog(Start.this, " Are You Sure ? ", "Quit",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (reply == JOptionPane.YES_OPTION) {
                    dispose();
                    bf.Stop();
                    new Selection();
                }
            }
        });
        ch.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {

                if (ch.isSelected())
                    bf.mute();
                if (!ch.isSelected())
                    bf.unmute();
                ;
            }
        });

        bar.add(Menu);




        setIconImage(logo.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);// maximais







    }

}
