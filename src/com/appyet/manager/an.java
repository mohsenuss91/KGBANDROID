// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import com.appyet.a.a.a;
import com.appyet.a.a.b;
import com.appyet.a.a.d;
import com.appyet.a.a.e;
import com.appyet.a.a.f;
import com.appyet.context.ApplicationContext;
import com.appyet.context.g;
import com.appyet.data.Forum;
import com.appyet.f.z;
import com.appyet.g.c;
import com.appyet.g.l;
import com.appyet.g.p;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.appyet.manager:
//            d, ao

public final class an
{

    private static final Pattern b = Pattern.compile("\\[IMG[l|r]?\\](.+?)\\[/IMG[l|r]?\\]", 2);
    private static final Pattern c = Pattern.compile("\\[IMG\\](.*)\\[/IMG\\]", 2);
    private static final Pattern d = Pattern.compile("\\[QUOTE(.*)\\]((?s).*?)\\[/QUOTE\\]", 2);
    private static final Pattern e = Pattern.compile("\\[URL=\"?(.+?)\"?\\](.+?)\\[/URL\\]", 2);
    private static final Pattern f = Pattern.compile("\\[URL\\](.+?)\\[/URL\\]", 2);
    private ApplicationContext a;

    public an(ApplicationContext applicationcontext)
    {
        a = applicationcontext;
    }

    public static String a(d d1, String s, boolean flag)
    {
        String s1 = d1.a;
        if (!s1.endsWith("/"))
        {
            s1 = (new StringBuilder()).append(s1).append("/").toString();
        }
        if (d1.a() && flag)
        {
            return (new StringBuilder()).append(s1).append("announcement.php?a=").append(s).toString();
        } else
        {
            return (new StringBuilder()).append(s1).append("showthread.php?t=").append(s).toString();
        }
    }

    private static String a(String s)
    {
        StringBuffer stringbuffer;
        Matcher matcher;
        try
        {
            stringbuffer = new StringBuffer();
            String s2;
            for (matcher = c.matcher(s); matcher.find(); matcher.appendReplacement(stringbuffer, (new StringBuilder("<img src=\"")).append(z.a(s2)).append("\">").toString()))
            {
                s2 = matcher.group(1);
            }

        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return s;
        }
        String s1;
        matcher.appendTail(stringbuffer);
        s1 = stringbuffer.toString();
        return s1;
    }

    private void a(Map map, d d1, a a1)
    {
        if (map.containsKey("forum_id"))
        {
            a1.a = (String)map.get("forum_id");
        }
        if (map.containsKey("forum_name"))
        {
            a1.b = new String((byte[])(byte[])map.get("forum_name"));
        }
        if (map.containsKey("description"))
        {
            a1.c = new String((byte[])(byte[])map.get("description"));
        }
        if (map.containsKey("parent_id"))
        {
            a1.d = (String)map.get("parent_id");
        }
        if (map.containsKey("logo_url"))
        {
            a1.e = (String)map.get("logo_url");
        }
        if (map.containsKey("new_post"))
        {
            a1.f = ((Boolean)map.get("new_post")).booleanValue();
        }
        if (map.containsKey("is_protected"))
        {
            a1.g = ((Boolean)map.get("is_protected")).booleanValue();
        }
        if (map.containsKey("is_subscribed"))
        {
            a1.h = ((Boolean)map.get("is_subscribed")).booleanValue();
        }
        if (map.containsKey("can_subscribe"))
        {
            a1.i = ((Boolean)map.get("can_subscribe")).booleanValue();
        }
        if (map.containsKey("url"))
        {
            a1.j = (String)map.get("url");
        }
        if (map.containsKey("sub_only"))
        {
            a1.k = ((Boolean)map.get("sub_only")).booleanValue();
        }
        if (map.containsKey("child"))
        {
            Object aobj[] = (Object[])(Object[])map.get("child");
            if (aobj != null)
            {
                int i = aobj.length;
                for (int j = 0; j < i; j++)
                {
                    Map map1 = (Map)aobj[j];
                    a a2 = new a();
                    a(map1, d1, a2);
                    d1.b.add(a2);
                }

            }
        }
    }

    private static String b(String s)
    {
        StringBuffer stringbuffer;
        Matcher matcher;
        try
        {
            stringbuffer = new StringBuffer();
            String s2;
            String s3;
            for (matcher = e.matcher(s); matcher.find(); matcher.appendReplacement(stringbuffer, (new StringBuilder("<a href=\"")).append(z.a(s2)).append("\">").append(s3).append("</a>").toString()))
            {
                s2 = matcher.group(1);
                s3 = matcher.group(2);
            }

        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return s;
        }
        String s1;
        matcher.appendTail(stringbuffer);
        s1 = stringbuffer.toString();
        return s1;
    }

