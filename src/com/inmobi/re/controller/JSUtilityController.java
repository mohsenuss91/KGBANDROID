// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.controller;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Environment;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import com.inmobi.androidsdk.IMBrowserActivity;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.internal.ApiStatCollector;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.metric.EventLog;
import com.inmobi.commons.metric.Logger;
import com.inmobi.re.configs.ConfigParams;
import com.inmobi.re.configs.Initializer;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.mraidimpl.AudioTriggerCallback;
import com.inmobi.re.container.mraidimpl.AudioTriggerer;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.re.controller:
//            JSController, d, JSDisplayController

public class JSUtilityController extends JSController
{

    public static SimpleDateFormat calendarUntiFormats[];
    public static SimpleDateFormat formats[];
    DownloadManager a;
    Object b;
    int c;
    private JSDisplayController d;
    private boolean e;
    private Map f;
    private AudioTriggerCallback g;
    private boolean h;
    private boolean i;

    public JSUtilityController(IMWebView imwebview, Context context)
    {
        super(imwebview, context);
        a = null;
        e = false;
        c = 0;
        f = new HashMap();
        g = new d(this);
        h = false;
        i = false;
        d = new JSDisplayController(imwebview, context);
        imwebview.addJavascriptInterface(d, "displayController");
    }

    private int a()
    {
        String as[] = {
            "_id", "title"
        };
        Cursor cursor;
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            cursor = imWebView.getActivity().getContentResolver().query(Uri.parse("content://com.android.calendar/events"), as, null, null, null);
        } else
        {
            cursor = imWebView.getActivity().getContentResolver().query(Uri.parse("content://calendar/events"), as, null, null, null);
        }
        if (cursor != null && cursor.moveToLast())
        {
            int j = cursor.getColumnIndex("title");
            int k = cursor.getColumnIndex("_id");
            String s = cursor.getString(j);
            String s1 = cursor.getString(k);
            if (s != null)
            {
                return Integer.parseInt(s1);
            }
        }
        return 0;
    }

    static int a(JSUtilityController jsutilitycontroller)
    {
        return jsutilitycontroller.a();
    }

    private int a(String s, int j)
    {
        int k;
        try
        {
            k = Integer.parseInt(s);
        }
        catch (NumberFormatException numberformatexception)
        {
            return j;
        }
        return k;
    }

    private String b(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            s = null;
        } else
        if (!s.startsWith("tel:"))
        {
            StringBuilder stringbuilder = new StringBuilder("tel:");
            stringbuilder.append(s);
            return stringbuilder.toString();
        }
        return s;
    }

    private int[] b()
    {
        int ai[] = new int[2];
        try
        {
            FrameLayout framelayout = (FrameLayout)((ViewGroup)imWebView.getOriginalParent()).getRootView().findViewById(0x1020002);
            ai[0] = (int)((float)framelayout.getWidth() / imWebView.getDensity());
            ai[1] = (int)((float)framelayout.getHeight() / imWebView.getDensity());
        }
        catch (Exception exception)
        {
            ai[1] = 0;
            ai[0] = 0;
            return ai;
        }
        return ai;
    }

    private void c()
    {
        if (i)
        {
            registerMicListener();
        }
    }

    private void c(String s)
    {
        (new d(s)).start();
    }

    public static GregorianCalendar convertDateString(String s)
    {
        SimpleDateFormat asimpledateformat[];
        int j;
        int k;
        asimpledateformat = formats;
        j = asimpledateformat.length;
        k = 0;
_L2:
        SimpleDateFormat simpledateformat;
        if (k >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        simpledateformat = asimpledateformat[k];
        GregorianCalendar gregoriancalendar1;
        java.util.Date date = simpledateformat.parse(s);
        GregorianCalendar gregoriancalendar = new GregorianCalendar();
        gregoriancalendar.setTime(date);
        gregoriancalendar1 = (GregorianCalendar)gregoriancalendar;
        return gregoriancalendar1;
        Exception exception;
        exception;
        k++;
        if (true) goto _L2; else goto _L1
_L1:
        return null;
    }

    private void d()
    {
        i = h;
        unRegisterMicListener();
    }

    boolean a(String s)
    {
        PackageManager packagemanager = imWebView.getActivity().getPackageManager();
        return packagemanager.checkPermission(s, packagemanager.getNameForUid(Binder.getCallingUid())) == 0;
    }

    public void asyncPing(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(31), null));
        try
        {
            Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("JSUtilityController-> asyncPing: url: ")).append(s).toString());
            if (!URLUtil.isValidUrl(s))
            {
                imWebView.raiseError("Invalid url", "asyncPing");
                return;
            }
        }
        catch (Exception exception)
        {
            return;
        }
        c(s);
        return;
    }

    public void cancelSaveContent(String s)
    {
        imWebView.cancelSaveContent(s);
    }

    public void closeVideo(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(50), null));
        Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("JSUtilityController-> closeVideo: id :")).append(s).toString());
        imWebView.closeVideo(s);
    }

    public void createCalendarEvent(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9)
    {
        if (a("android.permission.READ_CALENDAR") && a("android.permission.WRITE_CALENDAR"))
        {
            c = a();
        }
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(30), null));
        Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("JSUtilityController-> createEvent: date: ")).append(s1).append(" location: ").append(s3).append(" body: ").append(s4).toString());
        if (!supports("calendar"))
        {
            Log.internal("[InMobi]-[RE]-4.4.1", "createCalendarEvent called even if it is not supported");
            imWebView.raiseError("createCalendarEvent called even if it is not supported", "createCalendarEvent");
            return;
        }
        GregorianCalendar gregoriancalendar;
        GregorianCalendar gregoriancalendar1;
        gregoriancalendar = convertDateString(s1);
        gregoriancalendar1 = convertDateString(s2);
        if (gregoriancalendar == null || gregoriancalendar1 == null)
        {
            try
            {
                Log.debug("[InMobi]-[RE]-4.4.1", "exception");
                imWebView.raiseError("Date format is incorrect", "createCalendarEvent");
                return;
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-[RE]-4.4.1", "Error creating reminder event", exception);
            }
            return;
        }
        Intent intent;
        intent = new Intent(imWebView.getActivity(), com/inmobi/androidsdk/IMBrowserActivity);
        intent.putExtra("extra_browser_type", 100);
        intent.putExtra("id", IMBrowserActivity.generateId(new e(s6, s9, s1)));
        intent.putExtra("eventId", s);
        intent.putExtra("action", "createCalendarEvent");
        intent.putExtra("description", s4);
        intent.putExtra("summary", s5);
        intent.putExtra("location", s3);
        intent.putExtra("start", gregoriancalendar.getTimeInMillis());
        intent.putExtra("end", gregoriancalendar1.getTimeInMillis());
        intent.putExtra("status", s6);
        intent.putExtra("transparency", s7);
        intent.putExtra("recurrence", s8);
        if (s9 == null)
        {
            break MISSING_BLOCK_LABEL_385;
        }
        if (!"".equals(s9))
        {
            intent.putExtra("hasAlarm", true);
        }
        imWebView.getActivity().startActivity(intent);
        if (imWebView.mListener != null)
        {
            imWebView.mListener.onLeaveApplication();
        }
        return;
    }

    public int getAudioVolume(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(37), null));
        Log.debug("[InMobi]-[RE]-4.4.1", "JSUtilityController-> getAudioVolume: ");
        return imWebView.getAudioVolume(s);
    }

    public String getCurrentPosition()
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(18), null));
        Log.debug("[InMobi]-[RE]-4.4.1", "JSUtilityController-> getCurrentPosition");
        Object obj = imWebView.mutexcPos;
        obj;
        JVM INSTR monitorenter ;
        imWebView.sendToCPHandler();
