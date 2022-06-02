/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palabrasdavidcharry;

import java.util.Scanner;

/**
 *
 * @author mono-
 */
public class PalabrasDavidCharry {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int opcion = 0;
        do {
            System.out.println("\u001B[31m---Menu---");
            System.out.println("1. Palabra limitada");
            System.out.println("2. Palabra con mayúscula final");
            System.out.println("3. Contar palabras");
            System.out.println("4. Palabra con número");
            System.out.println("5. Palabra con símbolo");
            System.out.println("6. Salir");
            System.out.println("\u001B[31mIngrese la opción:");
            opcion = Integer.parseInt(sc.next());
            switch (opcion) {
                case 1: {
                    if (validarPalabraLimitada() == true) {
                        System.out.println("\u001B[31mPalabra correcta.");
                    } else {
                        System.out.println("\u001B[31mLa palabra no cumple con los criterios.");
                    }
                    break;
                }
                case 2: {
                    if (validarMayusculaFinal() == true) {
                        System.out.println("\u001B[31mPalabra correcta");
                    } else {
                        System.out.println("\u001B[31mLa palabra no cumple con los criterios");
                    }
                    break;
                }
                case 3: {
                    System.out.println("\u001B[31mLa frase ingresada tiene " + contarPalabras() + " palabras.");
                    break;
                }
                case 4: {
                    if (validarPalabraConNumero() == true) {
                        System.out.println("\u001B[31mPalabra correcta");
                    } else {
                        System.out.println("\u001B[31mLa palabra no cumple con los criterios.");
                    }
                    break;
                }
                case 5: {
                    if (validarPalabraConSímbolo() == true) {
                        System.out.println("\u001B[31mPalabra correta.");
                    } else {
                        System.out.println("\u001B[31mLa palabra no cumple con los criterios");
                    }
                    break;
                }
                case 6: {
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("\u001B[31mOpcion no disponible");
            }
        } while (opcion != 0);
    }

    public static Boolean validarPalabraLimitada() {
        sc.nextLine();
        System.out.println("\u001B[31mIngrese una palabra:");
        String palabra = sc.nextLine();
        int cantidadCaracteres = palabra.length();
        System.out.println("cantidad: " + cantidadCaracteres);
        if (cantidadCaracteres >= 7) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean validarMayusculaFinal() {
        sc.nextLine();
        System.out.println("\u001B[31mIngrese una palabra con la ultima letra en mayúscula:");
        String palabra = sc.nextLine();
        char[] arregloPalabra = palabra.toCharArray();
        boolean ultimaLetra = false;
        boolean primeraLetra = true;

        for (int i = 0; i < arregloPalabra.length; i++) {
            if (i == (arregloPalabra.length - 1)) {
                if (Character.isUpperCase(arregloPalabra[i]) == true) {
                    ultimaLetra = true;
                }
            }
            if (i < (arregloPalabra.length - 1)) {
                if (Character.isLowerCase(arregloPalabra[i]) == false) {
                    primeraLetra = false;
                }
            }
        }
        if (ultimaLetra == true && primeraLetra == true) {
            return true;
        } else {
            return false;
        }
    }

    public static int contarPalabras() {
        sc.nextLine();
        System.out.println("\u001B[31mIngrese una frase");
        String frase = sc.nextLine();
        String[] palabras = frase.split(" ");
        return palabras.length;
    }

    public static boolean validarPalabraConNumero() {
        sc.nextLine();
        System.out.println("\u001B[31mIngrese una palabra que tenga al menos un número");
        String palabra = sc.nextLine();
        char[] arregloPalabra = palabra.toCharArray();
        for (int i = 0; i < arregloPalabra.length; i++) {
            if (arregloPalabra[i] >= 48 && arregloPalabra[i] <= 57) {
                return true;
            }
        }
        return false;
    }

    public static Boolean validarPalabraConSímbolo() {
        sc.nextLine();
        System.out.println("\u001B[31mIngrese una palabra que tenga al menos uno de estos simbolos (&,@,#): ");
        String palabra = sc.nextLine();
        char[] arregloPalabra = palabra.toCharArray();
        for (int i = 0; i < arregloPalabra.length; i++) {
            if (arregloPalabra[i] == 35 || arregloPalabra[i] == 38 || arregloPalabra[i] == 64) {
                return true;
            }
        }
        return false;
    }
}
