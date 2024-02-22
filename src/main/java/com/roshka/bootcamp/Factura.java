package com.roshka.bootcamp;

import java.util.Date;

public class Factura {

    private int id;
    private Date fecha_emision;
    private Date fecha_vencimiento;
    private int cliente_id;
    private int factura_tipo_id;
    private int moneda_id;

    public Factura(){
    }

    public Factura(int id){
        this.id = id;
    }

    public Factura(int id, Date fecha_emision, Date fecha_vencimiento, int cliente_id, int factura_tipo_id, int moneda_id) {
        this.id = id;
        this.fecha_emision = fecha_emision;
        this.fecha_vencimiento = fecha_vencimiento;
        this.cliente_id = cliente_id;
        this.factura_tipo_id = factura_tipo_id;
        this.moneda_id = moneda_id;
    }

    public Factura(Date fecha_emision, Date fecha_vencimiento, int cliente_id, int factura_tipo_id, int moneda_id) {
        this.fecha_emision = fecha_emision;
        this.fecha_vencimiento = fecha_vencimiento;
        this.cliente_id = cliente_id;
        this.factura_tipo_id = factura_tipo_id;
        this.moneda_id = moneda_id;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public int getMoneda_id() {
        return moneda_id;
    }

    public void setMoneda_id(int moneda_id) {
        this.moneda_id = moneda_id;
    }

    public int getFactura_tipo_id() {
        return factura_tipo_id;
    }

    public void setFactura_tipo_id(int factura_tipo_id) {
        this.factura_tipo_id = factura_tipo_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }
}
