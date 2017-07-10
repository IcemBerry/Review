package controller;

import dto.*;
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
public class TeacherController {

    @Resource
    private DeliveryService deliveryService;
    @Resource
    private ScoreService scoreService;
    @Resource
    private UserService userService;

    @RequestMapping(value = "/tchInfo", method = RequestMethod.GET)
    public String toTchInfo(HttpSession session, Model model) {
        CheckInfo checkInfo = Check.CheckRole(session, 1);
        if (checkInfo.isResult()) {
            List<User> userList = userService.getStuByTchId(checkInfo.getUser().getUserId());
            int successNum = 0, state0 = 0, state1 = 0, state2 = 0, state3 = 0, state4 = 0, failNum = 0, stateN1 = 0, stateN2 = 0, stateN3 = 0, stateN4 = 0;
            for (User user : userList) {
                if (user.getUserState().equals(0))
                    state0++;
                if (user.getUserState().equals(1))
                    state1++;
                if (user.getUserState().equals(2))
                    state2++;
                if (user.getUserState().equals(3))
                    state3++;
                if (user.getUserState().equals(4))
                    state4++;
                if (user.getUserState().equals(-1))
                    stateN1++;
                if (user.getUserState().equals(-2))
                    stateN2++;
                if (user.getUserState().equals(-3))
                    stateN3++;
                if (user.getUserState().equals(-4))
                    stateN4++;
            }
            successNum = state0 + state1 + state2 + state3;
            failNum = stateN1 + stateN2 + stateN3 + stateN4;
            model.addAttribute("state0", state0);
            model.addAttribute("state1", state1);
            model.addAttribute("state2", state2);
            model.addAttribute("state3", state3);
            model.addAttribute("state4", state4);
            model.addAttribute("stateN1", stateN1);
            model.addAttribute("stateN2", stateN2);
            model.addAttribute("stateN3", stateN3);
            model.addAttribute("stateN4", stateN4);

            model.addAttribute("successNum", successNum);
            model.addAttribute("failNum", failNum);
            return "tchInfo";
        }
        return "redirect:allUserLogin";
    }

    @RequestMapping(value = "/tchUpload", method = RequestMethod.GET)
    public String toTchUpload(HttpSession session) {
        CheckInfo checkInfo = Check.CheckRole(session, 1);
        if (checkInfo.isResult()) {
            return "tchUpload";
        }
        return "redirect:allUserLogin";
    }

    @RequestMapping(value = "/tchUpload", method = RequestMethod.POST)
    public String tchUpload(@RequestParam(value = "uploadFile", required = false) MultipartFile file,
                            @RequestParam(value = "uploadType", required = false) int uploadType,
                            HttpSession session, HttpServletRequest request) {
        Delivery delivery = new Delivery();
        User user = (User) session.getAttribute("user");
        String fileName = FileUtil.fileUpload(file, request, user, uploadType);
        delivery.setDeliveryPath(fileName);
        delivery.setDeliveryTime(new Date());
        delivery.setDeliveryType(uploadType);
        delivery.setDeliveryUserId(user.getUserId());
        deliveryService.addDelivery(delivery);

        return "tchUpload";
    }

    @RequestMapping(value = "/tchDownload", method = RequestMethod.GET)
    public String toTchDownload(HttpSession session) {
        CheckInfo checkInfo = Check.CheckRole(session, 1);
        if (checkInfo.isResult()) {
            return "tchDownload";
        }
        return "redirect:allUserLogin";
    }

    @ResponseBody
    @RequestMapping(value = "/tchDownload", method = RequestMethod.POST)
    public Map<String, Object> getTchDownload(HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        User user = (User) session.getAttribute("user");
        List<User> userList = userService.getStuByTchId(user.getUserId());
        List<TchDownload> tchDownloadList = new ArrayList<TchDownload>();
        for (User stuUser : userList) {
            List<Delivery> deliveryList = deliveryService.getDeliveryByUser(stuUser);
            for (Delivery delivery : deliveryList) {
                TchDownload tchDownload = new TchDownload();
                tchDownload.setDeliveryId(delivery.getDeliveryId());
                tchDownload.setDeliveryPath(delivery.getDeliveryPath());
                tchDownload.setDeliveryTime(DateStringSwitcher.dataToString(delivery.getDeliveryTime()));
                tchDownload.setDeliveryType(new StuSubmit(delivery.getDeliveryType()).getStage());

                tchDownload.setStuId(stuUser.getUserId());
                tchDownload.setStuName(stuUser.getUserName());
                tchDownload.setStuState(new StuProgress(stuUser.getUserState()).getState());

                tchDownloadList.add(tchDownload);
            }
        }
        map.put("tchDownloadList", tchDownloadList);
        return map;
    }

