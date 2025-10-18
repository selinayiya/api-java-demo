package com.az.api.client.spot;

import com.az.api.dto.CommonResponse;
import com.az.api.dto.spot.NetworthUpdateRequest;
import com.az.api.dto.spot.SpotPostOrderRequest;
import com.az.api.dto.spot.SpotUpdateOrderRequest;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 * @author az
 * @create 2023/9/20 14:28
 */
public interface SpotApiService {

    @GET("/az/spot/public/symbol")
    Call<CommonResponse> getPublicSymbol(@Query("symbol") String symbol, @Query("symbols") String symbols, @Query("version") String version);

    @GET("/az/spot/public/depth")
    Call<CommonResponse> getPublicDepth(@Query("symbol") String symbol, @Query("limit") Long limit);

    @GET("/az/spot/public/kline")
    Call<CommonResponse> getPublicKLine(@Query("symbol") String symbol, @Query("interval") String interval, @Query("startTime") Long startTime, @Query("endTime") Long endTime, @Query("limit") Long limit);

    @GET("/az/spot/public/trade/history")
    Call<CommonResponse> getPublicTradeHistory(@Query("symbol") String symbol, @Query("limit") Long limit, @Query("direction") String direction, @Query("fromId") Long fromId);

    @GET("/az/spot/public/trade/recent")
    Call<CommonResponse> getPublicRecentTrade(@Query("symbol") String symbol, @Query("limit") Long limit);

    @GET("/az/spot/public/ticker")
    Call<CommonResponse>  getPublicTicker(@Query("symbol") String symbol, @Query("symbols") List<String> symbols, @Query("tags") String tags);

    @GET("/az/spot/public/ticker/price")
    Call<CommonResponse> getPublicTickerPrice(@Query("symbol") String symbol, @Query("symbols") List<String> symbols, @Query("tags") String tags);

    @POST("/az/spot/order")
    Call<CommonResponse> postOrder(@Body SpotPostOrderRequest request);

    @GET("/az/spot/order/{id}")
    Call<CommonResponse> getOrder(@Path("id")Long id);

    @GET("/az/spot/order")
    Call<CommonResponse> queryOrder(@Query("orderId") Long orderId);

    @DELETE("/az/spot/order/{id}")
    Call<CommonResponse> delOrder(@Path("id")Long id);

    @PUT("/az/spot/order/{id}")
    Call<CommonResponse> updateOrder(@Path("id")Long id, @Body SpotUpdateOrderRequest request);

    @POST("/az/spot/ws-token")
    Call<CommonResponse> getWsToken();
}
