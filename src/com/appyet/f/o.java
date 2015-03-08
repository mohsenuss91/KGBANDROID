// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.f;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

// Referenced classes of package com.appyet.f:
//            j

public final class o
{

    Cipher a;
    Cipher b;
    byte c[] = {
        -87, -101, -56, 50, 86, 53, -29, 3
    };
    int d;

    public o(String s)
    {
        d = 19;
        try
        {
            PBEKeySpec pbekeyspec = new PBEKeySpec(s.toCharArray(), c, d);
            SecretKey secretkey = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(pbekeyspec);
            a = Cipher.getInstance(secretkey.getAlgorithm());
            b = Cipher.getInstance(secretkey.getAlgorithm());
            PBEParameterSpec pbeparameterspec = new PBEParameterSpec(c, d);
            a.init(1, secretkey, pbeparameterspec);
            b.init(2, secretkey, pbeparameterspec);
            return;
        }
        catch (InvalidAlgorithmParameterException invalidalgorithmparameterexception)
        {
            return;
        }
        catch (InvalidKeySpecException invalidkeyspecexception)
        {
            return;
        }
        catch (NoSuchPaddingException nosuchpaddingexception)
        {
            return;
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            return;
        }
        catch (InvalidKeyException invalidkeyexception)
        {
            return;
        }
    }

    public final String a(String s)
    {
        String s1;
        byte abyte0[] = j.a(s);
        s1 = new String(b.doFinal(abyte0), "UTF8");
        return s1;
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
_L2:
        return null;
        IllegalBlockSizeException illegalblocksizeexception;
        illegalblocksizeexception;
        continue; /* Loop/switch isn't completed */
        BadPaddingException badpaddingexception;
        badpaddingexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final String b(String s)
    {
        String s1;
        byte abyte0[] = s.getBytes("UTF8");
        s1 = j.a(a.doFinal(abyte0));
        return s1;
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
_L2:
        return null;
        IllegalBlockSizeException illegalblocksizeexception;
        illegalblocksizeexception;
        continue; /* Loop/switch isn't completed */
        BadPaddingException badpaddingexception;
        badpaddingexception;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
