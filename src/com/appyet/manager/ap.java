// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.metadata.Metadata;
import com.appyet.metadata.MetadataAppSync;
import com.appyet.metadata.MetadataApplication;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.MapBuilder;
import com.google.analytics.tracking.android.Tracker;

// Referenced classes of package com.appyet.manager:
//            aq

public final class ap
{

    public Tracker a;
    public Tracker b;
    private ApplicationContext c;
    private GoogleAnalytics d;

    public ap(ApplicationContext applicationcontext)
    {
        c = applicationcontext;
        a();
    }

    public final void a()
    {
        d = GoogleAnalytics.getInstance(c);
        if (c.r == null || c.r.VendorGoogleAnalyticUACode == null || c.r.VendorGoogleAnalyticUACode.trim().equals("")) goto _L2; else goto _L1
_L1:
        a = d.getTracker(c.r.VendorGoogleAnalyticUACode);
_L4:
        Exception exception;
        try
        {
            if (c.q.MetadataApplication.UserGoogleAnalyticUaCode != null)
            {
                b = d.getTracker(c.q.MetadataApplication.UserGoogleAnalyticUaCode);
                return;
            }
            break; /* Loop/switch isn't completed */
        }
        catch (Exception exception1)
        {
            com.appyet.d.d.a(exception1);
        }
        break MISSING_BLOCK_LABEL_211;
_L2:
        if (c.q.MetadataApplication.VendorGoogleAnalyticUaCode != null && !c.q.MetadataApplication.VendorGoogleAnalyticUaCode.trim().equals(""))
        {
            a = d.getTracker(c.q.MetadataApplication.VendorGoogleAnalyticUaCode);
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            a = null;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        if (true) goto _L4; else goto _L3
_L3:
        b = null;
        return;
    }

    public final void a(Exception exception)
    {
        if (a != null)
        {
            a.send(MapBuilder.createException(exception.getMessage(), Boolean.valueOf(false)).build());
        }
    }

    public final void a(String s)
    {
        (new aq(this, s)).a(new Void[0]);
    }

    public final void a(String s, String s1, String s2)
    {
        try
        {
            if (a != null)
            {
                a.send(MapBuilder.createSocial(s, s1, s2).build());
            }
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        try
        {
            if (b != null)
            {
                b.send(MapBuilder.createSocial(s, s1, s2).build());
            }
            return;
        }
        catch (Exception exception1)
        {
            com.appyet.d.d.a(exception1);
        }
    }
}
