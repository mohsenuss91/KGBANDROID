// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hn;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.android.gms.common.data:
//            f

public final class DataHolder
    implements SafeParcelable
{

    public static final f CREATOR = new f();
    private static final a EL = new _cls1(new String[0], null);
    private final int CQ;
    private final String ED[];
    Bundle EE;
    private final CursorWindow EF[];
    private final Bundle EG;
    int EH[];
    int EI;
    private Object EJ;
    private boolean EK;
    boolean mClosed;
    private final int xJ;

    DataHolder(int i, String as[], CursorWindow acursorwindow[], int j, Bundle bundle)
    {
        mClosed = false;
        EK = true;
        xJ = i;
        ED = as;
        EF = acursorwindow;
        CQ = j;
        EG = bundle;
    }

    private DataHolder(a a1, int i, Bundle bundle)
    {
        this(a.a(a1), a(a1, -1), i, bundle);
    }

    public DataHolder(String as[], CursorWindow acursorwindow[], int i, Bundle bundle)
    {
        mClosed = false;
        EK = true;
        xJ = 1;
        ED = (String[])hn.f(as);
        EF = (CursorWindow[])hn.f(acursorwindow);
        CQ = i;
        EG = bundle;
        eR();
    }

    public static DataHolder a(int i, Bundle bundle)
    {
        return new DataHolder(EL, i, bundle);
    }

    private static CursorWindow[] a(a a1, int i)
    {
        int j;
        Object obj;
        CursorWindow cursorwindow;
        ArrayList arraylist;
        int l;
        boolean flag;
        j = 0;
        if (a.a(a1).length == 0)
        {
            return new CursorWindow[0];
        }
        int k;
        CursorWindow acursorwindow[];
        if (i < 0 || i >= a.b(a1).size())
        {
            obj = a.b(a1);
        } else
        {
            obj = a.b(a1).subList(0, i);
        }
        k = ((List) (obj)).size();
        cursorwindow = new CursorWindow(false);
        arraylist = new ArrayList();
        arraylist.add(cursorwindow);
        cursorwindow.setNumColumns(a.a(a1).length);
        l = 0;
        flag = false;
_L3:
        if (l >= k) goto _L2; else goto _L1
_L1:
        if (cursorwindow.allocRow())
        {
            break MISSING_BLOCK_LABEL_723;
        }
        Log.d("DataHolder", (new StringBuilder("Allocating additional cursor window for large data set (row ")).append(l).append(")").toString());
        cursorwindow = new CursorWindow(false);
        cursorwindow.setStartPosition(l);
        cursorwindow.setNumColumns(a.a(a1).length);
        arraylist.add(cursorwindow);
        if (cursorwindow.allocRow())
        {
            break MISSING_BLOCK_LABEL_224;
        }
        Log.e("DataHolder", "Unable to allocate row to hold data.");
        arraylist.remove(cursorwindow);
        acursorwindow = (CursorWindow[])arraylist.toArray(new CursorWindow[arraylist.size()]);
        return acursorwindow;
        int j1 = 0;
_L5:
        Map map = (Map)((List) (obj)).get(l);
        boolean flag1;
        flag1 = true;
        RuntimeException runtimeexception;
        int i1;
        String s;
        Object obj1;
        long l1;
        int i2;
        int j2;
        CursorWindow cursorwindow1;
        int k2;
        CursorWindow cursorwindow2;
        for (int k1 = 0; k1 >= a.a(a1).length || !flag1; k1++)
        {
            break MISSING_BLOCK_LABEL_585;
        }

        s = a.a(a1)[k1];
        obj1 = map.get(s);
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_300;
        }
        flag1 = cursorwindow.putNull(j1, k1);
        break MISSING_BLOCK_LABEL_730;
        if (obj1 instanceof String)
        {
            flag1 = cursorwindow.putString((String)obj1, j1, k1);
            break MISSING_BLOCK_LABEL_730;
        }
        if (obj1 instanceof Long)
        {
            flag1 = cursorwindow.putLong(((Long)obj1).longValue(), j1, k1);
            break MISSING_BLOCK_LABEL_730;
        }
        if (obj1 instanceof Integer)
        {
            flag1 = cursorwindow.putLong(((Integer)obj1).intValue(), j1, k1);
            break MISSING_BLOCK_LABEL_730;
        }
        if (!(obj1 instanceof Boolean))
        {
            break MISSING_BLOCK_LABEL_426;
        }
        if (((Boolean)obj1).booleanValue())
        {
            l1 = 1L;
        } else
        {
            l1 = 0L;
        }
        flag1 = cursorwindow.putLong(l1, j1, k1);
        break MISSING_BLOCK_LABEL_730;
        if (obj1 instanceof byte[])
        {
            flag1 = cursorwindow.putBlob((byte[])(byte[])obj1, j1, k1);
            break MISSING_BLOCK_LABEL_730;
        }
        if (obj1 instanceof Double)
        {
            flag1 = cursorwindow.putDouble(((Double)obj1).doubleValue(), j1, k1);
            break MISSING_BLOCK_LABEL_730;
        }
        if (obj1 instanceof Float)
        {
            flag1 = cursorwindow.putDouble(((Float)obj1).floatValue(), j1, k1);
            break MISSING_BLOCK_LABEL_730;
        }
        throw new IllegalArgumentException((new StringBuilder("Unsupported object for column ")).append(s).append(": ").append(obj1).toString());
        runtimeexception;
        for (i1 = arraylist.size(); j < i1; j++)
        {
            ((CursorWindow)arraylist.get(j)).close();
        }

        break MISSING_BLOCK_LABEL_703;
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_686;
        }
        Log.d("DataHolder", (new StringBuilder("Couldn't populate window data for row ")).append(l).append(" - allocating new window.").toString());
        cursorwindow.freeLastRow();
        cursorwindow2 = new CursorWindow(false);
        cursorwindow2.setNumColumns(a.a(a1).length);
        arraylist.add(cursorwindow2);
        j2 = l - 1;
        cursorwindow1 = cursorwindow2;
        i2 = 0;
