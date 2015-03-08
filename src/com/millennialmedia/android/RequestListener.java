// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            MMAd, MMException

public interface RequestListener
{

    public abstract void MMAdOverlayLaunched(MMAd mmad);

    public abstract void MMAdRequestIsCaching(MMAd mmad);

    public abstract void requestCompleted(MMAd mmad);

    public abstract void requestFailed(MMAd mmad, MMException mmexception);
}