_L1:
        boolean flag = imWebView.acqMutexcPos.get();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        imWebView.mutexcPos.wait();
          goto _L1
        InterruptedException interruptedexception;
        interruptedexception;
        Log.debug("[InMobi]-[RE]-4.4.1", "mutexcPos failed ", interruptedexception);
          goto _L1
        Exception exception;
        exception;
        throw exception;
        imWebView.acqMutexcPos.set(true);
        obj;
        JVM INSTR monitorexit ;
        return imWebView.curPosition.toString();
    }

    public String getDefaultPosition()
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(19), null));
        Log.debug("[InMobi]-[RE]-4.4.1", "JSUtilityController-> getDefaultPosition");
        Object obj = imWebView.mutexdPos;
        obj;
        JVM INSTR monitorenter ;
        imWebView.sendToDPHandler();
_L1:
        boolean flag = imWebView.acqMutexdPos.get();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        imWebView.mutexdPos.wait();
          goto _L1
        InterruptedException interruptedexception;
        interruptedexception;
        Log.debug("[InMobi]-[RE]-4.4.1", "mutexdPos failed ", interruptedexception);
          goto _L1
        Exception exception;
        exception;
        throw exception;
        imWebView.acqMutexdPos.set(true);
        obj;
        JVM INSTR monitorexit ;
        Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("mutexdPassed")).append(imWebView.defPosition).toString());
        return imWebView.defPosition.toString();
    }

    public String getGalleryImage()
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(25), null));
        if (!supports("getGalleryImage"))
        {
            Log.internal("[InMobi]-[RE]-4.4.1", "getGalleryImage called even if it is not supported");
        } else
        {
            Intent intent = new Intent(imWebView.getActivity(), com/inmobi/androidsdk/IMBrowserActivity);
            intent.putExtra("extra_browser_type", 100);
            intent.putExtra("id", IMBrowserActivity.generateId(new a()));
            intent.putExtra("action", "getGalleryImage");
            imWebView.getActivity().startActivity(intent);
            if (imWebView.mListener != null)
            {
                imWebView.mListener.onLeaveApplication();
                return null;
            }
        }
        return null;
    }

    public String getMaxSize()
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(20), null));
        int ai[] = b();
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("width", ai[0]);
            jsonobject.put("height", ai[1]);
        }
        catch (JSONException jsonexception) { }
        return jsonobject.toString();
    }

    public double getMicIntensity()
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(51), null));
        return imWebView.getLastGoodKnownMicValue();
    }

    public String getScreenSize()
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(17), null));
        Log.debug("[InMobi]-[RE]-4.4.1", "JSUtilityController-> getScreenSize");
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager)mContext.getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
        int j = (int)((float)displaymetrics.widthPixels / displaymetrics.density);
        int k = (int)((float)displaymetrics.heightPixels / displaymetrics.density);
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("width", j);
            jsonobject.put("height", k);
        }
        catch (JSONException jsonexception)
        {
            Log.debug("[InMobi]-[RE]-4.4.1", "Failed to get screen size");
        }
        return jsonobject.toString();
    }

    public String getSdkVersion()
    {
        return InMobi.getVersion();
    }

    public int getVideoVolume(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(45), null));
        Log.debug("[InMobi]-[RE]-4.4.1", "JSUtilityController-> getVideoVolume: ");
        return imWebView.getVideoVolume(s);
    }

    public void hideVideo(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(48), null));
        Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("JSUtilityController-> hideVideo: id :")).append(s).toString());
        imWebView.hideVideo(s);
    }

    public void incentCompleted(String s)
    {
        JSONObject jsonobject;
        HashMap hashmap;
        Iterator iterator;
        jsonobject = new JSONObject(s);
        hashmap = new HashMap();
        iterator = jsonobject.keys();
_L1:
        String s1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_72;
        }
        s1 = (String)iterator.next();
        try
        {
            hashmap.put(s1, jsonobject.get(s1));
        }
        catch (JSONException jsonexception1)
        {
            try
            {
                imWebView.incentCompleted(null);
                return;
            }
            catch (JSONException jsonexception)
            {
                Log.internal("[InMobi]-[RE]-4.4.1", "JSON error");
            }
            break MISSING_BLOCK_LABEL_92;
        }
          goto _L1
        imWebView.incentCompleted(hashmap);
        return;
        imWebView.incentCompleted(null);
        return;
    }

    public boolean isAudioMuted(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(35), null));
        Log.debug("[InMobi]-[RE]-4.4.1", "JSUtilityController-> isAudioMuted: ");
        return imWebView.isAudioMuted(s);
    }

    public boolean isVideoMuted(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(43), null));
        Log.debug("[InMobi]-[RE]-4.4.1", "JSUtilityController-> isVideoMuted: ");
        return imWebView.isVideoMuted(s);
    }

    public void log(String s)
    {
        Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("Ad Log Message: ")).append(s).toString());
    }

    public void makeCall(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(29), null));
        Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("JSUtilityController-> makeCall: number: ")).append(s).toString());
        String s1 = b(s);
        if (s1 == null)
        {
            Intent intent;
            try
            {
                imWebView.raiseError("Bad Phone Number", "makeCall");
                return;
            }
            catch (Exception exception)
            {
                Log.debug("[InMobi]-[RE]-4.4.1", "Exception in making call ", exception);
            }
            break MISSING_BLOCK_LABEL_129;
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse(s1.toString()));
        intent.addFlags(0x10000000);
        imWebView.getActivity().startActivity(intent);
        imWebView.fireOnLeaveApplication();
        return;
        imWebView.raiseError("Exception in making call", "makeCall");
        return;
    }

    public void muteAudio(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(33), null));
        Log.debug("[InMobi]-[RE]-4.4.1", "JSUtilityController-> muteAudio: ");
        imWebView.muteAudio(s);
    }

    public void muteVideo(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(41), null));
        Log.debug("[InMobi]-[RE]-4.4.1", "JSUtilityController-> muteVideo: ");
        imWebView.muteVideo(s);
    }

    public void onUserInteraction(String s)
    {
        JSONObject jsonobject;
        HashMap hashmap;
        Iterator iterator;
        jsonobject = new JSONObject(s);
        hashmap = new HashMap();
        iterator = jsonobject.keys();
_L1:
        String s1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_66;
        }
        s1 = (String)iterator.next();
        try
        {
            hashmap.put(s1, jsonobject.getString(s1));
        }
        catch (JSONException jsonexception) { }
          goto _L1
        try
        {
            imWebView.userInteraction(hashmap);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void openExternal(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(2), null));
        Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("JSUtilityController-> openExternal: url: ")).append(s).toString());
        imWebView.openExternal(s);
    }

    public void pauseAudio(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(39), null));
        Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("JSUtilityController-> pauseAudio: id :")).append(s).toString());
        imWebView.pauseAudio(s);
    }

    public void pauseVideo(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(47), null));
        Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("JSUtilityController-> pauseVideo: id :")).append(s).toString());
        imWebView.pauseVideo(s);
    }

    public void playAudio(String s, boolean flag, boolean flag1, boolean flag2, String s1, String s2, String s3)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(32), null));
        Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("playAudio: url: ")).append(s).append(" autoPlay: ").append(flag).append(" controls: ").append(flag1).append(" loop: ").append(flag2).append(" startStyle: ").append(s1).append(" stopStyle: ").append(s2).append(" id:").append(s3).toString());
        imWebView.playAudio(s, flag, flag1, flag2, s1, s2, s3);
    }

    public void playVideo(String s, boolean flag, boolean flag1, boolean flag2, boolean flag3, String s1, String s2, 
            String s3, String s4, String s5, String s6, String s7)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(40), null));
        Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("JSUtilityController-> playVideo: url: ")).append(s).append(" audioMuted: ").append(flag).append(" autoPlay: ").append(flag1).append(" controls: ").append(flag2).append(" loop: ").append(flag3).append(" x: ").append(s1).append(" y: ").append(s2).append(" width: ").append(s3).append(" height: ").append(s4).append(" startStyle: ").append(s5).append(" stopStyle: ").append(s6).append(" id:").append(s7).toString());
        JSController.Dimensions dimensions = new JSController.Dimensions();
        dimensions.x = a(s1, 0xfffe7961);
        dimensions.y = a(s2, 0xfffe7961);
        dimensions.width = a(s3, 0xfffe7961);
        dimensions.height = a(s4, 0xfffe7961);
        if (dimensions.width == 0xfffe7961 && dimensions.height == 0xfffe7961)
        {
            int ai[] = b();
            dimensions.x = 0;
            dimensions.y = 0;
            dimensions.width = ai[0];
            dimensions.height = ai[1];
        }
        imWebView.playVideo(s, flag, flag1, flag2, flag3, dimensions, s5, s6, s7);
    }

    public void postToSocial(int j, String s, String s1, String s2)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(21), null));
        if (!supports((new StringBuilder("postToSocial.")).append(j).toString()))
        {
            imWebView.raiseError((new StringBuilder("Social type ")).append(j).append(" is not supported.").toString(), "postToSocial");
        } else
        {
            String s3;
            Intent intent;
            int k;
            if (s == null)
            {
                s3 = "";
            } else
            {
                s3 = s;
            }
            if (s1 == null)
            {
                s3 = "";
            }
            if (s2 == null)
            {
                s2 = "";
            }
            intent = new Intent(imWebView.getActivity(), com/inmobi/androidsdk/IMBrowserActivity);
            k = IMBrowserActivity.generateId(new c());
            intent.putExtra("extra_browser_type", 100);
            intent.putExtra("id", k);
            intent.putExtra("action", "postToSocial");
            intent.putExtra("socialType", j);
            intent.putExtra("text", s3);
            intent.putExtra("link", s1);
            intent.putExtra("image", s2);
            imWebView.getActivity().startActivity(intent);
            if (imWebView.mListener != null)
            {
                imWebView.mListener.onLeaveApplication();
                return;
            }
        }
    }

    public void registerBroadcastListener()
    {
        c();
        while (b != null || android.os.Build.VERSION.SDK_INT <= 8) 
        {
            return;
        }
        try
        {
            if (a == null)
            {
                a = (DownloadManager)imWebView.getActivity().getSystemService("download");
            }
            b = new f();
            if (!e)
            {
                imWebView.getActivity().registerReceiver((BroadcastReceiver)b, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
                return;
            }
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[RE]-4.4.1", "JSUtilityController-> registerBroadcastListener. Unable to register download listener", exception);
            return;
        }
        b = null;
        return;
    }

    public void registerMicListener()
    {
        if (h)
        {
            return;
        } else
        {
            h = true;
            AudioTriggerer.addEventListener(g);
            return;
        }
    }

    public void reset()
    {
        if (d != null)
        {
            d.reset();
        }
    }

    public void saveContent(String s, String s1)
    {
        Context context = InternalSDKUtil.getContext();
        File file = new File((new StringBuilder()).append(context.getExternalFilesDir(null)).append("/im_cached_content/").toString());
        if (file.exists())
        {
            file.delete();
        }
        file.mkdir();
        char ac[] = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder stringbuilder = new StringBuilder();
        Random random = new Random();
        for (int j = 0; j < 20; j++)
        {
            stringbuilder.append(ac[random.nextInt(ac.length)]);
        }

        File file1 = new File(file, stringbuilder.toString());
        imWebView.saveFile(file1, s1, s);
    }

    public void seekAudio(String s, int j)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(38), null));
        Log.debug("[InMobi]-[RE]-4.4.1", "JSUtilityController-> seekAudio: ");
        imWebView.seekAudio(s, j);
    }

    public void seekVideo(String s, int j)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(46), null));
        Log.debug("[InMobi]-[RE]-4.4.1", "JSUtilityController-> seekVideo: ");
        imWebView.seekVideo(s, j);
    }

    public void sendMail(String s, String s1, String s2)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(28), null));
        Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("JSUtilityController-> sendMail: recipient: ")).append(s).append(" subject: ").append(s1).append(" body: ").append(s2).toString());
        try
        {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("plain/text");
            intent.putExtra("android.intent.extra.EMAIL", new String[] {
                s
            });
            intent.putExtra("android.intent.extra.SUBJECT", s1);
            intent.putExtra("android.intent.extra.TEXT", s2);
            intent.addFlags(0x10000000);
            Intent intent1 = Intent.createChooser(intent, "Choose the Email Client.");
            imWebView.getActivity().startActivity(intent1);
            imWebView.fireOnLeaveApplication();
            return;
        }
        catch (Exception exception)
        {
            Log.debug("[InMobi]-[RE]-4.4.1", "Exception in sending mail ", exception);
        }
        imWebView.raiseError("Exception in sending mail", "sendMail");
    }

    public void sendSMS(String s, String s1)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(27), null));
        Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("JSUtilityController-> sendSMS: recipient: ")).append(s).append(" body: ").append(s1).toString());
        try
        {
            Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse((new StringBuilder("smsto:")).append(Uri.encode(s)).toString()));
            intent.putExtra("sms_body", s1);
            intent.addFlags(0x10000000);
            imWebView.getActivity().startActivity(intent);
            imWebView.fireOnLeaveApplication();
            return;
        }
        catch (Exception exception)
        {
            Log.debug("[InMobi]-[RE]-4.4.1", "Exception in sending SMS ", exception);
        }
        imWebView.raiseError("Exception in sending SMS", "sendSMS");
    }

    public void setAudioVolume(String s, int j)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(36), null));
        Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("JSUtilityController-> setAudioVolume: ")).append(s).append(" ").append(j).toString());
        imWebView.setAudioVolume(s, j);
    }

    public void setVideoVolume(String s, int j)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(44), null));
        Log.debug("[InMobi]-[RE]-4.4.1", "JSUtilityController-> setVideoVolume: ");
        imWebView.setVideoVolume(s, j);
    }

    public void setWebViewClosed(boolean flag)
    {
        e = flag;
    }

    public void showAlert(String s)
    {
        Log.debug("[InMobi]-[RE]-4.4.1", s);
    }

    public void showVideo(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(49), null));
        Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("JSUtilityController-> showVideo: id :")).append(s).toString());
        imWebView.showVideo(s);
    }

    public void stopAllListeners()
    {
        try
        {
            d.stopAllListeners();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void storePicture(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(23), null));
        Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("Store picture called on URL: ")).append(s).toString());
        Uri uri;
        android.app.DownloadManager.Request request;
        try
        {
            uri = Uri.parse(InternalSDKUtil.getFinalRedirectedUrl(s));
        }
        catch (Exception exception)
        {
            imWebView.raiseError("Invalid URL.", "storePicture");
            return;
        }
        if (!supports("storePicture"))
        {
            break MISSING_BLOCK_LABEL_97;
        }
        request = new android.app.DownloadManager.Request(uri);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, uri.getLastPathSegment());
        a.enqueue(request);
        return;
        Exception exception1;
        exception1;
        imWebView.raiseError("Unable to store.", "storePicture");
        return;
    }

    public boolean supports(String s)
    {
        boolean flag;
        PackageManager packagemanager;
        flag = true;
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(22), null));
        if (s.equals("html5video") || s.equals("inlineVideo"))
        {
            Boolean boolean1;
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                boolean flag1;
                if (imWebView.isHardwareAccelerated() && imWebView.isEnabledHardwareAcceleration())
                {
                    flag1 = flag;
                } else
                {
                    flag1 = false;
                }
                boolean1 = Boolean.valueOf(flag1);
            } else
            {
                boolean1 = Boolean.valueOf(flag);
            }
            f.put(s, boolean1);
            return boolean1.booleanValue();
        }
        Boolean boolean2 = (Boolean)f.get(s);
        if (boolean2 != null)
        {
            return boolean2.booleanValue();
        }
        packagemanager = imWebView.getActivity().getPackageManager();
        if (s.equals("tel"))
        {
            f.put(s, Boolean.valueOf(flag));
            return flag;
        }
        if (s.equals("sms"))
        {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setType("vnd.android-dir/mms-sms");
            Boolean boolean3;
            if (imWebView.getActivity().getPackageManager().resolveActivity(intent, 0x10000) == null)
            {
                boolean3 = Boolean.valueOf(false);
            } else
            {
                boolean3 = Boolean.valueOf(flag);
            }
            f.put(s, boolean3);
            return boolean3.booleanValue();
        }
        if (s.equals("calendar"))
        {
            Intent intent1 = new Intent("android.intent.action.VIEW");
            intent1.setType("vnd.android.cursor.item/event");
            Boolean boolean4;
            if (imWebView.getActivity().getPackageManager().resolveActivity(intent1, 0x10000) == null)
            {
                boolean4 = Boolean.valueOf(false);
            } else
            {
                boolean4 = Boolean.valueOf(flag);
            }
            f.put(s, boolean4);
            return boolean4.booleanValue();
        }
        if (s.equals("microphone"))
        {
            Boolean boolean11;
            if (packagemanager.checkPermission("android.permission.RECORD_AUDIO", packagemanager.getNameForUid(Binder.getCallingUid())) != 0)
            {
                flag = false;
            }
            boolean11 = Boolean.valueOf(flag);
            f.put(s, boolean11);
            return boolean11.booleanValue();
        }
        if (s.equals("storePicture"))
        {
            Boolean boolean10;
            if (android.os.Build.VERSION.SDK_INT <= 8 || packagemanager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", packagemanager.getNameForUid(Binder.getCallingUid())) != 0)
            {
                flag = false;
            }
            boolean10 = Boolean.valueOf(flag);
            f.put(s, boolean10);
            return boolean10.booleanValue();
        }
        if (s.equals("postToSocial.2") || s.equals("postToSocial.3"))
        {
            Boolean boolean5 = Boolean.valueOf(flag);
            f.put(s, boolean5);
            return boolean5.booleanValue();
        }
        if (s.equals("takeCameraPicture"))
        {
            Intent intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
            android.content.pm.ResolveInfo resolveinfo = imWebView.getActivity().getPackageManager().resolveActivity(intent2, 0x10000);
            boolean flag2;
            Boolean boolean6;
            if (packagemanager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", packagemanager.getNameForUid(Binder.getCallingUid())) == 0)
            {
                flag2 = flag;
            } else
            {
                flag2 = false;
            }
            if (resolveinfo == null || !flag2)
            {
                flag = false;
            }
            boolean6 = Boolean.valueOf(flag);
            f.put(s, boolean6);
            return boolean6.booleanValue();
        }
        if (s.equals("getGalleryImage"))
        {
            Intent intent3 = new Intent("android.intent.action.PICK", android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            Boolean boolean7;
            if (imWebView.getActivity().getPackageManager().resolveActivity(intent3, 0x10000) == null)
            {
                boolean7 = Boolean.valueOf(false);
            } else
            {
                boolean7 = Boolean.valueOf(flag);
            }
            f.put(s, boolean7);
            return boolean7.booleanValue();
        }
        if (!s.equals("vibrate")) goto _L2; else goto _L1
_L1:
        Boolean boolean8;
        Boolean boolean9;
        boolean flag3;
        Vibrator vibrator;
        if (packagemanager.checkPermission("android.permission.VIBRATE", packagemanager.getNameForUid(Binder.getCallingUid())) == 0)
        {
            flag3 = flag;
        } else
        {
            flag3 = false;
        }
        boolean8 = Boolean.valueOf(flag3);
        vibrator = (Vibrator)d.imWebView.getActivity().getSystemService("vibrator");
        if (vibrator == null) goto _L4; else goto _L3
_L3:
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            break MISSING_BLOCK_LABEL_838;
        }
        if (!boolean8.booleanValue() || !vibrator.hasVibrator()) goto _L4; else goto _L5
_L5:
        boolean9 = Boolean.valueOf(flag);
_L6:
        f.put(s, boolean9);
        return boolean9.booleanValue();
_L4:
        flag = false;
          goto _L5
_L2:
        return false;
        boolean9 = boolean8;
          goto _L6
    }

    public String supportsFeature(String s)
    {
        return String.valueOf(supports(s));
    }

    public String takeCameraPicture()
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(24), null));
        if (!supports("takeCameraPicture"))
        {
            Log.internal("[InMobi]-[RE]-4.4.1", "takeCameraPicture called even if it is not supported");
        } else
        {
            Intent intent = new Intent(imWebView.getActivity(), com/inmobi/androidsdk/IMBrowserActivity);
            intent.putExtra("extra_browser_type", 100);
            ContentValues contentvalues = new ContentValues();
            Uri uri = mContext.getContentResolver().insert(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentvalues);
            intent.putExtra("id", IMBrowserActivity.generateId(new b(uri)));
            intent.putExtra("URI", uri);
            intent.putExtra("action", "takeCameraPicture");
            imWebView.getActivity().startActivity(intent);
            if (imWebView.mListener != null)
            {
                imWebView.mListener.onLeaveApplication();
                return null;
            }
        }
        return null;
    }

    public void unMuteAudio(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(34), null));
        Log.debug("[InMobi]-[RE]-4.4.1", "JSUtilityController-> unMuteAudio: ");
        imWebView.unMuteAudio(s);
    }

    public void unMuteVideo(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(42), null));
        Log.debug("[InMobi]-[RE]-4.4.1", "JSUtilityController-> unMuteVideo: ");
        imWebView.unMuteVideo(s);
    }

    public void unRegisterBroadcastListener()
    {
        try
        {
            d();
            if (android.os.Build.VERSION.SDK_INT > 8)
            {
                imWebView.getActivity().unregisterReceiver((BroadcastReceiver)b);
                b = null;
            }
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[RE]-4.4.1", "JSUtilityController-> unregisterBroadcastListener. Unable to unregister download listener");
        }
    }

    public void unRegisterMicListener()
    {
        if (!h)
        {
            return;
        } else
        {
            h = false;
            AudioTriggerer.removeEventListener(g);
            return;
        }
    }

    public void vibrate()
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(26), null));
        if (!imWebView.isViewable())
        {
            imWebView.raiseError("Creative not visible. Will not vibrate.", "vibrate");
            return;
        }
        if (supports("vibrate"))
        {
            ((Vibrator)imWebView.getActivity().getSystemService("vibrator")).vibrate(2000L);
            (new Timer()).schedule(new g(), 2000L);
            return;
        } else
        {
            Log.internal("[InMobi]-[RE]-4.4.1", "vibrate called even if it is not supported");
            return;
        }
    }

    public void vibrate(String s, int j)
    {
        Vibrator vibrator;
        String s1;
        try
        {
            ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(26), null));
            if (!imWebView.isViewable())
            {
                imWebView.raiseError("Creative not visible. Will not vibrate.", "vibrate");
                return;
            }
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[RE]-4.4.1", "vibrate exception", exception);
            return;
        }
        if (!supports("vibrate")) goto _L2; else goto _L1
