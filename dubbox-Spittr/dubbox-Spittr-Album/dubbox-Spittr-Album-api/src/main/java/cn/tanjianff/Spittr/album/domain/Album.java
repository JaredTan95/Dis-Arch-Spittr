package cn.tanjianff.Spittr.album.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by tanjian on 2017/5/3.
 * 专辑实体类
 */
public class Album implements Serializable {
    private String id;
    private String singerid;
    private String title;
    private Date pubTime;
    private String descp;
    private int visRec;
    private String CoverUrl;

    public Album() {
    }

    public Album(String id, String singerid, String title, Date pubTime,
                 String descp, int visRec, String coverUrl) {
        this.id = id;
        this.singerid = singerid;
        this.title = title;
        this.pubTime = pubTime;
        this.descp = descp;
        this.visRec = visRec;
        CoverUrl = coverUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSingerid() {
        return singerid;
    }

    public void setSingerid(String singerid) {
        this.singerid = singerid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPubTime() {
        return pubTime;
    }

    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }

    public int getVisRec() {
        return visRec;
    }

    public void setVisRec(int visRec) {
        this.visRec = visRec;
    }

    public String getCoverUrl() {
        return CoverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        CoverUrl = coverUrl;
    }
}
