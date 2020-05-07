package liuxuan.education.entity;

import java.util.Date;

/**
 * @author lele
 * @version 1.00
 * @description
 * @Date 2019/7/11 13:30
 */
public class MBBS {
    private int id;
    private String content;
    private String user;
    private Date time;

    public MBBS(int id, String content, String user, Date time) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
