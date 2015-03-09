import java.util.ArrayList;

/**
 * ScoreKeeper is part of implementation of the "Race Car" program.
 * It keep tracks of the time scores of each car in every race, and stores them to be display.
 * It also contains methods to decide and rank the winner of the race.
 *
 * Created by catherine huang on 3/1/15.
 */
public class ScoreKeeper {

    //variables

    //storing the scores
    private ArrayList<int[]> scorePerRaceList;
    private ArrayList<Integer> finalRankList;
    private int[] carSpeeds;
    private String[] carNames;
    private String[] trackNames;

    //

    /**
     * Constructor
     */
    public ScoreKeeper() {
        scorePerRaceList = new ArrayList<int[]>();
        finalRankList = new ArrayList<Integer>();

    }

    /**
     * set the speeds of all the cars
     * @param speed: int[]
     */
    public void setCarSpeeds(int[] speed){
        this.carSpeeds = speed;
    }

    /**
     * adding all scores in 1 race into the scorePerRaceList
     * @param score: int[]
     */
    public void setRaceScores(int[] score) {

        scorePerRaceList.add(score);
    }

    /**
     * returns all the scores
     * @return String: all time scores
     */
    public String getAllRaceScores(){
        String s = "";

        for(int[] race: scorePerRaceList) {
            for(int i=0; i<race.length;i++) {
                s += "Car #"+ Integer.toString(i) + " Time: " + Integer.toString(race[i]) + "\n";
            }
        }

        return s;
    }

    /**
     * returns all the scores of 1 car
     * @return String
     * @param i: int
     */
    public String getSingleCarScores(int i){
        String s = "Car #"+ Integer.toString(i)+"\n";

        //check all race scores
        for(int[] race: scorePerRaceList) {
            //if the car exist
            s += " Time: " + Integer.toString(race[i]) + "\n";

        }

        return s;
    }

    /**
     * returns all the scores of 1 race
     * @return String
     * @param i: int
     */
    public String getSingleRaceScores(int i) {
        String s = "Race " + Integer.toString(i) + ":\n";

        if(i< scorePerRaceList.size()){
            int[] tempScores = scorePerRaceList.get(i);

            for(int score: tempScores) {
                s += Integer.toString(score) + "\n";
            }
        }
        else {
            new Exception("The race you're looking for doesn't exist, please check the race schedule.");
        }

        return s;
    }

    public void findWinner(){
        //create a temp int array to get the number of cars per race
        int[] tempintList = scorePerRaceList.get(0);
        //
        for(int i = 0; i< tempintList.length;i++) {

        }

    }

    //Getter and Setter

    /**
     * Return the list contains scores of every cars in all races
     * @return ArrayList
     */
    public ArrayList<int[]> getScorePerRaceList() {
        return scorePerRaceList;
    }

    /**
     * Set the list of scores of every cars in all races
     * @param scorePerRaceList
     */
    public void setScorePerRaceList(ArrayList<int[]> scorePerRaceList) {
        this.scorePerRaceList = scorePerRaceList;
    }

    /**
     * Returns the calculated ranking list
     * @return
     */
    public ArrayList<Integer> getFinalRankList() {
        return finalRankList;
    }

    /**
     * Set the calculated ranking list
     * @param finalRankList
     */
    public void setFinalRankList(ArrayList<Integer> finalRankList) {
        this.finalRankList = finalRankList;
    }

    public static void main(String[] args) {
        ScoreKeeper sk = new ScoreKeeper();
        int[] r1_test = {3,5,6,9};
        int[] r2_test = {8,22,13,19};
        int[] r3_test = {39,23,103,54};

        sk.setRaceScores(r1_test);
        sk.setRaceScores(r2_test);
        sk.setRaceScores(r3_test);
        System.out.print(sk.getSingleCarScores(3));
        System.out.print(sk.getSingleRaceScores(1));

        System.out.print(sk.getAllRaceScores());



    }
}//End of ScoreKeeper.java
