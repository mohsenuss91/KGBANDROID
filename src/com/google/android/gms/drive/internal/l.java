// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class l extends Metadata
{

    private final MetadataBundle IF;

    public l(MetadataBundle metadatabundle)
    {
        IF = metadatabundle;
    }

    protected final Object a(MetadataField metadatafield)
    {
        return IF.a(metadatafield);
    }

    public final Object freeze()
    {
        return gg();
    }

    public final Metadata gg()
    {
        return new l(MetadataBundle.a(IF));
    }

    public final boolean isDataValid()
    {
        return IF != null;
    }

    public final String toString()
    {
        return (new StringBuilder("Metadata [mImpl=")).append(IF).append("]").toString();
    }
}
