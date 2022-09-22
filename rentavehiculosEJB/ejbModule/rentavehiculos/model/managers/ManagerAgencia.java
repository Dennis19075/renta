package rentavehiculos.model.managers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import rentaevehiculos.model.core.managers.ManagerDAO;
import rentavehiculos.model.managers.Entities.Agencia;
import rentavehiculos.model.managers.Entities.Vehiculo;

/**
 * Session Bean implementation class ManagerAgencia
 */
@Stateless
@LocalBean
public class ManagerAgencia {
	@EJB
	private ManagerDAO mDAO;

    /**
     * Default constructor. 
     */
    public ManagerAgencia() {
        // TODO Auto-generated constructor stub
    }
    
    public List<Agencia> findAllAgencia(){
    	return mDAO.findAll(Agencia.class);
    }
    
    public Agencia findByIdAgencia(String idAgencia) throws Exception {
        return (Agencia) mDAO.findById(Agencia.class, idAgencia);
    }
    
    public void insertarAgencia(Agencia agencia) throws Exception {
    	mDAO.insertar(agencia);	
    }
    
    public void eliminarAgencia(String idagencia) throws Exception {
    	Agencia agencia = (Agencia) mDAO.findById(Agencia.class, idagencia);
    	
    	mDAO.eliminar(Agencia.class, agencia.getIdagencia());
    }
    
    public void editarAgencia(Agencia agenciaEditar) throws Exception {
    	
    	Agencia agencia = findByIdAgencia(agenciaEditar.getIdagencia());
    	
    	agencia.setCiudadage(agenciaEditar.getCiudadage());
    	agencia.setDireccionage(agenciaEditar.getDireccionage());
    	agencia.setNombreage(agenciaEditar.getNombreage());
    	agencia.setTelefonoage(agenciaEditar.getDireccionage());
    	
    	
    	mDAO.actualizar(agencia);
    }

}
