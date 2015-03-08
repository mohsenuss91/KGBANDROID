// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.internal.hn;

// Referenced classes of package com.google.android.gms.cast:
//            CastDevice

public final class Builder
    implements com.google.android.gms.common.api.sOptions
{

    final CastDevice zX;
    final Builder zY;
    private final int zZ;

    static int a(ons.HasOptions hasoptions)
    {
        return hasoptions.zZ;
    }

    public static Builder builder(CastDevice castdevice, zZ zz)
    {
        return new Builder(castdevice, zz, null);
    }

    private Builder(Builder builder1)
    {
        class Builder
        {

            CastDevice Aa;
            Cast.Listener Ab;
            private int Ac;

            static int a(Builder builder2)
            {
                return builder2.Ac;
            }

            public final Cast.CastOptions build()
            {
                return new Cast.CastOptions(this, null);
            }

            public final Builder setVerboseLoggingEnabled(boolean flag)
            {
                if (flag)
                {
                    Ac = 1 | Ac;
                    return this;
                } else
                {
                    Ac = -2 & Ac;
                    return this;
                }
            }

            private Builder(CastDevice castdevice, Cast.Listener listener)
            {
                hn.b(castdevice, "CastDevice parameter cannot be null");
                hn.b(listener, "CastListener parameter cannot be null");
                Aa = castdevice;
                Ab = listener;
                Ac = 0;
            }

            Builder(CastDevice castdevice, Cast.Listener listener, Cast._cls1 _pcls1)
            {
                this(castdevice, listener);
            }
        }

        zX = builder1.Aa;
        zY = builder1.Ab;
        zZ = Builder.a(builder1);
    }

    Builder(Builder builder1, Builder builder2)
    {
        this(builder1);
    }
}
