// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import com.appyet.a.f;
import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.HashMap;

// Referenced classes of package com.appyet.manager:
//            bp, am, bl

public final class al
{

    public static String a = "28g39kNcPYt4p2s3F";
    private String b;
    private String c;
    private String d;
    private String e;
    private ApplicationContext f;
    private int g;
    private long h;
    private long i;
    private am j;

    public al(ApplicationContext applicationcontext)
    {
        d = "";
        e = "";
        f = applicationcontext;
        try
        {
            b = (new StringBuilder()).append(f.getExternalCacheDir().getAbsolutePath()).append("/").toString();
        }
        catch (Exception exception)
        {
            b = (new StringBuilder()).append(f.getCacheDir().getAbsolutePath()).append("/").toString();
        }
        try
        {
            c = (new StringBuilder()).append(f.getCacheDir().getAbsolutePath()).append("/").toString();
        }
        catch (Exception exception1)
        {
            com.appyet.d.d.a(exception1);
        }
        g = f.d.C();
    }

    public final File a()
    {
        return new File((new StringBuilder()).append(d).append(e).toString());
    }

    public final void a(al al1, String s, String s1)
    {
        FileChannel filechannel = null;
        if (!al1.g(s))
        {
            return;
        }
        File file;
        File file1;
        file = new File(al1.b(s));
        file1 = new File(b(s1));
        File file2 = new File((new StringBuilder()).append(d).append(e).toString());
        if (!file2.isDirectory())
        {
            file2.mkdirs();
        }
        FileChannel filechannel4;
        if (!file1.exists())
        {
            file1.createNewFile();
        }
        filechannel4 = (new FileInputStream(file)).getChannel();
        FileChannel filechannel1;
        IOException ioexception;
        FileChannel filechannel2;
        FileChannel filechannel5;
        filechannel1 = filechannel4;
        Exception exception;
        Exception exception1;
        Exception exception2;
        FileChannel filechannel3;
        Exception exception3;
        Exception exception4;
        Exception exception5;
        try
        {
            filechannel5 = (new FileOutputStream(file1)).getChannel();
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            filechannel = filechannel1;
            filechannel2 = null;
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            filechannel = null;
            continue; /* Loop/switch isn't completed */
        }
        filechannel5.transferFrom(filechannel1, 0L, filechannel1.size());
        if (filechannel1 == null)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        filechannel1.close();
        if (filechannel5 != null)
        {
            try
            {
                filechannel5.close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception5)
            {
                try
                {
                    com.appyet.d.d.a(exception5);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception)
                {
                    com.appyet.d.d.a(exception);
                }
            }
            return;
        }
          goto _L1
        ioexception;
        filechannel2 = null;
_L6:
        com.appyet.d.d.a(ioexception);
        if (filechannel == null)
        {
            break MISSING_BLOCK_LABEL_204;
        }
        filechannel.close();
        if (filechannel2 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        filechannel2.close();
        return;
        exception3;
        com.appyet.d.d.a(exception3);
        return;
        exception1;
        filechannel1 = null;
_L5:
        if (filechannel1 == null)
        {
            break MISSING_BLOCK_LABEL_238;
        }
        filechannel1.close();
        if (filechannel == null)
        {
            break MISSING_BLOCK_LABEL_248;
        }
        filechannel.close();
_L3:
        throw exception1;
        exception2;
        com.appyet.d.d.a(exception2);
        if (true) goto _L3; else goto _L2
_L2:
        break MISSING_BLOCK_LABEL_133;
        exception4;
        filechannel = filechannel5;
        exception1 = exception4;
        continue; /* Loop/switch isn't completed */
        exception1;
        filechannel3 = filechannel2;
        filechannel1 = filechannel;
        filechannel = filechannel3;
        if (true) goto _L5; else goto _L4
_L4:
        break MISSING_BLOCK_LABEL_133;
        IOException ioexception1;
        ioexception1;
        filechannel = filechannel1;
        filechannel2 = filechannel5;
        ioexception = ioexception1;
        if (true) goto _L6; else goto _L1
_L1:
    }

    public final void a(am am1)
    {
        if (am1 == am.b)
        {
            d = b;
        } else
        {
            d = c;
        }
        j = am1;
    }

    public final void a(HashMap hashmap)
    {
        h = 0L;
        i = 0L;
        File file = new File((new StringBuilder()).append(d).append(e).toString());
        if (file.exists() && file.isDirectory())
        {
            File afile[] = file.listFiles();
            for (int k = 0; k < afile.length; k++)
            {
                File file1 = afile[k];
                if (file1.isFile() && !hashmap.containsKey(file1.getName()))
                {
                    h = 1L + h;
                    i = i + file1.length();
                    file1.delete();
                }
            }

        }
    }

    public final boolean a(InputStream inputstream, String s)
    {
        FileOutputStream fileoutputstream;
        boolean flag;
        fileoutputstream = null;
        flag = true;
        if (s != null && inputstream != null) goto _L2; else goto _L1
_L1:
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            catch (IOException ioexception)
            {
                com.appyet.d.d.a(ioexception);
            }
        }
        flag = false;
_L4:
        return flag;
_L2:
        File file;
        File file1;
        file = new File((new StringBuilder()).append(d).append(e).toString());
        file1 = new File((new StringBuilder()).append(d).append(e).toString(), s);
        boolean flag1 = file1.isFile();
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_137;
        }
        if (inputstream == null) goto _L4; else goto _L3
_L3:
        try
        {
            inputstream.close();
        }
        catch (IOException ioexception8)
        {
            com.appyet.d.d.a(ioexception8);
            return flag;
        }
        return flag;
        boolean flag2 = Environment.getExternalStorageState().equals("mounted");
        fileoutputstream = null;
        if (!flag2) goto _L6; else goto _L5
_L5:
        FileOutputStream fileoutputstream1;
        file.mkdirs();
        fileoutputstream1 = new FileOutputStream(file1);
        byte abyte0[] = new byte[1024];
_L9:
        int k = inputstream.read(abyte0);
        if (k <= 0) goto _L8; else goto _L7
_L7:
        fileoutputstream1.write(abyte0, 0, k);
          goto _L9
        Exception exception3;
        exception3;
        File file2;
        file2 = file1;
        fileoutputstream = fileoutputstream1;
_L13:
        if (file2 == null)
        {
            break MISSING_BLOCK_LABEL_232;
        }
        if (file2.exists())
        {
            file2.delete();
        }
_L10:
        Exception exception1;
        Exception exception2;
        IOException ioexception5;
        IOException ioexception6;
        IOException ioexception7;
        if (fileoutputstream != null)
        {
            try
            {
                fileoutputstream.close();
            }
            catch (IOException ioexception2)
            {
                com.appyet.d.d.a(ioexception2);
            }
        }
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            catch (IOException ioexception1)
            {
                com.appyet.d.d.a(ioexception1);
            }
        }
        return false;
