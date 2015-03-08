// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// Referenced classes of package com.mobeta.android.dslv:
//            DragSortListView

final class m
{

    StringBuilder a;
    File b;
    int c;
    int d;
    boolean e;
    final DragSortListView f;

    public m(DragSortListView dragsortlistview)
    {
        f = dragsortlistview;
        super();
        a = new StringBuilder();
        c = 0;
        d = 0;
        e = false;
        b = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
        if (b.exists())
        {
            break MISSING_BLOCK_LABEL_77;
        }
        b.createNewFile();
        Log.d("mobeta", "file created");
        return;
        IOException ioexception;
        ioexception;
        Log.w("mobeta", "Could not create dslv_state.txt");
        Log.d("mobeta", ioexception.getMessage());
        return;
    }

    public final void a()
    {
        if (!e)
        {
            return;
        }
        int i;
        boolean flag;
        FileWriter filewriter;
        try
        {
            i = d;
        }
        catch (IOException ioexception)
        {
            return;
        }
        flag = false;
        if (i != 0)
        {
            flag = true;
        }
        filewriter = new FileWriter(b, flag);
        filewriter.write(a.toString());
        a.delete(0, a.length());
        filewriter.flush();
        filewriter.close();
        d = 1 + d;
        return;
    }
}
