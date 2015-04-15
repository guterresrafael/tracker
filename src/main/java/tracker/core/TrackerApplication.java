package tracker.core;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import tracker.core.concurrency.TrackerScheduler;

/**
 *
 * Classe responsavel pela inicializacao da Aplicacao
 * Inicializa o servlet REST e substitui a declaração no web.xml
 * 
 * @author Rafael Guterres
 */
@ApplicationPath("/api")
public class TrackerApplication extends Application {

    @Inject
    TrackerScheduler trackerScheduler;
    
    @Inject
    Logger logger;
    
    @PostConstruct
    public void init() {
        logger.info("Application initialization..");
        trackerScheduler.scheduleJobs();
    }
}
