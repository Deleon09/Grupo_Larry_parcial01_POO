package com.AELQ.x00087919;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

        String menu = "1. Agregar Empleado.\n"+
                "2. Despedir Empleado.\n"+
                "3. Ver Lista de Empleados.\n"+
                "4. Calcular Sueldo.\n"+
                "5. Mostrar Totales.\n"+
                "0. Salir.";

        Empresa Nintendo = new Empresa("Nintendo");
        CalculadoraImpuestos calcular = new CalculadoraImpuestos();
        String nombreEmpleado, puesto, numeroDocumento, nombreDocumento;
        double salario;
        int contrato, extension;
        byte op = 0, puesto1 = 0;

        do{
            System.out.println(menu);
            System.out.print("Opción: "); op = in.nextByte(); in.nextLine();

            switch (op){
                case 1:
                    try{
                        System.out.print("Nombre de Empleado: "); nombreEmpleado = in.nextLine();
                        System.out.print("Salario de Empleado: "); salario = in.nextDouble(); in.nextLine();
                        System.out.print("Nombre de Documento: "); nombreDocumento = in.nextLine();
                        System.out.print("Numero de Documento:"); numeroDocumento = in.nextLine();
                        System.out.print("1) ServicioProfesional  o 2) PlazaFija: "); puesto1 = in.nextByte(); in.nextLine();
                        if (puesto1 == 1){
                            puesto = "ServicioProfesional";
                            System.out.print("Meses de Contrato: "); contrato = in.nextInt(); in.nextLine();
                            Nintendo.addempleado(new ServivioProfesional(nombreEmpleado,puesto,salario, contrato));
                            System.out.println("Empleado agregado con exito.");
                        }else {
                            puesto = "PlazaFija";
                            System.out.print("Extension: "); extension = in.nextInt(); in.nextLine();
                            Nintendo.addempleado(new PlazaFija(nombreEmpleado,puesto,salario,extension));
                            System.out.println("Empleado agregado con exito.");
                        }
                    }catch (AlreadyExistEmployee ex){
                        System.out.println(ex.getMessage());
                    }catch (InputMismatchException ex){
                        System.out.println("me diste un dato incorrecto.");
                    }catch (Exception ex){
                        System.out.println("ocurrio un error.");
                    }
                    break;
                case 2:
                    try {
                        System.out.print("Empleado a Despedir: ");
                        nombreEmpleado = in.nextLine();
                        Nintendo.quitempleado(nombreEmpleado);
                        System.out.println("Empleado despedido.");
                    }catch (NotFoundEmployee ex){
                        System.out.println(ex.getMessage());
                    }catch (Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 3:
                    System.out.println(Nintendo.consultarempleados());
                    break;
                case 4:
                    try {
                        System.out.print("Digite el nombre del empleado: ");
                        nombreEmpleado = in.nextLine();
                        System.out.println("El sueldo del empleado es: " + calcular.calacularpago(Nintendo.buscarempleado(nombreEmpleado)));
                    }catch(NotFoundEmployee ex){
                        System.out.println(ex.getMessage());
                    }catch (Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 5:
                    try {
                        System.out.print("Digite el nombre del empleado: ");
                        nombreEmpleado = in.nextLine();
                        System.out.println(calcular.mostrarTotales(Nintendo.buscarempleado(nombreEmpleado)));
                    }catch (NotFoundEmployee ex){
                        System.out.println(ex.getMessage());
                    }catch (Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Saliendo....");
                    break;
                default:
                    System.out.println("Opcion incorrecta!");
                    break;
            }

        }while(op!=0);

    }
}
