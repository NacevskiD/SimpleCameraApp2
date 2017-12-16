package com.david.simplecameraapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button mTakePicButton;
    ImageView mPic;

    int TAKE_PIC = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTakePicButton = (Button) findViewById(R.id.take_picture_button);
        mPic = (ImageView) findViewById(R.id.camera_picture);

        mTakePicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePic();
            }
        });
    }

    void takePic(){
        Intent picIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (picIntent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(picIntent,TAKE_PIC);

        }
    }

    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data){
        if(requestCode == TAKE_PIC && resultCode == RESULT_OK){
            Bitmap thumbnail = data.getParcelableExtra("data");

            mPic.setImageBitmap(thumbnail);
        }
    }


}
