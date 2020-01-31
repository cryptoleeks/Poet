package cn.loveyx815.apidemo.utils;

import com.alibaba.fastjson.JSONObject;

public class ResultUtil {

    public  static  Object buildResultJSON(int code,Object message){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("status",code);
        jsonObject.put("message",message);
    return jsonObject;
    }
}
