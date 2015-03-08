// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;


// Referenced classes of package org.simpleframework.xml.core:
//            Parameter

abstract class TemplateParameter
    implements Parameter
{

    protected TemplateParameter()
    {
    }

    public boolean isAttribute()
    {
        return false;
    }

    public boolean isText()
    {
        return false;
    }
}
