import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class tarea2{
    public static void main(String[] args) {
    System.out.println("Ingresa la cantidad de datos: ");
    Scanner teclado = new Scanner(System.in);
    int numeroDatos = teclado.nextInt();

    DecimalFormat df = new DecimalFormat("#.00");
    float datos[] = new float[numeroDatos];
    Random rnd = new Random();
    ArrayList <Integer> bits = new ArrayList<>();

        for(int i=1; i < numeroDatos; i++){
          datos[i] = rnd.nextFloat(1);
            System.out.println(df.format(datos[i]));
            if (datos[i] <= datos[i-1]) {
                bits.add(0);
            }else{
                bits.add(1);
            }
        }

        for (int i=0; i<bits.size(); i++){
            System.out.print(bits.get(i));
        }
     
    int corridasObservadas = 1;
    int dato = bits.get(0);
    for(int i=1; i < bits.size(); i++){
        if(bits.get(i) != dato){
            corridasObservadas++;
            dato = bits.get(i);
        }
    }
    System.out.println("  La cantidad de corridas son "+corridasObservadas);

    //MCO
    int mco = ((2 * numeroDatos) - 1) / 3;
    System.out.println("La media es: "+mco);
    //OCo 
    int OCo = ((16 * numeroDatos) - 29) / 29;
    System.out.println("La varianza es: "+OCo);
    //Zo
    double zo = (corridasObservadas - mco) / (Math.sqrt(OCo));
    System.out.println("El valor estadístico Z es: "+zo);

    //Determina si son independientes o no
    if(zo > 1.96){
        System.out.println("Los datos son independientes");
    }else{
        System.out.println("Los datos no son independientes");
    }
    }

    
}
