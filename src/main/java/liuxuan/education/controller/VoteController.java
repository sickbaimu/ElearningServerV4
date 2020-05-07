package liuxuan.education.controller;

import ch.qos.logback.core.util.FileUtil;
import liuxuan.education.entity.RankRecord;
import liuxuan.education.entity.WorkCommit;
import liuxuan.education.sql.BBSSQL;
import liuxuan.education.sql.UserSQL;
import liuxuan.education.sql.VoteSQL;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import static liuxuan.education.patch.UpLoadPicture.GenerateImage;
import static liuxuan.education.sql.BaseSQL.ListToString;
import static liuxuan.education.sql.LearnSQL.getNameList;

@Controller
public class VoteController {
    private SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式

    @ResponseBody
    @RequestMapping("/GetWorkNames")
    public String GetWorkNames(){
        return ListToString(getNameList("work","name",null));
    }

    @ResponseBody
    @RequestMapping("/GetWorkIDs")
    public String GetWorkIDs(){
        return ListToString(getNameList("work","id",null));
    }

    @ResponseBody
    @RequestMapping("/GetVoteRank")
    public ArrayList<RankRecord> GetRank(){
        //获得作品的集合
        ArrayList<RankRecord> rankRecords = VoteSQL.GetRank();
        //填入作者名
        for(RankRecord rankRecord:rankRecords){
            rankRecord.setUserName(UserSQL.getUserNameByID(rankRecord.getUserName()));
        }
        //填入票数
        for(RankRecord rankRecord:rankRecords){
            rankRecord.setPoint(VoteSQL.getVote(rankRecord.getId()));
        }
        Collections.sort(rankRecords, new SortByVote());
        return rankRecords;
    }

    class SortByVote implements Comparator {
        public int compare(Object o1, Object o2) {
            RankRecord s1 = (RankRecord) o1;
            RankRecord s2 = (RankRecord) o2;
            return s2.getPoint().compareTo(s1.getPoint());
        }
    }

    @ResponseBody
    @RequestMapping("/Vote")
    public String Vote(String from,String to){
        if(VoteSQL.VoteCheck(from,to).equals("-1"))
            return "-1";
        String result = VoteSQL.Vote(from,to);
        if(!result.equals("-1"))
            return "0";
        else
            return "-2";
    }

    @ResponseBody
    @RequestMapping("/VoteCommit")
    public String VoteCommit(String workID,String userID,String commit){
        return BBSSQL.addCommit(workID,userID,commit);
    }

    @ResponseBody
    @RequestMapping("/GetCommit")
    public ArrayList<WorkCommit> GetCommit(String workID){
        ArrayList<WorkCommit> workCommits = BBSSQL.getCommit(workID);
        for(WorkCommit workCommit:workCommits){
            workCommit.setUserName(UserSQL.getUserNameByID(workCommit.getUserName()));
        }
        return workCommits;
    }

    @ResponseBody
    @RequestMapping("/UpLoadWork")
    public String UpLoadWork(String base64,String userID,String name) {
        String folder_path = "data\\work\\";
        File folder = new File(folder_path);
        if (!folder.exists()) {
            folder.mkdir();
        }
        boolean result  = GenerateImage(base64,folder_path+name+".jpg");
        if(result){
            return VoteSQL.addWork(name,userID);
        }
        return "-1";
    }


}
