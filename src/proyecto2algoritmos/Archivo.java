/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2algoritmos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Alejandro
 */
public class Archivo {
    
    private File file;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    
    private String arbolTxt;
    private int cont;
    
    public Archivo(File file) throws FileNotFoundException{
        this.file=file;
    }
    
    public String verTexto() throws FileNotFoundException, IOException{
        fileReader=new FileReader(file);
        bufferedReader=new BufferedReader(fileReader);
        
        String linea;
        String texto="";
        while((linea=bufferedReader.readLine())!=null){
           texto+=linea+"\n";
        }// while
        bufferedReader.close();
        fileReader.close();
        return texto;
    }
    
    public ArbolAVL leerArchivo(ArbolAVL avl) throws FileNotFoundException, IOException{
        fileReader=new FileReader(file);
        bufferedReader=new BufferedReader(fileReader);
        
        String linea;
        String []vector;
        while((linea=bufferedReader.readLine())!=null){
           vector=linea.split(" ");
           for(int i=0; i<vector.length; i++){
               avl.setSiguientePocision(avl.getSiguientePocision()+1);
               avl.insertarNodo(vector[i]);
           }
        }// while
        bufferedReader.close();
        fileReader.close();
        
        return avl;
    }
    
    public void guardarArbolAVL(ArbolAVL avl) throws FileNotFoundException, IOException{
        FileWriter fileWriter=new FileWriter(file+".txt");
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
        
        arbolTxt="";
        verPalabraNodo(avl.getRaiz());
        bufferedWriter.write(arbolTxt);
        bufferedWriter.close();
        fileWriter.close();
    }
    
    public void verPalabraNodo(NodoAVL nodo){
        if(nodo!=null){
            String repeticiones="";
            for(int i=0; i<nodo.getRepeticiones().length; i++)
                repeticiones+=" "+nodo.getRepeticiones()[i];
            arbolTxt+=nodo.getPalabra()+repeticiones+",,";
            verPalabraNodo(nodo.getHijoIzquierdo());
            verPalabraNodo(nodo.getHijoDerecho());
        }
    }
    
    public ArbolAVL cargarArbolAVL() throws FileNotFoundException, IOException{
        ArbolAVL avl=new ArbolAVL();
        fileReader=new FileReader(file);
        bufferedReader=new BufferedReader(fileReader);
        
        String linea;
        String []vector;
        String palabra[];
        while((linea=bufferedReader.readLine())!=null){
           vector=linea.split(",,");
           for(int i=0; i<vector.length; i++){
               palabra=vector[i].split(" ");
               for(int j=1; j<palabra.length; j++){
                   avl.setSiguientePocision(Integer.parseInt(palabra[j]));
                   avl.insertarNodo(palabra[0]);
               }
           }
        }// while
        bufferedReader.close();
        fileReader.close();
        
        return avl;
    }
    
    public void guardarTexto(ArbolAVL avl) throws IOException{
        arbolTxt="";
        cont=0;
        int fin=avl.getSiguientePocision();
        while(cont<=fin){
            ordenarTexto(avl.getRaiz());
        }
        
        FileWriter fileWriter=new FileWriter(file+".txt");
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
        bufferedWriter.write(arbolTxt);
        bufferedWriter.close();
        fileWriter.close();
    }
    
    public void ordenarTexto(NodoAVL nodo){
        if(nodo!=null){
            for(int i=0; i<nodo.getRepeticiones().length; i++){
                if(nodo.getRepeticiones()[i]==cont){
                    arbolTxt+=nodo.getPalabra()+" ";
                    cont++;
                }
            }
            ordenarTexto(nodo.getHijoIzquierdo());
            ordenarTexto(nodo.getHijoDerecho());
        }
    }
    
            
    public String verTextoArbol(ArbolAVL avl){
        arbolTxt="";
        cont=0;
        int fin=avl.getSiguientePocision();
        while(cont<=fin){
            ordenarTexto(avl.getRaiz());
        }
        return arbolTxt;
    }// verTextoArbol
            
}// Archivo