_L1:
        vibrator = (Vibrator)imWebView.getActivity().getSystemService("vibrator");
        s1 = s.replaceAll("\\[", "").replaceAll("\\]", "");
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        if (!"".equals(s1.trim()))
        {
            break MISSING_BLOCK_LABEL_133;
        }
        vibrator.cancel();
        return;
        String as[];
        int k;
        int l;
        as = s1.split(",");
        k = as.length;
        if (k <= Initializer.getConfigParams().getMaxVibPatternLength())
        {
            break MISSING_BLOCK_LABEL_372;
        }
        Log.internal("[InMobi]-[RE]-4.4.1", (new StringBuilder("vibration pattern exceeds max length. Will be truncated to max ")).append(Initializer.getConfigParams().getMaxVibPatternLength()).append("ms").toString());
        l = Initializer.getConfigParams().getMaxVibPatternLength();
_L3:
        long al[] = new long[l];
        NumberFormatException numberformatexception;
        for (int i1 = 0; i1 >= l; i1++)
        {
            break MISSING_BLOCK_LABEL_334;
        }

        al[i1] = Long.parseLong(as[i1]);
        if (al[i1] > (long)Initializer.getConfigParams().getMaxVibDuration())
        {
            Log.internal("[InMobi]-[RE]-4.4.1", (new StringBuilder("vibration duration exceeds max. Will only vibrate for max ")).append(Initializer.getConfigParams().getMaxVibDuration()).append("ms").toString());
            al[i1] = Initializer.getConfigParams().getMaxVibDuration();
        }
        if (al[i1] < 0L)
        {
            imWebView.raiseError("Negative duration not allowed in vibration .", "vibrate");
        }
        break MISSING_BLOCK_LABEL_380;
        numberformatexception;
        imWebView.raiseError("Invalid values of pattern in vibration .", "vibrate");
        return;
        if (al.length != 0)
        {
            vibrator.vibrate(al, j);
            return;
        }
        break MISSING_BLOCK_LABEL_379;
