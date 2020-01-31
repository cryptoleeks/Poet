package cn.loveyx815.apidemo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.loveyx815.apidemo.service.ApiService;
import cn.loveyx815.apidemo.utils.ResultUtil;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class Apicontroller {

    @Autowired
    private ApiService service;


    @GetMapping("/getgoods")
    public Object getgoods(@RequestParam("pageindex") int pagenum){
        return ResultUtil.buildResultJSON(0,service.getGoodList(pagenum)) ;
    }

    @GetMapping("/goods/getshopcarlist/{ids}")
    public Object getshopcarlist(@PathVariable(value="ids") String ids){
        return ResultUtil.buildResultJSON(0,service.getCarList(ids)) ;
    }

    @GetMapping("/goodsinfo/{id}")
    public Object getGoodsinfo(@PathVariable(value="id") Integer id){
        return ResultUtil.buildResultJSON(0,service.getGoodInfo(id));
    }

    @GetMapping("/api")
    public Object getapi(HttpServletRequest request){
        HttpSession session = request.getSession();
        Object api = session.getAttribute("api");
        if (api==null){
            api="{\"name\":\"test\"}";
        }
        return api;
    }
    @GetMapping("/expressfind")
    public Object expressfind(HttpServletRequest request,@RequestParam(value="code",required = false)String code,@RequestParam(value="cb",required = false)String cb){
       String successResult="{\"msg\":\"\",\"status\":\"0\",\"error_code\":\"0\",\"data\":{\"info\":{\"status\":\"1\",\"com\":\"baishikuaidi\",\"state\":\"3\",\"send_time\":\"2019-08-09\",\"departure_city\":\"\\u91d1\\u534e\\u5e02\",\"arrival_city\":\"\\u5357\\u4eac\\u5e02\",\"latest_progress\":\"\\u5357\\u4eac2019-08-10 18:56:21\\u5ba2\\u6237\\u5df2\\u53d6\\u4ef6\\uff0c\\u63d0\\u8d27\\u70b9\\uff1a\\u3010\\u4e91\\u67dc\\u3011 \\u65b0\\u6cb3\\u82d1\\u4e8c\\u671f\\u5317\\u82d1\\uff0813291265712 \\u5357\\u4eac\\u5e02\\u96e8\\u82b1\\u53f0\\u533a\\u6625\\u56ed\\u8def30\\u53f7\\u6625\\u6c5f\\u65b0\\u57ce\\u65b0\\u6cb3\\u82d1\\u4e8c\\u671f\\u95e8\\u536b\\u5ba4\\u65c1\\uff09\",\"context\":[{\"time\":\"1565434581\",\"desc\":\"\\u5ba2\\u6237\\u5df2\\u53d6\\u4ef6\\uff0c\\u63d0\\u8d27\\u70b9\\uff1a\\u3010\\u4e91\\u67dc\\u3011 \\u65b0\\u6cb3\\u82d1\\u4e8c\\u671f\\u5317\\u82d1\\uff0813291265712 \\u5357\\u4eac\\u5e02\\u96e8\\u82b1\\u53f0\\u533a\\u6625\\u56ed\\u8def30\\u53f7\\u6625\\u6c5f\\u65b0\\u57ce\\u65b0\\u6cb3\\u82d1\\u4e8c\\u671f\\u95e8\\u536b\\u5ba4\\u65c1\\uff09\"},{\"time\":\"1565434581\",\"desc\":\"\\u5df2\\u7b7e\\u6536\\uff0c\\u7b7e\\u6536\\u4eba\\u51ed\\u53d6\\u8d27\\u7801\\u7b7e\\u6536\\u3002\"},{\"time\":\"1565410535\",\"desc\":\"\\u6d3e\\u4ef6\\u9001\\u8fbe\\u3010\\u4e91\\u67dc\\u3011\\u65b0\\u6cb3\\u82d1\\u4e8c\\u671f\\u5317\\u82d1\\uff0c\\u8bf7\\u524d\\u5f80\\u5357\\u4eac\\u5e02\\u96e8\\u82b1\\u53f0\\u533a\\u6625\\u56ed\\u8def30\\u53f7\\u6625\\u6c5f\\u65b0\\u57ce\\u65b0\\u6cb3\\u82d1\\u4e8c\\u671f\\u95e8\\u536b\\u5ba4\\u65c1\\u9886\\u53d6\\u60a8\\u7684\\u5305\\u88f9\\uff0c\\u8054\\u7cfb\\u7535\\u8bdd\\uff1a13291265712\"},{\"time\":\"1565399633\",\"desc\":\"\\u5357\\u4eac\\u5e02\\u3010\\u5357\\u4eac\\u96e8\\u82b1\\u4e5d\\u5206\\u90e8\\u3011\\uff0c\\u3010\\u559c\\u6d0b\\u6d0b\\/13291265712\\u3011\\u6b63\\u5728\\u6d3e\\u4ef6\"},{\"time\":\"1565399573\",\"desc\":\"\\u5230\\u5357\\u4eac\\u5e02\\u3010\\u5357\\u4eac\\u96e8\\u82b1\\u4e5d\\u5206\\u90e8\\u3011\"},{\"time\":\"1565398079\",\"desc\":\"\\u5357\\u4eac\\u5e02\\u3010\\u96e8\\u82b1\\u5206\\u90e8\\u3011\\uff0c\\u6b63\\u53d1\\u5f80\\u3010\\u5357\\u4eac\\u96e8\\u82b1\\u4e5d\\u5206\\u90e8\\u3011\"},{\"time\":\"1565379001\",\"desc\":\"\\u5357\\u4eac\\u5e02\\u3010\\u5357\\u4eac\\u8f6c\\u8fd0\\u4e2d\\u5fc3\\u3011\\uff0c\\u6b63\\u53d1\\u5f80\\u3010\\u96e8\\u82b1\\u5206\\u90e8\\u3011\"},{\"time\":\"1565376573\",\"desc\":\"\\u5230\\u5357\\u4eac\\u5e02\\u3010\\u5357\\u4eac\\u8f6c\\u8fd0\\u4e2d\\u5fc3\\u3011\"},{\"time\":\"1565347015\",\"desc\":\"\\u91d1\\u534e\\u5e02\\u3010\\u4e49\\u4e4c\\u8f6c\\u8fd0\\u4e2d\\u5fc3\\u3011\\uff0c\\u6b63\\u53d1\\u5f80\\u3010\\u5357\\u4eac\\u8f6c\\u8fd0\\u4e2d\\u5fc3\\u3011\"},{\"time\":\"1565346884\",\"desc\":\"\\u5230\\u91d1\\u534e\\u5e02\\u3010\\u4e49\\u4e4c\\u8f6c\\u8fd0\\u4e2d\\u5fc3\\u3011\"},{\"time\":\"1565338102\",\"desc\":\"\\u5230\\u91d1\\u534e\\u5e02\\u3010\\u4e49\\u4e4c2\\u5206\\u62e8\\u96c6\\u8d27\\u70b9\\u3011\"},{\"time\":\"1565335879\",\"desc\":\"\\u91d1\\u534e\\u5e02\\u3010\\u4e1c\\u9633\\u6c5f\\u5357\\u4e8c\\u5206\\u90e8-\\u4f18\\u8d28\\u5ba2\\u6237\\u3011\\uff0c\\u3010\\u738b\\u5bb6\\u9f99\\/18258585378\\u3011\\u5df2\\u63fd\\u6536\"}],\"_source_com\":\"huitongkuaidi\",\"_support_from\":\"partner\"},\"com\":\"huitongkuaidi\",\"company\":{\"xcx_brief_introduction\":\"\\u767e\\u4e16\\u5feb\\u9012\\u4e3a\\u60a8\\u63d0\\u4f9b\\u4f18\\u8d28\\u9ad8\\u6548\\u7684\\u5feb\\u9012\\u670d\\u52a1\",\"title_logo\":\"https:\\/\\/dss1.baidu.com\\/6ONXsjip0QIZ8tyhnq\\/it\\/u=3800376730,5852987&fm=58\",\"logo_color\":\"010F4D\",\"is_official\":\"1\",\"is_xcx_partner\":\"1\",\"url\":\"http:\\/\\/800bestex.com\\/\",\"fullname\":\"\\u767e\\u4e16\\u5feb\\u9012\",\"shortname\":\"\\u767e\\u4e16\",\"ispartner\":\"1\",\"tel\":\"95320\",\"icon\":{\"id\":\"7\",\"smallurl\":\"https:\\/\\/dss0.baidu.com\\/6ONWsjip0QIZ8tyhnq\\/it\\/u=3682653099,2524883494&fm=58\",\"smallpos\":\"0,1472\",\"middleurl\":\"https:\\/\\/dss2.baidu.com\\/6ONYsjip0QIZ8tyhnq\\/it\\/u=1078213688,3146076104&fm=58\",\"middlepos\":\"0,684\",\"normal\":\"https:\\/\\/dss1.baidu.com\\/6ONXsjip0QIZ8tyhnq\\/it\\/u=3908228140,1288170988&fm=58\"},\"website\":{\"title\":\"800bestex.com\",\"url\":\"http:\\/\\/800bestex.com\"},\"auxiliary\":[{\"title\":\"\\u7f51\\u70b9\\u67e5\\u8be2\",\"url\":\"http:\\/\\/800bestex.com\\/Site\\/Query\"},{\"title\":\"\\u7f51\\u4e0a\\u5bc4\\u4ef6\",\"url\":\"http:\\/\\/800bestex.com\\/Order\\/Create\"},{\"title\":\"\\u5728\\u7ebf\\u5ba2\\u670d\",\"url\":\"https:\\/\\/webcs.800best.com\\/index.html\"}],\"timecost\":{\"btn_show\":\"1\"},\"onlineorder\":{\"btn_show\":\"1\",\"url\":\"http:\\/\\/www.800bestex.com\\/Order\\/Create\\/?from=baidu_ala\"}},\"source\":{\"logo\":\"https:\\/\\/dss1.baidu.com\\/6ONXsjip0QIZ8tyhnq\\/it\\/u=1242368722,3163764871&fm=58\",\"title\":\"\\u6570\\u636e\\u6765\\u81ea\\u767e\\u4e16\\u5feb\\u9012\",\"url\":\"http:\\/\\/800bestex.com\",\"name\":\"\\u767e\\u4e16\\u5feb\\u9012\",\"showName\":\"\\u6570\\u636e\\u6765\\u6e90\\uff1a\\u767e\\u4e16\\u5feb\\u9012\"},\"kuaidiSource\":{\"logo\":\"https:\\/\\/dss2.baidu.com\\/6ONYsjip0QIZ8tyhnq\\/it\\/u=1429564979,1787167512&fm=58\",\"title\":\"\\u6570\\u636e\\u6765\\u81ea\\u5feb\\u9012100\",\"url\":\"http:\\/\\/www.kuaidi100.com\\/?from=baidu_ala\",\"name\":\"\\u5feb\\u9012100\",\"showName\":\"\\u5feb\\u9012100\"},\"pcAsynInfo\":{\"title\":\"\\u767e\\u4e16\\u5feb\\u9012-\\u5feb\\u9012\\u5355\\u53f7\\u67e5\\u8be2\",\"url\":\"http:\\/\\/800bestex.com\\/\",\"qr\":{\"txt\":\"\\u626b\\u63cf\\u4e8c\\u7ef4\\u7801\\u5b89\\u88c5\\u5feb\\u9012100\\u7684APP\\uff0c\\u5728\\u624b\\u673a\\u8ba2\\u9605\\u5feb\\u9012\\u63d0\\u9192\",\"src\":\"https:\\/\\/dss0.baidu.com\\/6ONWsjip0QIZ8tyhnq\\/it\\/u=326499225,7669382&fm=58\"},\"showurl\":\"http:\\/\\/800bestex.com\"}}}";
       String fauiledResult="{\n" +
               "\t\"msg\": \"暂无该订单数据\",\n" +
               "\t\"status\": \"0\",\n" +
               "\t\"error_code\": \"0\",\n" +
               "\t\"data\": {\n" +
               "\t\t\"info\": {\n" +
               "\t\t\t\"status\": \"0\",\n" +
               "\t\t\t\"com\": \"baishikuaidi\",\n" +
               "\t\t\t\"state\": \"3\",\n" +
               "\t\t\t\"send_time\": \"2019-08-09\",\n" +
               "\t\t\t\"departure_city\": \"\\u91d1\\u534e\\u5e02\",\n" +
               "\t\t\t\"arrival_city\": \"\\u5357\\u4eac\\u5e02\",\n" +
               "\t\t\t\"latest_progress\": \"\\u5357\\u4eac2019-08-10 18:56:21\\u5ba2\\u6237\\u5df2\\u53d6\\u4ef6\\uff0c\\u63d0\\u8d27\\u70b9\\uff1a\\u3010\\u4e91\\u67dc\\u3011 \\u65b0\\u6cb3\\u82d1\\u4e8c\\u671f\\u5317\\u82d1\\uff0813291265712 \\u5357\\u4eac\\u5e02\\u96e8\\u82b1\\u53f0\\u533a\\u6625\\u56ed\\u8def30\\u53f7\\u6625\\u6c5f\\u65b0\\u57ce\\u65b0\\u6cb3\\u82d1\\u4e8c\\u671f\\u95e8\\u536b\\u5ba4\\u65c1\\uff09\",\n" +
               "\t\t\t\"context\": {}\n" +
               "\t\t}\n" +
               "\t}\n" +
               "}";
       if (code!=null && code.equals("123456")){
           return cb+"("+successResult+")";
       }
       return cb+"("+fauiledResult+")";
    }

    @PostMapping("/api")
    public Object setapi(HttpServletRequest request, @RequestParam("jsontext") String jsontext){
        HttpSession session = request.getSession();
        session.setAttribute("api",jsontext);
        return "success";
    }


}
