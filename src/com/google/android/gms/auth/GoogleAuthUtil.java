// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth;

import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.a;
import com.google.android.gms.internal.ge;
import com.google.android.gms.internal.hn;
import com.google.android.gms.internal.s;
import java.io.IOException;
import java.net.URISyntaxException;

// Referenced classes of package com.google.android.gms.auth:
//            GooglePlayServicesAvailabilityException, UserRecoverableAuthException, UserRecoverableNotifiedException, GoogleAuthException

public final class GoogleAuthUtil
{

    public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
    public static final String KEY_ANDROID_PACKAGE_NAME = "androidPackageName";
    public static final String KEY_CALLER_UID = "callerUid";
    public static final String KEY_REQUEST_ACTIONS = "request_visible_actions";
    public static final String KEY_REQUEST_VISIBLE_ACTIVITIES = "request_visible_actions";
    public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
    private static final ComponentName yR;
    private static final ComponentName yS;
    private static final Intent yT;
    private static final Intent yU;

    private GoogleAuthUtil()
    {
    }

    private static String a(Context context, String s1, String s2, Bundle bundle)
    {
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        String s3;
        try
        {
            s3 = getToken(context, s1, s2, bundle);
        }
        catch (GooglePlayServicesAvailabilityException googleplayservicesavailabilityexception)
        {
            int i = googleplayservicesavailabilityexception.getConnectionStatusCode();
            if (b(context, i))
            {
                a a1 = new a(context.getApplicationContext());
                a1.sendMessageDelayed(a1.obtainMessage(1), 30000L);
            } else
            {
                GooglePlayServicesUtil.showErrorNotification(i, context);
            }
            throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
        }
        catch (UserRecoverableAuthException userrecoverableauthexception)
        {
            throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
        }
        return s3;
    }

    private static boolean ac(String s1)
    {
        return "NetworkError".equals(s1) || "ServiceUnavailable".equals(s1) || "Timeout".equals(s1);
    }

    private static boolean ad(String s1)
    {
        return "BadAuthentication".equals(s1) || "CaptchaRequired".equals(s1) || "DeviceManagementRequiredOrSyncDisabled".equals(s1) || "NeedPermission".equals(s1) || "NeedsBrowser".equals(s1) || "UserCancel".equals(s1) || "AppDownloadRequired".equals(s1);
    }

    private static boolean b(Context context, int i)
    {
        PackageManager packagemanager;
        if (i != 1)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        packagemanager = context.getPackageManager();
        boolean flag = packagemanager.getApplicationInfo("com.google.android.gms", 8192).enabled;
        if (flag)
        {
            return true;
        }
        break MISSING_BLOCK_LABEL_32;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        return false;
    }

    public static void clearToken(Context context, String s1)
    {
        Context context1;
        Bundle bundle;
        com.google.android.gms.common.a a1;
        context1 = context.getApplicationContext();
        hn.az("Calling this from your main thread can lead to deadlock");
        w(context1);
        bundle = new Bundle();
        String s2 = context.getApplicationInfo().packageName;
        bundle.putString("clientPackageName", s2);
        if (!bundle.containsKey(KEY_ANDROID_PACKAGE_NAME))
        {
            bundle.putString(KEY_ANDROID_PACKAGE_NAME, s2);
        }
        a1 = new com.google.android.gms.common.a();
        if (!context1.bindService(yT, a1, 1))
        {
            break MISSING_BLOCK_LABEL_181;
        }
        Bundle bundle1 = com.google.android.gms.internal.s.a.a(a1.er()).a(s1, bundle);
        String s3 = bundle1.getString(ge.zI);
        if (!bundle1.getBoolean("booleanResult"))
        {
            throw new GoogleAuthException(s3);
        }
        break MISSING_BLOCK_LABEL_161;
        RemoteException remoteexception;
        remoteexception;
        Log.i("GoogleAuthUtil", "GMS remote exception ", remoteexception);
        throw new IOException("remote exception");
        Exception exception;
        exception;
        context1.unbindService(a1);
        throw exception;
        context1.unbindService(a1);
        return;
        InterruptedException interruptedexception;
        interruptedexception;
        throw new GoogleAuthException("Interrupted");
        throw new IOException("Could not bind to service with the given context.");
    }

    private static void g(Intent intent)
    {
        if (intent == null)
        {
            throw new IllegalArgumentException("Callback cannot be null.");
        }
        String s1 = intent.toUri(1);
        try
        {
            Intent.parseUri(s1, 1);
            return;
        }
        catch (URISyntaxException urisyntaxexception)
        {
            throw new IllegalArgumentException("Parameter callback contains invalid data. It must be serializable using toUri() and parseUri().");
        }
    }

    public static String getToken(Context context, String s1, String s2)
    {
        return getToken(context, s1, s2, new Bundle());
    }

