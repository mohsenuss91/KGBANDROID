// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import android.app.Activity;
import android.content.res.Resources;
import android.widget.TextView;
import com.appyet.context.ApplicationContext;
import com.appyet.metadata.Metadata;
import com.appyet.metadata.MetadataSetting;
import com.appyet.metadata.MetadataTheme;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.appyet.manager:
//            bp

public final class bw
{

    public MetadataTheme a;
    private ApplicationContext b;
    private int c;
    private int d;
    private int e;

    public bw(ApplicationContext applicationcontext)
    {
        a = null;
        b = applicationcontext;
        a();
    }

    private static MetadataTheme c()
    {
        MetadataTheme metadatatheme = new MetadataTheme();
        metadatatheme.Name = "Light Theme";
        metadatatheme.PrimaryBgColor = "LIGHT";
        metadatatheme.Guid = "97e6ef36-cf61-43c5-a012-67dcf183c973";
        metadatatheme.ActionBarBgColor = "#DDDDDD";
        metadatatheme.ActionBarFgColor = false;
        metadatatheme.LeftMenuBgColor = "#E2E2E0";
        metadatatheme.LeftMenuIconSize = 20;
        metadatatheme.LeftMenuGroupTextColor = "#999999";
        metadatatheme.LeftMenuGroupTextSize = 14;
        metadatatheme.LeftMenuItemTextColor = "#494949";
        metadatatheme.LeftMenuItemTextSize = 15;
        metadatatheme.LeftMenuItemVerticalPadding = 15;
        metadatatheme.LeftMenuBadgeBgColor = "#888888";
        metadatatheme.LeftMenuBadgeTextColor = "#FFFFFF";
        metadatatheme.LeftMenuBadgeTextSize = 10;
        metadatatheme.LeftMenuDividerColor = "#DADAD8";
        return metadatatheme;
    }

    public final void a()
    {
        if (b.q.MetadataThemes == null || b.q.MetadataThemes.size() == 0)
        {
            a = c();
            return;
        }
        String s = b.d.F();
        for (Iterator iterator = b.q.MetadataThemes.iterator(); iterator.hasNext();)
        {
            MetadataTheme metadatatheme1 = (MetadataTheme)iterator.next();
            if (metadatatheme1.Guid.equals(s))
            {
                a = metadatatheme1;
                return;
            }
        }

        for (Iterator iterator1 = b.q.MetadataThemes.iterator(); iterator1.hasNext();)
        {
            MetadataTheme metadatatheme = (MetadataTheme)iterator1.next();
            if (metadatatheme.Guid.equals(b.q.MetadataSetting.DefaultThemeGuid))
            {
                a = metadatatheme;
                return;
            }
        }

        if (b.q.MetadataThemes.size() > 0)
        {
            a = (MetadataTheme)b.q.MetadataThemes.get(0);
            return;
        } else
        {
            a = c();
            return;
        }
    }

    public final void a(Activity activity)
    {
        if (a.ActionBarFgColor)
        {
            activity.setTheme(0x7f07006e);
            return;
        } else
        {
            activity.setTheme(0x7f07006d);
            return;
        }
    }

    public final void a(boolean flag, TextView textview, TextView textview1, TextView textview2, TextView textview3, TextView textview4, TextView textview5)
    {
        if (textview != null)
        {
            textview.setTextColor(d);
        }
        if (textview5 != null)
        {
            if (a.PrimaryBgColor.equals("DARK"))
            {
                textview5.setTextColor(d);
            } else
            {
                textview5.setTextColor(b.getResources().getColor(0x7f090042));
            }
        }
        if (textview1 != null)
        {
            textview1.setTextColor(d);
        }
        if (textview2 != null)
        {
            textview2.setTextColor(d);
        }
        if (textview3 != null)
        {
            textview3.setTextColor(d);
        }
        if (textview4 != null)
        {
            textview4.setTextColor(d);
        }
        if (!flag)
        {
            if (textview != null)
            {
                textview.setTextColor(c);
            }
            if (textview5 != null)
            {
                if (a.PrimaryBgColor.equals("DARK"))
                {
                    textview5.setTextColor(c);
                } else
                {
                    textview5.setTextColor(b.getResources().getColor(0x7f090041));
                }
            }
        }
        if (a.PrimaryBgColor.equals("DARK"))
        {
            if (textview != null)
            {
                textview.setTextColor(b.getResources().getColor(0x7f090042));
            }
            if (textview5 != null)
            {
                textview5.setTextColor(b.getResources().getColor(0x7f090042));
            }
            if (textview1 != null)
            {
                textview1.setTextColor(b.getResources().getColor(0x7f090042));
            }
            if (textview2 != null)
            {
                textview2.setTextColor(b.getResources().getColor(0x7f090042));
            }
            if (textview3 != null)
            {
                textview3.setTextColor(b.getResources().getColor(0x7f090042));
            }
            if (textview4 != null)
            {
                textview4.setTextColor(b.getResources().getColor(0x7f090042));
            }
            if (!flag)
            {
                if (textview != null)
                {
                    textview.setTextColor(b.getResources().getColor(0x7f090041));
                }
                if (textview5 != null)
                {
                    textview5.setTextColor(b.getResources().getColor(0x7f090041));
                }
            }
        } else
        {
            if (textview != null)
            {
                textview.setTextColor(b.getResources().getColor(0x7f090044));
            }
            if (textview5 != null)
            {
                textview5.setTextColor(b.getResources().getColor(0x7f090042));
            }
            if (textview1 != null)
            {
                textview1.setTextColor(b.getResources().getColor(0x7f090044));
            }
            if (textview2 != null)
            {
                textview2.setTextColor(b.getResources().getColor(0x7f090044));
            }
            if (textview3 != null)
            {
                textview3.setTextColor(b.getResources().getColor(0x7f090044));
            }
            if (textview4 != null)
            {
                textview4.setTextColor(b.getResources().getColor(0x7f090044));
            }
            if (!flag)
            {
                if (textview != null)
                {
                    textview.setTextColor(b.getResources().getColor(0x7f090043));
                }
                if (textview5 != null)
                {
                    textview5.setTextColor(b.getResources().getColor(0x7f090041));
                    return;
                }
            }
        }
    }

    public final void b()
    {
        c = b.d.G();
        d = b.d.H();
        e = b.getResources().getColor(0x7f09004e);
    }
}
