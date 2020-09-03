package stepdefinitions;

import Maven_Cucumber_BDD.cucumber.RestaurantMenu;
import Maven_Cucumber_BDD.cucumber.RestaurantMenuItem;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MenuManagementSteps {
	RestaurantMenuItem NewMenuItem;
	RestaurantMenu LocationMenu = new RestaurantMenu();
	
	@Given("I have a menu item with name {string} and price {int}")
	public void i_have_menu_item_with_name_and_price(String newMenuItemName, Integer price) {
		NewMenuItem = new RestaurantMenuItem(newMenuItemName, newMenuItemName, price);
		System.out.println("Step 1");
	}
	@When("I add that menu item")
	public void I_add_that_menu_item() {
		LocationMenu.addMenuItem(NewMenuItem);
		System.out.println("Step 2");
	}
	@Then("Menu Item with name {string} should be added")
	public void Menu_Item_with_name_should_be_added(String string) {
		boolean Exists = LocationMenu.DoesItemExist(NewMenuItem);
		System.out.println("Step 3" + Exists);
	}
}
