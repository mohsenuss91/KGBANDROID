// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.a.g;
import java.io.FileDescriptor;
import java.io.PrintWriter;

// Referenced classes of package android.support.v4.app:
//            LoaderManagerImpl

public abstract class LoaderManager
{

    public LoaderManager()
    {
    }

    public static void enableDebugLogging(boolean flag)
    {
        LoaderManagerImpl.DEBUG = flag;
    }

    public abstract void destroyLoader(int i);

    public abstract void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[]);

    public abstract g getLoader(int i);

    public boolean hasRunningLoaders()
    {
        return false;
    }

    public abstract g initLoader(int i, Bundle bundle, LoaderCallbacks loadercallbacks);

    public abstract g restartLoader(int i, Bundle bundle, LoaderCallbacks loadercallbacks);
}
