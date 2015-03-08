// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.hn;
import java.util.HashMap;
import java.util.Set;

public final class RequestUpdateOutcomes
{

    private static final String Sk[] = {
        "requestId", "outcome"
    };
    private final int CQ;
    private final HashMap Sl;

    private RequestUpdateOutcomes(int i, HashMap hashmap)
    {
        CQ = i;
        Sl = hashmap;
    }

    RequestUpdateOutcomes(int i, HashMap hashmap, _cls1 _pcls1)
    {
        this(i, hashmap);
    }

    public static RequestUpdateOutcomes U(DataHolder dataholder)
    {
        Builder builder = new Builder();
        builder.cw(dataholder.getStatusCode());
        int i = dataholder.getCount();
        for (int j = 0; j < i; j++)
        {
            int k = dataholder.ae(j);
            builder.v(dataholder.c("requestId", j, k), dataholder.b("outcome", j, k));
        }

        return builder.it();
    }

    public final Set getRequestIds()
    {
        return Sl.keySet();
    }

    public final int getRequestOutcome(String s)
    {
        hn.b(Sl.containsKey(s), (new StringBuilder("Request ")).append(s).append(" was not part of the update operation!").toString());
        return ((Integer)Sl.get(s)).intValue();
    }


    private class Builder
    {

        private int CQ;
        private HashMap Sl;

        public final Builder cw(int i)
        {
            CQ = i;
            return this;
        }

        public final RequestUpdateOutcomes it()
        {
            return new RequestUpdateOutcomes(CQ, Sl, null);
        }

        public final Builder v(String s, int i)
        {
            if (RequestUpdateResultOutcome.isValid(i))
            {
                Sl.put(s, Integer.valueOf(i));
            }
            return this;
        }

        public Builder()
        {
            Sl = new HashMap();
            CQ = 0;
        }
    }

}
