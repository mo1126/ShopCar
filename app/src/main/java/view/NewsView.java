package view;

import java.io.IOException;
import java.util.List;

import bean.News;
import okhttp3.Call;

/**
 * Created by DELL on 2017/10/24.
 */

public interface NewsView {
    void onNewsSuccess(List<News.StoriesBean> stories, List<News.TopStoriesBean> top_stories );
    void  onFailure(Call call, IOException e);
}
