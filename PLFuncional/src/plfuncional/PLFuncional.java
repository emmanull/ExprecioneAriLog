
package plfuncional;

import java.awt.BorderLayout;
import static java.lang.Thread.State.NEW;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author erixq
 */
public class PLFuncional {
    static JPanel pPrincipal;

    public static void main(String[] args) {
        /* Ventana();
    }
        
        public static void Ventana()
        {
            JFrame f=new JFrame();
            f.setDefaultLookAndFeelDecorated(true);
            
            
            f.setSize(600,400);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            pPrincipal=new JPanel();
            f.setContentPane(pPrincipal);
            pPrincipal.setLayout(new BorderLayout());
            
            f.setVisible(true);
            
            
        }
            
            */ Scanner leer = new Scanner(System.in);
		
		boolean continuar = true;
		int opcion;
		
		while(continuar) {
			System.out.println("");
			System.out.println("********************");
			System.out.println("1.- Expresión aritmética");
			System.out.println("2.- Expresión lógica");
			System.out.println("3.- Expresión lógica V2");
			System.out.println("4.- Salir");
			opcion = leer.nextInt();
			
			switch (opcion) {
			case 1:
				ExpresionAritmetica inst = new ExpresionAritmetica();
                               
                                   

                                
				//Aquí vamos a mandar a llamar el método de expresión aritmética
				break;

			case 2:
				ExpresionLogica insta = new ExpresionLogica("[(p->q)^p]->q");
                                 insta.resolver();
				
				
				break;

			case 3:
				SepararCNL CNL=new SepararCNL();
                                CNL.numeroscaracteres();
				/*
				 * "gh9j385ht49h2h4982hr27f2938fh249fh"
				 * 
				 *SOUT("Las letras en la cadena son las siguientes:")
				 *  jkdjdfnwefnwfnewofwen
				 *  
				 *  SOUT("y son " X " cantidad de caracteres")
				 *  
				 *  SOUT("Los números en la cadena son los siguientes:")
				 *  9837983759837958
				 *  SOUT("y son " X " cantidad de números")
				 *  
				 */
				
				//Aquí vamos a mandar a llamar el método de expresión lógica v2
				break;
			
			case 4:
				continuar = false;
				break;
	
			default:
				System.out.println("La opción que elegiste no es la correcta, favor de verificar.");
				break;
			}
		
		
	}
                }
    }

