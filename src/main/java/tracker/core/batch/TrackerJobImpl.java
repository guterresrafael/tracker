package tracker.core.batch;

import java.util.concurrent.TimeUnit;
import javax.batch.runtime.BatchRuntime;

/**
 *
 * @author Rafael Guterres
 */
public class TrackerJobImpl {
    
    private String jobName;
    private long initialDelay;
    private long period;
    private TimeUnit timeUnit;

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public long getInitialDelay() {
        return initialDelay;
    }

    public void setInitialDelay(long initialDelay) {
        this.initialDelay = initialDelay;
    }

    public long getPeriod() {
        return period;
    }

    public void setPeriod(long period) {
        this.period = period;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }
    
    public TrackerTask getTrackerTask() {
        return this.new TrackerTask();
    }

    private class TrackerTask implements Runnable {
        TrackerTask(){}
        
        @Override
        public void run() {
            BatchRuntime.getJobOperator().start(jobName, null);
        }
    }
}