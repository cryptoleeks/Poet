package cn.loveyx815.apidemo.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.loveyx815.apidemo.dao.ApiMapper;

@Service
public class ApiService {

    @Autowired
    private ApiMapper apiMapper;

    public List<Map<String,Object>> getGoodList(int page){
        int size=4;
        int index = page-1;
        List<Map<String, Object>> goodList = apiMapper.getGoodList(index * size, size);
        return goodList;
    }

    public Map<String ,Object> getGoodInfo(int  sid){
        int id = sid;
        Map<String, Object> goodInfo = apiMapper.getGoodInfo(id);
        return goodInfo;

    }

    public Object getCarList(String ids) {
        String[] strings = ids.split(",");
        return     apiMapper.getCarList(ids);

    }
}
