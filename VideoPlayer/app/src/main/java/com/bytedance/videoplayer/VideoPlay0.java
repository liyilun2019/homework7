package com.bytedance.videoplayer;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import static com.bytedance.videoplayer.MainActivity.TAG;
public class VideoPlay0 extends AppCompatActivity {
    public static final String PROGESS="PROGESS";
    private int progess=0;
    VideoPlayFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: VideoPlay0");
        setContentView(R.layout.activity_video_play0);
        if(savedInstanceState!=null){
            progess = savedInstanceState.getInt(PROGESS,0);
            Log.d(TAG, "VideoPlay onCreate: progess="+progess);
        }
        fragment = new VideoPlayFragment();
        ((VideoPlayFragment) fragment).setProgess(progess);
        getSupportFragmentManager().beginTransaction().replace(R.id.placeholder0,
                fragment).commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, "Video Play 0 onSaveInstanceState: SAVE:"+progess);
        super.onSaveInstanceState(outState);
        progess=fragment.getProgess();
        outState.putInt(PROGESS,progess);
    }
}
