package com.az.demo;

import com.alibaba.fastjson.JSON;
import com.az.api.util.HttpUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * spot business
 * @author az
 * @create 2022/10/28 15:04
 */
public class RestTest {

    @Test
    public void getServerTime() {
        String uri = "/az/spot/public/time";
        System.out.println("result====" + HttpUtil.get(uri, null));
    }

    @Test
    public void getClientIp() {
        String uri = "/az/spot/public/client";
        System.out.println("result====" + HttpUtil.get(uri, null));
    }

    @Test
    public void testpostOrder() {
        String uri = "/az/spot/order";
        Map<String, Object> param = new HashMap<>();
        param.put("symbol", "btc_usdt");
        param.put("side", "BUY");
        param.put("type", "LIMIT");
        param.put("timeInForce", "GTC");
        param.put("bizType", "SPOT");
        param.put("price", "3");
        param.put("quantity", "2");
        System.out.println("json===="+ JSON.toJSONString(param));
        System.out.println("result====" + HttpUtil.post(uri,JSON.toJSONString(param)));
    }

    @Test
    public void testpostBatchOrder() {
        String uri = "/az/spot/batch-order";
        Map<String, Object> outParam = new HashMap<>();
        outParam.put("batchId","asd123");


        Map<String, Object> param = new HashMap<>();
        param.put("symbol", "btc_usdt");
        param.put("side", "BUY");
        param.put("type", "LIMIT");
        param.put("timeInForce", "GTC");
        param.put("bizType", "SPOT");
        param.put("price", "3");
        param.put("quantity", "2");
        List<Map<String, Object>> items = new ArrayList<>();
        items.add(param);

        outParam.put("items",items);
        System.out.println("json===="+ JSON.toJSONString(outParam));
        System.out.println("result====" + HttpUtil.post(uri,JSON.toJSONString(outParam)));
    }

    @Test
    public void getOrder() {
        String uri = "/az/spot/order/156201996458139136";
        System.out.println("result====" + HttpUtil.get(uri, null));
    }

    @Test
    public void queryOrder() {
        String uri = "/az/spot/order";
        Map<String, Object> param = new HashMap<>();
        param.put("orderId", 156201996458139136L);
        System.out.println("result====" + HttpUtil.get(uri, param));
    }

    @Test
    public void delOrder() {
        String uri = "/az/spot/order/156201996458139136";
        System.out.println("result====" + HttpUtil.delete(uri, null));
    }

    @Test
    public void batchOrderGet() {
        String uri = "/az/spot/batch-order";
        Map<String, Object> param = new HashMap<>();
        param.put("orderIds", "156201996458139136,12312313212");
        System.out.println("result====" + HttpUtil.get(uri, param));
    }

    @Test
    public void batchOrderDel() {
        String uri = "/az/spot/batch-order";
        Map<String, Object> param = new HashMap<>();
        param.put("clientBatchId", "123123111");
        param.put("orderIds", List.of(156201996458139136L, 12312313212L));
        System.out.println("result====" + HttpUtil.deleteWithBody(uri, JSON.toJSONString(param)));
    }

    @Test
    public void getOpenOrder() {
        for(int x=0;x<100;x++){
            String uri = "/az/spot/open-order";
            Map<String, Object> param = new HashMap<>();
            //symbol=cmcx_usdt&bizType=SPOT
            param.put("symbol","cmcx_usdt");
            param.put("bizType","SPOT");
            System.out.println("result====" + HttpUtil.get(uri, param));
        }

    }

    @Test
    public void delOpenOrder() {
        String uri = "/az/spot/open-order";
        Map<String, Object> param = new HashMap<>();
        param.put("bizType", "SPOT");
        System.out.println("result====" + HttpUtil.deleteWithBody(uri, JSON.toJSONString(param)));
    }

    @Test
    public void getHistoryOrder() {
        String uri = "/az/spot/history-order";
        Map<String, Object> param = new HashMap<>();
        param.put("bizType", "SPOT");
        System.out.println("result====" + HttpUtil.get(uri, param));
    }


    @Test
    public void getTrade() {
        String uri = "/az/spot/trade";
        Map<String, Object> param = new HashMap<>();
        param.put("bizType", "SPOT");
        System.out.println("result====" + HttpUtil.get(uri, param));
    }


    @Test
    public void getBalance() {
        String uri = "/az/spot/balance";
        Map<String, Object> param = new HashMap<>();
        param.put("currency", "usdt");
        System.out.println("result====" + HttpUtil.get(uri, param));
    }

    @Test
    public void getBalances() {
        String uri = "/az/spot/balances";
        Map<String, Object> param = new HashMap<>();
        param.put("currencies", "usdt,btc");
        System.out.println("result====" + HttpUtil.get(uri, param));
    }
    
    @Test
    public void getToken() {
        String uri = "/az/spot/ws-token";
        String token = HttpUtil.post(uri, null);
        System.out.println("result====" + token);
    }

    @Test
    public void deposit() {
        String uri = "/az/spot/deposit/address";
        Map<String, Object> param = new HashMap<>();
        param.put("chain", "BNB Smart Chain");
        param.put("currency", "usdt");
        System.out.println("result====" + HttpUtil.get(uri, param));
    }

    @Test
    public void withdraw() {
        String uri = "/az/spot/withdraw";
        Map<String, Object> param = new HashMap<>();
        param.put("chain", "Tron");
        param.put("clientOrderId","1234");
        param.put("currency","USDT");
        param.put("amount",1000);
        param.put("address","xxxxx");
        param.put("toAccountId",1234567L);
        System.out.println("json===="+ JSON.toJSONString(param));
        System.out.println("result====" + HttpUtil.post(uri,JSON.toJSONString(param)));
    }

    @Test
    public void withdrawInfo() {
        String uri = "/az/spot/withdraw";
        Map<String, Object> param = new HashMap<>();
        param.put("recordId", 123);
        param.put("clientOrderId","1234");
        System.out.println("json===="+ JSON.toJSONString(param));
        System.out.println("result====" + HttpUtil.get(uri,param));
    }

    @Test
    public void transfer() {
        String uri = "/az/spot/balance/transfer";
        Map<String, Object> param = new HashMap<>();
        param.put("symbol", "btc_usdt");
        param.put("side", "BUY");
        param.put("type", "LIMIT");
        param.put("timeInForce", "GTC");
        param.put("bizType", "SPOT");
        param.put("price", "3");
        param.put("quantity", "2");
        System.out.println("json===="+ JSON.toJSONString(param));
        System.out.println("result====" + HttpUtil.post(uri,JSON.toJSONString(param)));
    }

    @Test
    public void accTransfer() {
        String uri = "/az/spot/balance/account/transfer";
        Map<String, Object> param = new HashMap<>();
        param.put("symbol", "btc_usdt");
        param.put("side", "BUY");
        param.put("type", "LIMIT");
        param.put("timeInForce", "GTC");
        param.put("bizType", "SPOT");
        param.put("price", "3");
        param.put("quantity", "2");
        System.out.println("json===="+ JSON.toJSONString(param));
        System.out.println("result====" + HttpUtil.post(uri,JSON.toJSONString(param)));
    }



}
