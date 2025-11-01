package com.az.demo;

import com.alibaba.fastjson.JSON;
import com.az.api.client.WebSocketClient;
import com.az.api.client.future.FutureApiClient;
import com.az.api.client.future.UFutureApiClientImpl;
import com.az.api.dto.FutureCommonResponse;
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
public class UserPrivateWebSocketTest {
    Gson gson = new Gson();
    org.java_websocket.client.WebSocketClient webSocketClient = null;
    FutureApiClient client =  null;

    @Before
    public void init(){
        try {
            webSocketClient = new WebSocketClient("wss://f-ws.myaztests.com/ws/user");

            client = new UFutureApiClientImpl(null);
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
        while (true){
            try {
                Thread.sleep(3000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("send msg ping");
            webSocketClient.send("ping");
        }
    }

    @Test
    public void subscribeAll(){
        FutureCommonResponse commonResponse = client.listenKey();
        String listenKey= commonResponse.getResult().toString();

        List<String> params = new ArrayList<>();
        params.add("balance@"+listenKey);
        params.add("order@"+listenKey);

        RequestMessage requestMessage = RequestMessage.builder()
                .id("001")
                .method(Method.SUBSCRIBE.name())
                .params(params).build();
        String info = gson.toJson(requestMessage);
        webSocketClient.send(info);
        System.out.println(info);
    }


}
