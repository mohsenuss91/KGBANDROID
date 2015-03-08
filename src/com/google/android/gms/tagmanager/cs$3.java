// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.tagmanager:
//            cm, ck, cs

class ahz
    implements ahz
{

    final cs ahv;
    final Map ahw;
    final Map ahx;
    final Map ahy;
    final Map ahz;

    public void a(ahz ahz1, Set set, Set set1, cm cm1)
    {
        List list = (List)ahw.get(ahz1);
        List list1 = (List)ahx.get(ahz1);
        if (list != null)
        {
            set.addAll(list);
            cm1.lP().b(list, list1);
        }
        List list2 = (List)ahy.get(ahz1);
        List list3 = (List)ahz.get(ahz1);
        if (list2 != null)
        {
            set1.addAll(list2);
            cm1.lQ().b(list2, list3);
        }
    }

    (cs cs, Map map, Map map1, Map map2, Map map3)
    {
        ahv = cs;
        ahw = map;
        ahx = map1;
        ahy = map2;
        ahz = map3;
        super();
    }
}
