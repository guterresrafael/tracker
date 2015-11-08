package tracker.core;

import arch.batch.JobScheduler;
import arch.core.BaseApplication;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;

/**
 *
 * @author Rafael Guterres
 */
@ApplicationPath("/api")
public class Application extends BaseApplication {

    @Inject
    private JobScheduler scheduler;

    @Inject
    private Logger logger;

    @Override
    public JobScheduler getScheduler() {
        return scheduler;
    }

    @Override
    public Logger getLogger() {
        return logger;
    }

    @PostConstruct
    @Override
    protected void init() {
        //TODO: implementar annotation para agendamento automatico
        //scheduler.addJob(new PositionJob());
        //scheduler.scheduleJobs();
    }
}
