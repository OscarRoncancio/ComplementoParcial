package com.crunchify.jsp.servlet;
 
import edu.co.sergio.mundo.dao.ColmenaDAO;
import edu.co.sergio.mundo.vo.Departamento;
import edu.co.sergio.mundo.vo.colmena;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import javax.servlet.RequestDispatcher;
 
/**
 * @author Crunchify.com
 */
 
public class HelloCrunchify extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // reading the user input
//        String id = request.getParameter("id");
//        String nombre = request.getParameter("calidad");
//        
//        //Se debe incluir validaciones - Lo recuerda: Gestion de Excepciones.
//        ColmenaDAO dao = new ColmenaDAO();
//        
//        colmena col = new colmena();
//        col.setId_colmena(Integer.parseInt(id));
//        col.setCalidadPoblacion(nombre);
//        dao.insert(col);
//        
////        //Listando la informacion  
////        List<colmena> departamentos =  dao.findAll();
////        request.setAttribute("departamentos", departamentos);
//       
//       
//        //Redireccionando la informacion
//        RequestDispatcher redireccion = request.getRequestDispatcher("index.jsp");
//        redireccion.forward(request, response);
        
        
        }
}
