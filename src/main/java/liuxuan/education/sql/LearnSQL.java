package liuxuan.education.sql;


import liuxuan.education.entity.MyMedia;
import liuxuan.education.entity.Photo;
import liuxuan.education.entity.TextChapter;
import liuxuan.education.entity.TextSection;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author lele
 * @version 1.00
 * @description
 * @Date 2019/7/12 19:49
 */
public class LearnSQL extends BaseSQL{

    /**
     * 获得id为chapter_id章、顺序为section_order的节
     * @param chapter_id 章ID
     * @param section_order 节顺序
     * @return 节对象（若id为-1，表示未找到，若id为-2表示已至章首，若id为-3表示已至章尾。
     */
    public static TextSection GetTextSection(String chapter_id, String section_order){
        TextSection textSection = new TextSection("-1",null,null,null);
        try{
            init();
            rs = stmt.executeQuery("select *from section where _order = "+section_order+" and chapter_id = "+chapter_id);
            while(rs.next())
            {
                textSection = new TextSection(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
            }
            closeQuery();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
        }
        if(textSection.getId().equals("-1")){//没有查找到的情况
            if(section_order.equals("0")){//已至章首的情况
                textSection.setId("-2");
            }else if(section_order.equals(String.valueOf(GetChapterSize(chapter_id)+1))){//已至章尾的情况
                textSection.setId("-3");
            }
        }
        return textSection;
    }

    /**
     * 获得某一章的节数
     * @param chapter_id 章id
     * @return 节数
     */
    public static int GetChapterSize(String chapter_id){
        int size = 0;
        try{
            init();
            rs = stmt.executeQuery("select *from section where chapter_id = "+chapter_id);
            while(rs.next())
            {
                size++;
            }
            closeQuery();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
        }
        return size;
    }

    public static TextChapter GetTextChapter(String chapter_id){
        TextChapter textChapter = new TextChapter(null,null,null,null);
        try{
            init();
            rs = stmt.executeQuery("select *from chapter where id = "+chapter_id);
            while(rs.next())
            {
                textChapter = new TextChapter(rs.getString(1),rs.getString(2),rs.getString(3),null);
            }
            closeQuery();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
        }
        return textChapter;
    }

    public static ArrayList<TextSection> GetTextSections(){
        ArrayList<TextSection> textSections = new ArrayList<>();
        try{
           init();
            rs = stmt.executeQuery("select *from section order by _order");
            while(rs.next())
            {
                textSections.add(new TextSection(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
            closeQuery();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
        }
        return textSections;
    }

    public static ArrayList<TextChapter> GetTextChapters(){
        ArrayList<TextChapter> textChapters = new ArrayList<>();
        try{
            init();
            rs = stmt.executeQuery("select *from chapter order by _order");
            while(rs.next())
            {
                textChapters.add(new TextChapter(rs.getString(1),rs.getString(2),rs.getString(3),null));
            }
            closeQuery();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
        }
        return textChapters;
    }

    public static String GetMediaPath(String name) {
        String path = "-1";
        try{
            init();
            rs = stmt.executeQuery("select *from media");
            while(rs.next()) {
                if(rs.getString("name").equals(name))
                path=rs.getString("path");
            }
            closeQuery();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
        }
        return path;
    }

    public static boolean CheckRecord(String userID,String type,String flag) {
        if(userID==null||userID.equals("999999"))
            return false;
        boolean isExist = false;
        try{
            init();
            rs = stmt.executeQuery("select *from record where user_id =  "+userID+" and _type = '"+type+"' and flag = '"+flag+"'");
            while(rs.next()) {
                isExist = true;
            }
            closeQuery();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
        }
        return isExist;
    }
    public static void AddRecord(String userID,String type,String flag){
        if(userID==null||userID.equals("999999"))
            return;
        try{
            Class.forName(jdbc);
            init();
            String sql = "insert into record(user_id, _type,flag)VALUES('"+userID+"','"+type+"','"+flag+"');";
            stmt.executeUpdate(sql);
            closeUpdate();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static int getRate(String userID,String type) {
        int cnt = 0;
        try{
            init();
            rs = stmt.executeQuery("select *from record where user_id =  "+userID+" and _type = '"+type+"'");
            while(rs.next()) {
                cnt++;
            }
            closeQuery();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
        }
        return cnt;
    }

    public static int getTotal(String type){
        int cnt = 0;
        try{
            init();
            rs = stmt.executeQuery("select *from "+type);
            while(rs.next()) {
                cnt++;
            }
            closeQuery();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
        }
        return cnt;
    }

    public static MyMedia GetMediaByName(String name) {
        MyMedia myMedia = new MyMedia("","","","");
        try{
            init();
            rs = stmt.executeQuery("select *from media where name = '"+name+"'");
            while(rs.next()) {
                myMedia = new MyMedia(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
            }
            closeQuery();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
        }
        return myMedia;
    }

    public static String UpdateMedia(String id, String order, String name, String path) {
        try{
            init();
            String sql = "update media set _order = "+order+" ,name ='"+name+"',path = '"+path+"' where id  = "+id;
            stmt.executeUpdate(sql);
            closeUpdate();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
            return "-1";
        }
        return "0";
    }

    public static String DeleteMedia(String id) {
        try {
            init();
            stmt.executeUpdate("delete from media where id =  "+id);
            closeQuery();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
            return "-1";
        }
        return "0";
    }

    public static String AddMedia(String order, String name, String path) {
        try{
            init();
            String sql = "insert into media (_order,name,path)VALUES('"+order+"','"+name+"','"+path+"');";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            closeUpdate();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
            return "-1";
        }
        return "0";
    }

    public static Photo GetPhotoByName(String name) {
        Photo photo = new Photo("","",name,"");
        try{
            init();
            rs = stmt.executeQuery("select *from photo where name = '"+name+"'");
            while(rs.next()) {
                photo.setId(rs.getString("id"));
                photo.setOrder(rs.getString("_order"));
            }
            closeQuery();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
        }
        return photo;
    }

    public static String UpdatePhoto(String id, String order, String name) {
        try{
            init();
            String sql = "update photo set _order = "+order+" ,name ='"+name+"' where id  = "+id;
            stmt.executeUpdate(sql);
            closeUpdate();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
            return "-1";
        }
        return "0";
    }

    public static String DeletePhoto(String id) {
        try {
            init();
            stmt.executeUpdate("delete from photo where id =  "+id);
            closeQuery();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
            return "-1";
        }
        return "0";
    }

    public static String AddPhoto(String order, String name) {
        try{
            init();
            String sql = "insert into photo (_order,name)VALUES('"+order+"','"+name+"');";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            closeUpdate();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
            return "-1";
        }
        return "0";
    }

    public static String UpdateText(String id, String order, String chapter, String name) {
        try{
            init();
            String sql = "update section set _order = "+order+" ,name ='"+name+"' ,chapter_id ='"+chapter+"' where id  = "+id;
            stmt.executeUpdate(sql);
            closeUpdate();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
            return "-1";
        }
        return "0";
    }

    public static String DeleteText(String id) {
        try {
            init();
            stmt.executeUpdate("delete from section where id =  "+id);
            closeQuery();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
            return "-1";
        }
        return "0";
    }

    public static String AddText(String order, String name, String chapter) {
        try{
            init();
            String sql = "insert into section (_order,name,chapter_id)VALUES('"+order+"','"+name+"','"+chapter+"');";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            closeUpdate();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
            return "-1";
        }
        return "0";
    }
}
