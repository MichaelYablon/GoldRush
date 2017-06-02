package score;

import objects.UserScore;

import java.util.ArrayList;

/**
 * Created by Miha on 24.02.2017.
 */
public interface ScoreSaver {
    boolean saveScore(UserScore userScore);

    ArrayList<UserScore> getScoreList();
}
