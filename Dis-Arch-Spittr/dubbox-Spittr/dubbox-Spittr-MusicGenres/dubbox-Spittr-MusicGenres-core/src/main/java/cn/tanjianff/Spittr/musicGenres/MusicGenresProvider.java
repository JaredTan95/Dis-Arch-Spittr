package cn.tanjianff.Spittr.musicGenres;

import cn.tanjianff.Spittr.musicGenres.domain.MusicGenre;
import cn.tanjianff.Spittr.musicGenres.repository.MusicGenresRepository;

import java.util.List;

/**
 * Created by tanjian on 2017/5/20.
 */
public class MusicGenresProvider implements MusicGenresService {
    private MusicGenresRepository musicGenresRepository;
    @Override
    public List<MusicGenre> getMusicGenres() {
        return null;
    }

    @Override
    public MusicGenre save(MusicGenre musicGenre) {
        return musicGenresRepository.save(musicGenre)?musicGenre:new MusicGenre();
    }

    @Override
    public MusicGenre getByMusicGenreId(String id) {
        return null;
    }

    @Override
    public int getMax() {
        return musicGenresRepository.count();
    }
}
