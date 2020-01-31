package cn.loveyx815.apidemo.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ApiMapper {

    public List<Map<String,Object>> getGoodList(@Param("index") int index,@Param("offset") int offset);

    public int getCountGoods();

    public Map<String ,Object> getGoodInfo(@Param("id") int id);

    public List<Map<String,Object>> getCarList(@Param("ids") String ids);
}

