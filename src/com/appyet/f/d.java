// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.f;

import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// Referenced classes of package com.appyet.f:
//            a

final class d extends FutureTask
{

    final a a;

    d(a a1, Callable callable)
    {
        a = a1;
        super(callable);
    }

    protected final void done()
    {
        try
        {
            Object obj = get();
            com.appyet.f.a.b(a, obj);
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            Log.w("AsyncTask", interruptedexception);
            return;
        }
        catch (ExecutionException executionexception)
        {
            throw new RuntimeException("An error occured while executing doInBackground()", executionexception.getCause());
        }
        catch (CancellationException cancellationexception)
        {
            com.appyet.f.a.b(a, null);
        }
        catch (Throwable throwable)
        {
            throw new RuntimeException("An error occured while executing doInBackground()", throwable);
        }
    }
}
