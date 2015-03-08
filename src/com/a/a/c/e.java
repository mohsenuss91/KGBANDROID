// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.c;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.IOException;

// Referenced classes of package com.a.a.c:
//            d

public final class e
{

    public static File a(Context context)
    {
        boolean flag = "mounted".equals(Environment.getExternalStorageState());
        File file = null;
        if (flag)
        {
            boolean flag1;
            if (context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            file = null;
            if (flag1)
            {
                file = c(context);
            }
        }
        if (file == null)
        {
            file = context.getCacheDir();
        }
        if (file == null)
        {
            d.c("Can't define system cache directory! The app should be re-installed.", new Object[0]);
        }
        return file;
    }

    public static File b(Context context)
    {
        File file = a(context);
        File file1 = new File(file, "uil-images");
        if (!file1.exists() && !file1.mkdir())
        {
            return file;
        } else
        {
            return file1;
        }
    }

    private static File c(Context context)
    {
        File file;
label0:
        {
            file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
            if (!file.exists())
            {
                if (file.mkdirs())
                {
                    break label0;
                }
                d.c("Unable to create external cache directory", new Object[0]);
                file = null;
            }
            return file;
        }
        try
        {
            (new File(file, ".nomedia")).createNewFile();
        }
        catch (IOException ioexception)
        {
            d.b("Can't create \".nomedia\" file in application external cache directory", new Object[0]);
            return file;
        }
        return file;
    }
}
