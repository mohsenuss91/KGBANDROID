// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c.a;

import android.content.res.Resources;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.appyet.a.a.c;
import com.appyet.a.a.e;
import com.appyet.context.ApplicationContext;
import com.appyet.context.g;
import com.appyet.d.d;
import com.appyet.f.a;
import com.appyet.manager.an;
import com.appyet.manager.bp;
import com.appyet.manager.bw;
import com.appyet.metadata.MetadataTheme;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.appyet.c.a:
//            l

final class n extends a
{

    WebView a;
    String b;
    View c;
    final l d;

    public n(l l1, WebView webview, View view)
    {
        d = l1;
        super();
        a = webview;
        c = view;
    }

    private transient Boolean f()
    {
        List list = com.appyet.c.a.l.c(d).p.a(l.b(d).longValue(), com.appyet.c.a.l.c(d).o.b.b, com.appyet.c.a.l.d(d));
        String s = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML Basic 1.1//EN\"\"http://www.w3.org/TR/xhtml-basic/xhtml-basic11.dtd\"><html><head><title></title>";
        String s1;
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            s = (new StringBuilder()).append(s).append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\" />").toString();
        }
        s1 = (new StringBuilder()).append(s).append("<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/html/fonts.css\"></link>").toString();
        if (!com.appyet.c.a.l.c(d).m.a.PrimaryBgColor.equals("DARK")) goto _L2; else goto _L1
_L1:
        String s2 = (new StringBuilder()).append(s1).append("<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/html/forum/forum_dark.css\"></link>").toString();
_L19:
        com.appyet.c.a.l.c(d).d.K();
        JVM INSTR tableswitch 0 4: default 192
    //                   0 544
    //                   1 609
    //                   2 674
    //                   3 739
    //                   4 804;
           goto _L3 _L4 _L5 _L6 _L7 _L8
_L3:
        String s3 = (new StringBuilder()).append(s2).append("</head><body><div class=\"posts\">").toString();
        if (list == null) goto _L10; else goto _L9
_L9:
        if (list.size() <= 0) goto _L10; else goto _L11
_L11:
        Iterator iterator = list.iterator();
        String s4;
        int i;
        s4 = s3;
        i = 0;
_L18:
        if (!iterator.hasNext()) goto _L13; else goto _L12
_L12:
        c c1 = (c)iterator.next();
        int j = i + 1;
        if (!com.appyet.d.a.a(c1.g, new Date())) goto _L15; else goto _L14
_L14:
        String s5 = com.appyet.d.a.d(com.appyet.c.a.l.c(d), c1.g);
_L20:
        if (c1.f == null || c1.f.length() <= 0) goto _L17; else goto _L16
_L16:
        String s6 = c1.f;
_L21:
        String s11;
        String s7 = (new StringBuilder()).append(s4).append("<div class=\"post\">").toString();
        String s8 = (new StringBuilder()).append(s7).append("<div class=\"posthead\"><img src=\"").append(s6).append("\" class=\"postavatar\"><div class=\"postauthor\">").append(c1.e).append("</div><div class=\"postindex\">&nbsp;/&nbsp;#").append(j + 10 * com.appyet.c.a.l.d(d)).append("</div><div class=\"postdate\">&nbsp;/&nbsp;").append(s5).append("</div></div>").toString();
        String s9 = (new StringBuilder()).append(s8).append("<div class=\"postbody\">").append(c1.c).append("</div>").toString();
        String s10 = (new StringBuilder()).append(s9).append("<div class=\"postfooter\"></div>").toString();
        s11 = (new StringBuilder()).append(s10).append("</div><hr/>").toString();
        i = j;
        s4 = s11;
          goto _L18
_L2:
        s2 = (new StringBuilder()).append(s1).append("<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/html/forum/forum_light.css\"></link>").toString();
          goto _L19
_L4:
label0:
        {
            if (!d.getResources().getBoolean(0x7f0d000d))
            {
                break label0;
            }
            s2 = (new StringBuilder()).append(s2).append("<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/html/article_tablet_extra_small.css\"></link>").toString();
        }
          goto _L3
        s2 = (new StringBuilder()).append(s2).append("<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/html/article_extra_small.css\"></link>").toString();
          goto _L3
_L5:
label1:
        {
            if (!d.getResources().getBoolean(0x7f0d000d))
            {
                break label1;
            }
            s2 = (new StringBuilder()).append(s2).append("<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/html/article_tablet_small.css\"></link>").toString();
        }
          goto _L3
        s2 = (new StringBuilder()).append(s2).append("<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/html/article_small.css\"></link>").toString();
          goto _L3
_L6:
label2:
        {
            if (!d.getResources().getBoolean(0x7f0d000d))
            {
                break label2;
            }
            s2 = (new StringBuilder()).append(s2).append("<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/html/article_tablet_medium.css\"></link>").toString();
        }
          goto _L3
        s2 = (new StringBuilder()).append(s2).append("<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/html/article_medium.css\"></link>").toString();
          goto _L3
_L7:
label3:
        {
            if (!d.getResources().getBoolean(0x7f0d000d))
            {
                break label3;
            }
            s2 = (new StringBuilder()).append(s2).append("<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/html/article_tablet_large.css\"></link>").toString();
        }
          goto _L3
        s2 = (new StringBuilder()).append(s2).append("<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/html/article_large.css\"></link>").toString();
          goto _L3
_L8:
label4:
        {
            if (!d.getResources().getBoolean(0x7f0d000d))
            {
                break label4;
            }
            s2 = (new StringBuilder()).append(s2).append("<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/html/article_tablet_extra_large.css\"></link>").toString();
        }
          goto _L3
        s2 = (new StringBuilder()).append(s2).append("<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/html/article_extra_large.css\"></link>").toString();
          goto _L3
_L15:
        s5 = com.appyet.d.a.b(com.appyet.c.a.l.c(d), c1.g);
          goto _L20
_L17:
        Exception exception;
        if (com.appyet.c.a.l.c(d).m.a.PrimaryBgColor.equals("DARK"))
        {
            s6 = "file:///android_asset/html/forum/default_avatar_dark.png";
        } else
        {
            s6 = "file:///android_asset/html/forum/default_avatar_light.png";
        }
          goto _L21
_L10:
        b = null;
        return null;
_L13:
        b = (new StringBuilder()).append(s4).append("</div></body></html>").toString();
        return Boolean.valueOf(true);
        exception;
        com.appyet.d.d.a(exception);
        return Boolean.valueOf(false);
          goto _L18
    }

    protected final void a()
    {
        l.f(d).setVisibility(0);
        com.appyet.c.a.l.e(d).setVisibility(8);
    }

    protected final void a(Object obj)
    {
        Boolean boolean1 = (Boolean)obj;
        super.a(boolean1);
        if (boolean1 == null || !boolean1.booleanValue())
        {
            break MISSING_BLOCK_LABEL_74;
        }
        if (a == null)
        {
            return;
        }
        try
        {
            if (b == null)
            {
                com.appyet.c.a.l.e(d).setVisibility(0);
                a.setVisibility(8);
                l.f(d).setVisibility(8);
                return;
            }
            break MISSING_BLOCK_LABEL_107;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        com.appyet.c.a.l.e(d).setVisibility(0);
        a.setVisibility(8);
        l.f(d).setVisibility(8);
        return;
        com.appyet.c.a.l.e(d).setVisibility(8);
        a.setVisibility(0);
        a.loadDataWithBaseURL(com.appyet.c.a.l.g(d), b, "text/html", "UTF-8", "");
        return;
    }

    protected final Object b()
    {
        return f();
    }
}
