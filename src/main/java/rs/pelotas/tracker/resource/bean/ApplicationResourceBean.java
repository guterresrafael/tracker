package rs.pelotas.tracker.resource.bean;

import rs.pelotas.tracker.resource.ApplicationResource;


public class ApplicationResourceBean implements ApplicationResource {

    private static final long serialVersionUID = 1429964490392452041L;

    @Override
    public String getVersion() {
        return "1.0.0-SNAPSHOT";
    }
}
