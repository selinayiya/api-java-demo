package com.az.api.client.future;

import com.az.api.dto.FutureCommonResponse;
import com.az.api.dto.future.FuturePostOrderRequest;
import retrofit2.http.Query;


import java.util.List;
import java.util.Map;


/**
 * @author az
 * @create 2023/9/20 11:48
 */
public interface FutureApiClient {

    FutureCommonResponse getPublicClient();

    FutureCommonResponse getPublicSymbolCoins();

    FutureCommonResponse getPublicSymbolDetail(String symbol);

    FutureCommonResponse getPublicSymbolList();

    FutureCommonResponse getPublicLeverageBracketDetail(String symbol);

    FutureCommonResponse getPublicLeverageBracketList();

    FutureCommonResponse getPublicQTicker(String symbol);

    FutureCommonResponse getPublicQTickersList();

    FutureCommonResponse getPublicQDeal(String symbol, Integer num);

    FutureCommonResponse getPublicQDepth(String symbol, Integer level);

    FutureCommonResponse getPublicQSymbolIndexPrice(String symbol);

    FutureCommonResponse getPublicQIndexPrice();

    FutureCommonResponse getPublicQSymbolMarkPrice(String symbol);

    FutureCommonResponse getPublicQMarketPrice(String symbol);

    FutureCommonResponse getBestPrice(String symbol);

    FutureCommonResponse getPublicQKline(String symbol, String interval, Long startTime, Long endTime, Long limit);

    FutureCommonResponse getPublicQAggTicker(String symbol);

    FutureCommonResponse getPublicQFundingRate(String symbol);

    FutureCommonResponse getPublicQTickerBook(String symbol);

    FutureCommonResponse getPublicQFundingRateRecord(String symbol, Long id, String direction, Long limit);

    FutureCommonResponse getPublicContractRiskBalance(String symbol, Long id, String direction, Long limit);

    FutureCommonResponse getPublicContractOpenInterest(String symbol);

    FutureCommonResponse getOrderSlim(Long orderId);

    FutureCommonResponse postOrder(FuturePostOrderRequest request);

    FutureCommonResponse batchOrder(List<FuturePostOrderRequest> futurePostOrderRequestList);


    FutureCommonResponse orderListHistory(Map<String, String> params);

    FutureCommonResponse orderTradeList(Map<String, String> params);

    FutureCommonResponse orderDetail(Long orderId);

    FutureCommonResponse orderList(Map<String, String> params);

    FutureCommonResponse orderCancel(Long orderId);

    FutureCommonResponse allCancel(String symbol);

    FutureCommonResponse entrustCreatePlan(Map<String, String> params);

    FutureCommonResponse entrustCancelPlan(Long entrustId);

    FutureCommonResponse entrustCancelAllPlan(String symbol);



    FutureCommonResponse accountInfo();

    FutureCommonResponse balanceDetail(String coin);

    FutureCommonResponse listenKey();

    FutureCommonResponse listBalance();

    FutureCommonResponse getBalance();

    FutureCommonResponse adjustLeverage(String symbol,String positionSide,Integer leverage);

}
