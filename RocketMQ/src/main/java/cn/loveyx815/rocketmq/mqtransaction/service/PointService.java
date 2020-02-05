package cn.loveyx815.rocketmq.mqtransaction.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.loveyx815.rocketmq.mqtransaction.bean.Point;
import cn.loveyx815.rocketmq.mqtransaction.common.BusinessException;
import cn.loveyx815.rocketmq.mqtransaction.dao.PointDao;

/**
 * @Auther: Yonggang Shi
 * @Date: 2020/02/04 21:36
 * @Description: 积分业务逻辑
 */
@Service
public class PointService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private PointDao pointDao;

    @Transactional(rollbackFor = Exception.class)
    public String savePoint(Point point){
        if ((point!=null) && (point.getUserId() != null)){
            Point queryPoint = pointDao.getByUserId(point.getUserId());
            if (queryPoint != null){
                return  queryPoint.getId();
            }else {
                return pointDao.insert(point);
            }
        }else {
             throw new BusinessException("入参不能为空");
        }
    }
}
