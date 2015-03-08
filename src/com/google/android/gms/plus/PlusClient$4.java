// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus;

import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.plus:
//            PlusClient

class abt
    implements com.google.android.gms.common.api.LoadedListener
{

    final PlusClient abs;
    final PeopleLoadedListener abt;

    public void a(opleResult opleresult)
    {
        abt.onPeopleLoaded(opleresult.getStatus().eM(), opleresult.getPersonBuffer(), opleresult.getNextPageToken());
    }

    public volatile void a(Object obj)
    {
        a((opleResult)obj);
    }

    PeopleLoadedListener(PlusClient plusclient, PeopleLoadedListener peopleloadedlistener)
    {
        abs = plusclient;
        abt = peopleloadedlistener;
        super();
    }
}
