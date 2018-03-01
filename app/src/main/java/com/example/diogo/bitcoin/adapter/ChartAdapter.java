package com.example.diogo.bitcoin.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.diogo.bitcoin.R;
import com.example.diogo.bitcoin.data.model.StatsResponse;

import java.util.List;

/**
 * Created by Diogo on 2/28/2018.
 */

public class ChartAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @NonNull
    private List<StatsResponse> statsResponse;

    private static final int VIEW_TYPE_DATA = 0;
    private static final int VIEW_TYPE_EMPTY_STATE = 1;

    @Override
    public int getItemViewType(int position) {
        return statsResponse.isEmpty() ? VIEW_TYPE_EMPTY_STATE : VIEW_TYPE_DATA;
    }

    public void setData(List<StatsResponse> data) {
        statsResponse = data;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;

        if (viewType == VIEW_TYPE_DATA) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_stats, parent, false);
            viewHolder = new StatsViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_stats_empty, parent, false);
            viewHolder = new StatsEmptyStateViewHolder(view);
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof StatsViewHolder) {
            StatsResponse stats = statsResponse.get(position);
            ((StatsViewHolder) holder).bind(stats);
        }
    }

    @Override
    public int getItemCount() {
        return statsResponse.isEmpty() ? 1 : statsResponse.size();
    }

    static class StatsViewHolder extends RecyclerView.ViewHolder {
        private TextView txtMarketPrice;
        private TextView txtTradeVolume;

        public StatsViewHolder(View itemView) {
            super(itemView);
            txtMarketPrice = itemView.findViewById(R.id.txtMarketPrice);
            txtTradeVolume = itemView.findViewById(R.id.txtTradeVolume);
        }

        public void bind(StatsResponse statsResponse) {
            txtMarketPrice.setText("Market Price USD:".concat(String.valueOf(statsResponse.getMarket_price_usd())));
            txtTradeVolume.setText("Volume Trade USD".concat(String.valueOf(statsResponse.getTrade_volume_usd())));
        }
    }

    static class StatsEmptyStateViewHolder extends RecyclerView.ViewHolder {
        public StatsEmptyStateViewHolder(View itemView) {
            super(itemView);
        }
    }
}
