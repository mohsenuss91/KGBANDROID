// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.millennialmedia.android:
//            MMWebView, MMJSObject, MMJSResponse, MMSDK

class MMCommand
    implements Runnable
{

    private Map arguments;
    private String callback;
    private Class cls;
    private Method method;
    private WeakReference webViewRef;

    MMCommand(MMWebView mmwebview, String s)
    {
        int j;
        webViewRef = new WeakReference(mmwebview);
        String as[];
        String s1;
        String s2;
        String as1[];
        int i;
        String as2[];
        Class class1;
        Class aclass[];
        try
        {
            as = Uri.parse(s).getHost().split("\\.");
            if (as.length < 2)
            {
                return;
            }
        }
        catch (Exception exception)
        {
            Object aobj[] = new Object[2];
            aobj[0] = s;
            aobj[1] = exception.getMessage();
            MMSDK.Log.e("Exception while executing javascript call %s %s", aobj);
            exception.printStackTrace();
            return;
        }
        s1 = as[-2 + as.length];
        s2 = as[-1 + as.length];
        arguments = new HashMap();
        as1 = s.substring(1 + s.indexOf('?')).split("&");
        i = as1.length;
        j = 0;
_L2:
        if (j >= i)
        {
            break MISSING_BLOCK_LABEL_173;
        }
        as2 = as1[j].split("=");
        if (as2.length >= 2)
        {
            arguments.put(Uri.decode(as2[0]), Uri.decode(as2[1]));
            if (as2[0].equalsIgnoreCase("callback"))
            {
                callback = Uri.decode(as2[1]);
            }
        }
        break MISSING_BLOCK_LABEL_266;
        cls = Class.forName((new StringBuilder("com.millennialmedia.android.Bridge")).append(s1).toString());
        class1 = cls;
        aclass = new Class[1];
        aclass[0] = arguments.getClass();
        method = class1.getMethod(s2, aclass);
        return;
        j++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private String getBridgeStrippedClassName()
    {
        return cls.getSimpleName().replaceFirst("Bridge", "");
    }

    boolean isResizeCommand()
    {
        if (method != null)
        {
            return "resize".equals(method.getName());
        } else
        {
            return false;
        }
    }

    public void run()
    {
        if (cls == null || method == null) goto _L2; else goto _L1
_L1:
        MMWebView mmwebview;
        MMJSObject mmjsobject;
        InvocationTargetException invocationtargetexception;
        Throwable throwable;
        MMJSResponse mmjsresponse1;
        MMJSResponse mmjsresponse2;
        final MMWebView webViewCallback;
        MMJSResponse mmjsresponse3;
        try
        {
            mmwebview = (MMWebView)webViewRef.get();
        }
        catch (Exception exception)
        {
            Object aobj1[] = new Object[2];
            aobj1[0] = method.toString();
            aobj1[1] = exception.getMessage();
            MMSDK.Log.e("Exception while executing javascript call %s %s", aobj1);
            exception.printStackTrace();
            return;
        }
        if (mmwebview == null) goto _L4; else goto _L3
_L3:
        mmjsobject = (MMJSObject)cls.newInstance();
        mmjsobject.setContext(mmwebview.getContext());
        mmjsobject.setMMWebView(mmwebview);
        mmwebview.updateArgumentsWithSettings(arguments);
        Method method1 = method;
        Object aobj3[] = new Object[1];
        aobj3[0] = arguments;
        mmjsresponse3 = (MMJSResponse)method1.invoke(mmjsobject, aobj3);
        mmjsresponse2 = mmjsresponse3;
_L5:
        if (callback == null || callback.length() <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        webViewCallback = (MMWebView)webViewRef.get();
        if (webViewCallback == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (mmjsresponse2 != null)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        mmjsresponse2 = MMJSResponse.responseWithError(method.getName());
        if (mmjsresponse2.methodName == null)
        {
            mmjsresponse2.methodName = method.getName();
        }
        if (mmjsresponse2.className == null)
        {
            mmjsresponse2.className = getBridgeStrippedClassName();
        }
        Object aobj2[] = new Object[2];
        aobj2[0] = callback;
        aobj2[1] = mmjsresponse2.toJSONString();
        final String call = String.format("javascript:%s(%s);", aobj2);
        MMSDK.Log.v((new StringBuilder("Executing JS bridge callback: ")).append(call).toString());
        MMSDK.runOnUiThread(new _cls1());
        return;
        invocationtargetexception;
        throwable = invocationtargetexception.getCause();
        if (throwable == null)
        {
            break MISSING_BLOCK_LABEL_297;
        }
        if (throwable.getClass() == android/content/ActivityNotFoundException)
        {
            mmjsresponse2 = MMJSResponse.responseWithError("Activity not found");
            continue; /* Loop/switch isn't completed */
        }
        mmjsresponse1 = MMJSResponse.responseWithError();
        mmjsresponse2 = mmjsresponse1;
        if (true) goto _L5; else goto _L4
_L2:
        if (!TextUtils.isEmpty(callback))
        {
            MMJSResponse mmjsresponse = MMJSResponse.responseWithError("No class or method found");
            Object aobj[] = new Object[2];
            aobj[0] = callback;
            aobj[1] = mmjsresponse.toJSONString();
            String s = String.format("javascript:%s(%s);", aobj);
            MMSDK.Log.v((new StringBuilder("Executing JS bridge failed callback: ")).append(s).toString());
            MMSDK.runOnUiThread(new _cls2());
        }
_L4:
    }


    private class _cls1
        implements Runnable
    {

        final MMCommand this$0;
        final String val$call;
        final MMWebView val$webViewCallback;

        public void run()
        {
            if (method.getName().equals("expandWithProperties"))
            {
                webViewCallback.isExpanding = true;
            }
            webViewCallback.loadUrl(call);
        }

        _cls1()
        {
            this$0 = MMCommand.this;
            webViewCallback = mmwebview;
            call = s;
            super();
        }
    }


    private class _cls2
        implements Runnable
    {

        final MMCommand this$0;
        final String val$call;
        final MMWebView val$webViewCallback;

        public void run()
        {
            webViewCallback.loadUrl(call);
        }

        _cls2()
        {
            this$0 = MMCommand.this;
            webViewCallback = mmwebview;
            call = s;
            super();
        }
    }

}
