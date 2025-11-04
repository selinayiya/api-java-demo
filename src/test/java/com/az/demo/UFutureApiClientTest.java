package com.az.demo;

import com.google.gson.Gson;
import com.az.api.client.future.FutureApiClient;
import com.az.api.client.future.UFutureApiClientImpl;
import com.az.api.dto.FutureCommonResponse;
import com.az.api.dto.future.FuturePostOrderRequest;
import org.junit.Test;

import java.util.*;

/**
 * USDT BASE Future
 * @author az
 * @create 2023/9/20 16:15
 */
public class UFutureApiClientTest {
    Gson gson = new Gson();
    FutureApiClient client = new UFutureApiClientImpl(null);

    @Test
    public void getPublicClient() {
        FutureCommonResponse publicClient = client.getPublicClient();
        System.out.println(gson.toJson(publicClient));
    }

    @Test
    public void getPublicSymbolCoins() {
        FutureCommonResponse publicSymbolCoins = client.getPublicSymbolCoins();
        System.out.println(gson.toJson(publicSymbolCoins));
    }

    @Test
    public void getPublicSymbolDetail() {
        FutureCommonResponse commonResponse = client.getPublicSymbolDetail("btc_usdt");
        System.out.println(gson.toJson(commonResponse));
    }

    @Test
    public void getPublicSymbolList() {
        FutureCommonResponse commonResponse = client.getPublicSymbolList();
        System.out.println(gson.toJson(commonResponse));
    }

    @Test
    public void getPublicLeverageBracketDetail() {
        FutureCommonResponse commonResponse = client.getPublicLeverageBracketDetail("btc_usdt");
        System.out.println(gson.toJson(commonResponse));
    }

    @Test
    public void getPublicLeverageBracketList() {
        FutureCommonResponse commonResponse = client.getPublicLeverageBracketList();
        System.out.println(gson.toJson(commonResponse));
    }

    @Test
    public void getPublicQTicker() {
        FutureCommonResponse commonResponse = client.getPublicQTicker("btc_usdt");
        System.out.println(gson.toJson(commonResponse));
    }

    @Test
    public void getPublicQTickersList() {
        FutureCommonResponse commonResponse = client.getPublicQTickersList();
        System.out.println(gson.toJson(commonResponse));
    }

    @Test
    public void getPublicQDeal() {
        FutureCommonResponse commonResponse = client.getPublicQDeal("btc_usdt", 10);
        System.out.println(gson.toJson(commonResponse));
    }

    @Test
    public void getPublicQDepth() {
        FutureCommonResponse commonResponse = client.getPublicQDepth("btc_usdt", 1);
        System.out.println(gson.toJson(commonResponse));
    }

    @Test
    public void getPublicQSymbolIndexPrice() {
        FutureCommonResponse commonResponse = client.getPublicQSymbolIndexPrice("btc_usdt");
        System.out.println(gson.toJson(commonResponse));
    }

    @Test
    public void getPublicQSymbolIndexPriceList() {
        FutureCommonResponse commonResponse = client.getPublicQIndexPrice();
        System.out.println(gson.toJson(commonResponse));
    }

    @Test
    public void getPublicQSymbolIndexPriceDetail() {
        FutureCommonResponse commonResponse = client.getPublicQSymbolMarkPrice("btc_usdt");
        System.out.println(gson.toJson(commonResponse));
    }

    @Test
    public void getPublicQMarketPrice() {
        FutureCommonResponse commonResponse = client.getPublicQMarketPrice("btc_usdt");
        System.out.println(gson.toJson(commonResponse));
    }

    @Test
    public void getBestPrice() {
        FutureCommonResponse commonResponse = client.getBestPrice("btc_usdt");
        System.out.println(gson.toJson(commonResponse));
    }

    @Test
    public void getPublicQKline() {
        FutureCommonResponse commonResponse = client.getPublicQKline("btc_usdt", "3m", null, null, null);
        System.out.println(gson.toJson(commonResponse));
    }

    @Test
    public void getPublicQAggTicker() {
        FutureCommonResponse commonResponse = client.getPublicQAggTicker("btc_usdt");
        System.out.println(gson.toJson(commonResponse));
    }

    @Test
    public void getPublicQFundingRate() {
        FutureCommonResponse commonResponse = client.getPublicQFundingRate("btc_usdt");
        System.out.println(gson.toJson(commonResponse));
    }

    @Test
    public void getPublicQTickerBook() {
        FutureCommonResponse commonResponse = client.getPublicQTickerBook("btc_usdt");
        System.out.println(gson.toJson(commonResponse));
    }

    @Test
    public void getPublicQFundingRateRecord() {
        FutureCommonResponse commonResponse = client.getPublicQFundingRateRecord("btc_usdt", null, null, 1L);
        System.out.println(gson.toJson(commonResponse));
    }

