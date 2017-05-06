package cn.tanjianff.Spittr.album;

import cn.tanjianff.Spittr.album.domain.Album;
import cn.tanjianff.Spittr.album.repository.AlbumRepository;

import java.util.List;

/**
 * Created by tanjian on 2017/5/3.
 * 专辑服务提供者
 */
public class AlbumServiceProvider implements AlbumService {
    private AlbumRepository albumRepository;

    public AlbumServiceProvider(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Album> getAlbums() {
      return albumRepository.findAll();
    }
}
