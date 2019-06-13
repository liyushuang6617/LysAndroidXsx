package com.example.lysandroidxsx;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.lysandroidxsx.bean.ArtBean;
import com.example.lysandroidxsx.bean.ArtBean.ResultBean;
import com.youth.banner.Banner;

import java.io.Serializable;
import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTv;
    private Toolbar mToolbar1;
    private ViewPager mVp;
    /**
     * 返回
     */
    private TextView mTv1;
    private String imgs;
    private Banner mBan;
    private ArrayList<String> list1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
        initVp();
    }

    private void initVp() {
        //传值
        String img = getIntent().getStringExtra("img");
        //空集合
        list1 = new ArrayList<>();
        //添加数据
        list1.add(img);
        //添加banner数据
        mBan.setImages(list1);
        mBan.setDelayTime(1000);
        mBan.startAutoPlay();
        mBan.start();
    }

    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
        mToolbar1 = (Toolbar) findViewById(R.id.toolbar1);
        mVp = (ViewPager) findViewById(R.id.vp);
        mBan = (Banner) findViewById(R.id.ban);
        mTv1 = (TextView) findViewById(R.id.tv1);
        mTv1.setOnClickListener(this);

        //ToolBar名字
        mTv.setText("图册");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv1:
                //点击返回关闭当前页面
                finish();
                break;
        }
    }
}
