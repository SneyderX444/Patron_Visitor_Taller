package visitor;

import model.ComputadoraTorre;
import model.Portatil;
import model.Producto;
import model.Tablet;
import model.Television;

public class CalculadorEnvioVisitor implements Visitante {
    private double envio = 0;

    private void sumar(Producto p) {
        double porcentajeEnvio = (p.getPesoGramos() / 100.0) * 2;
        envio += p.getPrecio() * porcentajeEnvio / 100.0;
    }

    @Override public void visitar(Tablet tablet) { sumar(tablet); }
    @Override public void visitar(Portatil portatil) { sumar(portatil); }
    @Override public void visitar(ComputadoraTorre torre) { sumar(torre); }
    @Override public void visitar(Television television) { sumar(television); }

    @Override
    public double getResultado() {
        return envio;
    }
}
