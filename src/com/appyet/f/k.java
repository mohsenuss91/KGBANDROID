// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.f;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import com.appyet.context.ApplicationContext;
import com.appyet.metadata.Metadata;
import com.appyet.metadata.MetadataApplication;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class k
    implements Runnable, Thread.UncaughtExceptionHandler
{

    private static String a;
    private static String b;
    private static String c;
    private static String d;
    private Thread.UncaughtExceptionHandler e;
    private Activity f;

    public k(Activity activity)
    {
        f = null;
        e = Thread.getDefaultUncaughtExceptionHandler();
        f = activity;
    }

    private LinkedList a(LinkedList linkedlist)
    {
        if (linkedlist == null)
        {
            linkedlist = new LinkedList();
        }
        linkedlist.add((new StringBuilder()).append(f.getLocalClassName()).append(" (").append(f.getTitle()).append(")").toString());
        if (f.getCallingActivity() == null) goto _L2; else goto _L1
_L1:
        linkedlist.add((new StringBuilder()).append(f.getCallingActivity().toString()).append(" (").append(f.getIntent().toString()).append(")").toString());
_L4:
        if (e != null && (e instanceof k))
        {
            ((k)e).a(linkedlist);
        }
        return linkedlist;
_L2:
        if (f.getCallingPackage() != null)
        {
            linkedlist.add((new StringBuilder()).append(f.getCallingPackage().toString()).append(" (").append(f.getIntent().toString()).append(")").toString());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void a(Thread thread, Throwable throwable)
    {
label0:
        {
            do
            {
                if (e == null)
                {
                    break label0;
                }
                if (!(e instanceof k))
                {
                    break;
                }
                this = (k)e;
            } while (true);
            e.uncaughtException(thread, throwable);
        }
    }

    private CharSequence b()
    {
        PackageManager packagemanager = f.getPackageManager();
        CharSequence charsequence;
        try
        {
            charsequence = packagemanager.getPackageInfo(f.getPackageName(), 0).applicationInfo.loadLabel(packagemanager);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return f.getPackageName();
        }
        return charsequence;
    }

    private String c()
    {
        PackageManager packagemanager = f.getPackageManager();
        PackageInfo packageinfo1 = packagemanager.getPackageInfo(f.getPackageName(), 0);
        PackageInfo packageinfo = packageinfo1;
_L1:
        String s1;
        Date date = new Date();
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss_zzz");
        String s = (new StringBuilder()).append("-------- Environment --------\n").append("Time\t= ").append(simpledateformat.format(date)).append("\n").toString();
        s1 = (new StringBuilder()).append(s).append("Device\t= ").append(Build.FINGERPRINT).append("\n").toString();
        String s7;
        Field field = android/os/Build.getField("MANUFACTURER");
        s7 = (new StringBuilder()).append(s1).append("Make\t=").append(field.get(null)).append("\n").toString();
        s1 = s7;
_L2:
        String s2 = (new StringBuilder()).append(s1).append("Model\t= ").append(Build.MODEL).append("\n").toString();
        String s3 = (new StringBuilder()).append(s2).append("Product\t= ").append(Build.PRODUCT).append("\n").toString();
        String s4 = (new StringBuilder()).append(s3).append("App\t\t= ").append(f.getPackageName()).append(", version ").append(packageinfo.versionName).append(" (build ").append(packageinfo.versionCode).append(")\n").toString();
        String s5 = (new StringBuilder()).append(s4).append("Locale\t= ").append(f.getResources().getConfiguration().locale.getDisplayName()).append("\n").toString();
        String s6 = (new StringBuilder()).append(s5).append("Res\t\t= ").append(f.getResources().getDisplayMetrics().toString()).append("\n").toString();
        return (new StringBuilder()).append(s6).append("-----------------------------\n\n").toString();
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        packageinfo = new PackageInfo();
        packageinfo.versionName = "unknown";
        packageinfo.versionCode = 69;
          goto _L1
        IllegalAccessException illegalaccessexception;
        illegalaccessexception;
          goto _L2
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
          goto _L2
        NoSuchFieldException nosuchfieldexception;
        nosuchfieldexception;
          goto _L2
        SecurityException securityexception;
        securityexception;
          goto _L2
    }

    private void d()
    {
        boolean flag;
        String s;
        flag = true;
        s = "";
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(f.openFileInput("postmortem.trace")));
_L1:
        String s1 = bufferedreader.readLine();
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        s = (new StringBuilder()).append(s).append(s1).append("\n").toString();
          goto _L1
        if (s == null) goto _L3; else goto _L2
_L2:
        Intent intent;
        intent = new Intent("android.intent.action.SEND");
        String s2 = (new StringBuilder()).append(b()).append(" ").append(a).toString();
        String s3 = (new StringBuilder("\n")).append(c).append("\n\n").append(s).append("\n\n").toString();
        String as[] = new String[1];
        as[0] = b;
        intent.putExtra("android.intent.extra.EMAIL", as);
        intent.putExtra("android.intent.extra.TEXT", s3);
        intent.putExtra("android.intent.extra.SUBJECT", s2);
        intent.setType("message/rfc822");
        FileNotFoundException filenotfoundexception;
        IOException ioexception;
        Boolean boolean1;
        Boolean boolean2;
        if (f.getPackageManager().queryIntentActivities(intent, 0).size() <= 0)
        {
            flag = false;
        }
        if (!Boolean.valueOf(flag).booleanValue()) goto _L5; else goto _L4
_L4:
        f.startActivity(intent);
_L3:
        boolean2 = Boolean.valueOf(true);
_L6:
        if (boolean2.booleanValue())
        {
            f.deleteFile("postmortem.trace");
            return;
        }
        break MISSING_BLOCK_LABEL_289;
_L5:
        boolean1 = Boolean.valueOf(false);
        boolean2 = boolean1;
          goto _L6
        ioexception;
        return;
        filenotfoundexception;
    }

    public final void a()
    {
        if (f == null)
        {
            throw new NullPointerException();
        } else
        {
            d();
            Thread.setDefaultUncaughtExceptionHandler(this);
            a = f.getString(0x7f080050);
            c = f.getString(0x7f080051);
            b = "appyet3@gmail.com";
            d = ((ApplicationContext)f.getApplicationContext()).q.MetadataApplication.BuildTemplateVersionName;
            return;
        }
    }

    protected final void finalize()
    {
        if (Thread.getDefaultUncaughtExceptionHandler().equals(this))
        {
            Thread.setDefaultUncaughtExceptionHandler(e);
        }
        super.finalize();
    }

    public final void run()
    {
        d();
    }

    public final void uncaughtException(Thread thread, Throwable throwable)
    {
        int i = 0;
        NotificationManager notificationmanager = (NotificationManager)f.getSystemService("notification");
        DecimalFormat decimalformat;
        String s;
        String s1;
        LinkedList linkedlist;
        if (notificationmanager != null)
        {
            try
            {
                notificationmanager.cancel(0x41a9aa);
            }
            catch (Throwable throwable2)
            {
                throwable2.printStackTrace();
            }
        }
        decimalformat = new DecimalFormat("#0.");
        s = (new StringBuilder()).append("").append(b()).append(" generated the following exception:\n").toString();
        s1 = (new StringBuilder()).append(s).append(throwable.toString()).append("\n\n").toString();
        linkedlist = a(null);
        if (linkedlist != null && linkedlist.size() > 0)
        {
            String s8 = (new StringBuilder()).append(s1).append("--------- Activity Stack Trace ---------\n").toString();
            for (int l = 0; l < linkedlist.size(); l++)
            {
                s8 = (new StringBuilder()).append(s8).append(decimalformat.format(l + 1)).append("\t").append(linkedlist.get(l)).append("\n").toString();
            }

            s1 = (new StringBuilder()).append(s8).append("----------------------------------------\n\n").toString();
        }
        if (throwable != null)
        {
            StackTraceElement astacktraceelement[] = throwable.getStackTrace();
            if (astacktraceelement.length > 0)
            {
                String s7 = (new StringBuilder()).append(s1).append("--------- Instruction Stack trace ---------\n").toString();
                for (int j = 0; j < astacktraceelement.length; j++)
                {
                    s7 = (new StringBuilder()).append(s7).append(decimalformat.format(j + 1)).append("\t").append(astacktraceelement[j].toString()).append("\n").toString();
                }

                s1 = (new StringBuilder()).append(s7).append("-------------------------------------------\n\n").toString();
            }
            Throwable throwable1 = throwable.getCause();
            if (throwable1 != null)
            {
                String s5 = (new StringBuilder()).append(s1).append("----------- Cause -----------\n").toString();
                String s6 = (new StringBuilder()).append(s5).append(throwable1.toString()).append("\n\n").toString();
                for (StackTraceElement astacktraceelement1[] = throwable1.getStackTrace(); i < astacktraceelement1.length; i++)
                {
                    s6 = (new StringBuilder()).append(s6).append(decimalformat.format(i + 1)).append("\t").append(astacktraceelement1[i].toString()).append("\n").toString();
                }

                s1 = (new StringBuilder()).append(s6).append("-----------------------------\n\n").toString();
            }
        }
        String s2 = (new StringBuilder()).append(s1).append(c()).toString();
        String s3 = (new StringBuilder()).append(s2).append("Source Version Name: ").append(d).toString();
        String s4 = (new StringBuilder()).append(s3).append("\n\nEND REPORT.").toString();
        try
        {
            FileOutputStream fileoutputstream = f.openFileOutput("postmortem.trace", 0);
            fileoutputstream.write(s4.getBytes());
            fileoutputstream.close();
        }
        catch (IOException ioexception) { }
        f.runOnUiThread(this);
        a(thread, throwable);
    }
}
