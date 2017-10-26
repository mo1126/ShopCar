package model;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.News;
import common.Api;
import okhttp3.Call;
import okhttp3.Response;
import utils.Callbck;
import utils.NetRequest;

/**
 * Created by DELL on 2017/10/24.
 */

public class NewsModel {
    private onNews onNews;
    public void getNews(){
        Map<String,String> params=new HashMap<>();
        NetRequest.call(Api.url, params, new Callbck() {
            @Override
            public void onSuccess(Call call, Response response) {
                try {
                    String result = response.body().string();
                    System.out.println(result);
                    Gson gson=new Gson();
                    News news = gson.fromJson(result, News.class);
                    List<News.StoriesBean> stories = news.stories;
                    List<News.TopStoriesBean> top_stories = news.top_stories;
                    onNews.onNewsSuccess(stories,top_stories);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call call, IOException e) {
                onNews.onFailure(call,e);

            }
        });
    }


    public void setOnNews(NewsModel.onNews onNews) {
        this.onNews = onNews;
    }

    public interface onNews{
        void onNewsSuccess( List<News.StoriesBean> stories,List<News.TopStoriesBean> top_stories );
        void  onFailure(Call call,IOException e);
    }
}
