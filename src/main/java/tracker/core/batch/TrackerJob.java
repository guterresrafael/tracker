package tracker.core.batch;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Rafael Guterres
 */
public interface TrackerJob extends Serializable {
    
    String getJobName();
    
    long getInitialDelay();
    
    long getPeriod();
    
    TimeUnit getTimeUnit();
    
    Runnable getRunnableTask();
}