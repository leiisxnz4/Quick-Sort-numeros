import java.io.*;
import java.util.*;

public class QuickSort {

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        int tmp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = tmp;

        return i + 1;
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("datos_quicksort.txt"));
            List<Integer> numeros = new ArrayList<>();
            String linea;

            while ((linea = br.readLine()) != null) {
                numeros.add(Integer.parseInt(linea.trim()));
            }
            br.close();

            System.out.println("Archivo de entrada: datos_quicksort.txt");
            System.out.println("Contenido:");
            System.out.println(numeros + "\n");

            int[] arr = numeros.stream().mapToInt(i -> i).toArray();
            quickSort(arr, 0, arr.length - 1);

            System.out.println("Resultado del QuickSort:");
            System.out.println(Arrays.toString(arr));

            Scanner sc = new Scanner(System.in);
            System.out.print("\nNombre del archivo de salida: ");
            String nombreSalida = sc.nextLine();

            PrintWriter pw = new PrintWriter(new FileWriter(nombreSalida));
            pw.println("Resultado QuickSort:");
            pw.println(Arrays.toString(arr));
            pw.close();

            System.out.println("Archivo generado: " + nombreSalida);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
