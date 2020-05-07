package liuxuan.education.patch;

public class TextContent {
    private String flag;
    private String chapter_name;
    private String chapter_order;
    private String section_name;

    private String section_order;
    private String content;

    public TextContent(String flag, String chapter_name, String chapter_order, String section_name, String section_order, String content) {
        this.flag = flag;
        this.chapter_name = chapter_name;
        this.chapter_order = chapter_order;
        this.section_name = section_name;
        this.section_order = section_order;
        this.content = content;
    }

    public String getChapter_name() {
        return chapter_name;
    }

    public void setChapter_name(String chapter_name) {
        this.chapter_name = chapter_name;
    }

    public String getChapter_order() {
        return chapter_order;
    }

    public void setChapter_order(String chapter_order) {
        this.chapter_order = chapter_order;
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

    public String getSection_order() {
        return section_order;
    }

    public void setSection_order(String section_order) {
        this.section_order = section_order;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
