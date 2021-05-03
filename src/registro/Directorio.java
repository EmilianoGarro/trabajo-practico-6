/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registro;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Emiliano
 */
public class Directorio {
   /*Un directorio telefónico posee una lista de Clientes de los que interesa conocer su dni, 
    nombre, apellido, ciudad y dirección. El directorio está compuesto por el número de teléfono
    y los datos del Cliente (Directorio: <teléfono,Cliente>, donde el teléfono no es un atributo 
    del cliente. Cuando agendamos un cliente al directorio telefónico lo agendamos con su 
    número de teléfono, que es único)*/
    private TreeMap<Long,Cliente>guia = new TreeMap<>();
    
    public Directorio(){}
    /*● agregarCliente() que permite registrar un nuevo cliente con su respectivo nro de 
    teléfono. Siendo el nro del teléfono la clave del mismo.*/ 
    public boolean agregarCliente(long telefono,Cliente cliente){
    this.guia.put(telefono, cliente);
    return this.guia.containsKey(telefono);
    }
    /*● buscarCliente() que en base al nro de teléfono retorna el Cliente asociado al 
    mismo*/
    public Cliente buscarCliente(long telefono){
    return this.guia.get(telefono);
    }
    /*● buscarTeléfono() que en base a un apellido nos devuelve una lista con los nros de 
    teléfono asociados a dicho apellido.*/ 
    public Set<Long> buscarTelefono(String apellido){
        Set<Long> auxTelefono = new HashSet<>();
      Set <Long> auxSet = guia.keySet();
      Iterator it=auxSet.iterator();
      while(it.hasNext()){
       long auxA=(long) it.next();
          if(guia.get(auxA).getApellido().equals(apellido)){
         auxTelefono.add(auxA);
          }   
         }
    return auxTelefono;  
}
    /*● buscarClientes() que en base a una ciudad nos devuelve una lista con los Clientes 
    asociados a dicha ciudad.*/
    public Set<Cliente> buscarClientes(String ciudad){
        Set<Cliente> auxCliente = new HashSet<>();
        Set <Long> auxSet = guia.keySet();
        Iterator it=auxSet.iterator();
        while(it.hasNext()){
        long auxA=(long)it.next();
            if(guia.get(auxA).getCiudad().equals(ciudad)){
            auxCliente.add(guia.get(auxA));
            }
        
        }
    return auxCliente;
    }
    /*● borrarCliente() que en base a un dni elimina el cliente del directorio.*/ 
    public TreeMap<Long,Cliente> borrarCliente(long dni){
        TreeMap<Long,Cliente> auxCliente=new TreeMap<>();
        Set <Long> auxSet2 = new HashSet<>();
        Set <Long> auxSet = guia.keySet();
        Iterator it = auxSet.iterator();
        while(it.hasNext()){
        long auxA = (long)it.next();
            if(guia.get(auxA).getDni()==dni){
            auxCliente.put(auxA,guia.get(auxA));
            auxSet2.add(auxA);
            }
        }
        Iterator it2 = auxSet2.iterator();
       while(it2.hasNext()){
       long auxA=(long)it2.next();
           guia.remove(auxA);
       }
        
        return auxCliente;
    }
    public boolean clienteExistente(long telefono){
    return guia.containsKey(telefono);
    }
}

