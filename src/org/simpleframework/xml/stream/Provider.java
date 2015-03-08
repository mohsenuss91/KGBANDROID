// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;

import java.io.InputStream;
import java.io.Reader;

// Referenced classes of package org.simpleframework.xml.stream:
//            EventReader

interface Provider
{

    public abstract EventReader provide(InputStream inputstream);

    public abstract EventReader provide(Reader reader);
}