_L4:
        k2 = j2 + 1;
        cursorwindow = cursorwindow1;
        l = k2;
        flag = i2;
          goto _L3
        i2 = j1 + 1;
        j2 = l;
        cursorwindow1 = cursorwindow;
          goto _L4
        throw runtimeexception;
          goto _L3
_L2:
        return (CursorWindow[])arraylist.toArray(new CursorWindow[arraylist.size()]);
        j1 = ((flag) ? 1 : 0);
          goto _L5
    }

    public static DataHolder af(int i)
    {
        return a(i, ((Bundle) (null)));
    }

    private void e(String s, int i)
    {
        if (EE == null || !EE.containsKey(s))
        {
            throw new IllegalArgumentException((new StringBuilder("No such column: ")).append(s).toString());
        }
        if (isClosed())
        {
            throw new IllegalArgumentException("Buffer is closed.");
        }
        if (i < 0 || i >= EI)
        {
            throw new CursorIndexOutOfBoundsException(i, EI);
        } else
        {
            return;
        }
    }

    public final long a(String s, int i, int j)
    {
        e(s, i);
        return EF[j].getLong(i, EE.getInt(s));
    }

    public final void a(String s, int i, int j, CharArrayBuffer chararraybuffer)
    {
        e(s, i);
        EF[j].copyStringToBuffer(i, EE.getInt(s), chararraybuffer);
    }

    public final int ae(int i)
    {
        int j = 0;
        boolean flag;
        if (i >= 0 && i < EI)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hn.A(flag);
        do
        {
label0:
            {
                if (j < EH.length)
                {
                    if (i >= EH[j])
                    {
                        break label0;
                    }
                    j--;
                }
                if (j == EH.length)
                {
                    j--;
                }
                return j;
            }
            j++;
        } while (true);
    }

    public final boolean av(String s)
    {
        return EE.containsKey(s);
    }

    public final int b(String s, int i, int j)
    {
        e(s, i);
        return EF[j].getInt(i, EE.getInt(s));
    }

    public final void b(Object obj)
    {
        EJ = obj;
    }

    public final String c(String s, int i, int j)
    {
        e(s, i);
        return EF[j].getString(i, EE.getInt(s));
    }

    public final void close()
    {
        this;
        JVM INSTR monitorenter ;
        if (mClosed) goto _L2; else goto _L1
_L1:
        mClosed = true;
        int i = 0;
_L3:
        if (i >= EF.length)
        {
            break; /* Loop/switch isn't completed */
        }
        EF[i].close();
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final boolean d(String s, int i, int j)
    {
        e(s, i);
        return Long.valueOf(EF[j].getLong(i, EE.getInt(s))).longValue() == 1L;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final float e(String s, int i, int j)
    {
        e(s, i);
        return EF[j].getFloat(i, EE.getInt(s));
    }

    public final Bundle eP()
    {
        return EG;
    }

    public final void eR()
    {
        int i = 0;
        EE = new Bundle();
        for (int j = 0; j < ED.length; j++)
        {
            EE.putInt(ED[j], j);
        }

        EH = new int[EF.length];
        int k = 0;
        for (; i < EF.length; i++)
        {
            EH[i] = k;
            int l = k - EF[i].getStartPosition();
            k += EF[i].getNumRows() - l;
        }

        EI = k;
    }

    final String[] eS()
    {
        return ED;
    }

    final CursorWindow[] eT()
    {
        return EF;
    }

    public final byte[] f(String s, int i, int j)
    {
        e(s, i);
        return EF[j].getBlob(i, EE.getInt(s));
    }

    protected final void finalize()
    {
        if (!EK || EF.length <= 0 || isClosed()) goto _L2; else goto _L1
_L1:
        if (EJ != null) goto _L4; else goto _L3
_L3:
        String s1 = (new StringBuilder("internal object: ")).append(toString()).toString();
_L5:
        Log.e("DataBuffer", (new StringBuilder("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call close() on all DataBuffer extending objects when you are done with them. (")).append(s1).append(")").toString());
        close();
_L2:
        super.finalize();
        return;
_L4:
        String s = EJ.toString();
        s1 = s;
          goto _L5
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public final Uri g(String s, int i, int j)
    {
        String s1 = c(s, i, j);
        if (s1 == null)
        {
            return null;
        } else
        {
            return Uri.parse(s1);
        }
    }

    public final int getCount()
    {
        return EI;
    }

    public final int getStatusCode()
    {
        return CQ;
    }

    final int getVersionCode()
    {
        return xJ;
    }

    public final boolean h(String s, int i, int j)
    {
        e(s, i);
        return EF[j].isNull(i, EE.getInt(s));
    }

    public final boolean isClosed()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mClosed;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.common.data.f.a(this, parcel, i);
    }


    private class a
    {

        private final String ED[];
        private final ArrayList EM;
        private final String EN;
        private final HashMap EO;
        private boolean EP;
        private String EQ;

        static String[] a(a a1)
        {
            return a1.ED;
        }

        static ArrayList b(a a1)
        {
            return a1.EM;
        }

        private a(String as[], String s)
        {
            ED = (String[])hn.f(as);
            EM = new ArrayList();
            EN = s;
            EO = new HashMap();
            EP = false;
            EQ = null;
        }

        a(String as[], String s, _cls1 _pcls1)
        {
            this(as, s);
        }
    }


    private class _cls1 extends a
    {

        _cls1(String as[], String s)
        {
            super(as, s, null);
        }
    }

}