    private static String c(String s)
    {
        StringBuffer stringbuffer;
        Matcher matcher;
        try
        {
            stringbuffer = new StringBuffer();
            String s2;
            for (matcher = f.matcher(s); matcher.find(); matcher.appendReplacement(stringbuffer, (new StringBuilder("<a href=\"")).append(z.a(s2)).append("\">").append(s2).append("</a>").toString()))
            {
                s2 = matcher.group(1);
            }

        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return s;
        }
        String s1;
        matcher.appendTail(stringbuffer);
        s1 = stringbuffer.toString();
        return s1;
    }

    private static String d(String s)
    {
        StringBuffer stringbuffer;
        Matcher matcher;
        try
        {
            stringbuffer = new StringBuffer();
            String s2;
            for (matcher = d.matcher(s); matcher.find(); matcher.appendReplacement(stringbuffer, (new StringBuilder("<div class=\"quote\">")).append(s2).append("</div>").toString()))
            {
                s2 = matcher.group(2);
            }

        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return s;
        }
        String s1;
        matcher.appendTail(stringbuffer);
        s1 = stringbuffer.toString();
        return s1;
    }

    public final a a(long l1, String s)
    {
        for (Iterator iterator = a(l1).b.iterator(); iterator.hasNext();)
        {
            a a1 = (a)iterator.next();
            if (a1.a.equals(s))
            {
                return a1;
            }
        }

        return null;
    }

    public final d a(long l1)
    {
        if (a.o.a == null)
        {
            return null;
        }
        for (Iterator iterator = a.o.a.iterator(); iterator.hasNext();)
        {
            d d2 = (d)iterator.next();
            if (d2.c == l1)
            {
                return d2;
            }
        }

        Forum forum = a.h.i(l1);
        if (forum == null)
        {
            return null;
        } else
        {
            d d1 = new d();
            d1.c = forum.getModuleId().longValue();
            d1.a = forum.getLink();
            a.o.a.add(d1);
            return d1;
        }
    }

    public final ao a(long l1, String s, String s1)
    {
        d d1;
        d1 = a(l1);
        if (d1 == null)
        {
            return new ao(this, false, null);
        }
        com.appyet.g.g g1;
        Map map;
        g1 = new com.appyet.g.g(new URL((new StringBuilder()).append(d1.a).append("/mobiquo/mobiquo.php").toString()));
        g1.j = 120;
        g1.a(a.v);
        g1.a("Accept-Encoding", "gzip");
        if (d1.d.d != null)
        {
            d1.d.d.equals("1");
        }
        if (d1.d.e != null)
        {
            d1.d.e.equals("1");
        }
        Object aobj[] = new Object[2];
        aobj[0] = s.getBytes();
        aobj[1] = s1.getBytes();
        map = (Map)g1.a("login", aobj);
        if (map == null) goto _L2; else goto _L1
_L1:
        Boolean boolean1 = (Boolean)map.get("result");
        if (!boolean1.booleanValue()) goto _L4; else goto _L3
_L3:
        ao ao2;
        d1.f = g1.e.b;
        d1.e = new f();
        d1.e.a = boolean1.booleanValue();
        if (map.containsKey("result_text"))
        {
            d1.e.b = new String((byte[])(byte[])map.get("result_text"));
        }
        if (map.containsKey("status"))
        {
            d1.e.c = (String)map.get("status");
        }
        d1.e.d = (String)map.get("user_id");
        d1.e.e = new String((byte[])(byte[])map.get("username"));
        if (map.containsKey("email"))
        {
            d1.e.f = new String((byte[])(byte[])map.get("email"));
        }
        d1.e.g = (String)map.get("icon_url");
        ao2 = new ao(this, true, null);
        return ao2;
        p p1;
        p1;
        d1.e = null;
        com.appyet.d.d.a(p1);
_L2:
        return new ao(this, false, null);
_L4:
        ao ao1;
        if (!map.containsKey("result_text"))
        {
            continue; /* Loop/switch isn't completed */
        }
        ao1 = new ao(this, false, new String((byte[])(byte[])map.get("result_text")));
        return ao1;
        l l2;
        l2;
        d1.e = null;
        com.appyet.d.d.a(l2);
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        d1.e = null;
        com.appyet.d.d.a(exception);
        if (true) goto _L2; else goto _L5
_L5:
    }

