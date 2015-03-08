// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson.internal.bind;

import com.millennialmedia.google.gson.Gson;
import com.millennialmedia.google.gson.TypeAdapter;
import com.millennialmedia.google.gson.TypeAdapterFactory;
import com.millennialmedia.google.gson.reflect.TypeToken;
import java.sql.Date;

// Referenced classes of package com.millennialmedia.google.gson.internal.bind:
//            SqlDateTypeAdapter

final class 
    implements TypeAdapterFactory
{

    public final TypeAdapter create(Gson gson, TypeToken typetoken)
    {
        if (typetoken.getRawType() == java/sql/Date)
        {
            return new SqlDateTypeAdapter();
        } else
        {
            return null;
        }
    }

    ()
    {
    }
}
