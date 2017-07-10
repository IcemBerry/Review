package mapper;

import model.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    User selectByUserName(String userName);

    List<User> selectUserByTchId(Integer tchId);

    List<User> selectUserByRoleId(Integer roleId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}