package com.geduo.datacollect.alive.doubles.one;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Description: <PairServiceB><br>
 * Author:      gxl<br>
 * Date:        2018/12/18<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class PairServiceB extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new Binder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        bindService(new Intent(PairServiceB.this, PairServiceA.class), mServiceConnection, BIND_AUTO_CREATE);
    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            bindService(new Intent(PairServiceB.this, PairServiceA.class), mServiceConnection, BIND_AUTO_CREATE);
        }
    };
}