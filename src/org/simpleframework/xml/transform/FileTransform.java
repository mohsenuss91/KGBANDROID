// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.transform;

import java.io.File;

// Referenced classes of package org.simpleframework.xml.transform:
//            Transform

class FileTransform
    implements Transform
{

    FileTransform()
    {
    }

    public File read(String s)
    {
        return new File(s);
    }

    public volatile Object read(String s)
    {
        return read(s);
    }

    public String write(File file)
    {
        return file.getPath();
    }

    public volatile String write(Object obj)
    {
        return write((File)obj);
    }
}
