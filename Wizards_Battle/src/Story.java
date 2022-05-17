
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Story extends JPanel implements ActionListener {

    String[] s = { "      HI EVERYONE,", "WELCOME IN THIS EVENT WITCH ", "HAPPEN EVERY YEAR WHERE ALL WIZARDS",
            "ARE FIGHTING TOGETHER TO SEE WHO IS", " THE STRONGEST WIZARDS IN THE WORLD." };
    Timer t;
    Timer done;
    Timer fin;

    Image img;
    Image next;
    Image happy;

    ImageIcon[] talk = new ImageIcon[3];
    ImageIcon[] cheer = new ImageIcon[3];

    int x, y, flyCont, flyIndex, actCont, actIndex;

    boolean cleked = false;

    String start = "\t\tLET'S GET STARTED";

    Story_Frame mood;
    ImageIcon bakgraud = new ImageIcon(getClass().getResource("HAPPY/sky.jpg"));
    ImageIcon button = new ImageIcon(getClass().getResource("HAPPY/next.png"));

    public Story(Story_Frame frame) {
        mood = frame;

        setLayout(null);

        for (int i = 0; i < 3; i++) {
            talk[i] = new ImageIcon(getClass().getResource("HAPPY/l/HAPPYtalk" + (1 + i) + ".png"));
        }
        for (int i = 0; i < 2; i++) {
            cheer[i] = new ImageIcon(getClass().getResource("HAPPY/l/HAPPYcheer" + (1 + i) + ".png"));
        }

        next = button.getImage();
        img = bakgraud.getImage();
        happy = talk[0].getImage();

        Rectangle r = new Rectangle(250, 270, 80, 80);

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (r.contains(me.getPoint())) {
                    cleked = true;
                    done.start();
                    t.stop();
                }
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        });
        x = 450;
        y = 400;

        done = new Timer(40, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                act();
                repaint();
                fin.start();
            }
        });

        fin = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!t.isRunning()) {
                    done.stop();
                    mood.dispose();
                    fin.stop();
                }
            }
        });
        t = new Timer(40, this);
        t.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        talk();
        fly();
    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);
        Graphics2D G2D = (Graphics2D) g;

        G2D.drawImage(img, 0, 0, 600, 400, null);

        G2D.drawImage(getImagehappy(), x, y, null);
        G2D.drawImage(next, 250, 270, 80, 80, null);
        G2D.setColor(Color.BLACK);
        G2D.setFont(new Font("Monospaced", Font.BOLD, 20));
        if (cleked == false) {
            G2D.drawString(s[0], 20, 70);
            G2D.drawString(s[1], 20, 90);
            G2D.drawString(s[2], 20, 110);
            G2D.drawString(s[3], 20, 130);
            G2D.drawString(s[4], 20, 150);
        }
        if (cleked == true) {
            G2D.drawString(start, 20, 70);
        }
    }

    public void fly() {
        if (y > 100)
            y = y - 7;
    }

    public Image getImagehappy() {
        return happy;
    }

    public void talk() {
        flyCont++;
        if (flyCont > 30)
            flyCont = 0;

        if (flyCont != 0) {
            if (flyCont < 10)
                flyIndex = 0;
            else if (flyCont < 20)
                flyIndex = 1;
            else if (flyCont < 30) {
                flyIndex = 2;
                // act();

            }
        }
        happy = talk[flyIndex].getImage();
    }

    public void act() {
        actCont++;

        if (actCont != 0) {
            if (actCont < 10)
                actIndex = 0;
            else if (actCont < 20)
                actIndex = 1;
        }
        happy = cheer[actIndex].getImage();

    }

}
