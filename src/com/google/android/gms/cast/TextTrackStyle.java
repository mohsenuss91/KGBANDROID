// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import com.google.android.gms.internal.gj;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.io;
import com.google.android.gms.internal.iq;
import org.json.JSONException;
import org.json.JSONObject;

public final class TextTrackStyle
{

    public static final int COLOR_UNSPECIFIED = 0;
    public static final float DEFAULT_FONT_SCALE = 1F;
    public static final int EDGE_TYPE_DEPRESSED = 4;
    public static final int EDGE_TYPE_DROP_SHADOW = 2;
    public static final int EDGE_TYPE_NONE = 0;
    public static final int EDGE_TYPE_OUTLINE = 1;
    public static final int EDGE_TYPE_RAISED = 3;
    public static final int EDGE_TYPE_UNSPECIFIED = -1;
    public static final int FONT_FAMILY_CASUAL = 4;
    public static final int FONT_FAMILY_CURSIVE = 5;
    public static final int FONT_FAMILY_MONOSPACED_SANS_SERIF = 1;
    public static final int FONT_FAMILY_MONOSPACED_SERIF = 3;
    public static final int FONT_FAMILY_SANS_SERIF = 0;
    public static final int FONT_FAMILY_SERIF = 2;
    public static final int FONT_FAMILY_SMALL_CAPITALS = 6;
    public static final int FONT_FAMILY_UNSPECIFIED = -1;
    public static final int FONT_STYLE_BOLD = 1;
    public static final int FONT_STYLE_BOLD_ITALIC = 3;
    public static final int FONT_STYLE_ITALIC = 2;
    public static final int FONT_STYLE_NORMAL = 0;
    public static final int FONT_STYLE_UNSPECIFIED = -1;
    public static final int WINDOW_TYPE_NONE = 0;
    public static final int WINDOW_TYPE_NORMAL = 1;
    public static final int WINDOW_TYPE_ROUNDED = 2;
    public static final int WINDOW_TYPE_UNSPECIFIED = -1;
    private JSONObject Ax;
    private float Bp;
    private int Bq;
    private int Br;
    private int Bs;
    private int Bt;
    private int Bu;
    private int Bv;
    private String Bw;
    private int Bx;
    private int By;
    private int ta;

    public TextTrackStyle()
    {
        clear();
    }

    private int ah(String s)
    {
        int i = 0;
        if (s != null)
        {
            int j = s.length();
            i = 0;
            if (j == 9)
            {
                char c = s.charAt(0);
                i = 0;
                if (c == '#')
                {
                    int j1;
                    try
                    {
                        int k = Integer.parseInt(s.substring(1, 3), 16);
                        int l = Integer.parseInt(s.substring(3, 5), 16);
                        int i1 = Integer.parseInt(s.substring(5, 7), 16);
                        j1 = Color.argb(Integer.parseInt(s.substring(7, 9), 16), k, l, i1);
                    }
                    catch (NumberFormatException numberformatexception)
                    {
                        return 0;
                    }
                    i = j1;
                }
            }
        }
        return i;
    }

    private void clear()
    {
        Bp = 1.0F;
        Bq = 0;
        ta = 0;
        Br = -1;
        Bs = 0;
        Bt = -1;
        Bu = 0;
        Bv = 0;
        Bw = null;
        Bx = -1;
        By = -1;
        Ax = null;
    }

