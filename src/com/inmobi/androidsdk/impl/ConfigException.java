// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk.impl;


public final class ConfigException extends Exception
{

    public static final int MISSING_ACCESS_NETWORK_STATE_PERMISSION = -9;
    public static final int MISSING_ACTIVITY_DECLARATION = -2;
    public static final int MISSING_CONFIG_CHANGES = -3;
    public static final int MISSING_CONFIG_KEYBOARD = -4;
    public static final int MISSING_CONFIG_KEYBOARDHIDDEN = -5;
    public static final int MISSING_CONFIG_ORIENTATION = -6;
    public static final int MISSING_CONFIG_SCREENSIZE = -7;
    public static final int MISSING_CONFIG_SMALLEST_SCREENSIZE = -8;
    public static final int MISSING_INTERNET_PERMISSION = -1;
    private static final long serialVersionUID = 1L;
    private int a;

    ConfigException(int i)
    {
        a = i;
    }

    public final int getExceptionCode()
    {
        return a;
    }

    public final String toString()
    {
        StringBuffer stringbuffer = new StringBuffer("IMConfigException : ");
        a;
        JVM INSTR tableswitch -9 -1: default 64
    //                   -9 149
    //                   -8 139
    //                   -7 129
    //                   -6 119
    //                   -5 109
    //                   -4 99
    //                   -3 79
    //                   -2 69
    //                   -1 89;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
        return stringbuffer.toString();
_L9:
        stringbuffer.append("IMBrowserActivity not declared in the manifest. Please declare it in the app manifest");
        continue; /* Loop/switch isn't completed */
_L8:
        stringbuffer.append("IMBrowserActivity in the manifest does not have android:configChanges attributes.Please add android:configChanges=keyboardHidden|orientation|keyboard|screenSize|smallestScreenSize to IMBrowserActivity in the app manifest");
        continue; /* Loop/switch isn't completed */
_L10:
        stringbuffer.append("App does not have INTERNET permissions. Please provide INTERNET permissions");
        continue; /* Loop/switch isn't completed */
_L7:
        stringbuffer.append("Missing Config keyboard from android:configChangesof IMBRowserActivity");
        continue; /* Loop/switch isn't completed */
_L6:
        stringbuffer.append("Missing Config keyboardHidden from android:configChangesof IMBRowserActivity");
        continue; /* Loop/switch isn't completed */
_L5:
        stringbuffer.append("Missing Config orientation from android:configChangesof IMBRowserActivity");
        continue; /* Loop/switch isn't completed */
_L4:
        stringbuffer.append("Missing Config screenSize from android:configChangesof IMBRowserActivity");
        continue; /* Loop/switch isn't completed */
_L3:
        stringbuffer.append("Missing Config smallestScreenSize from android:configChanges of IMBRowserActivity");
        continue; /* Loop/switch isn't completed */
_L2:
        stringbuffer.append("App does not have ACCESS_NETWORK_STATE permissions. Please provide ACCESS_NETWORK_STATE permissions");
        if (true) goto _L1; else goto _L11
_L11:
    }
}
