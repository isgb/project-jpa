/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isgb.projectjpa.dao.impl;

import com.isgb.projectjpa.dao.SubGeneroDAO;
import com.isgb.projectjpa.entity.Genero;
import com.isgb.projectjpa.entity.SubGenero;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author isaias
 * Clase TEST para comprobar el funcionamiento de los emtodos del CRUD del subgenero
 */
public class SubGeneroDAOImplTest {
    
    public SubGeneroDAOImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    private SubGeneroDAO subGeneroDAO = new SubGeneroDAOImpl();
    
    @Test
    public void testGuardar(){
       SubGenero subGenero = new SubGenero();
       subGenero.setDescripcion("HardCore");
       subGenero.setFechaCreacion(LocalDateTime.now());
       subGenero.setEstatus(true);
       
       Genero genero = new Genero();
       genero.setDescripcion("Metal");
       genero.setFechaCreacion(LocalDateTime.now());
       genero.setEstatus(true);
       
       subGenero.setGenero(genero);
       
       this.subGeneroDAO.guardar(subGenero);
    }
    
    @Test
    public void testConsultar(){
        List<SubGenero> subGeneroConsultados = this.subGeneroDAO.consultar();
        
        assertTrue(subGeneroConsultados.size() > 0);
        
        for(SubGenero subGenero : subGeneroConsultados){
            System.out.println("Subgenero: "+ subGenero.getDescripcion());
            System.out.println("Genero: "+ subGenero.getGenero().getDescripcion());
        }
    }
    
    @Test
    public void testActualizar(){
        
        SubGenero subGeneroConsultado = this.subGeneroDAO.consultarById(3L);
        
        subGeneroConsultado.setDescripcion("Trash Metal");
        subGeneroConsultado.getGenero().setDescripcion("Metal Trash");
        
        this.subGeneroDAO.actualizar(subGeneroConsultado);
        
    }
    
    @Test
    public void testEliminar(){
        
        this.subGeneroDAO.eliminar(3L);
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
