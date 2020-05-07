package liuxuan.education.entity;

import java.util.Date;

public class CBBS {
    String content;
    String user;
    String time;
    int order;

    public CBBS(String content, String user, String time, int order) {
        this.content = content;
        this.user = user;
        this.time = time;
        this.order = order;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
