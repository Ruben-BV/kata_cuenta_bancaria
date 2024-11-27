package dev.ruben.kata_cuenta_bancaria;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CuentaTest {
    private Cuenta cuenta;

    @BeforeEach
    public void init() {
        this.cuenta = new Cuenta(10000, 0.03f);
    }

    @Test
    void testConsignarDineroCantidadMayorQueCero() {
        float cantidad = 100f;

        cuenta.consignarDinero(cantidad);

        assertEquals(10100f, cuenta.saldo);
        assertEquals(1, cuenta.numConsign);
    }

    @Test
    void testConsignarDineroCantidadMenorQueCero() {
        float cantidad = -100f;

        cuenta.consignarDinero(cantidad);

        assertEquals(10000, cuenta.saldo);
        assertEquals(0, cuenta.numConsign);
    }

    @Test
    void testRetirarDineroCantidadMenorQueSaldo() {
        float cantidad = 3000f;

        cuenta.retirarDinero(cantidad);

        assertEquals(7000f, cuenta.saldo);
        assertEquals(1, cuenta.numRetiros);
    }
    @Test
    void testRetirarDineroCantidadMayorQueSaldo() {
        float cantidad = 10001f;

        cuenta.retirarDinero(cantidad);

        assertEquals(10000, cuenta.saldo);
        assertEquals(0, cuenta.numRetiros);
    }
    @Test
    void testRetirarDineroCantidadNegativa() {
        float cantidad = -100f;

        cuenta.retirarDinero(cantidad);

        assertEquals(10000, cuenta.saldo);
        assertEquals(0, cuenta.numRetiros);
    }
    
    @Test
    void testConsignarInteresMensual() {
        cuenta.consignarInteresMensual();
        assertEquals(10025f, cuenta.saldo);
    }

    @Test
    void testExtractoMensual() {
        cuenta.extractoMensual();
        assertEquals(10025f, cuenta.saldo);
    }

    @Test
    void testImprimirCuenta() {
        cuenta.imprimirCuenta();

        assertEquals(  " Saldo: 10000.0" +
                "\n Nº consignaciones: 0" +
                "\n Nº retiros: 0" +
                "\n Tasa anual: 3.0%" +
                "\n Comisión mensual: 0.0$", cuenta.imprimirCuenta() );
    }


    
}
