package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.yuekao1.R;

import java.util.List;

import bean.News;

/**
 * Created by DELL on 2017/10/24.
 */

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder>{

    private Context context;
    private List<News.StoriesBean> stories;

    public RvAdapter(Context context, List<News.StoriesBean> stories) {
        this.context = context;
        this.stories = stories;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.rv_item, null);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_title.setText(stories.get(position).title);
        List<String> images = stories.get(position).images;

        Glide.with(context).load(images.get(0)).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return stories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView tv_title;
        private final ImageView iv;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            iv = itemView.findViewById(R.id.iv);

        }
    }
}
