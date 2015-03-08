// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import java.io.File;
import java.io.FileFilter;

final class 
    implements FileFilter
{

    public final boolean accept(File file)
    {
        return !file.isDirectory() && file.getName().endsWith("ad.dat");
    }

    ()
    {
    }
}
