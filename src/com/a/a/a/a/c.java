// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.a;

import com.a.a.a.a.b.a;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.a.a.a.a:
//            a, d

public abstract class c extends com.a.a.a.a.a
{

    final AtomicInteger b = new AtomicInteger();
    final Map c = Collections.synchronizedMap(new HashMap());
    private final int d;

    public c(File file, a a1, int i)
    {
        super(file, a1);
        d = i;
        (new Thread(new d(this))).start();
    }

    private int a()
    {
        File file = null;
        if (!c.isEmpty()) goto _L2; else goto _L1
_L1:
        int i = -1;
_L5:
        return i;
_L2:
        Set set = c.entrySet();
        Map map = c;
        map;
        JVM INSTR monitorenter ;
        Iterator iterator = set.iterator();
        Long long1 = null;
_L3:
        java.util.Map.Entry entry;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_149;
        }
        entry = (java.util.Map.Entry)iterator.next();
        if (file != null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        File file1;
        Long long2;
        file1 = (File)entry.getKey();
        long2 = (Long)entry.getValue();
        file = file1;
        long1 = long2;
          goto _L3
        Long long3;
        File file2;
        long3 = (Long)entry.getValue();
        if (long3.longValue() < long1.longValue())
        {
            file2 = (File)entry.getKey();
            break MISSING_BLOCK_LABEL_220;
        }
        break MISSING_BLOCK_LABEL_213;
        map;
        JVM INSTR monitorexit ;
        i = 0;
        if (file == null) goto _L5; else goto _L4
_L4:
        if (!file.exists())
        {
            break MISSING_BLOCK_LABEL_200;
        }
        i = b(file);
        if (!file.delete()) goto _L5; else goto _L6
_L6:
        c.remove(file);
        return i;
        Exception exception;
        exception;
        throw exception;
        c.remove(file);
        return 0;
        file2 = file;
        long3 = long1;
        file = file2;
        long1 = long3;
          goto _L3
    }

    public final File a(String s)
    {
        File file = super.a(s);
        Long long1 = Long.valueOf(System.currentTimeMillis());
        file.setLastModified(long1.longValue());
        c.put(file, long1);
        return file;
    }

    public final void a(File file)
    {
        int i = b(file);
        int j = b.get();
        do
        {
            if (j + i <= d)
            {
                break;
            }
            int k = a();
            if (k == -1)
            {
                break;
            }
            j = b.addAndGet(-k);
        } while (true);
        b.addAndGet(i);
        Long long1 = Long.valueOf(System.currentTimeMillis());
        file.setLastModified(long1.longValue());
        c.put(file, long1);
    }

    protected abstract int b(File file);
}
