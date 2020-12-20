package com.example.my_game;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import java.io.BufferedInputStream;
import java.io.InputStream;


public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;
    Bitmap bitmap;
    public GamePanel(Context context) {
        super(context);
        getHolder().addCallback(this);
        thread=new MainThread(getHolder(),this);
        setFocusable(true);
//        InputStream inputStream = getResources().
        InputStream is = getResources().openRawResource(R.raw.cat);
        bitmap= BitmapFactory.decodeStream(new BufferedInputStream(is));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap, 10, 10,null);
    }

    public void surfaceCreated( SurfaceHolder arg0) {
        thread.setRunning(true);
        thread.start();

    }

    public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3){

    }

    public void surfaceDestroyed(SurfaceHolder arg0){
        if (thread.isAlive()){
            thread.setRunning(false);
        }

    }
}
