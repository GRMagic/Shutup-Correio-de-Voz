package br.com.gustavorm.shutup;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //startService(new Intent(this, MyService.class));

        setContentView(R.layout.activity_main);
        //startActivity(new Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS));
        //finish();
        super.onCreate(savedInstanceState);
    }


    public void configurar(View v){
        startActivity(new Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS));
    }
}
