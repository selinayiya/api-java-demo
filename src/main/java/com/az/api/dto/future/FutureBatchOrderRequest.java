package com.az.api.dto.future;

import lombok.Builder;
import lombok.Data;


/**
 * @author az
 * @create 2023/9/21 18:03
 */
@Data
@Builder
public class FutureBatchOrderRequest {

    private String list;
}
