// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import java.util.Arrays;

final class afe
{

    public final String JI;
    public final Object afe;

    public final boolean equals(Object obj)
    {
        afe afe1;
        if (obj instanceof afe)
        {
            if (JI.equals((afe1 = (JI)obj).JI) && afe.equals(afe1.afe))
            {
                return true;
            }
        }
        return false;
    }

    public final int hashCode()
    {
        Integer ainteger[] = new Integer[2];
        ainteger[0] = Integer.valueOf(JI.hashCode());
        ainteger[1] = Integer.valueOf(afe.hashCode());
        return Arrays.hashCode(ainteger);
    }

    public final String toString()
    {
        return (new StringBuilder("Key: ")).append(JI).append(" value: ").append(afe.toString()).toString();
    }

    (String s, Object obj)
    {
        JI = s;
        afe = obj;
    }
}
