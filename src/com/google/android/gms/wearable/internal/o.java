// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable.internal;

import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.wearable.DataItem;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.wearable.internal:
//            k, l

public final class o extends d
    implements DataItem
{

    private final int RD;

    public o(DataHolder dataholder, int i, int j)
    {
        super(dataholder, i);
        RD = j;
    }

    public final Object freeze()
    {
        return nm();
    }

    public final Map getAssets()
    {
        HashMap hashmap = new HashMap(RD);
        for (int i = 0; i < RD; i++)
        {
            k k1 = new k(DD, i + Ez);
            if (k1.getDataItemKey() != null)
            {
                hashmap.put(k1.getDataItemKey(), k1);
            }
        }

        return hashmap;
    }

    public final byte[] getData()
    {
        return getByteArray("data");
    }

    public final Uri getUri()
    {
        return Uri.parse(getString("path"));
    }

    public final DataItem nm()
    {
        return new l(this);
    }

    public final DataItem setData(byte abyte0[])
    {
        throw new UnsupportedOperationException();
    }
}
