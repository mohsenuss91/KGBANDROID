// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml;

import java.lang.annotation.Annotation;

// Referenced classes of package org.simpleframework.xml:
//            ElementList

public interface ElementListUnion
    extends Annotation
{

    public abstract ElementList[] value();
}