_L2:
        imWebView.raiseError("Vibrate called even if it is not supported.", "vibrate");
        Log.internal("[InMobi]-[RE]-4.4.1", "vibrate called even if it is not supported");
        return;
        l = k;
          goto _L3
    }

    static 
    {
        SimpleDateFormat asimpledateformat[] = new SimpleDateFormat[9];
        asimpledateformat[0] = new SimpleDateFormat("yyyy-MM-dd'T'hh:mmZ", Locale.ENGLISH);
        asimpledateformat[1] = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.ENGLISH);
        asimpledateformat[2] = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz", Locale.ENGLISH);
        asimpledateformat[3] = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
        asimpledateformat[4] = new SimpleDateFormat("yyyyMMddHHmmssZ", Locale.ENGLISH);
        asimpledateformat[5] = new SimpleDateFormat("yyyyMMddHHmm", Locale.ENGLISH);
        asimpledateformat[6] = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
        asimpledateformat[7] = new SimpleDateFormat("yyyyMM", Locale.ENGLISH);
        asimpledateformat[8] = new SimpleDateFormat("yyyy", Locale.ENGLISH);
        formats = asimpledateformat;
        SimpleDateFormat asimpledateformat1[] = new SimpleDateFormat[3];
        asimpledateformat1[0] = new SimpleDateFormat("yyyyMMdd'T'HHmmssZ");
        asimpledateformat1[1] = new SimpleDateFormat("yyyyMMdd'T'HHmm");
        asimpledateformat1[2] = new SimpleDateFormat("yyyyMMdd");
        calendarUntiFormats = asimpledateformat1;
    }

    private class d extends Thread
    {

        final String a;
        final JSUtilityController b;

        public void run()
        {
            HttpURLConnection httpurlconnection = null;
            HttpURLConnection httpurlconnection1;
            String s = a.replaceAll("%25", "%");
            Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("Pinging URL: ")).append(s).toString());
            httpurlconnection1 = (HttpURLConnection)(new URL(s)).openConnection();
            httpurlconnection1.setConnectTimeout(20000);
            httpurlconnection1.setRequestMethod("GET");
            InternalSDKUtil.addCommonPropertiesToConnection(httpurlconnection1);
            Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("Async Ping Connection Response Code: ")).append(httpurlconnection1.getResponseCode()).toString());
            if (httpurlconnection1 != null)
            {
                httpurlconnection1.disconnect();
            }
