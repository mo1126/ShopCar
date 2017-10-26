package fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.dell.yuekao1.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.stx.xhb.xbanner.XBanner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import adapter.RvAdapter;
import bean.News;
import okhttp3.Call;
import presenter.NewsPresenter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.dell.yuekao1.MainActivity;
import com.example.dell.yuekao1.R;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.stx.xhb.xbanner.XBanner;
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import adapter.MyAdapter;
import adapter.RvAdapter;
import bean.News;
import common.Api;
import okhttp3.Call;
import okhttp3.Response;
import presenter.NewsPresenter;
import utils.Callbck;
import utils.NetRequest;
import view.NewsView;

/**
 * Created by DELL on 2017/10/24.
 */

public class Fragment2 extends Fragment  implements NewsView, XBanner.XBannerAdapter{

    private View view;
    private RecyclerView rv;
    private List<News.TopStoriesBean> top_stories;
    private List<News.StoriesBean> stories;
    private Object data;
    private List<String> imgs;
    private View xbanner;
    private XBanner xb;
    private SwipeRefreshLayout swipe;
    private NewsPresenter presenter;
    private HeaderAndFooterWrapper mHeaderAndFooterWrapper;
    private RvAdapter rvAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.zuixin1, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        presenter = new NewsPresenter(this);
        presenter.requestNews();
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                presenter.requestNews();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipe.setRefreshing(false);
                    }
                }, 500);
            }
        });





    }

    private void initView() {
        rv = view.findViewById(R.id.rv);
        swipe = view.findViewById(R.id.swipe);
        imgs = new ArrayList<>();
        xbanner = View.inflate(getActivity(), R.layout.xbanner, null);
        xb = xbanner.findViewById(R.id.xb);

        xb.setPoinstPosition(XBanner.CENTER);
        xb.setmAdapter(this);


    }

    @Override
    public void onNewsSuccess(final List<News.StoriesBean> stories, final List<News.TopStoriesBean> top_stories) {
        if (this != null) {
            getActivity().runOnUiThread(new Runnable() {

                @Override
                public void run() {

                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

                    rv.setLayoutManager(linearLayoutManager);
                    rvAdapter = new RvAdapter(getActivity(), stories);
                    rv.setAdapter(rvAdapter);

                    for (int i = 0; i < top_stories.size(); i++) {
                        imgs.add(top_stories.get(i).image);
                    }
                     xb.setData(imgs,null);

                    mHeaderAndFooterWrapper = new HeaderAndFooterWrapper(rvAdapter);
                    mHeaderAndFooterWrapper.addHeaderView(xbanner);

                    rv.setAdapter(mHeaderAndFooterWrapper);
                    mHeaderAndFooterWrapper.notifyDataSetChanged();
                }

            });
        }
    }

    @Override
    public void onFailure(Call call, IOException e) {

    }

    @Override
    public void onResume() {
        super.onResume();
        xb.startAutoPlay();
    }
    @Override
    public void onStop() {
        super.onStop();
        xb.stopAutoPlay();
    }

    @Override
    public void loadBanner(XBanner banner, View view, int position) {
        Glide.with(getActivity()).load(imgs.get(position)).into((ImageView) view);
    }
}
