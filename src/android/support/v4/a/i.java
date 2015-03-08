// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package android.support.v4.a:
//            j, k, l

public final class i
{

    private static final Object f = new Object();
    private static i g;
    private final Context a;
    private final HashMap b = new HashMap();
    private final HashMap c = new HashMap();
    private final ArrayList d = new ArrayList();
    private final Handler e;

    private i(Context context)
    {
        a = context;
        e = new j(this, context.getMainLooper());
    }

    public static i a(Context context)
    {
        i i1;
        synchronized (f)
        {
            if (g == null)
            {
                g = new i(context.getApplicationContext());
            }
            i1 = g;
        }
        return i1;
    }

    static void a(i i1)
    {
_L4:
        HashMap hashmap = i1.b;
        hashmap;
        JVM INSTR monitorenter ;
        int j1 = i1.d.size();
        if (j1 > 0)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        hashmap;
        JVM INSTR monitorexit ;
        return;
        k ak[];
        ak = new k[j1];
        i1.d.toArray(ak);
        i1.d.clear();
        hashmap;
        JVM INSTR monitorexit ;
        int k1 = 0;
_L2:
        if (k1 < ak.length)
        {
            k k2 = ak[k1];
            for (int l1 = 0; l1 < k2.b.size(); l1++)
            {
                ((l)k2.b.get(l1)).b.onReceive(i1.a, k2.a);
            }

            break MISSING_BLOCK_LABEL_120;
        }
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        throw exception;
        k1++;
        if (true) goto _L2; else goto _L1
_L1:
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final boolean a(Intent intent)
    {
        HashMap hashmap = b;
        hashmap;
        JVM INSTR monitorenter ;
        String s;
        String s1;
        android.net.Uri uri;
        String s2;
        java.util.Set set;
        s = intent.getAction();
        s1 = intent.resolveTypeIfNeeded(a.getContentResolver());
        uri = intent.getData();
        s2 = intent.getScheme();
        set = intent.getCategories();
        ArrayList arraylist1;
        int j1;
        ArrayList arraylist2;
        String s3;
        Exception exception;
        boolean flag;
        ArrayList arraylist;
        int i1;
        l l1;
        int k1;
        if ((8 & intent.getFlags()) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        Log.v("LocalBroadcastManager", (new StringBuilder("Resolving type ")).append(s1).append(" scheme ").append(s2).append(" of intent ").append(intent).toString());
        arraylist = (ArrayList)c.get(intent.getAction());
        if (arraylist == null) goto _L2; else goto _L1
_L1:
        if (!flag) goto _L4; else goto _L3
_L3:
        Log.v("LocalBroadcastManager", (new StringBuilder("Action list: ")).append(arraylist).toString());
          goto _L4
_L24:
        if (i1 >= arraylist.size()) goto _L6; else goto _L5
_L5:
        l1 = (l)arraylist.get(i1);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_209;
        }
        Log.v("LocalBroadcastManager", (new StringBuilder("Matching against filter ")).append(l1.a).toString());
        if (!l1.c) goto _L8; else goto _L7
_L7:
        if (!flag) goto _L10; else goto _L9
_L9:
        Log.v("LocalBroadcastManager", "  Filter's target already added");
        arraylist2 = arraylist1;
          goto _L11
_L8:
        k1 = l1.a.match(s, s1, s2, uri, set, "LocalBroadcastManager");
        if (k1 < 0) goto _L13; else goto _L12
_L12:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_295;
        }
        Log.v("LocalBroadcastManager", (new StringBuilder("  Filter matched!  match=0x")).append(Integer.toHexString(k1)).toString());
        if (arraylist1 != null) goto _L15; else goto _L14
_L14:
        arraylist2 = new ArrayList();
_L23:
        arraylist2.add(l1);
        l1.c = true;
          goto _L11
        exception;
        throw exception;
_L13:
        if (!flag) goto _L10; else goto _L16
_L16:
        k1;
        JVM INSTR tableswitch -4 -1: default 368
    //                   -4 520
    //                   -3 513
    //                   -2 527
    //                   -1 534;
           goto _L17 _L18 _L19 _L20 _L21
_L17:
        s3 = "unknown reason";
_L25:
        Log.v("LocalBroadcastManager", (new StringBuilder("  Filter did not match: ")).append(s3).toString());
          goto _L10
_L22:
        if (j1 >= arraylist1.size())
        {
            break MISSING_BLOCK_LABEL_428;
        }
        ((l)arraylist1.get(j1)).c = false;
        j1++;
          goto _L22
        d.add(new k(intent, arraylist1));
        if (!e.hasMessages(1))
        {
            e.sendEmptyMessage(1);
        }
        hashmap;
        JVM INSTR monitorexit ;
        return true;
_L2:
        hashmap;
        JVM INSTR monitorexit ;
        return false;
_L15:
        arraylist2 = arraylist1;
          goto _L23
_L4:
        arraylist1 = null;
        i1 = 0;
          goto _L24
_L11:
        i1++;
        arraylist1 = arraylist2;
          goto _L24
_L10:
        arraylist2 = arraylist1;
          goto _L11
_L19:
        s3 = "action";
          goto _L25
_L18:
        s3 = "category";
          goto _L25
_L20:
        s3 = "data";
          goto _L25
_L21:
        s3 = "type";
          goto _L25
_L6:
        if (arraylist1 == null) goto _L2; else goto _L26
_L26:
        j1 = 0;
          goto _L22
    }

}
