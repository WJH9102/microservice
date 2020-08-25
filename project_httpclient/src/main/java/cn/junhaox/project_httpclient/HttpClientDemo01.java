package cn.junhaox.project_httpclient;

import cn.junhaox.entity.StatusCode;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
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
public class HttpClientDemo01 {


    public static void main(String[] args) {
        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        try {
            client = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet("https://www.montnets.com/");
            response = client.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == StatusCode.HTTP_OK_CODE.getCode()) {
                HttpEntity entity = response.getEntity();
                System.out.println(EntityUtils.toString(entity, "UTF-8"));
                System.out.println(entity);
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
