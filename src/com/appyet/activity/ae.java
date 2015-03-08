// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import com.appyet.context.ApplicationContext;
import com.appyet.manager.bp;

// Referenced classes of package com.appyet.activity:
//            TranslateActivity

final class ae
    implements android.widget.AdapterView.OnItemSelectedListener
{

    final TranslateActivity a;

    ae(TranslateActivity translateactivity)
    {
        a = translateactivity;
        super();
    }

    public final void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        TranslateActivity.a(a, a.getResources().getStringArray(0x7f0e000f)[i]);
        TranslateActivity.a(a).d.e(i);
    }

    public final void onNothingSelected(AdapterView adapterview)
    {
    }
}
