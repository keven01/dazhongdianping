package com.kevin.dianping;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/6.
 */
@ContentView(R.layout.welcome_guide)
public class WelcomeGuide extends Activity {
    @ViewInject(R.id.btn_jump)
    private Button btn;
    @ViewInject(R.id.welcome_pager)
    private ViewPager viewPager;
    private List<View> list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        initViewPager();
    }
    //点击页面跳转到主页面
    @Event(value = R.id.btn_jump)
    private void Click_Jump(View v){
        startActivity(new Intent(WelcomeGuide.this,MainActivity.class));
        finish();
    }
    //页卡
    private void initViewPager(){
        list = new ArrayList<>();
        ImageView i1 = new ImageView(this);
        i1.setImageResource(R.drawable.guide_01);
        list.add(i1);
        ImageView i2 = new ImageView(this);
        i2.setImageResource(R.drawable.guide_02);
        list.add(i2);
        ImageView i3 = new ImageView(this);
        i3.setImageResource(R.drawable.guide_03);
        list.add(i3);
        viewPager.setAdapter(new MyAdapter());
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                                              @Override
                                              public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                                              }
                                              @Override
                                              public void onPageSelected(int position) {
                                                  if(position == 2){
                                                      btn.setVisibility(View.VISIBLE);
                                                  }else {
                                                      btn.setVisibility(View.GONE);
                                                  }
                                              }
                                              @Override
                                              public void onPageScrollStateChanged(int state) {
                                              }
                                          }
        );
    }
    private class MyAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
        //初始化item
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(list.get(position));
            return list.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object);//按钮会报错，父类要注销点
            container.removeView(list.get(position));
        }
    }
}
