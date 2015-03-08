// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UIDHelper;
import com.inmobi.commons.uid.UIDUtil;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class GetLtvpRulesRequest
{

    private String a;
    private String b;
    private String c;
    private long d;
    private String e;
    private String f;
    private String g;

    public GetLtvpRulesRequest()
    {
        try
        {
            a = InMobi.getAppId();
            b = (new StringBuilder("pr-SAND-")).append(InternalSDKUtil.getInMobiInternalVersion(InMobi.getVersion())).append("-20140613").toString();
            d = (new Random()).nextInt();
            c = UIDUtil.getEncryptedUid(Long.toString(d));
            e = UIDHelper.getRSAKeyVersion();
            f = InternalSDKUtil.getContext().getPackageName();
            g = InternalSDKUtil.getContext().getPackageManager().getPackageInfo(f, 0).versionName;
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[Monetization]", "Failed to init Ltvp request", exception);
        }
    }

    public String getEncodedRequestParams()
    {
        LinkedList linkedlist;
        String s;
        String s1;
        try
        {
            linkedlist = new LinkedList();
            if (a != null && !"".equals(a))
            {
                linkedlist.add(new BasicNameValuePair("mk-siteid", a));
            }
            if (b != null && !"".equals(b))
            {
                linkedlist.add(new BasicNameValuePair("mk-version", b));
            }
            if (c != null && !"".equals(c))
            {
                linkedlist.add(new BasicNameValuePair("u-id-map", c));
            }
            linkedlist.add(new BasicNameValuePair("u-id-key", Long.toString(d)));
            if (e != null && !"".equals(e))
            {
                linkedlist.add(new BasicNameValuePair("u-key-ver", e));
            }
            if (f != null && !"".equals(f))
            {
                linkedlist.add(new BasicNameValuePair("u-appbid", f));
            }
            if (g != null && !"".equals(g))
            {
                linkedlist.add(new BasicNameValuePair("u-appver", g));
            }
            s = InternalSDKUtil.getContext().getResources().getConfiguration().locale.toString();
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[Monetization]", "Exception getting request params for ltvp get rules", exception);
            return null;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_315;
        }
        if (!"".equals(s))
        {
            linkedlist.add(new BasicNameValuePair("d-localization", s));
        }
        linkedlist.add(new BasicNameValuePair("ts", Long.toString(System.currentTimeMillis())));
        s1 = URLEncodedUtils.format(linkedlist, "utf-8");
        return s1;
    }
}
