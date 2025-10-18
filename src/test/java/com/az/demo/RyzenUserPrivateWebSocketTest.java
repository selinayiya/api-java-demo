package com.az.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.az.api.client.WebSocketClient;
import com.az.api.client.spot.SpotApiClientImpl;
import com.az.api.dto.CommonResponse;
import com.az.api.dto.websocket.Method;
import com.az.api.dto.websocket.RequestMessage;
import com.google.gson.Gson;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author az
 * @create 2023/12/12 16:36
 */
public class RyzenUserPrivateWebSocketTest {
    Gson gson = new Gson();
    org.java_websocket.client.WebSocketClient webSocketClient = null;
    SpotApiClientImpl spotApiClient ;
    @Before
    public void init(){
        try {
//            HttpProxyProperties properties = new HttpProxyProperties();
//            properties.setHost("127.0.0.1");
//            properties.setEnabled(true);
//            properties.setPort(7890);
            webSocketClient = new WebSocketClient("wss://s-ws.myaztests.com/private");
//            webSocketClient.setProxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(properties.getHost(), properties.getPort())));

            spotApiClient = new SpotApiClientImpl(null);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        assert webSocketClient != null;
        webSocketClient.connect();
        while (!webSocketClient.isOpen()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @After
    public void after(){

    }

    @Test
    public void subscribe(){
        CommonResponse wsToken = spotApiClient.getWsToken();
        Map<String, Object> map = JSON.parseObject(JSON.toJSONString(wsToken.getResult()), Map.class);
        String accessToken = (String) map.get("accessToken");


        List<String> params = new ArrayList<>();
        params.add("trade");

        RequestMessage requestMessage = RequestMessage.builder().id("123").method(Method.SUBSCRIBE.name()).params(params).listenKey(accessToken.toString()).build();
        webSocketClient.send(gson.toJson(requestMessage));

        while (true){
            try {
                Thread.sleep(30000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("send msg ping");
            webSocketClient.send("ping");
        }
    }


}
