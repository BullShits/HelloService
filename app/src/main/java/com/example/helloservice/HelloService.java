package com.example.helloservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by admin on 西暦15/10/26.
 */
public class HelloService extends Service {

    int mStartMode;
    IBinder iBinder;
    boolean mAllowRebind;



    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
//        return null;
        return iBinder;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        return super.onStartCommand(intent, flags, startId);
        return mStartMode;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public boolean onUnbind(Intent intent) {
//        return super.onUnbind(intent);
        return mAllowRebind;
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }
}
