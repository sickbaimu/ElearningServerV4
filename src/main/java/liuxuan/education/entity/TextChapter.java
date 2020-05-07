package liuxuan.education.entity;

import java.util.ArrayList;

public class TextChapter {
    private String id;
    private String order;
    private String name;
    private ArrayList<TextSection> textSections;

    public TextChapter(String id, String order, String name, ArrayList<TextSection> textSections) {
        this.id = id;
        this.order = order;
        this.name = name;
        this.textSections = textSections;
    }

    public void setTextSections(ArrayList<TextSection> textSections) {
        this.textSections = textSections;
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

    public ArrayList<TextSection> getTextSections() {
        return textSections;
    }
}
