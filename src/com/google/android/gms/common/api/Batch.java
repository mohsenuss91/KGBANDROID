// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.Looper;
import java.util.List;

// Referenced classes of package com.google.android.gms.common.api:
//            PendingResult, BatchResult, Status, Result

public final class Batch extends a.a
{

    private int Dw;
    private boolean Dx;
    private boolean Dy;
    private final PendingResult Dz[];
    private final Object lq;

    private Batch(List list, Looper looper)
    {
        super(new a.c(looper));
        lq = new Object();
        Dw = list.size();
        Dz = new PendingResult[Dw];
        for (int i = 0; i < list.size(); i++)
        {
            PendingResult pendingresult = (PendingResult)list.get(i);
            Dz[i] = pendingresult;
            pendingresult.a(new _cls1());
        }

    }

    Batch(List list, Looper looper, _cls1 _pcls1)
    {
        this(list, looper);
    }

    static Object a(Batch batch)
    {
        return batch.lq;
    }

    static boolean a(Batch batch, boolean flag)
    {
        batch.Dy = flag;
        return flag;
    }

    static int b(Batch batch)
    {
        int i = batch.Dw;
        batch.Dw = i - 1;
        return i;
    }

    static boolean b(Batch batch, boolean flag)
    {
        batch.Dx = flag;
        return flag;
    }

    static int c(Batch batch)
    {
        return batch.Dw;
    }

    static boolean d(Batch batch)
    {
        return batch.Dy;
    }

    static void e(Batch batch)
    {
        batch.a.a.cancel();
    }

    static boolean f(Batch batch)
    {
        return batch.Dx;
    }

    static PendingResult[] g(Batch batch)
    {
        return batch.Dz;
    }

    public final Result c(Status status)
    {
        return createFailedResult(status);
    }

    public final void cancel()
    {
        super.cancel();
        PendingResult apendingresult[] = Dz;
        int i = apendingresult.length;
        for (int j = 0; j < i; j++)
        {
            apendingresult[j].cancel();
        }

    }

    public final BatchResult createFailedResult(Status status)
    {
        return new BatchResult(status, Dz);
    }

    private class _cls1
        implements PendingResult.a
    {

        final Batch DA;

        public void n(Status status)
        {
label0:
            {
                synchronized (Batch.a(DA))
                {
                    if (!DA.isCanceled())
                    {
                        break label0;
                    }
                }
                return;
            }
            if (!status.isCanceled()) goto _L2; else goto _L1
_L1:
            Batch.a(DA, true);
_L8:
            Batch.b(DA);
            if (Batch.c(DA) != 0) goto _L4; else goto _L3
_L3:
            if (!Batch.d(DA)) goto _L6; else goto _L5
_L5:
            Batch.e(DA);
_L4:
            obj;
            JVM INSTR monitorexit ;
            return;
_L2:
            if (status.isSuccess()) goto _L8; else goto _L7
_L7:
            Batch.b(DA, true);
              goto _L8
_L6:
            Status status1;
            if (!Batch.f(DA))
            {
                break MISSING_BLOCK_LABEL_148;
            }
            status1 = new Status(13);
_L9:
            DA.b(new BatchResult(status1, Batch.g(DA)));
              goto _L4
            status1 = Status.Ek;
              goto _L9
        }

        _cls1()
        {
            DA = Batch.this;
            super();
        }
    }

}
