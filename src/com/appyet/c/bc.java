// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import com.appyet.context.ApplicationContext;
import com.appyet.data.Feed;
import com.appyet.data.Module;
import com.appyet.f.a;
import com.appyet.manager.d;
import com.appyet.metadata.Metadata;
import com.appyet.metadata.MetadataModule;
import com.appyet.metadata.MetadataModuleFeedSql;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.appyet.c:
//            ay, bb, ba

final class bc extends a
{

    boolean a;
    Hashtable b;
    final ay c;

    bc(ay ay1)
    {
        c = ay1;
        super();
        a = false;
    }

    private transient Void f()
    {
        try
        {
            if (c.e == null)
            {
                c.e = c.a.h.j();
            }
            c.c = c.a.h.d();
            b = new Hashtable();
            Iterator iterator = c.a.q.MetadataModuleFeedSqls.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break MISSING_BLOCK_LABEL_246;
                }
                MetadataModuleFeedSql metadatamodulefeedsql = (MetadataModuleFeedSql)iterator.next();
                Iterator iterator1 = c.a.q.MetadataModules.iterator();
label0:
                do
                {
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    MetadataModule metadatamodule = (MetadataModule)iterator1.next();
                    if (metadatamodule.Id != metadatamodulefeedsql.ModuleId)
                    {
                        continue;
                    }
                    Iterator iterator2 = c.e.iterator();
                    Module module;
                    do
                    {
                        if (!iterator2.hasNext())
                        {
                            continue label0;
                        }
                        module = (Module)iterator2.next();
                    } while (!metadatamodule.Guid.equals(module.getGuid()));
                    b.put(module.getModuleId(), Long.valueOf(c.a.h.b(metadatamodulefeedsql.Query)));
                } while (true);
            } while (true);
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        return null;
    }

    protected final void a()
    {
        super.a();
    }

    protected final void a(Object obj)
    {
        super.a((Void)obj);
        if (com.appyet.c.ay.a(c)) goto _L2; else goto _L1
_L1:
        if (c.e == null || c.e.size() <= 0) goto _L4; else goto _L3
_L3:
        String s = ((Module)c.e.get(0)).getGroupName();
        if (s == null) goto _L6; else goto _L5
_L5:
        if (s.trim().length() > 0)
        {
            c.d.add(new bb(c, s, null, null, null, null, true, null));
        }
          goto _L6
_L17:
        int l;
        if (l >= c.e.size()) goto _L8; else goto _L7
_L7:
        Module module;
        String s2;
        module = (Module)c.e.get(l);
        s2 = module.getGroupName();
        if (s2 == null) goto _L10; else goto _L9
_L9:
        String s1;
        if (s2.trim().length() <= 0 || s1 == null) goto _L10; else goto _L11
_L11:
        if (s1.trim().length() <= 0 || s2.equals(s1)) goto _L10; else goto _L12
_L12:
        bb bb2;
        c.d.add(new bb(c, s2, null, null, null, null, true, null));
        bb2.g = true;
        String s3 = s2;
_L39:
        if (module.getIcon() != null) goto _L14; else goto _L13
_L13:
        if (!module.getType().equals("Downloads")) goto _L16; else goto _L15
_L15:
        module.setIcon("download.png");
_L14:
        bb bb3;
        bb3 = new bb(c, module.getName(), module.getStatusLabel(), module.getType(), module.getModuleId(), module.getIcon(), false, module.getGuid());
        c.d.add(bb3);
        l++;
        s1 = s3;
        bb2 = bb3;
          goto _L17
_L16:
        if (!module.getType().equals("Sync")) goto _L19; else goto _L18
_L18:
        Exception exception;
        module.setIcon("sync_now.png");
          goto _L14
_L34:
        return;
_L19:
label0:
        {
            if (!module.getType().equals("Themes"))
            {
                break label0;
            }
            module.setIcon("switch_theme.png");
        }
          goto _L14
        if (!module.getType().equals("Settings")) goto _L21; else goto _L20
_L20:
        module.setIcon("settings.png");
          goto _L14
_L21:
        if (!module.getType().equals("Customize")) goto _L14; else goto _L22
_L22:
        module.setIcon("customize.png");
          goto _L14
_L8:
        bb2.g = true;
_L4:
        c.setListAdapter(c.d);
        ay.b(c);
          goto _L2
_L40:
        int i;
        bb bb1;
        if (i >= c.d.getCount())
        {
            continue; /* Loop/switch isn't completed */
        }
        bb1 = (bb)c.d.getItem(i);
        if (bb1.c == null)
        {
            break MISSING_BLOCK_LABEL_779;
        }
        if (!bb1.c.equals("Feed")) goto _L24; else goto _L23
_L23:
        Iterator iterator = c.c.iterator();
        int j = 0;
_L41:
        if (!iterator.hasNext()) goto _L26; else goto _L25
_L25:
        Feed feed = (Feed)iterator.next();
        if (feed.getModuleId() != bb1.d.longValue()) goto _L28; else goto _L27
_L27:
        int k = (int)((long)j + feed.getUnreadCount());
          goto _L29
_L26:
        if (bb1.b == null) goto _L31; else goto _L30
_L30:
        if (j == 0) goto _L33; else goto _L32
_L32:
        if (bb1.b.equals(String.valueOf(j)))
        {
            break MISSING_BLOCK_LABEL_779;
        }
        bb1.b = String.valueOf(j);
_L37:
        a = true;
        break MISSING_BLOCK_LABEL_779;
_L31:
        if (j == 0)
        {
            break MISSING_BLOCK_LABEL_779;
        }
        try
        {
            bb1.b = String.valueOf(j);
            a = true;
            break MISSING_BLOCK_LABEL_779;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
          goto _L34
_L24:
        Long long1;
        if (!bb1.c.equals("FeedQuery"))
        {
            break MISSING_BLOCK_LABEL_779;
        }
        long1 = (Long)b.get(bb1.d);
        if (long1 == null) goto _L33; else goto _L35
_L35:
        if (long1.longValue() <= 0L) goto _L33; else goto _L36
_L36:
        bb1.b = String.valueOf(long1);
          goto _L37
_L33:
        bb1.b = null;
          goto _L37
        if (!a) goto _L34; else goto _L38
_L38:
        c.d.notifyDataSetChanged();
        return;
_L28:
        k = j;
          goto _L29
_L10:
        s3 = s1;
          goto _L39
_L6:
        s1 = s;
        bb2 = null;
        l = 0;
          goto _L17
_L2:
        i = 0;
          goto _L40
_L29:
        j = k;
          goto _L41
        i++;
          goto _L40
    }

    protected final Object b()
    {
        return f();
    }
}
