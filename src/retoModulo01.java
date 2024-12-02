import java.util.Scanner;

public class retoModulo01 {

    //constantes para los planetas
    private static final String[] PLANETAS = { "Marte", "Júpiter", "Saturno", "Venus", "Neptuno" };
    private static final double[] DISTANCIAS = { 225.0, 778.0, 1429.0, 556.32, 884.25 }; // Distancias en millones de km
    private static final String[] DESCRIPCIONES_PLANETAS = {
            "Es el cuarto planeta del sistema solar.",
            "Es el planeta más grande del sistema solar.",
            "Es conocido por sus impresionantes anillos.",
            "Es el planeta mas frio del sistema solar, lleve ruana.",
            "Es el planeta mas lejano del sol, 30 veces mas lejos que la tierra."
    };

    // Constantes para las naves espaciales
    private static final String[] NAVES = { "Alcerina, reserva de oxigeno 1000 Litros, combustible 10 Galones",
            "La ruidosa, reserva de oxigeno 3000 Litros, combustible 30 Galones",
            "Silent Hills, reserva de oxigeno 5000 Litros, combustible 100 Galones" };
    private static final double[] VELOCIDADES = { 30.0, 50.0, 70.0 }; // Velocidades en millones de km

    // Variables para la selección del usuario
    private static int planetaSeleccionado = -1;
    private static int naveSeleccionada = -1;
    private static int cantidadPasajeros = 1;   

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        //ciclo
        while (!salir) { 
            mostrarMenu();
            int opcion = scanner.nextInt();
            //sentencia
            switch (opcion) {
                case 1:
                    seleccionarPlaneta(scanner);
                    break;
                case 2:
                    seleccionarNave(scanner);
                    ingresarPasajeros(scanner);
                    break;
                case 3:
                    if (planetaSeleccionado != -1 && naveSeleccionada != -1) {
                        iniciarSimulacion();
                    } else {
                        System.out.println("Por favor, seleccione un planeta y una nave antes de iniciar su viaje.");
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
        scanner.close();
    }

    //metodo para mostrar el menu principal
    private static void mostrarMenu() {
        System.out.println(" =======================");
        System.out.println("| VIAJE INTERPLANETARIO |");
        System.out.println(" =======================");
        System.out.println("1. Seleccionar un planeta de destino");
        System.out.println("2. Seleccionar una nave espacial y cantidad de pasajeros");
        System.out.println("3. Iniciar la simulación del viaje");
        System.out.println("4. Salir del programa");
        System.out.println("  .....................");
        System.out.println("  Seleccione una opción:");
        System.out.println("  .....................");
    }

    //Metodo para mostrar la seleccion de planetas
    private static void seleccionarPlaneta(Scanner scanner) {
        System.out.println("Seleccione un planeta de destino:");
        for (int i = 0; i < PLANETAS.length; i++) {
            System.out.println((i + 1) + ". " + PLANETAS[i] + " - " + DESCRIPCIONES_PLANETAS[i]);
        }
        int seleccion = scanner.nextInt();
        if (seleccion >= 1 && seleccion <= PLANETAS.length) {
            planetaSeleccionado = seleccion - 1;
            System.out.println("Planeta seleccionado: " + PLANETAS[planetaSeleccionado] + ", Distancia: "
                    + DISTANCIAS[planetaSeleccionado] + " millones de km.");
        } else {
            System.out.println("Selección inválida. Intente nuevamente.");
        }
    }

    //Metodo para seleccionar Nave y velocidad
    private static void seleccionarNave(Scanner scanner) {
        System.out.println("Seleccione una nave espacial:");
        for (int i = 0; i < NAVES.length; i++) {
            System.out
                    .println((i + 1) + ". " + NAVES[i] + " - Velocidad máxima: " + VELOCIDADES[i] + " millones de km ");
        }
        int seleccion = scanner.nextInt();
        if (seleccion >= 1 && seleccion <= NAVES.length) {
            naveSeleccionada = seleccion - 1;
            System.out.println("Nave seleccionada: " + NAVES[naveSeleccionada]);
        } else {
            System.out.println("Selección inválida. Intente nuevamente.");
        }
    }

    //Metodo para ingresar cantidad de pasajeros
    private static void ingresarPasajeros(Scanner scanner) {
        System.out.print("Ingrese la cantidad de pasajeros: ");
        cantidadPasajeros = scanner.nextInt();
        if (cantidadPasajeros > 0) {
            System.out.println("Cantidad de pasajeros: " + cantidadPasajeros);
        } else {
            System.out.println("Número de pasajeros inválido. Debe ser minimo uno y maximo 4.");
            cantidadPasajeros = 0;
        }
    }

    //Metodo de calcular duracion de Viaje
    private static double calcularDuracion() {
        double distancia = DISTANCIAS[planetaSeleccionado];
        double velocidad = VELOCIDADES[naveSeleccionada];
        return distancia / velocidad;
    }

    //Metodo de inicio de Simulacion
    private static void iniciarSimulacion() {
        System.out.println("Iniciando el viaje...");
        double duracion = calcularDuracion();
        int progreso = 0;

        for (int i = 0; i <= 100; i += 10) {
            System.out.println("Progreso del viaje: " + i + "% completado.");

            if (i == 0) {
                System.out.println("Inicio del viaje.");
            } else if (i == 50) {
                System.out.println("Mitad del camino alcanzada. ");
            } else if (i == 100) {
                System.out.println("Llegada al destino: " + PLANETAS[planetaSeleccionado]);
            }

            try {
                Thread.sleep(1000); // Pausa para simular el tiempo del viaje
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Duración estimada del viaje: " + duracion + " días.");
    }
}
