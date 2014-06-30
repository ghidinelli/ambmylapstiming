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

        String type = "P3";
        String byteData = null;
        for (int i = 0; i < args.length; i++) {
            if ("-bytes".equals(args[i])) {
                i++;
                byteData = args[i];
            } else if ("-type".equals(args[i])) {
                i++;
                type = args[i];
            } // TODO conversion from file, stream etc
        }

        if (byteData != null) {
            new MsgConverter().toJson(type, byteData);
        } else {
            System.out.println("No data input");
        }

    }

    private void toJson(String type, String byteData) {

        JSONObject obj = new JSONObject();
        obj.put("type", type);
        obj.put("data", byteData);

        System.out.println("JSON:" + obj.toJSONString());

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
    }

}