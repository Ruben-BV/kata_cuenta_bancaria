package dev.ruben.kata_cuenta_bancaria;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CuentaAhorroTest {

    private CuentaAhorro cuentaAhorro1;
    private CuentaAhorro cuentaAhorro2;

    @BeforeEach
    public void init() {
        this.cuentaAhorro1 = new CuentaAhorro(15000, 0.03f, true);
        this.cuentaAhorro2 = new CuentaAhorro(5000, 0.03f, false);
    }
    
    @Test
    void testComprobarActiva() {
        cuentaAhorro1.saldo = 10500;
        boolean result = cuentaAhorro1.comprobarActiva();
        assertTrue(result);
    }

    @Test
    void testComprobarNoActiva() {
        cuentaAhorro1.saldo = 9000;
        boolean result = cuentaAhorro1.comprobarActiva();
        assertFalse(result);
    }

    @Test
    void testConsignarDineroCuentaActiva() {
        float cantidad = 5000f;
        cuentaAhorro1.consignarDinero(cantidad);
        assertEquals(20000, cuentaAhorro1.saldo);
    }

    @Test
    void testConsignarDineroCuentaNoActiva() {
        float cantidad = 5000f;
        cuentaAhorro2.consignarDinero(cantidad);
        assertEquals(5000, cuentaAhorro2.saldo);
    }

    
    @Test
    void testRetirarDineroCuentaActiva() {
        float cantidad = 5000f;
        cuentaAhorro1.retirarDinero(cantidad);
        assertEquals(10000, cuentaAhorro1.saldo);
    }

    @Test
    void testRetirarDineroCuentaNoActiva() {
        float cantidad = 5000f;
        cuentaAhorro2.retirarDinero(cantidad);
        assertEquals(5000, cuentaAhorro2.saldo);
    }
    
    @Test
    void testExtractoMensualRetirosMenorQueCuatro() {
        cuentaAhorro1.retirarDinero(1000.0f);
        cuentaAhorro1.retirarDinero(1000.0f);
        cuentaAhorro1.retirarDinero(1000.0f);
        
        cuentaAhorro1.extractoMensual();

        assertEquals(12030.0, cuentaAhorro1.saldo);

    }
    @Test
    void testExtractoMensualRetirosMayorQueCuatro() {
        cuentaAhorro1.retirarDinero(1000.0f);
        cuentaAhorro1.retirarDinero(1000.0f);
        cuentaAhorro1.retirarDinero(1000.0f);
        cuentaAhorro1.retirarDinero(1000.0f);
        cuentaAhorro1.retirarDinero(1000.0f);
        
        cuentaAhorro1.extractoMensual();

        assertEquals(9022.5, cuentaAhorro1.saldo);

    }

    @Test
    void testImprimirCuentaNumRetirosMayorQueCuatro() {
        cuentaAhorro1.retirarDinero(1000.0f);
        cuentaAhorro1.retirarDinero(1000.0f);
        cuentaAhorro1.retirarDinero(1000.0f);
        cuentaAhorro1.retirarDinero(1000.0f);
        cuentaAhorro1.retirarDinero(1000.0f);

        String result = cuentaAhorro1.imprimirCuenta();
        assertEquals(" Saldo: 10000.0$\n Comisión mensual: 1000.0$\n Transacciones realizadas: 5", result);
    }

    @Test
    void testImprimirCuentaNumRetirosMenorQueCuatro() {
        cuentaAhorro1.retirarDinero(1000.0f);
        cuentaAhorro1.retirarDinero(1000.0f);
        cuentaAhorro1.retirarDinero(1000.0f);
        
        String result = cuentaAhorro1.imprimirCuenta();
        assertEquals(" Saldo: 12000.0$\n Comisión mensual: 0.0$\n Transacciones realizadas: 3", result);

    }

    
}
