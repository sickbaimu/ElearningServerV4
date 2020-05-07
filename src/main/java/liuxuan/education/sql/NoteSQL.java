package liuxuan.education.sql;


import liuxuan.education.entity.Note;

import java.sql.SQLException;
import java.util.ArrayList;

public class NoteSQL extends BaseSQL {

    public static String AddNote(String userID, String type, String title, String tag, String content) {
        try{
            Class.forName(jdbc);
            init();
            String sql = "insert into note(user_id,shape,title,tag,content)VALUES('"+userID+"','"+type+"','"+title+"','"+tag+"','"+content+"');";
            stmt.executeUpdate(sql);
            closeUpdate();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
            return "-1";
        }
        return "0";
    }

    public static ArrayList<Note> GetNotes(String userID) {
        ArrayList<Note> notes = new ArrayList<>();
        //填入作品名
        try{
            init();
            rs = stmt.executeQuery("select *from note where user_id = "+userID);
            while(rs.next())
            {
                notes.add(new Note(rs.getString("id"),rs.getString("user_id"),
                        rs.getString("shape"),rs.getString("title"),
                        rs.getString("tag"),rs.getString("content")));
            }
            closeQuery();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
        }
        return notes;
    }
}
