package cn.tanjianff.Spittr.album;

import cn.tanjianff.Spittr.album.domain.Album;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tanjian on 2017/5/3.
 */
public interface AlbumService extends Serializable{

    /**
     * Gets albums.
     *
     * @return the albums
     */
    List<Album> getAlbums();

    /**
     * Save album.
     *
     * @param album the album
     * @return the album
     */
    Album save(Album album);

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    Album getById(String id);

    /**
     * Gets by singer id.
     *
     * @param id the id
     * @return the by singer id
     */
    List<Album> getBySingerID(String id);

    /**
     * Gets by title.
     *
     * @param id the id
     * @return the by title
     */
    List<Album> getByTitle(String id);

    /**
     * Gets by update.
     *
     * @return the by update
     */
    List<Album> getByUpdate();

    /**
     * 依据点击量获取一定数量的热门专辑
     *
     * @param lmt 获取的数量
     * @return 专辑集合(List)
     */
    List<Album> getByVisited(int lmt);

    /**
     * Gets max.
     *
     * @return the max
     */
    int getMax();
}
