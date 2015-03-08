// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TabWidget;
import android.widget.TextView;

public class BadgeView extends TextView
{

    private static final int DEFAULT_BADGE_COLOR = 0;
    private static final int DEFAULT_CORNER_RADIUS_DIP = 8;
    private static final int DEFAULT_LR_PADDING_DIP = 5;
    private static final int DEFAULT_MARGIN_DIP = 5;
    private static final int DEFAULT_POSITION = 2;
    private static final int DEFAULT_TEXT_COLOR = -1;
    public static final int POSITION_BOTTOM_LEFT = 3;
    public static final int POSITION_BOTTOM_RIGHT = 4;
    public static final int POSITION_CENTER = 5;
    public static final int POSITION_CENTER_LEFT = 6;
    public static final int POSITION_CENTER_RIGHT = 7;
    public static final int POSITION_TOP_LEFT = 1;
    public static final int POSITION_TOP_RIGHT = 2;
    private static Animation fadeIn;
    private static Animation fadeOut;
    private ShapeDrawable badgeBg;
    private int badgeColor;
    private int badgeMarginH;
    private int badgeMarginV;
    private int badgePosition;
    private Context context;
    private boolean isShown;
    private View target;
    private int targetTabIndex;

    public BadgeView(Context context1)
    {
        this(context1, ((AttributeSet) (null)), 0x1010084);
    }

    public BadgeView(Context context1, AttributeSet attributeset)
    {
        this(context1, attributeset, 0x1010084);
    }

    public BadgeView(Context context1, AttributeSet attributeset, int i)
    {
        this(context1, attributeset, i, null, 0);
    }

    public BadgeView(Context context1, AttributeSet attributeset, int i, View view, int j)
    {
        super(context1, attributeset, i);
        init(context1, view, j);
    }

    public BadgeView(Context context1, View view)
    {
        this(context1, null, 0x1010084, view, 0);
    }

    public BadgeView(Context context1, TabWidget tabwidget, int i)
    {
        this(context1, null, 0x1010084, ((View) (tabwidget)), i);
    }

