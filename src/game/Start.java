
package game;

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

        ImageIcon logo=new ImageIcon(getClass().getResource("logo.jpg"));
       ImageIcon logoha=new ImageIcon(getClass().getResource("HAPPY/HAPPY.jpg"));

        
            public Start() {
        super("Greating");
      Story st = new Story(this);
      
        add(st);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setResizable(false);//maximais
         setIconImage(logoha.getImage());
        //setIconImage(logo.getImage());
       
        
    }
    
    public Start(String f, String p1,String p2) {
       super(" Wizards Battle");
       Battlefield bf= new Battlefield(this,f,p1,p2);
               add( bf);
               
            JMenuBar bar = new JMenuBar(); // create menu bar
             JMenu Menu = new JMenu( "Control" );
            JMenuItem Item = new JMenuItem( "Quit" );
            JRadioButton ch=new JRadioButton("Mute",false);
         
             setJMenuBar(bar);
             Menu.add(Item);
             Menu.add(ch);
         
            Item.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                 int reply = JOptionPane.showConfirmDialog(Start.this, " Are You Sure ? ", "Quit", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if(reply == JOptionPane.YES_OPTION){
                    dispose();
                bf.Stop();
                new Selection();  
                }
            }
            });
            ch.addItemListener(new ItemListener(){

           @Override
           public void itemStateChanged(ItemEvent e) {
               
               if(ch.isSelected())
                  bf.mute();
               if(!ch.isSelected())
                  bf.unmute();
           ;}
            }
            );
            
            
            bar.add(Menu);

                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setIconImage(logo.getImage());
            
               setResizable(false);//maximais
               setSize(1200, 700);
               setVisible(true);
    }


    

    
    
    
    
    
}
