package liuxuan.education.entity;

public class TextSection {
    private String id;
    private String order;
    private String chapter_id;
    private String name;

    public TextSection(String id, String order, String chapter_id, String name) {
        this.id = id;
        this.order = order;
        this.chapter_id = chapter_id;
        this.name = name;
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

    public String getChapter_id() {
        return chapter_id;
    }

    public void setChapter_id(String chapter_id) {
        this.chapter_id = chapter_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
