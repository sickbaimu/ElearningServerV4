package liuxuan.education.controller;

import liuxuan.education.sql.PointSQL;
import liuxuan.education.sql.UserSQL;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class PointController {

    @ResponseBody
    @RequestMapping("/GetPointRank")
    public String GetPointRank(){
        String result = "";
        ArrayList<String> userIDList = UserSQL.getAllUser();
        ArrayList<String> tempList = new ArrayList<>();
        for(String userID:userIDList)
            tempList.add(userID+" "+PointSQL.GetPoint(userID));
        for(String userInfo:tempList)
            result += UserSQL.getUserNameByID(userInfo.split(" ")[0])+" "+userInfo.split(" ")[1]+".";
        return result.substring(0,result.length()-1);
    }

    @ResponseBody
    @RequestMapping("/AddPoint")
    public static void AddPoint(String userID,int point,String type){
        int limit = -1;
        switch (type){
            case "Login":
            case "Collection":
            case "BBS":
                limit = 1;break;
            case "TP":
            case "TextTime":
            case "MediaTime":
            case "Answer":
            case "AnswerTime":
                limit = 6;break;
            default:break;
        }

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

        //每次循环加1分，直到对应的上限
        for(int i=0;i<point;i++)
            if(PointSQL.CheckPoint(userID,type,simpleDateFormat.format(date))+1<=limit)
                PointSQL.AddPoint(userID,type,simpleDateFormat.format(date));
            else
                break;
    }

    @ResponseBody
    @RequestMapping("/GetPointToday")
    public static String GetPointToday(String userID) {
        String result = "";
        String[] type= {"Login","Collection","BBS","TP","TextTime","MediaTime","Answer","AnswerTime"};
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        for(int i=0;i<type.length;i++)
            result += PointSQL.GetTypePoint(userID,type[i],simpleDateFormat.format(date))+"-";
        return result.substring(0,result.length()-1);
    }


}
