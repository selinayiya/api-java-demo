package com.az.api.client.spot;

import com.az.api.dto.CommonResponse;
import com.az.api.dto.spot.NetworthUpdateRequest;
import com.az.api.dto.spot.SpotPostOrderRequest;
import com.az.api.dto.spot.SpotUpdateOrderRequest;
import retrofit2.http.Query;

import java.util.List;


/**
 * @author az
 * @create 2023/9/20 11:48
 */
public interface SpotApiClient {

    CommonResponse getPublicSymbol(String symbol, String symbols, String version);

    CommonResponse getPublicDepth(String symbol, Long limit);

    CommonResponse getPublicKLine(String symbol, String interval, Long startTime, Long endTime, Long limit);

    CommonResponse getPublicTradeHistory(String symbol, Long limit, String direction, Long fromId);

    CommonResponse getPublicRecentTrade(String symbol, Long limit);

    CommonResponse getPublicTicker(String symbol, List<String> symbols, String tags);

    CommonResponse getPublicTickerPrice(String symbol, List<String> symbols, String tags);

    CommonResponse postOrder(SpotPostOrderRequest request);

    CommonResponse getOrder(Long id);

    CommonResponse queryOrder(Long orderId);

    CommonResponse delOrder(Long id);

    CommonResponse updateOrder(Long id, SpotUpdateOrderRequest request);

    CommonResponse getWsToken();
}