    public static TextTrackStyle fromSystemSettings(Context context)
    {
        TextTrackStyle texttrackstyle;
        android.view.accessibility.CaptioningManager.CaptionStyle captionstyle;
        texttrackstyle = new TextTrackStyle();
        if (!iq.gd())
        {
            return texttrackstyle;
        }
        CaptioningManager captioningmanager = (CaptioningManager)context.getSystemService("captioning");
        texttrackstyle.Bp = captioningmanager.getFontScale();
        captionstyle = captioningmanager.getUserStyle();
        texttrackstyle.ta = captionstyle.backgroundColor;
        texttrackstyle.Bq = captionstyle.foregroundColor;
        captionstyle.edgeType;
        JVM INSTR tableswitch 1 2: default 80
    //                   1 151
    //                   2 159;
           goto _L1 _L2 _L3
_L3:
        break MISSING_BLOCK_LABEL_159;
_L1:
        texttrackstyle.setEdgeType(0);
_L4:
        texttrackstyle.Bs = captionstyle.edgeColor;
        Typeface typeface = captionstyle.getTypeface();
        if (typeface != null)
        {
            boolean flag;
            boolean flag1;
            if (Typeface.MONOSPACE.equals(typeface))
            {
                texttrackstyle.setFontGenericFamily(1);
            } else
            if (!Typeface.SANS_SERIF.equals(typeface) && Typeface.SERIF.equals(typeface))
            {
                texttrackstyle.setFontGenericFamily(2);
            } else
            {
                texttrackstyle.setFontGenericFamily(0);
            }
            flag = typeface.isBold();
            flag1 = typeface.isItalic();
            if (flag && flag1)
            {
                texttrackstyle.setFontStyle(3);
            } else
            if (flag)
            {
                texttrackstyle.setFontStyle(1);
            } else
            if (flag1)
            {
                texttrackstyle.setFontStyle(2);
            } else
            {
                texttrackstyle.setFontStyle(0);
            }
        }
        return texttrackstyle;
_L2:
        texttrackstyle.setEdgeType(1);
          goto _L4
        texttrackstyle.setEdgeType(2);
          goto _L4
    }

    private String o(int i)
    {
        Object aobj[] = new Object[4];
        aobj[0] = Integer.valueOf(Color.red(i));
        aobj[1] = Integer.valueOf(Color.green(i));
        aobj[2] = Integer.valueOf(Color.blue(i));
        aobj[3] = Integer.valueOf(Color.alpha(i));
        return String.format("#%02X%02X%02X%02X", aobj);
    }

    public final void b(JSONObject jsonobject)
    {
        clear();
        Bp = (float)jsonobject.optDouble("fontScale", 1.0D);
        Bq = ah(jsonobject.optString("foregroundColor"));
        ta = ah(jsonobject.optString("backgroundColor"));
        if (jsonobject.has("edgeType"))
        {
            String s3 = jsonobject.getString("edgeType");
            if ("NONE".equals(s3))
            {
                Br = 0;
            } else
            if ("OUTLINE".equals(s3))
            {
                Br = 1;
            } else
            if ("DROP_SHADOW".equals(s3))
            {
                Br = 2;
            } else
            if ("RAISED".equals(s3))
            {
                Br = 3;
            } else
            if ("DEPRESSED".equals(s3))
            {
                Br = 4;
            }
        }
        Bs = ah(jsonobject.optString("edgeColor"));
        if (jsonobject.has("windowType"))
        {
            String s2 = jsonobject.getString("windowType");
            if ("NONE".equals(s2))
            {
                Bt = 0;
            } else
            if ("NORMAL".equals(s2))
            {
                Bt = 1;
            } else
            if ("ROUNDED_CORNERS".equals(s2))
            {
                Bt = 2;
            }
        }
        Bu = ah(jsonobject.optString("windowColor"));
        if (Bt == 2)
        {
            Bv = jsonobject.optInt("windowRoundedCornerRadius", 0);
        }
        Bw = jsonobject.optString("fontFamily", null);
        if (jsonobject.has("fontGenericFamily"))
        {
            String s1 = jsonobject.getString("fontGenericFamily");
            if ("SANS_SERIF".equals(s1))
            {
                Bx = 0;
            } else
            if ("MONOSPACED_SANS_SERIF".equals(s1))
            {
                Bx = 1;
            } else
            if ("SERIF".equals(s1))
            {
                Bx = 2;
            } else
            if ("MONOSPACED_SERIF".equals(s1))
            {
                Bx = 3;
            } else
            if ("CASUAL".equals(s1))
            {
                Bx = 4;
            } else
            if ("CURSIVE".equals(s1))
            {
                Bx = 5;
            } else
            if ("SMALL_CAPITALS".equals(s1))
            {
                Bx = 6;
            }
        }
        if (jsonobject.has("fontStyle"))
        {
            String s = jsonobject.getString("fontStyle");
            if ("NORMAL".equals(s))
            {
                By = 0;
            } else
            if ("BOLD".equals(s))
            {
                By = 1;
            } else
            if ("ITALIC".equals(s))
            {
                By = 2;
            } else
            if ("BOLD_ITALIC".equals(s))
            {
                By = 3;
            }
        }
        Ax = jsonobject.optJSONObject("customData");
    }

