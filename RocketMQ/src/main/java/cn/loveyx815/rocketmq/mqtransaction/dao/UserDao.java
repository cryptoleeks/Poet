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

    /*
     * @Description: 通过UUID生成用户ID
     * @Param: []
     * @Return: java.lang.String
     * @Author: Yonggang Shi
     * @Date: 2020/2/5/005 下午 11:43
     */
    public String getId(){
        String id= UUID.randomUUID().toString().replace("-","");
        return  id;
    }
    /*
     * @Description: 向库中插入新用户
     * @Param: [id, userName]
     * @Return: java.lang.String
     * @Author: Yonggang Shi
     * @Date: 2020/2/5/005 下午 11:43
     */
    public String insert(String id,String userName){
        getJdbcTemplate().update("insert into t_user(id,user_name) values(?,?)",(PreparedStatement ps )->{
            ps.setString(1,id);
            ps.setString(2,userName);
        });
        return id;
    }
    /*
     * @Description: 通过用户ID查找用户
     * @Param: [userId]
     * @Return: cn.loveyx815.rocketmq.mqtransaction.bean.User
     * @Author: Yonggang Shi
     * @Date: 2020/2/5/005 下午 11:44
     */
    public User getById(String userId){
        return getJdbcTemplate().queryForObject("select id,user_name from t_user where id ='"+userId+"'",(ResultSet rs,int rowNum)->{
            User user =new User();
            user.setId(rs.getString("id"));
            user.setUserName(rs.getString("user_name"));
            return  user;
        });
    }

}
