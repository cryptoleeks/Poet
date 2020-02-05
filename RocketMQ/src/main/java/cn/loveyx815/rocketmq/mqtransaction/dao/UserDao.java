package cn.loveyx815.rocketmq.mqtransaction.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import cn.loveyx815.rocketmq.mqtransaction.bean.User;

/**
 * @Auther: Yonggang Shi
 * @Date: 2020/02/04 17:11
 * @Description: 用户表持久层
 */

public class UserDao extends JdbcDaoSupport {

//    @Qualifier("jdbcTemplate1")
//    private JdbcTemplate jdbcTemplate;
//    public void init(){
//        super.setJdbcTemplate(jdbcTemplate);
//    }
    public String getId(){
        String id= UUID.randomUUID().toString().replace("-","");
        return  id;
    }

    public String insert(String id,String userName){
        getJdbcTemplate().update("insert into t_user(id,user_name) values(?,?)",(PreparedStatement ps )->{
            ps.setString(1,id);
            ps.setString(2,userName);
        });
        return id;
    }

    public User getById(String userId){
        return getJdbcTemplate().queryForObject("select id,user_name from t_user where id ='"+userId+"'",(ResultSet rs,int rowNum)->{
            User user =new User();
            user.setId(rs.getString("id"));
            user.setUserName(rs.getString("user_name"));
            return  user;
        });
    }

}
