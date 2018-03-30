package cn.tanjianff.Spittr.singer.domain;

import java.io.Serializable;

/**
 * Created by tanjian on 2017/5/10.
 * 歌手实体
 */
public class Singer implements Serializable{
    private String singerid;
    private String name;
    private int gender;
    private String descp;
    private int visi;
    private String pic;

    public Singer() {
    }

    public Singer(String singerid, String name, int gender, String descp, int visi, String pic) {
        this.singerid = singerid;
        this.name = name;
        this.gender = gender;
        this.descp = descp;
        this.visi = visi;
        this.pic = pic;
    }

    public String getSingerid() {
        return singerid;
    }

    public void setSingerid(String singerid) {
        this.singerid = singerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }

    public int getVisi() {
        return visi;
    }

    public void setVisi(int visi) {
        this.visi = visi;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
