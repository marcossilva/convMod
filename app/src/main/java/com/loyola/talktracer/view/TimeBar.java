package com.loyola.talktracer.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.loyola.blabbertabber.R;

/**
 * Created by Marcos on 08/06/16.
 */
public class TimeBar extends View{
    private boolean mVisible = true;
    private int mColor = Color.GREEN;
    private RectF mRectF;
    private Paint mPaint;
    private long mStartTime;
    private long mFinishTime;

    public TimeBar(Context context) {
        super(context);
        init();
    }

    public TimeBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.TimeBar,
                0, 0);

        try {
            mColor = a.getColor(R.styleable.TimeBar_fillColor, Color.GREEN);
            mStartTime = a.getInteger(R.styleable.TimeBar_start, 0);
            mFinishTime = a.getInteger(R.styleable.TimeBar_end, 100);
        } finally {
            a.recycle();
        }
    }

    public TimeBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        this.mRectF = new RectF();
        this.mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public void setColor(int color) {
        mColor = color;
        invalidate();
        requestLayout();
    }

    public void setVisible(boolean visible) {
        mVisible = visible;
    }

    public boolean isVisible() {
        return mVisible;
    }

    public long getFinishTime() {
        return mFinishTime;
    }

    public void setFinishTime(long mFinishTime) {
        this.mFinishTime = mFinishTime;
        invalidate();
        requestLayout();
    }

    public long getStartTime() {
        return mStartTime;
    }

    public void setStartTime(long mStartTime) {
        this.mStartTime = mStartTime;
        invalidate();
        requestLayout();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mVisible) {
            mRectF.left = 0;
            mRectF.top = 0;
            mRectF.right = getRight();
            mRectF.bottom = getHeight();
            Log.i("DIMENSIONS", "getWidth() " + getWidth() + " getLeft() " + getLeft() + " rect.right " + mRectF.right + " bottom " + mRectF.bottom);
            mPaint.setColor(mColor);
            mPaint.setStrokeWidth(1);
            canvas.drawRect(mRectF, mPaint);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }


}
