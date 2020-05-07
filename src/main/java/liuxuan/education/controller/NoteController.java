package liuxuan.education.controller;

import liuxuan.education.entity.Note;
import liuxuan.education.sql.NoteSQL;
import liuxuan.education.sql.UserSQL;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class NoteController {
    @ResponseBody
    @RequestMapping("/AddNote")
    public String AddNote(String userID,String type,String title,String TAG,String content){
       return NoteSQL.AddNote(userID,type,title,TAG,content);
    }

    @ResponseBody
    @RequestMapping("/GetNotes")
    public ArrayList<Note> GetNotes(String userID){
        return NoteSQL.GetNotes(userID);
    }
}
