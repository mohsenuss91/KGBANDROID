// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container;

import android.view.View;
import android.widget.VideoView;

// Referenced classes of package com.inmobi.re.container:
//            a, IMWebView

class a
    implements android.view..OnFocusChangeListener
{

    final a a;

    public void onFocusChange(View view, boolean flag)
    {
        IMWebView.j(a.a).requestFocus();
    }

    bView(a a1)
    {
        a = a1;
        super();
    }
}
