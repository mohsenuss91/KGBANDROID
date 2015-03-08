// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.WebView;
import java.lang.reflect.Method;

// Referenced classes of package com.adsdk.sdk.mraid:
//            WebViews, VersionCode

public class BaseWebView extends WebView
{

    public BaseWebView(Context context)
    {
        super(context.getApplicationContext());
        enablePlugins(false);
        WebViews.setDisableJSChromeClient(this);
    }

    public void destroy()
    {
        if (getParent() != null && (getParent() instanceof ViewGroup))
        {
            ((ViewGroup)getParent()).removeView(this);
        }
        super.destroy();
    }

    protected void enablePlugins(boolean flag)
    {
        if (VersionCode.currentApiLevel().isAtLeast(VersionCode.JELLY_BEAN_MR2))
        {
            return;
        }
        if (VersionCode.currentApiLevel().isBelow(VersionCode.FROYO))
        {
            try
            {
                Class class2 = Class.forName("android.webkit.WebSettings");
                Class aclass1[] = new Class[1];
                aclass1[0] = Boolean.TYPE;
                Method method1 = class2.getDeclaredMethod("setPluginsEnabled", aclass1);
                android.webkit.WebSettings websettings = getSettings();
                Object aobj[] = new Object[1];
                aobj[0] = Boolean.valueOf(flag);
                method1.invoke(websettings, aobj);
                return;
            }
            catch (Exception exception1)
            {
                StringBuilder stringbuilder = new StringBuilder("Unable to ");
                String s1;
                if (flag)
                {
                    s1 = "enable";
                } else
                {
                    s1 = "disable";
                }
                Log.d("MoPub", stringbuilder.append(s1).append("WebSettings plugins for BaseWebView.").toString());
                return;
            }
        }
        Class class1;
        Method method;
        class1 = Class.forName("android.webkit.WebSettings$PluginState");
        Class aclass[] = {
            class1
        };
        method = getSettings().getClass().getDeclaredMethod("setPluginState", aclass);
        String s;
        if (flag)
        {
            s = "ON";
        } else
        {
            s = "OFF";
        }
        try
        {
            Enum enum = Enum.valueOf(class1, s);
            method.invoke(getSettings(), new Object[] {
                enum
            });
            return;
        }
        catch (Exception exception)
        {
            Log.d("MoPub", "Unable to modify WebView plugin state.");
        }
        return;
    }
}
