// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.LimitedCache;

// Referenced classes of package org.simpleframework.xml.core:
//            Support, Detail, PathParser, ClassType, 
//            Expression

class ExpressionBuilder
{

    private final Cache cache = new LimitedCache();
    private final Format format;
    private final Class type;

    public ExpressionBuilder(Detail detail, Support support)
    {
        format = support.getFormat();
        type = detail.getType();
    }

    private Expression create(String s)
    {
        PathParser pathparser = new PathParser(s, new ClassType(type), format);
        if (cache != null)
        {
            cache.cache(s, pathparser);
        }
        return pathparser;
    }

    public Expression build(String s)
    {
        Expression expression = (Expression)cache.fetch(s);
        if (expression == null)
        {
            expression = create(s);
        }
        return expression;
    }
}
