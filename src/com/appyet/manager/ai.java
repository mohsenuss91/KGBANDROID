// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import java.io.File;
import java.util.Comparator;

// Referenced classes of package com.appyet.manager:
//            af

final class ai
    implements Comparator
{

    final af a;

    ai(af af)
    {
        a = af;
        super();
    }

    public final int compare(Object obj, Object obj1)
    {
        File file = (File)obj;
        File file1 = (File)obj1;
        return Long.valueOf(file.length()).compareTo(Long.valueOf(file1.length()));
    }
}
