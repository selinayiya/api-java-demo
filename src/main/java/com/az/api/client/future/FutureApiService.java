package com.az.api.client.future;

import com.az.api.dto.FutureCommonResponse;
import com.az.api.dto.future.FutureOrderCancelAllRequest;
import com.az.api.dto.future.FutureOrderCancelRequest;
import com.az.api.dto.future.FuturePostOrderRequest;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

/**
 * @author az
 * @create 2023/9/20 14:28
 */
public interface FutureApiService {
    @GET("/az/future/public/client")
    Call<FutureCommonResponse> getPublicClient();

    @GET("/az/future/market/v1/public/symbol/coins")
    Call<FutureCommonResponse> getPublicSymbolCoins();

    @GET("/az/future/market/v1/public/symbol/detail")
    Call<FutureCommonResponse> getPublicSymbolDetail(@Query("symbol") String symbol);

    @GET("/az/future/market/v3/public/symbol/list")
    Call<FutureCommonResponse> getPublicSymbolList();

    @GET("/az/future/market/v1/public/leverage/bracket/detail")
    Call<FutureCommonResponse> getPublicLeverageBracketDetail(@Query("symbol") String symbol);

    @GET("/az/future/market/v1/public/leverage/bracket/list")
    Call<FutureCommonResponse> getPublicLeverageBracketList();

    @GET("/az/future/market/v1/public/q/ticker")
    Call<FutureCommonResponse> getPublicQTicker(@Query("symbol") String symbol);

    @GET("/az/future/market/v1/public/q/tickers")
    Call<FutureCommonResponse> getPublicQTickersList();

    @GET("/az/future/market/v1/public/q/deal")
    Call<FutureCommonResponse> getPublicQDeal(@Query("symbol") String symbol, @Query("num") Integer num);

    @GET("/az/future/market/v1/public/q/depth")
    Call<FutureCommonResponse> getPublicQDepth(@Query("symbol") String symbol, @Query("level") Integer level);

    @GET("/az/future/market/v1/public/q/symbol-index-price")
    Call<FutureCommonResponse> getPublicQSymbolIndexPrice(@Query("symbol") String symbol);

    @GET("/az/future/market/v1/public/q/index-price")
    Call<FutureCommonResponse> getPublicQIndexPrice();

    @GET("/az/future/market/v1/public/q/symbol-mark-price")
    Call<FutureCommonResponse> getPublicQSymbolMarkPrice(@Query("symbol") String symbol);

    @GET("/az/future/market/v1/public/q/mark-price")
    Call<FutureCommonResponse> getPublicQMarketPrice(@Query("symbol") String symbol);

    @GET("/az/future/market/v1/public/q/best-price")
    Call<FutureCommonResponse> getBestPrice(@Query("symbol") String symbol);

    @GET("/az/future/market/v1/public/q/kline")
    Call<FutureCommonResponse> getPublicQKline(@Query("symbol") String symbol, @Query("interval") String interval, @Query("startTime") Long startTime, @Query("endTime") Long endTime, @Query("limit") Long limit);

    @GET("/az/future/market/v1/public/q/agg-ticker")
    Call<FutureCommonResponse> getPublicQAggTicker(@Query("symbol") String symbol);

    @GET("/az/future/market/v1/public/q/funding-rate")
    Call<FutureCommonResponse> getPublicQFundingRate(@Query("symbol") String symbol);

    @GET("/az/future/market/v1/public/q/ticker/book")
    Call<FutureCommonResponse> getPublicQTickerBook(@Query("symbol") String symbol);

    @GET("/az/future/market/v1/public/q/funding-rate-record")
    Call<FutureCommonResponse> getPublicQFundingRateRecord(@Query("symbol") String symbol, @Query("id") Long id, @Query("direction") String direction, @Query("limit") Long limit);

    @GET("/az/future/market/v1/public/contract/risk-balance")
    Call<FutureCommonResponse> getPublicContractRiskBalance(@Query("symbol") String symbol, @Query("id") Long id, @Query("direction") String direction, @Query("limit") Long limit);

    @GET("/az/future/market/v1/public/contract/open-interest")
    Call<FutureCommonResponse> getPublicContractOpenInterest(@Query("symbol") String symbol);

    @GET("/az/future/trade/v1/order/slim")
    Call<FutureCommonResponse> getOrderSlim(@Query("orderId") Long orderId);

    @POST("/az/future/trade/v1/order/create")
    Call<FutureCommonResponse> makeOrder(@QueryMap Map<String, String> params);

    @POST("/az/future/trade/v1/order/create")
    Call<FutureCommonResponse> postOrder(@Body FuturePostOrderRequest futurePostOrderRequest);

    @POST("/az/future/trade/v1/order/create-batch")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Call<FutureCommonResponse> batchOrder(@Query("list") String list);

    @GET("/az/future/trade/v1/order/list-history")
    Call<FutureCommonResponse> orderListHistory(@QueryMap Map<String, String> params);

    @GET("/az/future/trade/v1/order/trade-list")
    Call<FutureCommonResponse> orderTradeList(@QueryMap Map<String, String> params);

    @GET("/az/future/trade/v1/order/detail")
    Call<FutureCommonResponse> orderDetail(@Query("orderId") Long orderId);

    @GET("/az/future/trade/v1/order/list")
    Call<FutureCommonResponse> orderList(@QueryMap Map<String, String> params);

    @POST("/az/future/trade/v1/order/cancel")
    Call<FutureCommonResponse> orderCancel(@Body FutureOrderCancelRequest request);

    @POST("/az/future/trade/v1/order/cancel-all")
    Call<FutureCommonResponse> allCancel(@Body FutureOrderCancelAllRequest request);

    @POST("/az/future/trade/v1/entrust/create-plan")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Call<FutureCommonResponse> entrustCreatePlan(@QueryMap Map<String, String> params);

    @POST("/az/future/trade/v1/entrust/cancel-plan")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Call<FutureCommonResponse> entrustCancelPlan(@Query("entrustId") Long entrustId);

    @POST("/az/future/trade/v1/entrust/cancel-all-plan")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Call<FutureCommonResponse> entrustCancelAllPlan(@Query("symbol") String symbol);

    @GET("/az/future/user/v1/account/info")
    Call<FutureCommonResponse> accountInfo();

    @GET("/az/future/user/v1/balance/detail")
    Call<FutureCommonResponse> balanceDetail(@Query("coin") String coin);

    @GET("/az/future/user/v1/user/listen-key")
    Call<FutureCommonResponse> listenKey();

    @GET("/az/future/user/v1/balance/list")
    Call<FutureCommonResponse> listBalance();

    @GET("/az/future/cache/v1/balance")
    Call<FutureCommonResponse> getBalance();

    @POST("/az/future/user/v1/position/adjust-leverage")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Call<FutureCommonResponse> adjustLeverage(@Query("symbol") String symbol,@Query("positionSide") String positionSide,@Query("leverage") Integer leverage);

}
