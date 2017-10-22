package cn.tanjianff.Spittr.musicGenres;

import cn.tanjianff.Spittr.musicGenres.domain.MusicGenre;
import cn.tanjianff.Spittr.musicGenres.repository.MusicGenresRepository;

import java.util.List;

/**
 * Created by tanjian on 2017/5/20.
 */
public class MusicGenresProvider implements MusicGenresService {
    private MusicGenresRepository musicGenresRepository;

    //TODO:专辑服务未完善,分页
    public MusicGenresProvider(MusicGenresRepository musicGenresRepository) {
        this.musicGenresRepository = musicGenresRepository;
    }

    @Override
    public List<MusicGenre> getMusicGenres(int count) {
        return musicGenresRepository.getTop(count);
    }

    @Override
    public MusicGenre save(MusicGenre musicGenre) {
        return musicGenresRepository.save(musicGenre)?musicGenre:new MusicGenre();
    }

    @Override
    public MusicGenre getByMusicGenreId(String id) {
        return musicGenresRepository.getByAlbumId(id);
    }

    @Override
    public int getMax() {
        return musicGenresRepository.count();
    }
}
