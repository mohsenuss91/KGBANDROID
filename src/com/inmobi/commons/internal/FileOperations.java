// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.internal;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

// Referenced classes of package com.inmobi.commons.internal:
//            Log

public class FileOperations
{

    public FileOperations()
    {
    }

    public static boolean getBooleanPreferences(Context context, String s, String s1)
    {
        if (context == null || s == null || s1 == null || "".equals(s.trim()) || "".equals(s1.trim()))
        {
            Log.debug("[InMobi]-4.4.1", "Failed to get preferences..App context NULL");
            return false;
        } else
        {
            return context.getSharedPreferences(s, 0).getBoolean(s1, false);
        }
    }

    public static int getIntPreferences(Context context, String s, String s1)
    {
        if (context == null || s == null || s1 == null || "".equals(s.trim()) || "".equals(s1.trim()))
        {
            Log.debug("[InMobi]-4.4.1", "Failed to get preferences..App context NULL");
            return 0;
        } else
        {
            return context.getSharedPreferences(s, 0).getInt(s1, 0);
        }
    }

    public static long getLongPreferences(Context context, String s, String s1)
    {
        if (context == null || s == null || s1 == null || "".equals(s.trim()) || "".equals(s1.trim()))
        {
            Log.debug("[InMobi]-4.4.1", "Failed to get preferences..App context NULL");
            return 0L;
        } else
        {
            return context.getSharedPreferences(s, 0).getLong(s1, 0L);
        }
    }

    public static String getPreferences(Context context, String s, String s1)
    {
        if (context == null || s == null || s1 == null || "".equals(s.trim()) || "".equals(s1.trim()))
        {
            Log.debug("[InMobi]-4.4.1", "Failed to get preferences..App context NULL");
            return null;
        } else
        {
            return context.getSharedPreferences(s, 0).getString(s1, null);
        }
    }

    public static boolean isFileExist(Context context, String s)
    {
        boolean flag = (new File(context.getDir("data", 0), s)).exists();
        boolean flag1 = false;
        if (flag)
        {
            flag1 = true;
        }
        return flag1;
    }

    public static String readFileAsString(Context context, String s)
    {
        File file = new File((new StringBuilder()).append(context.getCacheDir().getAbsolutePath()).append(File.separator).append(s).toString());
        file.createNewFile();
        BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
        StringBuffer stringbuffer = new StringBuffer();
        do
        {
            String s1 = bufferedreader.readLine();
            if (s1 == null)
            {
                break;
            }
            stringbuffer.append("\n").append(s1);
        } while (true);
        bufferedreader.close();
        if (stringbuffer.length() > 0)
        {
            return stringbuffer.substring(1).toString();
        } else
        {
            return "";
        }
    }

    public static Object readFromFile(Context context, String s)
    {
        Object obj = null;
        if (context != null && s != null && !"".equals(s.trim())) goto _L2; else goto _L1
_L1:
        Log.internal("[InMobi]-4.4.1", "Cannot read map application context or Filename NULL");
_L4:
        return obj;
_L2:
        File file = new File(context.getDir("data", 0), s);
        ObjectInputStream objectinputstream = new ObjectInputStream(new FileInputStream(file));
        Object obj1 = objectinputstream.readObject();
        ObjectInputStream objectinputstream1;
        obj = obj1;
        objectinputstream1 = objectinputstream;
_L5:
        if (objectinputstream1 != null)
        {
            try
            {
                objectinputstream1.close();
            }
            catch (IOException ioexception)
            {
                Log.internal("[InMobi]-4.4.1", "Log File Close Exception");
                return Boolean.valueOf(false);
            }
            return obj;
        }
        if (true) goto _L4; else goto _L3
_L3:
        EOFException eofexception1;
        eofexception1;
        objectinputstream = null;
_L10:
        Log.internal("[InMobi]-4.4.1", "End of File reached");
        objectinputstream1 = objectinputstream;
        obj = null;
          goto _L5
        FileNotFoundException filenotfoundexception1;
        filenotfoundexception1;
        objectinputstream1 = null;
_L9:
        Log.internal("[InMobi]-4.4.1", "Event log File doesnot exist", filenotfoundexception1);
        obj = null;
          goto _L5
        StreamCorruptedException streamcorruptedexception1;
        streamcorruptedexception1;
        objectinputstream1 = null;
_L8:
        Log.internal("[InMobi]-4.4.1", "Event log File corrupted", streamcorruptedexception1);
        obj = null;
          goto _L5
        IOException ioexception2;
        ioexception2;
        objectinputstream1 = null;
_L7:
        Log.internal("[InMobi]-4.4.1", "Event log File IO Exception", ioexception2);
        obj = null;
          goto _L5
        ClassNotFoundException classnotfoundexception1;
        classnotfoundexception1;
        objectinputstream1 = null;
_L6:
        Log.internal("[InMobi]-4.4.1", "Error: class not found", classnotfoundexception1);
        obj = null;
          goto _L5
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        objectinputstream1 = objectinputstream;
        classnotfoundexception1 = classnotfoundexception;
          goto _L6
        IOException ioexception1;
        ioexception1;
        objectinputstream1 = objectinputstream;
        ioexception2 = ioexception1;
          goto _L7
        StreamCorruptedException streamcorruptedexception;
        streamcorruptedexception;
        objectinputstream1 = objectinputstream;
        streamcorruptedexception1 = streamcorruptedexception;
          goto _L8
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        objectinputstream1 = objectinputstream;
        filenotfoundexception1 = filenotfoundexception;
          goto _L9
        EOFException eofexception;
        eofexception;
          goto _L10
    }

