// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.db;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.inmobi.commons.analytics.util.SessionInfo;
import com.inmobi.commons.internal.Log;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.analytics.db:
//            AnalyticsFunctions, AnalyticsEvent

public class FunctionTagTransaction extends AnalyticsFunctions
{

    private Context a;
    private Intent b;
    private Bundle c;

    public FunctionTagTransaction(Context context, Intent intent, Bundle bundle)
    {
        a = context;
        b = intent;
        c = bundle;
    }

    private AnalyticsEvent a()
    {
        if (SessionInfo.getSessionId(a) == null || b == null) goto _L2; else goto _L1
_L1:
        AnalyticsEvent analyticsevent;
        int i;
        String s;
        analyticsevent = new AnalyticsEvent("pi");
        i = b.getIntExtra("RESPONSE_CODE", 0);
        s = b.getStringExtra("INAPP_PURCHASE_DATA");
        if (i != 0) goto _L4; else goto _L3
_L3:
        JSONObject jsonobject;
        long l;
        jsonobject = new JSONObject(s);
        analyticsevent.setTransactionId(jsonobject.getString("orderId"));
        analyticsevent.setTransactionProductId(jsonobject.getString("productId"));
        l = jsonobject.getLong("purchaseTime");
        if (0L != l)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        l = System.currentTimeMillis();
        int j;
        analyticsevent.setEventTimeStamp(l / 1000L);
        j = jsonobject.getInt("purchaseState");
        if (AnalyticsEvent.TRANSACTION_STATUS_GOOGLE_API_VALUES.PURCHASED.getValue() != j) goto _L6; else goto _L5
_L5:
        int i1 = AnalyticsEvent.TRANSACTION_STATUS_SERVER_CODE.PURCHASED.getValue();
_L7:
        analyticsevent.setTransactionStatus(i1);
        AnalyticsEvent analyticsevent2 = a(analyticsevent);
        AnalyticsEvent analyticsevent1 = analyticsevent2;
        analyticsevent1.setEventSessionId(SessionInfo.getSessionId(a));
        analyticsevent1.setEventSessionTimeStamp(SessionInfo.getSessionTime(a));
        analyticsevent = analyticsevent1;
_L8:
        insertInDatabase(analyticsevent);
_L4:
        return analyticsevent;
_L6:
label0:
        {
            if (AnalyticsEvent.TRANSACTION_STATUS_GOOGLE_API_VALUES.FAILED.getValue() != j)
            {
                break label0;
            }
            i1 = AnalyticsEvent.TRANSACTION_STATUS_SERVER_CODE.FAILED.getValue();
        }
          goto _L7
label1:
        {
            if (AnalyticsEvent.TRANSACTION_STATUS_GOOGLE_API_VALUES.REFUNDED.getValue() != j)
            {
                break label1;
            }
            i1 = AnalyticsEvent.TRANSACTION_STATUS_SERVER_CODE.REFUNDED.getValue();
        }
          goto _L7
        int k = AnalyticsEvent.TRANSACTION_STATUS_SERVER_CODE.RESTORED.getValue();
        i1 = k;
          goto _L7
        JSONException jsonexception;
        jsonexception;
        Log.debug("[InMobi]-[Analytics]-4.4.1", "Error sending transaction info. Transaction details invalid");
        Log.internal("[InMobi]-[Analytics]-4.4.1", "Failed transaction", jsonexception);
        return null;
_L9:
        Exception exception2;
        Log.debug("[InMobi]-[Analytics]-4.4.1", "Error sending transaction info. Bundle details invalid");
        Log.internal("[InMobi]-[Analytics]-4.4.1", "Failed to send extra params transaction", exception2);
        analyticsevent = analyticsevent1;
          goto _L8
        Exception exception;
        exception;
        Log.internal("[InMobi]-[Analytics]-4.4.1", "Exception in tag transaction", exception);
_L2:
        return null;
        exception2;
          goto _L9
        Exception exception1;
        exception1;
        analyticsevent1 = analyticsevent;
        exception2 = exception1;
          goto _L9
    }

    private AnalyticsEvent a(AnalyticsEvent analyticsevent)
    {
        if (c.getInt("RESPONSE_CODE") != 0) goto _L2; else goto _L1
_L1:
        ArrayList arraylist = c.getStringArrayList("DETAILS_LIST");
        int i = 0;
_L7:
        long l;
        String s1;
        String s2;
        if (i >= arraylist.size())
        {
            break; /* Loop/switch isn't completed */
        }
        JSONObject jsonobject = new JSONObject((String)arraylist.get(i));
        String s = jsonobject.getString("productId");
        l = jsonobject.getLong("price_amount_micros");
        s1 = jsonobject.getString("price_currency_code");
        s2 = jsonobject.optString("type");
        String s3 = jsonobject.optString("title");
        String s4 = jsonobject.optString("description");
        if (!s.equals(analyticsevent.getTransactionProductId()))
        {
            break MISSING_BLOCK_LABEL_208;
        }
        analyticsevent.setTransactionItemCount(1);
        analyticsevent.setTransactionItemDescription(s4);
        analyticsevent.setTransactionItemName(s3);
        if (!"inapp".equals(s2)) goto _L4; else goto _L3
_L3:
        analyticsevent.setTransactionItemType(AnalyticsEvent.TRANSACTION_ITEM_TYPE.INAPP.getValue());
_L6:
        analyticsevent.setTransactionItemPrice((double)l / 1000000D);
        analyticsevent.setTransactionCurrencyCode(s1);
        return analyticsevent;
_L4:
        if (!"subs".equals(s2)) goto _L6; else goto _L5
_L5:
        analyticsevent.setTransactionItemType(AnalyticsEvent.TRANSACTION_ITEM_TYPE.SUBSCRIPTION.getValue());
          goto _L6
        Exception exception;
        exception;
        Log.internal("[InMobi]-[Analytics]-4.4.1", "Failed to set purchase bundle info", exception);
        return analyticsevent;
        i++;
        if (true) goto _L7; else goto _L2
_L2:
        return analyticsevent;
    }

    public AnalyticsEvent processFunction()
    {
        return a();
    }
}
