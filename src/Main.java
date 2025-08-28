import java.util.Random;
import java.util.Scanner;

class AnalizadorDeNotas{
    double[][] notas;
    String[] evaluaciones;
    int[] rut;
    int cantEstudiantes;
    int cantEvaluaciones;
    double[] promediosEstudiantes;
    double[] promedioEvaluaciones;

    public AnalizadorDeNotas(int estudiantes, int evaluaciones){
        this.notas = new double[estudiantes][evaluaciones];
        this.cantEstudiantes = estudiantes;
        this.cantEvaluaciones = evaluaciones;
        this.evaluaciones = new String[evaluaciones];
        this.rut = new int[estudiantes];
        this.promediosEstudiantes = new double[estudiantes];
        this.promedioEvaluaciones = new double[evaluaciones];

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
        this.promediosEstudiantes = new double[estudiantes];
        this.promedioEvaluaciones = new double[evaluaciones];

        for(int  i = 0; i < estudiantes; i++){
            for(int j = 0; j < evaluaciones; j++){
                Random random = new Random();
                double randomValue = random.nextDouble();
                notas[i][j] = randomValue;
            }
        }

        Scanner entrada = new Scanner(System.in);

        for(int i = 0; i < estudiantes; i++){
            this.rut[i] = i+1;
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
            promedios[i] = calcularPromedioEstudiante(i+1);
        }
        return promedios;
    }

    public double[] calcularVarianzaEstudiantes(){
        double[] varianzas = new double[cantEstudiantes];
        for(int i = 0; i < cantEstudiantes; i++){
            double total = 0;
            double promedio = calcularPromedioEstudiante(i+1);
            for(int j = 0; j < cantEvaluaciones; j++){
                total += (notas[i][j]-promedio)*(notas[i][j]-promedio);
            }
            varianzas[i] = total/cantEvaluaciones;
        }
        return varianzas;
    }

    public double[] calcularPromedioEvaluaciones(String[] evaluaciones){
        double[] promedios = new double[cantEstudiantes];
        for(int i = 0; i < cantEstudiantes; i++){
            double suma = 0;
            int cont=0;
            for(int j = 0; j < cantEvaluaciones; j++){
                if(cont == evaluaciones.length){
                    break;
                }else if(this.evaluaciones[j].equals(evaluaciones[cont])){
                    suma += notas[i][j];
                    cont++;
                }
            }
            promedios[i]= (suma/evaluaciones.length);
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

    public double[] calcularPromediosEstudiantesOptimizado(){
        double[] promedios = new double[cantEstudiantes];
        for(int i = 0; i < cantEstudiantes; i++){
            promedios[i] = calcularPromedioEstudiante(i+1);
        }
        this.promediosEstudiantes = promedios;
        return promedios;
    }

    public double[] calcularPromedioEvaluacionesOptimizado(){
        double[] promedios = new double[cantEvaluaciones];
        for(int i = 0; i < cantEvaluaciones; i++){
            promedios[i] = calcularPromedioEvaluacion(i);
        }
        this.promedioEvaluaciones = promedios;
        return promedios;
    }
}



public class Main {
    public static void main(String[] args) {

    }
}
