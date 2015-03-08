// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.content.DialogInterface;
import android.content.Intent;
import com.appyet.context.ApplicationContext;
import com.appyet.manager.bp;
import com.appyet.manager.bw;
import com.appyet.metadata.Metadata;
import com.appyet.metadata.MetadataTheme;
import java.util.List;

// Referenced classes of package com.appyet.activity:
//            MainActivity

final class o
    implements android.content.DialogInterface.OnClickListener
{

    final MainActivity a;

    o(MainActivity mainactivity)
    {
        a = mainactivity;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        MainActivity.b(a).d.b(((MetadataTheme)MainActivity.b(a).q.MetadataThemes.get(i)).Guid);
        dialoginterface.dismiss();
        MainActivity.b(a).m.a();
        a.finish();
        Intent intent = new Intent(a, com/appyet/activity/MainActivity);
        intent.addFlags(0x4000000);
        intent.addFlags(0x10000000);
        a.startActivity(intent);
    }
}
