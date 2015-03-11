import java.util.ArrayList;

/**
 * ScoreKeeper is part of implementation of the "Race Car" program.
 * It keep tracks of the time scores of each car in every race, and stores them to be display.
 * It also contains methods to decide and rank the winner of the race.
 *
 * Created by Catherine Huang on 3/1/15.
 *
 * update 3/10/15.
 */
public class ScoreKeeper {

    //variables

    //storing the scores
    private ArrayList<int[]> scorePerRaceList;
    private ArrayList<Integer> finalRankList;
    private int[] carSpeeds;
    private String[] carNameList;
    private String[] trackNameList;
    private int[] trackLengthList;
//    private Car[] cars;
//    private Track[] tracks;

    /**
     * Constructor
     */
    public ScoreKeeper(int numberOfCar, int numberOfTracks) {
        //initialize variables
        scorePerRaceList = new ArrayList<int[]>();
        finalRankList = new ArrayList<Integer>();
        carSpeeds = new int[numberOfCar];
        carNameList = new String[numberOfCar];
        trackNameList = new String[numberOfTracks];
        trackLengthList = new int[numberOfTracks];


    }

    public void setCarSpeeds(int[] speed){ this.carSpeeds = speed; }

    public void setTrackName(String[] name) { this.trackNameList = name; }

    public void setCarNames(String[] name) { this.carNameList = name; }

    public void setTrackLength(int[] length){ this.trackLengthList = length; }

    /**
     * adding all scores in 1 race into the scorePerRaceList
     * @param score: int[]
     */
    public void setRaceScores(int[] score) {

        scorePerRaceList.add(score);
    }

    /**
     * returns all the scores
     * @return String
     */
    public String getAllRaceScores(){
        String s = "";
        int i=0;
        for(int[] race: scorePerRaceList) {
            s += trackNameList[i]+":\n";
            for(int j=0; j<race.length;j++) {
                s += carNameList[j] + " Time: " + Integer.toString(race[j]) + " hours.\n";
            }
            i++;
        }

        return s;
    }//end of getAllRaceScores

    /**
     * calculates every car's time in every race
     */
    public void calculateRaceTime(){

        for(int l: trackLengthList) {
            int i = 0;
            int[] tempTimeList = new int[carSpeeds.length];

            for(int s: carSpeeds) {
                int tempTime = l/s;
                tempTimeList[i] = tempTime;
                i++;
            }
            scorePerRaceList.add(tempTimeList);
        }
    }//end of calculateRaceTime

    /**
     * returns all the scores of 1 car
     * @return String
     * @param i
     */
    public String getSingleCarScores(int i){
        String s = carNameList[i] +":\n";

        //check all race scores
        for(int r = 0; r < scorePerRaceList.size();r++) {
            int[] race = scorePerRaceList.get(r);
            //if the car exist
            s += "Race at " + trackNameList[r] + " Time: " + Integer.toString(race[i]) + " hours\n";

        }

        return s;
    }//end of getSingleCarScores

    /**
     * calculate total time of 1 car
     * @param i
     */
    public int getTotalScorePerCar(int i) {
        int totalTemp = 0;

        for(int r = 0; r < scorePerRaceList.size();r++) {
            int[] race = scorePerRaceList.get(r);
            //if the car exist
            totalTemp += race[i];

        }

        return totalTemp;

    }//end of getTotalScorePerCar

    /**
     * set the final score list
     */
    public void setFinalRankList(){
        int tempFinal = 0;
        //for every car
        for(int t=0; t < carNameList.length;t++){
            tempFinal = getTotalScorePerCar(t);
            finalRankList.add(tempFinal);
        }

    }//end of setFinalRankList

    /**
     * get the final scores
     * @return String
     */
    public String getFinalRankList(){
        String temp = "";
        for(int i = 0; i<finalRankList.size();i++){
            temp += carNameList[i] + "'s total time: " + Integer.toString(finalRankList.get(i)) + " hours\n";
        }
        return temp;
    }//end of getFinalRankList

    /**
     * returns all the scores of 1 race
     * @return String
     * @param i: int
     */
    public String getSingleRaceScores(int i) {
        String s = "Race at " + trackNameList[i] + ":\n";

        if(i < scorePerRaceList.size()){
            int[] tempScores = scorePerRaceList.get(i);

            for(int a = 0; a < tempScores.length;a++) {
                s += carNameList[a] + ": "+ Integer.toString(tempScores[a]) + " hours.\n";
            }
        }
        else {
            new Exception("The race you're looking for doesn't exist, please check the race schedule.");
        }

        return s;
    }//end of getSingleRaceScores

    public String findWinner(){
        //create a temp int array to get the number of cars per race
        int a = carNameList.length;
        int min = finalRankList.get(0);
        int index = 0;
        for(int i = 0; i<a; i++){
            if(min > finalRankList.get(i)){
                min = finalRankList.get(i);
                index = i;
            }
        }

        return "The Winner is " + carNameList[index] + " with total time of " + finalRankList.get(index);

    }//end of findWinner


    //test
    public static void main(String[] args) {
        ScoreKeeper sk = new ScoreKeeper(4,4);
        String[] carNames = {"BRITISH MOTOR COMPANY", "FAST AND FURIOUS", "SCOOBY GANG", "SPEEDY CADDY"};
        String[] trackNames = {"Boston", "New York", "Philidelphia", "Washington D.C."};
        int[] speeds = {88,102,48,160};
        int[] lengths = {2000,3040,3948,1800};

        sk.setCarNames(carNames);
        sk.setTrackName(trackNames);
        sk.setCarSpeeds(speeds);
        sk.setTrackLength(lengths);
        sk.calculateRaceTime();
        sk.setFinalRankList();
//        System.out.print(sk.getSingleCarScores(3));
//        System.out.print(sk.getSingleRaceScores(1));
//        System.out.print(sk.getTotalScorePerCar(3));
        System.out.print(sk.getFinalRankList());
//        System.out.print("\n"+sk.getAllRaceScores());
//        System.out.print(sk.getAllRaceScores());
        System.out.print(sk.findWinner());
        Display d = new Display();
    }//end of test

}//End of ScoreKeeper.java
