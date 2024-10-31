package co.unicauca.edu.conferencia_microservicio.App;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import co.unicauca.edu.conferencia_microservicio.AccesoADatos.Repositorio.IRepositorioConferencia;
import co.unicauca.edu.conferencia_microservicio.AccesoADatos.modelos.Articulo;
import co.unicauca.edu.conferencia_microservicio.AccesoADatos.modelos.Conferencia;

@Component
public class Inicializador implements CommandLineRunner {
    @Autowired
    private IRepositorioConferencia repositorio;
    @Override
    public void run(String...args)throws Exception{
    List<Articulo> listaArticulos1 = new ArrayList<>();
    Articulo art1= new Articulo(1);
    Articulo art2= new Articulo(2);
    Articulo art3= new Articulo(3);

    listaArticulos1.add(art1);
    listaArticulos1.add(art2);
    listaArticulos1.add(art3);

    Conferencia objConferencia1= new Conferencia(1, "Conferencia Harry Potter",20, listaArticulos1);
    repositorio.save(objConferencia1);

    ArrayList<Articulo> listaArticulos2 = new ArrayList<Articulo>();
    Articulo art4= new Articulo(4);
    Articulo art5= new Articulo(5);
    Articulo art6= new Articulo(6);

    listaArticulos1.add(art4);
    listaArticulos1.add(art5);
    listaArticulos1.add(art6);

    Conferencia objConferencia2= new Conferencia(2, "SCRUM ", 20, listaArticulos2);
    repositorio.save(objConferencia2);

    ArrayList<Articulo> listaArticulos3 = new ArrayList<Articulo>();
    Articulo art7= new Articulo(7);
    Articulo art8= new Articulo(8);
    Articulo art9= new Articulo(9);

    listaArticulos1.add(art7);
    listaArticulos1.add(art8);
    listaArticulos1.add(art9);
    Conferencia objConferencia3= new Conferencia(3, "Arquitectura Hexagonal", 20, listaArticulos3);
    repositorio.save(objConferencia3);

    }
    
}
