package liuxuan.education.sql;

import liuxuan.education.entity.Question;
import liuxuan.education.entity.RankRecord;

import java.sql.SQLException;
import java.util.ArrayList;

public class ExamSQL extends BaseSQL {
    public static ArrayList<Question> GetQuestions(){
        //准备一个空的集合
        ArrayList<Question> questions = new ArrayList<>();
        //填入作品名
        try{
            init();
            rs = stmt.executeQuery("select *from question ");
            while(rs.next())
            {
                questions.add(new Question(rs.getString("id"),rs.getInt("_order"),rs.getString("_type"),rs.getString("question"),rs.getString("answer")));
            }
            closeQuery();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
        }
        return questions;
    }


    public static String AddCollection(String userID, String questionID) {
        try{
            init();
            String sql = "insert into collection(user_id,question_id)VALUES('"+userID+"','"+questionID+"');";
            stmt.executeUpdate(sql);
            closeUpdate();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
            return "-1";
        }
        return "0";
    }


    public static ArrayList<String> GetCollection(String userID) {
        ArrayList<String> questionsID = new ArrayList<>();
        try{
            init();
            rs = stmt.executeQuery("select *from collection where user_id = "+userID);
            while(rs.next())
            {
                questionsID.add(rs.getString("question_id"));
            }
            closeQuery();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
        }
        return questionsID;
    }

    public static String AddScore(String userID, String score, String time, String rate, String errorNum, String day) {
        try{
            init();
            String sql = "insert into score(user_id,score,time,rate,errorNum,day)VALUES('"+userID+"','"+score+"','"+time+"','"+rate+"','"+errorNum+"','"+day+"');";
            stmt.executeUpdate(sql);
            closeUpdate();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
            return "-1";
        }
        return "0";
    }

    public static String GetMyScore(String userID) {
        String score = "";
        try {
            init();
            rs = stmt.executeQuery("select *from score where user_id = "+userID);
            while (rs.next()){
                score = rs.getString("score")+"@"+
                        rs.getString("time")+"@"+
                        rs.getString("rate")+"@"+
                        rs.getString("errorNum")+"@"+
                        rs.getString("day");
            }
            System.out.println(score);
            closeQuery();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
        }
        return score;
    }

    public static ArrayList<RankRecord> GetAllScore() {
        ArrayList<RankRecord> rankRecords = new ArrayList<>();
        try {
            init();
            rs = stmt.executeQuery("select *from score order by score");
            while (rs.next()){
                rankRecords.add(new RankRecord(rs.getString("id"),
                                "用时"+rs.getString("time")+"秒\n"+
                                        "错误题目："+rs.getString("errorNum")+"\n"+
                                        rs.getString("day"),rs.getString("user_id"),rs.getString("score")
                        ));
            }
            closeQuery();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
        }
        return rankRecords;
    }

    public static Question GetQuestion(String id) {
        Question question =null;
        try {
            init();
            rs = stmt.executeQuery("select *from question where id = "+id);
            while (rs.next()){
                question = new Question(rs.getString("id"),rs.getInt("_order"),rs.getString("_type"),rs.getString("question"),rs.getString("answer"));

            }
            closeQuery();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
        }
        return question;
    }

    public static String DeleteQuestion(String id) {
        try {
            init();
            stmt.executeUpdate("delete from question where id =  "+id);
            closeQuery();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
            return "-1";
        }
        return "0";
    }

    public static String AddQuestion(String order, String type, String question, String answer) {
        try{
            init();
            String sql = "insert into question (_order,_type,question,answer)VALUES('"+order+"','"+type+"','"+question+"','"+answer+"');";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            closeUpdate();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
            return "-1";
        }
        return "0";
    }

    public static String UpdateQuestion(String id, String order, String type, String question, String answer) {
        try{
            init();
            String sql = "update question set _order = "+order+",_type ='"+type+"',question = '"+question+"',answer =  '"+answer+"' where id  = "+id;
            stmt.executeUpdate(sql);
            closeUpdate();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
            return "-1";
        }
        return "0";
    }
}
