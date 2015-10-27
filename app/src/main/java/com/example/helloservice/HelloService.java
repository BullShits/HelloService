package com.example.helloservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by admin on 西暦15/10/26.
 */
public class HelloService extends Service implements MediaPlayer.OnCompletionListener {

    int mStartMode;
    IBinder iBinder;
    boolean mAllowRebind;
    private static final String TAG = "Service";
    private MediaPlayer media;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
//        return null;
        Log.e(TAG, "onBind");
        Log.e(TAG, "----"+media.getDuration()+"-----");
        return iBinder;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        media.stop();
        media.release();
        Log.e(TAG, "onDestroy");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        return super.onStartCommand(intent, flags, startId);
        Log.e(TAG, "onStartCommand");
        media.start();
        Log.e(TAG, "----" + media.getDuration() / 1000 / 60 + "-----");
        Log.e(TAG, "----" + media.getCurrentPosition() + "-----");
        return mStartMode;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        media = MediaPlayer.create(this, R.raw.about_you_now);
        media.setOnCompletionListener(this);
        Log.e(TAG, "onCreate");
    }

    @Override
    public boolean onUnbind(Intent intent) {
//        return super.onUnbind(intent);
        Log.e(TAG, "onUnbind");
        return mAllowRebind;
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.e(TAG, "onRebind");
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        Log.e(TAG, "MediaPlayer complete" + mp.getDuration());
    }
}
