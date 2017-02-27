package com.example.administrator.qgweibo.View.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.administrator.qgweibo.Const.Consts;
import com.example.administrator.qgweibo.Service.NetworkStateService;

/**
 * Created by Administrator on 2017/2/26.
 */
public class BaseActivity extends FragmentActivity implements NetworkStateService.DoWhenDisconnected {
    public static NetworkStateService.DoWhenDisconnected  event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        event = BaseActivity.this;
        Intent intent = new Intent();
        intent.setAction(Consts.NETWORKSTATE_SERVICE);
        startService(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent intent = new Intent();
        intent.setAction(Consts.NETWORKSTATE_SERVICE);
        stopService(intent);
    }

    @Override
    public void doChange(boolean networkValid) {
        if(!networkValid){
            Toast.makeText(this,"网络不给力！",Toast.LENGTH_SHORT).show();
        }
    }
}
