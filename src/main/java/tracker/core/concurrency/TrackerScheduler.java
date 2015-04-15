package tracker.core.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import tracker.core.batch.TrackerJob;

/**
 *
 * @author Rafael Guterres
 */
public class TrackerScheduler {

    @Resource
    ManagedScheduledExecutorService managedScheduledExecutorService;

    List<TrackerJob> jobs = new ArrayList<>();

    @PostConstruct
    public void init() {
        jobs.add(createJobPosition());
    }

    private TrackerJob createJobPosition() {
        TrackerJob jobPosition = new TrackerJob();
        jobPosition.setJobName("position-job");
        jobPosition.setInitialDelay(0);
        jobPosition.setPeriod(15);
        jobPosition.setTimeUnit(TimeUnit.SECONDS);
        return jobPosition;
    }

    public void scheduleJobs() {
        for (TrackerJob job : jobs) {
            managedScheduledExecutorService.scheduleAtFixedRate(
                    job.getTrackerTask(),
                    job.getInitialDelay(),
                    job.getPeriod(),
                    job.getTimeUnit());
        }
    }
}
