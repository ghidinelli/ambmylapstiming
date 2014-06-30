package com.skoky.client;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;

import java.io.IOException;

public class MsgConverter {

    public static void main(String[] args) {

        for (int i = 0; i < args.length; i++) {
            if ("-bytes".equals(args[i])) {
                i++;
                String byteData = args[i];
                new MsgConverter().toJson(byteData);
                return;
            }  // TODO conversion from file, stream etc
        }
    }

    private void toJson(String byteData) {

        JSONObject obj = new JSONObject();
        obj.put("type", "P3");
        obj.put("data",byteData);

        System.out.println("JSON:"+obj.toJSONString());

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://ambconverter.appspot.com/json");

        StringEntity se = new StringEntity(obj.toJSONString(), ContentType.APPLICATION_JSON);
        httpPost.setEntity(se);
        try {
            CloseableHttpResponse response = httpclient.execute(httpPost);
            System.out.println("Response status:" + response.getStatusLine());
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }

//        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
//        nvps.add(new BasicNameValuePair("username", "vip"));
//        nvps.add(new BasicNameValuePair("password", "secret"));
//        httpPost.setEntity(new UrlEncodedFormEntity(nvps));
//        CloseableHttpResponse response2 = httpclient.execute(httpPost);
//
//        try {
//            System.out.println(response2.getStatusLine());
//            HttpEntity entity2 = response2.getEntity();
//            // do something useful with the response body
//            // and ensure it is fully consumed
//            EntityUtils.consume(entity2);
//        } finally {
//            response2.close();
//        }
    }

}