    public static boolean saveToFile(Context context, String s, Object obj)
    {
        if (context == null || s == null || "".equals(s.trim()) || obj == null)
        {
            Log.internal("[InMobi]-4.4.1", "Cannot read map application context of Filename NULL");
            return false;
        }
        File file = new File(context.getDir("data", 0), s);
        ObjectOutputStream objectoutputstream;
        try
        {
            objectoutputstream = new ObjectOutputStream(new FileOutputStream(file, false));
            objectoutputstream.writeObject(obj);
            objectoutputstream.flush();
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            Log.internal("[InMobi]-4.4.1", "Log File Not found", filenotfoundexception);
            return false;
        }
        catch (IOException ioexception)
        {
            Log.internal("[InMobi]-4.4.1", "Log File IO Exception", ioexception);
            return false;
        }
        try
        {
            objectoutputstream.close();
        }
        catch (IOException ioexception1)
        {
            Log.internal("[InMobi]-4.4.1", "Log File Close Exception");
            return false;
        }
        return true;
    }

    public static void setPreferences(Context context, String s, String s1, float f)
    {
        if (context == null || s == null || s1 == null || "".equals(s.trim()) || "".equals(s1.trim()))
        {
            Log.debug("[InMobi]-4.4.1", "Failed to set preferences..App context NULL");
            return;
        } else
        {
            android.content.SharedPreferences.Editor editor = context.getSharedPreferences(s, 0).edit();
            editor.putFloat(s1, f);
            editor.commit();
            return;
        }
    }

    public static void setPreferences(Context context, String s, String s1, int i)
    {
        if (context == null || s == null || s1 == null || "".equals(s.trim()) || "".equals(s1.trim()))
        {
            Log.debug("[InMobi]-4.4.1", "Failed to set preferences..App context NULL");
            return;
        } else
        {
            android.content.SharedPreferences.Editor editor = context.getSharedPreferences(s, 0).edit();
            editor.putInt(s1, i);
            editor.commit();
            return;
        }
    }

    public static void setPreferences(Context context, String s, String s1, long l)
    {
        if (context == null || s == null || s1 == null || "".equals(s.trim()) || "".equals(s1.trim()))
        {
            Log.debug("[InMobi]-4.4.1", "Failed to set preferences..App context NULL");
            return;
        } else
        {
            android.content.SharedPreferences.Editor editor = context.getSharedPreferences(s, 0).edit();
            editor.putLong(s1, l);
            editor.commit();
            return;
        }
    }

    public static void setPreferences(Context context, String s, String s1, boolean flag)
    {
        if (context == null || s == null || s1 == null || "".equals(s.trim()) || "".equals(s1.trim()))
        {
            Log.debug("[InMobi]-4.4.1", "Failed to set preferences..App context NULL");
            return;
        } else
        {
            android.content.SharedPreferences.Editor editor = context.getSharedPreferences(s, 0).edit();
            editor.putBoolean(s1, flag);
            editor.commit();
            return;
        }
    }

    public static boolean setPreferences(Context context, String s, String s1, String s2)
    {
        if (context == null || s == null || s1 == null || "".equals(s.trim()) || "".equals(s1.trim()))
        {
            Log.internal("[InMobi]-4.4.1", "Failed to set preferences..App context NULL");
            return false;
        } else
        {
            android.content.SharedPreferences.Editor editor = context.getSharedPreferences(s, 0).edit();
            editor.putString(s1, s2);
            editor.commit();
            return true;
        }
    }

    public static void writeStringToFile(Context context, String s, String s1, boolean flag)
    {
        File file = new File((new StringBuilder()).append(context.getCacheDir().getAbsolutePath()).append(File.separator).append(s).toString());
        file.createNewFile();
        BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file, flag));
        bufferedwriter.write(s1);
        bufferedwriter.close();
    }
}