    public final JSONObject dU()
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("fontScale", Bp);
        if (Bq != 0)
        {
            jsonobject.put("foregroundColor", o(Bq));
        }
        if (ta != 0)
        {
            jsonobject.put("backgroundColor", o(ta));
        }
        Br;
        JVM INSTR tableswitch 0 4: default 104
    //                   0 321
    //                   1 333
    //                   2 346
    //                   3 359
    //                   4 372;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        if (Bs != 0)
        {
            jsonobject.put("edgeColor", o(Bs));
        }
        Bt;
        JVM INSTR tableswitch 0 2: default 156
    //                   0 385
    //                   1 397
    //                   2 410;
           goto _L7 _L8 _L9 _L10
_L7:
        if (Bu != 0)
        {
            jsonobject.put("windowColor", o(Bu));
        }
        if (Bt == 2)
        {
            jsonobject.put("windowRoundedCornerRadius", Bv);
        }
        if (Bw != null)
        {
            jsonobject.put("fontFamily", Bw);
        }
        Bx;
        JVM INSTR tableswitch 0 6: default 264
    //                   0 423
    //                   1 437
    //                   2 451
    //                   3 465
    //                   4 479
    //                   5 493
    //                   6 507;
           goto _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18
_L11:
        By;
        JVM INSTR tableswitch 0 3: default 300
    //                   0 521
    //                   1 535
    //                   2 549
    //                   3 563;
           goto _L19 _L20 _L21 _L22 _L23
_L19:
        if (Ax == null) goto _L25; else goto _L24
_L24:
        jsonobject.put("customData", Ax);
        return jsonobject;
_L2:
        try
        {
            jsonobject.put("edgeType", "NONE");
        }
        catch (JSONException jsonexception)
        {
            return jsonobject;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        jsonobject.put("edgeType", "OUTLINE");
        continue; /* Loop/switch isn't completed */
_L4:
        jsonobject.put("edgeType", "DROP_SHADOW");
        continue; /* Loop/switch isn't completed */
_L5:
        jsonobject.put("edgeType", "RAISED");
        continue; /* Loop/switch isn't completed */
_L6:
        jsonobject.put("edgeType", "DEPRESSED");
        continue; /* Loop/switch isn't completed */
_L8:
        jsonobject.put("windowType", "NONE");
          goto _L7
_L9:
        jsonobject.put("windowType", "NORMAL");
          goto _L7
_L10:
        jsonobject.put("windowType", "ROUNDED_CORNERS");
          goto _L7
_L12:
        jsonobject.put("fontGenericFamily", "SANS_SERIF");
          goto _L11
_L13:
        jsonobject.put("fontGenericFamily", "MONOSPACED_SANS_SERIF");
          goto _L11
_L14:
        jsonobject.put("fontGenericFamily", "SERIF");
          goto _L11
_L15:
        jsonobject.put("fontGenericFamily", "MONOSPACED_SERIF");
          goto _L11
_L16:
        jsonobject.put("fontGenericFamily", "CASUAL");
          goto _L11
_L17:
        jsonobject.put("fontGenericFamily", "CURSIVE");
          goto _L11
_L18:
        jsonobject.put("fontGenericFamily", "SMALL_CAPITALS");
          goto _L11
_L20:
        jsonobject.put("fontStyle", "NORMAL");
          goto _L19
_L21:
        jsonobject.put("fontStyle", "BOLD");
          goto _L19
_L22:
        jsonobject.put("fontStyle", "ITALIC");
          goto _L19
_L23:
        jsonobject.put("fontStyle", "BOLD_ITALIC");
          goto _L19
_L25:
        return jsonobject;
        if (true) goto _L1; else goto _L26
_L26:
    }

