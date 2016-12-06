package com.kevin.dianping;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by Administrator on 2016/12/6.
 */
@ContentView(R.layout.activity_main)
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }
    @Event(value = R.id.btn_test_xutils)
    private void Click(View v){
        Toast.makeText(this,"测试xUtils",Toast.LENGTH_SHORT).show();
    }
}
