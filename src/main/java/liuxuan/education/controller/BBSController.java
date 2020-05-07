package liuxuan.education.controller;


import liuxuan.education.sql.*;
import liuxuan.education.entity.CBBS;
import liuxuan.education.entity.MBBS;
import liuxuan.education.entity.CBBS;
import liuxuan.education.entity.MBBS;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static liuxuan.education.FileHandler.ReadFile;
import static liuxuan.education.FileHandler.WriteFile;
import static liuxuan.education.sql.BBSSQL.*;


/**
 * @author lele
 * @version 1.00
 * @description 处理论坛请求
 * @Date 2019/7/11 13:27
 */
@Controller
public class BBSController {

    @ResponseBody
    @RequestMapping("/GetMainBBSList")
    public ArrayList<MBBS> getMainBBSList(String page){
        return BBSSQL.getMainBBS(0);
    }

    @ResponseBody
    @RequestMapping("/GetChildBBS")
    public ArrayList<CBBS> getChildBBS(String id){
        return PackedCBBS(BBSSQL.getChildBBS(id));
    }

    @ResponseBody
    @RequestMapping("/GetMainBBSContent")
    public String getMainBBSContent(String id){
        return BBSSQL.getMainBBSContent(id);
    }

    @ResponseBody
    @RequestMapping("/GetNotice")
    public String getNotice(){
        return ReadFile("data/notice.txt");
    }

    @ResponseBody
    @RequestMapping("/Post")
    public String Post(String theme,String content,String user){
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df2.format(new Date());
        BBSSQL.addMainBBS(theme,user,time);
        String id = BBSSQL.getMainBBSID(theme,user,time);
        BBSSQL.addChildBBS(id,user,content,time);
        PointController.AddPoint(user,1,"BBS");
        return "0";
    }

    @ResponseBody
    @RequestMapping("/RePost")
    public String RePost(String mainID,String user,String content){
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        PointController.AddPoint(user,1,"BBS");
        return BBSSQL.addChildBBS(mainID,user,content,df2.format(new Date()));
    }


    @ResponseBody
    @RequestMapping("/FreshPage")
    public ArrayList<MBBS> FreshPage(String page){
       return PackedMBBS(BBSSQL.getMainBBS(Integer.parseInt(page)));
    }

    @ResponseBody
    @RequestMapping("/UpdateNotice")
    public String UpdateNotice(String Content){
        return WriteFile("data/notice.txt",Content);
    }
}
