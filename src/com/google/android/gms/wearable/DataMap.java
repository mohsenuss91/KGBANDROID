// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.lw;
import com.google.android.gms.internal.lx;
import com.google.android.gms.internal.me;
import com.google.android.gms.internal.mf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.android.gms.wearable:
//            Asset

public class DataMap
{

    public static final String TAG = "DataMap";
    private final HashMap alh = new HashMap();

    public DataMap()
    {
    }

    private static void a(Bundle bundle, String s, Object obj)
    {
        if (obj instanceof String)
        {
            bundle.putString(s, (String)obj);
        } else
        {
            if (obj instanceof Integer)
            {
                bundle.putInt(s, ((Integer)obj).intValue());
                return;
            }
            if (obj instanceof Long)
            {
                bundle.putLong(s, ((Long)obj).longValue());
                return;
            }
            if (obj instanceof Double)
            {
                bundle.putDouble(s, ((Double)obj).doubleValue());
                return;
            }
            if (obj instanceof Float)
            {
                bundle.putFloat(s, ((Float)obj).floatValue());
                return;
            }
            if (obj instanceof Boolean)
            {
                bundle.putBoolean(s, ((Boolean)obj).booleanValue());
                return;
            }
            if (obj instanceof Byte)
            {
                bundle.putByte(s, ((Byte)obj).byteValue());
                return;
            }
            if (obj instanceof byte[])
            {
                bundle.putByteArray(s, (byte[])(byte[])obj);
                return;
            }
            if (obj instanceof String[])
            {
                bundle.putStringArray(s, (String[])(String[])obj);
                return;
            }
            if (obj instanceof long[])
            {
                bundle.putLongArray(s, (long[])(long[])obj);
                return;
            }
            if (obj instanceof float[])
            {
                bundle.putFloatArray(s, (float[])(float[])obj);
                return;
            }
            if (obj instanceof Asset)
            {
                bundle.putParcelable(s, (Asset)obj);
                return;
            }
            if (obj instanceof DataMap)
            {
                bundle.putParcelable(s, ((DataMap)obj).toBundle());
                return;
            }
            if (obj instanceof ArrayList)
            {
                ArrayList arraylist;
                switch (c((ArrayList)obj))
                {
                default:
                    return;

                case 0: // '\0'
                    bundle.putStringArrayList(s, (ArrayList)obj);
                    return;

                case 1: // '\001'
                    bundle.putStringArrayList(s, (ArrayList)obj);
                    return;

                case 3: // '\003'
                    bundle.putStringArrayList(s, (ArrayList)obj);
                    return;

                case 2: // '\002'
                    bundle.putIntegerArrayList(s, (ArrayList)obj);
                    return;

                case 4: // '\004'
                    arraylist = new ArrayList();
                    break;
                }
                for (Iterator iterator = ((ArrayList)obj).iterator(); iterator.hasNext(); arraylist.add(((DataMap)iterator.next()).toBundle())) { }
                bundle.putParcelableArrayList(s, arraylist);
                return;
            }
        }
    }

