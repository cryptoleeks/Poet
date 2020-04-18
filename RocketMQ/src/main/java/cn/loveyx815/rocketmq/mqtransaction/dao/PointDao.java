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

    /*
     * @Description: 插入积分对象入库
     * @Param: [point]
     * @Return: java.lang.String
     * @Author: Yonggang Shi
     * @Date: 2020/2/5/005 下午 11:41
     */
    public String insert(Point point){
        String id = UUID.randomUUID().toString().replace("-","");
        getJdbcTemplate().update("insert into t_point(id,user_id,amount) values(?,?,?)",(PreparedStatement ps)->{
            ps.setString(1,id);
            ps.setString(2,point.getUserId());
            ps.setInt(3,point.getAmount());
        });
        return id;
    }
    /*
     * @Description: 根据用户ID查找对应的积分记录
     * @Param: [userId]
     * @Return: cn.loveyx815.rocketmq.mqtransaction.bean.Point
     * @Author: Yonggang Shi
     * @Date: 2020/2/5/005 下午 11:42
     */
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