_L8:
        try
        {
            fileoutputstream1.close();
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception5)
        {
            com.appyet.d.d.a(ioexception5);
        }
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception6)
            {
                com.appyet.d.d.a(ioexception6);
                return flag;
            }
            return flag;
        }
          goto _L4
_L6:
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception7)
            {
                com.appyet.d.d.a(ioexception7);
            }
        }
        return false;
        exception2;
        com.appyet.d.d.a(exception2);
          goto _L10
        exception1;
_L12:
        if (fileoutputstream != null)
        {
            try
            {
                fileoutputstream.close();
            }
            catch (IOException ioexception4)
            {
                com.appyet.d.d.a(ioexception4);
            }
        }
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            catch (IOException ioexception3)
            {
                com.appyet.d.d.a(ioexception3);
            }
        }
        throw exception1;
        exception1;
        fileoutputstream = fileoutputstream1;
        if (true) goto _L12; else goto _L11
_L11:
        Exception exception4;
        exception4;
        file2 = null;
        fileoutputstream = null;
          goto _L13
        Exception exception;
        exception;
        file2 = file1;
        fileoutputstream = null;
          goto _L13
    }

    public final boolean a(String s)
    {
        File file;
        if (s != null)
        {
            if ((file = new File((new StringBuilder()).append(d).append(e).toString(), s)).isFile())
            {
                file.delete();
                return true;
            }
        }
        return false;
    }

    public final boolean a(String s, int k)
    {
        if (g(s))
        {
            f.getResources();
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(b(s), options);
            int l = options.outWidth;
            if (options.outHeight > k || l > k)
            {
                return true;
            }
        }
        return false;
    }

    public final boolean a(String s, String s1)
    {
        f f1;
        f1 = null;
        if (s == null || s1 == null)
        {
            bl.b(null);
            return false;
        }
        File file;
        FileOutputStream fileoutputstream;
        InputStream inputstream;
        InputStream inputstream1;
        File file1;
        URL url;
        f f2;
        Exception exception;
        Exception exception1;
        Exception exception2;
        Exception exception3;
        FileOutputStream fileoutputstream1;
        Exception exception4;
        Exception exception5;
        f f3;
        boolean flag;
        IOException ioexception3;
        byte abyte0[];
        int k;
        Exception exception6;
        Exception exception7;
        try
        {
            url = new URL(s);
            (new File((new StringBuilder()).append(d).append(e).toString())).mkdirs();
            file1 = new File((new StringBuilder()).append(d).append(e).toString(), s1);
        }
        catch (IOException ioexception)
        {
            f2 = null;
            file = null;
            fileoutputstream = null;
            inputstream = null;
            continue; /* Loop/switch isn't completed */
        }
        try
        {
_L4:
            com.appyet.a.d d1 = new com.appyet.a.d();
            d1.a = url.toString();
            f3 = f.g.a(d1);
        }
        catch (IOException ioexception1)
        {
            file = file1;
            f2 = null;
            fileoutputstream = null;
            inputstream = null;
            continue; /* Loop/switch isn't completed */
        }
        f2 = f3;
        try
        {
            f.g;
            flag = bl.a(f2);
        }
        catch (IOException ioexception2)
        {
            file = file1;
            fileoutputstream = null;
            inputstream = null;
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            f1 = f2;
            fileoutputstream1 = null;
            inputstream1 = null;
            continue; /* Loop/switch isn't completed */
        }
        if (!flag)
        {
            bl.b(f2);
            return false;
        }
        inputstream1 = f2.b;
        fileoutputstream1 = new FileOutputStream(file1);
        abyte0 = new byte[8192];
_L3:
        k = inputstream1.read(abyte0);
        if (k <= 0) goto _L2; else goto _L1
_L1:
        fileoutputstream1.write(abyte0, 0, k);
          goto _L3
        ioexception3;
        file = file1;
        fileoutputstream = fileoutputstream1;
        inputstream = inputstream1;
_L7:
        try
        {
            if (file.isFile())
            {
                file.delete();
            }
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception) { }
        finally
        {
            f1 = f2;
        }
        if (fileoutputstream != null)
        {
            try
            {
                fileoutputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception2) { }
        }
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception1) { }
        }
        bl.b(f2);
        return false;
