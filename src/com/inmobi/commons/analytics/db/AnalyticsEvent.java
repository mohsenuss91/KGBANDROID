// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.db;


public class AnalyticsEvent
{

    public static final String EVENT_ID = "id";
    public static final String IN_APP = "inapp";
    public static final String SUBS = "subs";
    public static final String TYPE_CUSTOM_EVENT = "ce";
    public static final String TYPE_END_SESSION = "es";
    public static final String TYPE_LEVEL_BEGIN = "lb";
    public static final String TYPE_LEVEL_END = "le";
    public static final String TYPE_START_SESSION = "ss";
    public static final String TYPE_TAG_TRANSACTION = "pi";
    private long a;
    private String b;
    private String c;
    private long d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private TRANSACTION_ITEM_TYPE o;
    private double p;
    private int q;
    private String r;
    private String s;
    private String t;
    private TRANSACTION_STATUS_SERVER_CODE u;
    private long v;
    private long w;

    public AnalyticsEvent(String s1)
    {
        b = s1;
    }

    public String getEventAttemptCount()
    {
        return j;
    }

    public String getEventAttemptTime()
    {
        return k;
    }

    public String getEventAttributeMap()
    {
        return e;
    }

    public String getEventCustomName()
    {
        return l;
    }

    public long getEventId()
    {
        return a;
    }

    public String getEventLevelId()
    {
        return f;
    }

    public String getEventLevelName()
    {
        return g;
    }

    public String getEventLevelStatus()
    {
        return h;
    }

    public String getEventSessionId()
    {
        return c;
    }

    public long getEventSessionTimeStamp()
    {
        return d;
    }

    public long getEventTableId()
    {
        return w;
    }

    public long getEventTimeStamp()
    {
        return v;
    }

    public String getEventTimeTaken()
    {
        return i;
    }

    public String getEventType()
    {
        return b;
    }

    public String getTransactionCurrencyCode()
    {
        return r;
    }

    public String getTransactionId()
    {
        return t;
    }

    public int getTransactionItemCount()
    {
        return q;
    }

    public String getTransactionItemDescription()
    {
        return n;
    }

    public String getTransactionItemName()
    {
        return m;
    }

    public double getTransactionItemPrice()
    {
        return p;
    }

    public int getTransactionItemType()
    {
        if (o == null)
        {
            return TRANSACTION_ITEM_TYPE.INVALID.getValue();
        } else
        {
            return o.getValue();
        }
    }

    public String getTransactionProductId()
    {
        return s;
    }

    public int getTransactionStatus()
    {
        if (u == null)
        {
            return TRANSACTION_STATUS_SERVER_CODE.INVALID.getValue();
        } else
        {
            return u.getValue();
        }
    }

    public void setEventAttemptCount(String s1)
    {
        j = s1;
    }

    public void setEventAttemptTime(String s1)
    {
        k = s1;
    }

    public void setEventAttributeMap(String s1)
    {
        e = s1;
    }

    public void setEventCustomName(String s1)
    {
        l = s1;
    }

    public void setEventId(long l1)
    {
        a = l1;
    }

    public void setEventLevelId(String s1)
    {
        f = s1;
    }

    public void setEventLevelName(String s1)
    {
        g = s1;
    }

    public void setEventLevelStatus(String s1)
    {
        h = s1;
    }

    public void setEventSessionId(String s1)
    {
        c = s1;
    }

    public void setEventSessionTimeStamp(long l1)
    {
        d = l1;
    }

    public void setEventTableId(long l1)
    {
        w = l1;
    }

    public void setEventTimeStamp(long l1)
    {
        v = l1;
    }

    public void setEventTimeTaken(String s1)
    {
        i = s1;
    }

    public void setTransactionCurrencyCode(String s1)
    {
        r = s1;
    }

    public void setTransactionId(String s1)
    {
        t = s1;
    }

    public void setTransactionItemCount(int i1)
    {
        q = i1;
    }

    public void setTransactionItemDescription(String s1)
    {
        n = s1;
    }

    public void setTransactionItemName(String s1)
    {
        m = s1;
    }

    public void setTransactionItemPrice(double d1)
    {
        p = d1;
    }

    public void setTransactionItemType(int i1)
    {
        if (TRANSACTION_ITEM_TYPE.INAPP.getValue() == i1)
        {
            o = TRANSACTION_ITEM_TYPE.INAPP;
            return;
        }
        if (TRANSACTION_ITEM_TYPE.SUBSCRIPTION.getValue() == i1)
        {
            o = TRANSACTION_ITEM_TYPE.SUBSCRIPTION;
            return;
        } else
        {
            o = TRANSACTION_ITEM_TYPE.INVALID;
            return;
        }
    }

    public void setTransactionProductId(String s1)
    {
        s = s1;
    }

