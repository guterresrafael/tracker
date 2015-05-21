package rs.pelotas.tracker.service;

import javax.ejb.Stateless;
import rs.pelotas.arch.service.Service;
import rs.pelotas.tracker.entity.Command;

/**
 *
 * @author Rafael Guterres
 */
@Stateless
public interface CommandService extends Service<Command, Long> {

}