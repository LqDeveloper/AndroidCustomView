package com.example.my_android_demo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.my_android_demo.R;

public class DrawView extends View {

    private float currentX = 40f;
    private float currentY = 50f;
    private float radius = 15f;
    private Paint p = new Paint();

    public DrawView(Context context) {
        this(context, null);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context,attrs);
    }


    private void initView(Context context,@Nullable AttributeSet attrs){
        setBackgroundColor(Color.GREEN);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DrawView);
        if (typedArray == null){
            return;
        }
        currentX = typedArray.getFloat(R.styleable.DrawView_currentX,40f);
        currentY = typedArray.getFloat(R.styleable.DrawView_currentY,50f);
        radius = typedArray.getFloat(R.styleable.DrawView_radius,15f);
        typedArray.recycle();
        invalidate();
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        p.setColor(Color.RED);
        canvas.drawCircle(currentX,currentY,radius,p);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        currentX = event.getX();
        currentY = event.getY();
        invalidate();
        return  true;
    }
}
