import java.util.Map;
import java.util.HashMap;

public class Cart {

	private static int index = 1;

	private static Map<Integer, String> Cartthings = new HashMap<Integer, String>();
	private static Map<Integer, String> Cartthings2 = new HashMap<Integer, String>();

	public Cart() {

	}

	public static void ViewCart() {

		if (!(Cartthings.isEmpty())) {

			for (int item : Cartthings.keySet()) {

				System.out.println(item + ".) " + Cartthings.get(item));

			}

		} else {

			System.out.println("The cart is empty.");

		}
	}

	public static void AddToCart(String selectedbook) {

		try {

			Cartthings.put(index, selectedbook);
			index++;

		}

		catch (Exception e) {

			System.out.println("Books not found.");

		}
	}

	public static void RemoveFromCart(String x) {

		System.out.println("Removing item: " + x);

		if (!Cartthings.isEmpty()) {

			try {

				if (!(x.contains(","))) {

					Cartthings.remove(Integer.valueOf(x));
					System.out.println("Book " + x + " successfully removed.");
					index--;

				}

				else {

					String[] stuff = x.split(",");

					for (String a : stuff) {

						Cartthings.remove(Integer.valueOf(a));
						index--;

						System.out.println("Book " + x + " successfully removed.");

					}

				}

				reorderCart();

			}

			catch (Exception e) {

				System.out.println("Book not found.");

			}

		}

		else {

			System.out.println("The cart is empty.");

		}

	}

	public static void DeleteCart() {

		Cartthings.clear();
		index = 1;
		System.out.println("All items removed.");

	}

	
	  public static void reorderCart() {
	 
		  if(Cartthings.size()>1) {
	  
			  int x=1;
			  Cartthings2.clear();
			  
			  for(int item : Cartthings.keySet()) {
				  
				  Cartthings2.put(x, Cartthings.get(item));
				  x++;
			  }
			  
			  Cartthings.clear();
			  
			  for(int item : Cartthings2.keySet()) {
				  	
				  Cartthings.put(item, Cartthings2.get(item));
	  
			  }
		  } 
	 }
	 
	 
	public static void CheckoutCart() {
		Log();
	}
}
