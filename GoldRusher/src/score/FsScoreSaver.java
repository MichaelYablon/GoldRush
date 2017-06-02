package score;

import objects.UserScore;

import java.util.ArrayList;

/**
 * Created by Miha on 24.02.2017.
 */
public class FsScoreSaver implements ScoreSaver {
    @Override
    public boolean saveScore(UserScore userScore) {
        return false;
    }

    @Override
    public ArrayList<UserScore> getScoreList() {
        return null;
    }
}
