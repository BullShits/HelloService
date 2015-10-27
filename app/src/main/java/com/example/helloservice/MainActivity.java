package com.example.helloservice;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;


public class MainActivity extends AppCompatActivity
        implements SeekBar.OnSeekBarChangeListener {
    private static final String TAG = "MainActivity";
    Button btnPlay, btnStop;
    private Handler mHanler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHanler = new Handler();
        btnPlay = (Button) findViewById(R.id.button);
        btnStop = (Button) findViewById(R.id.button2);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playMusic(v);
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopMusic(v);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void playMusic(View v){
        Intent i = new Intent(this, HelloService.class);
        startService(i);
//        bindService
    }

    private void stopMusic(View v){
        Intent i = new Intent(this, HelloService.class);
        stopService(i);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        mHanler.removeCallbacks(mUpdateTimeTask);
    }

    private String milliSecondsToTimer(long milliseconds){
        String secondsString = "";
        // Convert total duration into time
        int minutes = (int) (milliseconds / (1000 * 60));
        int seconds = (int) (milliseconds % (1000 * 60));
        secondsString = (seconds > 10) ? (""+seconds) : ("0"+seconds);

        return (minutes + " : " + secondsString);
    }

    public void updateProgressBar(){
        mHanler.postDelayed(mUpdateTimeTask, 500);
    }

    private Runnable mUpdateTimeTask = new Runnable() {
        @Override
        public void run() {



            mHanler.postDelayed(this, 500);
        }
    };


















}
