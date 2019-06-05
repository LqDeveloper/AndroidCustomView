package com.example.my_android_demo;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.my_android_demo.view.DrawView;


public class MainActivity extends AppCompatActivity{
     TextView mAddTextView;
     ConstraintLayout mLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLayout = findViewById(R.id.layout);
        mAddTextView = findViewById(R.id.addButton);
        mAddTextView.setOnClickListener((view)->{
            Log.d("MainActivity","点击了添加按钮");
        });


//        DrawView drawView = new DrawView(this);
//        drawView.setId(R.id.circle_view);
//        mLayout.addView(drawView);
//        ConstraintSet set = new ConstraintSet();
//        set.constrainWidth(drawView.getId(),ViewGroup.LayoutParams.MATCH_PARENT);
//        set.constrainHeight(drawView.getId(),500);
//        set.connect(drawView.getId(),ConstraintSet.START,ConstraintSet.PARENT_ID,ConstraintSet.START);
//        set.connect(drawView.getId(),ConstraintSet.RIGHT,ConstraintSet.PARENT_ID,ConstraintSet.RIGHT);
//        set.connect(drawView.getId(),ConstraintSet.TOP,mAddTextView.getId(),ConstraintSet.BOTTOM);
//        set.applyTo(mLayout);


    }

    public void addView(){
        TextView textView = new TextView(this);
        textView.setId(R.id.text_view_01);
        textView.setText("这是添加的TextView");
        textView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        textView.setGravity(Gravity.CENTER);
        mLayout.addView(textView);

        ConstraintSet set = new ConstraintSet();
        set.constrainWidth(textView.getId(),ViewGroup.LayoutParams.MATCH_PARENT);
        set.constrainHeight(textView.getId(),100);
        set.connect(textView.getId(),ConstraintSet.START,ConstraintSet.PARENT_ID,ConstraintSet.START);
        set.connect(textView.getId(),ConstraintSet.RIGHT,ConstraintSet.PARENT_ID,ConstraintSet.RIGHT);
        set.connect(textView.getId(),ConstraintSet.TOP,mAddTextView.getId(),ConstraintSet.BOTTOM);
        set.applyTo(mLayout);
    }

}
