// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestEntity;
import java.util.List;

final class ND extends b
    implements com.google.android.gms.games.quest.pl
{

    private final Quest ND;
    private final Milestone NF = null;

    public final Milestone getMilestone()
    {
        return NF;
    }

    public final Quest getQuest()
    {
        return ND;
    }

    (DataHolder dataholder, String s)
    {
        int i;
        QuestBuffer questbuffer;
        i = 0;
        super(dataholder);
        questbuffer = new QuestBuffer(dataholder);
        if (questbuffer.getCount() <= 0) goto _L2; else goto _L1
_L1:
        List list;
        int j;
        ND = new QuestEntity((Quest)questbuffer.get(0));
        list = ND.iE();
        j = list.size();
_L4:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!((Milestone)list.get(i)).getMilestoneId().equals(s))
        {
            break MISSING_BLOCK_LABEL_115;
        }
        NF = (Milestone)list.get(i);
        questbuffer.close();
        return;
        i++;
        if (true) goto _L4; else goto _L3
_L3:
_L6:
        questbuffer.close();
        return;
_L2:
        NF = null;
        ND = null;
        if (true) goto _L6; else goto _L5
_L5:
        Exception exception;
        exception;
        questbuffer.close();
        throw exception;
    }
}
