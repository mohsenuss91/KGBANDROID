// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity.forum;

import android.content.DialogInterface;

// Referenced classes of package com.appyet.activity.forum:
//            ForumNewTopicActivity

final class a
    implements android.content.DialogInterface.OnClickListener
{

    final ForumNewTopicActivity a;

    a(ForumNewTopicActivity forumnewtopicactivity)
    {
        a = forumnewtopicactivity;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        a.finish();
    }
}
