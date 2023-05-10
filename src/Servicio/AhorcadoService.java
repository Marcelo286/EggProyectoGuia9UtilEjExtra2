package Servicio;

import java.util.Scanner;


public class AhorcadoService {
    
    private String palabra;
    private int jugadasMaximas;
    private int jugadasRestantes;
    private char[] letrasEncontradas;
    private boolean[] letrasEncontradasBoolean;

    public void crearJuego() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingresar palabra a adivinar: ");
        palabra = scanner.nextLine();
        System.out.print("Ingresar cantidad de jugadas permitidas: ");
        jugadasMaximas = scanner.nextInt();
        jugadasRestantes = jugadasMaximas;
        letrasEncontradas = new char[palabra.length()];
        letrasEncontradasBoolean = new boolean[palabra.length()];
        
        for (int i = 0; i < palabra.length(); i++) {
            letrasEncontradas[i] = '_';
            letrasEncontradasBoolean[i] = false;
        }
    }

    public void longitud() {
        System.out.println("La longitud de la palabra es: " + palabra.length());
        
    }

    public boolean buscar(char letra) {
        boolean encontrada = false;
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == letra) {
                encontrada = true;
                letrasEncontradas[i] = letra;
                letrasEncontradasBoolean[i] = true;
            }
        }
        if (!encontrada) {
        }
        return encontrada;
    }

    public void encontradas(char letra) {
        int encontradas = 0;
        int faltan = 0;
        for (int i = 0; i < palabra.length(); i++) {
            if (letrasEncontradasBoolean[i]) {
                encontradas++;
            } else {
                faltan++;
            }
        }
        System.out.println("Letras encontradas: " + encontradas);
        System.out.println("Letras faltantes: " + faltan);
    }

    public void intentos() {
        System.out.println("Jugadas restantes: " + jugadasRestantes);
        jugadasRestantes--;
    }
    

    public void juego() {
        crearJuego();
        while (jugadasRestantes > 0) {
            System.out.println(letrasEncontradas);
            System.out.println("Ingresar letra: ");
            Scanner scanner = new Scanner(System.in);
            char letra = scanner.next().charAt(0);
            if (buscar(letra)) {
                System.out.println("La letra esta en la palabra.");
                if (!String.valueOf(letrasEncontradas).contains("_")) {
                    System.out.println("*************");
                    System.out.println("* Ganaste!! *");
                    System.out.println("*************");
                    break;
                }
            } else {
                System.out.println("La letra NO figura en la palabra.");
                intentos();
                if (jugadasRestantes == 0) {
                    System.out.println("-Perdiste!-");
                    break;
                }
            }
            encontradas(letra);
            intentos();
        }
    }

}

    

