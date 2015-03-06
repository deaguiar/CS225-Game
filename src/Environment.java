import java.util.ArrayList;

/**
 * Created by catherinehuang on 3/1/15.
 */
public class Environment {

    //for keeping track of all the scores.
    private ScoreKeeper scoreKeeper;
    private int[] scores;

    public Environment(){
        scoreKeeper = new ScoreKeeper();

    }

    //Methods for calculating the times
    //gets the track length
    //gets every car's speed
    //calculate and store all the times in scores. and send it to ScoreKeeper
    public void scoresPerRace(){

    }

    /**
     * Set the Scores for current race
     * @return
     */
    public int[] getScores() {
        return scores;
    }

    /**
     * get the score of the current race
     * @param scores
     */
    public void setScores(int[] scores) {
        this.scores = scores;
    }
}
