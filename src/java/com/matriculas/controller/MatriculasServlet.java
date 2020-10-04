/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matriculas.controller;

import com.matriculas.ejb.EstudianteFacadeLocal;
import com.matriculas.ejb.MateriaFacadeLocal;
import com.matriculas.ejb.MatriculaFacadeLocal;
import com.matriculas.modelo.Estudiante;
import com.matriculas.modelo.Materia;
import com.matriculas.modelo.Matricula;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alejandro Rios
 */
public class MatriculasServlet extends HttpServlet {

    @EJB
    private MatriculaFacadeLocal matriculaFacade;

    @EJB
    private MateriaFacadeLocal materiaFacade;

    @EJB
    private EstudianteFacadeLocal estudianteFacade;

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
        PrintWriter out = response.getWriter();
        try {
            String action = request.getParameter("action");
            String url = "index.jsp";
           if ("listem".equals(action)) {
                List<Materia> findAll = materiaFacade.findAll();
                request.getSession().setAttribute("subjects", findAll);
                url = "subjectsList.jsp";
            } else if ("liste".equals(action)) {
                List<Estudiante> findAll = estudianteFacade.findAll();
                request.getSession().setAttribute("students", findAll);
                url = "studentsList.jsp";
            } 
           
           else if ("getStudent".equals(action)) {
                int c=Integer.valueOf(request.getSession().getAttribute("ids").toString());
                List<Estudiante> e=new ArrayList<>();
                List<Materia> materias=materiaFacade.getCourses(c);
                Estudiante es =(Estudiante) estudianteFacade.getStudent(c);
                e.add(es);
                request.getSession().setAttribute("courses", materias);
                request.getSession().setAttribute("student", e);
                url = "studentInfo.jsp";
            } else if ("login".equals(action)) {
                int e = Integer.valueOf(request.getParameter("id"));
                String c = request.getParameter("password");
                boolean checkLogin = estudianteFacade.checkLogin(e,c);
                if (checkLogin) {
              
                    request.getSession().setAttribute("login", e);
                    request.getSession().setAttribute("ids", e);
                    url = "manager.jsp";
                } else {
                    url = "login.jsp?error=1";
                }
            } else if ("insert".equals(action)) {
                Estudiante e = new Estudiante();
                e.setCedula(Integer.valueOf(request.getParameter("id")));
                e.setContrasena(request.getParameter("password"));
                e.setNombres(request.getParameter("name"));
                e.setApellidos(request.getParameter("lastname"));
                e.setSexo(request.getParameter("sex"));
                e.setEdad(Integer.valueOf(request.getParameter("age")));
                e.setFoto(request.getParameter("photo"));
                estudianteFacade.create(e);
                url = "login.jsp";
            }else if ("enroll".equals(action)) {
                Matricula e = new Matricula(Integer.valueOf(request.getSession().getAttribute("login").toString()),
                Integer.valueOf(request.getParameter("course")));
                e.setFecha(request.getParameter("date"));
               matriculaFacade.create(e);
                url = "MatriculasServlet?action=getStudent";
           
            }  
            
            else if ("deleteStudent".equals(action)) {
                String id = request.getParameter("id");
                Estudiante e = estudianteFacade.find(Integer.valueOf(id));
                estudianteFacade.remove(e);
                request.getSession().removeAttribute("login");
                url = "login.jsp";
            }else if ("deleteCourse".equals(action)) {
                int id = Integer.valueOf(request.getSession().getAttribute("login").toString());
                int cod=Integer.valueOf(request.getParameter("course"));
               
                matriculaFacade.remove((Matricula)matriculaFacade.getMatricula(id, cod));
                url = "MatriculasServlet?action=getStudent";
            }
            
            else if ("logout".equals(action)) {
                request.getSession().removeAttribute("login");
                url = "login.jsp";
            }
            response.sendRedirect(url);
            
            
        } finally{
        out.close();
        
        }
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
