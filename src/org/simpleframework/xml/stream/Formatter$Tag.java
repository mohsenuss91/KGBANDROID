// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;


final class  extends Enum
{

    private static final .VALUES $VALUES[];
    public static final .VALUES COMMENT;
    public static final .VALUES END;
    public static final .VALUES START;
    public static final .VALUES TEXT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(org/simpleframework/xml/stream/Formatter$Tag, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        COMMENT = new <init>("COMMENT", 0);
        START = new <init>("START", 1);
        TEXT = new <init>("TEXT", 2);
        END = new <init>("END", 3);
        g_3B_.clone aclone[] = new <init>[4];
        aclone[0] = COMMENT;
        aclone[1] = START;
        aclone[2] = TEXT;
        aclone[3] = END;
        $VALUES = aclone;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
