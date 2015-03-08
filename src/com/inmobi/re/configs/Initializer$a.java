// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.configs;

import java.util.Map;

final class ller.Validator
    implements com.inmobi.commons.cache.r.Validator
{

    public final boolean validate(Map map)
    {
        return map.get("data") != null;
    }

    ller.Validator()
    {
    }
}
