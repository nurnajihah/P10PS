package sg.edu.rp.c346.p10_ps;


import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;
import static android.support.v4.content.ContextCompat.getSystemService;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag1 extends Fragment {

    Button btnChange, btnLater;
    TextView tv;

    int tap = 1;
    int reqCode = 12345;


    public Frag1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        btnChange = getView().findViewById(R.id.btnChange);
        btnLater = getView().findViewById(R.id.btnLater);

        tv = getView().findViewById(R.id.tv);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tap % 2 == 0) {
                    tv.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                } else {
                    tv.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                }
                tap++;
            }
        });

        btnLater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.MINUTE, 5);

                Intent intent  = new Intent(getContext(), NotificationReceiver.class);

                PendingIntent pendingIntent = PendingIntent.getBroadcast(getContext(), reqCode, intent, PendingIntent.FLAG_CANCEL_CURRENT);

//                AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
//                am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);
            }
        });
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false);
    }

}
