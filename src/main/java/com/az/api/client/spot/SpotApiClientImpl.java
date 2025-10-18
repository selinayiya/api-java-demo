package com.az.api.client.spot;

import com.az.api.client.HttpProxyProperties;
import com.az.api.client.OkHttpClientBuilder;
import com.az.api.dto.CommonResponse;
import com.az.api.dto.spot.NetworthUpdateRequest;
import com.az.api.dto.spot.SpotPostOrderRequest;
import com.az.api.dto.spot.SpotUpdateOrderRequest;
import com.az.api.interceptor.SpotOkHttpInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.List;


/**
 * @author az
 * @create 2023/9/20 12:18
 */
public class SpotApiClientImpl implements SpotApiClient {

    private final static String API_URL = "https://s-api.myaztests.com";

    private final SpotApiService service;

    public SpotApiClientImpl(HttpProxyProperties proxyProperties){
        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl(API_URL)
                        .client(OkHttpClientBuilder.build(proxyProperties,new SpotOkHttpInterceptor()))
                        .addConverterFactory(JacksonConverterFactory.create())
                        .build();
        service = retrofit.create(SpotApiService.class);
    }

    @Override
    public CommonResponse getPublicSymbol(String symbol, String symbols, String version) {
        return executeSync(service.getPublicSymbol(symbol, symbols, version));
    }

    @Override
    public CommonResponse getPublicDepth(String symbol, Long limit) {
        return executeSync(service.getPublicDepth(symbol, limit));
    }

    @Override
    public CommonResponse getPublicKLine(String symbol, String interval, Long startTime, Long endTime, Long limit) {
        return executeSync(service.getPublicKLine(symbol, interval, startTime, endTime, limit));
    }

    @Override
    public CommonResponse getPublicTradeHistory(String symbol, Long limit, String direction, Long fromId) {
        return executeSync(service.getPublicTradeHistory(symbol, limit, direction, fromId));
    }

    @Override
    public CommonResponse getPublicRecentTrade(String symbol, Long limit) {
        return executeSync(service.getPublicRecentTrade(symbol, limit));
    }

    @Override
    public CommonResponse getPublicTicker(String symbol, List<String> symbols, String tags) {
        return executeSync(service.getPublicTicker(symbol, symbols, tags));
    }

    @Override
    public CommonResponse getPublicTickerPrice(String symbol, List<String> symbols, String tags) {
        return executeSync(service.getPublicTickerPrice(symbol, symbols, tags));
    }

    @Override
    public CommonResponse postOrder(SpotPostOrderRequest request) {
        return executeSync(service.postOrder(request));
    }

    @Override
    public CommonResponse getOrder(Long id) {
        return executeSync(service.getOrder(id));
    }

    @Override
    public CommonResponse queryOrder(Long orderId) {
        return executeSync(service.queryOrder(orderId));
    }

    @Override
    public CommonResponse delOrder(Long id) {
        return executeSync(service.delOrder(id));
    }

    @Override
    public CommonResponse updateOrder(Long id, SpotUpdateOrderRequest request) {
        return executeSync(service.updateOrder(id,request));
    }

    @Override
    public CommonResponse getWsToken() {
        return executeSync(service.getWsToken());
    }

    public CommonResponse executeSync(Call<CommonResponse> call) {
        try {
            Response<CommonResponse> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            }else {
                System.err.println(String.format("failed to call interface:%s,%s",response.code(),response.toString()));
                return CommonResponse.failure(response.toString());
            }
        }catch (Exception e){
            System.err.println("call interface exception:"+e);
            throw new RuntimeException(e);
        }
    }
}
