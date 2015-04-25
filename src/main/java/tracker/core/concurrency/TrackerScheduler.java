package tracker.core.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import tracker.core.batch.TrackerJobImpl;

/**
 *
 * @author Rafael Guterres
 */
public class TrackerScheduler {

    @Resource
    ManagedScheduledExecutorService managedScheduledExecutorService;

    List<TrackerJobImpl> jobs = new ArrayList<>();

    @PostConstruct
    public void init() {
        jobs.add(createJobPosition());
    }

    private TrackerJobImpl createJobPosition() {
        TrackerJobImpl jobPosition = new TrackerJobImpl();
        jobPosition.setJobName("position-job");
        jobPosition.setInitialDelay(0);
        jobPosition.setPeriod(15);
        jobPosition.setTimeUnit(TimeUnit.SECONDS);
        return jobPosition;
    }

    public void scheduleJobs() {
        for (TrackerJobImpl job : jobs) {
            managedScheduledExecutorService.scheduleAtFixedRate(
                    job.getTrackerTask(),
                    job.getInitialDelay(),
                    job.getPeriod(),
                    job.getTimeUnit());
        }
    }
}