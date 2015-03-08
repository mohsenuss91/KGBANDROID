// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus;

import com.google.android.gms.internal.hn;
import java.util.HashSet;
import java.util.Set;

public final class Builder
    implements com.google.android.gms.common.api.tional
{

    final String abo;
    final Set abp;

    public static Builder builder()
    {
        return new Builder();
    }

    private Builder()
    {
        abo = null;
        abp = new HashSet();
    }

    abp(abp abp1)
    {
        this();
    }

    private Builder(Builder builder1)
    {
        class Builder
        {

            String abo;
            final Set abp = new HashSet();

            public final transient Builder addActivityTypes(String as[])
            {
                hn.b(as, "activityTypes may not be null.");
                for (int i = 0; i < as.length; i++)
                {
                    abp.add(as[i]);
                }

                return this;
            }

            public final Plus.PlusOptions build()
            {
                return new Plus.PlusOptions(this, null);
            }

            public final Builder setServerClientId(String s)
            {
                abo = s;
                return this;
            }

            public Builder()
            {
            }
        }

        abo = builder1.abo;
        abp = builder1.abp;
    }

    Builder(Builder builder1, Builder builder2)
    {
        this(builder1);
    }
}
