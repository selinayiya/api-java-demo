package com.az.api.client.future;

import com.az.api.client.HttpProxyProperties;
import com.az.api.client.OkHttpClientBuilder;
import com.az.api.interceptor.FutureOkHttpInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


/**
 * U-BASE future
 * @author az
 * @create 2023/9/20 12:18
 */
public class UFutureApiClientImpl extends AbstractFutureApiClient {

    private final static String API_URL = "https://f-api.myaztests.com";

    private final FutureApiService service;

    public UFutureApiClientImpl(HttpProxyProperties proxyProperties){
        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl(API_URL)
                        .client(OkHttpClientBuilder.build(proxyProperties,new FutureOkHttpInterceptor()))
                        .addConverterFactory(JacksonConverterFactory.create())
                        .build();
        service = retrofit.create(FutureApiService.class);
    }

    @Override
    FutureApiService getService() {
        return service;
    }


}
