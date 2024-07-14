/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author L E N O V O
 */
public class EntityManagerUtil {
    private static EntityManagerFactory EMF;
    public static EntityManagerFactory getEMF(){
        if(EMF==null){
            EMF = Persistence.createEntityManagerFactory("aparcPU");
        }
        return EMF ;
    }
    private static EntityManagerFactory EM;
    public static EntityManagerFactory getEM(){
        if(EM==null){
            EM = Persistence.createEntityManagerFactory("aparcPU");
        }
        return EM ;
    }
    
    public static void closeEMF(){
        if(EMF!=null || EMF.isOpen()){
        EMF.close();
        }
    }
    
}
