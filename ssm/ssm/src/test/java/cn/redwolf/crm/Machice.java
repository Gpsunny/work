package cn.redwolf.crm;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Machice {
    public static void main(String[] args) throws IOException {
        System.out.println("下面是聊天框哦...");
        while(true){
            System.out.println("lihui:");
//            扫描控制台的输入
            Scanner scan = new Scanner(System.in);
            String request= scan.nextLine();
//            解析控制台输入
            String info = URLEncoder.encode(request, "utf-8");
//            图灵机器人的apk
            String APIkey = "3da4a7fbf15a42448ea46592147dc9de";
//            获取网址和信息，这个是以get方式提交
            String getUrl = "http://www.tuling123.com/openapi/api?key="
                    +APIkey+"&info="+info;
            URL url = new URL(getUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();
//获取返回的输入流
            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            StringBuffer sb = new StringBuffer();
            while((line = br.readLine()) != null){
                sb.append(line);
            }
            JSONObject parse = (JSONObject)JSON.parse(sb.toString());
            Object text = parse.get("text");
            System.out.println("图灵机器人"+text.toString());
        }
//		is.close();
//		br.close();
//		conn.disconnect();
    }

}
