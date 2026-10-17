package main;

import model.*;
import visitor.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Calculadora de ventas Wtech ===");

        Pedido pedido = new Pedido();
        pedido.agregar(new Tablet(), 2);
        pedido.agregar(new Portatil(), 1);
        pedido.agregar(new ComputadoraTorre(), 1);
        pedido.agregar(new Television(), 1);

        Visitante subtotalV = new CalculadorSubtotalVisitor();
        pedido.aceptar(subtotalV);
        double subtotal = subtotalV.getResultado();

        Visitante envioV = new CalculadorEnvioVisitor();
        pedido.aceptar(envioV);
        double envio = envioV.getResultado();

        System.out.printf("Subtotal: $%.0f%n", subtotal);
        System.out.printf("Envio:    $%.0f%n", envio);
        System.out.printf("Total:    $%.0f%n", subtotal + envio);

        System.out.println("\n--- Pedido vacio ---");
        Pedido vacio = new Pedido();
        Visitante s2 = new CalculadorSubtotalVisitor();
        Visitante e2 = new CalculadorEnvioVisitor();
        vacio.aceptar(s2);
        vacio.aceptar(e2);
        System.out.printf("Subtotal: $%.0f | Envio: $%.0f | Total: $%.0f%n",
                s2.getResultado(), e2.getResultado(), s2.getResultado() + e2.getResultado());

        System.out.println("\n--- Cantidad invalida ---");
        try {
            pedido.agregar(new Tablet(), 0);
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
