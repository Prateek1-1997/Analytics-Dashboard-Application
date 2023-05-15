package com;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

/** Created by deep on 11/11/1 */
public class SmoothScrollLayoutManager extends LinearLayoutManager {
    public SmoothScrollLayoutManager(Context context) {
        super(context);
    }

    public SmoothScrollLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public SmoothScrollLayoutManager(
            Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void smoothScrollToPosition(
            RecyclerView recyclerView, RecyclerView.State state, int position) {
        RecyclerView.SmoothScroller smoothScroller =
                new TopSnappedSmoothScroller(recyclerView.getContext());
        smoothScroller.setTargetPosition(position);
        startSmoothScroll(smoothScroller);
    }

    private class TopSnappedSmoothScroller extends LinearSmoothScroller {
        public TopSnappedSmoothScroller(Context context) {
            super(context);
        }

        @Override
        protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return 70f / displayMetrics.densityDpi;
        }

        @Override
        public PointF computeScrollVectorForPosition(int targetPosition) {
            return SmoothScrollLayoutManager.this.computeScrollVectorForPosition(targetPosition);
        }

        @Override
        protected int getVerticalSnapPreference() {
            return SNAP_TO_START;
        }

        @Override
        protected int getHorizontalSnapPreference() {
            //            return super.getHorizontalSnapPreference();
            return SNAP_TO_START;
        }
    }
}
