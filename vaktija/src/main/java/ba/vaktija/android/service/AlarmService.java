package ba.vaktija.android.service;

import android.app.Notification;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.ForegroundInfo;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import ba.vaktija.android.R;

public class AlarmService extends Worker {
    private String channelId = "alarm-channel";
    private int notificationId = 100;

    public AlarmService(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Notification notification = new NotificationCompat.Builder(getApplicationContext(), channelId).
                setSmallIcon(R.drawable.ic_sound_on).
                setContentTitle("Namaz uskoro").build();
        ForegroundInfo foregroundInfo = new ForegroundInfo(notificationId, notification);

        return Result.success();
    }
}
