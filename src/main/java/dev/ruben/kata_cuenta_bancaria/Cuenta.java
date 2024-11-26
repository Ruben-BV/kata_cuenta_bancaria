package dev.ruben.kata_cuenta_bancaria;

public class Cuenta {
    protected float saldo;
    protected int numConsign = 0;
    protected int numRetiros = 0;
    protected float tasaAnual;
    protected float comisionMensual = 0f;
    
    
    public Cuenta(float saldo, float tasaAnual) {
        this.saldo = saldo;
        this.tasaAnual = tasaAnual;
    }


    public void consignarDinero(float cantidad) {
        if (cantidad > 0){
            saldo = cantidad + saldo;
            numConsign++;
            System.out.println("Consignación realizada con éxito\nSu saldo actual es: " + saldo + "€.");
        }
        else {
            System.out.println("La cantidad a consignar ha de ser mayor que cero.");
        }
        
    }

    public void retirarDinero(float cantidad) {
        if(cantidad <= saldo && cantidad > 0) {
            saldo = saldo - cantidad;
            numRetiros++;
            System.out.println("Retiro de dinero realizado con éxito. Su saldo actual es: " + saldo + "€.");
        }
        else if (cantidad > saldo){
            System.out.println("No hay suficiente saldo para realizar el retiro.");
        }
        else {
            System.out.println("La cantidad a retirar ha de ser mayor que cero.");
        }
    }

    public void consignarInteresMensual() {
        float interesMensual = saldo * tasaAnual / 12;
        saldo = saldo + interesMensual;
    }
    
    public void extractoMensual() {
        saldo = saldo - comisionMensual;
        consignarInteresMensual();

        System.out.println("Extracto mensual ejecutado.\nSu saldo actual es: " + saldo + "€.");
    }

    public String imprimirCuenta() {
        return  " Saldo: " + saldo +
                "\n Nº consignaciones: " + numConsign +
                "\n Nº retiros: " + numRetiros +
                "\n Tasa anual: " + tasaAnual*100 + "%" +
                "\n Comisión mensual: " + comisionMensual + "€";
    }


}
