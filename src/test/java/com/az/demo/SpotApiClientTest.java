package com.az.demo;

import com.az.api.client.spot.SpotApiClientImpl;
import com.az.api.dto.CommonResponse;
import com.az.api.dto.spot.NetworthUpdateRequest;
import com.az.api.dto.spot.SpotPostOrderRequest;
import com.az.api.dto.spot.SpotUpdateOrderRequest;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * SPOT Business
 * @author az
 * @create 2023/9/20 16:15
 */
public class SpotApiClientTest {

    SpotApiClientImpl spotApiClient = new SpotApiClientImpl(null);


    @Test
    public void getPublicSymbol() {
        String symbol = "btc_usdt";
        CommonResponse commonResponse = spotApiClient.getPublicSymbol(symbol, null, null);
        System.out.println("result:" + commonResponse);
    }

    @Test
    public void getPublicDepth() {
        String symbol = "btc_usdt";
        CommonResponse publicDepth = spotApiClient.getPublicDepth(symbol, 200L);
        System.out.println("result:" + publicDepth);
    }

    @Test
    public void getPublicKLine() {
        String symbol = "btc_usdt";
        String interval = "1m";
        CommonResponse publicKLine = spotApiClient.getPublicKLine(symbol, interval, null, null, null);
        System.out.println("result:" + publicKLine);
    }

    @Test
    public void getPublicTradeHistory() {
        String symbol = "btc_usdt";
        CommonResponse next = spotApiClient.getPublicTradeHistory(symbol, null, "NEXT", null);
        System.out.println("result:" + next);
    }

    @Test
    public void getPublicRecentTrade() {
        String symbol = "btc_usdt";
        CommonResponse publicRecentTrade = spotApiClient.getPublicRecentTrade(symbol, 200L);
        System.out.println("result:" + publicRecentTrade);
    }

    @Test
    public void getPublicTicker() {
//        String symbol = "btc_usdt";
        List<String> symbols = Arrays.asList("btc_usdt", "eth_usdt");
        CommonResponse commonResponse = spotApiClient.getPublicTicker(null, symbols, null);
        System.out.println("result:" + commonResponse);
    }

    @Test
    public void getPublicTickerPrice() {
//        String symbol = "btc_usdt";
        List<String> symbols = Arrays.asList("btc_usdt", "eth_usdt");
        CommonResponse commonResponse = spotApiClient.getPublicTickerPrice(null, symbols, null);
        System.out.println("result:" + commonResponse);
    }

    @Test
    public void testpostOrder() {
        SpotPostOrderRequest request = SpotPostOrderRequest.builder().symbol("btc_usdt")
                .side("BUY")
                .type("LIMIT")
                .timeInForce("GTC")
                .bizType("SPOT")
                .price("110000")
                .quantity("0.001")
                .media("btok")
                .mediaChannel("btok123")
                .build();
        CommonResponse commonResponse = spotApiClient.postOrder(request);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void getOrder() {
        CommonResponse commonResponse = spotApiClient.getOrder(549142997112497088L);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void queryOrder() {
        CommonResponse commonResponse = spotApiClient.queryOrder(549142997112497088L);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void delOrder() {
        CommonResponse commonResponse = spotApiClient.delOrder(549142997112497088L);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void updateOrder(){
        CommonResponse commonResponse = spotApiClient.updateOrder(407309222976613568L, SpotUpdateOrderRequest.builder().quantity("0.002").price("63010").build());
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void getWsToken(){
        CommonResponse commonResponse = spotApiClient.getWsToken();
        System.out.println("result:"+commonResponse);
    }
}
