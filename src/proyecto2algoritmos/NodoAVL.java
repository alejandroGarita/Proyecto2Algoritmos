/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2algoritmos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
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
    
    private int x;
    
    private int y;
    
    public NodoAVL() {
        palabra="";
        hijoDerecho=null;
        hijoIzquierdo=null;
        padre=null;
        equilibrio=0;
        repeticiones=new int[0];
        x=0; 
        y=0;
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

    public void draw(Graphics2D g2, int x, int y){
        this.x=x;
        this.y=y;
        
        if(hijoIzquierdo!=null)
            g2.drawLine(x, y, hijoIzquierdo.getX(), hijoIzquierdo.getY());
        if(hijoDerecho!=null)
            g2.drawLine(x, y, hijoDerecho.getX(), hijoDerecho.getY());
//        g2.setColor(Color.white);
//        g2.drawRect(x-20, y-30, 50, 50);
        g2.setColor(Color.black);
        g2.setFont(new Font("Monospace", Font.BOLD, 18));
        g2.drawString(this.palabra, this.x, this.y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}// NodoAVL
