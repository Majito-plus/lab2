package grades;
import java.util.ArrayList;
// Clase pricipal para gestionar las notas  
public class GradeManager {
    //Variable para almacenar las notas utilizando ArrayList 
    private ArrayList<Double>grades;
    //Constructor que inicializa el ArrayList
    public GradeManager(){
        grades=new ArrayList<>();
    }
    //Metodo para agreagr nota 
    public void addGrade(Double grade){
        grades.add(grade);
    }
    //Metodo para calcular el promedio de las notas 
    public Double calculateAverage(){
        Double sum= 0.0;
        for (Double grade: grades){
            sum +=grade;
        }
        return grades.isEmpty()? 0.0 : sum/grades.size();
    }
    //Metodo para contar el numero de aprobados (notas>=50)
    public Integer countPassingGrades(){
        Integer count = 0;
        for (Double grade : grades){
            if (grade >=50.0){
                count++;
            }
        } return count;
    }
 //Desafio 
 // devuelve las notas guardas
    public Integer getGradeCount(){
        return grades.size();
    }
    //Muestra las notas enumeradas
    public void printGrades() {
        for (int i = 0; i < grades.size(); i++) {
            System.out.println((i + 1) + ". " + grades.get(i));
        }
    }
    //Elimina por Posicion(1.2.3.4.)
        public boolean removeGradeByPosition(int position){
            if(position<1 || position>grades.size()){
                return false;
            }
            grades.remove(position-1);
            return true ;
        }
//Eminar por valor (borra la primera coincidencia )
    public boolean removeGradeByValue(Double value){
    return grades.remove(value);
  }

         
}
