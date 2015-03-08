// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.List;

// Referenced classes of package org.simpleframework.xml.core:
//            Criteria, Parameter

interface Instantiator
{

    public abstract List getCreators();

    public abstract Object getInstance();

    public abstract Object getInstance(Criteria criteria);

    public abstract Parameter getParameter(String s);

    public abstract List getParameters();

    public abstract boolean isDefault();
}
