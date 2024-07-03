package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.EmployeeRegistry;

public class EmployeeDataReader {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		// solicita o numero de funcionarios
		System.out.print("How many employees will be registered? ");
		int N = sc.nextInt();
		
		// criar lista para armazenar obj
		List<EmployeeRegistry> list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			System.out.println();
			System.out.printf("Employee #%d%n", i+1);
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			
			EmployeeRegistry emp = new EmployeeRegistry(id, name, salary);
			
			list.add(emp);
			
		}
		
		System.out.println();
		
		System.out.print("Enter the employee id that will have salary increase: ");
		int idEmployee = sc.nextInt(); // solicita o id do funcionario
		EmployeeRegistry result = list.stream().filter(x -> x.getId() == idEmployee).findFirst().orElse(null); // procura o id na lista
		if(result == null) {  // se nao encontrou, exibir seguinte mensagem
			System.out.println("This id does not exist!");
		} else { // se o id existir, entrar com a porcentagem de aumentos
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			result.increaseSalary(percentage);  // metodo para ganhar aumento
		}
		
		System.out.println();
		
		System.out.println("List of Employee:");
		for(int i=0; i<list.size(); i++) { // exibir lista de funcionarios
			System.out.println(list.get(i).getId() + ", " + list.get(i).getName() + ", " + list.get(i).getSalary());
		}
		
		
		sc.close();
	}

}
