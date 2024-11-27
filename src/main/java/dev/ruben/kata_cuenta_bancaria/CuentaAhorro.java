package dev.ruben.kata_cuenta_bancaria;

public class CuentaAhorro extends Cuenta {
    private boolean activa;

    public CuentaAhorro(float saldo, float tasaAnual, boolean activa) {
        super(saldo, tasaAnual);
        this.activa = activa;
    }

    public boolean comprobarActiva() {
        if(saldo < 10000){
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public void consignarDinero(float cantidad) {
        
        if (comprobarActiva()){
            super.consignarDinero(cantidad);
        }
        else {
            System.out.println("La cuenta no está activa. Su saldo ha de ser superior a 10000$.");
        }
    }

    @Override
    public void retirarDinero(float cantidad) {
        if (comprobarActiva()){
            super.retirarDinero(cantidad);
        }
        else {
            System.out.println("La cuenta no está activa. Su saldo ha de ser superior a 10000$.");
        }
    }

    @Override
    public void extractoMensual() {
        
        if (numRetiros <= 4) {
            super.extractoMensual();
        }
        else{
            saldo = saldo - 4*comisionMensual;
            comisionMensual = 1000f;
            saldo = saldo - (numRetiros-4)*comisionMensual;
            super.consignarInteresMensual();
            System.out.println("Extracto mensual ejecutado.\nSu saldo actual es: " + saldo + "$.");
        }
        
        if (!comprobarActiva()){
            System.out.println("Su cuenta está inactiva ya que su saldo es inferior a 10000$.");
        }

    }

    @Override
    public String imprimirCuenta() {
        
        if (numRetiros > 4) {
            comisionMensual = 1000f;
        }

        return  " Saldo: " + saldo + "$" +
                "\n Comisión mensual: " + comisionMensual + "$" +
                "\n Transacciones realizadas: " + (numConsign + numRetiros);
    }

}
