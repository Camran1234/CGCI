    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import com.chtml.error.ErrorHandler;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.StringReader;
import com.chtml.html.*;
import com.chtml.table.Captcha;
import com.chtml.table.Holder;
import com.chtml.table.HolderCaptcha;
import com.chtml.table.HtmlData;
import com.chtml.table.SymbolTable;
import javax.swing.JOptionPane;
/**
 *
 * @author camran1234
 */
@WebServlet("/Compilador")
public class Compilador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String code = request.getParameter("code");
        HtmlData htmlData=null;
        SymbolTable table = new SymbolTable();
        try {
        new ErrorHandler().resetHandler();
        //get the code
        StringReader reader = new StringReader(code);
        ChtmlLex lexic = new ChtmlLex(reader);
        HtmlParser parser = new HtmlParser(lexic);
        new SymbolTable().clearTable();;
        parser.parse();
         htmlData = parser.getHtmlData();
         
         //Analizamos semanticamente
         htmlData.execute();
         Captcha captcha = new Captcha();
         if(new ErrorHandler().isCompilable()){
             if(!code.isEmpty()){
                captcha.setData(htmlData);
                request.getSession().setAttribute("Mensaje", "GENERADO");
                HolderCaptcha holder = new HolderCaptcha(htmlData,captcha.getHref(),code );
                //Agregamos el captcha generado a la lista
                new Holder().addCaptcha(holder);
             }
         }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        String showDebug = request.getParameter("boton");
        String previousPosition = request.getParameter("position");
        request.getSession().setAttribute("newCode", code);
        request.getSession().setAttribute("positionA",previousPosition);
        request.getSession().setAttribute("tabla",showDebug);
        response.sendRedirect("./index.jsp");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
