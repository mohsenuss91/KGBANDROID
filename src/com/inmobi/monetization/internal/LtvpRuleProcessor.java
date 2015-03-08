// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;

import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.abstraction.IGetLtvpRuleRequestListener;
import com.inmobi.monetization.internal.objects.LtvpRuleCache;
import java.util.HashMap;

// Referenced classes of package com.inmobi.monetization.internal:
//            ServiceProvider, GetLtvpRulesRequest, GetLtvpRulesResponse, LtvpErrorCode

public class LtvpRuleProcessor
    implements IGetLtvpRuleRequestListener
{

    private ServiceProvider a;

    private LtvpRuleProcessor()
    {
        a = ServiceProvider.getInstance();
    }

    public static LtvpRuleProcessor getInstance()
    {
        return new LtvpRuleProcessor();
    }

    public void dispatchLtvpRule()
    {
        Log.internal("[InMobi]-[Monetization]", "Fetching LTVP Rule");
        GetLtvpRulesRequest getltvprulesrequest = new GetLtvpRulesRequest();
        a.getLtvpRule(getltvprulesrequest, this);
    }

    public ActionsRule getLtvpRuleConfig(long l)
    {
        ActionsRule.MEDIATION.getValue();
        LtvpRuleCache ltvprulecache = LtvpRuleCache.getInstance(InternalSDKUtil.getContext());
        if (ltvprulecache.getHardExpiryForLtvpRule() <= System.currentTimeMillis() || ltvprulecache.getHardExpiryForLtvpRule() == 0L)
        {
            Log.internal("[InMobi]-[Monetization]", "Hard Expiry or 1st rule fetch. Default mediation. Fetching Rule");
            dispatchLtvpRule();
            ltvprulecache.clearLtvpRuleCache();
            return ActionsRule.MEDIATION;
        }
        int i;
        if (ltvprulecache.getSoftExpiryForLtvpRule() <= System.currentTimeMillis())
        {
            Log.internal("[InMobi]-[Monetization]", "Soft Expiry. Default mediation. Fetching Rule");
            dispatchLtvpRule();
            i = ltvprulecache.getLtvpRule(l);
        } else
        {
            Log.internal("[InMobi]-[Monetization]", "Valid rule");
            i = ltvprulecache.getLtvpRule(l);
        }
        return ActionsRule.a(i);
    }

    public void onLtvpGetRuleFailed(GetLtvpRulesRequest getltvprulesrequest, LtvpErrorCode ltvperrorcode)
    {
        Log.internal("[InMobi]-[Monetization]", (new StringBuilder("Ltvp Rule error")).append(ltvperrorcode.toString()).toString());
    }

    public void onLtvpGetRuleSucceeded(GetLtvpRulesRequest getltvprulesrequest, GetLtvpRulesResponse getltvprulesresponse)
    {
        Log.internal("[InMobi]-[Monetization]", (new StringBuilder("Ltvp Rule received")).append(getltvprulesresponse.getRules().toString()).toString());
        LtvpRuleCache.getInstance(InternalSDKUtil.getContext()).setLtvpRuleConfig(getltvprulesresponse);
    }

    private class ActionsRule extends Enum
    {

        public static final ActionsRule ACTIONS_ONLY;
        public static final ActionsRule ACTIONS_TO_MEDIATION;
        public static final ActionsRule MEDIATION;
        public static final ActionsRule NO_ADS;
        private static final ActionsRule b[];
        int a;

        static ActionsRule a(int i)
        {
            switch (i)
            {
            default:
                return MEDIATION;

            case 1: // '\001'
                return NO_ADS;

            case 2: // '\002'
                return ACTIONS_TO_MEDIATION;

            case 3: // '\003'
                return ACTIONS_ONLY;
            }
        }

        public static ActionsRule valueOf(String s)
        {
            return (ActionsRule)Enum.valueOf(com/inmobi/monetization/internal/LtvpRuleProcessor$ActionsRule, s);
        }

        public static ActionsRule[] values()
        {
            return (ActionsRule[])b.clone();
        }

        public final int getValue()
        {
            return a;
        }

        static 
        {
            MEDIATION = new ActionsRule("MEDIATION", 0, 0);
            NO_ADS = new ActionsRule("NO_ADS", 1, 1);
            ACTIONS_TO_MEDIATION = new ActionsRule("ACTIONS_TO_MEDIATION", 2, 2);
            ACTIONS_ONLY = new ActionsRule("ACTIONS_ONLY", 3, 3);
            ActionsRule aactionsrule[] = new ActionsRule[4];
            aactionsrule[0] = MEDIATION;
            aactionsrule[1] = NO_ADS;
            aactionsrule[2] = ACTIONS_TO_MEDIATION;
            aactionsrule[3] = ACTIONS_ONLY;
            b = aactionsrule;
        }

        private ActionsRule(String s, int i, int j)
        {
            super(s, i);
            a = j;
        }
    }

}
