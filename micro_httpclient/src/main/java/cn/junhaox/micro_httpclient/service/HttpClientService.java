package cn.junhaox.micro_httpclient.service;

import cn.junhaox.entity.StatusCode;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author WJH
 * @Description
 * @date 2020/8/25 15:05
 * @Email ibytecode2020@gmail.com
 */
@Service
public class HttpClientService {

    @Autowired
    private RequestConfig requestConfig;

    @Autowired
    private CloseableHttpClient httpClient;

    /**
     * 不带参数的get请求
     * @param url 请求地址
     * @return 请求的响应值
     * @throws Exception 不处理异常
     */
    public String doGet(String url) throws Exception {
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(requestConfig);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        if (response != null && response.getStatusLine().getStatusCode() == StatusCode.HTTP_OK_CODE.getCode()) {
            return EntityUtils.toString(response.getEntity(), "UTF-8");
        } else {
            return null;
        }
    }


    /**
     * 带参数的get请求
     * @param url 请求地址
     * @param map 参数
     * @return 请求的响应值
     * @throws Exception 不处理异常
     */
    public String doGet(String url, Map<String, Object> map) throws Exception {
        URIBuilder uriBuilder = new URIBuilder(url);
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, Object> entry: map.entrySet()) {
                uriBuilder.setParameter(entry.getKey(), entry.getValue().toString());
            }
        }
        return doGet(uriBuilder.build().toString());
    }

    /**
     * 带参数的post请求
     * @param url 请求地址
     * @param map 请求参数
     * @return 响应参数
     * @throws Exception 不处理异常
     */
    public String doPost(String url, Map<String, Object> map) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        // 请求参数设置
        if (map != null && map.size() > 0) {
            List<NameValuePair> pairList = new ArrayList<>();
            for (Map.Entry<String, Object> entry: map.entrySet()) {
                pairList.add(new BasicNameValuePair(entry.getKey(), ((String) entry.getValue())));
            }
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(pairList, "UTF-8");
            httpPost.setEntity(entity);
        }
        CloseableHttpResponse response = httpClient.execute(httpPost);
        if (response != null && response.getStatusLine().getStatusCode() == StatusCode.HTTP_OK_CODE.getCode()) {
            return EntityUtils.toString(response.getEntity());
        } else {
            return null;
        }
    }

    /**
     * 无参POST请求
     * @param url 请求地址
     * @return 响应参数
     * @throws Exception 不处理异常
     */
    public String doPost(String url) throws Exception {
        return doPost(url, null);
    }
}
