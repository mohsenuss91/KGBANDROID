// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import android.net.Uri;
import android.os.Environment;
import android.webkit.MimeTypeMap;
import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.d.e;
import java.io.File;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;

// Referenced classes of package com.appyet.manager:
//            aj, ak, ag, ah, 
//            ai

public final class af
{

    public static String a = "Wzo7Wyv3Pr1wJlF5C";
    static final int b[];
    private String c;
    private String d;
    private ApplicationContext e;

    public af(ApplicationContext applicationcontext)
    {
        c = "";
        d = "";
        e = applicationcontext;
        c = (new StringBuilder()).append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath()).append("/").toString();
        d = e.getPackageName();
    }

    public static String a(File file)
    {
        int i;
        String s;
        String s1;
        try
        {
            i = file.getName().indexOf('_');
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return file.getName();
        }
        s = null;
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        s1 = file.getName().substring(i + 1);
        s = s1;
        return s;
    }

    private static String e(String s)
    {
        String s1;
label0:
        {
            int i = 0;
            String as[] = s.split("[\\\\/]");
            if (as != null)
            {
                int j = as.length;
                System.out.println((new StringBuilder("Path Contents Length: ")).append(j).toString());
                for (int k = 0; k < as.length; k++)
                {
                    System.out.println((new StringBuilder("Path ")).append(k).append(": ").append(as[k]).toString());
                }

                String as1[] = as[j - 1].split("\\.");
                if (as1 != null && as1.length > 1)
                {
                    int l = as1.length;
                    System.out.println((new StringBuilder("Last Part Length: ")).append(l).toString());
                    s1 = "";
                    for (; i < l; i++)
                    {
                        System.out.println((new StringBuilder("Last Part ")).append(i).append(": ").append(as1[i]).toString());
                        if (i < -1 + as1.length)
                        {
                            s1 = (new StringBuilder()).append(s1).append(as1[i]).toString();
                            if (i < l - 2)
                            {
                                s1 = (new StringBuilder()).append(s1).append(".").toString();
                            }
                        }
                    }

                    break label0;
                }
            }
            s1 = "";
        }
        return f(s1);
    }

    private static String f(String s)
    {
        int i;
        StringBuilder stringbuilder;
        String s1;
        char c1;
        try
        {
            stringbuilder = new StringBuilder();
        }
        catch (Exception exception)
        {
            return null;
        }
        i = 0;
_L2:
        if (i < s.length())
        {
            c1 = s.charAt(i);
            if (Arrays.binarySearch(b, c1) < 0)
            {
                stringbuilder.append(c1);
            }
            break MISSING_BLOCK_LABEL_58;
        }
        s1 = stringbuilder.toString();
        return s1;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final String a(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return (new File((new StringBuilder()).append(c).append(d).toString(), s)).getAbsolutePath();
        }
    }

    public final String a(String s, String s1, String s2)
    {
        String s12 = URLEncoder.encode(s1, "UTF-8");
        String s3 = s12;
_L1:
        String s5;
        String s6;
        String s4 = MimeTypeMap.getFileExtensionFromUrl(s3);
        if ((s4 == null || s4.trim().length() == 0) && s2 != null)
        {
            s4 = MimeTypeMap.getSingleton().getExtensionFromMimeType(s2);
        }
        UnsupportedEncodingException unsupportedencodingexception;
        if (s4 == null)
        {
            s5 = "";
        } else
        {
            s5 = (new StringBuilder(".")).append(s4).toString();
        }
        s6 = f(s);
        if (s6 == null || s6.trim().length() <= 0)
        {
            break MISSING_BLOCK_LABEL_212;
        }
        if (!c(s6))
        {
            return (new StringBuilder()).append(s6).append(s5).toString();
        }
        break MISSING_BLOCK_LABEL_144;
        unsupportedencodingexception;
        unsupportedencodingexception.printStackTrace();
        s3 = null;
          goto _L1
        for (int k = 0; k < 100; k++)
        {
            String s11 = (new StringBuilder()).append(s6).append(k).toString();
            if (!c(s11))
            {
                return (new StringBuilder()).append(s11).append(s5).toString();
            }
        }

        String s7 = e(s1);
        if (s7 != null && s7.trim().length() > 0)
        {
            if (!c(s7))
            {
                return (new StringBuilder()).append(s7).append(s5).toString();
            }
            for (int j = 0; j < 100; j++)
            {
                String s10 = (new StringBuilder()).append(s7).append(j).toString();
                if (!c(s10))
                {
                    return (new StringBuilder()).append(s10).append(s5).toString();
                }
            }

        }
        String s8 = (new StringBuilder()).append(f(com.appyet.d.e.a(s1))).append(s5).toString();
        if (s8 != null && s8.trim().length() > 0)
        {
            if (!c(s8))
            {
                return (new StringBuilder()).append(s8).append(s5).toString();
            }
            for (int i = 0; i < 100; i++)
            {
                String s9 = (new StringBuilder()).append(i).append("_").append(s8).toString();
                if (!c(s9))
                {
                    return (new StringBuilder()).append(s9).append(s5).toString();
                }
            }

        }
        return (new StringBuilder()).append(f(UUID.randomUUID().toString())).append(s5).toString();
    }

    public final ArrayList a(ak ak1)
    {
        ArrayList arraylist;
        arraylist = new ArrayList();
        File afile[];
        int i;
        int j;
        File file1;
        Exception exception1;
        try
        {
            File file = new File((new StringBuilder()).append(c).append(d).toString());
            if (!file.isDirectory())
            {
                file.mkdirs();
            }
            afile = file.listFiles();
            i = afile.length;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return arraylist;
        }
        j = 0;
        if (j >= i)
        {
            break; /* Loop/switch isn't completed */
        }
        file1 = afile[j];
        if (file1.isFile())
        {
            arraylist.add(file1);
        }
_L3:
        j++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_66;
        exception1;
        com.appyet.d.d.a(exception1);
          goto _L3
_L1:
        aj.a[ak1.ordinal()];
        JVM INSTR tableswitch 1 3: default 198
    //                   1 156
    //                   2 170
    //                   3 184;
           goto _L4 _L5 _L6 _L7
_L5:
        Collections.sort(arraylist, new ag(this));
        return arraylist;
_L6:
        Collections.sort(arraylist, new ah(this));
        return arraylist;
_L7:
        Collections.sort(arraylist, new ai(this));
        return arraylist;
_L4:
        return arraylist;
    }

    public final boolean a()
    {
        try
        {
            File file = new File((new StringBuilder()).append(c).append(d).toString());
            if (!file.isDirectory())
            {
                file.mkdirs();
            }
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return false;
        }
        return true;
    }

    public final Uri b(String s)
    {
        return Uri.fromFile(new File((new StringBuilder()).append(c).append(d).toString(), s));
    }

    public final boolean c(String s)
    {
        File file;
        if (s != null)
        {
            if ((file = new File((new StringBuilder()).append(c).append(d).toString(), s)).isFile() || file.isDirectory())
            {
                return true;
            }
        }
        return false;
    }

    public final String d(String s)
    {
        String s8 = URLEncoder.encode(s, "UTF-8");
        String s1 = s8;
_L1:
        String s3;
        String s4;
        String s2 = MimeTypeMap.getFileExtensionFromUrl(s1);
        UnsupportedEncodingException unsupportedencodingexception;
        if (s2 == null)
        {
            s3 = "";
        } else
        {
            s3 = (new StringBuilder(".")).append(s2).toString();
        }
        s4 = e(s);
        if (s4 == null || s4.trim().length() <= 0)
        {
            break MISSING_BLOCK_LABEL_178;
        }
        if (!c(s4))
        {
            return (new StringBuilder()).append(s4).append(s3).toString();
        }
        break MISSING_BLOCK_LABEL_110;
        unsupportedencodingexception;
        unsupportedencodingexception.printStackTrace();
        s1 = null;
          goto _L1
        for (int j = 0; j < 100; j++)
        {
            String s7 = (new StringBuilder()).append(s4).append(j).toString();
            if (!c(s7))
            {
                return (new StringBuilder()).append(s7).append(s3).toString();
            }
        }

        String s5 = f(com.appyet.d.e.a(s));
        if (s5 != null && s5.trim().length() > 0)
        {
            if (!c(s5))
            {
                return (new StringBuilder()).append(s5).append(s3).toString();
            }
            for (int i = 0; i < 100; i++)
            {
                String s6 = (new StringBuilder()).append(i).append("_").append(s5).toString();
                if (!c(s6))
                {
                    return (new StringBuilder()).append(s6).append(s3).toString();
                }
            }

        }
        return f(UUID.randomUUID().toString());
    }

    static 
    {
        int ai1[] = {
            34, 60, 62, 124, 0, 1, 2, 3, 4, 5, 
            6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 
            16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 
            26, 27, 28, 29, 30, 31, 58, 42, 63, 92, 
            47
        };
        b = ai1;
        Arrays.sort(ai1);
    }
}
