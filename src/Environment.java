import java.util.Random;
import java.util.ArrayList;

/**
 * Created by catherine huang on 3/1/15.
 *
 * @modified by Sean Johnston
 * @3/7/2015
 */
public class Environment {

    private Car[] garage;
    private Track[] tracks;
    private String[] carNames = {"BRITISH MOTOR COMPANY", "FAST AND FURIOUS", "SCOOBY GANG", "SPEEDY CADDY"};
    private String[] trackNames = {"Boston", "New York", "Philidelphia", "Washington D.C."};
    private Random random;
    private ScoreKeeper sk;

    /**
     * Constructor
     */
    public Environment(){
        random = new Random();

        populateGarage();
        populateTracks();

        sk = new ScoreKeeper();

        beginRace();

        calculateWinner();

    }


    /**
     * Create the cars to be put into Tracks
     */
    public void populateGarage()
    {
        garage = new Car[4];
        int randomSpeed;
        Car car;

        for(int i= 0; i < garage.length; i++)
        {
            //Get a random number between 5 and 10 to use as the random speed of a car
            randomSpeed = random.nextInt(10);
            if(randomSpeed < 5){
                randomSpeed = randomSpeed +5;
            }

            car = new Car(carNames[i], randomSpeed);
            garage[i] = car;

            System.out.println(car.getName() +" has speed "+ car.getSpeed());


        }

        System.out.println("\n");
    }

    /**
     * Create the Tracks for race
     */
    public void populateTracks()
    {
        tracks = new Track[4];
        int randomLength;
        Track track;

        for(int i= 0; i < tracks.length; i++)
        {
            //Get a random number between 60 and 100 to use as the length of a track
            randomLength = random.nextInt(100);
            if(randomLength < 60)
            {
                randomLength = randomLength + 60;
            }

            track = new Track(trackNames[i], randomLength);

            tracks[i] = track;

            System.out.println( track.getName() +" has length "+ track.getLength() );
        }

        System.out.println("\n");
    }

    /**
     * Place cars into Track
     * calculates the time for each car to finish the races.
     */
    public void beginRace()
    {
        int [] raceTimes = new int[garage.length];
        int newTime;
        Car car;

        for(Track track: tracks)
        {
            for(int i= 0; i < garage.length; i++)
            {
                car = garage[i];

                newTime = track.getLength() / car.getSpeed();

                raceTimes[i] = newTime;

                //needs to put the time into scorekeeper

                System.out.println(car.getName() + " raced " +track.getName()+ " in " +newTime+ " hours.");
            }

            System.out.println("\n");
            sk.addRaceScores(raceTimes);
        }
    }


    /**
     * Take all the times each car use to finish all races
     * then calculates the total time,
     * sort the time from lowest to highest for displaying the winners.
     */
    public void calculateWinner()
    {
        //taking the list of time scores from scorekeeper
        ArrayList<int[]> scoreList = sk.getScorePerRaceList();
        //temporary array to store the total times
        int[] timeTotals = new int[garage.length];
        int time;

        for(int[] timeArray: scoreList)
        {
            for(int i = 0; i < timeTotals.length; i++)
            {
                time = timeTotals[i] + timeArray[i];

                timeTotals[i] = time;
            }
        }


        //Print final results
        //isn't this going to be store in scorekeeper?
        Car car;
        for(int i= 0; i < timeTotals.length; i++)
        {
            car = garage[i];
            time = timeTotals[i];

            System.out.println( car.getName() +"'s total time was " +time);
        }
    }

}//End of Environment.java
