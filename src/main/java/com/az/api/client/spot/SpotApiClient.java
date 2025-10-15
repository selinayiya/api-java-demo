package com.az.api.client.spot;

import com.az.api.dto.CommonResponse;
import com.az.api.dto.spot.NetworthUpdateRequest;
import com.az.api.dto.spot.SpotPostOrderRequest;
import com.az.api.dto.spot.SpotUpdateOrderRequest;


/**
 * @author zhouzhuang
 * @create 2023/9/20 11:48
 */
public interface SpotApiClient {


    CommonResponse postOrder(SpotPostOrderRequest request);

    CommonResponse getOrder(Long id);

    CommonResponse queryOrder(Long orderId);

    CommonResponse delOrder(Long id);

    CommonResponse updateOrder(Long id, SpotUpdateOrderRequest request);

    CommonResponse netWorth(NetworthUpdateRequest request);

    CommonResponse nftHistoryOrder(Integer type, Integer status, String currency,
                                         Long startTime, Long endTime,
                                         Integer pageIndex, Integer pageSize);
}
