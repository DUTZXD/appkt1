package com.example.myapplication.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.animation.ValueAnimator;

public class WaveView extends View {

    private Path wavePath;
    private Paint wavePaint;
    private int waveAmplitude = 80; // 波浪振幅
    private int waveLength = 800; // 波浪长度
    private int waveSpeed = 10; // 波浪速度
    private int waveOffset = 20; // 波浪偏移量

    private ValueAnimator waveAnimator;

    public WaveView(Context context) {
        this(context, null, 0);
    }

    public WaveView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WaveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        wavePath = new Path();
        wavePaint = new Paint();
        wavePaint.setColor(0xFF00BFFF); // 波浪线颜色
        wavePaint.setStyle(Paint.Style.STROKE);
        wavePaint.setAntiAlias(true);

        // 创建动画，不断更新波浪的偏移量
        waveAnimator = ValueAnimator.ofInt(0, waveLength);
        waveAnimator.setDuration(1000);
        waveAnimator.setInterpolator(new LinearInterpolator());
        waveAnimator.setRepeatCount(ValueAnimator.INFINITE);
        waveAnimator.addUpdateListener(animation -> {
            waveOffset = (int) animation.getAnimatedValue();
            invalidate(); // 重绘View
        });
        waveAnimator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawWave(canvas);
    }

    private void drawWave(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        wavePath.reset();
        wavePath.moveTo(-waveLength + waveOffset, height / 2);

        // 绘制波浪线
        for (int i = -waveLength; i < width + waveLength; i += waveLength) {
            wavePath.rQuadTo(waveLength / 4, -waveAmplitude, waveLength / 2, 0);
            wavePath.rQuadTo(waveLength / 4, waveAmplitude, waveLength / 2, 0);
        }

        wavePath.lineTo(width, height);
        wavePath.lineTo(0, height);
        wavePath.close();

        canvas.drawPath(wavePath, wavePaint);
    }

    // 允许自定义属性的setter方法
    public void setWaveAmplitude(int amplitude) {
        this.waveAmplitude = amplitude;
    }

    public void setWaveLength(int length) {
        this.waveLength = length;
    }

    public void setWaveSpeed(int speed) {
        this.waveSpeed = speed;
        waveAnimator.setDuration(1000 - waveSpeed * 10);
    }

    public void setWaveColor(int color) {
        wavePaint.setColor(color);
    }

    // 在View销毁时停止动画
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (waveAnimator != null) {
            waveAnimator.cancel();
        }
    }
}
