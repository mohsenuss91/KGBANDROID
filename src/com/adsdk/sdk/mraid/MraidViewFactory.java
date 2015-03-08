// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;

import android.content.Context;

// Referenced classes of package com.adsdk.sdk.mraid:
//            MraidView

public class MraidViewFactory
{

    protected static MraidViewFactory instance = new MraidViewFactory();

    public MraidViewFactory()
    {
    }

    public static MraidView create(Context context)
    {
        return instance.internalCreate(context);
    }

    public static MraidView create(Context context, MraidView.ExpansionStyle expansionstyle, MraidView.NativeCloseButtonStyle nativeclosebuttonstyle, MraidView.PlacementType placementtype)
    {
        return instance.internalCreate(context, expansionstyle, nativeclosebuttonstyle, placementtype);
    }

    public static void setInstance(MraidViewFactory mraidviewfactory)
    {
        instance = mraidviewfactory;
    }

    protected MraidView internalCreate(Context context)
    {
        return new MraidView(context);
    }

    protected MraidView internalCreate(Context context, MraidView.ExpansionStyle expansionstyle, MraidView.NativeCloseButtonStyle nativeclosebuttonstyle, MraidView.PlacementType placementtype)
    {
        return new MraidView(context, expansionstyle, nativeclosebuttonstyle, placementtype);
    }

}
