package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderProduct;

public class Order {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderProduct status;
	
	private Client client;
	private List<OrderItem> orderItem = new ArrayList<>();
	
	public Order() {
	}
	public Order(Date moment, OrderProduct status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}
	
	public Date getMoment() {
		return moment;
	}
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	public OrderProduct getStatus() {
		return status;
	}
	public void setStatus(OrderProduct status) {
		this.status = status;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<OrderItem> getOrderItem(){
		return orderItem;
	}
	public void addItem(OrderItem add) {
		orderItem.add(add);
	}
	public void removeItem(OrderItem remove) {
		orderItem.remove(remove);
	}
	
	public Double total() {
		double sum = 0.0;
		for(OrderItem item : orderItem) {
			sum += item.subTotal();
		}
		return sum;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMARY:\n");
		sb.append("Order moment: " + sdf.format(moment) + "\n");
		sb.append("Order Status: " + status + "\n");
		sb.append("Client: " + client + "\n");
		sb.append("Order Items: ");
		for(OrderItem items : orderItem) {
			System.out.println(items);
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
}
