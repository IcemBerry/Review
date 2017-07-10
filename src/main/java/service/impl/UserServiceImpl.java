package service.impl;

import mapper.UserMapper;
import model.User;
import org.springframework.stereotype.Service;
import service.UserService;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserByUserName(String userName) {
        return userMapper.selectByUserName(userName);
    }

    @Override
    public User getUserByUserId(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<User> getStuByTchId(int tchId) {
        return userMapper.selectUserByTchId(tchId);
    }

    @Override
    public List<User> getUserByRoleId(int roleId) {
        return userMapper.selectUserByRoleId(roleId);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }
}
