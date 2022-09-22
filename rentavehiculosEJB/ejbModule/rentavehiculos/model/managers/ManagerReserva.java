package rentavehiculos.model.managers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import rentaevehiculos.model.core.managers.ManagerDAO;
import rentavehiculos.model.managers.Entities.Reserva;

/**
 * Session Bean implementation class ManagerReserva
 */
@Stateless
@LocalBean
public class ManagerReserva {
	@EJB
	private ManagerDAO mDAO;

    /**
     * Default constructor. 
     */
    public ManagerReserva() {
        // TODO Auto-generated constructor stub
    }
    
    public List<Reserva> findAllReserva(){
    	return mDAO.findAll(Reserva.class);
    }
    
}
