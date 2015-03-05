import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * Created by catherinehuang on 3/1/15.
 */
public class TimeTracker implements ActionListener {


    // Game Timer
    private Timer timer;
    private final byte timerDelay = 10;

    private DecimalFormat timeFormatter = new DecimalFormat("00");

    private byte timeRemainingSeconds;
    private byte timeRemainingMilliseconds;
    private byte maxMilliseconds = 99;
    private byte minMilliseconds = 0;
//
<<<<<<< HEAD
    private byte startTime = 0;
    private byte endTime;
=======
    private byte maxSeconds = 60;
>>>>>>> 02a8c19e58e25f38bb7c759a0f0a9e1eafccaefc

    // Countdown to Starting Game
    private Timer startTimer;
    private int startTimerDelay = 1;
<<<<<<< HEAD
    private int countDownToStart = 5000;
=======
    private int initialMilliSecondsToStart = 5000;
>>>>>>> 02a8c19e58e25f38bb7c759a0f0a9e1eafccaefc
    private int milliSecondsToStart;

    // Time Over Mechanics
    private Timer endTimer;
    private final byte endTimerDelay = 100;
    private int secondsSinceStartOfEndTimer = 0;

    //Layout
    private JPanel topPanel;
    private JPanel statusContainer;
    private JLabel statusLabel;
    private JLabel timeRemainingLabel;
    private JPanel gamePanel = new JPanel();
    private String currentStatus;
    private JFrame frame;

    private Font labelFont = new Font("serif", Font.BOLD, 12);
    private Font gameOverFont = new Font("ariel", Font.ITALIC, 10);

    //Game Condition
    private boolean gameOnMode;
    private boolean gameNotRunning;

    public TimeTracker(){
        //build frame
        frame = new JFrame("Timer test");

        //main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        //Top Panel build
        topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setBackground(Color.LIGHT_GRAY);

        statusContainer = new JPanel();
        statusContainer.setLayout(new BorderLayout());
        statusContainer.setBackground(Color.LIGHT_GRAY);

        statusLabel = new JLabel("   ");
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        statusLabel.setFont(labelFont);
        statusLabel.setBackground(Color.GRAY);

        timeRemainingLabel = new JLabel("Limit : " + timeRemainingSeconds + "." + timeFormatter.format(timeRemainingMilliseconds));
        timeRemainingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeRemainingLabel.setFont(labelFont);

        statusContainer.add(statusLabel);
        topPanel.add(statusContainer, BorderLayout.NORTH);
        topPanel.add(timeRemainingLabel);

        mainPanel.add(topPanel,BorderLayout.NORTH);
        frame.add(mainPanel);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent f)
    {
        gamePanel.setFocusable(true);


        if (f.getSource() == startTimer)
        {


            if (milliSecondsToStart == 5000)
            {

            }
            else if (milliSecondsToStart > 3000)
            {
                gamePanel.repaint();

                statusContainer.setBackground(Color.BLACK);
                statusLabel.setForeground(Color.WHITE);

                currentStatus = "Race is about to start!";
            }
            else if (milliSecondsToStart >= 2000)
            {
                statusContainer.setBackground(Color.RED);
                statusLabel.setForeground(Color.WHITE);

                currentStatus = "3";
            }
            else if (milliSecondsToStart >= 1000)
            {
                statusContainer.setBackground(Color.ORANGE);
                statusLabel.setForeground(Color.BLACK);

                currentStatus = "2";
            }
            else if (milliSecondsToStart >= 0)
            {
                statusContainer.setBackground(Color.YELLOW);
                statusLabel.setForeground(Color.BLACK);

                currentStatus = "1";
            }
            else if (milliSecondsToStart <= 0 && milliSecondsToStart > -2000)
            {
                statusContainer.setBackground(Color.GREEN);
                statusLabel.setForeground(Color.BLACK);

                currentStatus = "GO!";

                if (milliSecondsToStart == 0)
                {

                    gamePanel.repaint();
                    gamePanel.setFocusable(true);
                    gamePanel.requestFocusInWindow();

                }
                timer.start();


            }
            else
            {
                startTimer.stop();
                statusLabel.setFont(labelFont);
                statusContainer.setBackground(Color.LIGHT_GRAY);

                currentStatus = " ";
            }


            milliSecondsToStart -= 10;
        }




        else if (f.getSource() == endTimer)
        {
//            helpButton.setEnabled(false);
//            aboutButton.setEnabled(false);

            secondsSinceStartOfEndTimer += endTimer.getDelay();

            if     (secondsSinceStartOfEndTimer == 3000)
            {
            }
            if (secondsSinceStartOfEndTimer == 10000)
            {
                statusLabel.setFont(gameOverFont);
                currentStatus = "Race Finish";
            }
            else if (secondsSinceStartOfEndTimer == 15000)
            {
                secondsSinceStartOfEndTimer = 0;
                gameOnMode = false;
                gameNotRunning = true;
                endTimer.stop();

                currentStatus = " ";
                statusLabel.setFont(labelFont);
                statusContainer.setBackground(Color.LIGHT_GRAY);
//
//                helpButton.setEnabled(true);
//                aboutButton.setEnabled(true);
            }
        }


        statusLabel.setText(currentStatus);
    }

    /**
     * tester
     */
    public static void main(String[] args) {
        TimeTracker test = new TimeTracker();
    }

}//End of TimeTracker.java
