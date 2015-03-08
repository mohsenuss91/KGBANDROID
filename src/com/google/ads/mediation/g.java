// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation;

import com.google.android.gms.internal.ev;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.ads.mediation:
//            i, h

public abstract class g
{

    public g()
    {
    }

    protected void a()
    {
    }

    public void load(Map map)
    {
        HashMap hashmap = new HashMap();
        Field afield[] = getClass().getFields();
        int j = afield.length;
        for (int k = 0; k < j; k++)
        {
            Field field2 = afield[k];
            i l = (i)field2.getAnnotation(com/google/ads/mediation/i);
            if (l != null)
            {
                hashmap.put(l.a(), field2);
            }
        }

        if (hashmap.isEmpty())
        {
            ev.D("No server options fields detected. To suppress this message either add a field with the @Parameter annotation, or override the load() method.");
        }
        for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            Field field1 = (Field)hashmap.remove(entry.getKey());
            if (field1 != null)
            {
                try
                {
                    field1.set(this, entry.getValue());
                }
                catch (IllegalAccessException illegalaccessexception)
                {
                    ev.D((new StringBuilder("Server option \"")).append((String)entry.getKey()).append("\" could not be set: Illegal Access").toString());
                }
                catch (IllegalArgumentException illegalargumentexception)
                {
                    ev.D((new StringBuilder("Server option \"")).append((String)entry.getKey()).append("\" could not be set: Bad Type").toString());
                }
            } else
            {
                ev.z((new StringBuilder("Unexpected server option: ")).append((String)entry.getKey()).append(" = \"").append((String)entry.getValue()).append("\"").toString());
            }
        }

        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator1 = hashmap.values().iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            Field field = (Field)iterator1.next();
            if (((i)field.getAnnotation(com/google/ads/mediation/i)).b())
            {
                ev.D((new StringBuilder("Required server option missing: ")).append(((i)field.getAnnotation(com/google/ads/mediation/i)).a()).toString());
                if (stringbuilder.length() > 0)
                {
                    stringbuilder.append(", ");
                }
                stringbuilder.append(((i)field.getAnnotation(com/google/ads/mediation/i)).a());
            }
        } while (true);
        if (stringbuilder.length() > 0)
        {
            throw new h((new StringBuilder("Required server option(s) missing: ")).append(stringbuilder.toString()).toString());
        } else
        {
            a();
            return;
        }
    }
}
