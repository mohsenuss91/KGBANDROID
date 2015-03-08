// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;


// Referenced classes of package com.google.analytics.tracking.android:
//            ClientIdDefaultProvider

class this._cls0 extends Thread
{

    final ClientIdDefaultProvider this$0;

    public void run()
    {
        synchronized (ClientIdDefaultProvider.access$000(ClientIdDefaultProvider.this))
        {
            ClientIdDefaultProvider.access$102(ClientIdDefaultProvider.this, initializeClientId());
            ClientIdDefaultProvider.access$202(ClientIdDefaultProvider.this, true);
            ClientIdDefaultProvider.access$000(ClientIdDefaultProvider.this).notifyAll();
        }
    }

    (String s)
    {
        this$0 = ClientIdDefaultProvider.this;
        super(s);
    }
}
