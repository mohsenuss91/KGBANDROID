// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

final class sN
    implements android.content.gInterface.OnCancelListener
{

    final JsPromptResult sN;

    public final void onCancel(DialogInterface dialoginterface)
    {
        sN.cancel();
    }

    celListener(JsPromptResult jspromptresult)
    {
        sN = jspromptresult;
        super();
    }
}
