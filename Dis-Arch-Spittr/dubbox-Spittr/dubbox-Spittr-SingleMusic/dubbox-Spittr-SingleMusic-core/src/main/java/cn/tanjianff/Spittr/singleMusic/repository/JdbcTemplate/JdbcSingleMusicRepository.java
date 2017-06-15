package cn.tanjianff.Spittr.singleMusic.repository.JdbcTemplate;

import cn.tanjianff.Spittr.singleMusic.domain.SingleMusic;
import cn.tanjianff.Spittr.singleMusic.repository.SingleMusicRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by tanjian on 2017/5/15.
 * 基于JdbcTemplate实现单曲存储接口
 */
public class JdbcSingleMusicRepository implements SingleMusicRepository {
    private static final String COUNT_SONG="SELECT s_songid FROM S_song;";
    private static final String SELECT_ALL_SONGS="SELECT * FROM S_song;";
    private static final String SELECT_BY_ID="SELECT * FROM S_song WHERE s_songid=?;";
    private static final String SELECT_BY_SINGER_ID="SELECT * FROM S_song WHERE s_singerid=?;";
    private static final String SELECT_BY_TITLE_REG="SELECT s_songid,s_singerid,s_title,s_surl,s_visited,s_visitedTotal,s_dloaded,s_scover,s_smvurl,s_songdescp FROM S_song WHERE s_title REGEXP ?;";
    private static final String INSERT_SONG="INSERT INTO S_song" +
            "(s_songid,s_singerid,s_title,s_surl,s_visited,s_visitedTotal" +
            ",s_dloaded,s_scover,s_smvurl,s_songdescp)" +
            "VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static final String QUERY_BY_VISITEDNUM="SELECT s_songid,s_singerid,s_title,s_surl,s_visited," +
            "s_visitedTotal,s_dloaded,s_scover,s_smvurl,s_songdescp" +
            " FROM S_song ORDER BY s_visitedTotal DESC LIMIT 8;";
    private static final String QUERY_BY_DOWNLOADEDNUM="SELECT s_songid,s_singerid,s_title,s_surl,s_visited," +
            "s_visitedTotal,s_dloaded,s_scover,s_smvurl,s_songdescp" +
            " FROM S_song ORDER BY s_dloaded DESC LIMIT 8;";
    private static final String ADD_UP_VISITEDNUM="UPDATE S_song SET s_visited=s_visited+1," +
            " s_visitedTotal=s_visitedTotal+1 WHERE s_songid=?;";

    private static final String ORDER_BY_UPDATE="SELECT * FROM S_song ORDER BY update_time DESC LIMIT 12";

    private JdbcTemplate jdbcTemplate;

    public JdbcSingleMusicRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean save(SingleMusic song) {
        return jdbcTemplate.update(INSERT_SONG,new SingleMusicRowMapper(),song.getSongId(),song.getSingerId()
                                    ,song.getTitle(),song.getUrl(),song.getVisited(),song.getVisitedTotal()
                                    ,song.getDloaded(),song.getCover(),song.getMvurl(),song.getDescp())>0;
    }

    @Override
    public int count() {
        return jdbcTemplate.getMaxRows();
    }

    @Override
    public SingleMusic findById(String id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID,new SingleMusicRowMapper(),id);
    }

    @Override
    public List<SingleMusic> findBySingerId(String id) {
        return jdbcTemplate.query(SELECT_BY_SINGER_ID,new SingleMusicRowMapper(),id);
    }

    @Override
    public List<SingleMusic> findAll() {
        return jdbcTemplate.query(SELECT_ALL_SONGS,new SingleMusicRowMapper());
    }

    @Override
    public List<SingleMusic> findByTitle(String title) {
        return jdbcTemplate.query(SELECT_BY_TITLE_REG,new SingleMusicRowMapper(),title);
    }

    @Override
    public List<SingleMusic> OrderByVisited() {
        return jdbcTemplate.query(QUERY_BY_VISITEDNUM,new SingleMusicRowMapper());
    }

    @Override
    public List<SingleMusic> OrderByDloaded() {
        return jdbcTemplate.query(QUERY_BY_DOWNLOADEDNUM,new SingleMusicRowMapper());
    }

    @Override
    public List<SingleMusic> OrderByUpDate() {
        return jdbcTemplate.query(ORDER_BY_UPDATE,new SingleMusicRowMapper());
    }

    @Override
    public boolean IncrVisit(String songId) {
        return jdbcTemplate.update(ADD_UP_VISITEDNUM,new SingleMusicRowMapper(),songId)>0;
    }

    private static final class SingleMusicRowMapper implements RowMapper<SingleMusic>{
        @Override
        public SingleMusic mapRow(ResultSet resultSet, int i) throws SQLException {
            return new SingleMusic(resultSet.getString("s_songid")
                    , resultSet.getString("s_singerid")
                    , resultSet.getString("s_title")
                    , resultSet.getString("s_surl")
                    ,resultSet.getInt("s_visited")
                    ,resultSet.getInt("s_visitedTotal")
                    ,resultSet.getInt("s_dloaded")
                    ,resultSet.getString("s_scover")
                    ,resultSet.getString("s_smvurl")
                    ,resultSet.getString("s_songdescp"));
        }
    }
}
