// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.plus.internal.e;
import java.util.Collection;

// Referenced classes of package com.google.android.gms.internal:
//            kn

class <init> extends <init>
{

    final kn ack;
    final Collection acl;

    protected volatile void a(com.google.android.gms.common.api. )
    {
        a((e));
    }

    protected void a(e e1)
    {
        e1.a(this, acl);
    }

    e(kn kn, Collection collection)
    {
        ack = kn;
        acl = collection;
        super(null);
    }
}
