// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.controller;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import com.inmobi.commons.internal.Log;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.controller.util.StartActivityForResultCallback;
import java.util.GregorianCalendar;

// Referenced classes of package com.inmobi.re.controller:
//            JSUtilityController

class c
    implements StartActivityForResultCallback
{

    final String a;
    final String b;
    final String c;
    final JSUtilityController d;

    public void onActivityResult(int i, Intent intent)
    {
        if (!d.a("android.permission.READ_CALENDAR") || !d.a("android.permission.WRITE_CALENDAR")) goto _L2; else goto _L1
_L1:
        int j = JSUtilityController.a(d);
        if (d.c == j)
        {
            Log.internal("[InMobi]-[RE]-4.4.1", "User cancelled the create calendar event");
            return;
        }
        if (android.os.nternal < 8) goto _L4; else goto _L3
_L3:
        Uri uri = Uri.parse("content://com.android.calendar/events");
_L18:
        ContentResolver contentresolver;
        ContentValues contentvalues;
        contentresolver = d.imWebView.getActivity().getContentResolver();
        contentvalues = new ContentValues();
        if (!a.equals("tentative")) goto _L6; else goto _L5
_L5:
        contentvalues.put("eventStatus", Integer.valueOf(0));
_L11:
        contentresolver.update(ContentUris.withAppendedId(uri, JSUtilityController.a(d)), contentvalues, null, null);
        if (b == null) goto _L2; else goto _L7
_L7:
        boolean flag = "".equals(b);
        if (flag) goto _L2; else goto _L8
_L8:
        int k;
        k = Integer.parseInt(b) / 60000;
        break MISSING_BLOCK_LABEL_173;
_L4:
        uri = Uri.parse("content://calendar/events");
        continue; /* Loop/switch isn't completed */
_L6:
        if (!a.equals("confirmed")) goto _L10; else goto _L9
_L9:
        contentvalues.put("eventStatus", Integer.valueOf(1));
          goto _L11
_L10:
        if (!a.equals("cancelled")) goto _L11; else goto _L12
_L12:
        contentvalues.put("eventStatus", Integer.valueOf(2));
          goto _L11
        numberformatexception;
        k = (int)(JSUtilityController.convertDateString(b).getTimeInMillis() - JSUtilityController.convertDateString(c).getTimeInMillis()) / 60000;
          goto _L13
        exception1;
        d.imWebView.raiseError("Reminder format is incorrect. Invalid date", "createCalendarEvent");
        return;
_L13:
        int l;
        NumberFormatException numberformatexception;
        Exception exception1;
        if (k > 0)
        {
            try
            {
                d.imWebView.raiseError("Reminder format is incorrect. Reminder can be set only before the event starts", "createCalendarEvent");
                return;
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                Log.internal("[InMobi]-[RE]-4.4.1", "Exception adding reminder", exception);
                return;
            }
        }
        l = -k;
        ContentValues contentvalues1 = new ContentValues();
        contentvalues1.put("hasAlarm", Integer.valueOf(1));
        contentresolver.update(ContentUris.withAppendedId(uri, JSUtilityController.a(d)), contentvalues1, null, null);
        if (android.os.yController.e.d < 8) goto _L15; else goto _L14
_L14:
        Uri uri2 = Uri.parse("content://com.android.calendar/reminders");
_L16:
        ContentValues contentvalues2 = new ContentValues();
        contentvalues2.put("event_id", Integer.valueOf(JSUtilityController.a(d)));
        contentvalues2.put("method", Integer.valueOf(1));
        contentvalues2.put("minutes", Integer.valueOf(l));
        contentresolver.insert(uri2, contentvalues2);
        return;
_L15:
        Uri uri1 = Uri.parse("content://calendar/reminders");
        uri2 = uri1;
          goto _L16
_L2:
        return;
        if (true) goto _L18; else goto _L17
_L17:
    }

    esultCallback(JSUtilityController jsutilitycontroller, String s, String s1, String s2)
    {
        d = jsutilitycontroller;
        a = s;
        b = s1;
        c = s2;
        super();
    }
}
