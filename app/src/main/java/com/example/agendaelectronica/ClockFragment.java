package com.example.agendaelectronica;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import java.util.Calendar;

public class ClockFragment extends Fragment {

    private TimePicker timePicker;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_clock, container, false);

        // Initialize TimePicker
        timePicker = view.findViewById(R.id.timePicker);

        // Add a button to trigger the alarm
        Button startAlarmButton = view.findViewById(R.id.startAlarmButton);
        startAlarmButton.setOnClickListener(v -> setAlarm());

        return view;
    }

    private void setAlarm() {
        // Get the selected hour and minute from the TimePicker
        int selectedHour = timePicker.getCurrentHour();
        int selectedMinute = timePicker.getCurrentMinute();

        // Set the alarm to trigger at the selected time
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, selectedHour);
        calendar.set(Calendar.MINUTE, selectedMinute);
        calendar.set(Calendar.SECOND, 0);

        long alarmTime = calendar.getTimeInMillis();
        Intent alarmIntent = new Intent(getActivity(), AlarmReceiver.class); // Change this to your BroadcastReceiver class
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity(), 0, alarmIntent, PendingIntent.FLAG_IMMUTABLE);

        AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, alarmTime, pendingIntent);

        // Display a toast message to indicate that the alarm is set
        Toast.makeText(getActivity(), "Alarm set for " + selectedHour + ":" + selectedMinute, Toast.LENGTH_SHORT).show();
    }

}
