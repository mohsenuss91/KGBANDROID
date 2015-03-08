// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container;


// Referenced classes of package com.inmobi.re.container:
//            IMWebView

class a
    implements Runnable
{

    final String a;
    final IMWebView b;

    public void run()
    {
        b.injectJavaScript(a);
    }

    (IMWebView imwebview, String s)
    {
        b = imwebview;
        a = s;
        super();
    }
}
