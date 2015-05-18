package rs.pelotas.tracker.resource.bean;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import rs.pelotas.arch.resource.BaseResource;
import rs.pelotas.arch.service.Service;
import rs.pelotas.arch.resource.ResponseBuilder;
import rs.pelotas.tracker.entity.Position;
import rs.pelotas.tracker.resource.PositionResource;
import rs.pelotas.tracker.service.PositionService;

/**
 *
 * @author Rafael Guterres
 */
public class PositionResourceBean extends BaseResource<Position, Long> implements PositionResource {
    
    private static final long serialVersionUID = 3630413584076355265L;
    private static final String GOOGLE_MAPS_LINK = "https://maps.google.com?q=%s,%s";

    @Inject
    PositionService positionService;
    
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
