package Maven_Cucumber_BDD.cucumber;

import java.util.ArrayList;

public class RestaurantMenu {
	ArrayList<RestaurantMenuItem> MenuItems = new ArrayList<RestaurantMenuItem>();
	public boolean addMenuItem(RestaurantMenuItem newMenuItem) throws IllegalArgumentException {
		return MenuItems.add(newMenuItem);
	}
	public boolean DoesItemExist(RestaurantMenuItem newMenuItem) {
		boolean Exists = false;
		if (MenuItems.contains(newMenuItem)) {
			Exists = true;
		}
		return Exists;
	}
	
}
