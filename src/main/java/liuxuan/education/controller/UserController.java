package liuxuan.education.controller;


import liuxuan.education.entity.HomeInfo;
import liuxuan.education.sql.BBSSQL;
import liuxuan.education.sql.UserSQL;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import static liuxuan.education.sql.BBSSQL.PackedMBBS;
import static liuxuan.education.sql.BaseSQL.ListToString;
import static liuxuan.education.sql.LearnSQL.getNameList;


/**
 * @author lele
 * @version 1.00
 * @description
 * @Date 2019/7/12 20:03
 */
@Controller
public class UserController {
    /**
     * 登录验证
     * @param username 用户名
     * @param pwd 密码
     * @return 用户ID，不存在则返回-1，为教师返回-2
     */
    @ResponseBody
    @RequestMapping("/Login")
    public String Login(String username,String pwd){
        if(username.equals("admin")&&pwd.equals("admin"))
            return "-2";
        String userID = UserSQL.LoginCheck(username,pwd);
        if(!userID.equals("-1"))
            PointController.AddPoint(userID, 1, "Login");
        return userID;
    }

    @ResponseBody
    @RequestMapping("/AddUser")
    public String AddUser(String Name,String Sex,String ID,String Password){
        return UserSQL.AddUser(Name,Password,ID,Sex);
    }


    @ResponseBody
    @RequestMapping("/GetHomeInfo")
    public HomeInfo GetHomeInfo(String userID){
        System.out.println(getTextListDemo());
        System.out.println(getPhotoListDemo());
        System.out.println(getMediaListDemo());
        return new HomeInfo(getTextListDemo(),getPhotoListDemo(),getMediaListDemo(), PackedMBBS(BBSSQL.getMainBBS(0)),
                LearnController.GetRate(userID));
    }


    private String getTextListDemo(){
        return ListToString(getNameList("chapter","name"));
    }

    /**
     * 获取图片目录
     * @return 图片目录
     */
    private String getPhotoListDemo(){
        return ListToString(getNameList("photo","name"));
    }


    private ResourceLoader resourceLoader;
    private String uploadPicturePath;

    /**
     * 获取视频目录
     * @return 视频目录
     */
    private String getMediaListDemo(){
        return ListToString(getNameList("media","name"));
    }

}
