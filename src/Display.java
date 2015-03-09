
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;




public class Display extends JFrame{
    
   
    private JPanel right,left,center,south;
    private JButton start, stop,car1,car2,car3,car4;
    private JTextArea text1,text2;
    private TitledBorder title1,title2;
    private JLabel label,label2;
    private BufferedImage image;
    private RaceDisplay rd;
   

    
    public Display() {
        
        super("CAR GAME");
        rd = new RaceDisplay();
        
   /* ---------------------------------
    *            BOARD PANELS
    -----------------------------------*/
        //right panel uses a different layout
        right = new JPanel();
        right.setLayout(new BoxLayout(right, BoxLayout.PAGE_AXIS));
        right.setBackground(Color.GRAY);
       
         //center panel uses default layout
        center = new JPanel();
        
      
        //left panel uses a different layout
        left = new JPanel();
        left.setLayout(new BoxLayout(left, BoxLayout.PAGE_AXIS));
        left.setBackground(Color.GRAY);
        //south panel
        south = new JPanel();
        south.setBackground(Color.GRAY);
        
       /* ---------------------------------------
        * Text area used to diaply the results.
        ------------------------------------------*/  
        text1 = new JTextArea();
        text2 = new JTextArea();
        
    // ------------>car images to be used in the Car class<------------------
        ImageIcon img = new ImageIcon("./images/Car1-small.gif");
        ImageIcon img2 = new ImageIcon("./images/car2-small.gif");
        ImageIcon img3 = new ImageIcon("./images/car3-small.gif");
        ImageIcon img4 = new ImageIcon("./images/car4-small.gif");
    

     /* ----------------------------------------------------
      * creates the buttons and adds the proper image to them 
      --------------------------------------------------------*/   
        car1 = new JButton("BRITISH MOTOR COMPANY",img);
        car2=new JButton("FAST AND FURIOUS",img2);
        car3=new JButton("SCOOBY GANG",img3);
        car4=new JButton("SPEEDY CADDY",img4);
        start=new JButton("START");
        stop  = new JButton("STOP");
  
    /* ----------------------------------------------------
     * creates the title border and adds them to panels 
      --------------------------------------------------------*/   
       title1 = new TitledBorder("RESULTS");
       title2 = new TitledBorder("CHOOSE YOUR RACER!");
       //adds the title borders to the Panels.
       right.setBorder(title1);
       left.setBorder(title2);
   
      
   /* ----------------------------------------------------
    * This TextArea is added to the right Panel and it where
    * the result will be displayed
    --------------------------------------------------------*/    
       
       text1 = new JTextArea(" ",100,30);
       right.add(text1); 
       text1.setLineWrap(true);
  
  /* ----------------------------------------------------
   * adds the buttons to the proper panels 
   --------------------------------------------------------*/
       south.add(start);
       south.add(stop);
       left.add(car1);
       left.add(car2);
       left.add(car3);
       left.add(car4);
       
    
    /* ----------------------------------------------------
    * adds the panels to the main Frame at proper location
     --------------------------------------------------------*/
        add(right,BorderLayout.EAST);
        add(left,BorderLayout.WEST);
        add(south,BorderLayout.SOUTH);
        add(BorderLayout.CENTER,new RaceDisplay());
       
  /* -------------------------------------------------
   *        Gives actions to the buttons
   ---------------------------------------------------- */
        car1.addActionListener(new Car1Button());
        car2.addActionListener(new Car2Button());
        car3.addActionListener(new Car3Button());
        car4.addActionListener(new Car4Button()); 
        start.addActionListener(new Start());        

        
   /* ----------------------------------------------------
    *           sets up the main frame's components 
    --------------------------------------------------------*/
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1900,700);
        setVisible(true);
 
    }//end of constructor
    
    
     /**
     * 
     */
    private class Start implements ActionListener{
        ImageIcon imgTrack;
        public void actionPerformed(ActionEvent event){
            //imgTrack = new ImageIcon("./images/track1.jpg");
            
            
            
            
        }  
    }
     /**
     * 
     */
    private class Stop implements ActionListener{
        public void actionPerformed(ActionEvent event){
           //method that starts race
        }  
    }
     /**
     * 
     */
    private class Car1Button implements ActionListener{
        private ImageIcon img;
       
        public void actionPerformed(ActionEvent event){
           
              img = new ImageIcon("./images/car1-big.png");
              label= new JLabel(img);
              JOptionPane.showMessageDialog(null, label,"YOUR CAR", JOptionPane.PLAIN_MESSAGE,null);
           }
        
           
    }
      /**
     * 
     */
    private class Car2Button implements ActionListener{
        private ImageIcon img;

        public void actionPerformed(ActionEvent event){
           
              img = new ImageIcon("./images/car2-big.png");
              label= new JLabel(img);
              JOptionPane.showMessageDialog(null, label,"YOUR CAR", JOptionPane.PLAIN_MESSAGE,null);
           }
        
           
    }
       /**
     * 
     */
    private class Car3Button implements ActionListener{
        private ImageIcon img;

        public void actionPerformed(ActionEvent event){
           
              img = new ImageIcon("./images/car3-big.png");
              label= new JLabel(img);
              JOptionPane.showMessageDialog(null, label,"YOUR CAR", JOptionPane.PLAIN_MESSAGE,null);
           }
        
           
    }
       /**
     * 
     */
    private class Car4Button implements ActionListener{
        private ImageIcon img;

        public void actionPerformed(ActionEvent event){
           
              img = new ImageIcon("./images/car4-big.png");
              label= new JLabel(img);
              JOptionPane.showMessageDialog(null, label,"YOUR CAR", JOptionPane.PLAIN_MESSAGE,null);
           }
        
           
    }
    
     public static void main(String[] args) {
        Display d = new Display(); 
        RaceDisplay rd = new RaceDisplay();
      
               
   }



    //TO DO: add method for count down

}
