
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Player2 {

    String CharName;

    int HP = 1000;

    int x, xd, y;
    int aboutFace = 1;

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

    Image p2;

    ImageIcon[] p2hitR = new ImageIcon[3];
    ImageIcon[] p2hitL = new ImageIcon[3];

    ImageIcon[] p2runL = new ImageIcon[3];
    ImageIcon[] p2runR = new ImageIcon[3];

    ImageIcon p2standR;
    ImageIcon p2standL;

    ImageIcon p2difR;
    ImageIcon p2difL;

    ImageIcon p2damgeL;
    ImageIcon p2damgeR;

    ImageIcon p2dieR;
    ImageIcon p2dieL;

    ImageIcon p2win;

    public Player2(String name) {

        setCharName(name);

        for (int i = 0; i < 3; i++) {
            p2runL[i] = new ImageIcon(getClass().getResource("run/l/" + name + "run" + (i + 1) + ".png"));
            p2runR[i] = new ImageIcon(getClass().getResource("run/r/" + name + "run" + (i + 1) + ".png"));

            p2hitR[i] = new ImageIcon(getClass().getResource("stand/r/" + name + "hit" + (i + 1) + ".png"));
            p2hitL[i] = new ImageIcon(getClass().getResource("stand/l/" + name + "hit" + (i + 1) + ".png"));
        }

        p2standR = new ImageIcon(getClass().getResource("stand/r/" + name + "stand.png"));
        p2standL = new ImageIcon(getClass().getResource("stand/l/" + name + "stand.png"));

        p2difR = new ImageIcon(getClass().getResource("stand/r/" + name + "dif.png"));
        p2difL = new ImageIcon(getClass().getResource("stand/l/" + name + "dif.png"));

        p2damgeL = new ImageIcon(getClass().getResource("stand/l/" + name + "damge.png"));
        p2damgeR = new ImageIcon(getClass().getResource("stand/r/" + name + "damge.png"));

        p2dieR = new ImageIcon(getClass().getResource("stand/r/" + name + "die.png"));
        p2dieL = new ImageIcon(getClass().getResource("stand/r/" + name + "die.png"));

        p2win = new ImageIcon(getClass().getResource("stand/" + name + "win.png"));

        p2 = p2standL.getImage();

        x = 870;
        y = 490;

    }// constrect

    public void move() {

        if (die == false && win == false) {
            // stand
            if (damge == false) {
                if (aboutFace == faceL) {
                    p2 = p2standL.getImage();
                }
                if (aboutFace == faceR) {
                    p2 = p2standR.getImage();
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

    public void setWin(boolean win) {
        this.win = win;
    }

    public void setCharName(String CharName) {
        this.CharName = CharName;
    }

    public Rectangle sandplas() {
        return new Rectangle((x + 30), y, 70, 120);
    }

    public int getX2() {
        return x;
    }

    public int getY2() {
        return y;

    }

    public Image getImage2() {
        damge = false;
        return p2;
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
                p2 = p2runL[runIndex].getImage();
            }
            if (aboutFace == faceR) {
                p2 = p2runR[runIndex].getImage();

            }
        }

    }

    public void Defense() {
        if (aboutFace == faceL) {
            p2 = p2difL.getImage();
        }
        if (aboutFace == faceR) {
            p2 = p2difR.getImage();
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
            p2 = p2hitL[attIndex].getImage();
        }
        if (aboutFace == faceR) {
            p2 = p2hitR[attIndex].getImage();
        }
        if (attCtr >= 30) {
            attCtr = 0;
            attach = false;
            if (aboutFace == faceL) {
                p2 = p2standL.getImage();
            }
            if (aboutFace == faceR) {
                p2 = p2standR.getImage();
            }
        }

    }

    public void Damege() {
        if (aboutFace == faceL) {
            p2 = p2damgeL.getImage();
        }
        if (aboutFace == faceR) {
            p2 = p2damgeR.getImage();
        }
    }

    public void Die() {

        if (aboutFace == faceL) {
            p2 = p2dieL.getImage();
        }
        if (aboutFace == faceR) {
            p2 = p2dieR.getImage();
        }
    }

    public void Win() {
        p2 = p2win.getImage();
    }

    public void keyPressed(KeyEvent p) {
        int key = p.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {// need fix
            if (die == false && win == false)
                aboutFace = faceL;
            run = true;
            xd = -4;

        }
        if (key == KeyEvent.VK_RIGHT) {// need fix
            if (die == false && win == false)
                aboutFace = faceR;
            run = true;
            xd = 4;
        }

        if (key == KeyEvent.VK_DOWN) {
            defense = true;

        }

        if (key == KeyEvent.VK_ENTER) {
            if (die == false && win == false)
                attach = true;

        }
    }

    public void keyReleased(KeyEvent p) {
        int key = p.getKeyCode();

        if (key == KeyEvent.VK_RIGHT) {
            xd = 0;
            run = false;
            if (die == false && win == false)
                p2 = p2standR.getImage();
        }
        if (key == KeyEvent.VK_LEFT) {
            if (die == false && win == false)
                p2 = p2standL.getImage();
            run = false;
            xd = 0;

        }
        if (key == KeyEvent.VK_DOWN) {

            defense = false;
            if (die == false && win == false) {
                if (aboutFace == faceL) {
                    p2 = p2standL.getImage();
                }

                if (aboutFace == faceR) {
                    p2 = p2standR.getImage();
                }
            }
        }

    }

}
