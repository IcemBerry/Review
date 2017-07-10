package controller;

import model.User;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

@Controller
public class RoleController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/allUserLogin", method = RequestMethod.GET)
    public String toLogin(){
        return "allUserLogin";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpSession session) {
        User user = userService.getUserByUserName(request.getParameter("username"));
        if (user != null && user.getUserLoginPassword().equals(request.getParameter("password"))) {
            session.setAttribute("user", user);
            session.setMaxInactiveInterval(1200);
            if (user.getUserRole().equals(0))
                return "redirect:stuProgress";
            else if (user.getUserRole().equals(1))
                return "redirect:tchInfo";
            else if (user.getUserRole().equals(2))
                return "redirect:adminAddStu";
        }
        return "redirect:allUserLogin";
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void download(HttpServletRequest request, @RequestParam("deliveryName") String deliveryName, HttpServletResponse response) {
        try {
            String realPathDir = request.getSession().getServletContext().getRealPath("/assets/delivery/");
            String realFileName = realPathDir + deliveryName;
            File file = new File(realFileName);
            response.reset();
            response.setContentType("application/octet-stream; charset=utf-8");
            response.setHeader("Content-Disposition", "attachment; filename="+ new String(deliveryName.getBytes("utf-8"), "ISO8859-1" ) );
            OutputStream out = response.getOutputStream();
            out.write(FileUtils.readFileToByteArray(file));
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session){
        session.removeAttribute("user");
        session.invalidate();
        return "redirect:allUserLogin";
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public String editUserPage() {
        return "editUser";
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public String editUser(HttpSession session, HttpServletRequest request, Model model) {
        User user = (User) session.getAttribute("user");
        if (user != null){
            String oldPassword = request.getParameter("oldPassword");
            String newPassword = request.getParameter("newPassword");

            if (oldPassword != null && !oldPassword.equals("") && newPassword != null && !newPassword.equals("") &&oldPassword.equals(user.getUserLoginPassword())) {
                user.setUserLoginPassword(newPassword);
                userService.updateUser(user);
            }
        }
        session.removeAttribute("user");
        session.invalidate();
        return "redirect:allUserLogin";
    }
}
