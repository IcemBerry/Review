package service.impl;

import mapper.ScoreMapper;
import model.Score;
import model.User;
import org.springframework.stereotype.Service;
import service.ScoreService;

import javax.annotation.Resource;

@Service("scoreService")
public class ScoreServiceImpl implements ScoreService{

    @Resource
    private ScoreMapper scoreMapper;

    @Override
    public Score getScoreByUser(User user) {
        return scoreMapper.selectByUserId(user.getUserId());
    }

    @Override
    public Score getScoreByScoreId(int scoreId) {
        return scoreMapper.selectByPrimaryKey(scoreId);
    }

    @Override
    public int updateScore(Score score) {
        return scoreMapper.updateByPrimaryKeySelective(score);
    }

    @Override
    public int addScore(Score score) {
        return scoreMapper.insertSelective(score);
    }
}
