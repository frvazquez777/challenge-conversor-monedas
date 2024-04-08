import servicios.ApiMoneda;
import servicios.ApiResponse;
import servicios.ConversionRates;

import java.lang.reflect.Field;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        menu();

        System.out.print("Elija una opción Válida: ");
        if (teclado.hasNextInt()) {
            int opcion = teclado.nextInt();

            while (opcion != 7) {
                if(opcion <1 && opcion > 7){
                    System.out.println("Opción NO Permitida.");
                } else {
                    ProcesoConversion(opcion);

                    System.out.print("\n\n¿Deseas realizar otra conversión? (Y/N): ");
                    Scanner confirmar = new Scanner(System.in);

                    String continuar = confirmar.nextLine();
                    System.out.println("\n\n");

                    if("n".equalsIgnoreCase(continuar)){
                        opcion=7;
                    } else {
                        menu();
                        System.out.print("Elija una opción Válida: ");
                        opcion = teclado.nextInt();
                    }


                }
            }

        } else {
            System.out.println("Opción Invalidad");
        }

        System.out.println("Gracias, Vuelva Pronto...");

    }

    private static void ProcesoConversion(int opcion) {
        String monedaOrigen ="USD";
        String monedaDestino ="ANG";

        switch (opcion){
            case 1:
                monedaOrigen = "USD";
                monedaDestino="ANG";
                break;
            case 2:
                monedaOrigen = "ANG";
                monedaDestino="USD";
                break;
            case 3:
                monedaOrigen = "USD";
                monedaDestino="MXN";
                break;
            case 4:
                monedaOrigen = "MXN";
                monedaDestino="USD";
                break;
            case 5:
                monedaOrigen = "USD";
                monedaDestino="CLP";
                break;
            case 6:
                monedaOrigen = "CLP";
                monedaDestino="USD";
                break;
        }

        Scanner cantidad = new Scanner(System.in);
        System.out.print("\n\nIngresa el valor que deseas convertir: ");
        if(cantidad.hasNextDouble()) {
            double valor = cantidad.nextDouble();
            ApiMoneda api = new ApiMoneda();
            ApiResponse respuesta =   api.getResultado(monedaOrigen);

            if(respuesta != null){

                double cantidarConvertidad = respuesta.getConversion_rates().getValorCampo(monedaDestino);

                String resultado = "La cantidad: "+valor+" "+monedaOrigen+
                        " Corresponde a "+(cantidarConvertidad*valor)+" "+monedaDestino;
                System.out.println("\n\n\n");
                System.out.println(resultado);

            } else {
                System.out.println("Error al Convertir, Intente Nuevamente más Tarde.");
            }

        } else {
            System.out.println("Valor de Entrada Incorrector.");

        }
    }


    private static void menu() {
        System.out.println("*******************************************");
        System.out.println("Bienvenido al Converso de Moneda :D");
        System.out.println();
        System.out.println("1.- Dolar =>> Peso Agertino");
        System.out.println("2.- Peso Agertino =>>> Dolar");
        System.out.println("3.- Dolar =>> Peso Mexicano");
        System.out.println("4.- Peso Mexicano =>> Dolar");
        System.out.println("5.- Dolar =>> Peso Colombiano");
        System.out.println("6.- Peso Colombiano =>> Dolar");//USA, MXN, CLP
        System.out.println("7.- Salir");
        System.out.println();
        System.out.println("*******************************************");

    }

}