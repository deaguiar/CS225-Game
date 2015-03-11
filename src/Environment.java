import java.util.Random;
import java.util.ArrayList;

/**
 * Created by catherine huang on 3/1/15.
 *
 * @modified by Sean Johnston
 * @3/7/2015
 * 
 */
 
public class Environment {

    private Car[] garage;
    private Track[] tracks;
    private String[] carNames = {"BRITISH MOTOR COMPANY", "FAST AND FURIOUS", "SCOOBY GANG", "SPEEDY CADDY"};
    private String[] trackNames = {"Boston", "New York", "Philadelphia", "Washington D.C."};
    private Random random;
    private ScoreKeeper sk;
    
    //Car and track data
    ArrayList<int[]> carSpeeds;
    int[] trackLengths;
    
    Display display;

    
      
    
    public Environment(){
        random = new Random();

        populateGarage();
        populateTracks();


        sk = new ScoreKeeper(4,4);
        
//
        sk.setCarNames(carNames);
        sk.setTrackName(trackNames);
        sk.setCarSpeeds(carSpeeds);
        sk.setTrackName(trackNames);

        sk.calculateRaceTime();
        //display = new Display();
        //display.setSpeeds(carSpeeds);
        
        //display.beginRace();


    }


    
     /**
      * Create the cars to be put into Tracks
      */
   
    public void populateGarage()
    {

        garage = new Car[4];
        carSpeeds = new ArrayList<int[]>();

        int randomSpeed;
        Car car;

        for(int h=0; h < trackNames.length;h++) {
            int[] tempSpeed = new int[carNames.length];
            for (int i = 0; i < garage.length; i++) {
                //Get a random number between 5 and 10 to use as the random speed of a car
                randomSpeed = random.nextInt(10);
                if (randomSpeed < 5) {
                    randomSpeed = randomSpeed + 5;
                }

                car = new Car(carNames[i], randomSpeed);
                garage[i] = car;
                tempSpeed[i] = randomSpeed;


                System.out.println(car.getName() + " has speed " + car.getSpeed());


            }
            carSpeeds.add(tempSpeed);
        }


        System.out.println("\n");
    }

    
      
    /**
       * Create the Tracks for race
       */
    
    public void populateTracks()
    {
        tracks = new Track[4];
        trackLengths = new int[tracks.length];
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
            trackLengths[i] = randomLength;
            tracks[i] = track;

//            System.out.println( track.getName() +" has length "+ track.getLength() );
        }

        System.out.println("\n");
    }

    public String getCarName(int i){
        return carNames[i];
    }

    public int getSpeedOfCar(int race,int car){
        int[] tempList;
        tempList = carSpeeds.get(race);
        int tempSpeed = tempList[car];
        return tempSpeed;
    }

    private String speedsPrintOut() {
        String s = "";
        int i = 0;
        for(int[] l: carSpeeds) {

            s += "Race "+ Integer.toString(i) + ":\n";
            for(int sp: l){
                s += "Car Speed: " + Integer.toString(sp) + "  ";
            }
            i++;
            s += "\n";
        }

        return s;
    }


    public Car[] getCar(){
        return garage;
    }

//    //test
//    public static void main(String[] args) {
//        Environment env = new Environment();
//
//        System.out.print(env.getCarName(3));
//        System.out.print(env.speedsPrintOut());
//    }
}//End of Environment.java
