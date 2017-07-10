package service;

import model.User;

import java.util.List;

public interface UserService {
    User getUserByUserName(String userName);

    User getUserByUserId(int userId);

    List<User> getStuByTchId(int TchId);

    List<User> getUserByRoleId(int roleId);

    int updateUser(User user);

    int addUser(User user);
}
