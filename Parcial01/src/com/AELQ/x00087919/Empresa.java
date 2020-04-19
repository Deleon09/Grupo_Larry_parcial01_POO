package com.AELQ.x00087919;

import java.util.ArrayList;

public class Empresa {
    private String nombre;
    private ArrayList<Empleado> planilla;

    public Empresa(String nombre) {
        this.nombre = nombre;
        planilla = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Empleado> getPlanilla() {
        return planilla;
    }

    public void addempleado(Empleado emple) throws AlreadyExistEmployee{
        boolean existe = false;

        for(Empleado empl: planilla){
            if(empl.getNombre().equals(emple.getNombre())){
                existe = true;
            }
        }

        if(existe==true){
            throw new AlreadyExistEmployee("Ya existe el empleado en la empresa.");
        }else{
            planilla.add(emple);
        }

    }

    public void quitempleado(String nombre) throws NotFoundEmployee{
        Empleado aux = null;

        for(Empleado emp: planilla){
            if(emp.getNombre().equals(nombre)){
                aux = emp;
            }
        }

        if(aux!=null){
            planilla.remove(aux);
        }else{
            throw new NotFoundEmployee("El empleado no se encontro.");
        }

    }

    public String consultarempleados(){
        String datos = " ";

        for(Empleado emp: planilla){
            datos += emp.toString()+ "\n";
        }

        return datos;
    }

    public Empleado buscarempleado(String nombre) throws NotFoundEmployee{
        Empleado aux = null;
        for(Empleado empl: planilla){
            if(empl.getNombre().equals(nombre)){
                aux = empl;
            }
        }

        if(aux!=null){
            return aux;
        }else{
            throw new NotFoundEmployee("no se encontro el empleado.");
        }
    }

}