    private static void a(DataMap datamap, String s, Object obj)
    {
        if (obj instanceof String)
        {
            datamap.putString(s, (String)obj);
        } else
        {
            if (obj instanceof Integer)
            {
                datamap.putInt(s, ((Integer)obj).intValue());
                return;
            }
            if (obj instanceof Long)
            {
                datamap.putLong(s, ((Long)obj).longValue());
                return;
            }
            if (obj instanceof Double)
            {
                datamap.putDouble(s, ((Double)obj).doubleValue());
                return;
            }
            if (obj instanceof Float)
            {
                datamap.putFloat(s, ((Float)obj).floatValue());
                return;
            }
            if (obj instanceof Boolean)
            {
                datamap.putBoolean(s, ((Boolean)obj).booleanValue());
                return;
            }
            if (obj instanceof Byte)
            {
                datamap.putByte(s, ((Byte)obj).byteValue());
                return;
            }
            if (obj instanceof byte[])
            {
                datamap.putByteArray(s, (byte[])(byte[])obj);
                return;
            }
            if (obj instanceof String[])
            {
                datamap.putStringArray(s, (String[])(String[])obj);
                return;
            }
            if (obj instanceof long[])
            {
                datamap.putLongArray(s, (long[])(long[])obj);
                return;
            }
            if (obj instanceof float[])
            {
                datamap.putFloatArray(s, (float[])(float[])obj);
                return;
            }
            if (obj instanceof Asset)
            {
                datamap.putAsset(s, (Asset)obj);
                return;
            }
            if (obj instanceof Bundle)
            {
                datamap.putDataMap(s, fromBundle((Bundle)obj));
                return;
            }
            if (obj instanceof ArrayList)
            {
                switch (c((ArrayList)obj))
                {
                case 4: // '\004'
                default:
                    return;

                case 0: // '\0'
                    datamap.putStringArrayList(s, (ArrayList)obj);
                    return;

                case 1: // '\001'
                    datamap.putStringArrayList(s, (ArrayList)obj);
                    return;

                case 3: // '\003'
                    datamap.putStringArrayList(s, (ArrayList)obj);
                    return;

                case 2: // '\002'
                    datamap.putIntegerArrayList(s, (ArrayList)obj);
                    return;

                case 5: // '\005'
                    datamap.putDataMapArrayList(s, arrayListFromBundleArrayList((ArrayList)obj));
                    break;
                }
                return;
            }
        }
    }

    private void a(String s, Object obj, String s1, ClassCastException classcastexception)
    {
        a(s, obj, s1, "<null>", classcastexception);
    }

