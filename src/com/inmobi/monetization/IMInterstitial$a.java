// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;


class Processor.ActionsRule
{

    static final int a[];

    static 
    {
        a = new int[com.inmobi.monetization.internal..ActionsRule.values().length];
        try
        {
            a[com.inmobi.monetization.internal..ActionsRule.ACTIONS_TO_MEDIATION.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        try
        {
            a[com.inmobi.monetization.internal..ActionsRule.ACTIONS_ONLY.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[com.inmobi.monetization.internal..ActionsRule.MEDIATION.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[com.inmobi.monetization.internal..ActionsRule.NO_ADS.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror3)
        {
            return;
        }
    }
}
