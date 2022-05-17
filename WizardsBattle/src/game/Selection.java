package game;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Selection extends JFrame implements ActionListener {

    Battlefield bf;
    Player1 play1;
    Player2 play2;
    ImageIcon logo=new ImageIcon(getClass().getResource("logo.jpg"));
    
    String FieldName;
    String CharName1;
    String CharName2;
    
    int x = 0, event;

    String[] pathmap = {"map/Forest.png", "map/Desert.png", "map/Mountains.png", "map/Glacier.png","map/Dump.png"};
    String[] namemap = {"Forest", "Desert", "Mountains", "Glacier","Dump"};

    Icon picmap[] = new ImageIcon[namemap.length];
    JButton buttonsmap[] = new JButton[namemap.length];

    String[] pathch = {"characters/NATSU.png", "characters/LAXUS.png", "characters/c1.png", "characters/c2.png", "characters/c3.png", "characters/c4.png", "characters/c5.png", "characters/c6.png", "characters/c7.png", "characters/c8.png", "characters/c9.png","characters/c10.png","characters/c11.png","characters/c12.png","characters/c13.png","characters/c14.png"};
    String[] namech = {"NATSU", "LAXUS", "COBRA", "ERZA", "FRIED", "GAJEEL", "GRAY", "MAKAROV", "LEVY", "JELLAL", "JUVIA","LUCY","LYON","MIDNIGHT","WENDY","ZERO"};

    Icon picch[] = new ImageIcon[namech.length];
    JButton buttonsch[] = new JButton[namech.length];

    JLabel user1 = new JLabel("Player1: ");//get the name the payer that is log in
    JLabel user2 = new JLabel("Player2: ");

    JTextField char1 = new JTextField(15);
    JTextField char2 = new JTextField(15);

    JLabel filedname = new JLabel("MAP");
    JTextField filed = new JTextField(15);

    JButton next = new JButton("NEXT");
    
    JPanel panel = new JPanel();
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel p4 = new JPanel();
    JPanel p5 = new JPanel();
    
    ImageIcon icn = new ImageIcon(getClass().getResource("characters/sel.jpg"));
     ImageIcon info = new ImageIcon(getClass().getResource("characters/info.png"));
    JLabel l;
    
          Icon icn1 = new ImageIcon();
    Icon icn2 = new ImageIcon();
     Icon icn3 = new ImageIcon();
    Icon icn4 = new ImageIcon();
    
    
    JLabel lbl1 = new JLabel("Moving to the Left");
    JLabel lbl2 = new JLabel("Attack");
    JLabel lbl3 = new JLabel("Moving to the Right");
    JLabel lbl4  = new JLabel("Defence");
    JPanel panell = new JPanel();
    
    Icon icn11 = new ImageIcon();
    Icon icn22 = new ImageIcon();
     Icon icn33 = new ImageIcon();
    Icon icn44 = new ImageIcon();
    
    
    JLabel lbl11 = new JLabel("Moving to the Left");
    JLabel lbl44 = new JLabel("Attack");
    JLabel lbl22 = new JLabel("Moving to the Right");
    JLabel lbl33 = new JLabel("Defence");
        JPanel pany = new JPanel();
        
      //  ImageIcon Micn = new ImageIcon(getClass().getResource("characters/ac.png"));
        
        
  JTabbedPane pane = new JTabbedPane();
    JPanel login = new JPanel();
    JPanel logout = new JPanel();
        JPanel reg = new JPanel();
    
     URL url1 = Game.class.getResource("Sounds/opening.wav");
     AudioClip open = Applet.newAudioClip(url1);

    public Selection() {
        super("Selection mood");
        setLayout(null);
        
        open.loop();

         JMenuBar bar = new JMenuBar(); // create menu bar
         JMenu Menu = new JMenu( "Instruction" ); 
         JMenuItem Item1 = new JMenuItem( "How to select" ); // create exit item
         JMenuItem Item2 = new JMenuItem("Player 1" ); // create exit item
         JMenuItem Item3 = new JMenuItem( "Player 2" ); // create exit item
         JMenuItem Item4 = new JMenuItem( "Story" ); // create exit item
         
         Menu.setMnemonic('i');
          
        Image img = icn.getImage();
        icn.setImage(img.getScaledInstance(650, 600, Image.SCALE_SMOOTH));
        l=new JLabel (icn);
        l.setBounds(0,0,650, 600);
        add(l);
        
        panel.setBackground(new Color(0,0,0,0));
        panel.setLayout(null);
        panel.setBounds(5,5 ,625, 620);
        l.add(panel);
        
        p1.setBackground(new Color(0,0,0,0));
        p1.setLayout(new FlowLayout());
        p1.setBounds(0, 0, 625, 100);
        panel.add(p1);
        

        for (int j = 0; j < pathmap.length; j++) {
            SetImageSizemap(j);
        }

        //add button
        for (int i = 0; i < buttonsmap.length; i++) {
            buttonsmap[i] = new JButton(namemap[i], picmap[i]);
            buttonsmap[i].setHorizontalTextPosition(SwingConstants.CENTER);
            buttonsmap[i].setVerticalTextPosition(SwingConstants.BOTTOM);
           // buttonsmap[i].setBackground(new Color(0,0,0,0));
            p1.add(buttonsmap[i]);
            buttonsmap[i].addActionListener(this);//handel buuton
        }

        p2.setLayout(new FlowLayout());

        p2.setBackground(new Color(0,0,0,0));
        p2.setBounds(0, 100, 625, 50);
        panel.add(p2);
        filed.setEditable(false);
        filedname.setFont(new Font("MONOSPACED",Font.BOLD,20));
        filedname.setForeground(Color.WHITE);
        p2.add(filedname);
       // filed.setBackground(new Color(0,0,0,0));
       // filed.setForeground(Color.WHITE);
        p2.add(filed);
        
        
        p3.setBackground(new Color(0,0,0,0));
        p3.setLayout(new GridLayout(4,4,5,5));
        p3.setBounds(58, 140, 500,350);
        panel.add(p3);

        for (int x = 0; x < pathch.length; x++) {
            SetImageSizechar(x);
        }
        for (int i = 0; i < buttonsch.length; i++) {
            buttonsch[i] = new JButton(namech[i], picch[i]);
            buttonsch[i].setHorizontalTextPosition(SwingConstants.CENTER);
            buttonsch[i].setVerticalTextPosition(SwingConstants.BOTTOM);
          //  buttonsch[i].setBackground(new Color(0,0,0,20));
            p3.add(buttonsch[i]);
            buttonsch[i].addActionListener(this);//handel buuton

        }

        char1.setEditable(false);
        char2.setEditable(false);

        p4.setBackground(new Color(0,0,0,0));
        p4.setLayout(new FlowLayout());
        p4.setBounds(0, 500, 625, 100);
        panel.add(p4);
        
        user1.setFont(new Font("MONOSPACED",Font.BOLD,20));
        user1.setForeground(Color.WHITE);
        p4.add(user1);
        p4.add(char1);

        user2.setFont(new Font("MONOSPACED",Font.BOLD,20));
        user2.setForeground(Color.WHITE);
        p4.add(user2);
        p4.add(char2);
        
        p5.setBackground(new Color(0,0,0,0));
        p5.setLayout(new FlowLayout());
        p5.setBounds(0, 535, 625, 50);
        panel.add(p5);
        
       // next.setBackground(new Color(0,0,0,0));
        p5.add(next);
        
        setJMenuBar(bar);
    
       Menu.add(Item1);
       Menu.add(Item2);
       Menu.add(Item3);
       Menu.add(Item4);

            Item1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
            JOptionPane.showMessageDialog( Selection.this," You must select a battlefiled, A player1 character, and player2 Character. \nNote that you can't Select the same Character for both Player1 and Player2. ", "How to Select", JOptionPane.INFORMATION_MESSAGE );
            }
                
            });
             
             Item2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
           // JOptionPane.showMessageDialog( Selection.this,"Player1 move by pressing the Keys \na 'to Left'. \nd 'to Right'. \ns 'to Defence'. \nSpace 'to Attack' ", "Player 1", JOptionPane.INFORMATION_MESSAGE );
            MunPly1();
            }
                
            });
             
            Item3.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
           // JOptionPane.showMessageDialog( Selection.this,"Player2 move by pressing the Arrows \nLeft arrow 'to Left'. \nRight arrow 'to Right'. \nDown arrow 'to Defence'. \nEnter 'to Attack' ", "Player 2", JOptionPane.INFORMATION_MESSAGE );
            MunPly2();
            }
                
            });
            
            Item4.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                new Start();
            }
                
            });
            
       bar.add(Menu);
        
        next.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 640);
        setResizable(false);
        setIconImage(logo.getImage());
        setVisible(true);
    }

      public void MunPly1(){//Player2 Instruction
            JFrame frame1 = new JFrame("Player1");

        //super("Player2");
        setLayout(new FlowLayout());
        pany.setLayout(new BoxLayout(pany, BoxLayout.Y_AXIS));
        
        ImageIcon cn1 = new ImageIcon(getClass().getResource("Keys/a.png"));
        Image img1 = cn1.getImage();
        Image newImg1 = img1.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        icn1 = new ImageIcon(newImg1);
        
        ImageIcon cn2 = new ImageIcon(getClass().getResource("Keys/d.png"));
        Image img2 = cn2.getImage();
        Image newImg2 = img2.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        icn2 = new ImageIcon(newImg2);
        
         ImageIcon cn3 = new ImageIcon(getClass().getResource("Keys/s.png"));
        Image img3 = cn3.getImage();
        Image newImg3 = img3.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        icn3 = new ImageIcon(newImg3);
        
        ImageIcon cn4 = new ImageIcon(getClass().getResource("Keys/e.png"));
        Image img4 = cn4.getImage();
        Image newImg4 = img4.getScaledInstance(70, 100, Image.SCALE_SMOOTH);
        icn4 = new ImageIcon(newImg4);
        
        lbl1.setIcon(icn1);
        lbl2.setIcon(icn2);
        lbl3.setIcon(icn3);
        lbl4.setIcon(icn4);
        
        pany.add(lbl1);
       pany. add(lbl2);
       pany. add(lbl3);
       pany. add(lbl4);
        frame1.add(pany);
        frame1.setIconImage(info.getImage());
        frame1.setResizable(false);
       frame1. setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           frame1. setSize(300, 330);
           frame1. setVisible(true);
    
    
    
    }
      
        public void MunPly2(){ //Player1 Instruction
        JFrame frame = new JFrame("Player2");
        //super("Player1");
        panell.setLayout(new BoxLayout(panell, BoxLayout.Y_AXIS));
        setLayout(new FlowLayout());
        ImageIcon cn1 = new ImageIcon(getClass().getResource("Keys/image.png"));
        Image img1 = cn1.getImage();
        Image newImg1 = img1.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        icn1 = new ImageIcon(newImg1);
        
        ImageIcon cn2 = new ImageIcon(getClass().getResource("Keys/image-2.png"));
        Image img2 = cn2.getImage();
        Image newImg2 = img2.getScaledInstance(150, 60, Image.SCALE_SMOOTH);
        icn2 = new ImageIcon(newImg2);
        
         ImageIcon cn3 = new ImageIcon(getClass().getResource("Keys/image-3.png"));
        Image img3 = cn3.getImage();
        Image newImg3 = img3.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        icn3 = new ImageIcon(newImg3);
        
        ImageIcon cn4 = new ImageIcon(getClass().getResource("Keys/image-4.png"));
        Image img4 = cn4.getImage();
        Image newImg4 = img4.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        icn4 = new ImageIcon(newImg4);
        
        lbl1.setIcon(icn1);
        lbl2.setIcon(icn2);
        lbl3.setIcon(icn3);
        lbl4.setIcon(icn4);
        
       panell.add(lbl1);
       panell.add(lbl3);
       panell.add(lbl4);
       panell.add(lbl2);
       
            
//         p3.add(LB3);
//         p3.add(fntxt);
//         p3.add(untxt);
//         p3.add(pw);
         
       
       frame.add(panell);
        
                frame.setIconImage(info.getImage());
frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         frame.setSize(300, 300);
          frame.setVisible(true);
    
    }
      
    public void SetImageSizemap(int i) {
        ImageIcon icon = new ImageIcon(getClass().getResource(pathmap[i]));
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        picmap[i] = new ImageIcon(newImg);
    }

    public void SetImageSizechar(int x) {
        ImageIcon icon = new ImageIcon(getClass().getResource(pathch[x]));
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        picch[x] = new ImageIcon(newImg);
    }
    
     public String getFieldName() {
        return FieldName;
    }

    public void setFieldName(String FieldName) {
        this.FieldName = FieldName;
    }

    public String getCharName1() {
        return CharName1;
    }

    public void setCharName1(String CharName1) {
        this.CharName1 = CharName1;
    }

    public String getCharName2() {
        return CharName2;
    }
    
     public void setCharName2(String CharName2) {
        this.CharName2 = CharName2;
    }

    public void actionPerformed(ActionEvent e) {

        for (JButton buttonschz : buttonsch) {
            if (e.getSource() == buttonschz) {

                if (event == 0 && !char2.getText().equals(buttonschz.getText())) {
                    event++;
                    char1.setText(buttonschz.getText());
                       setCharName1(char1.getText());
                    //play1.setCharName(char1.getText());

                } else if (event != 0 && !char1.getText().equals(buttonschz.getText())) {
                    event = 0;
                    char2.setText(buttonschz.getText());
                    setCharName2(char2.getText());

                } else {
                    JOptionPane.showMessageDialog(null, "you can't select the same character your enemy has selected\nTry agian", "SORRY", JOptionPane.WARNING_MESSAGE);
                }

            }
        }

        for (JButton buttonsmaps : buttonsmap) {
            if (e.getSource() == buttonsmaps) {
                filed.setText(buttonsmaps.getText());
                setFieldName(filed.getText());
            }
        }

        if (e.getSource() == next) {
            if (!filed.getText().isEmpty() && !char2.getText().isEmpty() && !char1.getText().isEmpty()) {
                dispose();
               new Start(filed.getText(),char1.getText(),char2.getText());
               open.stop();
            } else {
                JOptionPane.showMessageDialog(null, "plz complete the selection", "complete selection", JOptionPane.ERROR_MESSAGE);
            }

        }

    }
    
}