    public final boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        boolean flag1 = true;
_L4:
        return flag1;
_L2:
        boolean flag = obj instanceof TextTrackStyle;
        flag1 = false;
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        TextTrackStyle texttrackstyle = (TextTrackStyle)obj;
        boolean flag2;
        boolean flag3;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        boolean flag4;
        int j3;
        int k3;
        int l3;
        int i4;
        boolean flag5;
        if (Ax == null)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (texttrackstyle.Ax == null)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        flag1 = false;
        if (flag2 != flag3)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (Ax == null || texttrackstyle.Ax == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag5 = io.d(Ax, texttrackstyle.Ax);
        flag1 = false;
        if (!flag5) goto _L4; else goto _L3
_L3:
        i = Bp != texttrackstyle.Bp;
        flag1 = false;
        if (i == 0)
        {
            j = Bq;
            k = texttrackstyle.Bq;
            flag1 = false;
            if (j == k)
            {
                l = ta;
                i1 = texttrackstyle.ta;
                flag1 = false;
                if (l == i1)
                {
                    j1 = Br;
                    k1 = texttrackstyle.Br;
                    flag1 = false;
                    if (j1 == k1)
                    {
                        l1 = Bs;
                        i2 = texttrackstyle.Bs;
                        flag1 = false;
                        if (l1 == i2)
                        {
                            j2 = Bt;
                            k2 = texttrackstyle.Bt;
                            flag1 = false;
                            if (j2 == k2)
                            {
                                l2 = Bv;
                                i3 = texttrackstyle.Bv;
                                flag1 = false;
                                if (l2 == i3)
                                {
                                    flag4 = gj.a(Bw, texttrackstyle.Bw);
                                    flag1 = false;
                                    if (flag4)
                                    {
                                        j3 = Bx;
                                        k3 = texttrackstyle.Bx;
                                        flag1 = false;
                                        if (j3 == k3)
                                        {
                                            l3 = By;
                                            i4 = texttrackstyle.By;
                                            flag1 = false;
                                            if (l3 == i4)
                                            {
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public final int getBackgroundColor()
    {
        return ta;
    }

    public final JSONObject getCustomData()
    {
        return Ax;
    }

    public final int getEdgeColor()
    {
        return Bs;
    }

    public final int getEdgeType()
    {
        return Br;
    }

    public final String getFontFamily()
    {
        return Bw;
    }

    public final int getFontGenericFamily()
    {
        return Bx;
    }

    public final float getFontScale()
    {
        return Bp;
    }

    public final int getFontStyle()
    {
        return By;
    }

    public final int getForegroundColor()
    {
        return Bq;
    }

    public final int getWindowColor()
    {
        return Bu;
    }

    public final int getWindowCornerRadius()
    {
        return Bv;
    }

    public final int getWindowType()
    {
        return Bt;
    }

    public final int hashCode()
    {
        Object aobj[] = new Object[12];
        aobj[0] = Float.valueOf(Bp);
        aobj[1] = Integer.valueOf(Bq);
        aobj[2] = Integer.valueOf(ta);
        aobj[3] = Integer.valueOf(Br);
        aobj[4] = Integer.valueOf(Bs);
        aobj[5] = Integer.valueOf(Bt);
        aobj[6] = Integer.valueOf(Bu);
        aobj[7] = Integer.valueOf(Bv);
        aobj[8] = Bw;
        aobj[9] = Integer.valueOf(Bx);
        aobj[10] = Integer.valueOf(By);
        aobj[11] = Ax;
        return hl.hashCode(aobj);
    }

    public final void setBackgroundColor(int i)
    {
        ta = i;
    }

    public final void setCustomData(JSONObject jsonobject)
    {
        Ax = jsonobject;
    }

    public final void setEdgeColor(int i)
    {
        Bs = i;
    }

    public final void setEdgeType(int i)
    {
        if (i < 0 || i > 4)
        {
            throw new IllegalArgumentException("invalid edgeType");
        } else
        {
            Br = i;
            return;
        }
    }

    public final void setFontFamily(String s)
    {
        Bw = s;
    }

    public final void setFontGenericFamily(int i)
    {
        if (i < 0 || i > 6)
        {
            throw new IllegalArgumentException("invalid fontGenericFamily");
        } else
        {
            Bx = i;
            return;
        }
    }

    public final void setFontScale(float f)
    {
        Bp = f;
    }

    public final void setFontStyle(int i)
    {
        if (i < 0 || i > 3)
        {
            throw new IllegalArgumentException("invalid fontStyle");
        } else
        {
            By = i;
            return;
        }
    }

    public final void setForegroundColor(int i)
    {
        Bq = i;
    }

    public final void setWindowColor(int i)
    {
        Bu = i;
    }

    public final void setWindowCornerRadius(int i)
    {
        if (i < 0)
        {
            throw new IllegalArgumentException("invalid windowCornerRadius");
        } else
        {
            Bv = i;
            return;
        }
    }

    public final void setWindowType(int i)
    {
        if (i < 0 || i > 2)
        {
            throw new IllegalArgumentException("invalid windowType");
        } else
        {
            Bt = i;
            return;
        }
    }
}
