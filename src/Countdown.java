
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Countdown extends JFrame{
    private final static int NUMBER_OF_SLIDES = 4;
     private final static int SHOW_TIME_PER_SLIDE = 1500;
     private static final int TIME_VISIBLE = 7500;
     private int current = 3;
     private JLabel imageLabel = new JLabel();

     public Countdown() {
         imageLabel.setIcon(new ImageIcon("./images/number_3.png"));
         new Timer(SHOW_TIME_PER_SLIDE,new Listener()).start();
         add(imageLabel);
          
        setTitle("GET READY!");
        setSize(500,500);
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
         new Timer(TIME_VISIBLE, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                    }
                }).start();
         setVisible(true);
         
         
         
     }
         public class Listener implements ActionListener{
             public void actionPerformed(ActionEvent event)
             {
                 if(current >=0) {
                     current--;
                     imageLabel.setIcon(new ImageIcon("./images/number_" + current + ".png"));

                 }
                 
             }         
         }
}
 
     