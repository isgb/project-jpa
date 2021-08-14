
package com.isgb.projectjpa.dao.impl;

import com.isgb.projectjpa.dao.DisqueraDAO;
import com.isgb.projectjpa.entity.Disquera;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Desarrollo
 * Clase que implementa las transacciones para tabla de Disquera
 */
public class DisqueraDAOImpl implements DisqueraDAO{
    
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("persistenceDevPredator");

    @Override
    public void guardar(Disquera disquera) {
       EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        
        EntityTransaction et = em.getTransaction();
        et.begin();
        
        try{
            System.out.println("SE ESTA GUARDANDO");
            em.persist(disquera);
            et.commit();
        }catch(Exception e){
            if(et != null){
                System.out.println("ROLLBACK!!");
                et.rollback();
            }
        }
        
    }

    @Override
    public void actualizar(Disquera disquera) {
         EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        
        EntityTransaction et = em.getTransaction();
        et.begin();
        
        try{
            System.out.println("SE ESTA ACTUALIZANDO");
            
            em.merge(disquera);
            
            et.commit();
        }catch(Exception e){
            if(et != null){
                System.out.println("ROLLBACK!!");
                et.rollback();
            }
        }
    }

    @Override
    public void eliminar(Long id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        
        Disquera disqueraConsultada = em.find(Disquera.class,id);
        
        EntityTransaction et = em.getTransaction();
        et.begin();
        
        try{
            System.out.println("SE ESTA ELIMINANDO");
            
            em.remove(disqueraConsultada);
            
            et.commit();
        }catch(Exception e){
            if(et != null){
                System.out.println("ROLLBACK!!");
                et.rollback();
            }
        }
    }

    @Override
    public List<Disquera> consultar() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        
        TypedQuery<Disquera> queryDisquera =(TypedQuery<Disquera>)em.createQuery("FROM Disquera ORDER by descripcion");
        
        return queryDisquera.getResultList();
        
        
    }

    @Override
    public Disquera consultarById(Long id) {
      EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
      
      Disquera disqueraConsultado = em.find(Disquera.class, id);
      
      if(disqueraConsultado == null){
          throw new EntityNotFoundException("La disquera con id: "+ id +" no se encontro");
      }
      
        return disqueraConsultado;
      
    }
    
    
    
}
