package tracker.batch;

import arch.batch.JobUnit;
import java.util.concurrent.TimeUnit;
import javax.batch.runtime.BatchRuntime;

/**
 *
 * @author Rafael Guterres
 */
public class PositionJob implements JobUnit {

    private static final String POSITION_JOB_NAME = "position-job";
    private static final long POSITION_JOB_INITIAL_DELAY = 0;
    private static final long POSITION_JOB_PERIOD = 15;
    private static final TimeUnit POSITION_JOB_TIME_UNIT = TimeUnit.SECONDS;

    @Override
    public String getJobName() {
        return POSITION_JOB_NAME;
    }

    @Override
    public long getInitialDelay() {
        return POSITION_JOB_INITIAL_DELAY;
    }

    @Override
    public long getPeriod() {
        return POSITION_JOB_PERIOD;
    }

    @Override
    public TimeUnit getTimeUnit() {
        return POSITION_JOB_TIME_UNIT;
    }

    @Override
    public Runnable getRunnableTask() {
        return new Runnable() {

            @Override
            public void run() {
                BatchRuntime.getJobOperator().start(getJobName(), null);
            }
        };
    }
}
