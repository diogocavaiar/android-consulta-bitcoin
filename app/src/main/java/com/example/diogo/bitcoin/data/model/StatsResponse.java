package com.example.diogo.bitcoin.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Diogo on 2/28/2018.
 */

public class StatsResponse {

    @SerializedName("timestamp")
    private long timestamp;
    @SerializedName("market_price_usd")
    private double market_price_usd;
    @SerializedName("hash_rate")
    private double hash_rate;
    @SerializedName("total_fees_btc")
    private double total_fees_btc;
    @SerializedName("n_btc_mined")
    private double n_btc_mined;
    @SerializedName("n_tx")
    private double n_tx;
    @SerializedName("n_blocks_mined")
    private int n_blocks_mined;
    @SerializedName("minutes_between_blocks")
    private double minutes_between_blocks;
    @SerializedName("totalbc")
    private double totalbc;
    @SerializedName("n_blocks_total")
    private int n_blocks_total;
    @SerializedName("estimated_transaction_volume_usd")
    private double estimated_transaction_volume_usd;
    @SerializedName("blocks_size")
    private long blocks_size;
    @SerializedName("miners_revenue_usd")
    private double miners_revenue_usd;
    @SerializedName("nextretarget")
    private double nextretarget;
    @SerializedName("difficulty")
    private double difficulty;
    @SerializedName("estimated_btc_sent")
    private double estimated_btc_sent;
    @SerializedName("miners_revenue_btc")
    private double miners_revenue_btc;
    @SerializedName("total_btc_sent")
    private double total_btc_sent;
    @SerializedName("trade_volume_btc")
    private double trade_volume_btc;
    @SerializedName("trade_volume_usd")
    private double trade_volume_usd;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public double getMarket_price_usd() {
        return market_price_usd;
    }

    public void setMarket_price_usd(double market_price_usd) {
        this.market_price_usd = market_price_usd;
    }

    public double getHash_rate() {
        return hash_rate;
    }

    public void setHash_rate(double hash_rate) {
        this.hash_rate = hash_rate;
    }

    public double getTotal_fees_btc() {
        return total_fees_btc;
    }

    public void setTotal_fees_btc(double total_fees_btc) {
        this.total_fees_btc = total_fees_btc;
    }

    public double getN_btc_mined() {
        return n_btc_mined;
    }

    public void setN_btc_mined(double n_btc_mined) {
        this.n_btc_mined = n_btc_mined;
    }

    public double getN_tx() {
        return n_tx;
    }

    public void setN_tx(double n_tx) {
        this.n_tx = n_tx;
    }

    public int getN_blocks_mined() {
        return n_blocks_mined;
    }

    public void setN_blocks_mined(int n_blocks_mined) {
        this.n_blocks_mined = n_blocks_mined;
    }

    public double getMinutes_between_blocks() {
        return minutes_between_blocks;
    }

    public void setMinutes_between_blocks(double minutes_between_blocks) {
        this.minutes_between_blocks = minutes_between_blocks;
    }

    public double getTotalbc() {
        return totalbc;
    }

    public void setTotalbc(double totalbc) {
        this.totalbc = totalbc;
    }

    public int getN_blocks_total() {
        return n_blocks_total;
    }

    public void setN_blocks_total(int n_blocks_total) {
        this.n_blocks_total = n_blocks_total;
    }

    public double getEstimated_transaction_volume_usd() {
        return estimated_transaction_volume_usd;
    }

    public void setEstimated_transaction_volume_usd(double estimated_transaction_volume_usd) {
        this.estimated_transaction_volume_usd = estimated_transaction_volume_usd;
    }

    public long getBlocks_size() {
        return blocks_size;
    }

    public void setBlocks_size(long blocks_size) {
        this.blocks_size = blocks_size;
    }

    public double getMiners_revenue_usd() {
        return miners_revenue_usd;
    }

    public void setMiners_revenue_usd(double miners_revenue_usd) {
        this.miners_revenue_usd = miners_revenue_usd;
    }

    public double getNextretarget() {
        return nextretarget;
    }

    public void setNextretarget(double nextretarget) {
        this.nextretarget = nextretarget;
    }

    public double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(double difficulty) {
        this.difficulty = difficulty;
    }

    public double getEstimated_btc_sent() {
        return estimated_btc_sent;
    }

    public void setEstimated_btc_sent(double estimated_btc_sent) {
        this.estimated_btc_sent = estimated_btc_sent;
    }

    public double getMiners_revenue_btc() {
        return miners_revenue_btc;
    }

    public void setMiners_revenue_btc(double miners_revenue_btc) {
        this.miners_revenue_btc = miners_revenue_btc;
    }

    public double getTotal_btc_sent() {
        return total_btc_sent;
    }

    public void setTotal_btc_sent(double total_btc_sent) {
        this.total_btc_sent = total_btc_sent;
    }

    public double getTrade_volume_btc() {
        return trade_volume_btc;
    }

    public void setTrade_volume_btc(double trade_volume_btc) {
        this.trade_volume_btc = trade_volume_btc;
    }

    public double getTrade_volume_usd() {
        return trade_volume_usd;
    }

    public void setTrade_volume_usd(double trade_volume_usd) {
        this.trade_volume_usd = trade_volume_usd;
    }
}