_L2:
        try
        {
            fileoutputstream1.close();
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception6) { }
        if (inputstream1 != null)
        {
            try
            {
                inputstream1.close();
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception7) { }
        }
        bl.b(f2);
        return true;
        exception3;
        fileoutputstream1 = null;
        inputstream1 = null;
_L5:
        if (fileoutputstream1 != null)
        {
            try
            {
                fileoutputstream1.close();
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception5) { }
        }
        if (inputstream1 != null)
        {
            try
            {
                inputstream1.close();
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception4) { }
        }
        bl.b(f1);
        throw exception3;
        exception3;
        f1 = f2;
        fileoutputstream1 = null;
        continue; /* Loop/switch isn't completed */
        exception3;
        f1 = f2;
        continue; /* Loop/switch isn't completed */
        inputstream1 = inputstream;
        fileoutputstream1 = fileoutputstream;
        if (true) goto _L5; else goto _L4
        IOException ioexception4;
        ioexception4;
        inputstream = inputstream1;
        file = file1;
        fileoutputstream = null;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public final long b()
    {
        return i;
    }

    public final String b(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return (new File((new StringBuilder()).append(d).append(e).toString(), s)).getAbsolutePath();
        }
    }

    public final String b(String s, String s1)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        File file;
        return null;
_L2:
        if (!(file = new File((new StringBuilder()).append(d).append(e).toString(), s)).canRead() || !file.isFile()) goto _L1; else goto _L3
_L3:
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(new FileInputStream(file), s1));
        StringBuilder stringbuilder = new StringBuilder();
_L6:
        String s2 = bufferedreader.readLine();
        if (s2 == null) goto _L5; else goto _L4
_L4:
        stringbuilder.append(s2);
          goto _L6
        Exception exception;
        exception;
_L8:
        com.appyet.d.d.a(exception);
        if (bufferedreader == null) goto _L1; else goto _L7
_L7:
        try
        {
            bufferedreader.close();
        }
        catch (IOException ioexception)
        {
            com.appyet.d.d.a(exception);
            return null;
        }
        return null;
_L5:
        String s3;
        bufferedreader.close();
        s3 = stringbuilder.toString();
        return s3;
        exception;
        bufferedreader = null;
          goto _L8
    }

    public final long c()
    {
        return h;
    }

    public final long c(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        File file;
        return -1L;
_L2:
        if (!(file = new File((new StringBuilder()).append(d).append(e).toString(), s)).isFile()) goto _L1; else goto _L3
_L3:
        long l = file.lastModified();
        return l;
        Exception exception;
        exception;
        return -1L;
    }

    public final Uri d(String s)
    {
        return Uri.fromFile(new File((new StringBuilder()).append(d).append(e).toString(), s));
    }

    public final android.graphics.BitmapFactory.Options e(String s)
    {
        android.graphics.BitmapFactory.Options options;
        File file = new File((new StringBuilder()).append(d).append(e).toString(), s);
        if (!file.isFile())
        {
            break MISSING_BLOCK_LABEL_117;
        }
        options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inDither = false;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inScaled = false;
        options.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        return options;
        Exception exception;
        exception;
        return null;
        OutOfMemoryError outofmemoryerror;
        outofmemoryerror;
        f;
        ApplicationContext.d();
        com.appyet.d.d.a(outofmemoryerror);
        return null;
    }

    public final InputStream f(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        File file;
        return null;
_L2:
        if (!(file = new File((new StringBuilder()).append(d).append(e).toString(), s)).canRead() || !file.isFile()) goto _L1; else goto _L3
_L3:
        FileInputStream fileinputstream = new FileInputStream(file);
        return fileinputstream;
        Exception exception;
        exception;
        return null;
    }

    public final boolean g(String s)
    {
        File file;
        if (s != null)
        {
            if ((file = new File((new StringBuilder()).append(d).append(e).toString(), s)).isFile() || file.isDirectory())
            {
                return true;
            }
        }
        return false;
    }

    public final void h(String s)
    {
        e = s;
    }

}
