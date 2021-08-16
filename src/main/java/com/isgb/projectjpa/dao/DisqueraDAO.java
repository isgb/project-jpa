
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
    
    /*Metodo que permite consultar con JPQL la disquera a apartir de uan descripcion
    * @param descripcion {@link String} descripcion de la disquera
    * @return {@link Disquera} la disquera consultada
    */
    Disquera consultarByDescripcionJPQL(String descripcion);
    
    /*Metodo que permite consultar con SQL NATIVO la disquera a apartir de uan descripcion
    * @param descripcion {@link String} descripcion de la disquera
    * @return {@link Disquera} la disquera consultada
    */
    Disquera consultarByDescripcionNative(String descripcion);
    
}
