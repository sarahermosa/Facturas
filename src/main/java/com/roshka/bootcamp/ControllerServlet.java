package com.roshka.bootcamp;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @author www.codejava.net
 */
public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private FacturaDAO facturaDAO;

    public void init() {

        String jdbcURL = getServletContext().getInitParameter("dbUrl");
        String jdbcUsername = getServletContext().getInitParameter("dbUser");
        String jdbcPassword = getServletContext().getInitParameter("dbPassword");

        facturaDAO = new FacturaDAO(jdbcURL, jdbcUsername, jdbcPassword);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertFactura(request, response);
                    break;
                case "/delete":
                    deleteFactura(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateFactura(request, response);
                    break;
                default:
                    listFactura(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listFactura(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Factura> listFactura = facturaDAO.listAllFacturas();
        request.setAttribute("listFactura", listFactura);
        RequestDispatcher dispatcher = request.getRequestDispatcher("FacturaList.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("FacturaForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Factura existingFactura = facturaDAO.getFactura(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("FacturaForm.jsp");
        request.setAttribute("factura", existingFactura);
        dispatcher.forward(request, response);

    }

    private void insertFactura(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Date fecha_emision =Date.valueOf(request.getParameter("fecha_emision"));
        Date fecha_vencimiento =Date.valueOf(request.getParameter("fecha_vencimiento"));
        int cliente_id = Integer.parseInt(request.getParameter("cliente_id"));
        int factura_tipo_id = Integer.parseInt(request.getParameter("factura_tipo_id"));
        int moneda_id = Integer.parseInt(request.getParameter("moneda_id"));

        Factura newFactura = new Factura(fecha_emision, fecha_vencimiento, cliente_id, factura_tipo_id, moneda_id);
        facturaDAO.insertFactura(newFactura);
        response.sendRedirect("list");
    }

    private void updateFactura(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Date fecha_emision = Date.valueOf(request.getParameter("fecha_emision"));
        Date fecha_vencimiento =Date.valueOf(request.getParameter("fecha_vencimiento"));
        int cliente_id = Integer.parseInt(request.getParameter("cliente_id"));
        int factura_tipo_id = Integer.parseInt(request.getParameter("factura_tipo_id"));
        int moneda_id = Integer.parseInt(request.getParameter("moneda_id"));

        Factura factura = new Factura(id, fecha_emision, fecha_vencimiento, cliente_id, factura_tipo_id, moneda_id);
        facturaDAO.updateFactura(factura);
        response.sendRedirect("list");
    }

    private void deleteFactura(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Factura factura = new Factura(id);
        facturaDAO.deleteFactura(factura);
        response.sendRedirect("list");

    }
}
