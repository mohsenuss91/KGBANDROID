// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.a.a.b.a.l;
import com.a.a.b.c.b;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

final class aa extends l
{

    static final List a = Collections.synchronizedList(new LinkedList());

    public final void a(String s, View view, Bitmap bitmap)
    {
        if (bitmap != null)
        {
            ImageView imageview = (ImageView)view;
            if (imageview.getVisibility() == 0)
            {
                boolean flag;
                if (!a.contains(s))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    b.a(imageview, 500);
                    a.add(s);
                }
            }
        }
    }

}
