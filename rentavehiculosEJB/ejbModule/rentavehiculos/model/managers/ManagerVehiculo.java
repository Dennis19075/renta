package rentavehiculos.model.managers;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import rentaevehiculos.model.core.managers.ManagerDAO;
import rentavehiculos.model.managers.Entities.Vehiculo;

/**
 * Session Bean implementation class ManagerVehiculo
 */
@Stateless
@LocalBean
public class ManagerVehiculo {
	@EJB
	private ManagerDAO mDAO;

    /**
     * Default constructor. 
     */
    public ManagerVehiculo() {
        // TODO Auto-generated constructor stub    	
    }
    
    public List<Vehiculo> findAllVehiculo(){
    	return mDAO.findAll(Vehiculo.class);
    }
    
    public Vehiculo findByIdVehiculo(String idVehiculo) throws Exception {
        return (Vehiculo) mDAO.findById(Vehiculo.class, idVehiculo);
    }
    
    public void insertarVehiculo(Vehiculo vehiculo) throws Exception {
    	mDAO.insertar(vehiculo);	
    }
    
    public void eliminarVehiculo(String placa) throws Exception {
    	Vehiculo vehiculo = (Vehiculo) mDAO.findById(Vehiculo.class, placa);
    	
    	mDAO.eliminar(Vehiculo.class, vehiculo.getPlacaveh());
    }
    
    public void editarVehiculo(Vehiculo vehiculoEditar) throws Exception {
    	
    	Vehiculo vehiculo = findByIdVehiculo(vehiculoEditar.getPlacaveh());
    	
    	vehiculo.setMarcaveh(vehiculoEditar.getMarcaveh());
    	vehiculo.setModeloveh(vehiculoEditar.getModeloveh());
    	vehiculo.setAnomodeloveh(vehiculoEditar.getAnomodeloveh());
    	vehiculo.setColorveh(vehiculoEditar.getColorveh());
    	vehiculo.setDisponibilidadeh(vehiculoEditar.getDisponibilidadeh());
    	vehiculo.setCapacidadpersonaseh(vehiculoEditar.getCapacidadpersonaseh());
    	vehiculo.setPreciorentaveh(vehiculoEditar.getPreciorentaveh());
    	vehiculo.setTipoVehiculo(vehiculoEditar.getTipoVehiculo());
    	
    	mDAO.actualizar(vehiculo);
    }
    

}
