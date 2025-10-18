package com.az.api.client.future;

import com.az.api.dto.FutureCommonResponse;
import com.az.api.dto.future.FutureOrderCancelAllRequest;
import com.az.api.dto.future.FutureOrderCancelRequest;
import com.az.api.dto.future.FuturePostOrderRequest;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

/**
 * @author az
 * @create 2023/9/20 14:28
 */
public interface FutureApiService {
    @GET("/az/future/public/client")
    Call<FutureCommonResponse> getPublicClient();

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


    @POST("/az/future/user/v1/position/adjust-leverage")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Call<FutureCommonResponse> adjustLeverage(@Query("symbol") String symbol,@Query("positionSide") String positionSide,@Query("leverage") Integer leverage);

}
