package dev.ruben.kata_cuenta_bancaria;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CuentaCorrienteTest {

    private CuentaCorriente cuentaCorriente;
    
    @BeforeEach
    public void init() {
        this.cuentaCorriente = new CuentaCorriente(0f, 0.03f, 5000f);
    
    }
    @Test
    void testConsignarDineroSobregiroIgualCero() {
        cuentaCorriente.sobregiro = 0f;
        cuentaCorriente.saldo = 2000f;

        cuentaCorriente.consignarDinero(2000);
        assertEquals(4000f, cuentaCorriente.saldo, 0.001f);
    }

    @Test
    void testConsignarDineroSobregiroPositivoMayorQueCantidad() {
        cuentaCorriente.sobregiro = 5000f;
        int cantidad = 2000;
        cuentaCorriente.consignarDinero(cantidad);
        assertEquals(0f, cuentaCorriente.saldo, 0.001f);
        assertEquals(3000f, cuentaCorriente.sobregiro, 0.001f);
    }


    @Test
    void testConsignarDineroSobregiroPositivoMenorQueCantidad() {
        cuentaCorriente.sobregiro = 5000f;
        int cantidad = 7000;
        cuentaCorriente.consignarDinero(cantidad);
        assertEquals(2000f, cuentaCorriente.saldo, 0.001f);
    }

    @Test
    void testRetirarDineroCantidadMayorQueSaldo() {
        cuentaCorriente.saldo = 2000f;
        cuentaCorriente.sobregiro = 0f;
        int cantidad = 7000;
        cuentaCorriente.retirarDinero(cantidad);
        assertEquals(5000f, cuentaCorriente.sobregiro, 0.001f);
        assertEquals(0f, cuentaCorriente.saldo, 0.001f);
        assertEquals(1, cuentaCorriente.numRetiros, 0.001f);
    }

    @Test
    void testRetirarDineroCantidadMenorQueSaldo() {
        cuentaCorriente.saldo = 5000f;
        cuentaCorriente.sobregiro = 0f;
        int cantidad = 3000;
        cuentaCorriente.retirarDinero(cantidad);
        assertEquals(0f, cuentaCorriente.sobregiro, 0.001f);
        assertEquals(2000f, cuentaCorriente.saldo, 0.001f);
        assertEquals(1, cuentaCorriente.numRetiros, 0.001f);
    }

    @Test
    void testExtractoMensual() {
        cuentaCorriente.saldo = 10000f;
        cuentaCorriente.extractoMensual();
        assertEquals(10025f, cuentaCorriente.saldo);
    }


    @Test
    void testImprimirCuenta() {
        cuentaCorriente.retirarDinero(1000);
        
        cuentaCorriente.imprimirCuenta();

        assertEquals(  " Saldo: 0.0" +
                "\n Nº Transacciones: 1" +
                "\n Sobregiro: 1000.0$", cuentaCorriente.imprimirCuenta() );
    }

    
}
