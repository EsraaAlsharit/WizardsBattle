
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Player1 {

    String CharName;

    int HP = 1000;

    int x, xd, y;
    int aboutFace = 0;

    final int faceR = 0;
    final int faceL = 1;

    int runCtr;
    int runIndex;

    int attCtr;
    int attIndex;

    boolean defense = false;
    boolean attach = false;
    boolean superhit = false;
    boolean run = false;
    boolean damge = false;
    boolean win = false;
    boolean die = false;

    Image p1;

    ImageIcon[] p1hitR = new ImageIcon[3];
    ImageIcon[] p1hitL = new ImageIcon[3];

    ImageIcon[] p1runL = new ImageIcon[3];
    ImageIcon[] p1runR = new ImageIcon[3];

    ImageIcon p1standR;
    ImageIcon p1standL;

    ImageIcon p1difR;
    ImageIcon p1difL;

    ImageIcon p1damgeL;
    ImageIcon p1damgeR;

    ImageIcon p1dieR;
    ImageIcon p1dieL;

    ImageIcon p1win;

    public Player1(String name) {
        setCharName(name);
        for (int i = 0; i < 3; i++) {
            p1runL[i] = new ImageIcon(getClass().getResource("run/l/" + name + "run" + (i + 1) + ".png"));
            p1runR[i] = new ImageIcon(getClass().getResource("run/r/" + name + "run" + (i + 1) + ".png"));

            p1hitR[i] = new ImageIcon(getClass().getResource("stand/r/" + name + "hit" + (i + 1) + ".png"));
            p1hitL[i] = new ImageIcon(getClass().getResource("stand/l/" + name + "hit" + (i + 1) + ".png"));
        }

        p1standR = new ImageIcon(getClass().getResource("stand/r/" + name + "stand.png"));
        p1standL = new ImageIcon(getClass().getResource("stand/l/" + name + "stand.png"));

        p1difR = new ImageIcon(getClass().getResource("stand/r/" + name + "dif.png"));
        p1difL = new ImageIcon(getClass().getResource("stand/l/" + name + "dif.png"));

        p1damgeL = new ImageIcon(getClass().getResource("stand/l/" + name + "damge.png"));
        p1damgeR = new ImageIcon(getClass().getResource("stand/r/" + name + "damge.png"));

        p1dieR = new ImageIcon(getClass().getResource("stand/r/" + name + "die.png"));
        p1dieL = new ImageIcon(getClass().getResource("stand/r/" + name + "die.png"));

        p1win = new ImageIcon(getClass().getResource("stand/" + name + "win.png"));

        p1 = p1standR.getImage();

        x = 200;
        y = 490;



    }// end constacter

    public void move() {

        if (die == false && win == false) {

            // stand
            if (damge == false) {
                if (aboutFace == faceL) {
                    p1 = p1standL.getImage();
                }
                if (aboutFace == faceR) {
                    p1 = p1standR.getImage();
                }
            }
            // run
            if (run == true && defense == false && attach == false && superhit == false) {
                Run();
            }

            // defense
            if (defense == true) {
                Defense();
            }

            // attach
            if (attach == true) {
                Attach();
            }
            // super
            // if

        }
        if (die == true) {
            Die();
        }
        if (win == true) {
            Win();
        }

    }// end constrct

    public int getHP() {
        return HP;
    }

    public void setHP(int hp) {
        if (hp < 0) {
            die = true;

        } else
            this.HP = hp;
    }

    public String getCharName() {
        return CharName;
    }

    public void setCharName(String CharName) {
        this.CharName = CharName;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public Rectangle sandplas() {
        return new Rectangle((x + 30), y, 70, 120);
    }

    public int getX1() {
        return x;
    }

    public int getY1() {
        return y;
    }

    public Image getImage1() {
        if (die == false)
            damge = false;
        return p1;
    }

    public void Run() {

        if (x + xd < 1090 && x + xd > -22) {// stop it move out right or left

            x = x + xd;
            runCtr++;
            if (runCtr >= 30)
                runCtr = 0;

            if (runCtr < 10)
                runIndex = 0;
            else if (runCtr < 20)
                runIndex = 1;
            else if (runCtr < 30)
                runIndex = 2;
            if (aboutFace == faceL) {
                p1 = p1runL[runIndex].getImage();
            }
            if (aboutFace == faceR) {
                p1 = p1runR[runIndex].getImage();
            }
        }

    }

    public void Defense() {
        if (aboutFace == faceL) {
            p1 = p1difL.getImage();
        }
        if (aboutFace == faceR) {
            p1 = p1difR.getImage();
        }
    }

    public void Attach() {
        attCtr++;
        if (attCtr < 10)
            attIndex = 0;
        else if (attCtr < 20)
            attIndex = 1;
        else if (attCtr < 30)
            attIndex = 2;

        if (aboutFace == faceL) {
            p1 = p1hitL[attIndex].getImage();
        }
        if (aboutFace == faceR) {
            p1 = p1hitR[attIndex].getImage();
        }

        if (attCtr >= 30) {
            attCtr = 0;
            attach = false;
            if (aboutFace == faceL) {
                p1 = p1standL.getImage();
            }
            if (aboutFace == faceR) {
                p1 = p1standR.getImage();
            }
        }
    }

    public void Damege() {

        if (aboutFace == faceL) {
            p1 = p1damgeL.getImage();
        }
        if (aboutFace == faceR) {
            p1 = p1damgeR.getImage();
        }

    }

    public void Die() {

        if (aboutFace == faceL) {
            p1 = p1dieL.getImage();
        }
        if (aboutFace == faceR) {
            p1 = p1dieR.getImage();
        }
    }

    public void Win() {

        p1 = p1win.getImage();
    }

    public void keyPressed(KeyEvent p) {
        int key = p.getKeyCode();

        if (key == KeyEvent.VK_A) {// need fix
            if (die == false && win == false)
                aboutFace = faceL;
            run = true;
            xd = -4;

        }
        if (key == KeyEvent.VK_D) {// need fix
            if (die == false && win == false)
                aboutFace = faceR;
            run = true;
            xd = 4;

        }

        if (key == KeyEvent.VK_S) {
            defense = true;

        }

        if (key == KeyEvent.VK_SPACE) {
            if (die == false && win == false)
                attach = true;
        }

    }

    public void keyReleased(KeyEvent p) {
        int key = p.getKeyCode();

        if (key == KeyEvent.VK_D) {
            xd = 0;
            if (die == false && win == false)
                p1 = p1standR.getImage();
            run = false;
        }
        if (key == KeyEvent.VK_A) {
            if (die == false && win == false)
                p1 = p1standL.getImage();
            run = false;
            xd = 0;

        }

        if (key == KeyEvent.VK_S) {

            defense = false;
            if (die == false && win == false) {
                if (aboutFace == faceL) {
                    p1 = p1standL.getImage();
                }
                if (aboutFace == faceR) {
                    p1 = p1standR.getImage();
                }

            }
        }

    }

}// END CLASS
