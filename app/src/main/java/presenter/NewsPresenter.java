package presenter;

import java.io.IOException;
import java.util.List;

import bean.News;
import model.NewsModel;
import okhttp3.Call;
import view.NewsView;

/**
 * Created by DELL on 2017/10/24.
 */

public class NewsPresenter implements NewsModel.onNews {


    private NewsModel newsModel;
    private NewsView newsView;

    public NewsPresenter(NewsView newsView) {
        this.newsView = newsView;
        newsModel=new NewsModel();
        newsModel.setOnNews(this);
    }


    public void requestNews(){
        newsModel.getNews();
    }
    @Override
    public void onNewsSuccess(List<News.StoriesBean> stories, List<News.TopStoriesBean> top_stories) {
        newsView.onNewsSuccess(stories,top_stories);
    }

    @Override
    public void onFailure(Call call, IOException e) {
        newsView.onFailure(call,e);

    }
}
