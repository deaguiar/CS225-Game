
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class RaceDisplay extends JPanel implements ActionListener{
    
   private   Image img1,img2,img3,img4;
   private int velX;
   private int x,y;
   private Timer tm;

   public RaceDisplay(){

        tm = new Timer(30,this);
        x=0;
        velX=2;
    }
    
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        ImageIcon car1 = new ImageIcon("./images/Car1-small.gif");
        ImageIcon car2 = new ImageIcon("./images/car2-small.gif");
        ImageIcon car3 = new ImageIcon("./images/car3-small.gif");
        ImageIcon car4 = new ImageIcon("./images/car4-small.gif");
        
        img1 = car1.getImage();        
        img2 = car2.getImage();
        img3= car3.getImage();
        img4= car4.getImage();
        
        
        
        g.drawImage(img1,x,100,null);
        g.drawImage(img2,x,200,null);
        g.drawImage(img3,x,300,null);
        g.drawImage(img4,x,400,null);
        tm.start();
        
    }

    public void actionPerformed(ActionEvent e) {
       x=x+velX;
       if(x>=550){
           x=0;
           x=x+velX;
           repaint();
       }
       repaint();
    }


}//End of RaceDisplay.java