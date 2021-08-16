
package com.isgb.projectjpa.dao;

import com.isgb.projectjpa.entity.Disquera;
import java.util.List;

/**
 *
 * @author isaias
 * Interface que genera el DAO para las transacciones del CRUD a la tabla de disquera
 */
public interface DisqueraDAO {
    
    void guardar(Disquera disquera);
    
    void actualizar(Disquera disquera);
    
    void eliminar(Long id);
    
    List<Disquera> consultar();
    
    Disquera consultarById(Long id);
    
}
