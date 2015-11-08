package tracker.resource.bean;

import arch.resource.BaseResource;
import arch.resource.ResponseBuilder;
import arch.service.Service;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import tracker.entity.Position;
import tracker.resource.PositionResource;
import tracker.service.PositionService;

/**
 *
 * @author Rafael Guterres
 */
@RequestScoped
public class PositionResourceBean extends BaseResource<Position, Long> implements PositionResource {

    private static final long serialVersionUID = 3630413584076355265L;

    private static final String GOOGLE_MAPS_LINK = "https://maps.google.com?q=%s,%s";

    @Inject
    private PositionService positionService;

    @Override
    public Service<Position, Long> getService() {
        return positionService;
    }

    @Override
    public Response getGoogleMapsLink(Long id) {
        Position position = getService().load(id);
        String googleMapsLink = String.format(GOOGLE_MAPS_LINK, position.getLatitude(), position.getLongitude());
        return ResponseBuilder.redirect(googleMapsLink);
    }
}
