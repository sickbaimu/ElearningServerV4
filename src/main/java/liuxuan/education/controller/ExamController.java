package liuxuan.education.controller;


import liuxuan.education.entity.Question;
import liuxuan.education.entity.RankRecord;
import liuxuan.education.sql.ExamSQL;
import liuxuan.education.sql.UserSQL;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.Collections;


/**
 * @author lele
 * @version 1.00
 * @description 处理考试请求
 * @Date 2019/7/11 13:27
 */
@Controller
public class ExamController {

    @ResponseBody
    @RequestMapping("/GetExam")
    public ArrayList<Question> getExam(String Type){
        ArrayList<Question> questions = ExamSQL.GetQuestions();
        if(Type.equals("Random"))
            Collections.shuffle(questions);
        return questions;
    }

    @ResponseBody
    @RequestMapping("/CollectQuestion")
    public String CollectQuestion(String userID,String questionID){
        PointController.AddPoint(userID,1,"Collection");
        return ExamSQL.AddCollection(userID,questionID);
    }

    @ResponseBody
    @RequestMapping("/GetQuestionCollection")
    public ArrayList<Question> GetQuestionCollection(String userID){
        ArrayList<String> questionID = ExamSQL.GetCollection(userID);
        ArrayList<Question> allQuestions = ExamSQL.GetQuestions();
        ArrayList<Question> collectionQuestions = new ArrayList<>();
        for(Question question:allQuestions){
            if(questionID.contains(question.getId()))
                collectionQuestions.add(question);
        }
        return collectionQuestions;
    }

    @ResponseBody
    @RequestMapping("/AddScore")
    public String AddScore(String userID,String score,String time,String rate,String errorNum,String day,String model){
        for(int i = 0; i<Integer.parseInt(time)/60; i++)
            PointController.AddPoint(userID,1,"AnswerTime");
        int point = Integer.parseInt(score);
        if(point==100)
            PointController.AddPoint(userID,6,"Answer");
        else if(point>=80){
            PointController.AddPoint(userID,4,"Answer");
        }else if(point>=60){
            PointController.AddPoint(userID,2,"Answer");
        }else if(point>=0){
            PointController.AddPoint(userID,1,"Answer");
        }
        if(!model.equals("Final"))
            return "0";
        return ExamSQL.AddScore(userID,score,time,rate,errorNum,day);
    }

    @ResponseBody
    @RequestMapping("GetMyScore")
    public String GetMyScore(String userID){
        return ExamSQL.GetMyScore(userID);
    }

    @ResponseBody
    @RequestMapping("GetAllScore")
    public ArrayList<RankRecord> GetAllScore(){
        ArrayList<RankRecord> rankRecords = ExamSQL.GetAllScore();
        for(RankRecord rankRecord:rankRecords)
            rankRecord.setUserName(UserSQL.getUserNameByID(rankRecord.getUserName()));
        return rankRecords;
    }
    @ResponseBody
    @RequestMapping("GetAllQuestion")
    public ArrayList<Question> GetAllQuestion(){
        return ExamSQL.GetQuestions();
    }
    @ResponseBody
    @RequestMapping("GetQuestion")
    public Question GetQuestion(String id){
        return ExamSQL.GetQuestion(id);
    }
    @ResponseBody
    @RequestMapping("UpdateQuestion")
    public String UpdateQuestion(String id,String order,String type,String question,String answer){
        return ExamSQL.UpdateQuestion(id,order,type,question,answer);
    }
    @ResponseBody
    @RequestMapping("AddQuestion")
    public String AddQuestion(String order,String type,String question,String answer){
        return ExamSQL.AddQuestion(order,type,question,answer);
    }
    @ResponseBody
    @RequestMapping("DeleteQuestion")
    public String DeleteQuestion(String id){
        return ExamSQL.DeleteQuestion(id);
    }
}
