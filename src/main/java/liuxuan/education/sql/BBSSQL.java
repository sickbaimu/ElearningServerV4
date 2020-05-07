package liuxuan.education.sql;

import liuxuan.education.entity.CBBS;
import liuxuan.education.entity.MBBS;
import liuxuan.education.entity.WorkCommit;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

import static liuxuan.education.sql.UserSQL.getUserNameByID;


/**
 * @author lele
 * @version 1.00
 * @description
 * @Date 2019/7/12 19:46
 */
public class BBSSQL extends BaseSQL{
    public static String getMainBBSContent(String id){
        String content = "";
        try {
            init();
            rs = stmt.executeQuery("select *from MainBBS where id = '" + id + "'");
            while (rs.next()) {
                content = rs.getString("content");
            }
            closeQuery();
        }catch(SQLException|ClassNotFoundException e){
            e.printStackTrace();
        }
        return content;
    }

    public static ArrayList<CBBS> getChildBBS(String id){
        ArrayList<CBBS> arrayList = new ArrayList<>();
        try {
            init();
            rs = stmt.executeQuery("select *from ChildBBS where main_id = '" + id + "' order by time");
            while (rs.next()) {
                arrayList.add(new CBBS(
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        -1)
                );
            }
            closeQuery();
        }catch(SQLException|ClassNotFoundException e){
            e.printStackTrace();
        }
        return arrayList;
    }

    public static ArrayList<MBBS> getMainBBS(int page){
        int i = 1;
        ArrayList<MBBS> arrayList = new ArrayList<>();
        try{
            init();
            rs = stmt.executeQuery("select *from MainBBS order by time desc");
            while(rs.next())
            {
                if(page*10<i && i<=(page+1)*10)
                    arrayList.add(new MBBS(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4))
                );
                i++;
            }
            closeQuery();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
        }
        return arrayList;
    }

    public static String addMainBBS(String head,String user,String time){
        try{
            init();
            String sql = "insert into mainbbs(head,user,time)VALUES('"+head+"','"+user+"','"+time+"');";
            stmt.executeUpdate(sql);
            closeUpdate();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
            return "-1";
        }
        return "0";
    }

    public static String addChildBBS(String main_id, String user, String content, String time) {
        try{
            init();
            String sql = "insert into childbbs(main_id,user,time,content)VALUES('"+main_id+"','"+user+"','"+time+"','"+content+"');";
            stmt.executeUpdate(sql);
            closeUpdate();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
            return "-1";
        }
        return "0";
    }

    public static ArrayList<MBBS> PackedMBBS(ArrayList<MBBS> arrayList){
        for(MBBS mbbs:arrayList){
            mbbs.setUser(getUserNameByID(mbbs.getUser()));
        }
        return arrayList;
    }


    public static ArrayList<CBBS> PackedCBBS(ArrayList<CBBS> arrayList){
        for(CBBS cbbs:arrayList){
            cbbs.setUser(getUserNameByID(cbbs.getUser()));
        }
        return arrayList;
    }


    public static String getMainBBSID(String theme, String user, String time) {
        String id = "";
        try{
            init();
            rs = stmt.executeQuery("select *from mainbbs");
            while(rs.next())
            {
               if(rs.getString("head").equals(theme)&&rs.getString("user").equals(user))
               {
                   Timestamp timestamp = rs.getTimestamp("time");
                   Date date = new Date();
                   if (timestamp != null)
                       date = new Date(timestamp.getTime());
                   SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                   df2.setTimeZone(TimeZone.getTimeZone("+8"));
                   String s = df2.format(date);
                   if(s.equals(time))
                        id = rs.getString("id");
               }
            }
            closeQuery();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
            return "-1";
        }
        return id;
    }

    public static String addCommit(String workID, String userID, String commit) {
        try{
            init();
            String sql = "insert into workcommit(workID,userID,commit)VALUES('"+workID+"','"+userID+"','"+commit+"');";
            stmt.executeUpdate(sql);
            closeUpdate();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
            return "-1";
        }
        return "0";
    }

    public static ArrayList<WorkCommit> getCommit(String workID) {
        ArrayList<WorkCommit> workCommits = new ArrayList<>();
        try{
            init();
            rs = stmt.executeQuery("select *from workcommit where workID = "+ workID);
            while(rs.next())
            {
                workCommits.add(new WorkCommit(rs.getString("userID"),rs.getString("commit")));
            }
            closeQuery();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
        }
        return workCommits;
    }

}
