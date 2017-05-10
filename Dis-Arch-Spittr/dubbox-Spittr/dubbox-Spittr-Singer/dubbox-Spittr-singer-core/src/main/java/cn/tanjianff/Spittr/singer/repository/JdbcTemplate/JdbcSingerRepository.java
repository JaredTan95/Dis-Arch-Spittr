package cn.tanjianff.Spittr.singer.repository.JdbcTemplate;

import cn.tanjianff.Spittr.singer.domain.Singer;
import cn.tanjianff.Spittr.singer.repository.SingerRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by tanjian on 2017/5/10.
 */
public class JdbcSingerRepository implements SingerRepository{
    private static final String SELECT_ALL_SINGERS="SELECT s_singerid,s_sname,s_sgender,s_singerdescp,s_svisi,s_spic FROM S_singer;";
    private static final String SELECT_BY_NAME_REG="SELECT s_singerid,s_sname,s_sgender,s_singerdescp,s_svisi,s_spic FROM S_singer WHERE s_sname REGEXP ?;";
    private static final String SELECT_BY_ID="SELECT s_singerid,s_sname,s_sgender,s_singerdescp,s_svisi,s_spic FROM S_singer WHERE s_singerid=?;";
    private static final String COUNT_SINGERS="SELECT s_singerid FROM S_singer;";
    private static final String INSERT_SINGER="INSERT INTO S_singer" +
            "(s_singerid,s_sname,s_sgender,s_singerdescp,s_svisi,s_spic) values ( ?, ?, ?, ?, ?,?);";

    private JdbcTemplate jdbcTemplate;

    public JdbcSingerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int count() {
        return jdbcTemplate.getMaxRows();
    }

    @Override
    public boolean save(Singer singer) {
        return jdbcTemplate.update(INSERT_SINGER,new SingerRowMapper()
                    ,singer.getSingerid(),singer.getName()
                    ,singer.getGender(),singer.getDescp()
                    ,singer.getVisi(),singer.getPic())>0;
    }

    @Override
    public Singer findById(String id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID,new SingerRowMapper(),id);
    }

    @Override
    public List<Singer> findByName(String name) {
        return jdbcTemplate.query(SELECT_BY_NAME_REG,new SingerRowMapper(),name);
    }

    @Override
    public List<Singer> findAll() {
        return jdbcTemplate.query(SELECT_ALL_SINGERS,new SingerRowMapper());
    }

    private static final class SingerRowMapper implements RowMapper<Singer>{
        @Override
        public Singer mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Singer(resultSet.getString("s_singerid"),resultSet.getString("s_sname")
                                ,resultSet.getInt("s_sgender"),resultSet.getString("s_singerdescp")
                                ,resultSet.getInt("s_svisi"),resultSet.getString("s_spic"));
        }
    }
}
