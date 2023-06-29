/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexionbd3a10;

import entity.Personne;
import entity.User;
import service.PersonneService;
import utils.DataSource;

/**
 *
 * @author wiemhjiri
 */
public class ConnexionBD3A10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        DataSource ds1 = DataSource.getInstance();
//        System.out.println(ds1);
//        DataSource ds2 = DataSource.getInstance();
//        System.out.println(ds2);
//
//        DataSource ds3 = DataSource.getInstance();
//        System.out.println(ds3);

        Personne p1=new Personne(3, "bensalah", "saif", 22);
        PersonneService ps=new PersonneService();
        
       //ps.insert(p1);
       //ps.delete(p1);
       //ps.update(p1);
       ps.readAll().forEach(System.out::println);
    }

}
