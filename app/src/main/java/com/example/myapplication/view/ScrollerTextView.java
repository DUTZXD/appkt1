package com.example.myapplication.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Scroller;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class ScrollerTextView extends AppCompatTextView {

    private Scroller mScroller;

    public ScrollerTextView(Context context) {
        super(context);
        init();
    }

    public ScrollerTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ScrollerTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mScroller = new Scroller(getContext());
    }

    public void smoothScrollTo(int destX, int destY) {
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int deltaX = destX - scrollX;
        int deltaY = destY - scrollY;
        mScroller.startScroll(scrollX, scrollY, deltaX, deltaY, 2000);
        invalidate();
    }

    public void smoothScrollBy(int deltaX, int deltaY) {
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        mScroller.startScroll(scrollX, scrollY, deltaX, deltaY, 2000);
        invalidate();
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
    }

}
