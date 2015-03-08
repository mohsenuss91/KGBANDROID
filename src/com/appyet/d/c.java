// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.d;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.appyet.d:
//            d

public final class c
{

    public static ArrayList a(String s)
    {
        ArrayList arraylist = new ArrayList();
        try
        {
            Matcher matcher = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>").matcher(s);
            do
            {
                if (!matcher.find())
                {
                    break;
                }
                if (matcher.groupCount() > 0)
                {
                    arraylist.add(matcher.group(1));
                }
            } while (true);
        }
        catch (Exception exception)
        {
            d.a(exception);
        }
        return arraylist;
    }
}
