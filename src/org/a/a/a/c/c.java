// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.a.c;


// Referenced classes of package org.a.a.a.c:
//            l

public class c extends l
{

    private static final byte f[] = {
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 3, 2, 2, 3, 
        3, 3, 3, 3, 3, 3, 3, 1, 3, 3, 
        3, 0, 2, 2, 3, 3, 0, 3, 0, 3, 
        2, 0, 3, 3, 3, 0, 3, 0, 0, 0, 
        2, 0, 0, 0, 0, 0, 2, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 
        3, 3, 3, 3, 0, 3, 3, 0, 3, 2, 
        3, 3, 0, 3, 2, 3, 3, 3, 0, 0, 
        3, 0, 3, 0, 3, 3, 2, 0, 0, 0, 
        2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 2, 3, 2, 2, 3, 3, 3, 
        3, 3, 3, 3, 3, 0, 3, 3, 3, 3, 
        0, 2, 3, 3, 0, 3, 3, 3, 3, 2, 
        3, 3, 3, 0, 2, 0, 0, 0, 2, 0, 
        0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 2, 3, 3, 
        2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 
        3, 3, 3, 0, 2, 1, 3, 3, 3, 3, 
        2, 3, 3, 2, 3, 3, 2, 0, 0, 0, 
        0, 0, 2, 0, 0, 0, 0, 0, 2, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 3, 3, 3, 3, 0, 3, 3, 3, 3, 
        3, 3, 0, 3, 3, 0, 3, 3, 3, 3, 
        3, 3, 3, 3, 3, 3, 0, 3, 2, 3, 
        3, 0, 2, 0, 1, 0, 2, 0, 0, 0, 
        0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 
        2, 3, 0, 0, 0, 0, 3, 3, 0, 3, 
        1, 3, 3, 3, 0, 3, 3, 0, 3, 3, 
        3, 3, 0, 0, 0, 0, 2, 0, 0, 0, 
        2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 
        3, 3, 3, 3, 0, 3, 0, 3, 3, 3, 
        3, 3, 0, 3, 2, 2, 2, 3, 0, 2, 
        3, 3, 3, 3, 3, 2, 3, 3, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 3, 3, 3, 3, 3, 3, 2, 
        2, 2, 3, 3, 3, 3, 0, 3, 1, 3, 
        3, 3, 3, 2, 3, 3, 3, 3, 3, 3, 
        3, 2, 2, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 
        3, 3, 2, 0, 3, 0, 0, 0, 3, 3, 
        2, 3, 3, 3, 3, 3, 0, 0, 3, 2, 
        3, 0, 2, 3, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 3, 0, 3, 3, 3, 3, 0, 0, 3, 
        3, 0, 2, 3, 0, 3, 0, 3, 3, 3, 
        0, 0, 3, 0, 3, 0, 2, 2, 3, 3, 
        0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 
        0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 
        2, 0, 3, 2, 3, 3, 3, 3, 0, 3, 
        3, 3, 3, 3, 0, 3, 3, 2, 3, 2, 
        3, 3, 2, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 
        3, 2, 3, 2, 3, 3, 3, 3, 3, 3, 
        0, 2, 3, 2, 3, 2, 2, 2, 3, 2, 
        3, 3, 2, 3, 0, 2, 2, 2, 3, 0, 
        2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 3, 0, 0, 0, 3, 3, 
        3, 2, 3, 3, 0, 0, 3, 0, 3, 0, 
        0, 0, 3, 2, 0, 3, 0, 3, 0, 0, 
        2, 0, 2, 0, 0, 0, 0, 0, 2, 0, 
        0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 3, 3, 3, 3, 0, 3, 3, 3, 3, 
        3, 3, 0, 3, 3, 0, 3, 0, 0, 0, 
        3, 3, 0, 3, 3, 3, 0, 0, 1, 2, 
        3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 
        2, 0, 0, 3, 2, 2, 3, 3, 0, 3, 
        3, 3, 3, 3, 2, 1, 3, 0, 3, 2, 
        3, 3, 2, 1, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        3, 3, 0, 2, 3, 3, 3, 3, 3, 3, 
        0, 0, 3, 0, 3, 0, 0, 0, 3, 3, 
        0, 3, 2, 3, 0, 0, 3, 3, 3, 0, 
        3, 0, 0, 0, 2, 0, 0, 0, 0, 0, 
        3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 3, 3, 3, 3, 0, 3, 3, 
        3, 3, 3, 3, 0, 0, 3, 0, 3, 0, 
        0, 0, 3, 2, 0, 3, 2, 3, 0, 0, 
        3, 2, 3, 0, 2, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 3, 1, 
        2, 2, 3, 3, 3, 3, 3, 3, 0, 2, 
        3, 0, 3, 0, 0, 0, 3, 3, 0, 3, 
        0, 2, 0, 0, 2, 3, 1, 0, 2, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 3, 0, 3, 3, 3, 3, 0, 3, 0, 
        3, 3, 2, 3, 0, 3, 3, 3, 3, 3, 
        3, 0, 3, 3, 3, 0, 2, 3, 0, 0, 
        3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 3, 0, 3, 3, 3, 
        0, 0, 3, 0, 0, 0, 3, 3, 0, 3, 
        0, 2, 3, 3, 0, 0, 3, 0, 3, 0, 
        3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        3, 0, 0, 0, 3, 3, 3, 3, 3, 3, 
        0, 0, 3, 0, 2, 0, 0, 0, 3, 3, 
        0, 3, 0, 3, 0, 0, 2, 0, 2, 0, 
        0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 
        2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 3, 3, 3, 3, 3, 3, 0, 
        3, 0, 2, 0, 3, 2, 0, 3, 2, 3, 
        2, 3, 0, 0, 3, 2, 3, 2, 3, 3, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 
        0, 2, 3, 3, 3, 3, 3, 0, 0, 0, 
        3, 0, 2, 1, 0, 0, 3, 2, 2, 2, 
        0, 3, 0, 0, 2, 2, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 3, 0, 3, 3, 3, 2, 0, 3, 0, 
        3, 0, 3, 3, 0, 2, 1, 2, 3, 3, 
        0, 0, 3, 0, 3, 0, 3, 3, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 2, 3, 3, 3, 0, 
        3, 3, 3, 3, 3, 3, 0, 2, 3, 0, 
        3, 0, 0, 0, 2, 1, 0, 2, 2, 3, 
        0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        3, 0, 0, 2, 3, 3, 3, 2, 3, 0, 
        0, 1, 3, 0, 2, 0, 0, 0, 0, 3, 
        0, 1, 0, 2, 0, 0, 1, 1, 1, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 3, 3, 3, 3, 3, 1, 0, 
        3, 0, 0, 0, 3, 2, 0, 3, 2, 3, 
        3, 3, 0, 0, 3, 0, 3, 2, 2, 2, 
        1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 3, 0, 3, 
        3, 3, 0, 0, 3, 0, 0, 0, 0, 2, 
        0, 2, 3, 3, 2, 2, 2, 2, 3, 0, 
        2, 0, 2, 2, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 3, 3, 3, 3, 2, 0, 0, 0, 0, 
        0, 0, 2, 3, 0, 2, 0, 2, 3, 2, 
        0, 0, 3, 0, 3, 0, 3, 1, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        3, 2, 3, 3, 2, 2, 3, 0, 2, 0, 
        3, 0, 0, 0, 2, 0, 0, 0, 0, 1, 
        2, 0, 2, 0, 2, 0, 0, 2, 0, 2, 
        0, 2, 2, 0, 0, 1, 0, 2, 2, 2, 
        0, 2, 2, 2, 0, 2, 2, 2, 0, 0, 
        2, 0, 0, 1, 0, 0, 0, 0, 0, 2, 
        0, 3, 3, 2, 0, 0, 0, 0, 0, 0, 
        1, 3, 0, 2, 0, 2, 2, 2, 0, 0, 
        2, 0, 3, 0, 0, 2, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 3, 0, 2, 3, 2, 0, 2, 
        2, 0, 2, 0, 2, 2, 0, 2, 0, 2, 
        2, 2, 0, 0, 0, 0, 0, 0, 2, 3, 
        0, 0, 0, 2, 0, 1, 2, 0, 0, 0, 
        0, 2, 2, 0, 0, 0, 2, 1, 0, 2, 
        2, 0, 0, 0, 0, 0, 0, 1, 0, 2, 
        0, 0, 0, 0, 0, 0, 0, 0, 2, 1, 
        0, 2, 3, 2, 2, 3, 2, 3, 2, 0, 
        0, 3, 3, 3, 0, 0, 3, 2, 0, 0, 
        0, 1, 1, 0, 2, 0, 2, 2, 0, 2, 
        0, 2, 0, 2, 2, 0, 0, 2, 0, 2, 
        2, 2, 0, 2, 2, 2, 2, 0, 0, 2, 
        0, 0, 0, 2, 0, 1, 0, 0, 0, 0, 
        0, 3, 0, 3, 3, 2, 2, 0, 3, 0, 
        0, 0, 2, 2, 0, 2, 2, 2, 1, 2, 
        0, 0, 1, 2, 2, 0, 0, 3, 0, 0, 
        0, 2, 0, 1, 2, 0, 0, 0, 1, 2, 
        0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 
        1, 0, 0, 2, 0, 0, 0, 2, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 
        3, 3, 2, 2, 0, 0, 0, 2, 0, 2, 
        3, 3, 0, 2, 0, 0, 0, 0, 0, 0, 
        2, 2, 2, 0, 2, 2, 0, 2, 0, 2, 
        0, 2, 2, 0, 0, 2, 2, 2, 2, 1, 
        0, 0, 2, 2, 0, 2, 0, 0, 2, 0, 
        0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 
        0, 0, 0, 2, 0, 3, 2, 3, 0, 0, 
        0, 3, 0, 0, 2, 2, 0, 2, 0, 2, 
        2, 2, 0, 0, 2, 0, 0, 0, 0, 0, 
        0, 0, 0, 2, 0, 0, 2, 2, 0, 0, 
        2, 2, 2, 0, 0, 0, 0, 0, 0, 2, 
        0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 
        0, 3, 2, 0, 2, 2, 2, 2, 2, 0, 
        0, 0, 2, 0, 0, 0, 0, 2, 0, 1, 
        0, 0, 2, 0, 1, 0, 0, 0, 0, 2, 
        2, 2, 0, 2, 2, 0, 1, 2, 0, 2, 
        2, 2, 0, 2, 2, 2, 2, 1, 2, 2, 
        0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 
        0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 2, 0, 2, 0, 2, 2, 0, 
        0, 0, 0, 1, 2, 1, 0, 0, 2, 2, 
        0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 3, 2, 3, 
        0, 0, 2, 0, 0, 0, 2, 2, 0, 2, 
        0, 0, 0, 1, 0, 0, 2, 0, 2, 0, 
        2, 2, 0, 0, 0, 0, 0, 0, 2, 0, 
        0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 
        0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 2, 0, 0, 0, 0, 0, 0, 0, 2, 
        2, 3, 2, 2, 0, 0, 0, 0, 0, 0, 
        1, 3, 0, 2, 0, 2, 2, 0, 0, 0, 
        1, 0, 2, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 2, 0, 2, 0, 3, 2, 0, 
        2, 0, 0, 0, 0, 0, 0, 2, 2, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 1, 0, 0, 2, 0, 0, 0, 
        0, 1, 1, 0, 0, 2, 1, 2, 0, 2, 
        2, 0, 1, 0, 0, 1, 0, 0, 0, 2, 
        0, 0, 0, 0, 0, 0, 0, 3, 0, 2, 
        2, 2, 0, 0, 2, 0, 0, 0, 2, 0, 
        0, 0, 2, 3, 0, 2, 0, 0, 0, 0, 
        0, 0, 2, 2, 0, 0, 0, 2, 0, 1, 
        2, 0, 0, 0, 1, 2, 2, 1, 0, 0, 
        0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 
        0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 
        0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 2, 1, 2, 0, 2, 2, 0, 
        2, 0, 0, 2, 0, 0, 0, 0, 1, 2, 
        1, 0, 2, 1, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 
        3, 1, 2, 2, 0, 2, 0, 0, 0, 0, 
        2, 0, 0, 0, 2, 0, 0, 3, 0, 0, 
        0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 
        1, 0, 2, 0, 1, 2, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 
        0, 0, 1, 0, 0, 0, 0, 0, 0, 2, 
        0, 2, 2, 0, 0, 2, 2, 2, 2, 2, 
        0, 1, 2, 0, 0, 0, 2, 2, 0, 1, 
        0, 2, 0, 0, 2, 2, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 
        0, 0, 0, 0, 3, 0, 0, 2, 0, 0, 
        0, 0, 0, 0, 0, 0, 2, 0, 2, 0, 
        0, 0, 0, 2, 0, 1, 2, 0, 0, 0, 
        0, 2, 2, 1, 0, 1, 0, 1, 0, 2, 
        2, 2, 1, 0, 0, 0, 0, 0, 0, 1, 
        0, 0, 0, 0, 0, 0, 0, 2, 0, 1, 
        2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 2, 0, 0, 2, 2, 0, 0, 0, 0, 
        1, 0, 0, 0, 0, 0, 0, 2, 0, 2, 
        2, 0, 0, 0, 0, 2, 2, 0, 0, 0, 
        0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 
        0, 2, 2, 2, 2, 0, 0, 0, 3, 0, 
        0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 
        0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 
        0, 1, 0, 0, 2, 0, 0, 0, 0, 1, 
        2, 0, 0, 0, 0, 0, 0, 2, 2, 1, 
        1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 
        0, 0, 0, 0, 0, 2, 0, 2, 2, 2, 
        0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 
        2, 2, 2, 0, 0, 0, 2, 0, 0, 0, 
        0, 0, 0, 0, 0, 2, 0, 0, 1, 0, 
        0, 0, 0, 2, 1, 0, 0, 0, 0, 0, 
        0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 
        0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 
        2, 0, 0, 0, 0, 0, 2, 0, 0, 0, 
        0, 0, 0, 0, 2, 0, 0, 0, 0, 2, 
        0, 0, 2, 0, 0, 0, 0, 2, 2, 0, 
        0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 2, 0, 2, 2, 1, 0, 0, 
        0, 0, 0, 0, 2, 0, 0, 2, 0, 2, 
        2, 2, 0, 0, 0, 0, 0, 0, 2, 0, 
        0, 0, 0, 2, 0, 0, 2, 0, 0, 2, 
        0, 2, 2, 0, 0, 0, 0, 2, 0, 2, 
        0, 0, 0, 0, 0, 2, 0, 0, 0, 2, 
        0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 
        0, 0, 2, 2, 0, 2, 2, 0, 0, 0, 
        0, 0, 2, 0, 0, 0, 0, 0, 0, 2, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 
        0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 
        0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 
        0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 
        0, 0, 0, 2, 1, 0, 0, 0, 0, 0, 
        0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 
        0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 
        0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 2, 0, 0, 0, 2, 0, 0, 0, 0, 
        0, 1, 0, 0, 0, 0, 2, 2, 0, 0, 
        0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 
        1, 0, 2, 0, 0, 0, 0, 2, 0, 2, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        1, 0, 0, 0, 0, 1, 0, 0, 2, 0, 
        2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 2, 1, 0, 0, 0, 0, 0, 0, 
        2, 0, 0, 0, 1, 2, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0
    };

    public c(short aword0[], String s)
    {
        super(aword0, f, 0.982851F, s);
    }

}
