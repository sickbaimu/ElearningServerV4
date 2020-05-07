package liuxuan.education.sql;

import liuxuan.education.entity.Note;

import java.sql.SQLException;
import java.util.ArrayList;

public class PointSQL extends BaseSQL{
    public static int CheckPoint(String userID, String type, String time){
        int cnt = 0;
        try{
            init();
            rs = stmt.executeQuery("select *from point where user_id = '" + userID + "' and time = '" + time + "' and type = '"+type+"'");
            while(rs.next())
            {
                cnt++;
            }
            closeQuery();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
        }
        return cnt;
    }

    public static void AddPoint(String userID, String type, String time) {
        try{
            Class.forName(jdbc);
            init();
            String sql = "insert into point(user_id,type,time)VALUES('"+userID+"','"+type+"','"+time+"');";
            stmt.executeUpdate(sql);
            closeUpdate();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static int GetPoint(String userID) {
        int point = 0;
        try{
            init();
            rs = stmt.executeQuery("select *from point where user_id = '" + userID+"'");
            while(rs.next())
            {
                point++;
            }
            closeQuery();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
        }
        return point;
    }

    public static int GetTypePoint(String userID, String type,String time) {
        int point = 0;
        try{
            init();
            rs = stmt.executeQuery("select *from point where user_id = '" + userID+"' and Type = '"+type+"' and time = '"+time+"'");
            while(rs.next())
            {
                point++;
            }
            closeQuery();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
        }
        return point;
    }
}
