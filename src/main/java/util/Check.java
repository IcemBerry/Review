package util;

import dto.CheckInfo;
import model.User;

import javax.servlet.http.HttpSession;

public class Check {
    public static CheckInfo CheckRole(HttpSession session,int roleId) {
        User user = (User) session.getAttribute("user");
        CheckInfo checkInfo = new CheckInfo();
        if (user != null) {
            if (user.getUserRole().equals(roleId)) {
                checkInfo.setResult(true);
                checkInfo.setUser(user);
            } else {
                checkInfo.setResult(false);
            }
        } else {
            checkInfo.setResult(false);
        }
        return checkInfo;
    }
}
