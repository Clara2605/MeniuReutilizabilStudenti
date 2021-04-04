package sample;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import abstractions.IMenuItem;
import implementations.Menu;
import implementations.MenuItem;

public class ApplicationMenu{
	private Scanner consoleScanner = new Scanner(System.in);
	private ArrayList<Student> StudentsList = new ArrayList<Student>();
	
    private Menu mainMenu = null;
    public ApplicationMenu()
    {
                 
    }
	
    public void load()
    {
        
        ArrayList<IMenuItem> menuItems = new ArrayList();
        ArrayList<IMenuItem> showStudentsOptions = new ArrayList();
        
        int shortCut = 1;    
        
         
       IMenuItem currentItem = new MenuItem("Adaugare student", shortCut++, (parameters)->{
           uiAddStudent();
       });       
       menuItems.add(currentItem);
       
       currentItem = new MenuItem("Sterge student", shortCut++, (parameters)->{
    	   	uiDeleteStudent();
       });       
       menuItems.add(currentItem); 
       
       currentItem = new MenuItem("Modifica student", shortCut++, (parameters)->{
   	   	uiModifyStudent();
      });       
      menuItems.add(currentItem);
      
      currentItem = new MenuItem("Vizualizeaza studenti", shortCut++, (parameters)->{
  	   	uiViewStudents();
     });       
     menuItems.add(currentItem);
       
       showStudentsOptions.add(new MenuItem("Ordonat crescator", 1, (parameters) -> {
    	System.out.println("Ordonare crescatoare executata");
    	Collections.sort(StudentsList, new StudentiComparatorMedie(true));
    	uiViewStudents();
       }));
       
       showStudentsOptions.add(new MenuItem("Ordonat descrescator", 2, (parameters) -> {
       	System.out.println("Ordonare descrescatoare executata");
       	Collections.sort(StudentsList, new StudentiComparatorMedie(false));
       	uiViewStudents();
          }));
       
       
       currentItem = new Menu("Afisaza studenti dupa medie", shortCut++, showStudentsOptions);       
       menuItems.add(currentItem);
       
       
        
        mainMenu = new Menu("Main Menu", -1, menuItems);
        
    }
    
    public void execute()
    {
        mainMenu.execute();
    }
    
    private void listStudent(Student Student)
	{
		System.out.println(Student.getNume() + "\t" + Student.getPrenume() + "\t" +  Student.getMedie() );
	}
    
	private void uiViewStudents() {
		
		System.out.println("Nume\tPrenume\tMedie");
		
		for(Student currentStudent: StudentsList)
		{
			listStudent(currentStudent);			
		}
	}

	private void uiDeleteStudent() {
		System.out.println("Sterge STUDENT dupa nume.\nNumele studentilor sunt:");
		for(Student stud:StudentsList) {
			System.out.print(" " + stud.getNume());
		}
		System.out.println("\nAlegeti numele studentului pe care doriti sa il stergeti");
		String StudentEliminat=consoleScanner.next();
		int indice=0;
		for(int i=0; i<StudentsList.size(); i++) {
			if(StudentsList.get(i).getNume()==StudentEliminat)
			{
				indice=i;
				break;
			}
		}
		StudentsList.remove(indice);
		System.out.println("Studentul a fost eliminat cu succes");
	}

	private void uiModifyStudent() {
		System.out.println("Alegeti indicele studentului pe care doriti sa il modificati");
		for(int i=0; i<StudentsList.size();i++) {
			System.out.println(i+". "+StudentsList.get(i).getNume()+" "+StudentsList.get(i).getPrenume());
		}
		int indice=consoleScanner.nextInt();
		System.out.println("Alegeti ce doriti sa modificati\n1.Nume\n2.Prenume\n3.Medie");
		int optiune=consoleScanner.nextInt();
		switch(optiune)
		{
		case 1:
			System.out.println("Introduceti noul nume:");
			StudentsList.get(indice).setNume(consoleScanner.next());
			break;
		case 2:
			System.out.println("Introduceti noul prenume:");
			StudentsList.get(indice).setPrenume(consoleScanner.next());
			break;
		case 3:
			System.out.println("Introduceti noua medie:");
			StudentsList.get(indice).setMedie(consoleScanner.nextDouble());
			break;
		default:
			System.out.println("Nu se modifica nimic.");
			break;
		}
	}

	private void uiAddStudent() {
		System.out.println("Adauga STUDENT: Nume, Prenume, Medie");
		String nume,prenume;
		double medie;
		nume=consoleScanner.next();
		prenume=consoleScanner.next();	
		medie=consoleScanner.nextDouble();
		StudentsList.add(new Student(nume,prenume,medie));
	}
    
}