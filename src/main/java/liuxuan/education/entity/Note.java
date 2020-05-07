package liuxuan.education.entity;

public class Note {
    String id;
    String userID;
    String shape;
    String title;
    String tag;
    String content;

    public Note(String id, String userID, String shape, String title, String tag, String content) {
        this.id = id;
        this.userID = userID;
        this.shape = shape;
        this.title = title;
        this.tag = tag;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
