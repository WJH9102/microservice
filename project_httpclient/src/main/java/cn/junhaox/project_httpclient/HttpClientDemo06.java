package cn.junhaox.project_httpclient;

import cn.junhaox.entity.StatusCode;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @Author WJH
 * @Description
 * @date 2020/8/25 10:50
 * @Email ibytecode2020@gmail.com
 */
public class HttpClientDemo06 {


    public static void main(String[] args) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://dasai.lanqiao.cn/pages/dasai/news_detail.html?id=1828");
        CloseableHttpResponse response = null;
        try {
            httpPost.setHeader("Content-Type", "text/html; charset=utf-8");

            RequestParam param = new RequestParam();
            param.setId("1828");
            param.setAge("12");
            param.setName("zs");

            StringEntity stringEntity = new StringEntity(JSON.toJSONString(param), "UTF-8");

            httpPost.setEntity(stringEntity);

            response = client.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == StatusCode.HTTP_OK_CODE.getCode()) {
                response = client.execute(httpPost);
                if (response.getStatusLine().getStatusCode() == StatusCode.HTTP_OK_CODE.getCode()) {
                    HttpEntity entity = response.getEntity();
                    String result = EntityUtils.toString(entity, "UTF-8");
                    System.out.println(result);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != client) {
                    client.close();
                }
                if (null != response) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