    @Test
    public void getPublicContractRiskBalance() {
        FutureCommonResponse commonResponse = client.getPublicContractRiskBalance("btc_usdt", null, null, 2L);
        System.out.println(gson.toJson(commonResponse));
    }

    @Test
    public void getPublicContractOpenInterest() {
        FutureCommonResponse commonResponse = client.getPublicContractOpenInterest("btc_usdt");
        System.out.println(gson.toJson(commonResponse));
    }

    @Test
    public void getOrderSlim() {
        FutureCommonResponse commonResponse = client.getOrderSlim(17249182446388224L);
        System.out.println(gson.toJson(commonResponse));
    }

    @Test
    public void postOrder(){
        FuturePostOrderRequest request = FuturePostOrderRequest.builder().symbol("btc_usdt")
                .origQty("4")
                .orderType("LIMIT")
                .timeInForce("GTC")
                .price("26972.9")
                .orderSide("BUY")
                .positionSide("LONG")
                .build();
        FutureCommonResponse commonResponse = client.postOrder(request);
        System.out.println("result:"+gson.toJson(commonResponse));
    }

    @Test
    public void batchOrder(){
        FuturePostOrderRequest request = FuturePostOrderRequest.builder().symbol("btc_usdt")
                .origQty("4")
                .orderType("LIMIT")
                .timeInForce("GTC")
                .price("26972.9")
                .orderSide("BUY")
                .positionSide("LONG")
                .build();
        FuturePostOrderRequest request2 = FuturePostOrderRequest.builder().symbol("btc_usdt")
                .origQty("4")
                .orderType("LIMIT")
                .timeInForce("GTC")
                .price("26972.9")
                .orderSide("BUY")
                .positionSide("LONG")
                .build();
        List<FuturePostOrderRequest> requestList = new ArrayList<>();
        requestList.add(request);
        requestList.add(request2);
        FutureCommonResponse commonResponse = client.batchOrder(requestList);
        System.out.println("result:"+gson.toJson(commonResponse));
    }

    @Test
    public void orderListHistory() {
        Map<String, String> params = new HashMap<>();
        params.put("limit", "1");
        FutureCommonResponse commonResponse = client.orderListHistory(params);
        System.out.println("result:"+gson.toJson(commonResponse));
    }

    @Test
    public void orderTradeList() {
        Map<String, String> params = new HashMap<>();
        params.put("limit", "1");
        FutureCommonResponse commonResponse = client.orderTradeList(params);
        System.out.println("result:"+gson.toJson(commonResponse));
    }

    @Test
    public void orderDetail() {
        FutureCommonResponse commonResponse = client.orderDetail(554854882113899648L);
        System.out.println("result:"+gson.toJson(commonResponse));
    }
    @Test
    public void orderList() {
        Map<String, String> params = new HashMap<>();
        params.put("symbol", "btc_usdt");
        FutureCommonResponse commonResponse = client.orderList(params);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void orderCancel() {
        FutureCommonResponse commonResponse = client.orderCancel(275110136488455424L);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void allCancel() {
        FutureCommonResponse commonResponse = client.allCancel(null);
        System.out.println("result:"+commonResponse);
    }


    @Test
    public void entrustCreatePlan() {
        Map<String, String> params = new HashMap<>();
        params.put("symbol","btc_usdt");
        params.put("orderSide","BUY");
        params.put("entrustType","TAKE_PROFIT");
        params.put("origQty","1");
        params.put("timeInForce","GTC");
        params.put("triggerPriceType","INDEX_PRICE");
        params.put("positionSide","LONG");
        params.put("stopPrice","55");
        FutureCommonResponse commonResponse = client.entrustCreatePlan(params);
        System.out.println("result:"+commonResponse);
    }
    @Test
    public void entrustCancelPlan() {
        FutureCommonResponse commonResponse = client.entrustCancelPlan(275110136488455424L);
        System.out.println("result:"+commonResponse);
    }
    @Test
    public void entrustCancelAllPlan() {
        FutureCommonResponse commonResponse = client.entrustCancelAllPlan("btc_usdt");
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void accountInfo() {
        FutureCommonResponse commonResponse = client.accountInfo();
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void balanceDetail() {
        FutureCommonResponse commonResponse = client.balanceDetail("usdt");
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void listenKey() {
        FutureCommonResponse commonResponse = client.listenKey();
        System.out.println("result:"+gson.toJson(commonResponse));
    }

    @Test
    public void listBalance() {
        FutureCommonResponse commonResponse = client.listBalance();
        System.out.println("result:"+gson.toJson(commonResponse));
    }

    @Test
    public void getBalance() {
        FutureCommonResponse commonResponse = client.getBalance();
        System.out.println("result:"+gson.toJson(commonResponse));
    }

    @Test
    public void adjustLeverage() {
        FutureCommonResponse commonResponse = client.adjustLeverage("btc_usdt","LONG",20);
        System.out.println("result:"+commonResponse);
    }

}
