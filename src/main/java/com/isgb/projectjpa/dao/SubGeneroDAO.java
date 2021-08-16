
package com.isgb.projectjpa.dao;

import com.isgb.projectjpa.entity.SubGenero;
import java.util.List;

/**
 *
 * @author isaias
 * Interfae que genera el DAO para als instrucciones del CRUD a la tabla de subgenero
 */
public interface SubGeneroDAO {
    
    void guardar(SubGenero subGenero);
    
    void actualizar(SubGenero subGenero);
    
    void eliminar(Long id);
    
    List<SubGenero> consultar();
    
    SubGenero consultarById(Long id);
}
