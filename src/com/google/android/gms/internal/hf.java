// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Intent;
import android.net.Uri;

public class hf
{

    private static final Uri GD;
    private static final Uri GE;

    public static Intent aB(String s)
    {
        Uri uri = Uri.fromParts("package", s, null);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(uri);
        return intent;
    }

    private static Uri aC(String s)
    {
        return Uri.parse("market://details").buildUpon().appendQueryParameter("id", s).build();
    }

    public static Intent aD(String s)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(aC(s));
        intent.setPackage("com.android.vending");
        intent.addFlags(0x80000);
        return intent;
    }

    public static Intent fv()
    {
        return new Intent("android.settings.DATE_SETTINGS");
    }

    static 
    {
        Uri uri = Uri.parse("http://plus.google.com/");
        GD = uri;
        GE = uri.buildUpon().appendPath("circles").appendPath("find").build();
    }
}
