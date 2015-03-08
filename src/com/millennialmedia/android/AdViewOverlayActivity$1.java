// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

// Referenced classes of package com.millennialmedia.android:
//            AdViewOverlayActivity

class prevShakeTime
    implements SensorEventListener
{

    private long currentTime;
    private float force;
    private float lastX;
    private float lastY;
    private float lastZ;
    private long prevShakeTime;
    private long prevTime;
    final AdViewOverlayActivity this$0;
    private long timeDifference;
    private float x;
    private float y;
    private float z;

    public void onAccuracyChanged(Sensor sensor, int i)
    {
    }

    public void onSensorChanged(SensorEvent sensorevent)
    {
        currentTime = sensorevent.timestamp;
        x = sensorevent.values[0];
        y = sensorevent.values[1];
        z = sensorevent.values[2];
        timeDifference = currentTime - prevTime;
        if (timeDifference > 500L)
        {
            AdViewOverlayActivity.access$000(AdViewOverlayActivity.this, x, y, z);
            force = Math.abs((x + y + z) - lastX - lastY - lastZ) / (float)timeDifference;
            AdViewOverlayActivity.access$000(AdViewOverlayActivity.this, x, y, z);
            if (force > 0.2F)
            {
                if (currentTime - prevShakeTime >= 1000L)
                {
                    AdViewOverlayActivity.access$100(AdViewOverlayActivity.this, force);
                }
                prevShakeTime = currentTime;
            }
            lastX = x;
            lastY = y;
            lastZ = z;
            prevTime = currentTime;
        }
    }

    _cls9()
    {
        this$0 = AdViewOverlayActivity.this;
        super();
        x = 0.0F;
        y = 0.0F;
        z = 0.0F;
        lastX = 0.0F;
        lastY = 0.0F;
        lastZ = 0.0F;
        force = 0.0F;
        currentTime = 0L;
        prevTime = 0L;
        timeDifference = 0L;
        prevShakeTime = 0L;
    }
}
