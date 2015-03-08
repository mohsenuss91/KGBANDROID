// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a;

import com.google.a.b.s;
import com.google.a.c.a;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.a:
//            af, d, a, ai, 
//            k, j

public final class r
{

    public String a;
    private s b;
    private af c;
    private j d;
    private final Map e = new HashMap();
    private final List f = new ArrayList();
    private final List g = new ArrayList();
    private boolean h;
    private int i;
    private int j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;

    public r()
    {
        b = s.a;
        c = com.google.a.af.a;
        d = com.google.a.d.a;
        i = 2;
        j = 2;
        m = true;
    }

    public final k a()
    {
        ArrayList arraylist;
        String s1;
        int i1;
        int j1;
        arraylist = new ArrayList();
        arraylist.addAll(f);
        Collections.reverse(arraylist);
        arraylist.addAll(g);
        s1 = a;
        i1 = i;
        j1 = j;
        if (s1 == null || "".equals(s1.trim())) goto _L2; else goto _L1
_L1:
        com.google.a.a a1 = new com.google.a.a(s1);
_L6:
        arraylist.add(com.google.a.ai.a(com.google.a.c.a.a(java/util/Date), a1));
        arraylist.add(com.google.a.ai.a(com.google.a.c.a.a(java/sql/Timestamp), a1));
        arraylist.add(com.google.a.ai.a(com.google.a.c.a.a(java/sql/Date), a1));
_L4:
        return new k(b, d, e, h, k, o, m, n, l, c, arraylist);
_L2:
        if (i1 == 2 || j1 == 2) goto _L4; else goto _L3
_L3:
        a1 = new com.google.a.a(i1, j1);
        if (true) goto _L6; else goto _L5
_L5:
    }
}
