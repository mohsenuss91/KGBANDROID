// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.internal.gj;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.io;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaTrack
{

    public static final int SUBTYPE_CAPTIONS = 2;
    public static final int SUBTYPE_CHAPTERS = 4;
    public static final int SUBTYPE_DESCRIPTIONS = 3;
    public static final int SUBTYPE_METADATA = 5;
    public static final int SUBTYPE_NONE = 0;
    public static final int SUBTYPE_SUBTITLES = 1;
    public static final int SUBTYPE_UNKNOWN = -1;
    public static final int TYPE_AUDIO = 2;
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_VIDEO = 3;
    private long AP;
    private int AQ;
    private int AR;
    private String Ao;
    private String Aq;
    private String As;
    private JSONObject Ax;
    private String mName;

    MediaTrack(long l, int i)
    {
        clear();
        AP = l;
        if (i <= 0 || i > 3)
        {
            throw new IllegalArgumentException((new StringBuilder("invalid type ")).append(i).toString());
        } else
        {
            AQ = i;
            return;
        }
    }

    MediaTrack(JSONObject jsonobject)
    {
        b(jsonobject);
    }

    private void b(JSONObject jsonobject)
    {
        clear();
        AP = jsonobject.getLong("trackId");
        String s = jsonobject.getString("type");
        if ("TEXT".equals(s))
        {
            AQ = 1;
        } else
        if ("AUDIO".equals(s))
        {
            AQ = 2;
        } else
        if ("VIDEO".equals(s))
        {
            AQ = 3;
        } else
        {
            throw new JSONException((new StringBuilder("invalid type: ")).append(s).toString());
        }
        Aq = jsonobject.optString("trackContentId", null);
        As = jsonobject.optString("trackContentType", null);
        mName = jsonobject.optString("name", null);
        Ao = jsonobject.optString("language", null);
        if (jsonobject.has("subtype"))
        {
            String s1 = jsonobject.getString("subtype");
            if ("SUBTITLES".equals(s1))
            {
                AR = 1;
            } else
            if ("CAPTIONS".equals(s1))
            {
                AR = 2;
            } else
            if ("DESCRIPTIONS".equals(s1))
            {
                AR = 3;
            } else
            if ("CHAPTERS".equals(s1))
            {
                AR = 4;
            } else
            if ("METADATA".equals(s1))
            {
                AR = 5;
            } else
            {
                throw new JSONException((new StringBuilder("invalid subtype: ")).append(s1).toString());
            }
        } else
        {
            AR = 0;
        }
        Ax = jsonobject.optJSONObject("customData");
    }

    private void clear()
    {
        AP = 0L;
        AQ = 0;
        Aq = null;
        mName = null;
        Ao = null;
        AR = -1;
        Ax = null;
    }

    final void R(int i)
    {
        if (i < 0 || i > 5)
        {
            throw new IllegalArgumentException((new StringBuilder("invalid subtype ")).append(i).toString());
        }
        if (i != 0 && AQ != 1)
        {
            throw new IllegalArgumentException("subtypes are only valid for text tracks");
        } else
        {
            AR = i;
            return;
        }
    }

    public final JSONObject dU()
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("trackId", AP);
        AQ;
        JVM INSTR tableswitch 1 3: default 48
    //                   1 180
    //                   2 192
    //                   3 204;
           goto _L1 _L2 _L3 _L4
_L1:
        if (Aq != null)
        {
            jsonobject.put("trackContentId", Aq);
        }
        if (As != null)
        {
            jsonobject.put("trackContentType", As);
        }
        if (mName != null)
        {
            jsonobject.put("name", mName);
        }
        if (!TextUtils.isEmpty(Ao))
        {
            jsonobject.put("language", Ao);
        }
        AR;
        JVM INSTR tableswitch 1 5: default 160
    //                   1 216
    //                   2 228
    //                   3 240
    //                   4 252
    //                   5 264;
           goto _L5 _L6 _L7 _L8 _L9 _L10
_L5:
        if (Ax == null) goto _L12; else goto _L11
_L11:
        jsonobject.put("customData", Ax);
        return jsonobject;
_L2:
        try
        {
            jsonobject.put("type", "TEXT");
        }
        catch (JSONException jsonexception)
        {
            return jsonobject;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        jsonobject.put("type", "AUDIO");
        continue; /* Loop/switch isn't completed */
_L4:
        jsonobject.put("type", "VIDEO");
        continue; /* Loop/switch isn't completed */
_L6:
        jsonobject.put("subtype", "SUBTITLES");
          goto _L5
_L7:
        jsonobject.put("subtype", "CAPTIONS");
          goto _L5
_L8:
        jsonobject.put("subtype", "DESCRIPTIONS");
          goto _L5
_L9:
        jsonobject.put("subtype", "CHAPTERS");
          goto _L5
_L10:
        jsonobject.put("subtype", "METADATA");
          goto _L5
_L12:
        return jsonobject;
        if (true) goto _L1; else goto _L13
_L13:
    }

    public final boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        boolean flag1 = true;
_L4:
        return flag1;
_L2:
        boolean flag = obj instanceof MediaTrack;
        flag1 = false;
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        MediaTrack mediatrack = (MediaTrack)obj;
        boolean flag2;
        boolean flag3;
        int i;
        int j;
        int k;
        boolean flag4;
        boolean flag5;
        boolean flag6;
        boolean flag7;
        int l;
        int i1;
        boolean flag8;
        if (Ax == null)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (mediatrack.Ax == null)
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
        if (Ax == null || mediatrack.Ax == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag8 = io.d(Ax, mediatrack.Ax);
        flag1 = false;
        if (!flag8) goto _L4; else goto _L3
_L3:
        i = AP != mediatrack.AP;
        flag1 = false;
        if (i == 0)
        {
            j = AQ;
            k = mediatrack.AQ;
            flag1 = false;
            if (j == k)
            {
                flag4 = gj.a(Aq, mediatrack.Aq);
                flag1 = false;
                if (flag4)
                {
                    flag5 = gj.a(As, mediatrack.As);
                    flag1 = false;
                    if (flag5)
                    {
                        flag6 = gj.a(mName, mediatrack.mName);
                        flag1 = false;
                        if (flag6)
                        {
                            flag7 = gj.a(Ao, mediatrack.Ao);
                            flag1 = false;
                            if (flag7)
                            {
                                l = AR;
                                i1 = mediatrack.AR;
                                flag1 = false;
                                if (l == i1)
                                {
                                    return true;
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

    public final String getContentId()
    {
        return Aq;
    }

    public final String getContentType()
    {
        return As;
    }

    public final JSONObject getCustomData()
    {
        return Ax;
    }

    public final long getId()
    {
        return AP;
    }

    public final String getLanguage()
    {
        return Ao;
    }

    public final String getName()
    {
        return mName;
    }

    public final int getSubtype()
    {
        return AR;
    }

    public final int getType()
    {
        return AQ;
    }

    public final int hashCode()
    {
        Object aobj[] = new Object[8];
        aobj[0] = Long.valueOf(AP);
        aobj[1] = Integer.valueOf(AQ);
        aobj[2] = Aq;
        aobj[3] = As;
        aobj[4] = mName;
        aobj[5] = Ao;
        aobj[6] = Integer.valueOf(AR);
        aobj[7] = Ax;
        return hl.hashCode(aobj);
    }

    public final void setContentId(String s)
    {
        Aq = s;
    }

    public final void setContentType(String s)
    {
        As = s;
    }

    final void setCustomData(JSONObject jsonobject)
    {
        Ax = jsonobject;
    }

    final void setLanguage(String s)
    {
        Ao = s;
    }

    final void setName(String s)
    {
        mName = s;
    }
}
