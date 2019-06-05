package com.example.my_android_demo.view;

import android.content.Context;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.my_android_demo.R;


public class MyView extends LinearLayout {

    private TextView mTextView1;
    private TextView mTextVIew2;


    private String titleText;
    private int textColor;


    public MyView(Context context) {
        this(context, null);

    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        this(context,attrs,0);

    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.my_view_layout, this, true);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyView);
        titleText = typedArray.getString(R.styleable.MyView_titleText);
        textColor = typedArray.getColor(R.styleable.MyView_textColor, Color.RED);
        typedArray.recycle();
    }

    public void setText(String text) {
        mTextView1.setText(text);
        mTextVIew2.setText(text);
    }

    public void setColor(int color) {
        mTextView1.setTextColor(color);
        mTextVIew2.setTextColor(color);
    }

    public void setOnClick(View.OnClickListener listener) {
         mTextView1.setOnClickListener(listener);
    }

    /*当应用从XML布局文件加载该组件并利用它来构建界面之后，该方法会被回调*/
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mTextView1 = findViewById(R.id.text1);
        mTextVIew2 = findViewById(R.id.text2);
        setText(titleText);
        setColor(textColor);
    }

    /*改方法用来检测View组件及其所包含的所有子组件的大小*/
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d("MyView", "width:" + widthMeasureSpec + " height:" + heightMeasureSpec);
    }

    /*当该组件需要分配其子组件的位置，大小时，该方法会被调用*/
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
       super.onLayout(changed,l,t,r,b);
    }

    /*当某个按键被按下时调用这个方法*/
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }

    /*当松开某个按键调用改方法*/
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return super.onKeyUp(keyCode, event);
    }

    /*当发生轨迹球是触发改方法*/
    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        return super.onTrackballEvent(event);
    }

    /*当发生触摸屏幕是触发改方法*/
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    /*当把给组件放入某个窗口时调用改方法*/
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d("MyView", "onAttachedToWindow");
    }

    /*当把该组件从某个窗口分离时调用改方法*/
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.d("MyView", "onDetachedFromWindow");
    }

    /*当包含该组件的窗口的可见性发生改变是调用改方法*/
    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
    }
}
