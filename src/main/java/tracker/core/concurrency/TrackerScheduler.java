package tracker.core.concurrency;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import tracker.core.batch.TrackerJob;
import tracker.legacy.batch.PositionJob;

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
        //TODO: implementar annotation para agendamento automatico
        jobs.add(new PositionJob());
    }

    public void scheduleJobs() {
        for (TrackerJob job : jobs) {
            managedScheduledExecutorService.scheduleAtFixedRate(
                    job.getRunnableTask(),
                    job.getInitialDelay(),
                    job.getPeriod(),
                    job.getTimeUnit());
        }
    }
}