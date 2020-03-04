package com.xcm.myappdemo;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * 描述：
 * 时间： 2020/3/4.
 * 创建： 张继良
 */
public class UIHelper {

    public static final String TAG = "CoverViewActivity";

    public boolean isViewCovered(final View view) {
        View currentView = view;

        Rect currentViewRect = new Rect();
        boolean partVisible = currentView.getGlobalVisibleRect(currentViewRect);
        boolean totalHeightVisible = (currentViewRect.bottom - currentViewRect.top) >= view.getMeasuredHeight();
        boolean totalWidthVisible = (currentViewRect.right - currentViewRect.left) >= view.getMeasuredWidth();
        boolean totalViewVisible = partVisible && totalHeightVisible && totalWidthVisible;
        if (!totalViewVisible)//if any part of the view is clipped by any of its parents,return true
            return true;

        while (currentView.getParent() instanceof ViewGroup) {
            ViewGroup currentParent = (ViewGroup) currentView.getParent();
            if (currentParent.getVisibility() != View.VISIBLE)//if the parent of view is not visible,return true
                return true;

            int start = indexOfViewInParent(currentView, currentParent);
            Log.i(TAG, "isViewCovered(UIHelper.java:40)          viewRect       " + currentViewRect.toString());
            for (int i = start + 1; i < currentParent.getChildCount(); i++) {
                Rect viewRect = new Rect();
                view.getGlobalVisibleRect(viewRect);
                View otherView = currentParent.getChildAt(i);
                Rect otherViewRect = new Rect();
                otherView.getGlobalVisibleRect(otherViewRect);


                if (Rect.intersects(viewRect, otherViewRect))//if view intersects its older brother(covered),return true
                    return true;
                else {
                    Log.i(TAG, "isViewCovered(UIHelper.java:40)      otherViewRect      " + otherViewRect.toString());
                }
            }
            currentView = currentParent;
        }
        return false;
    }

    public boolean isShown(View adView) {

        if (adView == null) {
            return false;
        }

        boolean isVisible = (adView.getVisibility() == View.VISIBLE);
        boolean isShown = adView.isShown();
        boolean isVisibleRect = adView.getGlobalVisibleRect(new Rect());

        if (isVisible && isShown && isVisibleRect) {

        } else {
            return false;
        }

        while (adView.getParent() instanceof ViewGroup) {
            return isShown((ViewGroup) adView.getParent());
        }

        return true;
    }

    private int indexOfViewInParent(View view, ViewGroup parent) {
        int index;
        for (index = 0; index < parent.getChildCount(); index++) {
            if (parent.getChildAt(index) == view)
                break;
        }
        return index;
    }
}
