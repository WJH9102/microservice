package cn.junhaox.project_httpclient;

import cn.junhaox.entity.StatusCode;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author WJH
 * @Description
 * @date 2020/8/25 10:50
 * @Email ibytecode2020@gmail.com
 */
public class HttpClientDemo05 {


    public static void main(String[] args) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://dasai.lanqiao.cn/pages/dasai/news_detail.html?id=1828");
        CloseableHttpResponse response = null;
        try {
            httpPost.setHeader("Content-Type", "text/html; charset=utf-8");
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
