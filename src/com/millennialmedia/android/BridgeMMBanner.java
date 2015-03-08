// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.lang.ref.WeakReference;
import java.util.HashMap;

// Referenced classes of package com.millennialmedia.android:
//            MMJSObject, MMSDK, MMWebView, MMJSResponse, 
//            DTOResizeParameters

class BridgeMMBanner extends MMJSObject
{

    BridgeMMBanner()
    {
    }

    int getScreenHeight(Context context)
    {
        return Integer.parseInt(MMSDK.getDpiHeight(context));
    }

    int getScreenWidth(Context context)
    {
        return Integer.parseInt(MMSDK.getDpiWidth(context));
    }

    public MMJSResponse resize(HashMap hashmap)
    {
        MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
        if (mmwebview != null)
        {
            if (mmwebview.isMraidResized())
            {
                return MMJSResponse.responseWithError("State is currently resized");
            }
            String s = (String)hashmap.get("width");
            String s1 = (String)hashmap.get("height");
            int i;
            int j;
            String s2;
            String s3;
            String s4;
            int k;
            boolean flag;
            int l;
            boolean flag1;
            Context context;
            DisplayMetrics displaymetrics;
            int i1;
            int j1;
            if (!TextUtils.isEmpty(s))
            {
                i = (int)Float.parseFloat(s);
            } else
            {
                i = 0;
            }
            if (!TextUtils.isEmpty(s1))
            {
                j = (int)Float.parseFloat(s1);
            } else
            {
                j = 0;
            }
            s2 = (String)hashmap.get("customClosePosition");
            s3 = (String)hashmap.get("offsetX");
            s4 = (String)hashmap.get("offsetY");
            if (!TextUtils.isEmpty(s4))
            {
                k = (int)Float.parseFloat(s4);
            } else
            {
                k = 0;
            }
            flag = TextUtils.isEmpty(s3);
            l = 0;
            if (!flag)
            {
                l = (int)Float.parseFloat(s3);
            }
            flag1 = Boolean.parseBoolean((String)hashmap.get("allowOffscreen"));
            context = mmwebview.getContext();
            displaymetrics = MMSDK.getMetrics(context);
            i1 = getScreenWidth(context);
            j1 = getScreenHeight(context);
            mmwebview.setMraidResize(new DTOResizeParameters(displaymetrics.density, i, j, s2, l, k, flag1, i1, j1));
            return MMJSResponse.responseWithSuccess();
        } else
        {
            return null;
        }
    }
}
