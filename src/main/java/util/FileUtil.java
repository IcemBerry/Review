package util;

import dto.StuSubmit;
import model.User;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

public class FileUtil {
    public static String fileUpload(MultipartFile file, HttpServletRequest request, User user, int type) {
        String path = request.getSession().getServletContext().getRealPath("/assets/delivery/");
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String fileName = user.getUserLoginName() + new StuSubmit(type).getStage() + suffix;
        File realFile = new File(path, fileName);
        if(!realFile.exists()){
            realFile.mkdirs();
        }
        try {
            file.transferTo(realFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }
}
