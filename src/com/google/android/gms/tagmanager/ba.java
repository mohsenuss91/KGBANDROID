// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.tagmanager:
//            m, dh

class ba
{

    public static cq.c bY(String s)
    {
        com.google.android.gms.internal.d.a a = k(new JSONObject(s));
        cq.d d = cq.c.mm();
        for (int i = 0; i < a.fP.length; i++)
        {
            d.a(cq.a.mi().b(b.cI.toString(), a.fP[i]).b(b.cx.toString(), dh.cp(m.lf())).b(m.lg(), a.fQ[i]).ml());
        }

        return d.mp();
    }

    private static com.google.android.gms.internal.d.a k(Object obj)
    {
        return dh.r(l(obj));
    }

    static Object l(Object obj)
    {
        if (obj instanceof JSONArray)
        {
            throw new RuntimeException("JSONArrays are not supported");
        }
        if (JSONObject.NULL.equals(obj))
        {
            throw new RuntimeException("JSON nulls are not supported");
        }
        if (obj instanceof JSONObject)
        {
            JSONObject jsonobject = (JSONObject)obj;
            HashMap hashmap = new HashMap();
            String s;
            for (Iterator iterator = jsonobject.keys(); iterator.hasNext(); hashmap.put(s, l(jsonobject.get(s))))
            {
                s = (String)iterator.next();
            }

            obj = hashmap;
        }
        return obj;
    }
}
