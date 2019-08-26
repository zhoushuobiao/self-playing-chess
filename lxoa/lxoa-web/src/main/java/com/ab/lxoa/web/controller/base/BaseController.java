package com.ab.lxoa.web.controller.base;

import com.ab.lxoa.base.ResultJSON;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author shachor
 * @date 2018/12/20 17:23
 */
public class BaseController {

    private final Logger logger = LoggerFactory.getLogger(BaseController.class);

    /**
     * 设置请求头
     * @return
     */
    private static HttpHeaders getHttpHeaders() {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json;charset=UTF-8");
        headers.set("Connection", "keep-alive");
        headers.set("Keep-Alive", "timeout=20");
        headers.set("Cache-Control", "no-cache");
        return headers;
    }
    /**
     * 将对象转换成Fastjson格式并发送到客户端
     * @param response
     * @param object
     * @throws Exception
     */
    protected void sendJson(HttpServletResponse response, ResultJSON object){
        response.setStatus(200);
        response.setContentType("application/json;charset=UTF-8");
        try {
            PrintWriter writer = response.getWriter();
            //也可以用ServletOutputStream
            String res= JSON.toJSONString(object);
            writer.write(res);
            writer.close();
            response.flushBuffer();
        }catch (IOException e){
            logger.info("====返回数据异常====");
        }


    }

    public String getServerPath(HttpServletRequest request) {
        String port = Integer.toString(request.getServerPort());
        if (!port.equals("80")) {
            port = ":" + port;
        } else {
            port = "";
        }
        return request.getScheme() + "://" + request.getServerName() + port + request.getContextPath();
    }
}
