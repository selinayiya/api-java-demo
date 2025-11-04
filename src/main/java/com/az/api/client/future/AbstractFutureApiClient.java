package com.az.api.client.future;

import com.google.gson.Gson;
import com.az.api.dto.FutureCommonResponse;
import com.az.api.dto.future.FutureOrderCancelAllRequest;
import com.az.api.dto.future.FutureOrderCancelRequest;
import com.az.api.dto.future.FuturePostOrderRequest;
import retrofit2.Call;
import retrofit2.Response;

import java.util.List;
import java.util.Map;

/**
 * @author az
 * @create 2023/9/20 18:23
 */
public abstract class AbstractFutureApiClient implements FutureApiClient {
    private final Gson gson = new Gson();

    @Override
    public FutureCommonResponse getPublicClient() {
        return executeSync(getService().getPublicClient());
    }

    @Override
    public FutureCommonResponse getPublicSymbolCoins() {
        return executeSync(getService().getPublicSymbolCoins());
    }

    @Override
    public FutureCommonResponse getPublicSymbolDetail(String symbol) {
        return executeSync(getService().getPublicSymbolDetail(symbol));
    }

    @Override
    public FutureCommonResponse getPublicSymbolList() {
        return executeSync(getService().getPublicSymbolList());
    }

    @Override
    public FutureCommonResponse getPublicLeverageBracketDetail(String symbol) {
        return executeSync(getService().getPublicLeverageBracketDetail(symbol));
    }

    @Override
    public FutureCommonResponse getPublicLeverageBracketList() {
        return executeSync(getService().getPublicLeverageBracketList());
    }

    @Override
    public FutureCommonResponse getPublicQTicker(String symbol) {
        return executeSync(getService().getPublicQTicker(symbol));
    }

    @Override
    public FutureCommonResponse getPublicQTickersList() {
        return executeSync(getService().getPublicQTickersList());
    }

    @Override
    public FutureCommonResponse getPublicQDeal(String symbol, Integer num) {
        return executeSync(getService().getPublicQDeal(symbol, num));
    }

    @Override
    public FutureCommonResponse getPublicQDepth(String symbol, Integer level) {
        return executeSync(getService().getPublicQDepth(symbol, level));
    }

    @Override
    public FutureCommonResponse getPublicQSymbolIndexPrice(String symbol) {
        return executeSync(getService().getPublicQSymbolIndexPrice(symbol));
    }

    @Override
    public FutureCommonResponse getPublicQIndexPrice() {
        return executeSync(getService().getPublicQIndexPrice());
    }

    @Override
    public FutureCommonResponse getPublicQSymbolMarkPrice(String symbol) {
        return executeSync(getService().getPublicQSymbolMarkPrice(symbol));
    }

    @Override
    public FutureCommonResponse getPublicQMarketPrice(String symbol) {
        return executeSync(getService().getPublicQMarketPrice(symbol));
    }

    @Override
    public FutureCommonResponse getBestPrice(String symbol) {
        return executeSync(getService().getBestPrice(symbol));
    }

    @Override
    public FutureCommonResponse getPublicQKline(String symbol, String interval, Long startTime, Long endTime, Long limit) {
        return executeSync(getService().getPublicQKline(symbol, interval, startTime, endTime, limit));
    }

    @Override
    public FutureCommonResponse getPublicQAggTicker(String symbol) {
        return executeSync(getService().getPublicQAggTicker(symbol));
    }

    @Override
    public FutureCommonResponse getPublicQFundingRate(String symbol) {
        return executeSync(getService().getPublicQFundingRate(symbol));
    }

    @Override
    public FutureCommonResponse getPublicQTickerBook(String symbol) {
        return executeSync(getService().getPublicQTickerBook(symbol));
    }

    @Override
    public FutureCommonResponse getPublicQFundingRateRecord(String symbol, Long id, String direction, Long limit){
        return executeSync(getService().getPublicQFundingRateRecord(symbol, id, direction, limit));
    }

    @Override
    public FutureCommonResponse getPublicContractRiskBalance(String symbol, Long id, String direction, Long limit) {
        return  executeSync(getService().getPublicContractRiskBalance(symbol, id, direction, limit));
    }

    @Override
    public FutureCommonResponse getPublicContractOpenInterest(String symbol) {
        return  executeSync(getService().getPublicContractOpenInterest(symbol));
    }

    @Override
    public FutureCommonResponse getOrderSlim(Long orderId){
        return executeSync(getService().getOrderSlim(orderId));
    }

    @Override
    public FutureCommonResponse postOrder(FuturePostOrderRequest request) {
        return executeSync(getService().postOrder(request));
    }
    @Override
    public FutureCommonResponse batchOrder(List<FuturePostOrderRequest> futurePostOrderRequestList){
        return executeSync(getService().batchOrder(gson.toJson(futurePostOrderRequestList)));
    }

    @Override
    public FutureCommonResponse orderListHistory(Map<String, String> params) {
        return executeSync(getService().orderListHistory(params));
    }

    @Override
    public FutureCommonResponse orderTradeList(Map<String, String> params) {
        return executeSync(getService().orderTradeList(params));
    }

    @Override
    public FutureCommonResponse orderDetail(Long orderId) {
        return executeSync(getService().orderDetail(orderId));
    }
    @Override
    public FutureCommonResponse orderList(Map<String, String> params){
        return executeSync(getService().orderList(params));
    }
    @Override
    public FutureCommonResponse orderCancel(Long orderId){
        return executeSync(getService().orderCancel(FutureOrderCancelRequest.builder().orderId(orderId).build()));
    }

    @Override
    public FutureCommonResponse allCancel(String symbol){
        symbol = symbol==null?"":symbol;
        return executeSync(getService().allCancel(FutureOrderCancelAllRequest.builder().symbol(symbol).build()));
    }

    @Override
    public FutureCommonResponse entrustCreatePlan(Map<String, String> params){
        return executeSync(getService().entrustCreatePlan(params));
    }

    @Override
    public FutureCommonResponse entrustCancelPlan(Long entrustId){
        return executeSync(getService().entrustCancelPlan(entrustId));
    }

    @Override
    public FutureCommonResponse entrustCancelAllPlan(String symbol){
        return executeSync(getService().entrustCancelAllPlan(symbol));
    }

    @Override
    public FutureCommonResponse accountInfo(){
        return executeSync(getService().accountInfo());
    }

    @Override
    public FutureCommonResponse balanceDetail(String coin){
        return executeSync(getService().balanceDetail(coin));
    }

    @Override
    public FutureCommonResponse listenKey(){
        return executeSync(getService().listenKey());
    }

    @Override
    public FutureCommonResponse listBalance() {
        return executeSync(getService().listBalance());
    }

    @Override
    public FutureCommonResponse getBalance() {
        return executeSync(getService().getBalance());
    }

    @Override
    public FutureCommonResponse adjustLeverage(String symbol,String positionSide,Integer leverage){
        return executeSync(getService().adjustLeverage(symbol,positionSide,leverage));
    }

    public FutureCommonResponse executeSync(Call<FutureCommonResponse> call) {
        try {
            Response<FutureCommonResponse> response = call.execute();

            if (response.isSuccessful()) {
                return response.body();
            }else {
                System.err.println(String.format("failed to call interface:%s,%s",response.code(),response.toString()));
                String err = new String(response.errorBody().bytes());
                return gson.fromJson(err,FutureCommonResponse.class);
            }
        }catch (Exception e){
            System.err.println("call interface exception:"+e);
            throw new RuntimeException(e);
        }
    }

    abstract FutureApiService getService();
}
