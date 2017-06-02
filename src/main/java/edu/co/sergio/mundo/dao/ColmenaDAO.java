package edu.co.sergio.mundo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import edu.co.sergio.mundo.vo.Departamento;
import edu.co.sergio.mundo.vo.colmena;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Isabel-Fabian
 * @since 12/08/2015
 * @version 2
 * Clase que permite la gestion de la tabla Depto en la base de datos.
 * 
 * CREATE TABLE Depto(
 *     id_depto integer,
 *     nom_depto varchar(40),
 *     PRIMARY KEY(id_depto)
 * );
 */
 

public class ColmenaDAO implements IBaseDatos<colmena> {

    /**
     * Funcion que permite obtener una lista de los departamentos existentes en
     * la base de datos
     *
     * @return List<Departamento> Retorna la lista de Departamentos existentes
     * en la base de datos
     */
    public List<colmena> findAll() {
        List<colmena> obras = null;
        String query = "Select PanalesConAlimento from colmena where id_colmena = 1";
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(ColmenaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            

            while (rs.next()) {
                if (obras == null) {
                    obras = new ArrayList<colmena>();
                }
                colmena registro = new colmena();
                int valor = rs.getInt("PanalesConAlimento");
                registro.setPanalesConAlimento(valor);
                obras.add(registro);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Departamentos");
            e.printStackTrace();
        }

        return obras;
    }
    public List<colmena> consultaGrafico1() {
        List<colmena> col = null;
        String query = "Select PanalesConAlimento from Colmena where id_colmena = 1";
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(ColmenaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            

            while (rs.next()) {
                if (col == null) {
                    col = new ArrayList<colmena>();
                }
                colmena registro = new colmena();
                int valor = rs.getInt("PanalesConAlimento");
                registro.setPanalesConAlimento(valor);
                col.add(registro);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Departamentos");
            e.printStackTrace();
        }

        return col;
    }
    
     public List<colmena> consultaGrafico2() {
        List<colmena> col = null;
        String query = "SELECT sum(kilosMiel) as suma FROM Recoleccion group by id_colmena";
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(ColmenaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                if (col == null) {
                    col = new ArrayList<colmena>();
                }

                colmena registro = new colmena();
                
                int valor = rs.getInt("suma");
                registro.setKilosMiel(valor);

                col.add(registro);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Departamentos");
            e.printStackTrace();
        }

        return col;
    }

    /**
     * Funcion que permite realizar la insercion de un nuevo registro en la
     * tabla Departamento
     *
     * @param Departamento recibe un objeto de tipo Departamento
     * @return boolean retorna true si la operacion de insercion es exitosa.
     */
    public boolean insert(colmena t) {
        boolean result = false;
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(ColmenaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String query = " insert into Obra (nombreAutor,nombreObra,descripcion,estilo,valor)" + " values (?,?,?,?,?)";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, t.getPanalesConAlimento());
            preparedStmt.setDouble(5, t.getKilosMiel());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Funcion que permite realizar la actualizacion de un nuevo registro en la
     * tabla Departamento
     *
     * @param Departamento recibe un objeto de tipo Departamento
     * @return boolean retorna true si la operacion de actualizacion es exitosa.
     */
    public boolean update(colmena t) {
        boolean result = false;
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(ColmenaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String query = "update Obra set nom_depto = ? where id_depto = ?";
        PreparedStatement preparedStmt = null;
        /*try {
         preparedStmt = connection.prepareStatement(query);
         preparedStmt.setString(1, t.getNom_departamento());
         preparedStmt.setInt   (2, t.getId_departamento());
         if (preparedStmt.executeUpdate() > 0){
         result=true;
         }
			    
         } catch (SQLException e) {
         e.printStackTrace();
         }*/

        return result;
    }

    /**
     * Funcion que permite realizar la eliminario de registro en la tabla
     * Departamento
     *
     * @param Departamento recibe un objeto de tipo Departamento
     * @return boolean retorna true si la operacion de borrado es exitosa.
     */
    public boolean delete(colmena t) {
        boolean result = false;
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(ColmenaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String query = "delete from Obra where nombreObra = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
   
        
}
