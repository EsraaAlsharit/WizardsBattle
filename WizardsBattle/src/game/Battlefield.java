
package game;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Battlefield extends JPanel implements ActionListener {
    
    URL url1 = Battlefield.class.getResource("Sounds/ost.wav");
    AudioClip ost = Applet.newAudioClip(url1);
    URL url = Battlefield.class.getResource("Sounds/PunchGaming.wav");
    AudioClip clip = Applet.newAudioClip(url);
    
    Player1 p1;
    Player2 p2;
    Start s;
   
    Image img;
   

    Timer time;
    Timer gameover;

       ImageIcon HpBarP1[]=new ImageIcon[18];
        ImageIcon HpBarP2[]=new ImageIcon[18];

        Image HB1;
        Image HB2;

Timer batteltime;
JLabel timer = new JLabel();
int sec=0;
int min=1;

  Image happy;
     
     
 ImageIcon flyL[]=new ImageIcon[3];
 ImageIcon flyR[]=new ImageIcon[3];

 
  ImageIcon cheerR;
  ImageIcon cheerL;
  
 int hx,hy,flyCont,flyIndex,actIndex;
 
 int aboutFace=1;
    
    final int faceR=0;
    final int faceL=1;
Timer flying;


    public Battlefield(Start temp, String name,String c1,String c2) {
       s=temp;
       p1=new Player1(c1);
        p2=new Player2(c2);

        setLayout(null);
        addKeyListener(new MultiKey());
        setFocusable(true);
        
         for (int j = 0; j < 18; j++) {
            HpBarP1[j]=new ImageIcon(getClass().getResource("HealthBar/p1/HP"+(j+1)+".png"));
            HpBarP2[j]=new ImageIcon(getClass().getResource("HealthBar/p2/HP"+(j+1)+".png"));
        }
         for (int i = 0; i < 3; i++) {
            flyL[i]=new ImageIcon(getClass().getResource("HAPPY/l/HAPPYtalk"+(1+i)+".png"));
            flyR[i]=new ImageIcon(getClass().getResource("HAPPY/r/HAPPYtalk"+(1+i)+".png"));

        }
         
        
        ImageIcon i=new ImageIcon(getClass().getResource("map/"+name+".png"));

       HB1=HpBarP1[0].getImage();
       HB2=HpBarP2[0].getImage();
        
        img=i.getImage(); 
        
        hy=250;
        hx=600;
        happy=flyL[0].getImage();
       
        
        time=new Timer(4, this);
        
        gameover=new Timer(1000,new ActionListener(){
             
             public void actionPerformed(ActionEvent e) {
                 if(!time.isRunning()){
              s.dispose();
           new Selection();
           gameover.stop();
             }
             }});
     
        time.start();
       flying();
        Timer();
        ost.loop();
      

    }
    @Override
    public void actionPerformed(ActionEvent ae) {
         check();
        p2.move();
        p1.move();
        repaint();
    }
    
     public void paint (Graphics g){
     
        super.paint(g);
        Graphics2D g2d=(Graphics2D ) g;
        g2d.drawImage(img, 0, 0,1200,700, null);
        g2d.drawImage(gethappy(), getHX(), getHY(),null);

        

        g2d.drawImage(p1.getImage1(), p1.getX1(), p1.getY1(),null);//p2
        g2d.drawImage(p2.getImage2(), p2.getX2(), p2.getY2(),null);//p1
        
        g2d.setFont(new Font("Monospaced",Font.BOLD+Font.ITALIC,20));
        g2d.setColor(Color.RED);
        
        g2d.drawImage(getImageHpBar1(),10, 10, null);
        g2d.drawString(p1.getCharName(), 10, 55);
    
        g2d.setColor(Color.BLUE);
         g2d.drawImage(getImageHpBar2(),980, 10, null);
        g2d.drawString(p2.getCharName(),980, 55);
        
         g2d.setFont(new Font("Monospaced",Font.BOLD,20));
        g2d.setColor(Color.BLACK);
        
         g2d.drawString(""+timer.getText(), 570, 30);

    }
     
   public void check(){
    Rectangle rp1=p1.sandplas();
    Rectangle rp2=p2.sandplas();
      //  cheer();
        if(rp1.intersects(rp2) && p1.attach==true && p2.defense==false && p2.die==false ){
         p2.setHP(p2.getHP()-2);
         p2.damge=true;
          p2.Damege();  
         HPBAR2();
         clip.play();
        }
         else if ( p2.die==true){
             flying.stop();
              p1.setWin(true);
             // 

            JOptionPane.showMessageDialog(null,"Player 1 is the winer", "The Winer", JOptionPane.INFORMATION_MESSAGE);
             gameover.start();
             
              batteltime.stop();
              ost.stop();
             time.stop();
                        

        }
        
        if(rp2.intersects(rp1) && p2.attach==true && p1.defense==false && p1.die==false){
             p1.setHP(p1.getHP()-2);
              p1.damge=true;
             p1.Damege();
              HPBAR1();
              clip.play();
        }
        else if ( p1.die==true){
              p2.setWin(true);
              flying.stop();
            JOptionPane.showMessageDialog(null,"Player 2 is the winer", "The Winer", JOptionPane.INFORMATION_MESSAGE);
           
          gameover.start();
           batteltime.stop();
            ost.stop();
            time.stop();
       
        }
        
    }
   
   public void mute(){
       ost.stop();
   }
   
      public void unmute(){
          ost.loop();
      }
   
    public void HPBAR1(){
         int h1=p1.getHP();
                 if(h1>=940)
                   HB1=HpBarP1[1].getImage();
                else if(h1>=880)
                    HB1=HpBarP1[2].getImage();
                else if(h1>=820)
                    HB1=HpBarP1[3].getImage();
                else if(h1>=760)
                    HB1=HpBarP1[4].getImage();
                else if(h1>=700)
                     HB1=HpBarP1[5].getImage();
                else if(h1>=640)
                    HB1=HpBarP1[6].getImage();
                else if(h1>=580)
                    HB1=HpBarP1[7].getImage();
                else if(h1>=520)
                    HB1=HpBarP1[8].getImage();
                else if(h1>=460)
                    HB1=HpBarP1[9].getImage();
                else if(h1>=400)
                    HB1=HpBarP1[10].getImage();
                else if(h1>=340)
                    HB1=HpBarP1[11].getImage();
                else if(h1>=280)
                     HB1=HpBarP1[12].getImage();
                else if(h1>=220)
                    HB1=HpBarP1[13].getImage();
                else if(h1>=160)
                    HB1=HpBarP1[14].getImage();
                else if(h1>=100)
                    HB1=HpBarP1[15].getImage();
                else if(h1>=40)
                    HB1=HpBarP1[16].getImage();
                else if(h1==0)
                   HB1=HpBarP1[17].getImage();
     }
     
     public void HPBAR2(){
         int h2=p2.getHP();
                 if(h2>=940)
                   HB2=HpBarP2[1].getImage();
                else if(h2>=880)
                    HB2=HpBarP2[2].getImage();
                else if(h2>=820)
                    HB2=HpBarP2[3].getImage();
                else if(h2>=760)
                    HB2=HpBarP2[4].getImage();
                else if(h2>=700)
                     HB2=HpBarP2[5].getImage();
                else if(h2>=640)
                    HB2=HpBarP2[6].getImage();
                else if(h2>=580)
                    HB2=HpBarP2[7].getImage();
                else if(h2>=520)
                    HB2=HpBarP2[8].getImage();
                else if(h2>=460)
                    HB2=HpBarP2[9].getImage();
                else if(h2>=400)
                    HB2=HpBarP2[10].getImage();
                else if(h2>=340)
                    HB2=HpBarP2[11].getImage();
                else if(h2>=280)
                     HB2=HpBarP2[12].getImage();
                else if(h2>=220)
                    HB2=HpBarP2[13].getImage();
                else if(h2>=160)
                    HB2=HpBarP2[14].getImage();
                else if(h2>=100)
                    HB2=HpBarP2[15].getImage();
                else if(h2>=40)
                    HB2=HpBarP2[16].getImage();
                else if(h2==0)
                   HB2=HpBarP2[17].getImage();
     }
     
      public Image getImageHpBar1(){
          
          return HB1; 
     }
      
      public Image getImageHpBar2(){
          
          return HB2; 
     }
    
       public void Timer(){
         
          batteltime = new Timer(1000,new ActionListener(){
             
             public void actionPerformed(ActionEvent e) {
                 
                  if(sec<10)
                  timer.setText("0"+min+" : 0"+sec);
                 
                      else
                  timer.setText("0"+min+" : "+sec);
                 
                  if(sec==0 ){
                     sec=60;
                     min--;
                     if(min<0){
                     min=0;
                     sec=0;
                     batteltime.stop();
                     }
                  }
                  
                  if(sec == 0&& min==0){
                         if(p1.getHP()==p2.getHP()){
                       JOptionPane.showMessageDialog(null,"Tie", "Time's up", JOptionPane.INFORMATION_MESSAGE);
                                    flying.stop();

                     gameover.start();
                        ost.stop();
                       time.stop();
  
                     }
                     
                     if(p1.getHP()>p2.getHP()){
                        JOptionPane.showMessageDialog(null,"Player 1 is the winer", "Time's up", JOptionPane.INFORMATION_MESSAGE);
                          p2.setWin(true);            
                        flying.stop();

                    gameover.start();
                     ost.stop();
                        time.stop();

                     }
                     if(p2.getHP()>p1.getHP()){
                        JOptionPane.showMessageDialog(null,"Player 2 is the winer", "Time's up", JOptionPane.INFORMATION_MESSAGE);
                          p2.setWin(true);           
                        flying.stop();

                     gameover.start();
                      ost.stop();
                        time.stop();

                     }}
                  
                   sec--;
                  
                 }

         });
         batteltime.start();
   
     }
       
       public void Stop() {
           ost.stop();
       batteltime.stop();
       time.stop();
       
       }
       
          public Image gethappy(){
          
          return happy; 
     }
      
       public int getHX(){
        return hx;
        
    }
    
    public int getHY(){
        return hy;
    }
    
     public void flying(){
         
         flying=new Timer(20,new ActionListener(){
         public void actionPerformed(ActionEvent ae)  {
          flyCont++;
         
            if(flyCont>30)
            flyCont=0;
            
        if(flyCont!=0){
       if(flyCont<10)
            flyIndex=0;
       else if(flyCont<20)
            flyIndex=1;
       else if(flyCont<30){
            flyIndex=2;
               

            }}
   
         if(aboutFace==faceL){
                   happy=flyL[flyIndex].getImage();
                   if(hx>-22)
                    hx--;
                   else
                   aboutFace=0;
                            }
                    if(aboutFace==faceR){
                 happy=flyR[flyIndex].getImage();
                 if(hx<1090)
                    hx++;
                 else
                   aboutFace=1;}
    
         }});
         flying.start();
          }
     

      
    class MultiKey extends KeyAdapter{
        
        
         public void keyPressed(KeyEvent p){
             p2.keyPressed(p);
             p1.keyPressed(p);

          
         }
        
         public void keyReleased(KeyEvent r){
          p2.keyReleased(r);
          p1.keyReleased(r);

                

            }
            
        }
    
}