    public void setTransactionStatus(int i1)
    {
        if (TRANSACTION_STATUS_SERVER_CODE.PURCHASED.getValue() == i1)
        {
            u = TRANSACTION_STATUS_SERVER_CODE.PURCHASED;
            return;
        }
        if (TRANSACTION_STATUS_SERVER_CODE.REFUNDED.getValue() == i1)
        {
            u = TRANSACTION_STATUS_SERVER_CODE.REFUNDED;
            return;
        }
        if (TRANSACTION_STATUS_SERVER_CODE.FAILED.getValue() == i1)
        {
            u = TRANSACTION_STATUS_SERVER_CODE.FAILED;
            return;
        } else
        {
            u = TRANSACTION_STATUS_SERVER_CODE.INVALID;
            return;
        }
    }

    private class TRANSACTION_ITEM_TYPE extends Enum
    {

        public static final TRANSACTION_ITEM_TYPE INAPP;
        public static final TRANSACTION_ITEM_TYPE INVALID;
        public static final TRANSACTION_ITEM_TYPE SUBSCRIPTION;
        private static final TRANSACTION_ITEM_TYPE b[];
        private final int a;

        public static TRANSACTION_ITEM_TYPE valueOf(String s1)
        {
            return (TRANSACTION_ITEM_TYPE)Enum.valueOf(com/inmobi/commons/analytics/db/AnalyticsEvent$TRANSACTION_ITEM_TYPE, s1);
        }

        public static TRANSACTION_ITEM_TYPE[] values()
        {
            return (TRANSACTION_ITEM_TYPE[])b.clone();
        }

        public final int getValue()
        {
            return a;
        }

        static 
        {
            INVALID = new TRANSACTION_ITEM_TYPE("INVALID", 0, -1);
            INAPP = new TRANSACTION_ITEM_TYPE("INAPP", 1, 1);
            SUBSCRIPTION = new TRANSACTION_ITEM_TYPE("SUBSCRIPTION", 2, 2);
            TRANSACTION_ITEM_TYPE atransaction_item_type[] = new TRANSACTION_ITEM_TYPE[3];
            atransaction_item_type[0] = INVALID;
            atransaction_item_type[1] = INAPP;
            atransaction_item_type[2] = SUBSCRIPTION;
            b = atransaction_item_type;
        }

        private TRANSACTION_ITEM_TYPE(String s1, int i1, int j1)
        {
            super(s1, i1);
            a = j1;
        }
    }


    private class TRANSACTION_STATUS_SERVER_CODE extends Enum
    {

        public static final TRANSACTION_STATUS_SERVER_CODE FAILED;
        public static final TRANSACTION_STATUS_SERVER_CODE INVALID;
        public static final TRANSACTION_STATUS_SERVER_CODE PURCHASED;
        public static final TRANSACTION_STATUS_SERVER_CODE REFUNDED;
        public static final TRANSACTION_STATUS_SERVER_CODE RESTORED;
        private static final TRANSACTION_STATUS_SERVER_CODE b[];
        private final int a;

        public static TRANSACTION_STATUS_SERVER_CODE valueOf(String s1)
        {
            return (TRANSACTION_STATUS_SERVER_CODE)Enum.valueOf(com/inmobi/commons/analytics/db/AnalyticsEvent$TRANSACTION_STATUS_SERVER_CODE, s1);
        }

        public static TRANSACTION_STATUS_SERVER_CODE[] values()
        {
            return (TRANSACTION_STATUS_SERVER_CODE[])b.clone();
        }

        public final int getValue()
        {
            return a;
        }

        static 
        {
            INVALID = new TRANSACTION_STATUS_SERVER_CODE("INVALID", 0, -1);
            PURCHASED = new TRANSACTION_STATUS_SERVER_CODE("PURCHASED", 1, 1);
            FAILED = new TRANSACTION_STATUS_SERVER_CODE("FAILED", 2, 2);
            RESTORED = new TRANSACTION_STATUS_SERVER_CODE("RESTORED", 3, 3);
            REFUNDED = new TRANSACTION_STATUS_SERVER_CODE("REFUNDED", 4, 4);
            TRANSACTION_STATUS_SERVER_CODE atransaction_status_server_code[] = new TRANSACTION_STATUS_SERVER_CODE[5];
            atransaction_status_server_code[0] = INVALID;
            atransaction_status_server_code[1] = PURCHASED;
            atransaction_status_server_code[2] = FAILED;
            atransaction_status_server_code[3] = RESTORED;
            atransaction_status_server_code[4] = REFUNDED;
            b = atransaction_status_server_code;
        }

        private TRANSACTION_STATUS_SERVER_CODE(String s1, int i1, int j1)
        {
            super(s1, i1);
            a = j1;
        }
    }

}
