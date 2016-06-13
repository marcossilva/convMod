package com.loyola.talktracer.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Marcos on 08/06/16.
 */
public class TimeDomainView extends View {
    private int _maxLimit;
    private ArrayList<TimeBar> _bars = new ArrayList<>();
    private Paint _paint = new Paint();
    public TimeDomainView(Context context) {
        this(context, null);
    }

    public TimeDomainView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TimeDomainView(Context context, AttributeSet attrs) {
        //super(context, attrs);
        this(context, attrs, 0);
    }

    public TimeDomainView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public int getTimeLimit(){
        return _maxLimit;
    }

    public boolean setTimeLimit(int newLimit){
        if (newLimit > _maxLimit){
            this._maxLimit = newLimit;
            return true;
        }
        return false;
    }

}
