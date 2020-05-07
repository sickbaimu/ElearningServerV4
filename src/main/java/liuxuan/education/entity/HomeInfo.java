package liuxuan.education.entity;

import java.util.ArrayList;

/**
 * @author lele
 * @version 1.00
 * @description
 * @Date 2019/7/12 21:42
 */
public class HomeInfo {
    private String textList;
    private String photoList;
    private String mediaList;
    private ArrayList<MBBS> bbsList;
    private String rate;

    public HomeInfo(String textList, String photoList, String mediaList, ArrayList<MBBS> bbsList, String rate) {
        this.textList = textList;
        this.photoList = photoList;
        this.mediaList = mediaList;
        this.bbsList = bbsList;
        this.rate = rate;
    }

    public String getTextList() {
        return textList;
    }

    public void setTextList(String textList) {
        this.textList = textList;
    }

    public String getPhotoList() {
        return photoList;
    }

    public void setPhotoList(String photoList) {
        this.photoList = photoList;
    }

    public String getMediaList() {
        return mediaList;
    }

    public void setMediaList(String mediaList) {
        this.mediaList = mediaList;
    }

    public ArrayList<MBBS> getBbsList() {
        return bbsList;
    }

    public void setBbsList(ArrayList<MBBS> bbsList) {
        this.bbsList = bbsList;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
