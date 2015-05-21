/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.pelotas.tracker.service;

import javax.ejb.Stateless;
import rs.pelotas.arch.service.Service;
import rs.pelotas.tracker.entity.Position;

/**
 *
 * @author Rafael
 */
@Stateless
public interface PositionService extends Service<Position, Long> {
    
}