package liuxuan.education.sql;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author lele
 * @version 1.00
 * @description
 * @Date 2019/7/12 19:49
 */
public class UserSQL extends BaseSQL{
    /**
     * 登录验证
     * @param username 用户名
     * @param pwd 密码
     * @return 登录验证成功返回用户id，失败返回-1
     */
    public static String LoginCheck(String username,String pwd){
        try{
            Class.forName(jdbc);
            conn = DriverManager.getConnection(url,user,password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select *from user");
            while(rs.next())
            {
                if(rs.getString(2).equals(username)&rs.getString(3).equals(pwd))
                    return rs.getString(1);
            }
            closeQuery();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
        }
        return "-1";
    }

    /**
     * 新增用户
     * @param username 用户名
     * @param pwd 密码
     * @param st_id 学号
     * @param sex 性别
     * @return 新增结果，-1表示失败，0表示成功
     */
    public static String AddUser(String username,String pwd,String st_id,String sex){
        try{
            Class.forName(jdbc);
            init();
            String sql = "insert into user(username,pwd,st_id,sex)VALUES('"+username+"','"+pwd+"','"+st_id+"','"+sex+"');";
            stmt.executeUpdate(sql);
            closeUpdate();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
            return "-1";
        }
        return "0";
    }

    /**
     * 通过ID获取用户名
     * @param id ID
     * @return 用户名
     */
    public static String getUserNameByID(String id){
        String username = null;
        try{
            init();
            rs = stmt.executeQuery("select *from user");
            while(rs.next())
            {
                if(id.equals(rs.getString("id")))
                    username = rs.getString("username");
            }
            closeQuery();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
        }
        return username;
    }

    public static ArrayList<String> getAllUser(){
        ArrayList<String> users = new ArrayList<>();
        try{
            init();
            rs = stmt.executeQuery("select *from user");
            while(rs.next())
            {
                users.add(rs.getString("id"));
            }
            closeQuery();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
        }
        return users;
    }
}
