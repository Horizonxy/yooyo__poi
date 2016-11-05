package com.yooyo.poi;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.chanven.lib.cptr.PtrClassicFrameLayout;
import com.chanven.lib.cptr.PtrDefaultHandler;
import com.chanven.lib.cptr.PtrFrameLayout;
import com.chanven.lib.cptr.loadmore.OnLoadMoreListener;
import com.chanven.lib.cptr.recyclerview.RecyclerAdapterWithHF;
import com.yooyo.poi.di.component.DaggerMainCompoent;
import com.yooyo.poi.di.module.MainModule;
import com.yooyo.poi.model.bean.RouteVo;
import com.yooyo.poi.presenter.RoutePresenter;
import com.yooyo.poi.ui.activity.BaseActivity;
import com.yooyo.poi.ui.adapter.RouteAdapter;
import com.yooyo.poi.ui.iview.MainViewListener;
import com.yooyo.poi.ui.widget.DividerItemDecoration;
import com.yooyo.poi.ui.widget.WrapContentLinearLayoutManager;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainViewListener {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.refresh_layout)
    PtrClassicFrameLayout refreshLayout;
    @Inject
    RoutePresenter presenter;

    int pateNo = 1;
    RecyclerAdapterWithHF adapter;
    List<RouteVo> datas = new ArrayList<RouteVo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerMainCompoent.builder().mainModule(new MainModule(this)).build().inject(this);
    }

    @Override
    protected void initView() {
        tvTitle.setText("线  路");

        recyclerView.setAdapter(adapter = new RecyclerAdapterWithHF(new RouteAdapter(this, datas)));
        recyclerView.setLayoutManager(new WrapContentLinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.clearAnimation();

        refreshLayout.setLastUpdateTimeRelateObject(this);
        refreshLayout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                pateNo = 1;
                loadData();
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void loadMore() {
                loadData();
            }
        });
        refreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshLayout.autoRefresh(true);
            }
        }, 50);
    }

    private void loadData() {
        presenter.getRouteList();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public int getPageNo() {
        return pateNo;
    }

    @Override
    public void onFailure() {
        refreshLayout.setLoadMoreEnable(true);
        refreshLayout.loadMoreComplete(true);
    }

    @Override
    public void onSuccess(List<RouteVo> data) {
        if(pateNo == 1){
            datas.clear();
        }
        datas.addAll(data);
        adapter.notifyItemRangeChangedHF(datas.size() - data.size(), data.size());
        pateNo++;
    }

    @Override
    public void onFinish() {
        refreshLayout.setNoMoreData();
    }

    @Override
    public void onCompleted(int pageNo) {
        if(pageNo == 1){
            refreshLayout.refreshComplete();
        }
        refreshLayout.setLoadMoreEnable(true);
        refreshLayout.loadMoreComplete(true);
    }

    @Override
    public void onDestroy() {
        if (presenter != null) {
            presenter.onDestroy();
        }
        super.onDestroy();
    }
}
