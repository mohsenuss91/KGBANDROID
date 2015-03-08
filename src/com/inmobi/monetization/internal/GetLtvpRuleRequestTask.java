// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;

import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsEndPointsConfig;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.abstraction.IGetLtvpRuleRequestListener;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.monetization.internal:
//            GetLtvpRulesRequest, LtvpErrorCode, GetLtvpRulesResponse

public class GetLtvpRuleRequestTask
    implements Runnable
{

    private GetLtvpRulesRequest a;
    private IGetLtvpRuleRequestListener b;
    private final int c = 60000;
    private final int d = -1;

    GetLtvpRuleRequestTask(GetLtvpRulesRequest getltvprulesrequest, IGetLtvpRuleRequestListener igetltvprulerequestlistener)
    {
        a = getltvprulesrequest;
        b = igetltvprulerequestlistener;
    }

    public void run()
    {
        JSONObject jsonobject;
        JSONObject jsonobject1;
        GetLtvpRulesResponse getltvprulesresponse;
        String s1;
        long l;
        JSONObject jsonobject2;
        long l1;
        long l2;
        HashMap hashmap;
        JSONObject jsonobject3;
        try
        {
            URL url = new URL(AnalyticsInitializer.getConfigParams().getEndPoints().getRulesUrl());
            DefaultHttpClient defaulthttpclient = new DefaultHttpClient();
            String s = (new StringBuilder()).append(url).append("?").append(a.getEncodedRequestParams()).toString();
            Log.debug("[InMobi]-[Monetization]", (new StringBuilder("Getting LTVP rule: ")).append(s).toString());
            HttpGet httpget = new HttpGet(s);
            BasicHttpParams basichttpparams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(basichttpparams, 60000);
            HttpConnectionParams.setSoTimeout(basichttpparams, 60000);
            defaulthttpclient.setParams(basichttpparams);
            HttpResponse httpresponse = defaulthttpclient.execute(httpget);
            if (httpresponse.getStatusLine().getStatusCode() != 200)
            {
                break MISSING_BLOCK_LABEL_511;
            }
            jsonobject = new JSONObject(EntityUtils.toString(httpresponse.getEntity()));
            if (!jsonobject.getBoolean("success"))
            {
                int i = jsonobject.getInt("error_code");
                String s3 = jsonobject.getString("error_message");
                Log.debug("[InMobi]-[Monetization]", (new StringBuilder("Received LTVP rule fetch failure: ")).append(i).append(" : ").append(s3).toString());
                if (b != null)
                {
                    b.onLtvpGetRuleFailed(a, new LtvpErrorCode(i, s3));
                    return;
                }
                break MISSING_BLOCK_LABEL_511;
            }
        }
        catch (Exception exception)
        {
            Log.debug("[InMobi]-[Monetization]", "Received LTVP rule fetch exception", exception);
            if (b != null)
            {
                b.onLtvpGetRuleFailed(a, new LtvpErrorCode(-1, "Ltvp rule server unreachable"));
                return;
            }
            break MISSING_BLOCK_LABEL_511;
        }
        jsonobject1 = jsonobject.getJSONObject("response");
        Log.debug("[InMobi]-[Monetization]", (new StringBuilder("Received LTVP rule fetch success: ")).append(jsonobject1.toString()).toString());
        getltvprulesresponse = new GetLtvpRulesResponse();
        s1 = jsonobject1.getString("rule_id");
        l = jsonobject1.getLong("ts");
        jsonobject2 = jsonobject1.getJSONObject("exp");
        l1 = jsonobject2.getLong("se");
        l2 = jsonobject2.getLong("he");
        hashmap = new HashMap();
        jsonobject3 = jsonobject1.getJSONObject("rules");
        String s2;
        for (Iterator iterator = jsonobject3.keys(); iterator.hasNext(); hashmap.put(s2, Integer.valueOf(jsonobject3.getInt(String.valueOf(s2)))))
        {
            s2 = (String)iterator.next();
        }

        getltvprulesresponse.setRuleId(s1);
        getltvprulesresponse.setTimeStamp(l);
        getltvprulesresponse.setSoftExpiry(l1);
        getltvprulesresponse.setHardExpiry(l2);
        getltvprulesresponse.setRules(hashmap);
        if (b != null)
        {
            b.onLtvpGetRuleSucceeded(a, getltvprulesresponse);
        }
    }
}
