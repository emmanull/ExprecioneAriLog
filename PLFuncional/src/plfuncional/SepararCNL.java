
package plfuncional;

/**
 *
 * @author erixq
 */
class SepararCNL {
    String aux;
   
    public void numeroscaracteres(){
         int x = 0;
    
        
        String cadena="dddhh464djdj8484jffff";
       
        
        char[] cadenadiv=cadena.toCharArray();
        String n="";
         String n1="";
        for(x=0;x<cadenadiv.length;x++){
             if(Character.isAlphabetic(cadenadiv[x])){
                n+=cadenadiv[x];
            }
               if(Character.isDigit(cadenadiv[x])){
                n1+=cadenadiv[x];
            }
           
            
             
            
        
    }
        System.out.println("Los caracteres son: "+n+" y son "+n.length()+" caracteres");
        
                System.out.print("Los numeros son: "+n1+" y son "+n1.length()+" numeros");
        
        
       
        
        

        
    }
    
}
