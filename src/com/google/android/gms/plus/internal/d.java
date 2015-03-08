// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.internal.hh;
import com.google.android.gms.internal.hs;
import com.google.android.gms.internal.if;
import java.util.List;

// Referenced classes of package com.google.android.gms.plus.internal:
//            b

public interface d
    extends IInterface
{

    public abstract hh a(b b1, int i, int j, int k, String s);

    public abstract void a(if if1);

    public abstract void a(b b1);

    public abstract void a(b b1, int i, String s, Uri uri, String s1, String s2);

    public abstract void a(b b1, Uri uri, Bundle bundle);

    public abstract void a(b b1, if if1);

    public abstract void a(b b1, String s);

    public abstract void a(b b1, String s, String s1);

    public abstract void a(b b1, List list);

    public abstract void a(String s, hs hs, hs hs1);

    public abstract void b(b b1);

    public abstract void b(b b1, String s);

    public abstract void c(b b1, String s);

    public abstract void clearDefaultAccount();

    public abstract void d(b b1, String s);

    public abstract void e(b b1, String s);

    public abstract String getAccountName();

    public abstract String jP();

    public abstract boolean jQ();

    public abstract String jR();

    public abstract void removeMoment(String s);
}
