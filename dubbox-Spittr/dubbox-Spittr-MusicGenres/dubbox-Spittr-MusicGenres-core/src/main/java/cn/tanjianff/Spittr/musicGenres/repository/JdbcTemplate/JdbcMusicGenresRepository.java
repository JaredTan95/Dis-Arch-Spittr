package cn.tanjianff.Spittr.musicGenres.repository.JdbcTemplate;

import cn.tanjianff.Spittr.musicGenres.domain.MusicGenre;
import cn.tanjianff.Spittr.musicGenres.repository.MusicGenresRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by tanjian on 2017/5/20.
 */
public class JdbcMusicGenresRepository implements MusicGenresRepository {
    private static final String INSERT_INTO="INSERT INTO S_MusicAblumRelationship (s_aid,s_songid) VALUES (?,?);";
    private static final String SELECT_BY_ALBUM_ID="SELECT s_aid,s_songid FROM S_MusicAblumRelationship WHERE s_aid=?;";
    private static final String SELECT_BY_SONG_ID="SELECT s_aid,s_songid FROM S_MusicAblumRelationship WHERE s_songid=?;";
    private static final String SELET_TOP_CLOUT="SELECT * FROM S_albums order by s_avisRec desc limit ?";

    private static final String SELECT_MUSIC_BY_RELATION="SELECT musAlRel.s_aid,s.s_songid,s.s_singerid,s.s_title" +
            ",S_singer.s_sname,S_albums.s_atitle,s.s_surl,s.s_visited,s.s_visitedTotal" +
            ",s.s_dloaded,s.s_scover,s.s_smvurl,s.s_songdescp " +
            "FROM S_MusicAblumRelationship musAlRel, S_song s, S_singer, S_albums " +
            "WHERE musAlRel.s_songid=s.s_songid AND S_singer.s_singerid=s.s_singerid " +
            "AND S_albums.s_aid=musAlRel.s_aid AND musAlRel.s_aid=?";
    private JdbcTemplate jdbcTemplate;

    public JdbcMusicGenresRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean save(MusicGenre musicGenre) {
        return jdbcTemplate.update(INSERT_INTO,new MusicGenresRowMapper(),musicGenre.getAlbumId(),musicGenre.getMusicId())>0;
    }

    @Override
    public List<MusicGenre> findBySongId(String id) {
        return jdbcTemplate.query(SELECT_BY_SONG_ID,new MusicGenresRowMapper());
    }

    @Override
    public MusicGenre getByAlbumId(String id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ALBUM_ID,new MusicGenresRowMapper());
    }

    @Override
    public List<MusicGenre> getTop(int count) {
        return jdbcTemplate.query(SELET_TOP_CLOUT,new MusicGenresRowMapper(),count);
    }

    @Override
    public int count() {
        return jdbcTemplate.getMaxRows();
    }

    private static final class MusicGenresRowMapper implements RowMapper<MusicGenre>{
        @Override
        public MusicGenre mapRow(ResultSet resultSet, int i) throws SQLException {
            return new MusicGenre(resultSet.getString("s_aid"),resultSet.getString("s_songid"));
        }
    }
}
