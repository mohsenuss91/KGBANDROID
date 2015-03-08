// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.metric;

import com.inmobi.commons.internal.Log;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.metric:
//            EventType

public class EventLog
{

    private EventType a;
    private JSONObject b;

    public EventLog(EventType eventtype, JSONObject jsonobject)
    {
        a = eventtype;
        b = jsonobject;
    }

    public String toString()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("t", a.getValue());
            jsonobject.put("v", b);
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.4.1", "Unable to log json.", exception);
        }
        return jsonobject.toString();
    }
}
