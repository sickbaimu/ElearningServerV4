package liuxuan.education.sql;

import liuxuan.education.entity.RankRecord;

import java.sql.SQLException;
import java.util.ArrayList;

public class VoteSQL extends BaseSQL {
    public static ArrayList<RankRecord> GetRank(){
        //准备一个空的集合
        ArrayList<RankRecord> rankRecords = new ArrayList<>();
        //填入作品名
        try{
            init();
            rs = stmt.executeQuery("select *from work ");
            while(rs.next())
            {
                rankRecords.add(new RankRecord(rs.getString("id"),rs.getString("name"),rs.getString("user_id"),""));
            }
            closeQuery();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
        }

        return rankRecords;
    }

    public static String VoteCheck(String from, String to){
        String result = "0";
        try{
            init();
            rs = stmt.executeQuery("select *from vote ");
            while(rs.next())
            {
                if(rs.getString("from_id").equals(from)&&rs.getString("to_id").equals(to))
                    result = "-1";

            }
            closeQuery();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 投票
     * @param from 投票人的id
     * @param to 被投票作品的id
     * @return -1表示失败 0表示正常
     */
    public static String Vote(String from,String to){
        try{
            Class.forName(jdbc);
            init();
            String sql = "insert into vote(from_id,to_id)VALUES('"+from+"','"+to+"');";
            stmt.executeUpdate(sql);
            closeUpdate();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
            return "-1";
        }
        return "0";
    }

    /**
     * 获得某件作品的总票数
     * @param id 作品的id
     * @return 票数
     */
    public static String getVote(String id) {
        int cnt = 0;
        try{
            init();
            rs = stmt.executeQuery("select *from vote where to_id = "+id);
            while(rs.next())
            {
                cnt++;
            }
            closeQuery();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
        }
        System.out.println(id+cnt);
        return String.valueOf(cnt);
    }

    public static String addWork(String name, String userID) {
        try{
            Class.forName(jdbc);
            init();
            String sql = "insert into work(name,user_id)VALUES('"+name+"','"+userID+"');";
            stmt.executeUpdate(sql);
            closeUpdate();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
            return "-1";
        }
        return "0";
    }
}
