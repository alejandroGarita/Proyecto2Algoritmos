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
public class ArbolAVL {

    private NodoAVL raiz;
    private int siguientePocision;
    
    public ArbolAVL(){
        raiz=null;
        siguientePocision=-1;
    }
    
    public boolean insertarNodo(String palabra){
        
        NodoAVL nuevoNodo=new NodoAVL();
        nuevoNodo.setPalabra(palabra);
        nuevoNodo.agregarRepeticion(siguientePocision);
        nuevoNodo.setHijoDerecho(null);
        nuevoNodo.setHijoIzquierdo(null);
        
        NodoAVL temp=raiz;
        
        if(repetido(palabra, siguientePocision)!=true){
        
            if(raiz==null){
                nuevoNodo.setPadre(null);
                raiz=nuevoNodo;
                return true;
            }else {

                while(true){

                    if(palabra.compareTo(temp.getPalabra())<0){

                        if(temp.getHijoIzquierdo()==null){
                            nuevoNodo.setPadre(temp);
                            temp.setHijoIzquierdo(nuevoNodo);
                            calcularFE(raiz);
                            verificarBalanceo(raiz);
                            return true;
                        }else {
                            temp=temp.getHijoIzquierdo();
                        }

                    }else {

                        if(temp.getHijoDerecho()==null){
                            nuevoNodo.setPadre(temp);
                            temp.setHijoDerecho(nuevoNodo);
                            calcularFE(raiz);
                            verificarBalanceo(raiz);
                            return true;
                        }else {
                            temp=temp.getHijoDerecho();
                        }

                    }

                }

            }
        }
        return false;
    }// insertarNodo    
    
    private boolean repetido(String palabra, int pocision){
        NodoAVL temp=raiz;
        
        while(temp!=null){
            if(temp.getPalabra().equals(palabra)){
                temp.agregarRepeticion(pocision);
                return true;
            }else if(palabra.compareTo(temp.getPalabra())<0){
                    temp=temp.getHijoIzquierdo();
            }else temp=temp.getHijoDerecho();
        }
        return false;
    }
    
    public int calcularAltura(NodoAVL nodo){
        if(nodo==null){
            return 0;
        }else return 1+(mayor(calcularAltura(nodo.getHijoIzquierdo()), calcularAltura(nodo.getHijoDerecho())));
        
    }
    
    public int mayor(int a, int b){
        if(a>b)
            return a;
        else return b;
    }
    
    public void calcularFE(NodoAVL nodo){
        if(nodo!=null){
            nodo.setEquilibrio(calcularAltura(nodo.getHijoIzquierdo())-calcularAltura(nodo.getHijoDerecho()));
            calcularFE(nodo.getHijoDerecho());
            calcularFE(nodo.getHijoIzquierdo());
        }
    }
    
    public void balancear(NodoAVL nodo){
        if(nodo.getEquilibrio()>1){
            if(nodo.getHijoIzquierdo().getEquilibrio()<=-1){
                rotacionIzquierda(nodo.getHijoIzquierdo());
                rotacionDerecha(nodo);
            }else rotacionDerecha(nodo);
        }else if(nodo.getEquilibrio()<-1){
                if(nodo.getHijoDerecho().getEquilibrio()>0){
                    rotacionDerecha(nodo.getHijoDerecho());
                    rotacionIzquierda(nodo);
                }else rotacionIzquierda(nodo);
        }
    }
    
    public void verificarBalanceo(NodoAVL temp){
        if(temp!=null){
            balancear(temp);
            verificarBalanceo(temp.getHijoIzquierdo());
            verificarBalanceo(temp.getHijoDerecho());
        }
        calcularFE(raiz);
    }
    
    public void rotacionDerecha(NodoAVL nodo){
        NodoAVL a=nodo.getHijoIzquierdo();
        NodoAVL b=a.getHijoDerecho();
        if(nodo.getPadre()==null){
            a.setHijoDerecho(nodo);
            nodo.setPadre(a);
            nodo.setHijoIzquierdo(b);
            a.setPadre(null);
            if(b!=null)
                b.setPadre(nodo);
            raiz=a;
        }else {
            NodoAVL x=nodo.getPadre();
            if(x.getPalabra().compareTo(a.getPalabra())>0){
                x.setHijoIzquierdo(a);
            }else x.setHijoDerecho(a);
            a.setHijoDerecho(nodo);
            a.setPadre(x);
            nodo.setPadre(a);
            nodo.setHijoIzquierdo(b);
        }calcularFE(raiz);
    }
    
    public void rotacionIzquierda(NodoAVL nodo){
        NodoAVL a=nodo.getHijoDerecho();
        NodoAVL b=a.getHijoIzquierdo();
        if(nodo.getPadre()==null){
            a.setHijoIzquierdo(nodo);
            nodo.setPadre(a);
            nodo.setHijoDerecho(b);
            a.setPadre(null);
            if(b!=null)
                b.setPadre(nodo);
            raiz=a;
        }else {
            NodoAVL x=nodo.getPadre();
            if(x.getPalabra().compareTo(a.getPalabra())>0){
                x.setHijoIzquierdo(a);
            }else x.setHijoDerecho(a);
            a.setHijoIzquierdo(nodo);
            a.setPadre(x);
            nodo.setPadre(a);
            nodo.setHijoDerecho(b);
        }calcularFE(raiz);
    }
//    public String x="";
    public void ImprimirPreOrden(NodoAVL arbol){
        if(arbol!=null){
            System.out.println(arbol.getPalabra()+ " FE "+arbol.getEquilibrio());
//            String repeticiones="";
//            for(int i=0; i<arbol.getRepeticiones().length; i++)
//                repeticiones+=arbol.getRepeticiones()[i]+",";
//            x+=arbol.getPalabra()+"{"+repeticiones+"} FE: "+arbol.getEquilibrio()+"\n";
            ImprimirPreOrden(arbol.getHijoIzquierdo());
            ImprimirPreOrden(arbol.getHijoDerecho());
        }
    }
    
    public String buscarNodo(String palabra){
        char[] vector=palabra.toCharArray();
        NodoAVL temp=raiz;
        
        while(temp!=null){
            char[] vectorNodo=temp.getPalabra().toCharArray();
            int menor;
            String res="";
            if(vector.length<vectorNodo.length)
                menor=vector.length;
            else menor=vectorNodo.length;
            for(int i=0; i<menor; i++){
                if(vector[i]!=vectorNodo[i])
                    break;
                else res+=vectorNodo[i];
            }
            if(res.equals(palabra)){
                return temp.getPalabra();
            }else if(palabra.compareTo(temp.getPalabra())<0){
                    temp=temp.getHijoIzquierdo();
            }else temp=temp.getHijoDerecho();
        }
        return "No se encontro la palabra";
    }

    public NodoAVL getRaiz() {
        return raiz;
    }

    public int getSiguientePocision() {
        return siguientePocision;
    }

    public void setSiguientePocision(int siguientePocision) {
        this.siguientePocision = siguientePocision;
    }
    
    
    
    
}// ArbolAVL
