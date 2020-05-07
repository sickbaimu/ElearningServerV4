package liuxuan.education.entity;

public class MyMedia {
    String id;
    String order;
    String name;
    String path;

    public MyMedia(String id, String order, String name, String path) {
        this.id = id;
        this.order = order;
        this.name = name;
        this.path = path;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
