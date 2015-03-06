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

    /**
     * Constructor
     */
    public ScoreKeeper() {
        scorePerRaceList = new ArrayList<int[]>();
        finalRankList = new ArrayList<Integer>();

    }

    /**
     * adding all scores in 1 race into the scorePerRaceList
     * @param score int[]
     */
    public void addRaceScores(int[] score) {
        scorePerRaceList.add(score);
    }

    /**
     * returns all the scores
     * @return String
     */
    public String getRaceScores(){
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
     * @return
     */
    public String getCarScores(int i){
        String s = "Car #"+ Integer.toString(i);

        for(int[] race: scorePerRaceList) {

                s += " Time: " + Integer.toString(race[i]) + "\n";

        }

        return s;
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
}//End of ScoreKeeper.java