    public final ao a(long l1, String s, String s1, String s2)
    {
        d d1;
        d1 = a(l1);
        if (d1 == null)
        {
            return new ao(this, false, null);
        }
        Map map;
        com.appyet.g.g g1 = new com.appyet.g.g(new URL((new StringBuilder()).append(d1.a).append("/mobiquo/mobiquo.php").toString()));
        if (d1.f != null)
        {
            g1.a(d1.f);
        }
        g1.j = 120;
        g1.a(a.v);
        g1.a("Accept-Encoding", "gzip");
        Object aobj[] = new Object[3];
        aobj[0] = s;
        aobj[1] = s1.getBytes();
        aobj[2] = s2.getBytes();
        map = (Map)g1.a("new_topic", aobj);
        if (map == null) goto _L2; else goto _L1
_L1:
        Boolean boolean1 = (Boolean)map.get("result");
        if (!map.containsKey("result_text")) goto _L4; else goto _L3
_L3:
        String s3 = new String((byte[])(byte[])map.get("result_text"));
_L6:
        if (!boolean1.booleanValue()) goto _L2; else goto _L5
_L5:
        ao ao1 = new ao(this, true, s3);
        return ao1;
        p p1;
        p1;
        com.appyet.d.d.a(p1);
_L2:
        return new ao(this, false, null);
        l l2;
        l2;
        com.appyet.d.d.a(l2);
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        com.appyet.d.d.a(exception);
        if (true) goto _L2; else goto _L4
_L4:
        s3 = null;
          goto _L6
    }

