package dev.ruben.kata_cuenta_bancaria;

public class CuentaCorriente extends Cuenta {
    private float sobregiro = 0f;

    public CuentaCorriente(float saldo, float tasaAnual, float sobregiro) {
        super(saldo, tasaAnual);
        this.sobregiro = sobregiro;
    }

    @Override
    public void retirarDinero(float cantidad) {
    
        saldo = saldo - cantidad;
        numRetiros++;

        if(cantidad > saldo) {
            sobregiro = sobregiro + (cantidad - saldo);
            saldo = 0;
        }

        System.out.println("Retiro de dinero realizado con éxito. Su saldo actual es: " + saldo + "$.");
        System.out.println("Sobregiro actual: " + sobregiro + "$.");
    }
        

    @Override
    public void consignarDinero(float cantidad) {
        
        if (sobregiro == 0) {
            super.consignarDinero(cantidad);
        }
        else {
            sobregiro = sobregiro - cantidad;
            if (sobregiro > 0) {
                System.out.println("Consignación realizada con éxito. Aún tiene un sobregiro de: " + sobregiro + "$.");
            }
            else{
                saldo = -sobregiro;
                sobregiro = 0;
                System.out.println("Consignación realizada con éxito. Su saldo actual es: " + saldo + "$.");
            }
        }
    }
    
    
    @Override
    public void extractoMensual() {
        super.extractoMensual();
    }
    
    @Override
    public String imprimirCuenta() {
        return  " Saldo: " + saldo +
                "\n Nº Transacciones: " + (numConsign + numRetiros) +
                "\n Sobregiro: " + sobregiro + "$";
    }
}