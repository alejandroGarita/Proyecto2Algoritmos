/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2algoritmos;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Alejandro
 */
public class Panel extends JPanel{
    
    private ArbolAVL avl;
    private int ancho;
    private int alto;
    private int x;
    private int y;
    
    public Panel(ArbolAVL avl){
        this.ancho=1500;
        this.alto=1000;
        this.setSize(ancho,alto);
        this.setLayout(null);
        this.avl=avl;
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        repaint();
        Graphics2D g2=(Graphics2D)g;
        if(avl.getRaiz()!=null){
//             System.out.println(calculaCantidadHijos(avl.getRaiz()));
            this.y=30;
            this.x=0;
            draw(g2);
        }
    }
    
    public void draw(Graphics2D g2){
        x=(calculaCantidadHijos(avl.getRaiz())/2)*50;
        dibujarArbol(g2, avl.getRaiz(), x, y);
    }
    
    public void dibujarArbol(Graphics2D g2, NodoAVL nodo, int x, int y){
        if(nodo!=null){
            nodo.draw(g2, x, y);
            x=nodo.getX()-50-(calculaCantidadHijos(nodo.getHijoIzquierdo())/2)*50;
            dibujarArbol(g2,nodo.getHijoIzquierdo(),x, y+40);
            x=nodo.getX()+50+(calculaCantidadHijos(nodo.getHijoDerecho())/2)*50;
            dibujarArbol(g2, nodo.getHijoDerecho(),x,y+40);
        }
    }
    
    
    public void setAvl(ArbolAVL avl){
        this.avl=avl;
//        repaint();
    }// setAvl

    public int calculaCantidadHojas(int altura){
        if(altura<=1)
            return 0;
        if(altura==2)
            return 2;
        else return calculaCantidadHojas(altura-1)*2;
    }
    
    public int calculaCantidadHijos(NodoAVL nodo){
        int x=0;
        if(nodo!=null){
            int hojas=calculaCantidadHojas(avl.calcularAltura(nodo));
            while(hojas>=2){
                x=x+hojas;
                hojas=hojas/2;
            }
        }
        return x;
    }
    
}// Panel
