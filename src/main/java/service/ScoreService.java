package service;

import model.Score;
import model.User;

public interface ScoreService {
    Score getScoreByUser(User user);

    Score getScoreByScoreId(int scoreId);

    int updateScore(Score score);

    int addScore(Score score);
}
