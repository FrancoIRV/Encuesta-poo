import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Run lz = new Run();

        lz.run();
        Matriz m1 = new Matriz();
    }
}
class Run {
    public void run(){
        System.out.println("progama lanzado");
        Matriz m1 = new Matriz();
        char [][] matriz = m1.crearMatriz(6);
        m1.mostrarMatriz(matriz);
        int result =  m1.hombresAprueban(matriz);
        System.out.println("los hombres que aprueban son "+result);
        int mujeresresult = m1.mujeresDesaprueban(matriz);
        System.out.println("las mujeres que desaprueban son " + mujeresresult);
        int porcentajeAprobados = m1.pocentajeAprobado(matriz);
        System.out.println("aprobo el " + porcentajeAprobados +"%");
    }
}
class Matriz{

    public char[][] crearMatriz(int nro){
        Random rnum = new Random();
        char [] valores = {'s','n','x'};


        char matriz [][] =  new char[2][nro];
        for (int i=0;i<2;i++){
            for (int j=0;j<nro;j++){
                int nroRandom = rnum.nextInt(valores.length);
                matriz[i][j] = valores[nroRandom];
            }
        }
        return matriz;
    }
    public void mostrarMatriz(char[][] m1) {
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                System.out.print(m1[i][j] + " ");
            }
            System.out.println();
        }
    }
    public int hombresAprueban(char[][] m1){
        int contador = 0;
        if (m1.length>0){
            for (int j=0;j<m1[0].length;j++){
                if (m1[0][j] == 's'){
                    contador += 1;
                }
            }
        }
        return contador;
    }
    public int mujeresDesaprueban(char[][] m1){
        int contador = 0;
        if (m1.length>0) {
            for (int j = 0; j < m1[0].length; j++) {
                if (m1[1][j] == 'n') {
                    contador += 1;
                }
            }
        }
        return contador;
    }
    public int pocentajeAprobado(char [][] m1 ){
        int nroAprobados = 0;

        for (int i=0;i<m1.length;i++){
            for (int j=0;j<m1[i].length;j++){
                if(m1[i][j] == 's'){
                    nroAprobados+= 1;
                }
            }
        }
        int n = m1[0].length;
        int divisor = 2*n;
        int porcentajeTotal = nroAprobados * 100 /divisor;
        return (porcentajeTotal );
    }
}