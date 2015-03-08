// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container;

import com.inmobi.re.container.mraidimpl.ResizeDimensions;
import java.util.Map;

public interface _cls9
{

    public abstract void onDismissAdScreen();

    public abstract void onError();

    public abstract void onExpand();

    public abstract void onExpandClose();

    public abstract void onIncentCompleted(Map map);

    public abstract void onLeaveApplication();

    public abstract void onResize(ResizeDimensions resizedimensions);

    public abstract void onResizeClose();

    public abstract void onShowAdScreen();

    public abstract void onUserInteraction(Map map);
}
