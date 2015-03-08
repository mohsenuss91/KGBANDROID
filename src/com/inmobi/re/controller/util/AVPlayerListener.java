// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.controller.util;


// Referenced classes of package com.inmobi.re.controller.util:
//            AVPlayer

public interface AVPlayerListener
{

    public abstract void onComplete(AVPlayer avplayer);

    public abstract void onError(AVPlayer avplayer);

    public abstract void onPrepared(AVPlayer avplayer);
}
