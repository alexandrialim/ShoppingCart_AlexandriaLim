import java.util.*;
import java.text.DecimalFormat;
public class ShoppingCart implements Cart {
	ArrayList<SelectedItem> listofItems = new ArrayList<SelectedItem>();
	private double total;
	public ShoppingCart(){
	}
	public void addItem(SelectedItem newItem) {
		listofItems.add(newItem);
		for (SelectedItem Item: listofItems){
			if(Item.getItemNumber() == newItem.getItemNumber()){
				Item.setQuantity(Item.getQuantity());
			}
		}
	}

	public void deleteItem(int deleteItemNumber) {			
			for(SelectedItem Item: listofItems){
				if (Item.getItemNumber() == deleteItemNumber){
					listofItems.remove(Item);
				}
			}
	}

	public double getTotal() {
		for(SelectedItem Item: listofItems){
		total = total + (Item.getQuantity() *  Item.getUnitPrice());
		}
		return Double.parseDouble(new DecimalFormat("#.0#").format(total));
	} 
	public double getTax() {
		return total * 0.045;
	}
	public double getShipping() {
		if( total <= 10){
			return  2.50;
		}
		else{
			return total * 0.15;	
		}
	}
	public double grandTotal(){
		double sum;
		sum = this.getTotal() + this.getShipping() + this.getTax();
		return sum;
	}
	public String toString(){
		for(SelectedItem Item: listofItems){
		System.out.print("Item: " + Item.getDescription() + 
				"\n" + "Quantity: " + Item.getQuantity() + 
				"\n" + "Unit Price: $" + Item.getUnitPrice() +
				"\n" + "Total Price: $" + Double.parseDouble(new DecimalFormat("#.00").format((Item.getQuantity() * Item.getUnitPrice()))) +
				"\n" + "\n");
		}
		return "\n" + "Total: $" + Double.parseDouble(new DecimalFormat("#.00").format(getTotal())) + 
				"\n" + "Tax: $" + Double.parseDouble(new DecimalFormat("#.00").format(getTax())) +
				"\n" + "Shipping: $" + Double.parseDouble(new DecimalFormat("#.00").format(getShipping()))
			+	"\n" + "Grand Total: $" + Double.parseDouble(new DecimalFormat("#.00").format(grandTotal()));
	}
 
}

