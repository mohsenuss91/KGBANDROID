// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.photoview;

import android.content.Context;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

// Referenced classes of package uk.co.senab.photoview:
//            b, g, h, i

public class PhotoView extends ImageView
{

    private final b a;
    private android.widget.ImageView.ScaleType b;

    public PhotoView(Context context)
    {
        this(context, null);
    }

    public PhotoView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public PhotoView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        super.setScaleType(android.widget.ImageView.ScaleType.MATRIX);
        a = new b(this);
        if (b != null)
        {
            setScaleType(b);
            b = null;
        }
    }

    public RectF getDisplayRect()
    {
        return a.b();
    }

    public float getMaxScale()
    {
        return a.f();
    }

    public float getMidScale()
    {
        return a.e();
    }

    public float getMinScale()
    {
        return a.d();
    }

    public float getScale()
    {
        return a.g();
    }

    public android.widget.ImageView.ScaleType getScaleType()
    {
        return a.h();
    }

    protected void onDetachedFromWindow()
    {
        a.a();
        super.onDetachedFromWindow();
    }

    public void setAllowParentInterceptOnEdge(boolean flag)
    {
        a.a(flag);
    }

    public void setImageDrawable(Drawable drawable)
    {
        super.setImageDrawable(drawable);
        if (a != null)
        {
            a.i();
        }
    }

    public void setImageResource(int i)
    {
        super.setImageResource(i);
        if (a != null)
        {
            a.i();
        }
    }

    public void setImageURI(Uri uri)
    {
        super.setImageURI(uri);
        if (a != null)
        {
            a.i();
        }
    }

    public void setMaxScale(float f)
    {
        a.c(f);
    }

    public void setMidScale(float f)
    {
        a.b(f);
    }

    public void setMinScale(float f)
    {
        a.a(f);
    }

    public void setOnLongClickListener(android.view.View.OnLongClickListener onlongclicklistener)
    {
        a.a(onlongclicklistener);
    }

    public void setOnMatrixChangeListener(g g)
    {
        a.a(g);
    }

    public void setOnPhotoTapListener(h h)
    {
        a.a(h);
    }

    public void setOnViewTapListener(i i)
    {
        a.a(i);
    }

    public void setScaleType(android.widget.ImageView.ScaleType scaletype)
    {
        if (a != null)
        {
            a.a(scaletype);
            return;
        } else
        {
            b = scaletype;
            return;
        }
    }

    public void setZoomable(boolean flag)
    {
        a.b(flag);
    }
}
