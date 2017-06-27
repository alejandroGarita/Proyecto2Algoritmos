/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2algoritmos;

/**
 *
 * @author Alejandro
 */
public class NodoAVL {
    
    private String palabra;
    
    private NodoAVL hijoDerecho;
    private NodoAVL hijoIzquierdo;
    
    private NodoAVL padre;

    private int equilibrio;

    private int[] repeticiones;
    
    public NodoAVL() {
        palabra="";
        hijoDerecho=null;
        hijoIzquierdo=null;
        padre=null;
        equilibrio=0;
        repeticiones=new int[0];
    }
    
    public void agregarRepeticion(int pocision){
        int[] repeticionesNuevas=new int[repeticiones.length+1];
        for(int i=0; i<repeticiones.length; i++){
            repeticionesNuevas[i]=repeticiones[i];
        }
        repeticionesNuevas[repeticiones.length]=pocision;
        repeticiones=repeticionesNuevas;
    }
    
    public int[] getRepeticiones(){
        return repeticiones;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public NodoAVL getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(NodoAVL hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public NodoAVL getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(NodoAVL hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public int getEquilibrio() {
        return equilibrio;
    }

    public void setEquilibrio(int equilibrio) {
        this.equilibrio = equilibrio;
    }

    public NodoAVL getPadre() {
        return padre;
    }

    public void setPadre(NodoAVL padre) {
        this.padre = padre;
    }

    
}// NodoAVL