_L2:
            return;
            Exception exception1;
            exception1;
_L5:
            Log.debug("[InMobi]-[RE]-4.4.1", "Error doing async Ping. ", exception1);
            if (httpurlconnection == null) goto _L2; else goto _L1
_L1:
            httpurlconnection.disconnect();
            return;
            Exception exception;
            exception;
_L4:
            if (httpurlconnection != null)
            {
                httpurlconnection.disconnect();
            }
            throw exception;
            Exception exception3;
            exception3;
            httpurlconnection = httpurlconnection1;
            exception = exception3;
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception2;
            exception2;
            httpurlconnection = httpurlconnection1;
            exception1 = exception2;
              goto _L5
        }

        d(String s)
        {
            b = JSUtilityController.this;
            a = s;
            super();
        }
    }


    private class e
        implements StartActivityForResultCallback
    {

        final String a;
        final String b;
        final String c;
        final JSUtilityController d;

        public void onActivityResult(int j, Intent intent)
        {
            if (!d.a("android.permission.READ_CALENDAR") || !d.a("android.permission.WRITE_CALENDAR")) goto _L2; else goto _L1
_L1:
            int k = JSUtilityController.a(d);
            if (d.c == k)
            {
                Log.internal("[InMobi]-[RE]-4.4.1", "User cancelled the create calendar event");
                return;
            }
            if (android.os.Build.VERSION.SDK_INT < 8) goto _L4; else goto _L3
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
            int l;
            l = Integer.parseInt(b) / 60000;
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
            l = (int)(JSUtilityController.convertDateString(b).getTimeInMillis() - JSUtilityController.convertDateString(c).getTimeInMillis()) / 60000;
              goto _L13
            exception1;
            d.imWebView.raiseError("Reminder format is incorrect. Invalid date", "createCalendarEvent");
            return;
_L13:
            int i1;
            NumberFormatException numberformatexception;
            Exception exception1;
            if (l > 0)
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
            i1 = -l;
            ContentValues contentvalues1 = new ContentValues();
            contentvalues1.put("hasAlarm", Integer.valueOf(1));
            contentresolver.update(ContentUris.withAppendedId(uri, JSUtilityController.a(d)), contentvalues1, null, null);
            if (android.os.Build.VERSION.SDK_INT < 8) goto _L15; else goto _L14
_L14:
            Uri uri2 = Uri.parse("content://com.android.calendar/reminders");
_L16:
            ContentValues contentvalues2 = new ContentValues();
            contentvalues2.put("event_id", Integer.valueOf(JSUtilityController.a(d)));
            contentvalues2.put("method", Integer.valueOf(1));
            contentvalues2.put("minutes", Integer.valueOf(i1));
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

        e(String s, String s1, String s2)
        {
            d = JSUtilityController.this;
            a = s;
            b = s1;
            c = s2;
            super();
        }
    }


    private class a
        implements StartActivityForResultCallback
    {

        final JSUtilityController a;

        public void onActivityResult(int j, Intent intent)
        {
            if (j == -1)
            {
                Bitmap bitmap = ImageProcessing.getCompressedBitmap(ImageProcessing.convertMediaUriToPath(intent.getData(), a.mContext), a.mContext);
                int k = bitmap.getWidth();
                int l = bitmap.getHeight();
                String s = ImageProcessing.getBase64EncodedImage(bitmap, a.mContext);
                a.imWebView.raiseGalleryImageSelectedEvent(s, k, l);
                return;
            } else
            {
                a.imWebView.raiseError("User did not select a picture", "getGalleryImage");
                return;
            }
        }

        a()
        {
            a = JSUtilityController.this;
            super();
        }
    }


    private class c
        implements StartActivityForResultCallback
    {

        final JSUtilityController a;

        public void onActivityResult(int j, Intent intent)
        {
        }

        c()
        {
            a = JSUtilityController.this;
            super();
        }
    }


    private class f extends BroadcastReceiver
    {

        final JSUtilityController a;

        public void onReceive(Context context, Intent intent)
        {
            Cursor cursor;
            int j;
label0:
            {
                if ("android.intent.action.DOWNLOAD_COMPLETE".equals(intent.getAction()))
                {
                    long l = intent.getLongExtra("extra_download_id", 0L);
                    android.app.DownloadManager.Query query = new android.app.DownloadManager.Query();
                    query.setFilterById(new long[] {
                        l
                    });
                    cursor = a.a.query(query);
                    if (cursor.moveToFirst())
                    {
                        j = cursor.getColumnIndex("status");
                        if (16 != cursor.getInt(j))
                        {
                            break label0;
                        }
                        a.imWebView.raiseError("download failed", "storePicture");
                    }
                }
                return;
            }
            cursor.getInt(j);
        }

        f()
        {
            a = JSUtilityController.this;
            super();
        }
    }


    private class b
        implements StartActivityForResultCallback
    {

        final Uri a;
        final JSUtilityController b;

        public void onActivityResult(int j, Intent intent)
        {
            if (j == -1)
            {
                String s;
                Bitmap bitmap;
                int k;
                int l;
                String s1;
                if (intent == null)
                {
                    s = ImageProcessing.convertMediaUriToPath(a, b.mContext);
                } else
                {
                    s = ImageProcessing.convertMediaUriToPath(intent.getData(), b.mContext);
                }
                bitmap = ImageProcessing.getCompressedBitmap(s, b.mContext);
                k = bitmap.getWidth();
                l = bitmap.getHeight();
                s1 = ImageProcessing.getBase64EncodedImage(bitmap, b.mContext);
                b.imWebView.raiseCameraPictureCapturedEvent(s1, k, l);
                return;
            } else
            {
                b.imWebView.raiseError("User did not take a picture", "takeCameraPicture");
                return;
            }
        }

        b(Uri uri)
        {
            b = JSUtilityController.this;
            a = uri;
            super();
        }
    }


    private class g extends TimerTask
    {

        final JSUtilityController a;

        public void run()
        {
            try
            {
                a.imWebView.raiseVibrateCompleteEvent();
                return;
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-[RE]-4.4.1", "Vibrate callback execption", exception);
            }
        }

        g()
        {
            a = JSUtilityController.this;
            super();
        }
    }

}
