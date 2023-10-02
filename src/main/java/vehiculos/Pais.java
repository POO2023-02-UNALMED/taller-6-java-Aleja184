package vehiculos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Pais {
    private String nombre;
    Pais(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public static Pais paisMasVendedor(){
        ArrayList<Pais> paises = Fabricante.getPaises();
        Map<Pais,Integer> paisesCount = new HashMap<>();
        for(Pais pais : paises){
            if(!paisesCount.containsKey(pais)){
                paisesCount.put(pais, 1);
            }else{
                int valor = paisesCount.get(pais);
                paisesCount.put(pais,valor++ );
            }
        }
        int valor=0;
        Pais paisReturn = paises.get(0);
        for(Pais pais: paisesCount.keySet()){
            int valorPais= paisesCount.get(pais);
            if(valorPais>valor){
                valor = valorPais;
                paisReturn = pais;
            }
        }
        return paisReturn;
    }
}
