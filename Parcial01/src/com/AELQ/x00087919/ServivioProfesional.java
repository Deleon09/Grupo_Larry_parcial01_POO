package com.AELQ.x00087919;

public class ServivioProfesional extends Empleado {

    private int mesesdecontrato;

    public ServivioProfesional(String nombre, String puesto, double salario, int mesesdecontrato) {
        super(nombre, puesto, salario);
        this.mesesdecontrato = mesesdecontrato;
    }

    public void setMesesdecontrato(int mesesdecontrato) {
        this.mesesdecontrato = mesesdecontrato;
    }

    public int getMesesdecontrato() {
        return mesesdecontrato;
    }

}
