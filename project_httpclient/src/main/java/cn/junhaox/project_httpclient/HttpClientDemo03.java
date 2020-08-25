package cn.junhaox.project_httpclient;

import cn.junhaox.entity.StatusCode;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @Author WJH
 * @Description
 * @date 2020/8/25 10:50
 * @Email ibytecode2020@gmail.com
 */
public class HttpClientDemo03 {


    public static void main(String[] args) {
        // HTTPClient 连接池
        PoolingHttpClientConnectionManager pool = new PoolingHttpClientConnectionManager();
        // 连接最大数量
        pool.setMaxTotal(100);
        // 访问同一个网站的HTTPClient的数量
        pool.setDefaultMaxPerRoute(20);
        // 通过连接池获取HTTPClient
        CloseableHttpClient client = HttpClients.custom().setConnectionManager(pool).build();
        CloseableHttpResponse response = null;
        try {
            HttpGet httpGet = new HttpGet("https://www.montnets.com/");
            // 连接属性
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(3000)
                    .setConnectionRequestTimeout(5000)
                    .setSocketTimeout(5000).build();
            httpGet.setConfig(requestConfig);
            response = client.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == StatusCode.HTTP_OK_CODE.getCode()) {
                HttpEntity entity = response.getEntity();
                System.out.println(EntityUtils.toString(entity, "UTF-8"));
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
