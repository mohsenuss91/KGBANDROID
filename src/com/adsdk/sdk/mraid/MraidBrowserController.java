// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

// Referenced classes of package com.adsdk.sdk.mraid:
//            MraidAbstractController, MraidView, Utils, MraidBrowser

class MraidBrowserController extends MraidAbstractController
{

    private static final String LOGTAG = "MraidBrowserController";
    private Context mContext;

    MraidBrowserController(MraidView mraidview)
    {
        super(mraidview);
        mContext = mraidview.getContext();
    }

    private boolean canHandleApplicationUrl(String s)
    {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(s));
        if (!Utils.deviceCanHandleIntent(mContext, intent))
        {
            Log.w("MoPub", (new StringBuilder("Could not handle application specific action: ")).append(s).append(". You may be running in the emulator or another device which does not have the required application.").toString());
            return false;
        } else
        {
            return true;
        }
    }

    private boolean executeIntent(Context context, Intent intent, String s)
    {
        try
        {
            context.startActivity(intent);
        }
        catch (Exception exception)
        {
            if (s == null)
            {
                s = "Unable to start intent.";
            }
            Log.d("MoPub", s);
            return false;
        }
        return true;
    }

    private boolean isWebSiteUrl(String s)
    {
        return s.startsWith("http://") || s.startsWith("https://");
    }

    private boolean launchApplicationUrl(String s)
    {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(s));
        intent.addFlags(0x10000000);
        return executeIntent(getMraidView().getContext(), intent, "Unable to open intent.");
    }

    protected void open(String s)
    {
        Log.d("MraidBrowserController", (new StringBuilder("Opening url: ")).append(s).toString());
        MraidView mraidview = getMraidView();
        if (mraidview.getOnOpenListener() != null)
        {
            mraidview.getOnOpenListener().onOpen(mraidview);
        }
        if (!isWebSiteUrl(s) && canHandleApplicationUrl(s))
        {
            launchApplicationUrl(s);
            return;
        } else
        {
            Intent intent = new Intent(mContext, com/adsdk/sdk/mraid/MraidBrowser);
            intent.putExtra("extra_url", s);
            intent.addFlags(0x10000000);
            mContext.startActivity(intent);
            return;
        }
    }
}
