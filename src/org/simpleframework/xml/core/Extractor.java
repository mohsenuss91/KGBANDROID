// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;

// Referenced classes of package org.simpleframework.xml.core:
//            Label

interface Extractor
{

    public abstract Annotation[] getAnnotations();

    public abstract Label getLabel(Annotation annotation);

    public abstract Class getType(Annotation annotation);
}
