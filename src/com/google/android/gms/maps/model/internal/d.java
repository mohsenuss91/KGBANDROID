// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model.internal;

import android.os.IInterface;
import java.util.List;

public interface d
    extends IInterface
{

    public abstract boolean b(d d1);

    public abstract int getActiveLevelIndex();

    public abstract int getDefaultLevelIndex();

    public abstract List getLevels();

    public abstract int hashCodeRemote();

    public abstract boolean isUnderground();
}
