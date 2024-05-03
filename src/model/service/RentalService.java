package model.service;

import java.time.Duration;

import models.entities.CarRental;
import models.entities.Invoice;

public class RentalService {

	private double pricePerHour;
	private double pricePerDay;
	private TaxService taxService;

	public RentalService(double pricePerHour, double pricePerDay, TaxService taxService) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;
	}

	public void processInvoice(CarRental carRental) {

		Duration t1 = Duration.between(carRental.getStart(), carRental.getFinish());

		if (t1.toHours() <= 12) {
			double horas = Math.ceil(t1.toMinutes() / 60f);
			double pagBasico = horas * this.getPricePerHour();
			double tax = taxService.tax(pagBasico);
			carRental.setInvoice(new Invoice(pagBasico, tax));

		} else {
			double dias = Math.ceil(t1.toHours() / 24f);
			double pagBasico = dias * this.getPricePerDay();
			double tax = taxService.tax(pagBasico);
			carRental.setInvoice(new Invoice(pagBasico, tax));
		}

	}

	public double getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	public double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}


}
