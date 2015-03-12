import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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


    private JPanel right,left,center,south,panel;
    private JButton start,car1,car2,car3,car4;
    private JTextArea text1,text2,text3,text4;
    private TitledBorder title1,title2;
    private JLabel label,label2,label3,label4;
    private Environment env = new Environment();
    private RaceDisplay rd;
    private Car car;
    private ScoreKeeper sk = env.getSK();

    //check if user selected a car.
    private boolean userSelect = false;
    private String userCar;

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

        text1 = new JTextArea("",10,30);
        text2 = new JTextArea("",10,30);
        //text1.setText("");
        right.add(text1);
        right.add(text2);
        text1.setLineWrap(true);

  /* ----------------------------------------------------
   * adds the buttons to the proper panels
   --------------------------------------------------------*/
        south.add(start);
        left.add(car1);
        left.add(car2);
        left.add(car3);
        left.add(car4);
   /* ----------------------------------------------------
   * adds the images of flags
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

        public void actionPerformed(ActionEvent event) {

            if (userSelect) {
//                System.out.print(userCar);
                Countdown c = new Countdown();
                rd = new RaceDisplay(sk);
                add(rd);
                revalidate();
                repaint();
            }
            else {
                JOptionPane.showMessageDialog(null, "You need to choose a car to start the game.", "Error", JOptionPane.WARNING_MESSAGE);
//                System.out.print(userCar);
            }
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
            int car = JOptionPane.showConfirmDialog(null, label,"YOUR CAR", JOptionPane.INFORMATION_MESSAGE,JOptionPane.YES_NO_OPTION);
            if(car == JOptionPane.YES_OPTION) {
                userSelect = true;
                userCar = env.getCarName(0);
//                System.out.print(userCar);
            }
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
            int car = JOptionPane.showConfirmDialog(null, label,"YOUR CAR", JOptionPane.INFORMATION_MESSAGE,JOptionPane.YES_NO_OPTION);
            if(car == JOptionPane.YES_OPTION) {
                userSelect = true;
                userCar = env.getCarName(1);
            }

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
            int car = JOptionPane.showConfirmDialog(null, label,"YOUR CAR", JOptionPane.PLAIN_MESSAGE,JOptionPane.YES_NO_OPTION);
            if(car == JOptionPane.YES_OPTION) {
                userSelect = true;
                userCar = env.getCarName(2);
            }
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
            int car = JOptionPane.showConfirmDialog(null, label,"YOUR CAR", JOptionPane.PLAIN_MESSAGE,JOptionPane.YES_NO_OPTION);
            if(car == JOptionPane.YES_OPTION) {
                userSelect = true;
                userCar = env.getCarName(3);
            }
        }
    }



    /*
     * Creates the panel where the race cars are displayed
    */
    private class RaceDisplay extends JPanel implements ActionListener{

        private   Image img1,img2,img3,img4,img5,img6,img7,bk1,bk2,bk3,bk4;
        private JLabel l1;
        private int velX1,velX2,velX3,velX4;
        private int x1,x2,x3,x4;
        private Timer tm;
        private Car car;
        private ScoreKeeper sk;
        private Display d;
        ArrayList<String>resultString = new ArrayList<String>();
        int count = 0;



        public RaceDisplay(ScoreKeeper sk){
            this.sk = sk;

            tm = new Timer(30,this);
            x1=0;
            x2=0;
            x3=0;
            x4=0;
            //change the first parameter with some sort of loop
            velX1=env.getSpeedOfCar(0,0);
            velX2=env.getSpeedOfCar(0,1);
            velX3=env.getSpeedOfCar(0,2);
            velX4=env.getSpeedOfCar(0,3);

        }

        public void paintComponent(Graphics g){

            super.paintComponent(g);
            ImageIcon car1 = new ImageIcon("./images/Car1-small.gif");
            ImageIcon car2 = new ImageIcon("./images/car2-small.gif");
            ImageIcon car3 = new ImageIcon("./images/car3-small.gif");
            ImageIcon car4 = new ImageIcon("./images/car4-small.gif");
            ImageIcon imgLine = new ImageIcon("./images/finish_line.png");
            ImageIcon imgLine2 = new ImageIcon("./images/start_line.gif");
            ImageIcon imgBg = new ImageIcon("./images/starting_line.png");
            ImageIcon bk1img = new ImageIcon("./images/Boston.png");
            ImageIcon bk2img = new ImageIcon("./images/DC.png");
            ImageIcon bk3img = new ImageIcon("./images/nyc.png");
            ImageIcon bk4img = new ImageIcon("./images/Philly.png");

            img1 = car1.getImage();
            img2 = car2.getImage();
            img3= car3.getImage();
            img4= car4.getImage();
            img5 = imgLine.getImage();
            img6= imgBg.getImage();
            img7 = imgLine2.getImage();
            bk1 = bk1img.getImage();
            bk2 = bk2img.getImage();
            bk3 = bk3img.getImage();
            bk4 = bk4img.getImage();



            g.drawImage(img6, 0, 0, null);
            g.drawImage(img1,x1,100,null);
            g.drawImage(img2,x2,200,null);
            g.drawImage(img3,x3,300,null);
            g.drawImage(img4,x4,400,null);
            g.drawImage(img5,750,50,null);


            tm.start();

        }
        //makes the imgaes move. They also stop for 3 sec when they rech 650
        public void actionPerformed(ActionEvent e) {
            if(count<4) {
                x1 = x1 + velX1;
                x2 = x2 + velX2;
                x3 = x3 + velX3;
                x4 = x4 + velX4;
                repaint();


                if (x1 >= 650) {
                    velX1 = 0;
                }
                if (x2 >= 650) {
                    velX2 = 0;
                }
                if (x3 >= 650) {
                    velX3 = 0;
                }
                if (x4 >= 650) {
                    velX4 = 0;
                }
                if (x1 >= 650 && x2 >= 650 && x3 >= 650 && x4 >= 650) {//<---works

                    count++;
                    text1.append(sk.getSingleRaceScores(0));

                    try {
                        Thread.sleep(2500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    x1 = 0;
                    x2 = 0;
                    x3 = 0;
                    x4 = 0;
                    repaint();
                    //change the first value with an loop
                    velX1 = env.getSpeedOfCar(0, 0);
                    velX2 = env.getSpeedOfCar(0, 1);
                    velX3 = env.getSpeedOfCar(0, 2);
                    velX4 = env.getSpeedOfCar(0, 3);
                }
//                repaint();
            }
            else {
                text1.append(sk.findWinner());
            }
        }
    }
}

//}//End of Display.java
