package controller;

import dto.CheckInfo;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;
import util.Check;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/adminAddStu", method = RequestMethod.GET)
    public String toAdminAddStu(HttpSession session, Model model) {
        CheckInfo checkInfo = Check.CheckRole(session, 2);
        if (checkInfo.isResult()) {
            List<User> teacherList = userService.getUserByRoleId(1);
            model.addAttribute("teacherList", teacherList);
            return "adminAddStu";
        }
        return "redirect:allUserLogin";
    }


    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@RequestParam(value = "userName", required = false) String userName,
                          @RequestParam(value = "userNum", required = false) int userNum,
                          @RequestParam(value = "userLead", required = false) int userLead,
                          @RequestParam(value = "userCollege", required = false) String userCollege) {
        User student = new User();
        student.setUserLoginName(Integer.toString(userNum));
        student.setUserLead(userLead);
        student.setUserCollege(userCollege);
        student.setUserLoginPassword("123");
        student.setUserName(userName);
        student.setUserState(0);
        student.setUserRole(0);

        userService.addUser(student);

        return "adminAddStu";
    }

    @RequestMapping(value = "/adminStuManage", method = RequestMethod.GET)
    public String toAdminStuManage(HttpSession session) {
        CheckInfo checkInfo = Check.CheckRole(session, 2);
        if (checkInfo.isResult()) {
            return "adminStuManage";
        }
        return "redirect:allUserLogin";
    }

    @ResponseBody
    @RequestMapping(value = "/getStuManager", method = RequestMethod.POST)
    public Map<String, Object> getStuManager() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<User> studentList = userService.getUserByRoleId(0);
        map.put("studentList", studentList);
        return map;
    }

    @RequestMapping(value = "/reset", method = RequestMethod.GET)
    public String reset(HttpSession session, @RequestParam(value = "userId", required = false) int userId) {
        CheckInfo checkInfo = Check.CheckRole(session, 2);
        if (checkInfo.isResult()) {
            User user = userService.getUserByUserId(userId);
            user.setUserLoginPassword("123");
            userService.updateUser(user);
            return "adminStuManage";
        }
        return "redirect:allUserLogin";
    }


    @RequestMapping(value = "/resetState", method = RequestMethod.GET)
    public String resetState(HttpSession session, @RequestParam(value = "userId", required = false) int userId) {
        CheckInfo checkInfo = Check.CheckRole(session, 2);
        if (checkInfo.isResult()) {
            User user = userService.getUserByUserId(userId);
            user.setUserState(0);
            userService.updateUser(user);
            return "adminStuManage";
        }
        return "redirect:allUserLogin";
    }

    @RequestMapping(value = "/adminAddTch", method = RequestMethod.GET)
    public String toAdminAddTch(HttpSession session) {
        CheckInfo checkInfo = Check.CheckRole(session, 2);
        if (checkInfo.isResult()) {
            return "adminAddTch";
        }
        return "redirect:allUserLogin";
    }

    @RequestMapping(value = "/addTeacher", method = RequestMethod.POST)
    public String addTeacher(@RequestParam(value = "userName", required = false) String userName,
                             @RequestParam(value = "userNum", required = false) int userNum,
                             @RequestParam(value = "userCollege", required = false) String userCollege) {
        User teacher = new User();
        teacher.setUserLoginName(Integer.toString(userNum));
        teacher.setUserCollege(userCollege);
        teacher.setUserLoginPassword("qazwsx");
        teacher.setUserName(userName);
        teacher.setUserRole(1);

        userService.addUser(teacher);

        return "adminAddTch";
    }

    @RequestMapping(value = "/adminTchManage", method = RequestMethod.GET)
    public String toAdminTchManage(HttpSession session) {
        CheckInfo checkInfo = Check.CheckRole(session, 2);
        if (checkInfo.isResult()) {
            return "adminTchManage";
        }
        return "redirect:allUserLogin";

    }

    @ResponseBody
    @RequestMapping(value = "/getTchManager", method = RequestMethod.POST)
    public Map<String, Object> getTchManager() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<User> teacherList = userService.getUserByRoleId(1);
        map.put("teacherList", teacherList);
        return map;
    }

}
