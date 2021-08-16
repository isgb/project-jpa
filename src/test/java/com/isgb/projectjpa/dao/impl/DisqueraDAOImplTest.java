/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isgb.projectjpa.dao.impl;

import com.isgb.projectjpa.entity.Disquera;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Desarrollo
 */
public class DisqueraDAOImplTest {
    
    public DisqueraDAOImplTest() {
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
    
    private DisqueraDAOImpl instance = new DisqueraDAOImpl();
    /**
     * Test of guardar method, of class DisqueraDAOImpl.
     */
    @Test
    public void testGuardar() {
        System.out.println("guardar");
        
        Disquera disquera = new Disquera();
        disquera.setDescripcion("MegaForce");
        disquera.setFechaCreacion(LocalDateTime.now());
        disquera.setEstatus(true);
       
        instance.guardar(disquera);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testConsultarById() {
        Disquera disquera = instance.consultarById(19L);
        
         assertNotNull(disquera);
        
        System.out.println("Dsiquera: "+ disquera.getDescripcion());
        
    }
    
    @Test
    public void testActualizar() {
        Disquera disqueraConsultada = instance.consultarById(19L);
        
        disqueraConsultada.setDescripcion("Disquera Judas priest");
        
        instance.actualizar(disqueraConsultada);
        
    }
    
    @Test
    public void testEliminar() {
       
        Long id = 20L;
        
        instance.eliminar(id);
        
    }
    
    @Test
    public void testConsultar() {
       
       List<Disquera> disquerasConsultadas = instance.consultar();
       
       //assertTrue(disquerasConsultadas.size() > 0);  
       assertNotNull(disquerasConsultadas);
       
       disquerasConsultadas.forEach(disquera -> {
           System.out.println("Disquera: "+ disquera.getDescripcion());
       });
        
    }
    
    @Test
    public void testConsultarByDescripcionJPQL(){
        
        Disquera disqueraConsultada = instance.consultarByDescripcionJPQL("Disquera Judas priest");
        
        assertNotNull(disqueraConsultada);
        
        System.out.println("Disquera native by descripcion: " + disqueraConsultada);
    
    }
    
    @Test
    public void testConsultarByDescripcionNative(){
        
        Disquera disqueraConsultada = instance.consultarByDescripcionNative("Disquera Judas priest");
        
        assertNotNull(disqueraConsultada);
        
        System.out.println("Disquera Nativw by descripcion: " + disqueraConsultada);
    
    }
   
    
}
