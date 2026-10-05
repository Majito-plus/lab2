import grades.GradeManager;
import java.util.Scanner;
public class App {
    public static void main(String[] args)  {
        //Crea una instancia de GradeManger 
       grades.GradeManager gradeManager =new GradeManager();
       Scanner scanner = new Scanner (System.in);

       // Este bucle mantiene activo el menu del programa, permitiendo al usuario interactuar 
       //continuamente hasta que decida salir. Anteriormente , en clase, utilizamos una bandera(flag
       // para controlar la finalizacion del programa .Sin embargo , en este caso ,hemos optado por 
       //finalizar la ejecucion de la aplicacion de manera explicita utilizando System.exit(0),
       //lo que asegura un terminacion inmediata y ordeanada 
       while (true){
        //Mostrar el menun al usuario 
        System.out.println("====Grade Manager====");
        System.out.println("=================\\nMenu:======================= ");
        System.out.println("1.add grade");
        System.out.println("2. View average grade");
        System.out.println("3.View Number of passing grades");
        System.out.println("4.Remove grade");
        System.out.println("5.Exit");
        System.out.println("Choose an option: ");
        System.out.println("======================================================");
        if (!scanner.hasNextInt()){
            //entra si NO es un entero
            System.out.println("invaled input.Please enter a number");
           scanner.next(); // descarta el texto invalido 
        continue;//vuelve a entrar al menu 
        }//Leer la opccion elegida por el usuario 
        Integer choice = scanner.nextInt();

        switch (choice){
            case 1:
                // solicita al ususario una nueva nota a la lista
                System.out.print("Enter a grade: ");
                if(!scanner.hasNextDouble()){
                    //entra qui si es decimal la nota
                    System.out.println("Invalid grade.please enter a number ");
                    scanner.next();    
                }else{
                Double grade =scanner.nextDouble();
                gradeManager.addGrade(grade);
                }
                break;
            case 2 :
                //calcula en promedio 
                System.out.println("Average grade: " + gradeManager.calculateAverage());
                break;
            case 3: 
            //muestra el numero de aprobados
                System.out.println("Number of passing grad: "+ gradeManager.countPassingGrades());
                break;
            case 4: 
            // el dessafio 
                System.out.println("====Desafio=====");
                 if (gradeManager.getGradeCount() == 0) {
                        System.out.println("There are no grades to remove.");
                        break;
                    }
                    // es como un submenu para elminar 
                 System.out.println("Grades:");
                 gradeManager.printGrades();
                 System.out.println("Remove by:");
                 System.out.println("1. Position");
                 System.out.println("2. Value");
                 System.out.print("Choose: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next();
                    break;
                }
                Integer subChoice= scanner.nextInt();

                if (subChoice==1){ 
                    System.out.print("Enter the position to remove: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next();
                    break;
                 }
                Integer position = scanner.nextInt();
                if (gradeManager.removeGradeByPosition(position)) {
                     System.out.println("Grade removed.");
                 } else {
                     System.out.println("That position does not exist.");
                }

                }else if (subChoice==2){
                 System.out.print("Enter the grade value to remove: ");
                if (!scanner.hasNextInt()) {
                     System.out.println("Invalid input. Please enter a number.");
                    scanner.next();
                     break;
                }
                 Double value = scanner.nextDouble();
                if(gradeManager.removeGradeByValue(value)){
                    System.out.println("Grade removed");
                }else {
                    System.out.println("That grade was not found.");
                }
                 } else {
                 System.out.println("Invalid option. Please try again.");
                        }
                 break;
             case 5:
                 System.out.println("Exiting the program.");
                 scanner.close();
                 System.exit(0);
                 break;
            default:
                 System.out.println("Invalid option. Please try again.");
                
                   
            }

   
       }
    }
     
}
