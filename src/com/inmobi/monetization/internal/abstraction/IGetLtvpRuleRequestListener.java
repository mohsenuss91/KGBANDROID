// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal.abstraction;

import com.inmobi.monetization.internal.GetLtvpRulesRequest;
import com.inmobi.monetization.internal.GetLtvpRulesResponse;
import com.inmobi.monetization.internal.LtvpErrorCode;

public interface IGetLtvpRuleRequestListener
{

    public abstract void onLtvpGetRuleFailed(GetLtvpRulesRequest getltvprulesrequest, LtvpErrorCode ltvperrorcode);

    public abstract void onLtvpGetRuleSucceeded(GetLtvpRulesRequest getltvprulesrequest, GetLtvpRulesResponse getltvprulesresponse);
}
