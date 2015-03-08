// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.controller;

import android.content.Context;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.controller.util.NavigationStringEnum;
import com.inmobi.re.controller.util.TransitionStringEnum;
import java.lang.reflect.Field;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class JSController
{

    public static final String EXIT = "exit";
    public static final String FULL_SCREEN = "fullscreen";
    public static final String STYLE_NORMAL = "normal";
    protected ExpandProperties expProps;
    protected IMWebView imWebView;
    protected Context mContext;
    protected ExpandProperties temporaryexpProps;

    public JSController(IMWebView imwebview, Context context)
    {
        imWebView = imwebview;
        mContext = context;
        expProps = new ExpandProperties();
        temporaryexpProps = new ExpandProperties();
    }

    protected static Object getFromJSON(JSONObject jsonobject, Class class1)
    {
        Field afield[];
        Object obj;
        int i;
        afield = class1.getDeclaredFields();
        obj = class1.newInstance();
        i = 0;
_L9:
        if (i >= afield.length) goto _L2; else goto _L1
_L1:
        Field field;
        String s;
        String s1;
        field = afield[i];
        s = field.getName().replace('_', '-');
        s1 = field.getType().toString();
        if (!s1.equals("int")) goto _L4; else goto _L3
_L3:
        String s2 = jsonobject.getString(s).toLowerCase(Locale.ENGLISH);
        boolean flag = s2.startsWith("#");
        if (!flag) goto _L6; else goto _L5
_L5:
        int j = -1;
        if (!s2.startsWith("#0x")) goto _L8; else goto _L7
_L7:
        int i1 = Integer.decode(s2.substring(1)).intValue();
        j = i1;
_L10:
        NumberFormatException numberformatexception;
        int k;
        NumberFormatException numberformatexception1;
        int l;
        try
        {
            field.set(obj, Integer.valueOf(j));
        }
        catch (JSONException jsonexception) { }
_L11:
        i++;
          goto _L9
_L8:
        l = Integer.parseInt(s2.substring(1), 16);
        j = l;
          goto _L10
_L6:
        k = Integer.parseInt(s2);
        j = k;
          goto _L10
_L4:
label0:
        {
            if (!s1.equals("class java.lang.String"))
            {
                break label0;
            }
            field.set(obj, jsonobject.getString(s));
        }
          goto _L11
label1:
        {
            if (!s1.equals("boolean"))
            {
                break label1;
            }
            field.set(obj, Boolean.valueOf(jsonobject.getBoolean(s)));
        }
          goto _L11
label2:
        {
            if (!s1.equals("float"))
            {
                break label2;
            }
            field.set(obj, Float.valueOf(Float.parseFloat(jsonobject.getString(s))));
        }
          goto _L11
        if (!s1.equals("class com.mraid.NavigationStringEnum")) goto _L13; else goto _L12
_L12:
        field.set(obj, NavigationStringEnum.fromString(jsonobject.getString(s)));
          goto _L11
_L13:
        if (!s1.equals("class com.mraid.TransitionStringEnum")) goto _L11; else goto _L14
_L14:
        field.set(obj, TransitionStringEnum.fromString(jsonobject.getString(s)));
          goto _L11
_L2:
        return obj;
        numberformatexception;
        j = 0;
          goto _L10
        numberformatexception1;
          goto _L10
    }

    public abstract void stopAllListeners();

    private class ExpandProperties extends ReflectedParcelable
    {
        private class ReflectedParcelable
            implements Parcelable
        {

            public int describeContents()
            {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i)
            {
                Field afield[];
                int j;
                afield = getClass().getDeclaredFields();
                j = 0;
_L2:
                Field field;
                Class class1;
                if (j >= afield.length)
                {
                    break MISSING_BLOCK_LABEL_111;
                }
                field = afield[j];
                class1 = field.getType();
                if (!class1.isEnum())
                {
                    break MISSING_BLOCK_LABEL_112;
                }
                String s = class1.toString();
                if (s.equals("class com.mraid.NavigationStringEnum"))
                {
                    parcel.writeString(((NavigationStringEnum)field.get(this)).getText());
                    break MISSING_BLOCK_LABEL_145;
                }
                Object obj;
                try
                {
                    if (s.equals("class com.mraid.TransitionStringEnum"))
                    {
                        parcel.writeString(((TransitionStringEnum)field.get(this)).getText());
                    }
                    break MISSING_BLOCK_LABEL_145;
                }
                catch (IllegalArgumentException illegalargumentexception)
                {
                    illegalargumentexception.printStackTrace();
                }
                catch (IllegalAccessException illegalaccessexception)
                {
                    illegalaccessexception.printStackTrace();
                    return;
                }
                return;
                obj = field.get(this);
                if (!(obj instanceof android.os.Parcelable.Creator))
                {
                    parcel.writeValue(obj);
                }
                j++;
                if (true) goto _L2; else goto _L1
_L1:
            }

            public ReflectedParcelable()
            {
            }

            protected ReflectedParcelable(Parcel parcel)
            {
                Field afield[];
                int i;
                afield = getClass().getDeclaredFields();
                i = 0;
_L2:
                Field field;
                Class class1;
                if (i >= afield.length)
                {
                    break MISSING_BLOCK_LABEL_106;
                }
                field = afield[i];
                class1 = field.getType();
                if (!class1.isEnum())
                {
                    break MISSING_BLOCK_LABEL_107;
                }
                String s = class1.toString();
                if (s.equals("class com.mraid.NavigationStringEnum"))
                {
                    field.set(this, NavigationStringEnum.fromString(parcel.readString()));
                    break MISSING_BLOCK_LABEL_141;
                }
                try
                {
                    if (s.equals("class com.mraid.TransitionStringEnum"))
                    {
                        field.set(this, TransitionStringEnum.fromString(parcel.readString()));
                    }
                    break MISSING_BLOCK_LABEL_141;
                }
                catch (IllegalArgumentException illegalargumentexception)
                {
                    illegalargumentexception.printStackTrace();
                }
                catch (IllegalAccessException illegalaccessexception)
                {
                    illegalaccessexception.printStackTrace();
                    return;
                }
                return;
                if (!(field.get(this) instanceof android.os.Parcelable.Creator))
                {
                    field.set(this, parcel.readValue(null));
                }
                i++;
                if (true) goto _L2; else goto _L1
_L1:
            }
        }


        public static final android.os.Parcelable.Creator CREATOR = new f();
        public int actualHeightRequested;
        public int actualWidthRequested;
        public int bottomStuff;
        public int currentX;
        public int currentY;
        public int height;
        public boolean isModal;
        public boolean lockOrientation;
        public String orientation;
        public int portraitHeightRequested;
        public int portraitWidthRequested;
        public String rotationAtExpand;
        public int topStuff;
        public boolean useCustomClose;
        public int width;
        public int x;
        public int y;
        public boolean zeroWidthHeight;

        public void reinitializeExpandProperties()
        {
            width = 0;
            height = 0;
            x = -1;
            y = -1;
            useCustomClose = false;
            isModal = true;
            lockOrientation = false;
            orientation = "";
            actualWidthRequested = 0;
            actualHeightRequested = 0;
            topStuff = 0;
            bottomStuff = 0;
            portraitWidthRequested = 0;
            portraitHeightRequested = 0;
            zeroWidthHeight = false;
            rotationAtExpand = "";
            currentX = 0;
            currentY = 0;
        }


        public ExpandProperties()
        {
            reinitializeExpandProperties();
        }

        protected ExpandProperties(Parcel parcel)
        {
            super(parcel);
        }
    }

}
