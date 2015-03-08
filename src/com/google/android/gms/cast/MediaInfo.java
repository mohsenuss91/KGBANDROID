// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.internal.gj;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.io;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            MediaMetadata, MediaTrack, TextTrackStyle

public final class MediaInfo
{

    public static final int STREAM_TYPE_BUFFERED = 1;
    public static final int STREAM_TYPE_INVALID = -1;
    public static final int STREAM_TYPE_LIVE = 2;
    public static final int STREAM_TYPE_NONE;
    private final String Aq;
    private int Ar;
    private String As;
    private MediaMetadata At;
    private long Au;
    private List Av;
    private TextTrackStyle Aw;
    private JSONObject Ax;

    MediaInfo(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        } else
        {
            Aq = s;
            Ar = -1;
            return;
        }
    }

    MediaInfo(JSONObject jsonobject)
    {
        int i = 0;
        super();
        Aq = jsonobject.getString("contentId");
        String s = jsonobject.getString("streamType");
        if ("NONE".equals(s))
        {
            Ar = 0;
        } else
        if ("BUFFERED".equals(s))
        {
            Ar = 1;
        } else
        if ("LIVE".equals(s))
        {
            Ar = 2;
        } else
        {
            Ar = -1;
        }
        As = jsonobject.getString("contentType");
        if (jsonobject.has("metadata"))
        {
            JSONObject jsonobject2 = jsonobject.getJSONObject("metadata");
            At = new MediaMetadata(jsonobject2.getInt("metadataType"));
            At.b(jsonobject2);
        }
        Au = gj.b(jsonobject.optDouble("duration", 0.0D));
        if (jsonobject.has("tracks"))
        {
            Av = new ArrayList();
            for (JSONArray jsonarray = jsonobject.getJSONArray("tracks"); i < jsonarray.length(); i++)
            {
                MediaTrack mediatrack = new MediaTrack(jsonarray.getJSONObject(i));
                Av.add(mediatrack);
            }

        } else
        {
            Av = null;
        }
        if (jsonobject.has("textTrackStyle"))
        {
            JSONObject jsonobject1 = jsonobject.getJSONObject("textTrackStyle");
            TextTrackStyle texttrackstyle = new TextTrackStyle();
            texttrackstyle.b(jsonobject1);
            Aw = texttrackstyle;
        } else
        {
            Aw = null;
        }
        Ax = jsonobject.optJSONObject("customData");
    }

    final void a(MediaMetadata mediametadata)
    {
        At = mediametadata;
    }

    final void b(List list)
    {
        Av = list;
    }

    final void dT()
    {
        if (TextUtils.isEmpty(Aq))
        {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        }
        if (TextUtils.isEmpty(As))
        {
            throw new IllegalArgumentException("content type cannot be null or empty");
        }
        if (Ar == -1)
        {
            throw new IllegalArgumentException("a valid stream type must be specified");
        } else
        {
            return;
        }
    }

    public final JSONObject dU()
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("contentId", Aq);
        Ar;
        JVM INSTR tableswitch 1 2: default 215
    //                   1 225
    //                   2 232;
           goto _L1 _L2 _L3
_L3:
        break MISSING_BLOCK_LABEL_232;
_L8:
        String s;
        jsonobject.put("streamType", s);
        if (As != null)
        {
            jsonobject.put("contentType", As);
        }
        if (At != null)
        {
            jsonobject.put("metadata", At.dU());
        }
        jsonobject.put("duration", gj.o(Au));
        if (Av == null) goto _L5; else goto _L4
_L4:
        JSONArray jsonarray;
        jsonarray = new JSONArray();
        for (Iterator iterator = Av.iterator(); iterator.hasNext(); jsonarray.put(((MediaTrack)iterator.next()).dU())) { }
        jsonobject.put("tracks", jsonarray);
_L5:
        if (Aw != null)
        {
            jsonobject.put("textTrackStyle", Aw.dU());
        }
        if (Ax == null) goto _L7; else goto _L6
_L6:
        jsonobject.put("customData", Ax);
        return jsonobject;
_L1:
        s = "NONE";
          goto _L8
        JSONException jsonexception;
        jsonexception;
_L7:
        return jsonobject;
_L2:
        s = "BUFFERED";
          goto _L8
        s = "LIVE";
          goto _L8
    }

    public final boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        boolean flag1 = true;
_L4:
        return flag1;
_L2:
        boolean flag = obj instanceof MediaInfo;
        flag1 = false;
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        MediaInfo mediainfo = (MediaInfo)obj;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        int i;
        int j;
        boolean flag5;
        boolean flag6;
        int k;
        boolean flag7;
        if (Ax == null)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (mediainfo.Ax == null)
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
        if (Ax == null || mediainfo.Ax == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag7 = io.d(Ax, mediainfo.Ax);
        flag1 = false;
        if (!flag7) goto _L4; else goto _L3
_L3:
        flag4 = gj.a(Aq, mediainfo.Aq);
        flag1 = false;
        if (flag4)
        {
            i = Ar;
            j = mediainfo.Ar;
            flag1 = false;
            if (i == j)
            {
                flag5 = gj.a(As, mediainfo.As);
                flag1 = false;
                if (flag5)
                {
                    flag6 = gj.a(At, mediainfo.At);
                    flag1 = false;
                    if (flag6)
                    {
                        k = Au != mediainfo.Au;
                        flag1 = false;
                        if (k == 0)
                        {
                            return true;
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

    public final List getMediaTracks()
    {
        return Av;
    }

    public final MediaMetadata getMetadata()
    {
        return At;
    }

    public final long getStreamDuration()
    {
        return Au;
    }

    public final int getStreamType()
    {
        return Ar;
    }

    public final TextTrackStyle getTextTrackStyle()
    {
        return Aw;
    }

    public final int hashCode()
    {
        Object aobj[] = new Object[6];
        aobj[0] = Aq;
        aobj[1] = Integer.valueOf(Ar);
        aobj[2] = As;
        aobj[3] = At;
        aobj[4] = Long.valueOf(Au);
        aobj[5] = String.valueOf(Ax);
        return hl.hashCode(aobj);
    }

    final void m(long l)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException("Stream duration cannot be negative");
        } else
        {
            Au = l;
            return;
        }
    }

    final void setContentType(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("content type cannot be null or empty");
        } else
        {
            As = s;
            return;
        }
    }

    final void setCustomData(JSONObject jsonobject)
    {
        Ax = jsonobject;
    }

    final void setStreamType(int i)
    {
        if (i < -1 || i > 2)
        {
            throw new IllegalArgumentException("invalid stream type");
        } else
        {
            Ar = i;
            return;
        }
    }

    public final void setTextTrackStyle(TextTrackStyle texttrackstyle)
    {
        Aw = texttrackstyle;
    }
}
