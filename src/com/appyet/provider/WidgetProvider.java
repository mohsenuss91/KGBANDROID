// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.provider;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.RemoteViews;
import com.appyet.activity.MainActivity;
import com.appyet.context.ApplicationContext;
import com.appyet.d.a;
import com.appyet.d.d;
import com.appyet.data.FeedItem;
import com.appyet.data.Module;
import com.appyet.data.Widget;
import com.appyet.f.w;
import com.appyet.manager.al;
import com.appyet.manager.ap;
import com.appyet.metadata.Metadata;
import com.appyet.metadata.MetadataModule;
import com.appyet.metadata.MetadataModuleFeedSql;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WidgetProvider extends AppWidgetProvider
{

    public static String a;
    public static String b = "ACTION_WIDGET_FORWARD";
    public static String c = "ACTION_WIDGET_BACKWARD";
    public static String d = "ACTION_WIDGET_OPEN";
    private static final int e[] = {
        0xff21aabd, -23296, 0xffbd2a4e, 0xff654b6b, 0xff87c032
    };

    public WidgetProvider()
    {
    }

    private static int a(Context context, int i)
    {
        AppWidgetManager appwidgetmanager;
        double d2;
        appwidgetmanager = AppWidgetManager.getInstance(context);
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        d2 = (double)appwidgetmanager.getAppWidgetOptions(i).getInt("appWidgetMinHeight") / 55D;
        if (d2 <= 1.5D)
        {
            return 1;
        }
        break MISSING_BLOCK_LABEL_127;
        AppWidgetProviderInfo appwidgetproviderinfo = appwidgetmanager.getAppWidgetInfo(i);
        if (appwidgetproviderinfo == null)
        {
            return 2;
        }
        int j;
        float f;
        j = appwidgetproviderinfo.minHeight;
        f = context.getResources().getDisplayMetrics().density;
        double d1 = (double)((float)j / f) / 55D;
        if (d1 > 1.5D)
        {
            if (d1 <= 2.5D)
            {
                return 2;
            }
            return d1 > 3.5D ? 4 : 3;
        }
        break MISSING_BLOCK_LABEL_125;
        Exception exception;
        exception;
        com.appyet.d.d.a(exception);
        return 1;
        if (d2 <= 2.5D)
        {
            return 2;
        }
        return d2 > 3.5D ? 4 : 3;
    }

    private static Uri a(ApplicationContext applicationcontext, FeedItem feeditem)
    {
        if (feeditem.getThumbnailMD5() == null) goto _L2; else goto _L1
_L1:
        al al1 = applicationcontext.j;
        if (!al1.g(feeditem.getThumbnailMD5())) goto _L4; else goto _L3
_L3:
        Uri uri1 = al1.d(feeditem.getThumbnailMD5());
        Uri uri = uri1;
_L6:
        if (uri != null)
        {
            return uri;
        } else
        {
            return null;
        }
_L2:
        return null;
        Exception exception;
        exception;
        com.appyet.d.d.a(exception);
        return null;
_L4:
        uri = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static void a(Context context, AppWidgetManager appwidgetmanager, int i, int j)
    {
        ApplicationContext applicationcontext;
        Widget widget;
        Module module;
        List list;
        RemoteViews remoteviews;
        List list1;
        applicationcontext = (ApplicationContext)context.getApplicationContext();
        int k;
        Bitmap bitmap;
        int l;
        RemoteViews remoteviews1;
        try
        {
            widget = applicationcontext.h.j(i);
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            applicationcontext.e.a(exception);
            return;
        }
        if (widget == null)
        {
            return;
        }
        module = applicationcontext.h.g(widget.getModuleId().longValue());
        if (!module.getType().equals("Feed")) goto _L2; else goto _L1
_L1:
        list1 = applicationcontext.h.e(widget.getModuleId().longValue());
          goto _L3
_L75:
        if (list == null) goto _L5; else goto _L4
_L4:
        if (list.size() != 0) goto _L6; else goto _L5
_L5:
        k = a(context, i);
        remoteviews = null;
        k;
        JVM INSTR tableswitch 1 4: default 136
    //                   1 432
    //                   2 451
    //                   3 470
    //                   4 470;
           goto _L7 _L8 _L9 _L10 _L10
_L7:
        remoteviews.setTextViewText(0x7f0a0068, "0/0");
        remoteviews.setTextViewText(0x7f0a0069, w.b(applicationcontext, module.getName()));
        remoteviews.setTextViewText(0x7f0a0065, applicationcontext.getResources().getString(0x7f08005b));
        bitmap = Bitmap.createBitmap(1, 1, android.graphics.Bitmap.Config.ARGB_8888);
        l = widget.getModuleId().intValue() % e.length;
        (new Canvas(bitmap)).drawColor(e[l]);
        remoteviews.setImageViewBitmap(0x7f0a006a, bitmap);
        remoteviews1 = new RemoteViews(context.getPackageName(), 0x7f030033);
        remoteviews1.removeAllViews(0x7f0a006e);
        remoteviews1.addView(0x7f0a006e, remoteviews);
        remoteviews1.setViewVisibility(0x7f0a006f, 8);
        appwidgetmanager.updateAppWidget(i, remoteviews1);
        return;
_L2:
        if (!module.getType().equals("FeedQuery")) goto _L12; else goto _L11
_L11:
        Iterator iterator = applicationcontext.q.MetadataModuleFeedSqls.iterator();
_L16:
        if (!iterator.hasNext()) goto _L14; else goto _L13
_L13:
        MetadataModuleFeedSql metadatamodulefeedsql;
        Iterator iterator1;
        metadatamodulefeedsql = (MetadataModuleFeedSql)iterator.next();
        iterator1 = applicationcontext.q.MetadataModules.iterator();
_L18:
        if (!iterator1.hasNext()) goto _L16; else goto _L15
_L15:
        MetadataModule metadatamodule = (MetadataModule)iterator1.next();
        if (metadatamodule.Id != metadatamodulefeedsql.ModuleId || !metadatamodule.Guid.equals(module.getGuid())) goto _L18; else goto _L17
_L17:
        list1 = applicationcontext.h.c(metadatamodulefeedsql.Query);
          goto _L3
_L8:
        remoteviews = new RemoteViews(context.getPackageName(), 0x7f03001f);
          goto _L7
_L9:
        remoteviews = new RemoteViews(context.getPackageName(), 0x7f03001e);
          goto _L7
_L10:
        remoteviews = new RemoteViews(context.getPackageName(), 0x7f030022);
          goto _L7
_L6:
        int i1 = j + (int)widget.getPosition().longValue();
        if (i1 < 0)
        {
            i1 = 0;
        }
        RemoteViews remoteviews4;
        RemoteViews remoteviews5;
        int j1;
        int k1;
        int l1;
        Uri uri;
        Uri uri1;
        int i2;
        RemoteViews remoteviews2;
        RemoteViews remoteviews3;
        RemoteViews remoteviews6;
        Intent intent;
        FeedItem feeditem;
        Bitmap bitmap1;
        int j2;
        FeedItem feeditem1;
        Bitmap bitmap2;
        int k2;
        Intent intent1;
        PendingIntent pendingintent;
        RemoteViews remoteviews7;
        RemoteViews remoteviews8;
        RemoteViews remoteviews9;
        RemoteViews remoteviews10;
        RemoteViews remoteviews11;
        RemoteViews remoteviews12;
        RemoteViews remoteviews13;
        if (i1 >= list.size())
        {
            j1 = 0;
        } else
        {
            j1 = i1;
        }
        k1 = j1 - 1;
        if (k1 >= 0) goto _L20; else goto _L19
_L19:
        l1 = -1 + list.size();
_L74:
        uri = a(applicationcontext, (FeedItem)list.get(j1));
        uri1 = null;
        if (l1 < 0)
        {
            break MISSING_BLOCK_LABEL_612;
        }
        i2 = list.size();
        uri1 = null;
        if (l1 >= i2)
        {
            break MISSING_BLOCK_LABEL_612;
        }
        uri1 = a(applicationcontext, (FeedItem)list.get(l1));
        a(context, i);
        JVM INSTR tableswitch 1 4: default 1894
    //                   1 1256
    //                   2 1408
    //                   3 1560
    //                   4 1560;
           goto _L21 _L22 _L23 _L24 _L24
_L47:
        remoteviews6 = new RemoteViews(context.getPackageName(), 0x7f030033);
        remoteviews6.removeAllViews(0x7f0a006e);
        remoteviews6.addView(0x7f0a006e, remoteviews5);
        if (remoteviews4 == null) goto _L26; else goto _L25
_L25:
        remoteviews6.addView(0x7f0a006e, remoteviews4);
_L26:
        remoteviews6.setViewVisibility(0x7f0a006f, 0);
        intent = new Intent(context, com/appyet/provider/WidgetProvider);
        intent.setAction(b);
        intent.setData(Uri.withAppendedPath(Uri.parse(a), String.valueOf(i)));
        remoteviews6.setOnClickPendingIntent(0x7f0a006f, PendingIntent.getBroadcast(context, 0, intent, 0));
        widget.setPosition(Long.valueOf(j1));
        applicationcontext.h.b(widget);
        if (list.size() <= j1) goto _L28; else goto _L27
_L27:
        feeditem1 = (FeedItem)list.get(j1);
        if (list.size() < 100) goto _L30; else goto _L29
_L29:
        remoteviews5.setTextViewText(0x7f0a0068, (new StringBuilder()).append(j1 + 1).append("/").append(list.size()).append("+").toString());
_L71:
        remoteviews5.setTextViewText(0x7f0a0069, (new StringBuilder()).append(w.b(applicationcontext, module.getName())).append(" / ").append(com.appyet.d.a.a(applicationcontext, feeditem1.getPubDate())).toString());
        remoteviews5.setTextViewText(0x7f0a0065, feeditem1.getTitle());
        if (uri != null) goto _L32; else goto _L31
_L31:
        bitmap2 = Bitmap.createBitmap(1, 1, android.graphics.Bitmap.Config.ARGB_8888);
        k2 = j1 % e.length;
        (new Canvas(bitmap2)).drawColor(e[k2]);
        remoteviews5.setImageViewBitmap(0x7f0a006a, bitmap2);
_L72:
        intent1 = new Intent(context, com/appyet/provider/WidgetProvider);
        intent1.setAction(d);
        intent1.setData(Uri.withAppendedPath(Uri.parse(a), String.valueOf(feeditem1.getFeedItemId())));
        pendingintent = PendingIntent.getBroadcast(context, 0, intent1, 0);
        if (uri != null) goto _L34; else goto _L33
_L33:
        remoteviews5.setOnClickPendingIntent(0x7f0a006a, pendingintent);
_L28:
        if (l1 < 0 || remoteviews4 == null) goto _L36; else goto _L35
_L35:
        if (list.size() <= l1) goto _L38; else goto _L37
_L37:
        feeditem = (FeedItem)list.get(l1);
        if (list.size() < 100) goto _L40; else goto _L39
_L39:
        remoteviews4.setTextViewText(0x7f0a0068, (new StringBuilder()).append(l1 + 1).append("/").append(list.size()).append("+").toString());
_L73:
        remoteviews4.setTextViewText(0x7f0a0069, (new StringBuilder()).append(w.b(applicationcontext, module.getName())).append(" / ").append(com.appyet.d.a.a(applicationcontext, feeditem.getPubDate())).toString());
        remoteviews4.setTextViewText(0x7f0a0065, feeditem.getTitle());
        if (uri1 != null) goto _L42; else goto _L41
_L41:
        bitmap1 = Bitmap.createBitmap(1, 1, android.graphics.Bitmap.Config.ARGB_8888);
        j2 = l1 % e.length;
        (new Canvas(bitmap1)).drawColor(e[j2]);
        remoteviews4.setImageViewBitmap(0x7f0a006a, bitmap1);
_L36:
        appwidgetmanager.updateAppWidget(i, remoteviews6);
        return;
_L22:
        if (j != 0) goto _L44; else goto _L43
_L43:
        if (uri != null) goto _L46; else goto _L45
_L45:
        remoteviews5 = new RemoteViews(context.getPackageName(), 0x7f03001f);
        remoteviews4 = null;
          goto _L47
_L46:
        remoteviews5 = new RemoteViews(context.getPackageName(), 0x7f030018);
        remoteviews4 = null;
          goto _L47
_L44:
        if (uri1 != null) goto _L49; else goto _L48
_L48:
        remoteviews11 = new RemoteViews(context.getPackageName(), 0x7f030021);
_L52:
        if (uri != null) goto _L51; else goto _L50
_L50:
        remoteviews12 = new RemoteViews(context.getPackageName(), 0x7f030020);
        remoteviews4 = remoteviews11;
        remoteviews5 = remoteviews12;
          goto _L47
_L49:
        remoteviews11 = new RemoteViews(context.getPackageName(), 0x7f03001a);
          goto _L52
_L51:
        remoteviews13 = new RemoteViews(context.getPackageName(), 0x7f030019);
        remoteviews4 = remoteviews11;
        remoteviews5 = remoteviews13;
          goto _L47
_L23:
        if (j != 0) goto _L54; else goto _L53
_L53:
        if (uri != null) goto _L56; else goto _L55
_L55:
        remoteviews5 = new RemoteViews(context.getPackageName(), 0x7f03001e);
        remoteviews4 = null;
          goto _L47
_L56:
        remoteviews5 = new RemoteViews(context.getPackageName(), 0x7f030017);
        remoteviews4 = null;
          goto _L47
_L54:
        if (uri1 != null) goto _L58; else goto _L57
_L57:
        remoteviews8 = new RemoteViews(context.getPackageName(), 0x7f030026);
_L61:
        if (uri != null) goto _L60; else goto _L59
_L59:
        remoteviews9 = new RemoteViews(context.getPackageName(), 0x7f030025);
        remoteviews4 = remoteviews8;
        remoteviews5 = remoteviews9;
          goto _L47
_L58:
        remoteviews8 = new RemoteViews(context.getPackageName(), 0x7f03001c);
          goto _L61
_L60:
        remoteviews10 = new RemoteViews(context.getPackageName(), 0x7f03001b);
        remoteviews4 = remoteviews8;
        remoteviews5 = remoteviews10;
          goto _L47
_L24:
        if (j != 0) goto _L63; else goto _L62
_L62:
        if (uri != null) goto _L65; else goto _L64
_L64:
        remoteviews5 = new RemoteViews(context.getPackageName(), 0x7f030022);
        remoteviews4 = null;
          goto _L47
_L65:
        remoteviews5 = new RemoteViews(context.getPackageName(), 0x7f030017);
        remoteviews4 = null;
          goto _L47
_L63:
        if (uri1 != null) goto _L67; else goto _L66
_L66:
        remoteviews2 = new RemoteViews(context.getPackageName(), 0x7f030024);
_L70:
        if (uri != null) goto _L69; else goto _L68
_L68:
        remoteviews3 = new RemoteViews(context.getPackageName(), 0x7f030023);
        remoteviews4 = remoteviews2;
        remoteviews5 = remoteviews3;
          goto _L47
_L67:
        remoteviews2 = new RemoteViews(context.getPackageName(), 0x7f03001c);
          goto _L70
_L69:
        remoteviews7 = new RemoteViews(context.getPackageName(), 0x7f03001b);
        remoteviews4 = remoteviews2;
        remoteviews5 = remoteviews7;
          goto _L47
_L30:
        remoteviews5.setTextViewText(0x7f0a0068, (new StringBuilder()).append(j1 + 1).append("/").append(list.size()).toString());
          goto _L71
_L32:
        remoteviews5.setImageViewUri(0x7f0a0063, uri);
          goto _L72
_L34:
        remoteviews5.setOnClickPendingIntent(0x7f0a0063, pendingintent);
          goto _L28
_L40:
        remoteviews4.setTextViewText(0x7f0a0068, (new StringBuilder()).append(l1 + 1).append("/").append(list.size()).toString());
          goto _L73
_L42:
        remoteviews4.setImageViewUri(0x7f0a0063, uri1);
          goto _L36
_L38:
        remoteviews4.setTextViewText(0x7f0a0065, "");
        remoteviews4.setImageViewResource(0x7f0a0063, 0x7f0200fe);
          goto _L36
_L20:
        l1 = k1;
          goto _L74
_L12:
        list = null;
          goto _L75
_L3:
        list = list1;
          goto _L75
_L14:
        list1 = null;
          goto _L3
_L21:
        remoteviews5 = null;
        remoteviews4 = null;
          goto _L47
    }

    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appwidgetmanager, int i, Bundle bundle)
    {
        a(context, appwidgetmanager, i, 0);
        super.onAppWidgetOptionsChanged(context, appwidgetmanager, i, bundle);
    }

    public void onDeleted(Context context, int ai[])
    {
        ApplicationContext applicationcontext;
        ArrayList arraylist;
        int i;
        applicationcontext = (ApplicationContext)context.getApplicationContext();
        arraylist = new ArrayList();
        i = ai.length;
        int j = 0;
_L2:
        if (j >= i)
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(Long.valueOf(ai[j]));
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        try
        {
            applicationcontext.h.e(arraylist);
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        return;
    }

    public void onReceive(Context context, Intent intent)
    {
        boolean flag;
        a = (new StringBuilder("MFRD://")).append(context.getPackageName()).append(".widget/id/").toString();
        flag = intent.getAction().equals(c);
        if (flag)
        {
            try
            {
                int j = Integer.parseInt(intent.getData().toString().replace(a, ""));
                a(context, AppWidgetManager.getInstance(context), j, -1);
                return;
            }
            catch (Exception exception3)
            {
                try
                {
                    com.appyet.d.d.a(exception3);
                    return;
                }
                catch (Exception exception)
                {
                    com.appyet.d.d.a(exception);
                }
            }
            return;
        }
        boolean flag1 = intent.getAction().equals(b);
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_151;
        }
        int i = Integer.parseInt(intent.getData().toString().replace(a, ""));
        a(context, AppWidgetManager.getInstance(context), i, 1);
        return;
        Exception exception2;
        exception2;
        com.appyet.d.d.a(exception2);
        return;
        boolean flag2 = intent.getAction().equals(d);
        if (!flag2)
        {
            break MISSING_BLOCK_LABEL_228;
        }
        long l = Long.parseLong(intent.getData().toString().replace(a, ""));
        Intent intent1 = new Intent(context, com/appyet/activity/MainActivity);
        intent1.putExtra("ACTION_WIDGET_OPEN_FEEDITEM_ID", l);
        context.startActivity(intent1);
        return;
        Exception exception1;
        exception1;
        com.appyet.d.d.a(exception1);
        return;
        super.onReceive(context, intent);
        return;
    }

    public void onUpdate(Context context, AppWidgetManager appwidgetmanager, int ai[])
    {
        int i = 0;
        int j = ai.length;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        a(context, appwidgetmanager, ai[i], 0);
        i++;
        if (true) goto _L2; else goto _L1
        Exception exception;
        exception;
        com.appyet.d.d.a(exception);
_L1:
    }

}
