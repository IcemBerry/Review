package controller;

import dto.CheckInfo;
import dto.StuDownload;
import dto.StuProgress;
import dto.StuSubmit;
import model.Delivery;
import model.Score;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import service.DeliveryService;
import service.ScoreService;
import service.UserService;
import util.Check;
import util.DateStringSwitcher;
import util.FileUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class StudentController {

    @Resource
    private DeliveryService deliveryService;
    @Resource
    private ScoreService scoreService;
    @Resource
    private UserService userService;

    @RequestMapping(value = "/stuProgress", method = RequestMethod.GET)
    public String toStuProgress(HttpSession session, Model model) {
        CheckInfo checkInfo = Check.CheckRole(session, 0);
        if (checkInfo.isResult()) {
            StuProgress stuProgress = new StuProgress(checkInfo.getUser().getUserState());
            model.addAttribute("stuProgress", stuProgress);
            return "stuProgress";
        } else {
            return "redirect:allUserLogin";
        }
    }

    @RequestMapping(value = "/stuDownload", method = RequestMethod.GET)
    public String toStuDownload(HttpSession session) {
        CheckInfo checkInfo = Check.CheckRole(session, 0);
        if (checkInfo.isResult()) {
            return "stuDownload";
        } else {
            return "redirect:allUserLogin";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/stuDownload", method = RequestMethod.POST)
    public Map<String, Object> getStuDownload(HttpSession session) {
        CheckInfo checkInfo = Check.CheckRole(session, 0);
        Map<String, Object> map = new HashMap<String, Object>();
        StuDownload stuDownload = new StuDownload();
        User tchUser = userService.getUserByUserId(checkInfo.getUser().getUserLead());
        List<Delivery> deliveryList = deliveryService.getDeliveryByUser(tchUser);
        for (Delivery delivery : deliveryList) {
            if (delivery.getDeliveryType().equals(1)) {
                String date = DateStringSwitcher.dataToString(delivery.getDeliveryTime());
                stuDownload.setDate1(date);
                stuDownload.setPath1(delivery.getDeliveryPath());
                stuDownload.setTitle1("开题报告");
            } else if (delivery.getDeliveryType().equals(2)) {
                String date = DateStringSwitcher.dataToString(delivery.getDeliveryTime());
                stuDownload.setDate2(date);
                stuDownload.setPath2(delivery.getDeliveryPath());
                stuDownload.setTitle2("中期验收报告");
            } else if (delivery.getDeliveryType().equals(3)) {
                String date = DateStringSwitcher.dataToString(delivery.getDeliveryTime());
                stuDownload.setDate3(date);
                stuDownload.setPath3(delivery.getDeliveryPath());
                stuDownload.setTitle3("实验报告/论文");
            }
        }
        map.put("stuDownload", stuDownload);
        return map;
    }

    @RequestMapping(value = "/stuSubmit", method = RequestMethod.GET)
    public String toStuSubmit(HttpSession session) {
        CheckInfo checkInfo = Check.CheckRole(session, 0);
        if (checkInfo.isResult()) {
            return "stuSubmit";
        } else {
            return "redirect:allUserLogin";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getStuSubmit", method = RequestMethod.POST)
    public Map<String, Object> getStuSubmit(HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        User user = (User) session.getAttribute("user");
        StuSubmit stuSubmit = new StuSubmit(user.getUserState());
        if (user.getUserState() < 0) {
            stuSubmit.setMessage(user.getUserMessage());
        }
        map.put("stuSubmit", stuSubmit);
        return map;
    }


    @RequestMapping(value = "/stuAddDelivery", method = RequestMethod.POST)
    public String stuAddDelivery(@RequestParam(value = "submitFile", required = false) MultipartFile file,
                                 HttpSession session, HttpServletRequest request) {

        String submitDesc = request.getParameter("submitDesc");

        Delivery delivery = new Delivery();
        User user = (User) session.getAttribute("user");
        if (file != null) {
            String fileName = FileUtil.fileUpload(file, request, user, user.getUserState());
            delivery.setDeliveryPath(fileName);
        }
        if (submitDesc != null && !submitDesc.equals("")) {
            delivery.setDeliveryDesc(submitDesc);
        }
        delivery.setDeliveryTime(new Date());
        delivery.setDeliveryType(user.getUserState());
        delivery.setDeliveryUserId(user.getUserId());
        deliveryService.addDelivery(delivery);

        return "stuSubmit";
    }


    @RequestMapping(value = "/stuQuery", method = RequestMethod.GET)
    public String toStuQuery(HttpSession session) {
        CheckInfo checkInfo = Check.CheckRole(session, 0);
        if (checkInfo.isResult()) {
            return "stuQuery";
        } else {
            return "redirect:allUserLogin";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getStuQuery", method = RequestMethod.POST)
    public Map<String, Object> getStuQuery(HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        User user = (User) session.getAttribute("user");
        User userLead = userService.getUserByUserId(user.getUserLead());
        Score score = scoreService.getScoreByUser(user);
        if (score != null && score.getScoreFraction() != null) {
            map.put("error", false);
            map.put("score", score);
            map.put("teacher", userLead);
        } else {
            map.put("error", true);
        }
        return map;
    }
}