    public final List a(long l1, String s, int i)
    {
        d d1;
        int j;
        int k;
        ArrayList arraylist;
        d1 = a(l1);
        j = i * 10;
        k = -1 + 10 * (i + 1);
        arraylist = new ArrayList();
        com.appyet.g.g g1;
        g1 = new com.appyet.g.g(new URL((new StringBuilder()).append(d1.a).append("/mobiquo/mobiquo.php").toString()));
        if (d1.f != null)
        {
            g1.a(d1.f);
        }
        g1.j = 120;
        g1.a(a.v);
        g1.a("Accept-Encoding", "gzip");
        if (!a.o.b.m || !d1.a()) goto _L2; else goto _L1
_L1:
        Map map1;
        Object aobj2[] = new Object[4];
        aobj2[0] = s;
        aobj2[1] = Integer.valueOf(j);
        aobj2[2] = Integer.valueOf(k);
        aobj2[3] = Boolean.valueOf(false);
        map1 = (Map)g1.a("get_announcement", aobj2);
_L6:
        if (map1 == null)
        {
            break MISSING_BLOCK_LABEL_683;
        }
        Object aobj1[];
        if (map1.containsKey("result_text"))
        {
            new String((byte[])(byte[])map1.get("result_text"));
        }
        if (map1.containsKey("total_post_num"))
        {
            int k1 = ((Integer)map1.get("total_post_num")).intValue();
            if (a.o.b != null && a.o.b.k != k1)
            {
                a.o.b.k = k1;
            }
        }
        if (!map1.containsKey("posts"))
        {
            break; /* Loop/switch isn't completed */
        }
        aobj1 = (Object[])(Object[])map1.get("posts");
        if (aobj1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        int i1 = aobj1.length;
        int j1 = 0;
_L4:
        if (j1 >= i1)
        {
            break; /* Loop/switch isn't completed */
        }
        Map map2 = (Map)aobj1[j1];
        com.appyet.a.a.c c1 = new com.appyet.a.a.c();
        c1.b = new String((byte[])(byte[])map2.get("post_title"));
        c1.f = (String)map2.get("icon_url");
        c1.c = d(c(b(a(new String((byte[])(byte[])map2.get("post_content"))))));
        if (a.o.b.m && d1.a())
        {
            c1.c = c1.c.replace("\n", "<br>");
        }
        c1.g = (Date)map2.get("post_time");
        c1.a = (String)map2.get("post_id");
        c1.d = (String)map2.get("post_author_id");
        c1.e = new String((byte[])(byte[])map2.get("post_author_name"));
        arraylist.add(c1);
        j1++;
        if (true) goto _L4; else goto _L3
_L3:
        break; /* Loop/switch isn't completed */
_L2:
        Map map;
        Object aobj[] = new Object[4];
        aobj[0] = s;
        aobj[1] = Integer.valueOf(j);
        aobj[2] = Integer.valueOf(k);
        aobj[3] = Boolean.valueOf(true);
        map = (Map)g1.a("get_thread", aobj);
        map1 = map;
        if (true) goto _L6; else goto _L5
_L5:
        return arraylist;
        p p1;
        p1;
        com.appyet.d.d.a(p1);
_L8:
        return null;
        l l2;
        l2;
        com.appyet.d.d.a(l2);
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        com.appyet.d.d.a(exception);
        if (true) goto _L8; else goto _L7
_L7:
    }

    public final List a(long l1, String s, int i, int j, String s1)
    {
        d d1;
        a a1;
        int k;
        int i1;
        d1 = a(l1);
        a1 = a(l1, s);
        if (a1 == null)
        {
            return null;
        }
        k = i * j;
        i1 = -1 + j * (i + 1);
        Map map;
        com.appyet.g.g g1 = new com.appyet.g.g(new URL((new StringBuilder()).append(d1.a).append("/mobiquo/mobiquo.php").toString()));
        if (d1.f != null)
        {
            g1.a(d1.f);
        }
        g1.j = 120;
        g1.a(a.v);
        g1.a("Accept-Encoding", "gzip");
        Object aobj[] = new Object[4];
        aobj[0] = s;
        aobj[1] = Integer.valueOf(k);
        aobj[2] = Integer.valueOf(i1);
        aobj[3] = s1;
        map = (Map)g1.a("get_topic", aobj);
        if (map == null)
        {
            break MISSING_BLOCK_LABEL_678;
        }
        ArrayList arraylist;
        arraylist = new ArrayList();
        if (map.containsKey("total_topic_num"))
        {
            a1.l = ((Integer)map.get("total_topic_num")).intValue();
        }
        if (map.containsKey("can_post"))
        {
            a1.m = ((Boolean)map.get("can_post")).booleanValue();
        }
        if (map.containsKey("unread_sticky_count"))
        {
            a1.n = ((Integer)map.get("unread_sticky_count")).intValue();
        }
        if (map.containsKey("unread_announce_count"))
        {
            a1.o = ((Integer)map.get("unread_announce_count")).intValue();
        }
        if (map.containsKey("require_prefix"))
        {
            a1.p = ((Boolean)map.get("require_prefix")).booleanValue();
        }
        if (!map.containsKey("topics")) goto _L2; else goto _L1
_L1:
        Object aobj1[] = (Object[])(Object[])map.get("topics");
        if (aobj1 == null) goto _L2; else goto _L3
_L3:
        int j1 = aobj1.length;
        int k1 = 0;
_L4:
        if (k1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        Map map1 = (Map)aobj1[k1];
        e e1 = new e();
        e1.a = s;
        e1.b = (String)map1.get("topic_id");
        e1.c = new String((byte[])(byte[])map1.get("topic_title"));
        e1.f = (String)map1.get("icon_url");
        e1.j = new String((byte[])(byte[])map1.get("short_content"));
        e1.d = new String((byte[])(byte[])map1.get("topic_author_name"));
        e1.h = ((Integer)map1.get("reply_number")).intValue();
        e1.i = ((Integer)map1.get("view_number")).intValue();
        e1.g = (Date)map1.get("last_reply_time");
        if (map1.containsKey("is_closed"))
        {
            e1.e = ((Boolean)map1.get("is_closed")).booleanValue();
        }
        arraylist.add(e1);
        k1++;
        if (true) goto _L4; else goto _L2
_L2:
        return arraylist;
        p p1;
        p1;
        com.appyet.d.d.a(p1);
_L6:
        return null;
        l l2;
        l2;
        com.appyet.d.d.a(l2);
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        com.appyet.d.d.a(exception);
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final ao b(long l1, String s, String s1, String s2)
    {
        d d1;
        d1 = a(l1);
        if (d1 == null)
        {
            return new ao(this, false, null);
        }
        Map map;
        com.appyet.g.g g1 = new com.appyet.g.g(new URL((new StringBuilder()).append(d1.a).append("/mobiquo/mobiquo.php").toString()));
        if (d1.f != null)
        {
            g1.a(d1.f);
        }
        g1.j = 120;
        g1.a(a.v);
        g1.a("Accept-Encoding", "gzip");
        Object aobj[] = new Object[4];
        aobj[0] = s;
        aobj[1] = s1;
        aobj[2] = "".getBytes();
        aobj[3] = s2.getBytes();
        map = (Map)g1.a("reply_post", aobj);
        if (map == null) goto _L2; else goto _L1
_L1:
        Boolean boolean1 = (Boolean)map.get("result");
        if (!map.containsKey("result_text")) goto _L4; else goto _L3
_L3:
        String s3 = new String((byte[])(byte[])map.get("result_text"));
_L6:
        if (!boolean1.booleanValue()) goto _L2; else goto _L5
_L5:
        ao ao1 = new ao(this, true, s3);
        return ao1;
        p p1;
        p1;
        com.appyet.d.d.a(p1);
_L2:
        return new ao(this, false, null);
        l l2;
        l2;
        com.appyet.d.d.a(l2);
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        com.appyet.d.d.a(exception);
        if (true) goto _L2; else goto _L4
_L4:
        s3 = null;
          goto _L6
    }

    public final void b(long l1)
    {
        d d1;
        d1 = a(l1);
        break MISSING_BLOCK_LABEL_6;
_L1:
        do
        {
            do
            {
                return;
            } while (d1 == null || d1.d != null);
            Map map;
            try
            {
                com.appyet.g.g g1 = new com.appyet.g.g(new URL((new StringBuilder()).append(d1.a).append("/mobiquo/mobiquo.php").toString()));
                g1.j = 120;
                g1.a(a.v);
                g1.a("Accept-Encoding", "gzip");
                map = (Map)g1.a("get_config", new Object[0]);
            }
            catch (p p1)
            {
                d1.d = null;
                com.appyet.d.d.a(p1);
                return;
            }
            catch (l l2)
            {
                d1.d = null;
                com.appyet.d.d.a(l2);
                return;
            }
            catch (Exception exception)
            {
                d1.d = null;
                com.appyet.d.d.a(exception);
                return;
            }
        } while (map == null);
        d1.d = new b();
        d1.d.a = (String)map.get("sys_version");
        d1.d.c = (String)map.get("api_level");
        d1.d.b = (String)map.get("version");
        if (map.containsKey("support_md5"))
        {
            d1.d.d = (String)map.get("support_md5");
        }
        if (map.containsKey("support_sha1"))
        {
            d1.d.e = (String)map.get("support_sha1");
            return;
        }
          goto _L1
    }

    public final boolean c(long l1)
    {
        d d1;
        d1 = a(l1);
        if (d1 == null)
        {
            return false;
        }
        boolean flag;
        com.appyet.g.g g1 = new com.appyet.g.g(new URL((new StringBuilder()).append(d1.a).append("/mobiquo/mobiquo.php").toString()));
        if (d1.f != null)
        {
            g1.a(d1.f);
        }
        g1.j = 120;
        g1.a(a.v);
        g1.a("Accept-Encoding", "gzip");
        Boolean boolean1 = (Boolean)g1.a("logout_user", new Object[0]);
        d1.e = null;
        d1.f = null;
        flag = boolean1.booleanValue();
        if (flag)
        {
            return true;
        }
        break MISSING_BLOCK_LABEL_145;
        p p1;
        p1;
        com.appyet.d.d.a(p1);
_L2:
        return false;
        l l2;
        l2;
        com.appyet.d.d.a(l2);
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        com.appyet.d.d.a(exception);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final void d(long l1)
    {
        int i;
        d d1;
        i = 0;
        d1 = a(l1);
        break MISSING_BLOCK_LABEL_9;
_L4:
        do
        {
            return;
        } while (d1 == null || d1.b != null && d1.b.size() > 0);
        if (d1.b == null)
        {
            d1.b = new ArrayList();
        }
        com.appyet.g.g g1;
        g1 = new com.appyet.g.g(new URL((new StringBuilder()).append(d1.a).append("/mobiquo/mobiquo.php").toString()));
        if (d1.f != null)
        {
            g1.a(d1.f);
        }
        g1.j = 120;
        g1.a(a.v);
        g1.a("Accept-Encoding", "gzip");
        if (!d1.d.c.equals("3")) goto _L2; else goto _L1
_L1:
        Object aobj2[] = (Object[])(Object[])g1.a("get_forum", new Object[0]);
_L7:
        if (aobj2 == null) goto _L4; else goto _L3
_L3:
        Object aobj1[];
        int j;
        try
        {
            j = aobj2.length;
        }
        catch (p p1)
        {
            d1.b.clear();
            com.appyet.d.d.a(p1);
            return;
        }
        catch (l l2)
        {
            d1.b.clear();
            com.appyet.d.d.a(l2);
            return;
        }
        catch (Exception exception)
        {
            d1.b.clear();
            com.appyet.d.d.a(exception);
            return;
        }
_L6:
        if (i >= j) goto _L4; else goto _L5
_L5:
        Map map = (Map)aobj2[i];
        a a1 = new a();
        a(map, d1, a1);
        d1.b.add(a1);
        i++;
          goto _L6
          goto _L4
_L2:
        Object aobj[] = new Object[1];
        aobj[0] = Boolean.valueOf(false);
        aobj1 = (Object[])(Object[])g1.a("get_forum", aobj);
        aobj2 = aobj1;
          goto _L7
    }

}
