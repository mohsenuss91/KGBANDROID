// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.thinICE.icedatacollector;


public class ThinICEConfigSettings
{

    public static final int CELL_OP_FLAG_DISABLE_CURRENT_DETAILS = 2;
    public static final int CELL_OP_FLAG_DISABLE_SIM_DETAILS = 1;
    public static final int WIFI_FLAG_DISABLE_NOMAP_EXCLUSION = 2;
    public static final int WIFI_FLAG_DISABLE_SSID_COLLECTION = 1;
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private long g;
    private long h;
    private int i;
    private int j;
    private int k;

    public ThinICEConfigSettings()
    {
        a = true;
        b = true;
        c = true;
        d = true;
        e = true;
        f = true;
        g = 60000L;
        h = 3000L;
        i = 50;
        j = 0;
        k = 0;
    }

    public ThinICEConfigSettings(ThinICEConfigSettings thiniceconfigsettings)
    {
        a = true;
        b = true;
        c = true;
        d = true;
        e = true;
        f = true;
        g = 60000L;
        h = 3000L;
        i = 50;
        j = 0;
        k = 0;
        a = thiniceconfigsettings.a;
        b = thiniceconfigsettings.b;
        c = thiniceconfigsettings.c;
        d = thiniceconfigsettings.d;
        e = thiniceconfigsettings.e;
        f = thiniceconfigsettings.f;
        g = thiniceconfigsettings.g;
        h = thiniceconfigsettings.h;
        i = thiniceconfigsettings.i;
        j = thiniceconfigsettings.j;
        k = thiniceconfigsettings.k;
    }

    public static boolean bitTest(int l, int i1)
    {
        return (l & i1) == i1;
    }

    public int getCellOpFlags()
    {
        return k;
    }

    public int getSampleHistorySize()
    {
        return i;
    }

    public long getSampleInterval()
    {
        return g;
    }

    public long getStopRequestTimeout()
    {
        return h;
    }

    public int getWifiFlags()
    {
        return j;
    }

    public boolean isEnabled()
    {
        return a;
    }

    public boolean isSampleCellEnabled()
    {
        return c;
    }

    public boolean isSampleCellOperatorEnabled()
    {
        return b;
    }

    public boolean isSampleConnectedWifiEnabled()
    {
        return d;
    }

    public boolean isSampleLocationEnabled()
    {
        return e;
    }

    public boolean isSampleVisibleWifiEnabled()
    {
        return f;
    }

    public ThinICEConfigSettings setCellOpFlags(int l)
    {
        k = l;
        return this;
    }

    public ThinICEConfigSettings setEnabled(boolean flag)
    {
        a = flag;
        return this;
    }

    public ThinICEConfigSettings setSampleCellEnabled(boolean flag)
    {
        c = flag;
        return this;
    }

    public ThinICEConfigSettings setSampleCellOperatorEnabled(boolean flag)
    {
        b = flag;
        return this;
    }

    public ThinICEConfigSettings setSampleConnectedWifiEnabled(boolean flag)
    {
        d = flag;
        return this;
    }

    public ThinICEConfigSettings setSampleHistorySize(int l)
    {
        if (l <= 0)
        {
            throw new IllegalArgumentException("Sample history size must be greater than 0");
        } else
        {
            i = l;
            return this;
        }
    }

    public ThinICEConfigSettings setSampleInterval(long l)
    {
        if (l <= 0L)
        {
            throw new IllegalArgumentException("Sample interval must be greater than 0");
        } else
        {
            g = l;
            return this;
        }
    }

    public ThinICEConfigSettings setSampleLocationEnabled(boolean flag)
    {
        e = flag;
        return this;
    }

    public ThinICEConfigSettings setSampleVisibleWifiEnabled(boolean flag)
    {
        f = flag;
        return this;
    }

    public ThinICEConfigSettings setStopRequestTimeout(long l)
    {
        if (l <= 0L)
        {
            throw new IllegalArgumentException("Stop request timeout must be greater than 0");
        } else
        {
            h = l;
            return this;
        }
    }

    public ThinICEConfigSettings setWifiFlags(int l)
    {
        j = l;
        return this;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(getClass().getSimpleName()).append("[");
        stringbuilder.append("mEnabled=").append(a).append(", ");
        stringbuilder.append("mSampleCellOperatorEnabled=").append(b).append(", ");
        stringbuilder.append("mSampleCellEnabled=").append(c).append(", ");
        stringbuilder.append("mSampleConnectedWifiEnabled=").append(d).append(", ");
        stringbuilder.append("mSampleLocationEnabled=").append(e).append(", ");
        stringbuilder.append("mSampleVisibleWifiEnabled=").append(f).append(", ");
        stringbuilder.append("mSampleInterval=").append(g).append(", ");
        stringbuilder.append("mStopRequestTimeout=").append(h).append(", ");
        stringbuilder.append("mWifiFlags=").append(Integer.toBinaryString(j)).append(", ");
        stringbuilder.append("mCellOpFlags=").append(Integer.toBinaryString(k));
        stringbuilder.append("]");
        return stringbuilder.toString();
    }
}
