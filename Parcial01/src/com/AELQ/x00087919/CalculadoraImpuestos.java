package com.AELQ.x00087919;

public final class CalculadoraImpuestos {
    private double totalRenta, totalISSS, totalAFP;

    protected CalculadoraImpuestos() {
    }

    public double calacularpago(Empleado emple) {
        double restante, pago_empleado = 0;

        if (emple instanceof ServivioProfesional) {
            totalRenta = emple.salario * 0.1;
            pago_empleado = emple.salario - totalRenta;
        } else {
            totalAFP = emple.salario * 0.0625;
            totalISSS = emple.salario * 0.03;
            restante = emple.salario - totalAFP - totalISSS;

            if((restante>=0.01)&&(restante<=472.00)){
                totalRenta = 0;
                pago_empleado = restante;
            }else if((restante>=472.01)&&(restante<=895.24)){
                totalRenta = (0.1 * (restante - 472) + 17.67);
                pago_empleado = restante - totalRenta;
            }else if((restante>=895.25)&&(restante<=2038.10)){
                totalRenta = (0.2 * (restante - 895.24) + 60);
                pago_empleado = restante - totalRenta;
            }else{
                totalRenta = (0.3 * (restante - 2038.10) + 288.57);
                pago_empleado = restante - totalRenta;
            }

        }
        return pago_empleado;
    }

    public String mostrarTotales (Empleado emple) {
        return "CalculadoraImpuestos{" +
                "totalRenta=" + totalRenta +
                ", totalISSS=" + totalISSS +
                ", totalAFP=" + totalAFP +
                '}';
    }
}