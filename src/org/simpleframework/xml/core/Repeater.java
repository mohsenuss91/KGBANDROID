// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import org.simpleframework.xml.stream.InputNode;

// Referenced classes of package org.simpleframework.xml.core:
//            Converter

interface Repeater
    extends Converter
{

    public abstract Object read(InputNode inputnode, Object obj);
}
