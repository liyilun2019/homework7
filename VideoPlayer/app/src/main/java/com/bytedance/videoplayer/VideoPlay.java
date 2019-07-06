package com.bytedance.videoplayer;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.widget.LinearLayout;
import static  com.bytedance.videoplayer.MainActivity.TAG;
public class VideoPlay extends AppCompatActivity {
    public static final String URI="URI";
    Uri resource;
    public static final String PROGESS="PROGESS";
    private int progess=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);
        if(savedInstanceState!=null){
            progess = savedInstanceState.getInt(PROGESS,0);
            resource = savedInstanceState.getParcelable(URI);
            Log.d(TAG, "VideoPlay onCreate: progess="+progess);
        }else{
            resource = getIntent().getData();
        }

        Fragment fragment = new VideoPlayFragment();
        ((VideoPlayFragment) fragment).setResource(resource);
        ((VideoPlayFragment) fragment).setProgess(progess);
        getSupportFragmentManager().beginTransaction().replace(
                R.id.placeholder,fragment).commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, "Video Play onSaveInstanceState: SAVE:"+progess);
        super.onSaveInstanceState(outState);
        outState.putInt(PROGESS,progess);
        outState.putParcelable(URI,resource);
    }
}
