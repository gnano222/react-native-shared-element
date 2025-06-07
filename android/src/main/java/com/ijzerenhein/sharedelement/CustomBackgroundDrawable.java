package com.ijzerenhein.sharedelement;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class CustomBackgroundDrawable extends Drawable {
    private final Paint mPaint;
    private final RectF mRectF;
    private float mBorderWidth;
    private int mBorderColor;
    private float[] mRadii;
    private String mBorderStyle;

    public CustomBackgroundDrawable(Context context) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mRectF = new RectF();
        mRadii = new float[8];
    }

    public void setColor(int color) {
        mPaint.setColor(color);
        invalidateSelf();
    }

    public void setBorderWidth(float borderWidth) {
        mBorderWidth = borderWidth;
        invalidateSelf();
    }

    public void setBorderColor(int borderColor) {
        mBorderColor = borderColor;
        invalidateSelf();
    }

    public void setRadii(float[] radii) {
        mRadii = radii;
        invalidateSelf();
    }

    public void setBorderStyle(String borderStyle) {
        mBorderStyle = borderStyle;
        invalidateSelf();
    }

    public void setBorderWidth(int index, float borderWidth) {
        // Implement logic to handle border width for each side if needed
        mBorderWidth = borderWidth;
        invalidateSelf();
    }

    public void setRadius(float radius) {
        // Implement logic to handle radius for each corner if needed
        for (int i = 0; i < mRadii.length; i++) {
            mRadii[i] = radius;
        }
        invalidateSelf();
    }

    public void setTopLeftRadius(float radius) {
        mRadii[0] = radius;
        mRadii[1] = radius;
        invalidateSelf();
    }

    public void setTopRightRadius(float radius) {
        mRadii[2] = radius;
        mRadii[3] = radius;
        invalidateSelf();
    }

    public void setBottomRightRadius(float radius) {
        mRadii[4] = radius;
        mRadii[5] = radius;
        invalidateSelf();
    }

    public void setBottomLeftRadius(float radius) {
        mRadii[6] = radius;
        mRadii[7] = radius;
        invalidateSelf();
    }

    @Override
    public void draw(Canvas canvas) {
        mRectF.set(getBounds());
        canvas.drawRoundRect(mRectF, mRadii[0], mRadii[1], mPaint);
        if (mBorderWidth > 0) {
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setStrokeWidth(mBorderWidth);
            mPaint.setColor(mBorderColor);
            canvas.drawRoundRect(mRectF, mRadii[0], mRadii[1], mPaint);
        }
    }

    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
        invalidateSelf();
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
