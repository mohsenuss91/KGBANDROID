// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.simonvt.menudrawer.a;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

public final class c
{

    public ImageView a;
    public Object b;
    public Method c;

    c(Activity activity)
    {
        String s;
        Class class1;
        Class aclass[];
        try
        {
            s = activity.getPackageName();
        }
        catch (Throwable throwable)
        {
            return;
        }
        try
        {
            a = (ImageView)((ViewGroup)activity.findViewById(activity.getResources().getIdentifier("abs__home", "id", s)).getParent()).findViewById(activity.getResources().getIdentifier("abs__up", "id", s));
        }
        catch (Throwable throwable1) { }
        if (a == null)
        {
            a = (ImageView)((ViewGroup)activity.findViewById(activity.getResources().getIdentifier("home", "id", s)).getParent()).findViewById(activity.getResources().getIdentifier("up", "id", s));
        }
        b = activity.getClass().getMethod("getSupportActionBar", new Class[0]).invoke(activity, null);
        class1 = b.getClass();
        aclass = new Class[1];
        aclass[0] = Boolean.TYPE;
        c = class1.getMethod("setDisplayHomeAsUpEnabled", aclass);
        return;
    }
}
