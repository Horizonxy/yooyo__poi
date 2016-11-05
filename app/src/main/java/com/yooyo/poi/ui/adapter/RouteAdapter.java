package com.yooyo.poi.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.orhanobut.logger.Logger;
import com.yooyo.poi.R;
import com.yooyo.poi.model.bean.RouteVo;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.functions.Action1;

public class RouteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<RouteVo> mDatas;
    private LayoutInflater mInflater;
    private Context mCxt;

    public RouteAdapter(Context context, List<RouteVo> data) {
        super();
        this.mInflater = LayoutInflater.from(context);
        this.mDatas = data;
        this.mCxt = context;
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        final ChildViewHolder holder = (ChildViewHolder) viewHolder;
        final RouteVo item = mDatas.get(position);
        holder.tvRoute.setText(item.getRoute_name());
        RxView.clicks(holder.tvRoute).throttleFirst(1, TimeUnit.SECONDS).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                Logger.i("click route: " + item.getRoute_name());
            }
        });
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewHolder, int position) {
        View view = mInflater.inflate(R.layout.item_route, viewHolder, false);
        AutoUtils.auto(view);
        return new ChildViewHolder(view);
    }

    public class ChildViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_route)
        TextView tvRoute;

        public ChildViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}