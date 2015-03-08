// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.DialogInterface;

final class ickListener
    implements android.content.terface.OnClickListener
{

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.cancel();
    }

    ickListener()
    {
    }
}
