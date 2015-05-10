package rs.pelotas.tracker.core;

import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import rs.pelotas.arch.batch.JobScheduler;
import rs.pelotas.arch.core.BaseApplication;

/**
 *
 * @author Rafael Guterres
 */
@ApplicationPath("/api")
public class Application extends BaseApplication {

    @Inject
    JobScheduler scheduler;

    @Inject
    Logger logger;
    
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
    
    @PermitAll
    @GET
    @Path("/version")
    public String getVersion() {
        return "1.0.0-SNAPSHOT";
    }
}