package com.example.lysandroidxsx;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

//我是1810A的 李玉爽  正在参加期中A场考试  身份证号 410725200009236617
public class MainActivity extends AppCompatActivity {

    private ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化
        initView();
    }

    private void initView() {
        mIv = (ImageView) findViewById(R.id.iv);

        //给图片添加动画效果
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.myanim);
        mIv.startAnimation(animation);

        //动画的监听
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //3秒后跳转页面
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
