package cn.tanjianff.Spittr.user.domain;

import java.io.Serializable;

/**
 * Created by tanjian on 2017/5/15.
 *  用户实体
 */
public class User implements Serializable{
    private String id;
    private String account;
    private String pwdsalt;
    private String passwd;
    private String nickname;
    private String email;
    private String Unone;

    public User() {
    }

    public User(String id, String account, String pwdsalt, String passwd,
                String nickname, String email, String unone) {
        this.id = id;
        this.account = account;
        this.pwdsalt = pwdsalt;
        this.passwd = passwd;
        this.nickname = nickname;
        this.email = email;
        Unone = unone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwdsalt() {
        return pwdsalt;
    }

    public void setPwdsalt(String pwdsalt) {
        this.pwdsalt = pwdsalt;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUnone() {
        return Unone;
    }

    public void setUnone(String unone) {
        Unone = unone;
    }

    public String getAccount() {

        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
