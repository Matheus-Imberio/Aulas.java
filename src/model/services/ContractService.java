package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	private OnlinePaymentService onlinePayment;
	
	public ContractService(OnlinePaymentService onlinePayment) {
		this.onlinePayment = onlinePayment;
	}
	
	
	public void processContract(Contract contract, Integer months) {
		double parc = contract.getTotalValue() / months; 
		for(int i = 1; i <= months; i++) {
			LocalDate dueDate = contract.getDate().plusMonths(i);
			double interest = onlinePayment.interest(parc,i);
			double fee = onlinePayment.paymentFee(parc+interest);
			double total = parc + interest + fee;
			contract.getIstallments().add(new Installment(dueDate, total));
		}
	}
}
