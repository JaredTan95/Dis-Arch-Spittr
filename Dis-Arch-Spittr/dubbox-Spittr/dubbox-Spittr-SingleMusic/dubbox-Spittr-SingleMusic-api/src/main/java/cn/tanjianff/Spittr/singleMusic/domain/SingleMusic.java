package cn.tanjianff.Spittr.singleMusic.domain;

/**
 * Created by tanjian on 2017/5/15.
 * 单曲实体
 */
public class SingleMusic {
    private String songId;
    private String singerId;
    private String title;
    private String url;
    private int visited;
    private int visitedTotal;
    private int dloaded;
    private String cover;
    private String mvurl;
    private String descp;

    public SingleMusic() {
    }

    public SingleMusic(String songId, String singerId,
                       String title, String url, int visited,
                       int visitedTotal, int dloaded, String cover,
                       String mvurl, String descp) {
        this.songId = songId;
        this.singerId = singerId;
        this.title = title;
        this.url = url;
        this.visited = visited;
        this.visitedTotal = visitedTotal;
        this.dloaded = dloaded;
        this.cover = cover;
        this.mvurl = mvurl;
        this.descp = descp;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSingerId() {
        return singerId;
    }

    public void setSingerId(String singerId) {
        this.singerId = singerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getVisited() {
        return visited;
    }

    public void setVisited(int visited) {
        this.visited = visited;
    }

    public int getVisitedTotal() {
        return visitedTotal;
    }

    public void setVisitedTotal(int visitedTotal) {
        this.visitedTotal = visitedTotal;
    }

    public int getDloaded() {
        return dloaded;
    }

    public void setDloaded(int dloaded) {
        this.dloaded = dloaded;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getMvurl() {
        return mvurl;
    }

    public void setMvurl(String mvurl) {
        this.mvurl = mvurl;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }
}
