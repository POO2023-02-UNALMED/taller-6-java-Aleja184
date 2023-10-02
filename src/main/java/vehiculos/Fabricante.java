package vehiculos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Fabricante {
    private String nombre;
    private Pais pais;
    private static ArrayList<Pais> paises = new ArrayList<Pais>();

    Fabricante(String nombre,Pais pais){
        this.nombre = nombre;
        this.pais = pais;
        Fabricante.paises.add(pais);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
    public static ArrayList<Pais> getPaises() {
        return Fabricante.paises;
    }

    public static Fabricante fabricaMayorVentas(){
        ArrayList<Fabricante> fabricantes = Automovil.getFabricantes();
        Map<Fabricante,Integer> fabricantesCount = new HashMap<>();
        for(Fabricante fabricante : fabricantes){
            if(!fabricantesCount.containsKey(fabricante)){
                fabricantesCount.put(fabricante,1);
            }else{
                int valor = fabricantesCount.get(fabricante);
                fabricantesCount.put(fabricante,valor++);
            }
        }
        
        int valor = 0;
        Fabricante fabricanteReturn = fabricantes.get(0);
        for(Fabricante fabricante : fabricantesCount.keySet()){
            int valorFabricante = fabricantesCount.get(fabricante);
            if(valorFabricante>valor){
                valor = valorFabricante;
                fabricanteReturn = fabricante;
            }       
        }
        return fabricanteReturn;
    }
}
