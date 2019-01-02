/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Services.JPAPaginController;
import Services.PaginationController;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author KIENDINH
 */
public interface entity {

    static String unitName = "SaleManagerProjectPU";
    static EntityManagerFactory factory = javax.persistence.Persistence.createEntityManagerFactory(unitName);
    static EntityManager entityManager = factory.createEntityManager();
    
}
