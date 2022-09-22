package rentavehiculos.model.managers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import rentaevehiculos.model.core.managers.ManagerDAO;
import rentavehiculos.model.managers.Entities.TipoVehiculo;
import rentavehiculos.model.managers.Entities.Vehiculo;

/**
 * Session Bean implementation class ManagerTipoVehiculo
 */
@Stateless
@LocalBean
public class ManagerTipoVehiculo {
	
	@EJB
	private ManagerDAO mDAO;

    /**
     * Default constructor. 
     */
    public ManagerTipoVehiculo() {
        // TODO Auto-generated constructor stub
    }
    
    public List<TipoVehiculo> findAllTipoVehiculo(){
    	return mDAO.findAll(TipoVehiculo.class);
    }
    
    public TipoVehiculo findByIdTipoVehiculo(int idTipoVehiculo) throws Exception {
        return (TipoVehiculo) mDAO.findById(TipoVehiculo.class, idTipoVehiculo);
    }

}