    private void a(String s, Object obj, String s1, Object obj1, ClassCastException classcastexception)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("Key ");
        stringbuilder.append(s);
        stringbuilder.append(" expected ");
        stringbuilder.append(s1);
        stringbuilder.append(" but value was a ");
        stringbuilder.append(obj.getClass().getName());
        stringbuilder.append(".  The default value ");
        stringbuilder.append(obj1);
        stringbuilder.append(" was returned.");
        Log.w("DataMap", stringbuilder.toString());
        Log.w("DataMap", "Attempt to cast generated internal exception:", classcastexception);
    }

    private static boolean a(Asset asset, Asset asset1)
    {
        if (asset == null || asset1 == null)
        {
            return asset == asset1;
        }
        if (!TextUtils.isEmpty(asset.getDigest()))
        {
            return asset.getDigest().equals(asset1.getDigest());
        } else
        {
            return Arrays.equals(asset.getData(), asset1.getData());
        }
    }

    private static boolean a(DataMap datamap, DataMap datamap1)
    {
        if (datamap.size() != datamap1.size())
        {
            return false;
        }
        for (Iterator iterator = datamap.keySet().iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            Object obj = datamap.get(s);
            Object obj1 = datamap1.get(s);
            if (obj instanceof Asset)
            {
                if (!(obj1 instanceof Asset))
                {
                    return false;
                }
                if (!a((Asset)obj, (Asset)obj1))
                {
                    return false;
                }
            } else
            if (obj instanceof String[])
            {
                if (!(obj1 instanceof String[]))
                {
                    return false;
                }
                if (!Arrays.equals((String[])(String[])obj, (String[])(String[])obj1))
                {
                    return false;
                }
            } else
            if (obj instanceof long[])
            {
                if (!(obj1 instanceof long[]))
                {
                    return false;
                }
                if (!Arrays.equals((long[])(long[])obj, (long[])(long[])obj1))
                {
                    return false;
                }
            } else
            if (obj instanceof float[])
            {
                if (!(obj1 instanceof float[]))
                {
                    return false;
                }
                if (!Arrays.equals((float[])(float[])obj, (float[])(float[])obj1))
                {
                    return false;
                }
            } else
            if (obj instanceof byte[])
            {
                if (!(obj1 instanceof byte[]))
                {
                    return false;
                }
                if (!Arrays.equals((byte[])(byte[])obj, (byte[])(byte[])obj1))
                {
                    return false;
                }
            } else
            {
                if (obj == null || obj1 == null)
                {
                    return obj == obj1;
                }
                if (!obj.equals(obj1))
                {
                    return false;
                }
            }
        }

        return true;
    }

    public static ArrayList arrayListFromBundleArrayList(ArrayList arraylist)
    {
        ArrayList arraylist1 = new ArrayList();
        for (Iterator iterator = arraylist.iterator(); iterator.hasNext(); arraylist1.add(fromBundle((Bundle)iterator.next()))) { }
        return arraylist1;
    }

    private static int c(ArrayList arraylist)
    {
        if (arraylist.isEmpty())
        {
            return 0;
        }
        for (Iterator iterator = arraylist.iterator(); iterator.hasNext();)
        {
            Object obj = iterator.next();
            if (obj != null)
            {
                if (obj instanceof Integer)
                {
                    return 2;
                }
                if (obj instanceof String)
                {
                    return 3;
                }
                if (obj instanceof DataMap)
                {
                    return 4;
                }
                if (obj instanceof Bundle)
                {
                    return 5;
                }
            }
        }

        return 1;
    }

    public static DataMap fromBundle(Bundle bundle)
    {
        bundle.setClassLoader(com/google/android/gms/wearable/Asset.getClassLoader());
        DataMap datamap = new DataMap();
        String s;
        for (Iterator iterator = bundle.keySet().iterator(); iterator.hasNext(); a(datamap, s, bundle.get(s)))
        {
            s = (String)iterator.next();
        }

        return datamap;
    }

    public static DataMap fromByteArray(byte abyte0[])
    {
        DataMap datamap;
        try
        {
            datamap = lw.a(new com.google.android.gms.internal.lw.a(lx.n(abyte0), new ArrayList()));
        }
        catch (me me1)
        {
            throw new IllegalArgumentException("Unable to convert data", me1);
        }
        return datamap;
    }

    public void clear()
    {
        alh.clear();
    }

    public boolean containsKey(String s)
    {
        return alh.containsKey(s);
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof DataMap))
        {
            return false;
        } else
        {
            return a(this, (DataMap)obj);
        }
    }

    public Object get(String s)
    {
        return alh.get(s);
    }

    public Asset getAsset(String s)
    {
        Object obj = alh.get(s);
        if (obj == null)
        {
            return null;
        }
        Asset asset;
        try
        {
            asset = (Asset)obj;
        }
        catch (ClassCastException classcastexception)
        {
            a(s, obj, "Asset", classcastexception);
            return null;
        }
        return asset;
    }

    public boolean getBoolean(String s)
    {
        return getBoolean(s, false);
    }

    public boolean getBoolean(String s, boolean flag)
    {
        Object obj = alh.get(s);
        if (obj == null)
        {
            return flag;
        }
        boolean flag1;
        try
        {
            flag1 = ((Boolean)obj).booleanValue();
        }
        catch (ClassCastException classcastexception)
        {
            a(s, obj, "Boolean", Boolean.valueOf(flag), classcastexception);
            return flag;
        }
        return flag1;
    }

    public byte getByte(String s)
    {
        return getByte(s, (byte)0);
    }

    public byte getByte(String s, byte byte0)
    {
        Object obj = alh.get(s);
        if (obj == null)
        {
            return byte0;
        }
        byte byte1;
        try
        {
            byte1 = ((Byte)obj).byteValue();
        }
        catch (ClassCastException classcastexception)
        {
            a(s, obj, "Byte", Byte.valueOf(byte0), classcastexception);
            return byte0;
        }
        return byte1;
    }

    public byte[] getByteArray(String s)
    {
        Object obj = alh.get(s);
        if (obj == null)
        {
            return null;
        }
        byte abyte0[];
        try
        {
            abyte0 = (byte[])(byte[])obj;
        }
        catch (ClassCastException classcastexception)
        {
            a(s, obj, "byte[]", classcastexception);
            return null;
        }
        return abyte0;
    }

    public DataMap getDataMap(String s)
    {
        Object obj = alh.get(s);
        if (obj == null)
        {
            return null;
        }
        DataMap datamap;
        try
        {
            datamap = (DataMap)obj;
        }
        catch (ClassCastException classcastexception)
        {
            a(s, obj, "DataMap", classcastexception);
            return null;
        }
        return datamap;
    }

    public ArrayList getDataMapArrayList(String s)
    {
        Object obj = alh.get(s);
        if (obj == null)
        {
            return null;
        }
        ArrayList arraylist;
        try
        {
            arraylist = (ArrayList)obj;
        }
        catch (ClassCastException classcastexception)
        {
            a(s, obj, "ArrayList<DataMap>", classcastexception);
            return null;
        }
        return arraylist;
    }

    public double getDouble(String s)
    {
        return getDouble(s, 0.0D);
    }

    public double getDouble(String s, double d)
    {
        Object obj = alh.get(s);
        if (obj == null)
        {
            return d;
        }
        double d1;
        try
        {
            d1 = ((Double)obj).doubleValue();
        }
        catch (ClassCastException classcastexception)
        {
            a(s, obj, "Double", Double.valueOf(d), classcastexception);
            return d;
        }
        return d1;
    }

    public float getFloat(String s)
    {
        return getFloat(s, 0.0F);
    }

    public float getFloat(String s, float f)
    {
        Object obj = alh.get(s);
        if (obj == null)
        {
            return f;
        }
        float f1;
        try
        {
            f1 = ((Float)obj).floatValue();
        }
        catch (ClassCastException classcastexception)
        {
            a(s, obj, "Float", Float.valueOf(f), classcastexception);
            return f;
        }
        return f1;
    }

    public float[] getFloatArray(String s)
    {
        Object obj = alh.get(s);
        if (obj == null)
        {
            return null;
        }
        float af[];
        try
        {
            af = (float[])(float[])obj;
        }
        catch (ClassCastException classcastexception)
        {
            a(s, obj, "float[]", classcastexception);
            return null;
        }
        return af;
    }

    public int getInt(String s)
    {
        return getInt(s, 0);
    }

    public int getInt(String s, int i)
    {
        Object obj = alh.get(s);
        if (obj == null)
        {
            return i;
        }
        int j;
        try
        {
            j = ((Integer)obj).intValue();
        }
        catch (ClassCastException classcastexception)
        {
            a(s, obj, "Integer", classcastexception);
            return i;
        }
        return j;
    }

    public ArrayList getIntegerArrayList(String s)
    {
        Object obj = alh.get(s);
        if (obj == null)
        {
            return null;
        }
        ArrayList arraylist;
        try
        {
            arraylist = (ArrayList)obj;
        }
        catch (ClassCastException classcastexception)
        {
            a(s, obj, "ArrayList<Integer>", classcastexception);
            return null;
        }
        return arraylist;
    }

    public long getLong(String s)
    {
        return getLong(s, 0L);
    }

    public long getLong(String s, long l)
    {
        Object obj = alh.get(s);
        if (obj == null)
        {
            return l;
        }
        long l1;
        try
        {
            l1 = ((Long)obj).longValue();
        }
        catch (ClassCastException classcastexception)
        {
            a(s, obj, "long", classcastexception);
            return l;
        }
        return l1;
    }

    public long[] getLongArray(String s)
    {
        Object obj = alh.get(s);
        if (obj == null)
        {
            return null;
        }
        long al[];
        try
        {
            al = (long[])(long[])obj;
        }
        catch (ClassCastException classcastexception)
        {
            a(s, obj, "long[]", classcastexception);
            return null;
        }
        return al;
    }

    public String getString(String s)
    {
        Object obj = alh.get(s);
        if (obj == null)
        {
            return null;
        }
        String s1;
        try
        {
            s1 = (String)obj;
        }
        catch (ClassCastException classcastexception)
        {
            a(s, obj, "String", classcastexception);
            return null;
        }
        return s1;
    }

    public String getString(String s, String s1)
    {
        String s2 = getString(s);
        if (s2 == null)
        {
            return s1;
        } else
        {
            return s2;
        }
    }

    public String[] getStringArray(String s)
    {
        Object obj = alh.get(s);
        if (obj == null)
        {
            return null;
        }
        String as[];
        try
        {
            as = (String[])(String[])obj;
        }
        catch (ClassCastException classcastexception)
        {
            a(s, obj, "String[]", classcastexception);
            return null;
        }
        return as;
    }

    public ArrayList getStringArrayList(String s)
    {
        Object obj = alh.get(s);
        if (obj == null)
        {
            return null;
        }
        ArrayList arraylist;
        try
        {
            arraylist = (ArrayList)obj;
        }
        catch (ClassCastException classcastexception)
        {
            a(s, obj, "ArrayList<String>", classcastexception);
            return null;
        }
        return arraylist;
    }

    public int hashCode()
    {
        return 29 * alh.hashCode();
    }

    public boolean isEmpty()
    {
        return alh.isEmpty();
    }

    public Set keySet()
    {
        return alh.keySet();
    }

    public void putAll(DataMap datamap)
    {
        String s;
        for (Iterator iterator = datamap.keySet().iterator(); iterator.hasNext(); alh.put(s, datamap.get(s)))
        {
            s = (String)iterator.next();
        }

    }

    public void putAsset(String s, Asset asset)
    {
        alh.put(s, asset);
    }

    public void putBoolean(String s, boolean flag)
    {
        alh.put(s, Boolean.valueOf(flag));
    }

    public void putByte(String s, byte byte0)
    {
        alh.put(s, Byte.valueOf(byte0));
    }

    public void putByteArray(String s, byte abyte0[])
    {
        alh.put(s, abyte0);
    }

    public void putDataMap(String s, DataMap datamap)
    {
        alh.put(s, datamap);
    }

    public void putDataMapArrayList(String s, ArrayList arraylist)
    {
        alh.put(s, arraylist);
    }

    public void putDouble(String s, double d)
    {
        alh.put(s, Double.valueOf(d));
    }

    public void putFloat(String s, float f)
    {
        alh.put(s, Float.valueOf(f));
    }

    public void putFloatArray(String s, float af[])
    {
        alh.put(s, af);
    }

    public void putInt(String s, int i)
    {
        alh.put(s, Integer.valueOf(i));
    }

    public void putIntegerArrayList(String s, ArrayList arraylist)
    {
        alh.put(s, arraylist);
    }

    public void putLong(String s, long l)
    {
        alh.put(s, Long.valueOf(l));
    }

    public void putLongArray(String s, long al[])
    {
        alh.put(s, al);
    }

    public void putString(String s, String s1)
    {
        alh.put(s, s1);
    }

    public void putStringArray(String s, String as[])
    {
        alh.put(s, as);
    }

    public void putStringArrayList(String s, ArrayList arraylist)
    {
        alh.put(s, arraylist);
    }

    public Object remove(String s)
    {
        return alh.remove(s);
    }

    public int size()
    {
        return alh.size();
    }

    public Bundle toBundle()
    {
        Bundle bundle = new Bundle();
        String s;
        for (Iterator iterator = alh.keySet().iterator(); iterator.hasNext(); a(bundle, s, alh.get(s)))
        {
            s = (String)iterator.next();
        }

        return bundle;
    }

    public byte[] toByteArray()
    {
        return mf.d(lw.a(this).amm);
    }

    public String toString()
    {
        return alh.toString();
    }
}
