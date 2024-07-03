package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {
	private static DateTimeFormatter fmt =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private LocalDate duedate;
	private Double amount;

	public Installment() {

	}

	public Installment(LocalDate duedate, Double amount) {
		this.duedate = duedate;
		this.amount = amount;
	}

	public LocalDate getDuedate() {
		return duedate;
	}

	public void setDuedate(LocalDate duedate) {
		this.duedate = duedate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return duedate.format(fmt) + " - " + String.format("%.2f", amount);
	}
	
	
}
