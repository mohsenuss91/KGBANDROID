// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.uid;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.thirdparty.Base64;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.Cipher;

// Referenced classes of package com.inmobi.commons.uid:
//            AdvertisingId

public class UIDHelper
{

    private static final Uri a = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
    private static String b = null;
    private static AdvertisingId c = null;

    public UIDHelper()
    {
    }

    static AdvertisingId a()
    {
        return c;
    }

    static String a(String s, String s1)
    {
        byte abyte0[];
        byte abyte1[];
        byte abyte2[];
        int i;
        String s2;
        try
        {
            abyte0 = s.getBytes("UTF-8");
            abyte1 = new byte[abyte0.length];
            abyte2 = s1.getBytes("UTF-8");
        }
        catch (Exception exception)
        {
            Log.debug("[InMobi]-4.4.1", "Exception in xor with random integer", exception);
            return "";
        }
        i = 0;
        if (i >= abyte0.length)
        {
            break; /* Loop/switch isn't completed */
        }
        abyte1[i] = (byte)(abyte0[i] ^ abyte2[i % abyte2.length]);
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_24;
_L1:
        s2 = new String(Base64.encode(abyte1, 2), "UTF-8");
        return s2;
    }

    private static byte[] a(byte abyte0[], int i, Cipher cipher)
    {
        byte abyte1[] = new byte[0];
        int j = abyte0.length;
        byte abyte2[] = new byte[64];
        byte abyte3[] = abyte1;
        byte abyte4[] = abyte2;
        int k = 0;
        while (k < j) 
        {
            if (k > 0 && k % 64 == 0)
            {
                byte abyte5[] = a(abyte3, cipher.doFinal(abyte4));
                int l;
                if (k + 64 > j)
                {
                    l = j - k;
                } else
                {
                    l = 64;
                }
                abyte4 = new byte[l];
                abyte3 = abyte5;
            }
            abyte4[k % 64] = abyte0[k];
            k++;
        }
        return a(abyte3, cipher.doFinal(abyte4));
    }

    private static byte[] a(byte abyte0[], byte abyte1[])
    {
        byte abyte2[] = new byte[abyte0.length + abyte1.length];
        System.arraycopy(abyte0, 0, abyte2, 0, abyte0.length);
        System.arraycopy(abyte1, 0, abyte2, abyte0.length, abyte1.length);
        return abyte2;
    }

    private static String b(String s, String s1)
    {
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        if ("".equals(s.trim()))
        {
            break MISSING_BLOCK_LABEL_113;
        }
        byte abyte0[];
        StringBuffer stringbuffer;
        int i;
        String s2;
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance(s1);
            messagedigest.update(s.getBytes());
            abyte0 = messagedigest.digest();
            stringbuffer = new StringBuffer();
        }
        catch (Exception exception)
        {
            Log.debug("[InMobi]-4.4.1", "Exception in getting ODIN-1", exception);
            return null;
        }
        i = 0;
        if (i >= abyte0.length)
        {
            break; /* Loop/switch isn't completed */
        }
        stringbuffer.append(Integer.toString(256 + (0xff & abyte0[i]), 16).substring(1));
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_50;
_L1:
        s2 = stringbuffer.toString();
        return s2;
        return "TEST_EMULATOR";
    }

    public static String byteToHex(byte byte0)
    {
        String s;
        try
        {
            char ac[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
                'a', 'b', 'c', 'd', 'e', 'f'
            };
            char ac1[] = new char[2];
            ac1[0] = ac[0xf & byte0 >> 4];
            ac1[1] = ac[byte0 & 0xf];
            s = new String(ac1);
        }
        catch (Exception exception)
        {
            return null;
        }
        return s;
    }

    public static String encryptRSA(String s)
    {
        if (s == null || "".equals(s))
        {
            return null;
        }
        String s1;
        try
        {
            BigInteger biginteger = new BigInteger("C10F7968CFE2C76AC6F0650C877806D4514DE58FC239592D2385BCE5609A84B2A0FBDAF29B05505EAD1FDFEF3D7209ACBF34B5D0A806DF18147EA9C0337D6B5B", 16);
            BigInteger biginteger1 = new BigInteger("010001", 16);
            RSAPublicKey rsapublickey = (RSAPublicKey)KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(biginteger, biginteger1));
            Cipher cipher = Cipher.getInstance("RSA/ECB/nopadding");
            cipher.init(1, rsapublickey);
            s1 = new String(Base64.encode(a(s.getBytes("UTF-8"), 1, cipher), 0));
        }
        catch (Exception exception)
        {
            Log.debug("[InMobi]-4.4.1", "Exception in encryptRSA", exception);
            return null;
        }
        return s1;
    }

    public static AdvertisingId getAdvertisingId()
    {
        return c;
    }

    public static String getAppId()
    {
        return b;
    }

    public static String getFBId(Context context)
    {
        String s;
        Cursor cursor;
        int i;
        try
        {
            String as[] = {
                "aid"
            };
            cursor = context.getContentResolver().query(a, as, null, null, null);
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.4.1", (new StringBuilder("Unable to retrieve Facebook attrib id: ")).append(exception).toString());
            return null;
        }
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        if (!cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_100;
        }
        s = cursor.getString(cursor.getColumnIndex("aid"));
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        i = s.length();
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        return null;
        s = null;
        return s;
    }

    public static String getODIN1(String s)
    {
        return b(s, "SHA-1");
    }

    public static String getPlatformId()
    {
        String s;
        try
        {
            Class aclass[] = {
                android/content/Context
            };
            Method method = Class.forName("com.inmobi.commons.uid.PlatformId").getDeclaredMethod("getAndroidId", aclass);
            Object aobj[] = new Object[1];
            aobj[0] = InternalSDKUtil.getContext();
            s = (String)method.invoke(null, aobj);
        }
        catch (Exception exception)
        {
            return null;
        }
        return s;
    }

    public static String getRSAKeyVersion()
    {
        return "1";
    }

    public static String getUM5(String s)
    {
        return b(s, "MD5");
    }

    public static void setAdvertisingId()
    {
        AdvertisingId advertisingid = new AdvertisingId();
        c = advertisingid;
        advertisingid.a(FileOperations.getPreferences(InternalSDKUtil.getContext(), "impref", "gpid"));
        c.a(FileOperations.getBooleanPreferences(InternalSDKUtil.getContext(), "impref", "limitadtrck"));
        (new Thread(new a())).start();
    }

    public static void setAppId(String s)
    {
        b = s;
    }


    private class a
        implements Runnable
    {

        public final void run()
        {
            try
            {
                Class class1 = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
                Class class2 = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
                Method method = class1.getDeclaredMethod("getAdvertisingIdInfo", new Class[] {
                    android/content/Context
                });
                Object aobj[] = new Object[1];
                aobj[0] = InternalSDKUtil.getContext();
                Object obj = method.invoke(null, aobj);
                String s = (String)class2.getDeclaredMethod("getId", null).invoke(obj, null);
                UIDHelper.a().a(s);
                FileOperations.setPreferences(InternalSDKUtil.getContext(), "impref", "gpid", s);
                Boolean boolean1 = (Boolean)class2.getDeclaredMethod("isLimitAdTrackingEnabled", null).invoke(obj, null);
                UIDHelper.a().a(boolean1.booleanValue());
                FileOperations.setPreferences(InternalSDKUtil.getContext(), "impref", "limitadtrck", boolean1.booleanValue());
                return;
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-4.4.1", "Exception getting advertiser id", exception);
            }
        }

        a()
        {
        }
    }

}
