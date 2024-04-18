package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private LocalDateTime moment;
	private OrderStatus order;
	private List<OrderItem> ordem = new ArrayList<>();
	private Client client;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	private DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Order(LocalDateTime moment, OrderStatus order, Client client) {
		this.moment = moment;
		this.order = order;
		this.client = client;
	}

	public void addItem(OrderItem item) {
		this.ordem.add(item);
	}

	public void removeItem(OrderItem item) {
		this.ordem.remove(item);
	}
	
	public String toString() {
		
		StringBuilder str = new StringBuilder();
		str.append("\nORDER SUMMARY: \n");
		str.append("Order moment: "+moment.format(formatter)+"\n");
		str.append("Order status: "+ this.getOrder()+"\n");
		str.append("Client: ");
		str.append(this.getClient().getName());
		str.append(" ("+ formatter1.format(this.getClient().getBirthDate())+") - ");
		str.append(this.getClient().getEmail()+"\n\n");
		str.append("Order items:\n");
		
		for (OrderItem c : ordem) {
			str.append(c.getProduct().getName()+", ");
			str.append("$"+c.getProduct().getPrice()+", ");
			str.append("Quantity: "+c.getQuantity()+", ");
			str.append("Subtotal: $"+(c.getPrice()*c.getQuantity())+"\n");
		}
		str.append("Total price: "+this.total());
		
		return str.toString();
	}

	public OrderStatus getOrder() {
		return order;
	}

	public double total() {

		double total = 0;

		for (OrderItem c : ordem) {
			total += c.getPrice() * c.getQuantity();
		}

		return total;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public List<OrderItem> getOrdem() {
		return ordem;
	}

	public void setOrdem(List<OrderItem> ordem) {
		this.ordem = ordem;
	}

}
