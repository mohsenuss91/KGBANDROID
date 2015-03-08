// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import java.util.HashMap;

// Referenced classes of package com.millennialmedia.android:
//            MMJSObject, MMJSResponse

class BridgeMMCalendar extends MMJSObject
{

    BridgeMMCalendar()
    {
    }

    public MMJSResponse addEvent(HashMap hashmap)
    {
        return MMJSResponse.responseWithError("Not supported");
    }
}
