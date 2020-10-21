/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plfuncional;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author erixq
 */
public class ExpresionLogica {
				/*
				 * 
				 * [(p->q)^p]->q
				 * [a^p]->q
				 * b->q
				 * 
				 * Método de insertar a arreglo correspondiente
				 * [a^p]->q
				 * b->q
				 * 
				 * p q	(p->q)	^	p	->	q
				 * V V	   V	V		V	V
				 * V F	   F	F		V	F
				 * F V	   V	F 		V	V
				 * F F	   V	F		V	F
				 * 
				 */
				//Aquí vamos a mandar a llamar el método de expresión lógica
 Stack pila = new Stack();
    Stack pilaOperaciones = new Stack();
    private Stack b = new Stack();
    private String a[];

    public ExpresionLogica(String expresion) {
        String c=expresion;
        String oper = "(?=[q|^()\\[\\]])|(?<=[\\[\\]^()p])";
        a = c.split(oper);
    }

    public String resolver() {
        List lista = InsertarEnPila(a);
        String a = realizarOperaciones(lista);
        return a;
    }

   

    private List InsertarEnPila(String arreglo[]) {
        List cadena = new ArrayList();
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i].equals("p") || arreglo[i].equals("q")) {
                cadena.add(arreglo[i]);
                if (i == arreglo.length - 1) {
                    while (!pilaOperaciones.empty()) {
                        cadena.add(pilaOperaciones.peek());
                        pilaOperaciones.pop();
                    }
                }
            } else {
                int prioridad = prioridad(arreglo[i]);
                switch (prioridad) {
                    case 0:
                        if (!pilaOperaciones.empty()) {
                            int prioridadpila = prioridad((String) pilaOperaciones.peek());
                            if (prioridad == prioridadpila) {
                                cadena.add(pilaOperaciones.peek());
                                pilaOperaciones.pop();
                            }
                        }
                        pilaOperaciones.push(arreglo[i]);
                        break;
                    case 1:
                        pilaOperaciones.push(arreglo[i]);
                        break;
                    case 2:
                        while (!pilaOperaciones.empty()) {
                            if (pilaOperaciones.peek().equals("(")) {
                                pilaOperaciones.pop();
                                break;
                            }
                            cadena.add(pilaOperaciones.peek());
                            pilaOperaciones.pop();
                        }
                        break;
                    case 3:
                        pilaOperaciones.push(arreglo[i]);
                        break;
                    case 4:
                        while (!pilaOperaciones.empty()) {
                            if (pilaOperaciones.peek().equals("[")) {
                                pilaOperaciones.pop();
                                break;
                            }
                            cadena.add(pilaOperaciones.peek());
                            pilaOperaciones.pop();
                        }
                        break;
                }
            }
        }
        //System.out.println(cadena);
        return cadena;
    }

    private int prioridad(String s) {
        if (s.equals("->") || s.equals("^")) {
            return 0;
        } else if (s.equals("(")) {
            return 1;
        } else if (s.equals(")")) {
            return 2;
        } else if (s.equals("[")) {
            return 3;
        } else if (s.equals("]")) {
            return 4;
        }
        return -1;
    } //Fin de la funcion prioridad

    private String realizarOperaciones(List lista) {
        boolean p = true, q = true, resultado = true;
        String operador, tabla = "";
        boolean pq[] = {true, true, true, false, false, true, false, false};

        for (int i = 0; i < pq.length - 1; i = i + 2) {
            tabla = pq[i] + "   " + pq[i + 1];

            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).equals("p")) {
                    pila.push(pq[i]);
                } else if (lista.get(j).equals("q")) {
                    pila.push(pq[i + 1]);
                } else {
                    operador = (String) lista.get(j);

                    q = Boolean.parseBoolean(pila.pop().toString());
                    p = Boolean.parseBoolean(pila.pop().toString());

                    switch (operador) {
                        case "^":
                            resultado = p & q;
                            tabla = tabla + "  " + resultado;
                            pila.push(resultado);
                            break;
                        case "->":
                            if (p && !q) {
                                resultado = false;
                            } else {
                                resultado = true;
                            }
                            tabla = tabla + "  " + resultado;
                            pila.push(resultado);
                            break;
                    }
                }
            }
            System.out.println(tabla);
        }
        return tabla;
    }
    
     private boolean isNumeric(String cadena) {
        try {
            double d = Double.parseDouble(cadena);

        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

}
