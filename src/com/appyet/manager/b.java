// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import android.app.Activity;
import android.content.res.Resources;
import android.view.ViewGroup;
import com.appyet.b.a.t;
import com.appyet.context.ApplicationContext;
import com.appyet.d.a;
import com.appyet.d.d;
import com.appyet.f.o;
import com.appyet.metadata.Metadata;
import com.appyet.metadata.MetadataAppSync;
import com.appyet.metadata.MetadataApplication;
import com.google.a.k;
import com.google.a.r;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Random;

// Referenced classes of package com.appyet.manager:
//            a, af, al, ar, 
//            c

public final class b
{

    public String a;
    private ApplicationContext b;
    private AdView c;

    public b(ApplicationContext applicationcontext)
    {
        a = "WeChap3awEbr";
        b = applicationcontext;
        d();
    }

    private void d()
    {
        StringBuilder stringbuilder;
        InputStream inputstream;
        DataInputStream datainputstream;
        BufferedReader bufferedreader;
        stringbuilder = new StringBuilder();
        inputstream = b.getResources().openRawResource(0x7f060000);
        datainputstream = new DataInputStream(inputstream);
        bufferedreader = new BufferedReader(new InputStreamReader(datainputstream, "UTF-8"));
_L1:
        String s = bufferedreader.readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_173;
        }
        stringbuilder.append(s);
          goto _L1
        Exception exception;
        exception;
        b.q.MetadataApplication.IsShowAd = Boolean.valueOf(true);
        b.q.MetadataApplication.VendorAdmobIdBanner = "a15170387834572";
        b.q.MetadataApplication.VendorAdmobIdFullBanner = "a15170387834572";
        b.q.MetadataApplication.UserAdAllocation = Integer.valueOf(0);
        b.q.MetadataApplication.UserAdmobIdBanner = "";
        b.q.MetadataApplication.UserAdmobIdFullBanner = "";
        com.appyet.d.d.a(exception);
_L2:
        return;
        datainputstream.close();
        bufferedreader.close();
        inputstream.close();
        String s1 = (new o((new StringBuilder()).append(com.appyet.manager.a.a).append(t.c).append(com.appyet.manager.af.a).append(com.appyet.manager.al.a).append(com.appyet.manager.ar.d).append(a.a).toString())).a(stringbuilder.toString());
        r r1 = new r();
        r1.a = "yyyy-MM-dd'T'HH:mm:ss";
        k k1 = r1.a();
        b.q = (Metadata)k1.a(s1, com/appyet/metadata/Metadata);
        if (!b.q.MetadataApplication.PackageName.equals(b.getPackageName()))
        {
            b.q.MetadataApplication.IsShowAd = Boolean.valueOf(true);
            b.q.MetadataApplication.VendorAdmobIdBanner = "a15170387834572";
            b.q.MetadataApplication.VendorAdmobIdFullBanner = "a15170387834572";
            b.q.MetadataApplication.UserAdAllocation = Integer.valueOf(0);
            b.q.MetadataApplication.UserAdmobIdBanner = "";
            b.q.MetadataApplication.UserAdmobIdFullBanner = "";
        }
        Date date = new Date();
        if (b.q.MetadataApplication.ApplicationTypeId != 1 && b.q.MetadataApplication.SubscriptionExpireDate != null && b.q.MetadataApplication.SubscriptionExpireDate.compareTo(date) < 0)
        {
            b.q.MetadataApplication.IsShowAd = Boolean.valueOf(true);
            b.q.MetadataApplication.VendorAdmobIdBanner = "a15170387834572";
            b.q.MetadataApplication.VendorAdmobIdFullBanner = "a15170387834572";
            b.q.MetadataApplication.UserAdAllocation = Integer.valueOf(0);
            b.q.MetadataApplication.UserAdmobIdBanner = "";
            b.q.MetadataApplication.UserAdmobIdFullBanner = "";
            return;
        }
          goto _L2
    }

    private com.appyet.a.a e()
    {
        com.appyet.a.a a1 = new com.appyet.a.a();
        if (b.r == null)
        {
            break MISSING_BLOCK_LABEL_502;
        }
        if (b.r.IsValid.booleanValue() && !b.r.IsExpired.booleanValue())
        {
            break MISSING_BLOCK_LABEL_88;
        }
        a1.a = Boolean.valueOf(true);
        a1.b = b.r.VendorAdmobIdBanner;
        a1.c = b.r.VendorAdmobIdFullBanner;
        return a1;
        if (!b.r.IsShowAd.booleanValue())
        {
            break MISSING_BLOCK_LABEL_482;
        }
        a1.a = Boolean.valueOf(true);
        if (b.r.UserAdAllocation != null && b.r.UserAdAllocation.intValue() > 0)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        a1.b = b.r.VendorAdmobIdBanner;
        a1.c = b.r.VendorAdmobIdFullBanner;
        Exception exception;
        return a1;
        if (b.r.UserAdAllocation.intValue() <= 100)
        {
            break MISSING_BLOCK_LABEL_314;
        }
        if (b.r.UserAdmobIdBanner == null || b.r.UserAdmobIdBanner.trim().length() <= 0)
        {
            break MISSING_BLOCK_LABEL_278;
        }
        a1.b = b.r.UserAdmobIdBanner;
        a1.c = b.r.UserAdmobIdFullBanner;
        return a1;
        try
        {
            a1.b = b.q.MetadataApplication.UserAdmobIdBanner;
            a1.c = b.q.MetadataApplication.UserAdmobIdFullBanner;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            a1.a = Boolean.valueOf(true);
            a1.b = "4e9e34fb3d06472b";
            a1.c = "936668ecf7014517";
            return a1;
        }
        return a1;
        if (1 + (new Random((new Date()).getTime())).nextInt(100) >= b.r.UserAdAllocation.intValue())
        {
            break MISSING_BLOCK_LABEL_452;
        }
        if (b.r.UserAdmobIdBanner == null || b.r.UserAdmobIdBanner.trim().length() <= 0)
        {
            break MISSING_BLOCK_LABEL_416;
        }
        a1.b = b.r.UserAdmobIdBanner;
        a1.c = b.r.UserAdmobIdFullBanner;
        return a1;
        a1.b = b.q.MetadataApplication.UserAdmobIdBanner;
        a1.c = b.q.MetadataApplication.UserAdmobIdFullBanner;
        return a1;
        a1.b = b.r.VendorAdmobIdBanner;
        a1.c = b.r.VendorAdmobIdFullBanner;
        return a1;
        a1.a = Boolean.valueOf(false);
        a1.b = null;
        a1.c = null;
        return a1;
        if (!b.q.MetadataApplication.IsShowAd.booleanValue())
        {
            break MISSING_BLOCK_LABEL_772;
        }
        a1.a = Boolean.valueOf(true);
        if (b.q.MetadataApplication.UserAdAllocation != null && b.q.MetadataApplication.UserAdAllocation.intValue() > 0)
        {
            break MISSING_BLOCK_LABEL_600;
        }
        a1.b = b.q.MetadataApplication.VendorAdmobIdBanner;
        a1.c = b.q.MetadataApplication.VendorAdmobIdFullBanner;
        return a1;
        if (b.q.MetadataApplication.UserAdAllocation.intValue() <= 100)
        {
            break MISSING_BLOCK_LABEL_657;
        }
        a1.b = b.q.MetadataApplication.UserAdmobIdBanner;
        a1.c = b.q.MetadataApplication.UserAdmobIdFullBanner;
        return a1;
        if (1 + (new Random((new Date()).getTime())).nextInt(100) >= b.q.MetadataApplication.UserAdAllocation.intValue())
        {
            break MISSING_BLOCK_LABEL_736;
        }
        a1.b = b.q.MetadataApplication.UserAdmobIdBanner;
        a1.c = b.q.MetadataApplication.UserAdmobIdFullBanner;
        return a1;
        a1.b = b.q.MetadataApplication.VendorAdmobIdBanner;
        a1.c = b.q.MetadataApplication.VendorAdmobIdFullBanner;
        return a1;
        a1.a = Boolean.valueOf(false);
        a1.b = null;
        a1.c = null;
        return a1;
    }

    public final void a()
    {
        try
        {
            if (c != null)
            {
                c.pause();
            }
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        c = null;
    }

    public final void a(Activity activity, ViewGroup viewgroup)
    {
        com.appyet.a.a a1;
        try
        {
            a1 = e();
            if (!a1.a.booleanValue())
            {
                return;
            }
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return;
        }
        viewgroup.removeAllViews();
        viewgroup.setVisibility(8);
        c = null;
        if (b.y != 4) goto _L2; else goto _L1
_L1:
        c = new AdView(activity);
        c.setAdUnitId(a1.c);
        c.setAdSize(AdSize.FULL_BANNER);
_L3:
        c.setAdListener(new c(this, viewgroup));
        viewgroup.addView(c);
        com.google.android.gms.ads.AdRequest adrequest = (new com.google.android.gms.ads.AdRequest.Builder()).build();
        c.loadAd(adrequest);
        return;
_L2:
label0:
        {
            if (b.y != 3)
            {
                break label0;
            }
            c = new AdView(activity);
            c.setAdUnitId(a1.b);
            c.setAdSize(AdSize.BANNER);
        }
          goto _L3
        c = new AdView(activity);
        c.setAdUnitId(a1.b);
        c.setAdSize(AdSize.BANNER);
          goto _L3
    }

    public final void b()
    {
        try
        {
            if (c != null)
            {
                c.resume();
            }
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        c = null;
    }

    public final void c()
    {
        try
        {
            if (c != null)
            {
                c.destroy();
                c = null;
            }
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        c = null;
    }
}
