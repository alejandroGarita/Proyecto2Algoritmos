/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2algoritmos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Alejandro
 */
public class Archivo {
    
    private File file;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    
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
        int pocision=0;
        while((linea=bufferedReader.readLine())!=null){
           vector=linea.split(" ");
           for(int i=0; i<vector.length; i++){
               avl.insertarNodo(vector[i], pocision);
               pocision++;
           }
        }// while
        bufferedReader.close();
        fileReader.close();
        
        return avl;
    }
    
    
    
    
}// Archivo
