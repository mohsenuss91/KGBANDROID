// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.internal.gu;
import com.google.android.gms.internal.gv;
import com.google.android.gms.internal.gx;
import com.google.android.gms.internal.gy;

public abstract class a
{

    final a Fj;
    protected int Fk;
    protected int Fl;
    private boolean Fm;
    private boolean Fn;
    protected int Fo;

    public com.google.android.gms.common.images.a(Uri uri, int i)
    {
        Fk = 0;
        Fl = 0;
        Fm = true;
        Fn = false;
        Fj = new a(uri);
        Fl = i;
    }

    private Drawable a(Context context, gx gx1, int i)
    {
        Resources resources = context.getResources();
        if (Fo > 0)
        {
            com.google.android.gms.internal.gx.a a1 = new com.google.android.gms.internal.gx.a(i, Fo);
            Drawable drawable = (Drawable)gx1.get(a1);
            if (drawable == null)
            {
                drawable = resources.getDrawable(i);
                if ((1 & Fo) != 0)
                {
                    drawable = a(resources, drawable);
                }
                gx1.put(a1, drawable);
            }
            return drawable;
        } else
        {
            return resources.getDrawable(i);
        }
    }

    protected Drawable a(Resources resources, Drawable drawable)
    {
        return gv.a(resources, drawable);
    }

    protected gu a(Drawable drawable, Drawable drawable1)
    {
        if (drawable != null)
        {
            if (drawable instanceof gu)
            {
                drawable = ((gu)drawable).fb();
            }
        } else
        {
            drawable = null;
        }
        return new gu(drawable, drawable1);
    }

    void a(Context context, Bitmap bitmap, boolean flag)
    {
        gy.c(bitmap);
        if ((1 & Fo) != 0)
        {
            bitmap = gv.a(bitmap);
        }
        a(((Drawable) (new BitmapDrawable(context.getResources(), bitmap))), flag, false, true);
    }

    void a(Context context, gx gx1)
    {
        int i = Fk;
        Drawable drawable = null;
        if (i != 0)
        {
            drawable = a(context, gx1, Fk);
        }
        a(drawable, false, true, false);
    }

    void a(Context context, gx gx1, boolean flag)
    {
        int i = Fl;
        Drawable drawable = null;
        if (i != 0)
        {
            drawable = a(context, gx1, Fl);
        }
        a(drawable, flag, false, false);
    }

    protected abstract void a(Drawable drawable, boolean flag, boolean flag1, boolean flag2);

    public void aj(int i)
    {
        Fl = i;
    }

    protected boolean b(boolean flag, boolean flag1)
    {
        return Fm && !flag1 && (!flag || Fn);
    }

    private class a
    {

        public final Uri uri;

        public final boolean equals(Object obj)
        {
            if (!(obj instanceof a))
            {
                return false;
            }
            if (this == obj)
            {
                return true;
            } else
            {
                return hl.equal(((a)obj).uri, uri);
            }
        }

        public final int hashCode()
        {
            Object aobj[] = new Object[1];
            aobj[0] = uri;
            return hl.hashCode(aobj);
        }

        public a(Uri uri1)
        {
            uri = uri1;
        }
    }

}
