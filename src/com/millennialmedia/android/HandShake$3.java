// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.widget.Toast;

// Referenced classes of package com.millennialmedia.android:
//            HandShake

class val.message
    implements Runnable
{

    final HandShake this$0;
    final Context val$context;
    final String val$message;

    public void run()
    {
        try
        {
            Toast.makeText(val$context, (new StringBuilder("Error: ")).append(val$message).toString(), 1).show();
            return;
        }
        catch (android.view.r.BadTokenException badtokenexception)
        {
            badtokenexception.printStackTrace();
        }
    }

    tion()
    {
        this$0 = final_handshake;
        val$context = context1;
        val$message = String.this;
        super();
    }
}
