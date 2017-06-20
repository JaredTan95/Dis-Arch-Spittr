package cn.tanjianff.Spittr.user.repository.JdbcTemplate;

import cn.tanjianff.Spittr.user.domain.User;
import cn.tanjianff.Spittr.user.repository.UserRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by tanjian on 2017/5/15.
 * 基于JdbcTemplate实现User用户存储接口
 */
public class JdbcUserRepository implements UserRepository {
    private static final String SELECT_USER_BY_NAME_PWD = "SELECT s_userid,s_uaccount,s_upwdsalt,s_upwd,s_unickname,s_uemail,s_unone FROM S_users WHERE s_uaccount=? AND s_upwd=?;";
    private static final String COUNT = "SELECT s_userid FROM S_users;";
    private static final String SELECT_ONE_BY_USER_ACCOUNT = "SELECT s_userid,s_uaccount,s_upwdsalt,s_upwd,s_unickname,s_uemail,s_unone FROM S_users where s_uaccount=?;";
    private static final String SELECT_ONE_BY_USER_ID = "SELECT s_userid,s_uaccount,s_upwdsalt,s_upwd,s_unickname,s_uemail,s_unone FROM S_users where s_userid=?;";
    private static final String SELECT_ONE_BY_USER_NICKNAME_REG = "SELECT s_userid,s_uaccount,s_upwdsalt,s_upwd,s_unickname,s_uemail,s_unone FROM S_users where s_unickname REGEXP ?;";
    private static final String SELECT_ALL = "SELECT s_userid,s_uaccount,s_upwdsalt,s_upwd,s_unickname,s_uemail,s_unone FROM S_users;";
    private static final String INSERT_INTO_USER = "INSERT INTO S_users (s_userid,s_uaccount,s_upwdsalt,s_upwd,s_unickname,s_uemail,s_unone) VALUES(?,?,?,?,?,?,?);";
    private static final String SELECT_BY_NICKNAME_REGEXP="SELECT s_userid,s_uaccount,s_upwdsalt,s_upwd,s_unickname,s_uemail,s_unone FROM S_users WHERE s_unickname REGEXP ?";
    private static final String LOGIN_VALI="SELECT * FROM S_users WHERE s_uaccount=? AND s_upwd=?";

    private JdbcTemplate jdbcTemplate;

    public JdbcUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int count() {
        return jdbcTemplate.getMaxRows();
    }

    @Override
    public boolean save(User user) {
        return jdbcTemplate.update(INSERT_INTO_USER,new UserRowMapper(),user.getId()
                                    ,user.getAccount(),user.getPwdsalt(),user.getPasswd()
                                    ,user.getNickname(),user.getEmail(),user.getUnone())>0;
    }

    @Override
    public User findById(String id) {
        return jdbcTemplate.queryForObject(SELECT_ONE_BY_USER_ID,new UserRowMapper(),id);
    }

    @Override
    public User findByAccount(String account) {
        return jdbcTemplate.queryForObject(SELECT_ONE_BY_USER_ACCOUNT,new UserRowMapper(),account);
    }

    @Override
    public List<User> findByNickName(String nickname) {
        return jdbcTemplate.query(SELECT_ONE_BY_USER_NICKNAME_REG,new UserRowMapper(),nickname);
    }

    @Override
    public boolean update(User user) {
        //TODO:更新用户信息
        return false;
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SELECT_ALL,new UserRowMapper());
    }

    @Override
    public User isExists(String name, String pwd) throws DataAccessException {
        return jdbcTemplate.queryForObject(LOGIN_VALI,new UserRowMapper(),name,pwd);
    }

    private static final class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            return new User( resultSet.getString("s_userid")
                    , resultSet.getString("s_uaccount")
                    , resultSet.getString("s_upwdsalt")
                    , resultSet.getString("s_upwd")
                    , resultSet.getString("s_unickname")
                    , resultSet.getString("s_uemail")
                    , resultSet.getString("s_unone"));
        }
    }
}
