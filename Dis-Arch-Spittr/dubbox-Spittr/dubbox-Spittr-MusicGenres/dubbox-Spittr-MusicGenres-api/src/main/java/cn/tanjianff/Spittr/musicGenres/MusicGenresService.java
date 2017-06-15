package cn.tanjianff.Spittr.musicGenres;

import cn.tanjianff.Spittr.musicGenres.domain.MusicGenre;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tanjian on 2017/5/15.
 */
public interface MusicGenresService extends Serializable{
  List<MusicGenre> getMusicGenres(int count);
  MusicGenre save(MusicGenre musicGenre);
  MusicGenre getByMusicGenreId(String id);

  int getMax();

}
