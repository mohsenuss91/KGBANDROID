// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.ir;
import com.google.android.gms.internal.it;
import java.util.Date;

public final class MetadataChangeSet
{

    public static final MetadataChangeSet HS = new MetadataChangeSet(MetadataBundle.gA());
    private final MetadataBundle HT;

    public MetadataChangeSet(MetadataBundle metadatabundle)
    {
        HT = MetadataBundle.a(metadatabundle);
    }

    public final String getDescription()
    {
        return (String)HT.a(ir.JT);
    }

    public final String getIndexableText()
    {
        return (String)HT.a(ir.JY);
    }

    public final Date getLastViewedByMeDate()
    {
        return (Date)HT.a(it.Ku);
    }

    public final String getMimeType()
    {
        return (String)HT.a(ir.Kh);
    }

    public final String getTitle()
    {
        return (String)HT.a(ir.Ko);
    }

    public final MetadataBundle gh()
    {
        return HT;
    }

    public final Boolean isPinned()
    {
        return (Boolean)HT.a(ir.Kc);
    }

    public final Boolean isStarred()
    {
        return (Boolean)HT.a(ir.Km);
    }

    public final Boolean isViewed()
    {
        return (Boolean)HT.a(ir.Kg);
    }

}
