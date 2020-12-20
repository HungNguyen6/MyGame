package com.example.my_game;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

public class MainThread extends Thread {
    private boolean running;
    private GamePanel gamePanel;
    private SurfaceHolder surfaceHolder;

    public MainThread(SurfaceHolder surfaceHolder, GamePanel gamePanel){
        this.surfaceHolder=surfaceHolder;
        this.gamePanel=gamePanel;
    }

    public void setRunning(boolean b){
        running=b;
    }
    public void run(){
        super.run();
        long dem = 0L;
        Canvas canvas = null;
        while (running)
        {
            canvas=surfaceHolder.lockCanvas();
            if (canvas!=null)
            {
                gamePanel.draw(canvas);
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
            Log.d("testloop","loop "+(dem++));

        }
    }
}
