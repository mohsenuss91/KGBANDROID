// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view.a;

import android.graphics.Rect;

// Referenced classes of package android.support.v4.view.a:
//            f, e, d, b, 
//            g, c

public final class a
{

    private static final c a;
    private final Object b;

    public a(Object obj)
    {
        b = obj;
    }

    public final Object a()
    {
        return b;
    }

    public final void a(int i)
    {
        a.a(b, i);
    }

    public final void a(CharSequence charsequence)
    {
        a.a(b, charsequence);
    }

    public final void a(boolean flag)
    {
        a.a(b, flag);
    }

    public final void b()
    {
        a.p(b);
    }

    public final boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        a a1;
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        a1 = (a)obj;
        if (b != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (a1.b == null) goto _L1; else goto _L3
_L3:
        return false;
        if (b.equals(a1.b)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public final int hashCode()
    {
        if (b == null)
        {
            return 0;
        } else
        {
            return b.hashCode();
        }
    }

    public final String toString()
    {
        StringBuilder stringbuilder;
        int i;
        stringbuilder = new StringBuilder();
        stringbuilder.append(super.toString());
        Rect rect = new Rect();
        a.a(b, rect);
        stringbuilder.append((new StringBuilder("; boundsInParent: ")).append(rect).toString());
        a.b(b, rect);
        stringbuilder.append((new StringBuilder("; boundsInScreen: ")).append(rect).toString());
        stringbuilder.append("; packageName: ").append(a.d(b));
        stringbuilder.append("; className: ").append(a.b(b));
        stringbuilder.append("; text: ").append(a.e(b));
        stringbuilder.append("; contentDescription: ").append(a.c(b));
        stringbuilder.append("; viewId: ").append(a.q(b));
        stringbuilder.append("; checkable: ").append(a.f(b));
        stringbuilder.append("; checked: ").append(a.g(b));
        stringbuilder.append("; focusable: ").append(a.j(b));
        stringbuilder.append("; focused: ").append(a.k(b));
        stringbuilder.append("; selected: ").append(a.o(b));
        stringbuilder.append("; clickable: ").append(a.h(b));
        stringbuilder.append("; longClickable: ").append(a.l(b));
        stringbuilder.append("; enabled: ").append(a.i(b));
        stringbuilder.append("; password: ").append(a.m(b));
        stringbuilder.append((new StringBuilder("; scrollable: ")).append(a.n(b)).toString());
        stringbuilder.append("; [");
        i = a.a(b);
_L21:
        int j;
        int k;
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_788;
        }
        j = 1 << Integer.numberOfTrailingZeros(i);
        k = i & ~j;
        j;
        JVM INSTR lookupswitch 18: default 632
    //                   1: 662
    //                   2: 669
    //                   4: 676
    //                   8: 683
    //                   16: 690
    //                   32: 697
    //                   64: 704
    //                   128: 711
    //                   256: 718
    //                   512: 725
    //                   1024: 732
    //                   2048: 739
    //                   4096: 746
    //                   8192: 753
    //                   16384: 767
    //                   32768: 774
    //                   65536: 760
    //                   131072: 781;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19
_L19:
        break MISSING_BLOCK_LABEL_781;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        String s = "ACTION_UNKNOWN";
_L22:
        stringbuilder.append(s);
        if (k != 0)
        {
            stringbuilder.append(", ");
        }
        i = k;
        if (true) goto _L21; else goto _L20
_L20:
        s = "ACTION_FOCUS";
          goto _L22
_L3:
        s = "ACTION_CLEAR_FOCUS";
          goto _L22
_L4:
        s = "ACTION_SELECT";
          goto _L22
_L5:
        s = "ACTION_CLEAR_SELECTION";
          goto _L22
_L6:
        s = "ACTION_CLICK";
          goto _L22
_L7:
        s = "ACTION_LONG_CLICK";
          goto _L22
_L8:
        s = "ACTION_ACCESSIBILITY_FOCUS";
          goto _L22
_L9:
        s = "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
          goto _L22
_L10:
        s = "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
          goto _L22
_L11:
        s = "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
          goto _L22
_L12:
        s = "ACTION_NEXT_HTML_ELEMENT";
          goto _L22
_L13:
        s = "ACTION_PREVIOUS_HTML_ELEMENT";
          goto _L22
_L14:
        s = "ACTION_SCROLL_FORWARD";
          goto _L22
_L15:
        s = "ACTION_SCROLL_BACKWARD";
          goto _L22
_L18:
        s = "ACTION_CUT";
          goto _L22
_L16:
        s = "ACTION_COPY";
          goto _L22
_L17:
        s = "ACTION_PASTE";
          goto _L22
        s = "ACTION_SET_SELECTION";
          goto _L22
        stringbuilder.append("]");
        return stringbuilder.toString();
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            a = new f();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 18)
        {
            a = new e();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            a = new d();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            a = new b();
        } else
        {
            a = new g();
        }
    }
}
