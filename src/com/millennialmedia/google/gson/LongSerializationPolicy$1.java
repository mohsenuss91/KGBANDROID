// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson;


// Referenced classes of package com.millennialmedia.google.gson:
//            LongSerializationPolicy, JsonPrimitive, JsonElement

final class nit> extends LongSerializationPolicy
{

    public final JsonElement serialize(Long long1)
    {
        return new JsonPrimitive(long1);
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