    public static String getToken(Context context, String s1, String s2, Bundle bundle)
    {
        Context context1;
        com.google.android.gms.common.a a1;
        Bundle bundle2;
        context1 = context.getApplicationContext();
        hn.az("Calling this from your main thread can lead to deadlock");
        w(context1);
        Bundle bundle1;
        String s3;
        String s4;
        boolean flag;
        if (bundle == null)
        {
            bundle1 = new Bundle();
        } else
        {
            bundle1 = new Bundle(bundle);
        }
        s3 = context.getApplicationInfo().packageName;
        bundle1.putString("clientPackageName", s3);
        if (!bundle1.containsKey(KEY_ANDROID_PACKAGE_NAME))
        {
            bundle1.putString(KEY_ANDROID_PACKAGE_NAME, s3);
        }
        a1 = new com.google.android.gms.common.a();
        if (!context1.bindService(yT, a1, 1))
        {
            break MISSING_BLOCK_LABEL_274;
        }
        bundle2 = com.google.android.gms.internal.s.a.a(a1.er()).a(s1, s2, bundle1);
        s4 = bundle2.getString("authtoken");
        flag = TextUtils.isEmpty(s4);
        if (!flag)
        {
            context1.unbindService(a1);
            return s4;
        }
        String s5;
        s5 = bundle2.getString("Error");
        Intent intent = (Intent)bundle2.getParcelable("userRecoveryIntent");
        if (ad(s5))
        {
            throw new UserRecoverableAuthException(s5, intent);
        }
        break MISSING_BLOCK_LABEL_233;
        RemoteException remoteexception;
        remoteexception;
        Log.i("GoogleAuthUtil", "GMS remote exception ", remoteexception);
        throw new IOException("remote exception");
        Exception exception;
        exception;
        context1.unbindService(a1);
        throw exception;
        if (ac(s5))
        {
            throw new IOException(s5);
        }
        break MISSING_BLOCK_LABEL_264;
        InterruptedException interruptedexception;
        interruptedexception;
        throw new GoogleAuthException("Interrupted");
        throw new GoogleAuthException(s5);
        throw new IOException("Could not bind to service with the given context.");
    }

    public static String getTokenWithNotification(Context context, String s1, String s2, Bundle bundle)
    {
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        bundle.putBoolean("handle_notification", true);
        return a(context, s1, s2, bundle);
    }

    public static String getTokenWithNotification(Context context, String s1, String s2, Bundle bundle, Intent intent)
    {
        g(intent);
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        bundle.putParcelable("callback_intent", intent);
        bundle.putBoolean("handle_notification", true);
        return a(context, s1, s2, bundle);
    }

    public static String getTokenWithNotification(Context context, String s1, String s2, Bundle bundle, String s3, Bundle bundle1)
    {
        if (TextUtils.isEmpty(s3))
        {
            throw new IllegalArgumentException("Authority cannot be empty or null.");
        }
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        if (bundle1 == null)
        {
            bundle1 = new Bundle();
        }
        ContentResolver.validateSyncExtrasBundle(bundle1);
        bundle.putString("authority", s3);
        bundle.putBundle("sync_extras", bundle1);
        bundle.putBoolean("handle_notification", true);
        return a(context, s1, s2, bundle);
    }

    public static void invalidateToken(Context context, String s1)
    {
        AccountManager.get(context).invalidateAuthToken("com.google", s1);
    }

    private static void w(Context context)
    {
        try
        {
            GooglePlayServicesUtil.w(context);
            return;
        }
        catch (GooglePlayServicesRepairableException googleplayservicesrepairableexception)
        {
            throw new GooglePlayServicesAvailabilityException(googleplayservicesrepairableexception.getConnectionStatusCode(), googleplayservicesrepairableexception.getMessage(), googleplayservicesrepairableexception.getIntent());
        }
        catch (GooglePlayServicesNotAvailableException googleplayservicesnotavailableexception)
        {
            throw new GoogleAuthException(googleplayservicesnotavailableexception.getMessage());
        }
    }

    static 
    {
        int _tmp = android.os.Build.VERSION.SDK_INT;
        int _tmp1 = android.os.Build.VERSION.SDK_INT;
        yR = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
        yS = new ComponentName("com.google.android.gms", "com.google.android.gms.recovery.RecoveryService");
        yT = (new Intent()).setPackage("com.google.android.gms").setComponent(yR);
        yU = (new Intent()).setPackage("com.google.android.gms").setComponent(yS);
    }

    private class a extends Handler
    {

        private final Context lx;

        public void handleMessage(Message message)
        {
            if (message.what == 1)
            {
                int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(lx);
                if (GooglePlayServicesUtil.isUserRecoverableError(i))
                {
                    GooglePlayServicesUtil.showErrorNotification(i, lx);
                }
                return;
            } else
            {
                Log.wtf("GoogleAuthUtil", (new StringBuilder("Don't know how to handle this message: ")).append(message.what).toString());
                return;
            }
        }

        a(Context context)
        {
            Looper looper;
            if (Looper.myLooper() == null)
            {
                looper = Looper.getMainLooper();
            } else
            {
                looper = Looper.myLooper();
            }
            super(looper);
            lx = context;
        }
    }

}