    private void applyLayoutParams()
    {
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-2, -2);
        badgePosition;
        JVM INSTR tableswitch 1 7: default 60
    //                   1 66
    //                   2 89
    //                   3 112
    //                   4 135
    //                   5 158
    //                   6 175
    //                   7 192;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        setLayoutParams(layoutparams);
        return;
_L2:
        layoutparams.gravity = 51;
        layoutparams.setMargins(badgeMarginH, badgeMarginV, 0, 0);
        continue; /* Loop/switch isn't completed */
_L3:
        layoutparams.gravity = 53;
        layoutparams.setMargins(0, badgeMarginV, badgeMarginH, 0);
        continue; /* Loop/switch isn't completed */
_L4:
        layoutparams.gravity = 83;
        layoutparams.setMargins(badgeMarginH, 0, 0, badgeMarginV);
        continue; /* Loop/switch isn't completed */
_L5:
        layoutparams.gravity = 85;
        layoutparams.setMargins(0, 0, badgeMarginH, badgeMarginV);
        continue; /* Loop/switch isn't completed */
_L6:
        layoutparams.gravity = 17;
        layoutparams.setMargins(0, 0, 0, 0);
        continue; /* Loop/switch isn't completed */
_L7:
        layoutparams.gravity = 19;
        layoutparams.setMargins(0, 0, 0, 0);
        continue; /* Loop/switch isn't completed */
_L8:
        layoutparams.gravity = 21;
        layoutparams.setMargins(0, 0, 0, 0);
        if (true) goto _L1; else goto _L9
_L9:
    }

    private void applyTo(View view)
    {
        android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
        android.view.ViewParent viewparent = view.getParent();
        FrameLayout framelayout = new FrameLayout(context);
        if (view instanceof TabWidget)
        {
            View view1 = ((TabWidget)view).getChildTabViewAt(targetTabIndex);
            target = view1;
            ((ViewGroup)view1).addView(framelayout, new android.view.ViewGroup.LayoutParams(-1, -1));
            setVisibility(8);
            framelayout.addView(this);
            return;
        } else
        {
            ViewGroup viewgroup = (ViewGroup)viewparent;
            int i = viewgroup.indexOfChild(view);
            viewgroup.removeView(view);
            viewgroup.addView(framelayout, i, layoutparams);
            framelayout.addView(view);
            setVisibility(8);
            framelayout.addView(this);
            viewgroup.invalidate();
            return;
        }
    }

    private int dipToPixels(int i)
    {
        Resources resources = getResources();
        return (int)TypedValue.applyDimension(1, i, resources.getDisplayMetrics());
    }

    private ShapeDrawable getDefaultBackground()
    {
        int i = dipToPixels(8);
        float af[] = new float[8];
        af[0] = i;
        af[1] = i;
        af[2] = i;
        af[3] = i;
        af[4] = i;
        af[5] = i;
        af[6] = i;
        af[7] = i;
        ShapeDrawable shapedrawable = new ShapeDrawable(new RoundRectShape(af, null, null));
        shapedrawable.getPaint().setColor(badgeColor);
        return shapedrawable;
    }

    private void hide(boolean flag, Animation animation)
    {
        setVisibility(8);
        if (flag)
        {
            startAnimation(animation);
        }
        isShown = false;
    }

    private void init(Context context1, View view, int i)
    {
        context = context1;
        target = view;
        targetTabIndex = i;
        badgePosition = 2;
        badgeMarginH = dipToPixels(5);
        badgeMarginV = badgeMarginH;
        badgeColor = DEFAULT_BADGE_COLOR;
        setTypeface(Typeface.DEFAULT_BOLD);
        int j = dipToPixels(5);
        setPadding(j, 0, j, 0);
        setTextColor(-1);
        AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
        fadeIn = alphaanimation;
        alphaanimation.setInterpolator(new DecelerateInterpolator());
        fadeIn.setDuration(200L);
        AlphaAnimation alphaanimation1 = new AlphaAnimation(1.0F, 0.0F);
        fadeOut = alphaanimation1;
        alphaanimation1.setInterpolator(new AccelerateInterpolator());
        fadeOut.setDuration(200L);
        isShown = false;
        if (target != null)
        {
            applyTo(target);
            return;
        } else
        {
            show();
            return;
        }
    }

    private void show(boolean flag, Animation animation)
    {
        if (getBackground() == null)
        {
            if (badgeBg == null)
            {
                badgeBg = getDefaultBackground();
            }
            setBackgroundDrawable(badgeBg);
        }
        applyLayoutParams();
        if (flag)
        {
            startAnimation(animation);
        }
        setVisibility(0);
        isShown = true;
    }

    private void toggle(boolean flag, Animation animation, Animation animation1)
    {
        boolean flag1 = true;
        if (isShown)
        {
            if (!flag || animation1 == null)
            {
                flag1 = false;
            }
            hide(flag1, animation1);
            return;
        }
        if (!flag || animation == null)
        {
            flag1 = false;
        }
        show(flag1, animation);
    }

    public int decrement(int i)
    {
        return increment(-i);
    }

    public int getBadgeBackgroundColor()
    {
        return badgeColor;
    }

    public int getBadgePosition()
    {
        return badgePosition;
    }

    public int getHorizontalBadgeMargin()
    {
        return badgeMarginH;
    }

    public View getTarget()
    {
        return target;
    }

    public int getVerticalBadgeMargin()
    {
        return badgeMarginV;
    }

    public void hide()
    {
        hide(false, null);
    }

    public void hide(Animation animation)
    {
        hide(true, animation);
    }

    public void hide(boolean flag)
    {
        hide(flag, fadeOut);
    }

    public int increment(int i)
    {
        CharSequence charsequence = getText();
        if (charsequence == null) goto _L2; else goto _L1
_L1:
        int l = Integer.parseInt(charsequence.toString());
        int j = l;
_L4:
        int k = j + i;
        setText(String.valueOf(k));
        return k;
        NumberFormatException numberformatexception;
        numberformatexception;
_L2:
        j = 0;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean isShown()
    {
        return isShown;
    }

    public void setBadgeBackgroundColor(int i)
    {
        badgeColor = i;
        badgeBg = getDefaultBackground();
    }

    public void setBadgeMargin(int i)
    {
        badgeMarginH = i;
        badgeMarginV = i;
    }

    public void setBadgeMargin(int i, int j)
    {
        badgeMarginH = i;
        badgeMarginV = j;
    }

    public void setBadgePosition(int i)
    {
        badgePosition = i;
    }

    public void show()
    {
        show(false, null);
    }

    public void show(Animation animation)
    {
        show(true, animation);
    }

    public void show(boolean flag)
    {
        show(flag, fadeIn);
    }

    public void toggle()
    {
        toggle(false, null, null);
    }

    public void toggle(Animation animation, Animation animation1)
    {
        toggle(true, animation, animation1);
    }

    public void toggle(boolean flag)
    {
        toggle(flag, fadeIn, fadeOut);
    }

    static 
    {
        DEFAULT_BADGE_COLOR = Color.parseColor("#CCFF0000");
    }
}
