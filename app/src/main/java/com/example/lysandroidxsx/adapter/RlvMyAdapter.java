package com.example.lysandroidxsx.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lysandroidxsx.R;
import com.example.lysandroidxsx.bean.ArtBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class RlvMyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<ArtBean.ResultBean> list;

    public RlvMyAdapter(Context context, ArrayList<ArtBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0) {
            View view = View.inflate(context, R.layout.layout_item1, null);
            return new ViewHolder1(view);
        } else {
            View view = View.inflate(context, R.layout.layout_item2, null);
            return new ViewHolder2(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        if (getItemViewType(i) == 0) {
            ViewHolder1 viewHolder1 = (ViewHolder1) viewHolder;
            viewHolder1.mybanner.setImages(list).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    ArtBean.ResultBean path1 = (ArtBean.ResultBean) path;
                    Glide.with(context).load(path1.getImages()).placeholder(R.mipmap.ic_launcher).into(imageView);
                }
            }).start();
        } else {
            ViewHolder2 viewHolder2 = (ViewHolder2) viewHolder;
            int pos = 0;
            if (list.size() > 0) {
                pos = i - 1;
            } else {
                pos = i;
            }
            viewHolder2.title.setText(list.get(pos).getText());
            viewHolder2.text.setText(list.get(pos).getTop_comments_content());
            Glide.with(context).load(list.get(pos).getImages()).placeholder(R.mipmap.ic_launcher).into(viewHolder2.iv);
            viewHolder2.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (a != null) {
                        a.onClick(i, list.get(i));
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (list.size() > 0 && position == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {
        Banner mybanner;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            mybanner = itemView.findViewById(R.id.mybanner);
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {
        TextView title;
        ImageView iv;
        TextView text;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title1);
            iv = itemView.findViewById(R.id.iv);
            text = itemView.findViewById(R.id.text1);
        }
    }

    private A a;

    public void setA(A a) {
        this.a = a;
    }

    public interface A {
        void onClick(int pos, ArtBean.ResultBean bean);
    }
}
