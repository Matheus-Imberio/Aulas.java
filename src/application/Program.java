package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("Entre os dados do contrato: ");
		System.out.print("Numero: ");
		int number = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		sc.nextLine();
		LocalDate date = LocalDate.parse(sc.next(), fmt);
		System.out.print("Valor do contrato: ");
		double valor = sc.nextDouble();
		System.out.print("Entre com o numero de parcelas: ");
		int parc = sc.nextInt();
		sc.nextLine();
		Contract contract = new Contract(number, date, valor);
		ContractService contractService = new ContractService(new PaypalService());
		contractService.processContract(contract,parc);
		
		System.out.println("Parcelas: ");
		for(Installment installment : contract.getIstallments()) {
			System.out.println(installment);
		}
		sc.close();
	}

}
