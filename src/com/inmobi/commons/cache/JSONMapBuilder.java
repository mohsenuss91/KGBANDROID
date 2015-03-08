// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.cache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.cache:
//            MapBuilder

public class JSONMapBuilder
    implements MapBuilder
{

    public JSONMapBuilder()
    {
    }

    private void a(JSONObject jsonobject, Map map)
    {
        Iterator iterator = jsonobject.keys();
_L6:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        String s = (String)iterator.next();
        Object obj = jsonobject.get(s);
        if (!(obj instanceof JSONObject)) goto _L4; else goto _L3
_L3:
        HashMap hashmap = new HashMap();
        map.put(s, hashmap);
        a((JSONObject)obj, ((Map) (hashmap)));
          goto _L5
_L4:
        try
        {
            map.put(s, obj);
        }
        catch (JSONException jsonexception) { }
_L5:
        if (true) goto _L6; else goto _L2
_L2:
    }

    public Map buildMap(String s)
    {
        JSONObject jsonobject = new JSONObject(s);
        HashMap hashmap = new HashMap();
        a(jsonobject, hashmap);
        return hashmap;
    }
}
