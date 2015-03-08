// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk.impl.imai;

import com.inmobi.androidsdk.bootstrapper.ConfigParams;
import com.inmobi.androidsdk.bootstrapper.IMAIConfigParams;
import com.inmobi.androidsdk.bootstrapper.Initializer;
import com.inmobi.androidsdk.impl.imai.db.ClickData;
import com.inmobi.androidsdk.impl.imai.db.ClickDatabaseManager;
import com.inmobi.androidsdk.impl.net.RequestResponseManager;
import com.inmobi.commons.internal.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public class IMAIClickEventList extends ArrayList
{

    private static final long serialVersionUID = 0xfd0f9c6d52a71745L;

    public IMAIClickEventList()
    {
    }

    public static IMAIClickEventList getLoggedClickEvents()
    {
        com/inmobi/androidsdk/impl/imai/IMAIClickEventList;
        JVM INSTR monitorenter ;
        int i = ClickDatabaseManager.getInstance().getNoOfEvents();
        IMAIClickEventList imaiclickeventlist;
        imaiclickeventlist = null;
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        IMAIClickEventList imaiclickeventlist1;
        ArrayList arraylist;
        int j = Initializer.getConfigParams().getImai().getmDefaultEventsBatch();
        ClickDatabaseManager.getInstance().setDBLimit(Initializer.getConfigParams().getImai().getmMaxDb());
        imaiclickeventlist1 = ClickDatabaseManager.getInstance().getClickEvents(j);
        arraylist = new ArrayList();
        for (Iterator iterator = imaiclickeventlist1.iterator(); iterator.hasNext(); arraylist.add(Long.valueOf(((ClickData)iterator.next()).getClickId()))) { }
        break MISSING_BLOCK_LABEL_107;
        Exception exception;
        exception;
        throw exception;
        ClickDatabaseManager.getInstance().deleteClickEvents(arraylist);
        imaiclickeventlist = imaiclickeventlist1;
        if (imaiclickeventlist == null)
        {
            break MISSING_BLOCK_LABEL_128;
        }
_L1:
        com/inmobi/androidsdk/impl/imai/IMAIClickEventList;
        JVM INSTR monitorexit ;
        return imaiclickeventlist;
        imaiclickeventlist = new IMAIClickEventList();
          goto _L1
    }

    public ClickData getClickEvent(long l)
    {
        Iterator iterator = iterator();
_L1:
        ClickData clickdata;
        long l1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_56;
        }
        clickdata = (ClickData)iterator.next();
        l1 = clickdata.getClickId();
        if (l1 == l)
        {
            return clickdata;
        }
          goto _L1
        Exception exception;
        exception;
        Log.internal("[InMobi]-[Network]-4.4.1", "Cant get click event", exception);
        return null;
        return null;
    }

    public void reduceRetryCount(int i)
    {
        this;
        JVM INSTR monitorenter ;
        ClickData clickdata;
        int j;
        RequestResponseManager.isSynced.set(false);
        clickdata = getClickEvent(i);
        j = clickdata.getRetryCount();
        removeClickEvent(i);
        if (j <= 1)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        clickdata.setRetryCount(-1 + clickdata.getRetryCount());
        add(clickdata);
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception1;
        exception1;
        Log.internal("[InMobi]-[Network]-4.4.1", "Cant reduce retry count", exception1);
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    public boolean removeClickEvent(long l)
    {
        this;
        JVM INSTR monitorenter ;
        RequestResponseManager.isSynced.set(false);
        remove(getClickEvent(l));
        boolean flag = true;
_L2:
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception1;
        exception1;
        Log.internal("[InMobi]-[Network]-4.4.1", "Cant remove click event", exception1);
        flag = false;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    public void saveClickEvents()
    {
        Log.internal("[InMobi]-[Network]-4.4.1", "Save ping events");
        if (RequestResponseManager.mDBWriterQueue != null && !RequestResponseManager.mDBWriterQueue.isEmpty())
        {
            ClickData clickdata;
            for (Iterator iterator = RequestResponseManager.mDBWriterQueue.iterator(); iterator.hasNext(); ClickDatabaseManager.getInstance().insertClick(clickdata))
            {
                clickdata = (ClickData)iterator.next();
            }

        }
    }
}
