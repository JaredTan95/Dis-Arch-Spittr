package cn.tanjianff.Spittr.musicGenres.domain;

/**
 * Created by tanjian on 2017/5/15.
 * 专辑-单曲关系实体
 */
public class MusicGenre {
    private String albumId;
    private String musicId;

    public MusicGenre() {
    }

    public MusicGenre(String albumId, String musicId) {
        this.albumId = albumId;
        this.musicId = musicId;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getMusicId() {
        return musicId;
    }

    public void setMusicId(String musicId) {
        this.musicId = musicId;
    }
}
