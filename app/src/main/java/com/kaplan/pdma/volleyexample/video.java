package com.kaplan.pdma.volleyexample;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class video extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        Button button10 = (Button) findViewById(R.id.button10);
        VideoView videoView =(VideoView)findViewById(R.id.videoView);
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri=Uri.parse("rtsp://r17---sn-oguesnes.googlevideo.com/Cj0LENy73wIaNAmlsy2csboSrxMYDSANFC30y7pYMOCoAUIASARgl6-tgaOzhKRYigELdkM4QWxuRnlJTlEM/14D50B6D06E27512263A64C62C814D2C645721F5.7F16B2470294DCA31C49CCC5024ED6ACC2E4DC17/yt6/1/video.3gp");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(video.this, setting.class);
                startActivity(intent);
            }
        });
    }
}
