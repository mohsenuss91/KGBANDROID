// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;

import android.content.Context;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import com.inmobi.androidsdk.impl.imai.IMAIController;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UIDUtil;
import com.inmobi.re.container.IMWebView;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.monetization.internal:
//            a

public class TrackerView extends View
{

    public static final int ID = 999;
    WebViewClient a;
    private IMWebView b;
    private boolean c;
    private String d;
    private ArrayList e;
    private boolean f;

    public TrackerView(Context context, String s, String s1)
    {
        super(context);
        c = false;
        e = null;
        f = false;
        a = new a(this);
        if (s == null || s1 == null)
        {
            return;
        } else
        {
            d = s1;
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            layoutparams.addRule(10);
            setLayoutParams(layoutparams);
            setBackgroundColor(0);
            IMWebView.setIMAIController(com/inmobi/androidsdk/impl/imai/IMAIController);
            b = new IMWebView(context, null, false, false);
            b.getSettings().setJavaScriptEnabled(true);
            b.getSettings().setCacheMode(2);
            b.setWebViewClient(a);
            b.loadData(s, "text/html", "UTF-8");
            e = new ArrayList();
            setId(999);
            return;
        }
    }

    private String a()
    {
        return (new StringBuilder()).append(d).append("recordEvent(18)").toString();
    }

    private String a(HashMap hashmap)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (hashmap == null || hashmap.isEmpty())
        {
            stringbuilder.append((new StringBuilder()).append(d).append("recordEvent(8)").toString());
            return stringbuilder.toString();
        } else
        {
            stringbuilder.append((new StringBuilder()).append(d).append("recordEvent(8, ").toString());
            JSONObject jsonobject = new JSONObject();
            UIDUtil.bindToJSON(hashmap, jsonobject);
            stringbuilder.append(jsonobject.toString());
            stringbuilder.append(")");
            return stringbuilder.toString();
        }
    }

    static ArrayList a(TrackerView trackerview)
    {
        return trackerview.e;
    }

    static ArrayList a(TrackerView trackerview, ArrayList arraylist)
    {
        trackerview.e = arraylist;
        return arraylist;
    }

    static boolean a(TrackerView trackerview, boolean flag)
    {
        trackerview.f = flag;
        return flag;
    }

    public void click(HashMap hashmap)
    {
        Log.debug("[InMobi]-[Monetization]", "Handle Click");
        String s = a(hashmap);
        if (f)
        {
            injectJavaScript(s);
        } else
        if (e != null)
        {
            e.add(s);
            return;
        }
    }

    public void destroy()
    {
        if (b != null)
        {
            b.destroy();
            b = null;
        }
        if (e != null)
        {
            e.clear();
            e = null;
        }
        c = false;
        f = false;
    }

    public void handleImpression(String s)
    {
        Log.debug("[InMobi]-[Monetization]", "Handle Impression");
        injectJavaScript(s);
    }

    public void injectJavaScript(String s)
    {
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        if (s.length() < 400)
        {
            Log.internal("[InMobi]-[Monetization]", s);
        }
        if (b != null)
        {
            b.loadUrl((new StringBuilder("javascript:try{")).append(s).append("}catch(e){}").toString());
        }
        return;
        Exception exception;
        exception;
        exception.printStackTrace();
        return;
    }

    protected void onWindowVisibilityChanged(int i)
    {
        super.onWindowVisibilityChanged(i);
        if (i == 0 && !c)
        {
            c = true;
            if (f)
            {
                handleImpression(a());
            } else
            if (e != null)
            {
                e.add(a());
                return;
            }
        }
    }
}
