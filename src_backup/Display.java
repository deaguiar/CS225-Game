
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.awt.image.BufferedImage;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;




public class Display extends JFrame{


    private JPanel right,left,center,south;
    private JButton start, stop,car1,car2,car3,car4;
    private JTextArea text1,text2;
    private TitledBorder title1,title2;
    private JLabel label,label2,label3,label4;
//    private BufferedImage image;
    private RaceDisplay rd;
//    private Environment env;
    private Car car;
    private ScoreKeeper sk = new ScoreKeeper(4,4);


    public Display() {

        super("CAR GAME");
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
        * Text area used to diaplay the results.
        ------------------------------------------*/
        text1 = new JTextArea("",20,20);
        text2 = new JTextArea();

    // ------------>car images to be used in the Car class<------------------
        ImageIcon img = new ImageIcon("./images/Car1-small.gif");
        ImageIcon img2 = new ImageIcon("./images/car2-small.gif");
        ImageIcon img3 = new ImageIcon("./images/car3-small.gif");
        ImageIcon img4 = new ImageIcon("./images/car4-small.gif");
        ImageIcon img5 = new ImageIcon("./images/flag 2.png");
        ImageIcon img6 = new ImageIcon("./images/flag1.png");


     /* ----------------------------------------------------
      * creates the buttons and adds the proper image to them
      --------------------------------------------------------*/
        car1 = new JButton("BRITISH MOTOR COMPANY",img);
        car2=new JButton("FAST AND FURIOUS",img2);
        car3=new JButton("SCOOBY GANG",img3);
        car4=new JButton("SPEEDY CADDY",img4);
        start=new JButton("START");
//        stop  = new JButton("STOP");



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

       text1 = new JTextArea(" ",10,30);
       text2 = new JTextArea("",10,30);
       right.add(text1);
       right.add(text2);
       text1.setLineWrap(true);
        text2.setLineWrap(true);

  /* ----------------------------------------------------
   * adds the buttons to the proper panels
   --------------------------------------------------------*/
       south.add(start);
//       south.add(stop);
       left.add(car1);
       left.add(car2);
       left.add(car3);
       left.add(car4);
   /* ----------------------------------------------------
   * adds the images
   --------------------------------------------------------*/

       label3=new JLabel(img6);
       label4 = new JLabel(img5);

        left.add(label3);
        center.add(label4);

    /* ----------------------------------------------------
    * adds the panels to the main Frame at proper location
     --------------------------------------------------------*/
        add(right,BorderLayout.EAST);
        add(left,BorderLayout.WEST);
        add(south,BorderLayout.SOUTH);
        add(center,BorderLayout.CENTER);


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

        public void actionPerformed(ActionEvent event){

//            env = new Environment();
            Countdown c = new Countdown();
            rd = new RaceDisplay();
            add(rd);
            revalidate();
            repaint();
        }
    }
//     /**
//     *
//     */
//    private class Stop implements ActionListener{
//        public void actionPerformed(ActionEvent event){
//           //method that starts race
//        }
//    }
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
//
//     public static void main(String[] args) {
//
//        Display d = new Display();
//
//   }

    /**
    * Creates the panel where the race cars are displayed
    */
    private class RaceDisplay extends JPanel implements ActionListener{

        private   Image img1,img2,img3,img4,img5;
        private JLabel l1;
        private int velX;
        private int x;
        private Timer tm;
        private Car car;
        private ScoreKeeper sk;
        private Display d;
        ArrayList<String>resultString = new ArrayList<String>();



        public RaceDisplay(){

            tm = new Timer(30,this);
            x=0;
            velX=4;
            resultString.add("Works");
            resultString.add("Works1");
            resultString.add("Works2");

        }

        public void paintComponent(Graphics g){

            super.paintComponent(g);
            ImageIcon car1 = new ImageIcon("./images/Car1-small.gif");
            ImageIcon car2 = new ImageIcon("./images/car2-small.gif");
            ImageIcon car3 = new ImageIcon("./images/car3-small.gif");
            ImageIcon car4 = new ImageIcon("./images/car4-small.gif");
            ImageIcon imgLine = new ImageIcon("./images/finish_line.png");


            img1 = car1.getImage();
            img2 = car2.getImage();
            img3= car3.getImage();
            img4= car4.getImage();
            img5 = imgLine.getImage();


            g.drawImage(img1,x,100,null);
            g.drawImage(img2,x,200,null);
            g.drawImage(img3,x,300,null);
            g.drawImage(img4,x,400,null);
            g.drawImage(img5,750,50,null);
            tm.start();

        }
        //makes the images move. They also stop for 3 sec when they reach 650
        public void actionPerformed(ActionEvent e) {

            x=x+velX;
            if(x>=650){
                x=0;
                x=x+velX; //<---------change this variable to accommodate the car's speeds.

                for(int i=0;i<=resultString.size()-1;i++){
                    text1.setText(resultString.get(i));

                    System.out.println(resultString.get(i));
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
                }
                repaint();

            }

            repaint();
        }
    }



    //TO DO: add method for count down

}//End of Display.java
