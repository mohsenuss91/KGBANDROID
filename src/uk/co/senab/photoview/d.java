// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.photoview;


final class d
{

    static final int a[];

    static 
    {
        a = new int[android.widget.ImageView.ScaleType.values().length];
        try
        {
            a[android.widget.ImageView.ScaleType.MATRIX.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        try
        {
            a[android.widget.ImageView.ScaleType.FIT_START.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[android.widget.ImageView.ScaleType.FIT_END.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[android.widget.ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[android.widget.ImageView.ScaleType.FIT_XY.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror4)
        {
            return;
        }
    }
}
