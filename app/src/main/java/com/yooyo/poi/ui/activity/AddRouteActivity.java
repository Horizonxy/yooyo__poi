package com.yooyo.poi.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.jakewharton.rxbinding.view.RxView;
import com.yooyo.poi.R;
import com.yooyo.poi.ui.adapter.RouteDetailAdapter;
import com.yooyo.poi.util.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import butterknife.BindView;
import rx.functions.Action1;

public class AddRouteActivity extends BaseActivity {

    @BindView(R.id.et_route_name)
    EditText etRouteName;
    @BindView(R.id.et_route_address)
    EditText etRouteAddresss;
    @BindView(R.id.et_route_type)
    EditText etRouteType;
    @BindView(R.id.et_route_phone)
    EditText etRoutePhone;
    @BindView(R.id.btn_add_detail_des)
    Button btnAddDetailDes;
    @BindView(R.id.btn_save)
    Button btnSave;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    @BindView(R.id.lv_detail_desc)
    ListView lvDetailDesc;

    private List<String> detailDatas = new ArrayList<String>();
    private RouteDetailAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initView() {
        tvTitle.setText("添  加");

        adapter = new RouteDetailAdapter(this, detailDatas);
        lvDetailDesc.setAdapter(adapter);

        RxView.clicks(btnAddDetailDes).throttleFirst(1, TimeUnit.SECONDS).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                detailDatas.add("11");
                adapter.notifyDataSetChanged();
                Utils.setListViewHeightBasedOnChildren(lvDetailDesc);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_route;
    }
}
