// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.a.a;


// Referenced classes of package org.a.a.a.a:
//            c

public abstract class b
{

    protected static final byte a[][] = {
        {
            0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 
            0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 1
        }, {
            2, 4, 0, 4, 0, 3, 0, 4, 0, 3, 
            4, 4, 4, 2, 4, 3, 3, 4, 3, 2, 
            3, 3, 4, 2, 3, 3, 3, 2, 4, 1, 
            4, 3, 3, 1, 5, 4, 3, 4, 3, 4, 
            3, 5, 3, 0, 3, 5, 4, 2, 0, 3, 
            1, 0, 3, 3, 0, 3, 3, 0, 1, 1, 
            0, 4, 3, 0, 3, 3, 0, 4, 0, 2, 
            0, 3, 5, 5, 5, 5, 4, 0, 4, 1, 
            0, 3, 4
        }, {
            0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 2
        }, {
            0, 4, 0, 5, 0, 5, 0, 4, 0, 4, 
            5, 4, 4, 3, 5, 3, 5, 1, 5, 3, 
            4, 3, 4, 4, 3, 4, 3, 3, 4, 3, 
            5, 4, 4, 3, 5, 5, 3, 5, 5, 5, 
            3, 5, 5, 3, 4, 5, 5, 3, 1, 3, 
            2, 0, 3, 4, 0, 4, 2, 0, 4, 2, 
            1, 5, 3, 2, 3, 5, 0, 4, 0, 2, 
            0, 5, 4, 4, 5, 4, 5, 0, 4, 0, 
            0, 4, 4
        }, {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0
        }, {
            0, 3, 0, 4, 0, 3, 0, 3, 0, 4, 
            5, 4, 3, 3, 3, 3, 4, 3, 5, 4, 
            4, 3, 5, 4, 4, 3, 4, 3, 4, 4, 
            4, 4, 5, 3, 4, 4, 3, 4, 5, 5, 
            4, 5, 5, 1, 4, 5, 4, 3, 0, 3, 
            3, 1, 3, 3, 0, 4, 4, 0, 3, 3, 
            1, 5, 3, 3, 3, 5, 0, 4, 0, 3, 
            0, 4, 4, 3, 4, 3, 3, 0, 4, 1, 
            1, 3, 4
        }, {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0
        }, {
            0, 4, 0, 3, 0, 3, 0, 4, 0, 3, 
            4, 4, 3, 2, 2, 1, 2, 1, 3, 1, 
            3, 3, 3, 3, 3, 4, 3, 1, 3, 3, 
            5, 3, 3, 0, 4, 3, 0, 5, 4, 3, 
            3, 5, 4, 4, 3, 4, 4, 5, 0, 1, 
            2, 0, 1, 2, 0, 2, 2, 0, 1, 0, 
            0, 5, 2, 2, 1, 4, 0, 3, 0, 1, 
            0, 4, 4, 3, 5, 4, 3, 0, 2, 1, 
            0, 4, 3
        }, {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0
        }, {
            0, 3, 0, 5, 0, 4, 0, 2, 1, 4, 
            4, 2, 4, 1, 4, 2, 4, 2, 4, 3, 
            3, 3, 4, 3, 3, 3, 3, 1, 4, 2, 
            3, 3, 3, 1, 4, 4, 1, 1, 1, 4, 
            3, 3, 2, 0, 2, 4, 3, 2, 0, 3, 
            3, 0, 3, 1, 1, 0, 0, 0, 3, 3, 
            0, 4, 2, 2, 3, 4, 0, 4, 0, 3, 
            0, 4, 4, 5, 3, 4, 4, 0, 3, 0, 
            0, 1, 4
        }, {
            1, 4, 0, 4, 0, 4, 0, 4, 0, 3, 
            5, 4, 4, 3, 4, 3, 5, 4, 3, 3, 
            4, 3, 5, 4, 4, 4, 4, 3, 4, 2, 
            4, 3, 3, 1, 5, 4, 3, 2, 4, 5, 
            4, 5, 5, 4, 4, 5, 4, 4, 0, 3, 
            2, 2, 3, 3, 0, 4, 3, 1, 3, 2, 
            1, 4, 3, 3, 4, 5, 0, 3, 0, 2, 
            0, 4, 5, 5, 4, 5, 4, 0, 4, 0, 
            0, 5, 4
        }, {
            0, 5, 0, 5, 0, 4, 0, 3, 0, 4, 
            4, 3, 4, 3, 3, 3, 4, 0, 4, 4, 
            4, 3, 4, 3, 4, 3, 3, 1, 4, 2, 
            4, 3, 4, 0, 5, 4, 1, 4, 5, 4, 
            4, 5, 3, 2, 4, 3, 4, 3, 2, 4, 
            1, 3, 3, 3, 2, 3, 2, 0, 4, 3, 
            3, 4, 3, 3, 3, 4, 0, 4, 0, 3, 
            0, 4, 5, 4, 4, 4, 3, 0, 4, 1, 
            0, 1, 3
        }, {
            0, 3, 1, 4, 0, 3, 0, 2, 0, 3, 
            4, 4, 3, 1, 4, 2, 3, 3, 4, 3, 
            4, 3, 4, 3, 4, 4, 3, 2, 3, 1, 
            5, 4, 4, 1, 4, 4, 3, 5, 4, 4, 
            3, 5, 5, 4, 3, 4, 4, 3, 1, 2, 
            3, 1, 2, 2, 0, 3, 2, 0, 3, 1, 
            0, 5, 3, 3, 3, 4, 3, 3, 3, 3, 
            4, 4, 4, 4, 5, 4, 2, 0, 3, 3, 
            2, 4, 3
        }, {
            0, 2, 0, 3, 0, 1, 0, 1, 0, 0, 
            3, 2, 0, 0, 2, 0, 1, 0, 2, 1, 
            3, 3, 3, 1, 2, 3, 1, 0, 1, 0, 
            4, 2, 1, 1, 3, 3, 0, 4, 3, 3, 
            1, 4, 3, 3, 0, 3, 3, 2, 0, 0, 
            0, 0, 1, 0, 0, 2, 0, 0, 0, 0, 
            0, 4, 1, 0, 2, 3, 2, 2, 2, 1, 
            3, 3, 3, 4, 4, 3, 2, 0, 3, 1, 
            0, 3, 3
        }, {
            0, 4, 0, 4, 0, 3, 0, 3, 0, 4, 
            4, 4, 3, 3, 3, 3, 3, 3, 4, 3, 
            4, 2, 4, 3, 4, 3, 3, 2, 4, 3, 
            4, 5, 4, 1, 4, 5, 3, 5, 4, 5, 
            3, 5, 4, 0, 3, 5, 5, 3, 1, 3, 
            3, 2, 2, 3, 0, 3, 4, 1, 3, 3, 
            2, 4, 3, 3, 3, 4, 0, 4, 0, 3, 
            0, 4, 5, 4, 4, 5, 3, 0, 4, 1, 
            0, 3, 4
        }, {
            0, 2, 0, 3, 0, 3, 0, 0, 0, 2, 
            2, 2, 1, 0, 1, 0, 0, 0, 3, 0, 
            3, 0, 3, 0, 1, 3, 1, 0, 3, 1, 
            3, 3, 3, 1, 3, 3, 3, 0, 1, 3, 
            1, 3, 4, 0, 0, 3, 1, 1, 0, 3, 
            2, 0, 0, 0, 0, 1, 3, 0, 1, 0, 
            0, 3, 3, 2, 0, 3, 0, 0, 0, 0, 
            0, 3, 4, 3, 4, 3, 3, 0, 3, 0, 
            0, 2, 3
        }, {
            2, 3, 0, 3, 0, 2, 0, 1, 0, 3, 
            3, 4, 3, 1, 3, 1, 1, 1, 3, 1, 
            4, 3, 4, 3, 3, 3, 0, 0, 3, 1, 
            5, 4, 3, 1, 4, 3, 2, 5, 5, 4, 
            4, 4, 4, 3, 3, 4, 4, 4, 0, 2, 
            1, 1, 3, 2, 0, 1, 2, 0, 0, 1, 
            0, 4, 1, 3, 3, 3, 0, 3, 0, 1, 
            0, 4, 4, 4, 5, 5, 3, 0, 2, 0, 
            0, 4, 4
        }, {
            0, 2, 0, 1, 0, 3, 1, 3, 0, 2, 
            3, 3, 3, 0, 3, 1, 0, 0, 3, 0, 
            3, 2, 3, 1, 3, 2, 1, 1, 0, 0, 
            4, 2, 1, 0, 2, 3, 1, 4, 3, 2, 
            0, 4, 4, 3, 1, 3, 1, 3, 0, 1, 
            0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 
            0, 4, 1, 1, 1, 2, 0, 3, 0, 0, 
            0, 3, 4, 2, 4, 3, 2, 0, 1, 0, 
            0, 3, 3
        }, {
            0, 1, 0, 4, 0, 5, 0, 4, 0, 2, 
            4, 4, 2, 3, 3, 2, 3, 3, 5, 3, 
            3, 3, 4, 3, 4, 2, 3, 0, 4, 3, 
            3, 3, 4, 1, 4, 3, 2, 1, 5, 5, 
            3, 4, 5, 1, 3, 5, 4, 2, 0, 3, 
            3, 0, 1, 3, 0, 4, 2, 0, 1, 3, 
            1, 4, 3, 3, 3, 3, 0, 3, 0, 1, 
            0, 3, 4, 4, 4, 5, 5, 0, 3, 0, 
            1, 4, 5
        }, {
            0, 2, 0, 3, 0, 3, 0, 0, 0, 2, 
            3, 1, 3, 0, 4, 0, 1, 1, 3, 0, 
            3, 4, 3, 2, 3, 1, 0, 3, 3, 2, 
            3, 1, 3, 0, 2, 3, 0, 2, 1, 4, 
            1, 2, 2, 0, 0, 3, 3, 0, 0, 2, 
            0, 0, 0, 1, 0, 0, 0, 0, 2, 2, 
            0, 3, 2, 1, 3, 3, 0, 2, 0, 2, 
            0, 0, 3, 3, 1, 2, 4, 0, 3, 0, 
            2, 2, 3
        }, {
            2, 4, 0, 5, 0, 4, 0, 4, 0, 2, 
            4, 4, 4, 3, 4, 3, 3, 3, 1, 2, 
            4, 3, 4, 3, 4, 4, 5, 0, 3, 3, 
            3, 3, 2, 0, 4, 3, 1, 4, 3, 4, 
            1, 4, 4, 3, 3, 4, 4, 3, 1, 2, 
            3, 0, 4, 2, 0, 4, 1, 0, 3, 3, 
            0, 4, 3, 3, 3, 4, 0, 4, 0, 2, 
            0, 3, 5, 3, 4, 5, 2, 0, 3, 0, 
            0, 4, 5
        }, {
            0, 3, 0, 4, 0, 1, 0, 1, 0, 1, 
            3, 2, 2, 1, 3, 0, 3, 0, 2, 0, 
            2, 0, 3, 0, 2, 0, 0, 0, 1, 0, 
            1, 1, 0, 0, 3, 1, 0, 0, 0, 4, 
            0, 3, 1, 0, 2, 1, 3, 0, 0, 0, 
            0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 
            0, 4, 2, 2, 3, 1, 0, 3, 0, 0, 
            0, 1, 4, 4, 4, 3, 0, 0, 4, 0, 
            0, 1, 4
        }, {
            1, 4, 1, 5, 0, 3, 0, 3, 0, 4, 
            5, 4, 4, 3, 5, 3, 3, 4, 4, 3, 
            4, 1, 3, 3, 3, 3, 2, 1, 4, 1, 
            5, 4, 3, 1, 4, 4, 3, 5, 4, 4, 
            3, 5, 4, 3, 3, 4, 4, 4, 0, 3, 
            3, 1, 2, 3, 0, 3, 1, 0, 3, 3, 
            0, 5, 4, 4, 4, 4, 4, 4, 3, 3, 
            5, 4, 4, 3, 3, 5, 4, 0, 3, 2, 
            0, 4, 4
        }, {
            0, 2, 0, 3, 0, 1, 0, 0, 0, 1, 
            3, 3, 3, 2, 4, 1, 3, 0, 3, 1, 
            3, 0, 2, 2, 1, 1, 0, 0, 2, 0, 
            4, 3, 1, 0, 4, 3, 0, 4, 4, 4, 
            1, 4, 3, 1, 1, 3, 3, 1, 0, 2, 
            0, 0, 1, 3, 0, 0, 0, 0, 2, 0, 
            0, 4, 3, 2, 4, 3, 5, 4, 3, 3, 
            3, 4, 3, 3, 4, 3, 3, 0, 2, 1, 
            0, 3, 3
        }, {
            0, 2, 0, 4, 0, 3, 0, 2, 0, 2, 
            5, 5, 3, 4, 4, 4, 4, 1, 4, 3, 
            3, 0, 4, 3, 4, 3, 1, 3, 3, 2, 
            4, 3, 0, 3, 4, 3, 0, 3, 4, 4, 
            2, 4, 4, 0, 4, 5, 3, 3, 2, 2, 
            1, 1, 1, 2, 0, 1, 5, 0, 3, 3, 
            2, 4, 3, 3, 3, 4, 0, 3, 0, 2, 
            0, 4, 4, 3, 5, 5, 0, 0, 3, 0, 
            2, 3, 3
        }, {
            0, 3, 0, 4, 0, 3, 0, 1, 0, 3, 
            4, 3, 3, 1, 3, 3, 3, 0, 3, 1, 
            3, 0, 4, 3, 3, 1, 1, 0, 3, 0, 
            3, 3, 0, 0, 4, 4, 0, 1, 5, 4, 
            3, 3, 5, 0, 3, 3, 4, 3, 0, 2, 
            0, 1, 1, 1, 0, 1, 3, 0, 1, 2, 
            1, 3, 3, 2, 3, 3, 0, 3, 0, 1, 
            0, 1, 3, 3, 4, 4, 1, 0, 1, 2, 
            2, 1, 3
        }, {
            0, 1, 0, 4, 0, 4, 0, 3, 0, 1, 
            3, 3, 3, 2, 3, 1, 1, 0, 3, 0, 
            3, 3, 4, 3, 2, 4, 2, 0, 1, 0, 
            4, 3, 2, 0, 4, 3, 0, 5, 3, 3, 
            2, 4, 4, 4, 3, 3, 3, 4, 0, 1, 
            3, 0, 0, 1, 0, 0, 1, 0, 0, 0, 
            0, 4, 2, 3, 3, 3, 0, 3, 0, 0, 
            0, 4, 4, 4, 5, 3, 2, 0, 3, 3, 
            0, 3, 5
        }, {
            0, 2, 0, 3, 0, 0, 0, 3, 0, 1, 
            3, 0, 2, 0, 0, 0, 1, 0, 3, 1, 
            1, 3, 3, 0, 0, 3, 0, 0, 3, 0, 
            2, 3, 1, 0, 3, 1, 0, 3, 3, 2, 
            0, 4, 2, 2, 0, 2, 0, 0, 0, 4, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 2, 1, 2, 0, 1, 0, 1, 0, 0, 
            0, 1, 3, 1, 2, 0, 0, 0, 1, 0, 
            0, 1, 4
        }, {
            0, 3, 0, 3, 0, 5, 0, 1, 0, 2, 
            4, 3, 1, 3, 3, 2, 1, 1, 5, 2, 
            1, 0, 5, 1, 2, 0, 0, 0, 3, 3, 
            2, 2, 3, 2, 4, 3, 0, 0, 3, 3, 
            1, 3, 3, 0, 2, 5, 3, 4, 0, 3, 
            3, 0, 1, 2, 0, 2, 2, 0, 3, 2, 
            0, 2, 2, 3, 3, 3, 0, 2, 0, 1, 
            0, 3, 4, 4, 2, 5, 4, 0, 3, 0, 
            0, 3, 5
        }, {
            0, 3, 0, 3, 0, 3, 0, 1, 0, 3, 
            3, 3, 3, 0, 3, 0, 2, 0, 2, 1, 
            1, 0, 2, 0, 1, 0, 0, 0, 2, 1, 
            0, 0, 1, 0, 3, 2, 0, 0, 3, 3, 
            1, 2, 3, 1, 0, 3, 3, 0, 0, 1, 
            0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 
            0, 2, 3, 1, 2, 3, 0, 3, 0, 1, 
            0, 3, 2, 1, 0, 4, 3, 0, 1, 1, 
            0, 3, 3
        }, {
            0, 4, 0, 5, 0, 3, 0, 3, 0, 4, 
            5, 5, 4, 3, 5, 3, 4, 3, 5, 3, 
            3, 2, 5, 3, 4, 4, 4, 3, 4, 3, 
            4, 5, 5, 3, 4, 4, 3, 4, 4, 5, 
            4, 4, 4, 3, 4, 5, 5, 4, 2, 3, 
            4, 2, 3, 4, 0, 3, 3, 1, 4, 3, 
            2, 4, 3, 3, 5, 5, 0, 3, 0, 3, 
            0, 5, 5, 5, 5, 4, 4, 0, 4, 0, 
            1, 4, 4
        }, {
            0, 4, 0, 4, 0, 3, 0, 3, 0, 3, 
            5, 4, 4, 2, 3, 2, 5, 1, 3, 2, 
            5, 1, 4, 2, 3, 2, 3, 3, 4, 3, 
            3, 3, 3, 2, 5, 4, 1, 3, 3, 5, 
            3, 4, 4, 0, 4, 4, 3, 1, 1, 3, 
            1, 0, 2, 3, 0, 2, 3, 0, 3, 0, 
            0, 4, 3, 1, 3, 4, 0, 3, 0, 2, 
            0, 4, 4, 4, 3, 4, 5, 0, 4, 0, 
            0, 3, 4
        }, {
            0, 3, 0, 3, 0, 3, 1, 2, 0, 3, 
            4, 4, 3, 3, 3, 0, 2, 2, 4, 3, 
            3, 1, 3, 3, 3, 1, 1, 0, 3, 1, 
            4, 3, 2, 3, 4, 4, 2, 4, 4, 4, 
            3, 4, 4, 3, 2, 4, 4, 3, 1, 3, 
            3, 1, 3, 3, 0, 4, 1, 0, 2, 2, 
            1, 4, 3, 2, 3, 3, 5, 4, 3, 3, 
            5, 4, 4, 3, 3, 0, 4, 0, 3, 2, 
            2, 4, 4
        }, {
            0, 2, 0, 1, 0, 0, 0, 0, 0, 1, 
            2, 1, 3, 0, 0, 0, 0, 0, 2, 0, 
            1, 2, 1, 0, 0, 1, 0, 0, 0, 0, 
            3, 0, 0, 1, 0, 1, 1, 3, 1, 0, 
            0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 
            0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 
            0, 1, 1, 2, 2, 0, 3, 4, 0, 0, 
            0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 
            0, 1, 1
        }, {
            0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 
            4, 0, 4, 1, 4, 0, 3, 0, 4, 0, 
            3, 0, 4, 0, 3, 0, 3, 0, 4, 1, 
            5, 1, 4, 0, 0, 3, 0, 5, 0, 5, 
            2, 0, 1, 0, 0, 0, 2, 1, 4, 0, 
            1, 3, 0, 0, 3, 0, 0, 3, 1, 1, 
            4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 
            0, 0, 0
        }, {
            1, 4, 0, 5, 0, 3, 0, 2, 0, 3, 
            5, 4, 4, 3, 4, 3, 5, 3, 4, 3, 
            3, 0, 4, 3, 3, 3, 3, 3, 3, 2, 
            4, 4, 3, 1, 3, 4, 4, 5, 4, 4, 
            3, 4, 4, 1, 3, 5, 4, 3, 3, 3, 
            1, 2, 2, 3, 3, 1, 3, 1, 3, 3, 
            3, 5, 3, 3, 4, 5, 0, 3, 0, 3, 
            0, 3, 4, 3, 4, 4, 3, 0, 3, 0, 
            2, 4, 3
        }, {
            0, 1, 0, 4, 0, 0, 0, 0, 0, 1, 
            4, 0, 4, 1, 4, 2, 4, 0, 3, 0, 
            1, 0, 1, 0, 0, 0, 0, 0, 2, 0, 
            3, 1, 1, 1, 0, 3, 0, 0, 0, 1, 
            2, 1, 0, 0, 1, 1, 1, 1, 0, 1, 
            0, 0, 0, 1, 0, 0, 3, 0, 0, 0, 
            0, 3, 2, 0, 2, 2, 0, 1, 0, 0, 
            0, 2, 3, 2, 3, 3, 0, 0, 0, 0, 
            2, 1, 0
        }, {
            0, 5, 1, 5, 0, 3, 0, 3, 0, 5, 
            4, 4, 5, 1, 5, 3, 3, 0, 4, 3, 
            4, 3, 5, 3, 4, 3, 3, 2, 4, 3, 
            4, 3, 3, 0, 3, 3, 1, 4, 4, 3, 
            4, 4, 4, 3, 4, 5, 5, 3, 2, 3, 
            1, 1, 3, 3, 1, 3, 1, 1, 3, 3, 
            2, 4, 5, 3, 3, 5, 0, 4, 0, 3, 
            0, 4, 4, 3, 5, 3, 3, 0, 3, 4, 
            0, 4, 3
        }, {
            0, 5, 0, 5, 0, 3, 0, 2, 0, 4, 
            4, 3, 5, 2, 4, 3, 3, 3, 4, 4, 
            4, 3, 5, 3, 5, 3, 3, 1, 4, 0, 
            4, 3, 3, 0, 3, 3, 0, 4, 4, 4, 
            4, 5, 4, 3, 3, 5, 5, 3, 2, 3, 
            1, 2, 3, 2, 0, 1, 0, 0, 3, 2, 
            2, 4, 4, 3, 1, 5, 0, 4, 0, 3, 
            0, 4, 3, 1, 3, 2, 1, 0, 3, 3, 
            0, 3, 3
        }, {
            0, 4, 0, 5, 0, 5, 0, 4, 0, 4, 
            5, 5, 5, 3, 4, 3, 3, 2, 5, 4, 
            4, 3, 5, 3, 5, 3, 4, 0, 4, 3, 
            4, 4, 3, 2, 4, 4, 3, 4, 5, 4, 
            4, 5, 5, 0, 3, 5, 5, 4, 1, 3, 
            3, 2, 3, 3, 1, 3, 1, 0, 4, 3, 
            1, 4, 4, 3, 4, 5, 0, 4, 0, 2, 
            0, 4, 3, 4, 4, 3, 3, 0, 4, 0, 
            0, 5, 5
        }, {
            0, 4, 0, 4, 0, 5, 0, 1, 1, 3, 
            3, 4, 4, 3, 4, 1, 3, 0, 5, 1, 
            3, 0, 3, 1, 3, 1, 1, 0, 3, 0, 
            3, 3, 4, 0, 4, 3, 0, 4, 4, 4, 
            3, 4, 4, 0, 3, 5, 4, 1, 0, 3, 
            0, 0, 2, 3, 0, 3, 1, 0, 3, 1, 
            0, 3, 2, 1, 3, 5, 0, 3, 0, 1, 
            0, 3, 2, 3, 3, 4, 4, 0, 2, 2, 
            0, 4, 4
        }, {
            2, 4, 0, 5, 0, 4, 0, 3, 0, 4, 
            5, 5, 4, 3, 5, 3, 5, 3, 5, 3, 
            5, 2, 5, 3, 4, 3, 3, 4, 3, 4, 
            5, 3, 2, 1, 5, 4, 3, 2, 3, 4, 
            5, 3, 4, 1, 2, 5, 4, 3, 0, 3, 
            3, 0, 3, 2, 0, 2, 3, 0, 4, 1, 
            0, 3, 4, 3, 3, 5, 0, 3, 0, 1, 
            0, 4, 5, 5, 5, 4, 3, 0, 4, 2, 
            0, 3, 5
        }, {
            0, 5, 0, 4, 0, 4, 0, 2, 0, 5, 
            4, 3, 4, 3, 4, 3, 3, 3, 4, 3, 
            4, 2, 5, 3, 5, 3, 4, 1, 4, 3, 
            4, 4, 4, 0, 3, 5, 0, 4, 4, 4, 
            4, 5, 3, 1, 3, 4, 5, 3, 3, 3, 
            3, 3, 3, 3, 0, 2, 2, 0, 3, 3, 
            2, 4, 3, 3, 3, 5, 3, 4, 1, 3, 
            3, 5, 3, 2, 0, 0, 0, 0, 4, 3, 
            1, 3, 3
        }, {
            0, 1, 0, 3, 0, 3, 0, 1, 0, 1, 
            3, 3, 3, 2, 3, 3, 3, 0, 3, 0, 
            0, 0, 3, 1, 3, 0, 0, 0, 2, 2, 
            2, 3, 0, 0, 3, 2, 0, 1, 2, 4, 
            1, 3, 3, 0, 0, 3, 3, 3, 0, 1, 
            0, 0, 2, 1, 0, 0, 3, 0, 3, 1, 
            0, 3, 0, 0, 1, 3, 0, 2, 0, 1, 
            0, 3, 3, 1, 3, 3, 0, 0, 1, 1, 
            0, 3, 3
        }, {
            0, 2, 0, 3, 0, 2, 1, 4, 0, 2, 
            2, 3, 1, 1, 3, 1, 1, 0, 2, 0, 
            3, 1, 2, 3, 1, 3, 0, 0, 1, 0, 
            4, 3, 2, 3, 3, 3, 1, 4, 2, 3, 
            3, 3, 3, 1, 0, 3, 1, 4, 0, 1, 
            1, 0, 1, 2, 0, 1, 1, 0, 1, 1, 
            0, 3, 1, 3, 2, 2, 0, 1, 0, 0, 
            0, 2, 3, 3, 3, 1, 0, 0, 0, 0, 
            0, 2, 3
        }, {
            0, 5, 0, 4, 0, 5, 0, 2, 0, 4, 
            5, 5, 3, 3, 4, 3, 3, 1, 5, 4, 
            4, 2, 4, 4, 4, 3, 4, 2, 4, 3, 
            5, 5, 4, 3, 3, 4, 3, 3, 5, 5, 
            4, 5, 5, 1, 3, 4, 5, 3, 1, 4, 
            3, 1, 3, 3, 0, 3, 3, 1, 4, 3, 
            1, 4, 5, 3, 3, 5, 0, 4, 0, 3, 
            0, 5, 3, 3, 1, 4, 3, 0, 4, 0, 
            1, 5, 3
        }, {
            0, 5, 0, 5, 0, 4, 0, 2, 0, 4, 
            4, 3, 4, 3, 3, 3, 3, 3, 5, 4, 
            4, 4, 4, 4, 4, 5, 3, 3, 5, 2, 
            4, 4, 4, 3, 4, 4, 3, 3, 4, 4, 
            5, 5, 3, 3, 4, 3, 4, 3, 3, 4, 
            3, 3, 3, 3, 1, 2, 2, 1, 4, 3, 
            3, 5, 4, 4, 3, 4, 0, 4, 0, 3, 
            0, 4, 4, 4, 4, 4, 1, 0, 4, 2, 
            0, 2, 4
        }, {
            0, 4, 0, 4, 0, 3, 0, 1, 0, 3, 
            5, 2, 3, 0, 3, 0, 2, 1, 4, 2, 
            3, 3, 4, 1, 4, 3, 3, 2, 4, 1, 
            3, 3, 3, 0, 3, 3, 0, 0, 3, 3, 
            3, 5, 3, 3, 3, 3, 3, 2, 0, 2, 
            0, 0, 2, 0, 0, 2, 0, 0, 1, 0, 
            0, 3, 1, 2, 2, 3, 0, 3, 0, 2, 
            0, 4, 4, 3, 3, 4, 1, 0, 3, 0, 
            0, 2, 4
        }, {
            0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 
            1, 0, 1, 0, 2, 0, 0, 0, 0, 0, 
            1, 0, 2, 0, 1, 0, 0, 0, 0, 0, 
            3, 1, 3, 0, 3, 2, 0, 0, 0, 1, 
            0, 3, 2, 0, 0, 2, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 3, 4, 0, 2, 0, 0, 0, 0, 
            0, 0, 2
        }, {
            0, 2, 1, 3, 0, 2, 0, 2, 0, 3, 
            3, 3, 3, 1, 3, 1, 3, 3, 3, 3, 
            3, 3, 4, 2, 2, 1, 2, 1, 4, 0, 
            4, 3, 1, 3, 3, 3, 2, 4, 3, 5, 
            4, 3, 3, 3, 3, 3, 3, 3, 0, 1, 
            3, 0, 2, 0, 0, 1, 0, 0, 1, 0, 
            0, 4, 2, 0, 2, 3, 0, 3, 3, 0, 
            3, 3, 4, 2, 3, 1, 4, 0, 1, 2, 
            0, 2, 3
        }, {
            0, 3, 0, 3, 0, 1, 0, 3, 0, 2, 
            3, 3, 3, 0, 3, 1, 2, 0, 3, 3, 
            2, 3, 3, 2, 3, 2, 3, 1, 3, 0, 
            4, 3, 2, 0, 3, 3, 1, 4, 3, 3, 
            2, 3, 4, 3, 1, 3, 3, 1, 1, 0, 
            1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 
            0, 4, 1, 1, 0, 3, 0, 3, 1, 0, 
            2, 3, 3, 3, 3, 3, 1, 0, 0, 2, 
            0, 3, 3
        }, {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            3, 0, 2, 0, 3, 0, 0, 0, 0, 0, 
            0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 
            3, 0, 3, 0, 3, 1, 0, 1, 0, 1, 
            0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 
            2, 0, 2, 3, 0, 0, 0, 0, 0, 0, 
            0, 0, 3
        }, {
            0, 2, 0, 3, 1, 3, 0, 3, 0, 2, 
            3, 3, 3, 1, 3, 1, 3, 1, 3, 1, 
            3, 3, 3, 1, 3, 0, 2, 3, 1, 1, 
            4, 3, 3, 2, 3, 3, 1, 2, 2, 4, 
            1, 3, 3, 0, 1, 4, 2, 3, 0, 1, 
            3, 0, 3, 0, 0, 1, 3, 0, 2, 0, 
            0, 3, 3, 2, 1, 3, 0, 3, 0, 2, 
            0, 3, 4, 4, 4, 3, 1, 0, 3, 0, 
            0, 3, 3
        }, {
            0, 2, 0, 1, 0, 2, 0, 0, 0, 1, 
            3, 2, 2, 1, 3, 0, 1, 1, 3, 0, 
            3, 2, 3, 1, 2, 0, 2, 0, 1, 1, 
            3, 3, 3, 0, 3, 3, 1, 1, 2, 3, 
            2, 3, 3, 1, 2, 3, 2, 0, 0, 1, 
            0, 0, 0, 0, 0, 0, 3, 0, 1, 0, 
            0, 2, 1, 2, 1, 3, 0, 3, 0, 0, 
            0, 3, 4, 4, 4, 3, 2, 0, 2, 0, 
            0, 2, 4
        }, {
            0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 
            1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 
            0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 2, 2, 0, 0, 0, 1, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 
            0, 0, 1, 3, 1, 0, 0, 0, 0, 0, 
            0, 0, 3
        }, {
            0, 3, 0, 3, 0, 2, 0, 3, 0, 3, 
            3, 3, 2, 3, 2, 2, 2, 0, 3, 1, 
            3, 3, 3, 2, 3, 3, 0, 0, 3, 0, 
            3, 2, 2, 0, 2, 3, 1, 4, 3, 4, 
            3, 3, 2, 3, 1, 5, 4, 4, 0, 3, 
            1, 2, 1, 3, 0, 3, 1, 1, 2, 0, 
            2, 3, 1, 3, 1, 3, 0, 3, 0, 1, 
            0, 3, 3, 4, 4, 2, 1, 0, 2, 1, 
            0, 2, 4
        }, {
            0, 1, 0, 3, 0, 1, 0, 2, 0, 1, 
            4, 2, 5, 1, 4, 0, 2, 0, 2, 1, 
            3, 1, 4, 0, 2, 1, 0, 0, 2, 1, 
            4, 1, 1, 0, 3, 3, 0, 5, 1, 3, 
            2, 3, 3, 1, 0, 3, 2, 3, 0, 1, 
            0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 
            0, 4, 0, 1, 0, 3, 0, 2, 0, 1, 
            0, 3, 3, 3, 4, 3, 3, 0, 0, 0, 
            0, 2, 3
        }, {
            0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 
            2, 0, 1, 0, 0, 0, 0, 0, 1, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            3, 0, 0, 0, 0, 0, 0, 1, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 2, 1, 0, 0, 1, 0, 0, 0, 
            0, 0, 3
        }, {
            0, 1, 0, 3, 0, 4, 0, 3, 0, 2, 
            4, 3, 1, 0, 3, 2, 2, 1, 3, 1, 
            2, 2, 3, 1, 1, 1, 2, 1, 3, 0, 
            1, 2, 0, 1, 3, 2, 1, 3, 0, 5, 
            5, 1, 0, 0, 1, 3, 2, 1, 0, 3, 
            0, 0, 1, 0, 0, 0, 0, 0, 3, 4, 
            0, 1, 1, 1, 3, 2, 0, 2, 0, 1, 
            0, 2, 3, 3, 1, 2, 3, 0, 1, 0, 
            1, 0, 4
        }, {
            0, 0, 0, 1, 0, 3, 0, 3, 0, 2, 
            2, 1, 0, 0, 4, 0, 3, 0, 3, 1, 
            3, 0, 3, 0, 3, 0, 1, 0, 3, 0, 
            3, 1, 3, 0, 3, 3, 0, 0, 1, 2, 
            1, 1, 1, 0, 1, 2, 0, 0, 0, 1, 
            0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 
            0, 2, 2, 1, 2, 0, 0, 2, 0, 0, 
            0, 0, 2, 3, 3, 3, 3, 0, 0, 0, 
            0, 1, 4
        }, {
            0, 0, 0, 3, 0, 3, 0, 0, 0, 0, 
            3, 1, 1, 0, 3, 0, 1, 0, 2, 0, 
            1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 
            3, 0, 2, 0, 2, 3, 0, 0, 2, 2, 
            3, 1, 2, 0, 0, 1, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 3, 0, 0, 2, 0, 0, 0, 
            0, 2, 3
        }, {
            2, 4, 0, 5, 0, 5, 0, 4, 0, 3, 
            4, 3, 3, 3, 4, 3, 3, 3, 4, 3, 
            4, 4, 5, 4, 5, 5, 5, 2, 3, 0, 
            5, 5, 4, 1, 5, 4, 3, 1, 5, 4, 
            3, 4, 4, 3, 3, 4, 3, 3, 0, 3, 
            2, 0, 2, 3, 0, 3, 0, 0, 3, 3, 
            0, 5, 3, 2, 3, 3, 0, 3, 0, 3, 
            0, 3, 4, 5, 4, 5, 3, 0, 4, 3, 
            0, 3, 4
        }, {
            0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 
            3, 4, 3, 2, 3, 2, 3, 0, 4, 3, 
            3, 3, 3, 3, 3, 3, 3, 0, 3, 2, 
            4, 3, 3, 1, 3, 4, 3, 4, 4, 4, 
            3, 4, 4, 3, 2, 4, 4, 1, 0, 2, 
            0, 0, 1, 1, 0, 2, 0, 0, 3, 1, 
            0, 5, 3, 2, 1, 3, 0, 3, 0, 1, 
            2, 4, 3, 2, 4, 3, 3, 0, 3, 2, 
            0, 4, 4
        }, {
            0, 3, 0, 3, 0, 1, 0, 0, 0, 1, 
            4, 3, 3, 2, 3, 1, 3, 1, 4, 2, 
            3, 2, 4, 2, 3, 4, 3, 0, 2, 2, 
            3, 3, 3, 0, 3, 3, 3, 0, 3, 4, 
            1, 3, 3, 0, 3, 4, 3, 3, 0, 1, 
            1, 0, 1, 0, 0, 0, 4, 0, 3, 0, 
            0, 3, 1, 2, 1, 3, 0, 4, 0, 1, 
            0, 4, 3, 3, 4, 3, 3, 0, 2, 0, 
            0, 3, 3
        }, {
            0, 3, 0, 4, 0, 1, 0, 3, 0, 3, 
            4, 3, 3, 0, 3, 3, 3, 1, 3, 1, 
            3, 3, 4, 3, 3, 3, 0, 0, 3, 1, 
            5, 3, 3, 1, 3, 3, 2, 5, 4, 3, 
            3, 4, 5, 3, 2, 5, 3, 4, 0, 1, 
            0, 0, 0, 0, 0, 2, 0, 0, 1, 1, 
            0, 4, 2, 2, 1, 3, 0, 3, 0, 2, 
            0, 4, 4, 3, 5, 3, 2, 0, 1, 1, 
            0, 3, 4
        }, {
            0, 5, 0, 4, 0, 5, 0, 2, 0, 4, 
            4, 3, 3, 2, 3, 3, 3, 1, 4, 3, 
            4, 1, 5, 3, 4, 3, 4, 0, 4, 2, 
            4, 3, 4, 1, 5, 4, 0, 4, 4, 4, 
            4, 5, 4, 1, 3, 5, 4, 2, 1, 4, 
            1, 1, 3, 2, 0, 3, 1, 0, 3, 2, 
            1, 4, 3, 3, 3, 4, 0, 4, 0, 3, 
            0, 4, 4, 4, 3, 3, 3, 0, 4, 2, 
            0, 3, 4
        }, {
            1, 4, 0, 4, 0, 3, 0, 1, 0, 3, 
            3, 3, 1, 1, 3, 3, 2, 2, 3, 3, 
            1, 0, 3, 2, 2, 1, 2, 0, 3, 1, 
            2, 1, 2, 0, 3, 2, 0, 2, 2, 3, 
            3, 4, 3, 0, 3, 3, 1, 2, 0, 1, 
            1, 3, 1, 2, 0, 0, 3, 0, 1, 1, 
            0, 3, 2, 2, 3, 3, 0, 3, 0, 0, 
            0, 2, 3, 3, 4, 3, 3, 0, 1, 0, 
            0, 1, 4
        }, {
            0, 4, 0, 4, 0, 4, 0, 0, 0, 3, 
            4, 4, 3, 1, 4, 2, 3, 2, 3, 3, 
            3, 1, 4, 3, 4, 0, 3, 0, 4, 2, 
            3, 3, 2, 2, 5, 4, 2, 1, 3, 4, 
            3, 4, 3, 1, 3, 3, 4, 2, 0, 2, 
            1, 0, 3, 3, 0, 0, 2, 0, 3, 1, 
            0, 4, 4, 3, 4, 3, 0, 4, 0, 1, 
            0, 2, 4, 4, 4, 4, 4, 0, 3, 2, 
            0, 3, 3
        }, {
            0, 0, 0, 1, 0, 4, 0, 0, 0, 0, 
            0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 
            0, 0, 1, 0, 3, 2, 0, 0, 1, 0, 
            0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 
            0, 0, 2
        }, {
            0, 2, 0, 3, 0, 4, 0, 4, 0, 1, 
            3, 3, 3, 0, 4, 0, 2, 1, 2, 1, 
            1, 1, 2, 0, 3, 1, 1, 0, 1, 0, 
            3, 1, 0, 0, 3, 3, 2, 0, 1, 1, 
            0, 0, 0, 0, 0, 1, 0, 2, 0, 2, 
            2, 0, 3, 1, 0, 0, 1, 0, 1, 1, 
            0, 1, 2, 0, 3, 0, 0, 0, 0, 1, 
            0, 0, 3, 3, 4, 3, 1, 0, 1, 0, 
            3, 0, 2
        }, {
            0, 0, 0, 3, 0, 5, 0, 0, 0, 0, 
            1, 0, 2, 0, 3, 1, 0, 1, 3, 0, 
            0, 0, 2, 0, 0, 0, 1, 0, 0, 0, 
            1, 1, 0, 0, 4, 0, 0, 0, 2, 3, 
            0, 1, 4, 1, 0, 2, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 
            0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 
            0, 0, 0, 2, 0, 0, 3, 0, 0, 0, 
            0, 0, 3
        }, {
            0, 2, 0, 5, 0, 5, 0, 1, 0, 2, 
            4, 3, 3, 2, 5, 1, 3, 2, 3, 3, 
            3, 0, 4, 1, 2, 0, 3, 0, 4, 0, 
            2, 2, 1, 1, 5, 3, 0, 0, 1, 4, 
            2, 3, 2, 0, 3, 3, 3, 2, 0, 2, 
            4, 1, 1, 2, 0, 1, 1, 0, 3, 1, 
            0, 1, 3, 1, 2, 3, 0, 2, 0, 0, 
            0, 1, 3, 5, 4, 4, 4, 0, 3, 0, 
            0, 1, 3
        }, {
            0, 4, 0, 5, 0, 4, 0, 4, 0, 4, 
            5, 4, 3, 3, 4, 3, 3, 3, 4, 3, 
            4, 4, 5, 3, 4, 5, 4, 2, 4, 2, 
            3, 4, 3, 1, 4, 4, 1, 3, 5, 4, 
            4, 5, 5, 4, 4, 5, 5, 5, 2, 3, 
            3, 1, 4, 3, 1, 3, 3, 0, 3, 3, 
            1, 4, 3, 4, 4, 4, 0, 3, 0, 4, 
            0, 3, 3, 4, 4, 5, 0, 0, 4, 3, 
            0, 4, 5
        }, {
            0, 4, 0, 4, 0, 3, 0, 3, 0, 3, 
            4, 4, 4, 3, 3, 2, 4, 3, 4, 3, 
            4, 3, 5, 3, 4, 3, 2, 1, 4, 2, 
            4, 4, 3, 1, 3, 4, 2, 4, 5, 5, 
            3, 4, 5, 4, 1, 5, 4, 3, 0, 3, 
            2, 2, 3, 2, 1, 3, 1, 0, 3, 3, 
            3, 5, 3, 3, 3, 5, 4, 4, 2, 3, 
            3, 4, 3, 3, 3, 2, 1, 0, 3, 2, 
            1, 4, 3
        }, {
            0, 4, 0, 5, 0, 4, 0, 3, 0, 3, 
            5, 5, 3, 2, 4, 3, 4, 0, 5, 4, 
            4, 1, 4, 4, 4, 3, 3, 3, 4, 3, 
            5, 5, 2, 3, 3, 4, 1, 2, 5, 5, 
            3, 5, 5, 2, 3, 5, 5, 4, 0, 3, 
            2, 0, 3, 3, 1, 1, 5, 1, 4, 1, 
            0, 4, 3, 2, 3, 5, 0, 4, 0, 3, 
            0, 5, 4, 3, 4, 3, 0, 0, 4, 1, 
            0, 4, 4
        }, {
            1, 3, 0, 4, 0, 2, 0, 2, 0, 2, 
            5, 5, 3, 3, 3, 3, 3, 0, 4, 2, 
            3, 4, 4, 4, 3, 4, 0, 0, 3, 4, 
            5, 4, 3, 3, 3, 3, 2, 5, 5, 4, 
            5, 5, 5, 4, 3, 5, 5, 5, 1, 3, 
            1, 0, 1, 0, 0, 3, 2, 0, 4, 2, 
            0, 5, 2, 3, 2, 4, 1, 3, 0, 3, 
            0, 4, 5, 4, 5, 4, 3, 0, 4, 2, 
            0, 5, 4
        }, {
            0, 3, 0, 4, 0, 5, 0, 3, 0, 3, 
            4, 4, 3, 2, 3, 2, 3, 3, 3, 3, 
            3, 2, 4, 3, 3, 2, 2, 0, 3, 3, 
            3, 3, 3, 1, 3, 3, 3, 0, 4, 4, 
            3, 4, 4, 1, 1, 4, 4, 2, 0, 3, 
            1, 0, 1, 1, 0, 4, 1, 0, 2, 3, 
            1, 3, 3, 1, 3, 4, 0, 3, 0, 1, 
            0, 3, 1, 3, 0, 0, 1, 0, 2, 0, 
            0, 4, 4
        }, {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0
        }, {
            0, 3, 0, 3, 0, 2, 0, 3, 0, 1, 
            5, 4, 3, 3, 3, 1, 4, 2, 1, 2, 
            3, 4, 4, 2, 4, 4, 5, 0, 3, 1, 
            4, 3, 4, 0, 4, 3, 3, 3, 2, 3, 
            2, 5, 3, 4, 3, 2, 2, 3, 0, 0, 
            3, 0, 2, 1, 0, 1, 2, 0, 0, 0, 
            0, 2, 1, 1, 3, 1, 0, 2, 0, 4, 
            0, 3, 4, 4, 4, 5, 2, 0, 2, 0, 
            0, 1, 3
        }, {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 
            1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 
            4, 2, 1, 1, 0, 1, 0, 3, 2, 0, 
            0, 3, 1, 1, 1, 2, 2, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 3, 0, 1, 0, 0, 0, 2, 0, 0, 
            0, 1, 4, 0, 4, 2, 1, 0, 0, 0, 
            0, 0, 1
        }, {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 
            0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 
            0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 
            3, 1, 0, 0, 0, 2, 0, 2, 1, 0, 
            0, 1, 2, 1, 0, 1, 1, 0, 0, 3, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 1, 3, 1, 0, 0, 0, 0, 0, 1, 
            0, 0, 2, 1, 0, 0, 0, 0, 0, 0, 
            0, 0, 2
        }, {
            0, 4, 0, 4, 0, 4, 0, 3, 0, 4, 
            4, 3, 4, 2, 4, 3, 2, 0, 4, 4, 
            4, 3, 5, 3, 5, 3, 3, 2, 4, 2, 
            4, 3, 4, 3, 1, 4, 0, 2, 3, 4, 
            4, 4, 3, 3, 3, 4, 4, 4, 3, 4, 
            1, 3, 4, 3, 2, 1, 2, 1, 3, 3, 
            3, 4, 4, 3, 3, 5, 0, 4, 0, 3, 
            0, 4, 3, 3, 3, 2, 1, 0, 3, 0, 
            0, 3, 3
        }, {
            0, 4, 0, 3, 0, 3, 0, 3, 0, 3, 
            5, 5, 3, 3, 3, 3, 4, 3, 4, 3, 
            3, 3, 4, 4, 4, 3, 3, 3, 3, 4, 
            3, 5, 3, 3, 1, 3, 2, 4, 5, 5, 
            5, 5, 4, 3, 4, 5, 5, 3, 2, 2, 
            3, 3, 3, 3, 2, 3, 3, 1, 2, 3, 
            2, 4, 3, 3, 3, 4, 0, 4, 0, 2, 
            0, 4, 3, 2, 2, 1, 2, 0, 3, 0, 
            0, 4, 1
        }
    };
    private int b[];
    private int c;
    private int d;
    private int e;
    private boolean f;
    private c g;

    public b()
    {
        b = new int[6];
        g = new c(this);
        b();
    }

    public final float a()
    {
        if (c > 4)
        {
            return (float)(c - b[0]) / (float)c;
        } else
        {
            return -1F;
        }
    }

    protected abstract int a(byte abyte0[], int i);

    public final void a(byte abyte0[], int i, int j)
    {
        if (c > 1000)
        {
            f = true;
        }
        if (f)
        {
            return;
        }
        int k;
        if (j == 2)
        {
            k = a(abyte0, i);
        } else
        {
            k = -1;
        }
        if (k != -1 && d != -1)
        {
            c = 1 + c;
            int ai[] = b;
            byte byte0 = a[d][k];
            ai[byte0] = 1 + ai[byte0];
        }
        d = k;
    }

    public final void b()
    {
        c = 0;
        for (int i = 0; i < 6; i++)
        {
            b[i] = 0;
        }

        e = 0;
        d = -1;
        f = false;
    }

    public final boolean c()
    {
        return c > 100;
    }

}
