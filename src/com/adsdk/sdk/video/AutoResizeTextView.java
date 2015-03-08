// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import android.content.Context;
import android.graphics.Canvas;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

public class AutoResizeTextView extends TextView
{

    public static final float MIN_TEXT_SIZE = 20F;
    private static final String mEllipsis = "...";
    private static final Canvas sTextResizeCanvas = new Canvas();
    private boolean mAddEllipsis;
    private float mMaxTextSize;
    private float mMinTextSize;
    private boolean mNeedsResize;
    private float mSpacingAdd;
    private float mSpacingMult;
    private OnTextResizeListener mTextResizeListener;
    private float mTextSize;

    public AutoResizeTextView(Context context)
    {
        this(context, null);
    }

    public AutoResizeTextView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public AutoResizeTextView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mNeedsResize = false;
        mMaxTextSize = 0.0F;
        mMinTextSize = 20F;
        mSpacingMult = 1.0F;
        mSpacingAdd = 0.0F;
        mAddEllipsis = true;
        mTextSize = getTextSize();
    }

    private int getTextHeight(CharSequence charsequence, TextPaint textpaint, int i, float f)
    {
        textpaint.setTextSize(f);
        StaticLayout staticlayout = new StaticLayout(charsequence, textpaint, i, android.text.Layout.Alignment.ALIGN_NORMAL, mSpacingMult, mSpacingAdd, true);
        staticlayout.draw(sTextResizeCanvas);
        return staticlayout.getHeight();
    }

    public boolean getAddEllipsis()
    {
        return mAddEllipsis;
    }

    public float getMaxTextSize()
    {
        return mMaxTextSize;
    }

    public float getMinTextSize()
    {
        return mMinTextSize;
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        if (flag || mNeedsResize)
        {
            resizeText(k - i - getCompoundPaddingLeft() - getCompoundPaddingRight(), l - j - getCompoundPaddingBottom() - getCompoundPaddingTop());
        }
        super.onLayout(flag, i, j, k, l);
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        if (i != k || j != l)
        {
            mNeedsResize = true;
        }
    }

    protected void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        mNeedsResize = true;
        resetTextSize();
    }

    public void resetTextSize()
    {
        super.setTextSize(0, mTextSize);
        mMaxTextSize = mTextSize;
    }

    public void resizeText()
    {
        int i = getHeight() - getPaddingBottom() - getPaddingTop();
        resizeText(getWidth() - getPaddingLeft() - getPaddingRight(), i);
    }

    public void resizeText(int i, int j)
    {
        CharSequence charsequence;
        TextPaint textpaint;
        float f2;
        int l;
        StaticLayout staticlayout;
        int i1;
        charsequence = getText();
        if (charsequence == null || charsequence.length() == 0 || j <= 0 || i <= 0 || mTextSize == 0.0F)
        {
            return;
        }
        textpaint = getPaint();
        float f = textpaint.getTextSize();
        float f1;
        int k;
        if (mMaxTextSize > 0.0F)
        {
            f1 = Math.min(mTextSize, mMaxTextSize);
        } else
        {
            f1 = mTextSize;
        }
        k = getTextHeight(charsequence, textpaint, i, f1);
        f2 = f1;
        l = k;
_L8:
        if (l > j && f2 > mMinTextSize) goto _L2; else goto _L1
_L1:
        if (!mAddEllipsis || f2 != mMinTextSize || l <= j) goto _L4; else goto _L3
_L3:
        staticlayout = new StaticLayout(charsequence, textpaint, i, android.text.Layout.Alignment.ALIGN_NORMAL, mSpacingMult, mSpacingAdd, false);
        staticlayout.draw(sTextResizeCanvas);
        if (staticlayout.getLineCount() <= 0) goto _L4; else goto _L5
_L5:
        i1 = -1 + staticlayout.getLineForVertical(j);
        if (i1 >= 0) goto _L7; else goto _L6
_L6:
        setText("");
_L4:
        textpaint.setTextSize(f2);
        setLineSpacing(mSpacingAdd, mSpacingMult);
        if (mTextResizeListener != null)
        {
            mTextResizeListener.onTextResize(this, f, f2);
        }
        mNeedsResize = false;
        return;
_L2:
        float f6 = Math.max(f2 - 2.0F, mMinTextSize);
        l = getTextHeight(charsequence, textpaint, i, f6);
        f2 = f6;
          goto _L8
_L7:
        int j1;
        float f4;
        float f5;
        int l1;
        j1 = staticlayout.getLineStart(i1);
        int k1 = staticlayout.getLineEnd(i1);
        float f3 = staticlayout.getLineWidth(i1);
        f4 = textpaint.measureText("...");
        f5 = f3;
        l1 = k1;
_L9:
label0:
        {
            if ((float)i < f5 + f4)
            {
                break label0;
            }
            setText((new StringBuilder()).append(charsequence.subSequence(0, l1)).append("...").toString());
        }
          goto _L4
        l1--;
        f5 = textpaint.measureText(charsequence.subSequence(j1, l1 + 1).toString());
          goto _L9
    }

    public void setAddEllipsis(boolean flag)
    {
        mAddEllipsis = flag;
    }

    public void setLineSpacing(float f, float f1)
    {
        super.setLineSpacing(f, f1);
        mSpacingMult = f1;
        mSpacingAdd = f;
    }

    public void setMaxTextSize(float f)
    {
        mMaxTextSize = f;
        requestLayout();
        invalidate();
    }

    public void setMinTextSize(float f)
    {
        mMinTextSize = f;
        requestLayout();
        invalidate();
    }

    public void setOnResizeListener(OnTextResizeListener ontextresizelistener)
    {
        mTextResizeListener = ontextresizelistener;
    }

    public void setTextSize(float f)
    {
        super.setTextSize(f);
        mTextSize = getTextSize();
    }

    public void setTextSize(int i, float f)
    {
        super.setTextSize(i, f);
        mTextSize = getTextSize();
    }


    private class OnTextResizeListener
    {

        public abstract void onTextResize(TextView textview, float f, float f1);
    }

}
