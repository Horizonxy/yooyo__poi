package com.yooyo.poi.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import com.yooyo.poi.R;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RouteDetailAdapter extends BaseAdapter {

    private List<String> datas ;
    private Context cxt;

    public RouteDetailAdapter(Context cxt, List<String> datas) {
        this.cxt = cxt;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if(convertView == null){
            convertView = LayoutInflater.from(cxt).inflate(R.layout.item_route_detail_desc, null, false);
            AutoUtils.auto(convertView);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        return convertView;
    }

    class Holder{
        @BindView(R.id.et_desc)
        EditText etDesc;

        public Holder(View view) {
            ButterKnife.bind(view);
        }
    }
}
