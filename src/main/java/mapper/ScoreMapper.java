package mapper;

import model.Score;

public interface ScoreMapper {
    int deleteByPrimaryKey(Integer scoreId);

    int insert(Score record);

    int insertSelective(Score record);

    Score selectByPrimaryKey(Integer scoreId);

	Score selectByUserId(Integer userId);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);
}