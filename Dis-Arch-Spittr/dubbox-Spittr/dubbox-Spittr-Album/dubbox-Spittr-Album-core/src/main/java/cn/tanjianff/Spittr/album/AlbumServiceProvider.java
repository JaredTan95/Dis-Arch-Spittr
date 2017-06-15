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

   /* @Autowired*/
    public AlbumServiceProvider(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Album> getAlbums() {
      return albumRepository.findAll();
    }

    @Override
    public Album save(Album album) {
        return albumRepository.save(album)?album:new Album();
    }

    @Override
    public Album getById(String id) {
        return albumRepository.findById(id);
    }

    @Override
    public  List<Album> getBySingerID(String singerId) {
        return albumRepository.findBySingerId(singerId);
    }

    @Override
    public  List<Album> getByTitle(String title) {
        return albumRepository.findByTitle(title);
    }

    @Override
    public List<Album> getByUpdate() {
        return albumRepository.orderByPubTime();
    }

    @Override
    public int getMax() {
        return albumRepository.count();
    }
}
