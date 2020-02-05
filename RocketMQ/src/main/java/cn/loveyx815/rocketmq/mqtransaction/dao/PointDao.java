package cn.loveyx815.rocketmq.mqtransaction.dao;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import cn.loveyx815.rocketmq.mqtransaction.bean.Point;

/**
 * @Auther: Yonggang Shi
 * @Date: 2020/02/04 17:25
 * @Description: 积分表持久层
 */
public class PointDao extends JdbcDaoSupport {

//    @Qualifier("jdbcTemplate2")
//    private JdbcTemplate jdbcTemplate;
//    public void init(){
//        super.setJdbcTemplate(jdbcTemplate);
//    }
    public String insert(Point point){
        String id = UUID.randomUUID().toString().replace("-","");
        getJdbcTemplate().update("insert into t_point(id,user_id,amount) values(?,?,?)",(PreparedStatement ps)->{
            ps.setString(1,id);
            ps.setString(2,point.getUserId());
            ps.setInt(3,point.getAmount());
        });
        return id;
    }

    public Point getByUserId(String userId){
        List<Map<String ,Object>> list = getJdbcTemplate().queryForList("select id,user_id,amount from t_point where user_id ='"+userId+"'");
        if ((list==null) || (list.size()==0)){
            return null;
        }else {
            Point point = new Point();
            point.setId((String) list.get(0).get("id"));
            point.setUserId((String) list.get(0).get("user_id"));
            point.setAmount((Integer) list.get(0).get("amount"));
            return  point;
        }

    }


}
