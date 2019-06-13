package com.example.lysandroidxsx;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lysandroidxsx.adapter.RlvMyAdapter;
import com.example.lysandroidxsx.bean.ArtBean;
import com.example.lysandroidxsx.model.MyMImple;
import com.example.lysandroidxsx.presenter.MyP;
import com.example.lysandroidxsx.presenter.MyPImple;
import com.example.lysandroidxsx.view.MyV;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements MyV, RlvMyAdapter.A {

    private static final String TAG = Main2Activity.class.getName();
    private RecyclerView mRe;
    private Toolbar mToolbar;
    private TextView mTv;
    private ArrayList<ArtBean.ResultBean> list;
    private RlvMyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //初始化
        initView();
        //调用MVP
        initData();
    }


    //找到控件
    private void initView() {
        mRe = (RecyclerView) findViewById(R.id.re);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTv = (TextView) findViewById(R.id.tv);

        mTv.setText("主页");

        list = new ArrayList<>();
        adapter = new RlvMyAdapter(this, list);
        mRe.setAdapter(adapter);
        mRe.setLayoutManager(new LinearLayoutManager(this));

        //条目监听
        adapter.setA(this);
    }

    private void initData() {
        //调用MVp
        MyP myP = new MyPImple(new MyMImple(), this);
        //请求数据
        myP.getData();
    }

    @Override
    public void onSuccess(ArtBean bean) {
        list.addAll(bean.getResult());
        adapter.notifyDataSetChanged();
        Log.e(TAG, "onSuccess: " + bean.getResult().toString());
    }

    @Override
    public void onFail(String msg) {
        Log.e(TAG, "onFail: " + msg);
    }

    @Override
    public void onClick(int pos, ArtBean.ResultBean bean) {
        Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
        intent.putExtra("img",bean.getImages());
        startActivity(intent);
        Toast.makeText(this, "发送成功", Toast.LENGTH_SHORT).show();
    }
}
