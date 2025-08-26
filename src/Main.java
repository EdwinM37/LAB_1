import java.util.Random;
import java.util.Scanner;

class AnalizadorDeNotas{
    double[][] notas;
    String[] evaluaciones;
    int[] rut;
    int cantEstudiantes;
    int cantEvaluaciones;

    public AnalizadorDeNotas(int estudiantes, int evaluaciones){
        this.notas = new double[estudiantes][evaluaciones];
        this.cantEstudiantes = estudiantes;
        this.cantEvaluaciones = evaluaciones;
        this.evaluaciones = new String[evaluaciones];
        this.rut = new int[estudiantes];

        for(int  i = 0; i < estudiantes; i++){
            for(int j = 0; j < evaluaciones; j++){
                Random random = new Random();
                double randomValue = random.nextDouble();
                notas[i][j] = randomValue;
            }
        }

        Scanner entrada = new Scanner(System.in);

        int cont=0;
        while(cont<cantEstudiantes){
            System.out.print("Ingrese id del estudiante "+(cont+1)+": ");
            int idEstudiante = entrada.nextInt();

            boolean existe = false;

            for(int i=0;i<cont;i++){
                if(rut[i]==idEstudiante){
                    existe = true;
                    break;
                }
            }
            if(existe){
                System.out.println("El id ya existe, ingrese otro;");
            } else{
                rut[cont] = idEstudiante;
                cont++;
            }
        }

        for(int i = 0; i < evaluaciones; i++){
            System.out.print("Ingrese nombre de evaluacion "+(i+1)+": ");
            String evaluacion = entrada.next();
            this.evaluaciones[i]=evaluacion;
        }
    }

    public AnalizadorDeNotas(int estudiantes, int evaluaciones, String[] nombresEvaluaciones){
        notas = new double[estudiantes][evaluaciones];
        this.cantEstudiantes = estudiantes;
        this.cantEvaluaciones = evaluaciones;
        this.evaluaciones = nombresEvaluaciones;
        this.rut = new int[estudiantes];

        for(int  i = 0; i < estudiantes; i++){
            for(int j = 0; j < evaluaciones; j++){
                Random random = new Random();
                double randomValue = random.nextDouble();
                notas[i][j] = randomValue;
            }
        }

        Scanner entrada = new Scanner(System.in);

        int cont=0;
        while(cont<cantEstudiantes){
            System.out.print("Ingrese id del estudiante "+(cont+1)+": ");
            int idEstudiante = entrada.nextInt();

            boolean existe = false;

            for(int i=0;i<cont;i++){
                if(rut[i]==idEstudiante){
                    existe = true;
                    break;
                }
            }
            if(existe){
                System.out.println("El id ya existe, ingrese otro;");
            } else{
                rut[cont] = idEstudiante;
                cont++;
            }
        }
    }

    public double calcularPromedioEstudiante(int numEstudiante){
        double total = 0;

        for(int i = 0; i < cantEstudiantes; i++){
            if(rut[i] == numEstudiante){
                for(int j = 0; j < cantEvaluaciones; j++){
                    total += notas[i][j];
                }
            }
        }
        return total / cantEvaluaciones;
    }

    public double calcularPromedioEvaluacion(int index){
        double total = 0;

        for(int i = 0; i < cantEstudiantes; i++){
            total += notas[i][index];
        }
        return total / cantEstudiantes;
    }

    public double calcularVarianzaEvaluacion(int index){
        double promedio = calcularPromedioEvaluacion(index);
        double total = 0;

        for(int i = 0; i < cantEstudiantes; i++){
            total += (notas[i][index]-promedio)*(notas[i][index]-promedio);
        }
        return total/cantEstudiantes;
    }

    public double[] calcularPromediosEstudiantes(){
        double[] promedios = new double[cantEstudiantes];
        for(int i = 0; i < cantEstudiantes; i++){
            promedios[i] = calcularPromedioEstudiante(i);
        }
        return promedios;
    }

    public double[] calcularVarianzasEstudiantes(){
        double[] varianzas = new double[cantEstudiantes];
        for(int i = 0; i < cantEstudiantes; i++){
            varianzas[i] = calcularPromedioEvaluacion(i);
        }
        return varianzas;
    }

    public double[] calcularPromedioEvaluaciones(String[] evaluaciones){
        double[] promedios = new double[cantEstudiantes];
        for(int i = 0; i < cantEstudiantes; i++){
            double suma = 0;
            int cont=0;
            for(int j = 0; j < cantEvaluaciones; j++){
                if(this.evaluaciones[j]==evaluaciones[cont]){
                    suma += notas[i][j];
                    cont++;
                }
                promedios[i]=suma/evaluaciones.length;
            }
        }
        return promedios;
    }

    public String encontrarMaximo(int index){
        int max = 0;
        for(int i=1; i<cantEstudiantes; i++){
            if(notas[i][index]>notas[max][index]){
                max=i;
            }
        }
        int res=rut[max];
        return res+"";
    }
}



public class Main {
    public static void main(String[] args) {

    }
}