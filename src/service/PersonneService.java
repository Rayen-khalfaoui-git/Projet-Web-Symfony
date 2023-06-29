/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import entity.Personne;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;
/**
 *
 * @author wiemhjiri
 */
public class PersonneService implements IService<Personne>{
    
    private Connection conn;

    public PersonneService() {
        conn=DataSource.getInstance().getCnx();
    }
    
    @Override
    public void insert(Personne p){
        String requete="insert into personne (nom,prenom,age) values"
                + "('"+p.getNom()+"','"+p.getPrenom()+"',"+p.getAge()+")";
        try {
            Statement ste=conn.createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(PersonneService.class.getName()).
                    log(Level.SEVERE, null, ex);
        }    
    }
    public void insertPst(Personne p){
        String requete="insert into personne (nom,prenom,age) values (?,?,?)";
        try {
            PreparedStatement pst=conn.prepareStatement(requete);
            pst.setString(1, p.getNom());
            pst.setString(2, p.getPrenom());
            pst.setInt(3, p.getAge());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonneService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void delete(Personne t) {
            String requete="DELETE from personne where id = "+t.getId();
        try {
            Statement st=conn.createStatement();
            st.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(PersonneService.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    @Override
    public void update(Personne t) {
        String requete="UPDATE `personne` SET `Nom`='" +t.getNom()+"',`Prenom`='"+t.getPrenom()+"',`Age`='"+ t.getAge() +"' where id = '" + t.getId() + "'" ;
        try {
            Statement st=conn.createStatement();
            st.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(PersonneService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Personne> readAll() {
        String requete ="select * from personne";
        List<Personne> list=new ArrayList<>();
        try {
            Statement st=conn.createStatement();
           ResultSet rs= st.executeQuery(requete);
           while(rs.next()){
               Personne p=new Personne
        (rs.getInt("id"), rs.getString(2), rs.getString("prenom"), rs.getInt("age"));
               list.add(p);
                       
           }
        } catch (SQLException ex) {
            Logger.getLogger(PersonneService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Personne readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
