package com.example.sulikowskip.tender;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

public class MyView extends View {

  private int rotation = 0, dr = 5;
  private int width, height;
  private boolean paused;

  private Paint paint = new Paint();
  private int color = Color.RED;
  private Typeface typeface = Typeface.DEFAULT;

  private Handler mHandler = new Handler();

  private long frameCount = 0;
  private long timeStart = 0;

  public MyView(Context context) {
    super(context);
  }

  public MyView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public void startAnimation() {
    paused = false;
    frameCount = 0;
    timeStart = System.currentTimeMillis();
    mHandler.post(update);
  }

  public void stopAnimation() {
    paused = true;
  }

  private Runnable update = new Runnable() {
    @Override
    public void run() {
      invalidate();
    }
  };

  @Override
  protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);
    width = w;
    height = h;
  }

  @Override
  protected void onDraw(Canvas canvas) {
    frameCount++;
    long timeNow = System.currentTimeMillis();
    long elapsedTime = timeNow - timeStart;
    float fps = (float) frameCount / elapsedTime * 1000L;

//    canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.grid), 0, 0, null);

    paint.setAntiAlias(true);
    paint.setColor(Color.BLACK);
    paint.setTextSize(40);
    paint.setTypeface(Typeface.DEFAULT);
    paint.setTextAlign(Paint.Align.LEFT);
//    canvas.drawText("Frame count=" + frameCount + "    Elapsed time=" + elapsedTime +
//        "    FPS=" + fps, 20, 60, paint);

    rotation += dr;
    if (rotation >= 360) {
      rotation %= 360;
      color = getRandomColor();
      typeface = getRandomTypeface();
    }

    paint.setColor(color);
    paint.setTextSize(90);
    paint.setTypeface(typeface);
    paint.setTextAlign(Paint.Align.CENTER);

    canvas.translate(width/2, height/2);
    canvas.rotate(rotation);
    canvas.drawText("WELCOME TO TENDER!!!", 0, 0, paint);
    canvas.drawText("Make yourself at home,", 0, 100, paint);
    canvas.drawText("hit the get started button", 0, 200, paint);
    canvas.drawText("to get started, or,", 0, 300, paint);
    canvas.drawText("hit the email us button", 0, 400, paint);
    canvas.drawText("to send us some feedback!", 0, 500, paint);

    if (!paused) mHandler.postDelayed(update, 80);
  }

  private static int getRandomColor() {
    Random random = new Random();
    return Color.rgb(random.nextInt(256),random.nextInt(256), random.nextInt(256));
  }

  static final Typeface[] TYPEFACE = {
      Typeface.DEFAULT, Typeface.MONOSPACE, Typeface.SERIF, Typeface.SANS_SERIF
  };

  static final int[] STYLE = {
      Typeface.NORMAL, Typeface.BOLD, Typeface.ITALIC, Typeface.BOLD_ITALIC
  };

  private static Typeface getRandomTypeface() {
    Random random = new Random();
    return Typeface.create(TYPEFACE[random.nextInt(4)], STYLE[random.nextInt(4)]);
  }

}
