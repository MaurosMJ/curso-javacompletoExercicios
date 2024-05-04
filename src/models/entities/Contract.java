package models.entities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {

	private int number;
	private LocalDate date;
	private double totalValue;
	private List <Installment> installment = new ArrayList <>();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Contract(int number, LocalDate date, double totalValue) {
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
	}

	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public double getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	
	@Override
	public String toString() {
		
		String msg = "";
		for (Installment c : installment) {
			
			msg += (c.getDueDate().format(formatter)) + " - " + String.format("%.2f", c.getAmount()) + "\n";
		}
		
		return msg;
		
		
		
	}
	
	public void addList (Installment installment) {
		this.installment.add(installment);
	}
	
	
}
