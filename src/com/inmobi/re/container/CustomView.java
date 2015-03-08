// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

public class CustomView extends View
{

    private float a;
    private float b;
    private float c;
    private float d;
    private float e;
    private SwitchIconType f;
    private int g;
    private Paint h;
    private Path i;
    private RectF j;

    private CustomView(Context context)
    {
        super(context);
    }

    public CustomView(Context context, float f1, SwitchIconType switchicontype)
    {
        this(context);
        f = switchicontype;
        a = f1;
        g = 15;
        b = (50F * a) / 2.0F;
        c = (30F * a) / 2.0F;
        d = b - c / 3F;
        e = b + c / 3F;
        h = new Paint(1);
        j = new RectF();
        i = new Path();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        h.reset();
        switch (a.a[f.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            h.setAntiAlias(true);
            h.setColor(0xff000000);
            h.setStrokeWidth(3F);
            h.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
            canvas.drawCircle(b, b, c, h);
            h.setColor(-1);
            h.setStyle(android.graphics.Paint.Style.STROKE);
            canvas.drawLine(d, d, e, e, h);
            canvas.drawLine(d, e, e, d, h);
            canvas.drawCircle(b, b, c, h);
            return;

        case 2: // '\002'
            h.setAntiAlias(true);
            h.setColor(0);
            h.setStrokeWidth(3F);
            h.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
            canvas.drawCircle(b, b, b, h);
            return;

        case 3: // '\003'
            i.reset();
            i.setFillType(android.graphics.Path.FillType.EVEN_ODD);
            i.moveTo((float)(getWidth() / 2) - ((float)g * a) / 2.0F, (float)(getHeight() / 2) - ((float)g * a) / 2.0F);
            i.lineTo((float)(getWidth() / 2) + ((float)g * a) / 2.0F, getHeight() / 2);
            i.lineTo((float)(getWidth() / 2) - ((float)g * a) / 2.0F, (float)(getHeight() / 2) + ((float)g * a) / 2.0F);
            i.lineTo((float)(getWidth() / 2) - ((float)g * a) / 2.0F, (float)(getHeight() / 2) - ((float)g * a) / 2.0F);
            i.close();
            h.setAntiAlias(true);
            h.setColor(0xff000000);
            h.setStrokeWidth(3F);
            h.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
            canvas.drawPath(i, h);
            return;

        case 4: // '\004'
            i.reset();
            i.setFillType(android.graphics.Path.FillType.EVEN_ODD);
            i.moveTo((float)(getWidth() / 2) - ((float)g * a) / 2.0F, (float)(getHeight() / 2) - ((float)g * a) / 2.0F);
            i.lineTo((float)(getWidth() / 2) + ((float)g * a) / 2.0F, getHeight() / 2);
            i.lineTo((float)(getWidth() / 2) - ((float)g * a) / 2.0F, (float)(getHeight() / 2) + ((float)g * a) / 2.0F);
            i.lineTo((float)(getWidth() / 2) - ((float)g * a) / 2.0F, (float)(getHeight() / 2) - ((float)g * a) / 2.0F);
            i.close();
            h.setAntiAlias(true);
            h.setColor(0xff444444);
            h.setStrokeWidth(3F);
            h.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
            canvas.drawPath(i, h);
            return;

        case 5: // '\005'
            i.reset();
            i.setFillType(android.graphics.Path.FillType.EVEN_ODD);
            i.moveTo((float)(getWidth() / 2) - ((float)g * a) / 2.0F, getHeight() / 2);
            i.lineTo((float)(getWidth() / 2) + ((float)g * a) / 2.0F, (float)(getHeight() / 2) - ((float)g * a) / 2.0F);
            i.lineTo((float)(getWidth() / 2) + ((float)g * a) / 2.0F, (float)(getHeight() / 2) + ((float)g * a) / 2.0F);
            i.lineTo((float)(getWidth() / 2) - ((float)g * a) / 2.0F, getHeight() / 2);
            i.close();
            h.setAntiAlias(true);
            h.setColor(0xff000000);
            h.setStrokeWidth(3F);
            h.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
            canvas.drawPath(i, h);
            return;

        case 6: // '\006'
            i.reset();
            h.setAntiAlias(true);
            h.setColor(0xff000000);
            h.setStrokeWidth(5F);
            h.setStyle(android.graphics.Paint.Style.STROKE);
            j.set((float)(getWidth() / 2) - ((float)g * a) / 2.0F, (float)(getHeight() / 2) - ((float)g * a) / 2.0F, (float)(getWidth() / 2) + ((float)g * a) / 2.0F, (float)(getHeight() / 2) + ((float)g * a) / 2.0F);
            canvas.drawArc(j, 0.0F, 270F, false, h);
            i.setFillType(android.graphics.Path.FillType.EVEN_ODD);
            i.moveTo((float)(getWidth() / 2) + ((float)g * a) / 2.0F, (float)(getHeight() / 2) - 2.0F * a);
            i.lineTo(((float)(getWidth() / 2) + ((float)g * a) / 2.0F) - 2.0F * a, getHeight() / 2);
            i.lineTo((float)(getWidth() / 2) + ((float)g * a) / 2.0F + 2.0F * a, getHeight() / 2);
            i.lineTo((float)(getWidth() / 2) + ((float)g * a) / 2.0F, (float)(getHeight() / 2) - 2.0F * a);
            i.close();
            h.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
            canvas.drawPath(i, h);
            return;

        case 7: // '\007'
            h.setAntiAlias(true);
            break;
        }
        h.setColor(0xff000000);
        h.setStrokeWidth(5F);
        h.setStyle(android.graphics.Paint.Style.STROKE);
        canvas.drawLine((float)(getWidth() / 2) - ((float)g * a) / 2.0F, (float)(getHeight() / 2) - ((float)g * a) / 2.0F, (float)(getWidth() / 2) + ((float)g * a) / 2.0F, (float)(getHeight() / 2) + ((float)g * a) / 2.0F, h);
        canvas.drawLine((float)(getWidth() / 2) - ((float)g * a) / 2.0F, (float)(getHeight() / 2) + ((float)g * a) / 2.0F, (float)(getWidth() / 2) + ((float)g * a) / 2.0F, (float)(getHeight() / 2) - ((float)g * a) / 2.0F, h);
    }

    public void setSwitchInt(SwitchIconType switchicontype)
    {
        f = switchicontype;
    }

    private class a
    {

        static final int a[];

        static 
        {
            a = new int[SwitchIconType.values().length];
            try
            {
                a[SwitchIconType.CLOSE_BUTTON.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror) { }
            try
            {
                a[SwitchIconType.CLOSE_TRANSPARENT.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                a[SwitchIconType.FORWARD_ACTIVE.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                a[SwitchIconType.FORWARD_INACTIVE.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                a[SwitchIconType.BACK.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                a[SwitchIconType.REFRESH.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                a[SwitchIconType.CLOSE_ICON.ordinal()] = 7;
            }
            catch (NoSuchFieldError nosuchfielderror6)
            {
                return;
            }
        }
    }


    private class SwitchIconType extends Enum
    {

        public static final SwitchIconType BACK;
        public static final SwitchIconType CLOSE_BUTTON;
        public static final SwitchIconType CLOSE_ICON;
        public static final SwitchIconType CLOSE_TRANSPARENT;
        public static final SwitchIconType FORWARD_ACTIVE;
        public static final SwitchIconType FORWARD_INACTIVE;
        public static final SwitchIconType REFRESH;
        private static final SwitchIconType a[];

        public static SwitchIconType valueOf(String s)
        {
            return (SwitchIconType)Enum.valueOf(com/inmobi/re/container/CustomView$SwitchIconType, s);
        }

        public static SwitchIconType[] values()
        {
            return (SwitchIconType[])a.clone();
        }

        static 
        {
            CLOSE_BUTTON = new SwitchIconType("CLOSE_BUTTON", 0);
            CLOSE_TRANSPARENT = new SwitchIconType("CLOSE_TRANSPARENT", 1);
            CLOSE_ICON = new SwitchIconType("CLOSE_ICON", 2);
            REFRESH = new SwitchIconType("REFRESH", 3);
            BACK = new SwitchIconType("BACK", 4);
            FORWARD_ACTIVE = new SwitchIconType("FORWARD_ACTIVE", 5);
            FORWARD_INACTIVE = new SwitchIconType("FORWARD_INACTIVE", 6);
            SwitchIconType aswitchicontype[] = new SwitchIconType[7];
            aswitchicontype[0] = CLOSE_BUTTON;
            aswitchicontype[1] = CLOSE_TRANSPARENT;
            aswitchicontype[2] = CLOSE_ICON;
            aswitchicontype[3] = REFRESH;
            aswitchicontype[4] = BACK;
            aswitchicontype[5] = FORWARD_ACTIVE;
            aswitchicontype[6] = FORWARD_INACTIVE;
            a = aswitchicontype;
        }

        private SwitchIconType(String s, int k)
        {
            super(s, k);
        }
    }

}
