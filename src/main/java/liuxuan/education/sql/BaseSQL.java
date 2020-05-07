package liuxuan.education.sql;
import java.sql.*;
import java.util.ArrayList;


public class BaseSQL {
    static String url = "jdbc:mysql://localhost:3306/elearning?useSSL=true&characterEncoding=utf8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static String jdbc = "com.mysql.cj.jdbc.Driver";
    static String user = "root";
    static String password = "password";
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;

    static void init()throws SQLException,ClassNotFoundException{
            Class.forName(jdbc);
            conn = DriverManager.getConnection(url,user,password);
            stmt = conn.createStatement();
    }
    static void closeQuery()throws SQLException{
            rs.close();
            stmt.close();
            conn.close();
    }
    static void closeUpdate()throws SQLException{
        stmt.close();
        conn.close();
    }
    /**
     * 将列表转化为字符串
     * @param arrayList 待转换列表
     * @return 字符串
     */
    public static String ListToString(ArrayList<String> arrayList){
        StringBuilder builder = new StringBuilder();
        for(String names:arrayList){
            builder.append(names.concat("-"));
        }
        return builder.toString().substring(0,builder.toString().length()-1);
    }

    /**
     * 按顺序获取某个表的命名字段
     * @param tableName 表名
     * @param column 列名
     * @return 命名字段的集合
     */
    public static ArrayList<String> getNameList(String tableName,String column){
        ArrayList<String> arrayList = new ArrayList<>();
        try{
            init();
            rs = stmt.executeQuery("select *from "+tableName+" order by _order");
            while(rs.next())
            {
                arrayList.add(rs.getString(column));
            }
            closeQuery();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
        }
        return arrayList;
    }

    /**
     * 按顺序获取某个表的命名字段
     * @param tableName 表名
     * @param column 列名
     * @param order 排列顺序
     * @return 命名字段的集合
     */
    public static ArrayList<String> getNameList(String tableName,String column,String order){
        ArrayList<String> arrayList = new ArrayList<>();
        try{
            init();
            rs = stmt.executeQuery("select *from "+tableName);
            while(rs.next())
            {
                arrayList.add(rs.getString(column));
            }
            closeQuery();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
        }
        return arrayList;
    }

}