    @RequestMapping(value = "/tchReview", method = RequestMethod.GET)
    public String toTchReview(HttpSession session) {
        CheckInfo checkInfo = Check.CheckRole(session, 1);
        if (checkInfo.isResult()) {
            return "tchReview";
        }
        return "redirect:allUserLogin";
    }

    @ResponseBody
    @RequestMapping(value = "/tchReview", method = RequestMethod.POST)
    public Map<String, Object> getTchReview(HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        User user = (User) session.getAttribute("user");
        List<User> userList = userService.getStuByTchId(user.getUserId());
        List<Student> studentList = new ArrayList<Student>();
        for (User student : userList) {
            Student tempStu = new Student();
            tempStu.setStuLoginName(student.getUserLoginName());
            tempStu.setStuId(student.getUserId());
            tempStu.setStuName(student.getUserName());
            tempStu.setStuStage(new StuProgress(student.getUserState()).getState());
            tempStu.setStuStageCode(student.getUserState());
            studentList.add(tempStu);
        }
        map.put("studentList", studentList);
        return map;
    }

    @RequestMapping(value = "/review", method = RequestMethod.GET)
    public String reviewSwitcher(HttpSession session, @RequestParam(value = "stuId", required = false) int stuId, Model model) {
        CheckInfo checkInfo = Check.CheckRole(session, 1);
        if (checkInfo.isResult()) {
            User stu = userService.getUserByUserId(stuId);
            model.addAttribute("stu", stu);
            Review review = new Review();
            review.setUserId(stu.getUserId());
            review.setUserName(stu.getUserName());
            List<DeliveryLite> deliveryLiteList = new ArrayList<DeliveryLite>();
            List<Delivery> deliveryList = deliveryService.getDeliveryByUser(stu);
            String lastDesc = null;
            Date date = new Date(0);
            for (Delivery delivery : deliveryList) {
                DeliveryLite deliveryLite = new DeliveryLite();
                deliveryLite.setPath(delivery.getDeliveryPath());
                deliveryLite.setTime(DateStringSwitcher.dataToString(delivery.getDeliveryTime()));
                deliveryLite.setType(new StuSubmit(delivery.getDeliveryType()).getStage());

                if (delivery.getDeliveryTime().after(date)) {
                    date = delivery.getDeliveryTime();
                    lastDesc = delivery.getDeliveryDesc();
                }

                deliveryLiteList.add(deliveryLite);
            }
            review.setLastDesc(lastDesc);
            review.setDeliveryLiteList(deliveryLiteList);
            Score score = scoreService.getScoreByUser(stu);
            if (score != null) {
                review.setTopic(score.getScoreTopic());
                review.setScoreId(score.getScoreId());
            }
            model.addAttribute("review", review);

            return "tchReviewMain";
        }
        return "redirect:allUserLogin";
    }

    @RequestMapping(value = "/submitReview", method = RequestMethod.POST)
    public String doReview(@RequestParam(value = "judge") String judge,
                           @RequestParam(value = "stuId") int stuId,
                           @RequestParam(value = "stuState") int stuState,
                           HttpServletRequest request) {

        String scoreStr = request.getParameter("scoreId");
        int scoreNum = 0;
        if (scoreStr != null && !scoreStr.equals("")) {
            scoreNum = Integer.parseInt(scoreStr);
        }

        int scoreId = 0;
        String scoreIdStr = request.getParameter("scoreId");
        if (scoreStr != null && !scoreStr.equals("")) {
            scoreId = Integer.parseInt(scoreIdStr);
        }

        String msg = request.getParameter("msg");
        String topic = request.getParameter("topic");

        User student = userService.getUserByUserId(stuId);

        if (judge.equals("pass")) {
            if (stuState < 0) {
                student.setUserState(Math.abs(stuState));
            } else if (stuState == 0 || stuState == -1) {
                if (topic != null) {
                    Score score = new Score();
                    student.setUserState(1);
                    score.setScoreTopic(topic);
                    score.setScoreUserId(stuId);
                    scoreService.addScore(score);
                }
            } else if (0 < stuState && stuState < 3) {
                student.setUserState(stuState + 1);
            } else if (stuState == 3 && scoreNum != 0 && msg != null && scoreId != 0) {
                student.setUserState(4);
                Score score = scoreService.getScoreByScoreId(scoreId);
                score.setScoreFraction(scoreNum);
                score.setScoreId(scoreId);
                score.setScoreOpinion(msg);
                scoreService.updateScore(score);
            }
        } else if (judge.equals("notPass")) {
            if (stuState < 0) {
                student.setUserState(stuState);
                if (msg != null) {
                    student.setUserMessage(msg);
                }
            } else {
                student.setUserState((stuState + 1) * (-1));
                if (msg != null) {
                    student.setUserMessage(msg);
                }
            }
        }
        userService.updateUser(student);
        return "tchReview";
    }
}
