// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestEntity;

final class ND extends b
    implements com.google.android.gms.games.quest.pl
{

    private final Quest ND = null;

    public final Quest getQuest()
    {
        return ND;
    }

    Q(DataHolder dataholder)
    {
        QuestBuffer questbuffer;
        super(dataholder);
        questbuffer = new QuestBuffer(dataholder);
        if (questbuffer.getCount() <= 0) goto _L2; else goto _L1
_L1:
        ND = new QuestEntity((Quest)questbuffer.get(0));
_L4:
        questbuffer.close();
        return;
_L2:
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        questbuffer.close();
        throw exception;
    }
}