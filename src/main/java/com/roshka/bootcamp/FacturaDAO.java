package com.roshka.bootcamp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacturaDAO {

    Connection connection;
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;


    public FacturaDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }


    protected void connect() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connection = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public boolean insertFactura(Factura factura) throws SQLException {
        String sql = "INSERT INTO factura (fecha_emision, fecha_vencimiento, cliente_id, factura_tipo_id, moneda_id) VALUES (?, ?, ?, ?, ?)";

        connect();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDate(1, (Date) factura.getFecha_emision());
        statement.setDate(2, (Date) factura.getFecha_vencimiento());
        statement.setInt(3, factura.getCliente_id());
        statement.setInt(4, factura.getFactura_tipo_id());
        statement.setInt(5, factura.getMoneda_id());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<Factura> listAllFacturas() throws SQLException {
        List<Factura> listBook = new ArrayList<>();

        String sql = "SELECT * FROM factura ORDER BY id";

        connect();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            Date fecha_emision = resultSet.getDate("fecha_emision");
            Date fecha_vencimiento = resultSet.getDate("fecha_vencimiento");
            int cliente_id = resultSet.getInt("cliente_id");
            int factura_tipo_id = resultSet.getInt("factura_tipo_id");
            int moneda_id = resultSet.getInt("moneda_id");

            Factura factura = new Factura(id, fecha_emision, fecha_vencimiento,cliente_id, factura_tipo_id, moneda_id);
            listBook.add(factura);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listBook;
    }

    public boolean deleteFactura(Factura factura) throws SQLException {
        String sql = "DELETE FROM factura where id = ?";

        connect();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, factura.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();

        return rowDeleted;
    }

    public boolean updateFactura(Factura factura) throws SQLException {
        String sql = "UPDATE factura SET fecha_emision = ?, fecha_vencimiento = ?, cliente_id = ?, factura_tipo_id = ?, moneda_id = ? ";
        sql += " WHERE id = ?";

        connect();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDate(1, (Date) factura.getFecha_emision());
        statement.setDate(2, (Date) factura.getFecha_vencimiento());
        statement.setInt(3, factura.getCliente_id());
        statement.setInt(4, factura.getFactura_tipo_id());
        statement.setInt(5, factura.getMoneda_id());
        statement.setInt(6, factura.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();

        disconnect();

        return rowUpdated;
    }

    public Factura getFactura(int id) throws SQLException {
        Factura factura = null;
        String sql = "SELECT * FROM factura WHERE id = ?";

        connect();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            Date fecha_emision = resultSet.getDate("fecha_emision");
            Date fecha_vencimiento = resultSet.getDate("fecha_vencimiento");
            int cliente_id = resultSet.getInt("cliente_id");
            int factura_tipo_id = resultSet.getInt("factura_tipo_id");
            int moneda_id = resultSet.getInt("moneda_id");

            factura = new Factura(id, fecha_emision, fecha_vencimiento, cliente_id, factura_tipo_id, moneda_id);
        }

        resultSet.close();
        statement.close();

        disconnect();


        return factura;
    }

}
