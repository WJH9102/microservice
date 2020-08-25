package cn.junhaox.project_httpclient;

import cn.junhaox.entity.StatusCode;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author WJH
 * @Description
 * @date 2020/8/25 10:50
 * @Email ibytecode2020@gmail.com
 */
public class HttpClientDemo02 {
    private static Pattern pattern = Pattern.compile("meta name=\"description\" content=\"(.+)\" />");


    public static void main(String[] args) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://www.montnets.com/");
        CloseableHttpResponse response = null;
        String des = null;
        try {
            List<NameValuePair> pairList = new ArrayList<>();
            pairList.add(new BasicNameValuePair("id", "1"));
            pairList.add(new BasicNameValuePair("name", "zs"));
            pairList.add(new BasicNameValuePair("age", "23"));
            UrlEncodedFormEntity httpEntity = new UrlEncodedFormEntity(pairList, "UTF-8");
            httpPost.setEntity(httpEntity);
            response = client.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == StatusCode.HTTP_OK_CODE.getCode()) {
                HttpEntity entity = response.getEntity();
                String result = EntityUtils.toString(entity, "UTF-8");
                Matcher matcher = pattern.matcher(result);
                if (matcher.find()) {
                    des = matcher.group();
                }
                System.out.println(des);
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
