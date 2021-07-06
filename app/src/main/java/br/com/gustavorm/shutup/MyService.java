package br.com.gustavorm.shutup;

import android.content.Intent;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import android.widget.Toast;

public class MyService extends NotificationListenerService {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("Nova Notificação", "Aguardando...");
        Toast.makeText(this, "Shutup em execução...", Toast.LENGTH_SHORT).show();;
        return super.onBind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        try {
            //cancelAllNotifications();
            //StatusBarNotification[] activeNotifications = getActiveNotifications();
            try{
                String pack = sbn.getPackageName();
                String key = sbn.getKey();
                String titulo = sbn.getNotification().extras.getString("android.title");
                Log.d("Nova Notificação", "package:" + pack + " key:" + key + " título:"+  titulo);
                if("com.android.phone".equals(pack) && "Novo correio de voz".equals(titulo)){
                    sbn.getNotification().defaults = 0;
                    cancelNotification(key);
                    Log.d("Nova Notificação", "Cancelada!");
                }
            }catch (Exception e){}

        }
        catch (Exception e)
        {

        }
        super.onNotificationPosted(sbn);
    }

}
