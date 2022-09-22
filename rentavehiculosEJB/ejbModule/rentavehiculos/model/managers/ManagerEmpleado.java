package rentavehiculos.model.managers;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import rentaevehiculos.model.core.managers.ManagerDAO;
import rentavehiculos.model.managers.Entities.Empleado;

/**
 * Session Bean implementation class ManagerEmpleado
 */
@Stateless
@LocalBean
public class ManagerEmpleado {

	@EJB
	private ManagerDAO mDAO;
	
    public ManagerEmpleado() {
        // TODO Auto-generated constructor stub
    }
    
    //EMPLEADOS:
    public List<Empleado> findAllEmpleado(){
    	return mDAO.findAll(Empleado.class);
    }
    
    public Empleado findByIdEmpleado(int idEmpleado) throws Exception {
    	return (Empleado) mDAO.findById(Empleado.class, idEmpleado);
    }
    
    public void insertarEmpleado() throws Exception {
    	Empleado empleado=new Empleado();
    	mDAO.insertar(empleado);
    }


}
