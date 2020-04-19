package com.AELQ.x00087919;

import java.util.ArrayList;

abstract class Empleado {
    protected String nombre,puesto;
    protected ArrayList<Documento> documentos;
    protected double salario;

    public Empleado(String nombre, String puesto, double salario) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        documentos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public ArrayList<Documento> getDocuments() {
        return documentos;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", puesto='" + puesto + '\'' +
                ", documentos=" + documentos +
                ", salario=" + salario +
                '}';
    }

    public void adddocument(Documento doc) throws AlreadyExistDocument{
        boolean existe = false;

        for(Documento docu: documentos){
            if(docu.getNumero().equals(doc.getNumero())){
                existe = true;
            }
        }

        if(existe==true){
            throw new AlreadyExistDocument("Ya existe ese documento.");
        }else{
            documentos.add(doc);
        }
    }

    public void removedocument(String nombre) throws NotFoundDocument{
        Documento aux = null;

        for(Documento docu: documentos){
            if(docu.getNombre().equals(nombre)){
                aux = docu;
            }
        }

        if(aux!=null){
            documentos.remove(aux);
        }else{
            throw new NotFoundDocument("El documento no se encontro.");
        }
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }
}