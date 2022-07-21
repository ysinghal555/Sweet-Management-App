package org.gloabalogic.sweetShopManagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.gloabalogic.sweetShopManagement.dao.SweetCategoryDao;
import org.gloabalogic.sweetShopManagement.dao.SweetProductDao;
import org.gloabalogic.sweetShopManagement.dao.UserDao;
import org.gloabalogic.sweetShopManagement.entities.SweetCategory;
import org.gloabalogic.sweetShopManagement.entities.SweetProduct;
import org.gloabalogic.sweetShopManagement.entities.Users;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// Main Program
public class Sweet {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Welcome to Sweet Shop Management App");
		System.out.println("----------------------------------------");

		boolean isExitFromFirstLoop = true;

		// Loop until user EXIT from the application
		while (isExitFromFirstLoop) {
			System.out.println("Press 1 to Login as Admin");
			System.out.println("Press 2 to Login as Customer");
			System.out.println("Press 3 to Register");
			System.out.println("Press 4 to EXIT");
			System.out.println("----------------------------------------\n");

			int isAdminOrCustomer = 0;

			// if the user press alphabets instead of numbers(integer)
			try {
				isAdminOrCustomer = Integer.parseInt(br.readLine());
			} catch (Exception e) {

			}

			// Create an object so that we can connect with config.xml file
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
					"org/gloabalogic/sweetShopManagement/config.xml");

			// Get the bean for SweetCategoryDao
			SweetCategoryDao sweetCategoryDao = applicationContext.getBean("sweetCategoryDao", SweetCategoryDao.class);

			// Get the bean for UserDao
			UserDao userDao = applicationContext.getBean("userDao", UserDao.class);

			// Get the bean for SweetCategoryDao
			SweetProductDao sweetProductDao = applicationContext.getBean("sweetProductDao", SweetProductDao.class);

			((ClassPathXmlApplicationContext) applicationContext).close();

			// Check if the User wants to login as Admin or Customer or wants to Register
			switch (isAdminOrCustomer) {

			// If the user wants to login as Admin
			case 1: {

				System.out.println("\nEnter Username: ");
				String username = br.readLine();
				System.out.println("Enter Password: ");
				String password = br.readLine();

				try {
					// Check if the user credentials are correct or not
					userDao.verifyuserFromDB(username, password, true);
					System.out.println("\nAdmin Logged in successfully!!!");
				} catch (Exception e) {
					// If the user credentials are incorrect
					System.out.println("\nInvalid Credentials!! Please try again!!! \n");
					break;
				}

				boolean isExitFromSecondLoop = true;

				// Different options to manage sweets
				while (isExitFromSecondLoop) {
					System.out.println("\n------------------------------------");
					System.out.println("Press 1 for Sweet Category");
					System.out.println("Press 2 for Sweet Product");
					System.out.println("Press 3 for to manage users");
					System.out.println("Press 4 to Back");
					System.out.println("Press 5 to EXIT");
					System.out.println("-----------------------------------");

					int selectSubtypes = 0;
					// if the user press alphabets instead of numbers(integer)
					try {
						selectSubtypes = Integer.parseInt(br.readLine());
					} catch (Exception e) {

					}

					// Check what user picks
					switch (selectSubtypes) {

					// If the user select for Sweet Category
					case 1: {
						boolean isExitFromThirdLoop = true;

						// Perform different operations for Sweet Category here until selects the Back
						// or EXIT option
						while (isExitFromThirdLoop) {

							System.out.println("\n---------- Sweet Category ----------\n");
							System.out.println("Press 1 to add new Sweet Category");
							System.out.println("Press 2 to remove Sweet Category");
							System.out.println("Press 3 to update a Sweet Category Name with it's ID");
							System.out.println("Press 4 to display a Sweet Category with it's ID");
							System.out.println("Press 5 to display all Sweet Category");
							System.out.println("Press 6 to Back");
							System.out.println("Press 7 to EXIT");
							System.out.println("\n-----------------------------------\n");

							int selected = 0;
							// if the user press alphabets instead of numbers(integer)
							try {
								selected = Integer.parseInt(br.readLine());
							} catch (Exception e) {

							}

							switch (selected) {
							// Add new Sweet Category
							case 1: {

								System.out.println("\nEnter Sweet Category Name: ");
								String sweetCategoryName = br.readLine();

								SweetCategory sweetCategory = new SweetCategory();

								sweetCategory.setSweetCategoryName(sweetCategoryName);

								int result = sweetCategoryDao.insertSweetCategory(sweetCategory);

								System.out.println("\n" + result + " Sweet Category added successfully!\n");

								break;
							}
							// Remove Sweet Category with it's Id
							case 2: {

								System.out.println("\nEnter the Sweet Category Id to delete the record: ");

								int sweetCategoryId = 0;
								// if the user press alphabets instead of numbers(integer)
								try {
									sweetCategoryId = Integer.parseInt(br.readLine());
								} catch (Exception e) {

								}

								int result = sweetCategoryDao.deleteSweetCategory(sweetCategoryId);

								if (result == 0) {
									System.out
											.println("\nNo Sweet Category present with Id: " + sweetCategoryId + "\n");
								} else {
									System.out.println("\nSweet Category removed successfully with id: "
											+ sweetCategoryId + " !!" + "\n");
								}

								break;
							}

							// Update Sweet Category Name with it's Id
							case 3: {

								System.out.println("Enter Sweet Category Id: ");
								int sweetCategoryId = 0;
								// if the user press alphabets instead of numbers(integer)
								try {
									sweetCategoryId = Integer.parseInt(br.readLine());
								} catch (Exception e) {

								}
								System.out.println("Enter Sweet Category new name: ");
								String sweetCategoryNewName = br.readLine();

								SweetCategory sweetCategory = new SweetCategory();

								sweetCategory.setSweetCategoryId(sweetCategoryId);
								sweetCategory.setSweetCategoryName(sweetCategoryNewName);

								int result = sweetCategoryDao.updateSweetCategoryName(sweetCategory);

								if (result == 0) {
									System.out
											.println("\nNo Sweet Category present with Id: " + sweetCategoryId + "\n");
								} else {
									System.out.println("\nSweet Category updated successfully!\n");
								}

								break;
							}

							// Display the Sweet Category record with it's Id
							case 4: {
								System.out.println("\nEnter the Sweet Category ID to display the record: ");

								int sweetCategoryId = 0;
								// if the user press alphabets instead of numbers(integer)
								try {
									sweetCategoryId = Integer.parseInt(br.readLine());
								} catch (Exception e) {

								}

								System.out.println();
								try {
									SweetCategory sweetCategory = sweetCategoryDao
											.getSweetCategoryById(sweetCategoryId);
									System.out.println(sweetCategory);
									System.out.println("\nSweet Category record displayed successfully!\n");
								} catch (Exception e) {
									System.out
											.println("\nNo Sweet Category present with Id: " + sweetCategoryId + "\n");
								}

								break;
							}

							// Display all the Sweet Category record
							case 5: {

								List<SweetCategory> sweetCategories = sweetCategoryDao.getAllSweetCategory();

								int count = 0;
								System.out.println();
								for (int i = 0; i < sweetCategories.size(); i++) {
									System.out.print((++count) + ". ");
									System.out.println(sweetCategories.get(i));
								}

								if (count == 0) {
									System.out.println("No data present in the table");
								} else {
									System.out.println();
								}

								break;

							}

							// Back
							case 6: {
								isExitFromThirdLoop = false;
								break;
							}

							// EXIT
							case 7: {
								System.out.println(
										"\nThank you for using the application" + "\n" + "See you soon bye bye..!! ");
								System.exit(0);
							}

							// If select another option that is not present
							default: {
								System.out.println("\nInvalid option!!! Please try again!! \n");

								break;
							}

							}

						}

						break;
					}

					// If the user select for Sweet Product
					case 2: {

						boolean isExitFromFourthLoop = true;
						// Perform different Sweet Product operations here until selects the Back or
						// EXIT option
						while (isExitFromFourthLoop) {

							System.out.println("\n---------- Sweet Products ----------\n");
							System.out.println("Press 1 to add new Sweet Product");
							System.out.println("Press 2 to remove Sweet Product");
							System.out.println("Press 3 to update a Sweet Product Name with it's ID");
							System.out.println("Press 4 to display a Sweet Product with it's ID");
							System.out.println("Press 5 to display all Sweet Product");
							System.out.println("Press 6 to Back");
							System.out.println("Press 7 to EXIT");
							System.out.println("\n-----------------------------------\n");

							int selected = 0;
							// if the user press alphabets instead of numbers(integer)
							try {
								selected = Integer.parseInt(br.readLine());
							} catch (Exception e) {

							}

							// Check what user picks
							switch (selected) {
							// Add new Sweet Product
							case 1: {

								System.out.println("\nEnter Sweet Product Name: ");
								String sweetProductName = br.readLine();
								System.out.println("Enter Sweet Product Price: ");
								double sweetProductPrice = Double.parseDouble(br.readLine());
								System.out.println("Enter Sweet Product Discount Percentage: ");
								double sweetProductDiscount = Double.parseDouble(br.readLine());
								double finalPrice = ((100 - sweetProductDiscount) * sweetProductPrice) / 100;

								SweetProduct sweetProduct = new SweetProduct();

								sweetProduct.setSweetProductName(sweetProductName);
								sweetProduct.setSweetProductPrice(sweetProductPrice);
								sweetProduct.setSweetProductDiscount(sweetProductDiscount);
								sweetProduct.setSweetProductFinalPrice(finalPrice);

								int result = sweetProductDao.insertSweetProduct(sweetProduct);

								System.out.println("\n" + result + " Sweet Product added successfully!\n");

								break;
							}
							// Remove Sweet Product with Id
							case 2: {

								System.out.println("\nEnter the Sweet Product ID to delete the record: ");

								int sweetProductId = 0;
								// if the user press alphabets instead of numbers(integer)
								try {
									sweetProductId = Integer.parseInt(br.readLine());
								} catch (Exception e) {

								}

								int result = sweetProductDao.deleteSweetProduct(sweetProductId);

								if (result == 0) {
									System.out.println("\nNo Sweet Product present with Id: " + sweetProductId + "\n");
								} else {
									System.out.println("\nSweet Category removed successfully with id: "
											+ sweetProductId + " !!" + "\n");
								}

								break;
							}

							// Update Sweet Product Name with Id
							case 3: {

								System.out.println("Enter Sweet Product Id: ");
								int sweetProductId = 0;
								// if the user press alphabets instead of numbers(integer)
								try {
									sweetProductId = Integer.parseInt(br.readLine());
								} catch (Exception e) {

								}
								System.out.println("Enter Sweet Product new name: ");
								String sweetProductNewName = br.readLine();

								SweetProduct sweetProduct = new SweetProduct();

								sweetProduct.setSweetProductId(sweetProductId);
								sweetProduct.setSweetProductName(sweetProductNewName);

								int result = sweetProductDao.updateSweetProductName(sweetProduct);

								if (result == 0) {
									System.out.println("\nNo Sweet Product present with Id: " + sweetProductId + "\n");
								} else {
									System.out.println("\nSweet Product updated successfully!\n");
								}

								break;
							}

							// Display Sweet Product with Id
							case 4: {
								System.out.println("\nEnter the Sweet Product ID to display the record: ");

								int sweetProductId = 0;
								// if the user press alphabets instead of numbers(integer)
								try {
									sweetProductId = Integer.parseInt(br.readLine());
								} catch (Exception e) {

								}

								System.out.println();
								try {
									SweetProduct sweetProduct = sweetProductDao.getSweetProductById(sweetProductId);
									System.out.println(sweetProduct);
									System.out.println("\nSweet Product record displayed successfully!\n");
								} catch (Exception e) {
									System.out.println("\nNo Sweet Product present with Id: " + sweetProductId + "\n");
								}

								break;
							}

							// Display All Sweet Product
							case 5: {

								List<SweetProduct> sweetProducts = sweetProductDao.getAllSweetProduct();

								int count = 0;
								System.out.println();
								for (int i = 0; i < sweetProducts.size(); i++) {
									System.out.print((++count) + ". ");
									System.out.println(sweetProducts.get(i));
								}

								if (count == 0) {
									System.out.println("No data present in the table");
								} else {
									System.out.println();
								}

								break;

							}

							// Back
							case 6: {
								isExitFromFourthLoop = false;
								break;
							}

							// EXIT from the App
							case 7: {
								System.out.println(
										"\nThank you for using the application" + "\n" + "See you soon bye bye..!! ");
								System.exit(0);
							}

							// If select another option that is not present
							default: {
								System.out.println("\nInvalid option!!! Please try again!! \n");

								break;
							}

							}

						}

						break;

					}

					// Manage Users
					case 3: {

						boolean isAdminmanage = true;

						while (isAdminmanage) {

							System.out.println("\n---------- Sweet Category ----------\n");
							System.out.println("Press 1 to display all the users in the database");
							System.out.println("Press 2 to remove the user from the database");
							System.out.println("Press 3 to Back");
							System.out.println("Press 4 to EXIT");
							System.out.println("\n-----------------------------------\n");

							int selected = 0;
							// if the user press alphabets instead of numbers(integer)
							try {
								selected = Integer.parseInt(br.readLine());
							} catch (Exception e) {

							}

							switch (selected) {

							// Display all the User record
							case 1: {

								List<Users> users = userDao.getAllUsers();

								int count = 0;
								System.out.println();
								for (int i = 0; i < users.size(); i++) {
									System.out.print((++count) + ". ");
									System.out.println(users.get(i));
								}

								if (count == 0) {
									System.out.println("No data present in the table");
								} else {
									System.out.println();
								}

								break;

							}

							// Remove user with it's Id
							case 2: {

								System.out.println("\nEnter the User Id to delete the record: ");

								int userId = 0;
								// if the user press alphabets instead of numbers(integer)
								try {
									userId = Integer.parseInt(br.readLine());
								} catch (Exception e) {

								}

								int result = userDao.deleteUserFromDB(userId);

								if (result == 0) {
									System.out.println("\nNo User present with Id: " + userId + "\n");
								} else {
									System.out.println("\nUser removed successfully with id: " + userId + " !!" + "\n");
								}

								break;
							}

							// Back
							case 3: {
								isAdminmanage = false;
								break;
							}

							// EXIT
							case 4: {
								System.out.println(
										"\nThank you for using the application" + "\n" + "See you soon bye bye..!! ");
								System.exit(0);
							}

							// If select another option that is not present
							default: {
								System.out.println("\nInvalid option!!! Please try again!! \n");

								break;
							}

							}

						}

					}

					// If the user select for back
					case 4: {
						isExitFromSecondLoop = false;
						break;
					}

					// If the user select for EXIT from App
					case 5: {
						System.out
								.println("\nThank you for using the application" + "\n" + "See you soon bye bye..!! ");
						System.exit(0);
					}

					// If select another option that is not present
					default:
						System.out.println("\nInvalid option!!! Please try again!! \n");
						break;
					}

				}

				break;
			}
			// If the user is Customer
			case 2: {

				System.out.println("Enter Username: ");
				String username = br.readLine();
				System.out.println("Enter Password: ");
				String password = br.readLine();

				try {
					// Check if the user credentials are correct or not
					userDao.verifyuserFromDB(username, password, false);
					System.out.println("\nCustomer Logged in successfully!!!");
				} catch (Exception e) {
					// If the user credentials are incorrect
					System.out.println("\nInvalid Credentials!! Please try again!!! \n");
					break;
				}

				boolean isExitFromSecondLoop = true;

				// Different options to see sweets
				while (isExitFromSecondLoop) {
					System.out.println("\n------------------------------------");
					System.out.println("Press 1 for Sweet Category");
					System.out.println("Press 2 for Sweet Product");
					System.out.println("Press 3 to Back");
					System.out.println("Press 4 to EXIT");
					System.out.println("-----------------------------------");

					int selectSubtypes = 0;
					// if the user press alphabets instead of numbers(integer)
					try {
						selectSubtypes = Integer.parseInt(br.readLine());
					} catch (Exception e) {

					}

					// Check what user selects
					switch (selectSubtypes) {

					// If the user select for the Sweet Category
					case 1: {
						boolean isExitFromThirdLoop = true;

						// Perform different Sweet Category operations here until selects the Back or
						// EXIT option
						while (isExitFromThirdLoop) {

							System.out.println("---------- Sweet Category ----------\n");
							System.out.println("Press 1 to display a Sweet Category with it's ID");
							System.out.println("Press 2 to display all Sweet Category");
							System.out.println("Press 3 to Back");
							System.out.println("Press 4 to EXIT");
							System.out.println("\n-----------------------------------\n");

							int selected = 0;
							// if the user press alphabets instead of numbers(integer)
							try {
								selected = Integer.parseInt(br.readLine());
							} catch (Exception e) {

							}

							switch (selected) {

							// Display Sweet Category with Id
							case 1: {
								System.out.println("Enter the Sweet Category ID to display the record: ");

								int sweetCategoryId = 0;
								// if the user press alphabets instead of numbers(integer)
								try {
									sweetCategoryId = Integer.parseInt(br.readLine());
								} catch (Exception e) {

								}

								try {
									SweetCategory sweetCategory = sweetCategoryDao
											.getSweetCategoryById(sweetCategoryId);
									System.out.println(sweetCategory);
									System.out.println("\nSweet Category record displayed successfully!\n");

								} catch (Exception e) {
									System.out.println("\nNo Sweet Category present with Id" + sweetCategoryId + "\n");
								}

								break;
							}

							// Display All Sweet Category
							case 2: {

								// List to store all the sweet category
								List<SweetCategory> sweetCategories = sweetCategoryDao.getAllSweetCategory();

								int count = 0;
								System.out.println();

								// print all the sweet categories
								for (int i = 0; i < sweetCategories.size(); i++) {
									System.out.print((++count) + ". ");
									System.out.println(sweetCategories.get(i));
								}

								if (count == 0) {
									System.out.println("No data present in the table");
								} else {
									System.out.println();
								}

								break;

							}

							// If the user selects the Back option
							case 3: {
								isExitFromThirdLoop = false;
								break;
							}

							// If the user selects the EXIT option
							case 4: {
								System.out.println(
										"\nThank you for using the application" + "\n" + "See you soon bye bye..!! ");
								System.exit(0);
							}

							// If select another option that is not present
							default:
								System.out.println("\nInvalid option!!! Please try again!! \n");

								break;

							}

						}

						break;
					}

					case 2: {

						boolean isExitFromFourthLoop = true;

						// Perform different Sweet Product operations here until selects the Back or
						// EXIT option
						while (isExitFromFourthLoop) {

							System.out.println("---------- Sweet Products ----------\n");
							System.out.println("Press 1 to display a Sweet Product with it's ID");
							System.out.println("Press 2 to display all Sweet Product");
							System.out.println("Press 3 to Back");
							System.out.println("Press 4 to EXIT");
							System.out.println("\n-----------------------------------\n");

							int selected = 0;
							// if the user press alphabets instead of numbers(integer)
							try {
								selected = Integer.parseInt(br.readLine());
							} catch (Exception e) {

							}

							switch (selected) {

							// Display Sweet Product with it's id
							case 1: {
								System.out.println("Enter the Sweet Product ID to display the record: ");

								int sweetProductId = 0;
								// if the user press alphaisExitFromFourthLoop = false;bets instead of
								// numbers(integer)
								try {
									sweetProductId = Integer.parseInt(br.readLine());
								} catch (Exception e) {

								}

								System.out.println();
								try {
									// check if the sweet product with the given id exist or not
									SweetProduct sweetProduct = sweetProductDao.getSweetProductById(sweetProductId);
									System.out.println(sweetProduct);
									System.out.println("\nSweet Product record displayed successfully!\n");
								} catch (Exception e) {
									System.out.println("\nNo Sweet Product present with Id" + sweetProductId + "\n");
								}

								break;
							}

							// Display all the sweet products
							case 2: {

								// Create the list to hold all the sweet product
								List<SweetProduct> sweetProducts = sweetProductDao.getAllSweetProduct();

								int count = 0;
								System.out.println();

								// print all the sweet product present in the database
								for (int i = 0; i < sweetProducts.size(); i++) {
									System.out.print((++count) + ". ");
									System.out.println(sweetProducts.get(i));
								}

								if (count == 0) {
									System.out.println("\nNo data present in the table\n");
								} else {
									System.out.println();
								}

								break;
							}

							// Back
							case 3: {
								isExitFromFourthLoop = false;
								break;
							}

							// Exit from the App
							case 4: {
								System.out.println(
										"\nThank you for using the application" + "\n" + "See you soon bye bye..!! ");
								System.exit(0);
							}

							// If select another option that is not present
							default:
								System.out.println("\nInvalid option!!! Please try again!! \n");

								break;

							}

						}

						break;

					}

					// Back
					case 3: {
						isExitFromSecondLoop = false;
						break;
					}

					// EXIT from the App
					case 4: {
						System.out
								.println("\nThank you for using the application" + "\n" + "See you soon bye bye..!! ");
						System.exit(0);
					}

					// If select another option that is not present
					default:
						System.out.println("\nInvalid option!!! Please try again!! \n");

						break;
					}

				}

				break;
			}
			// If the user wants to Register
			case 3: {

				System.out.println("Enter Username : ");
				String username = br.readLine();
				System.out.println("Enter Password : ");
				String password = br.readLine();
				System.out.println("Is Admin (yes/no)");
				String isUserAdmin = br.readLine();
				boolean isAdmin = false;

				if (isUserAdmin.equals("yes")) {
					isAdmin = true;
				} else {
					isAdmin = false;
				}

				// Create the object for the Users to store the details given by user
				Users users = new Users();

				users.setUsername(username);
				users.setPassword(password);
				users.setIsAdminOrCustomer(isAdmin);

				try {
					// check if the user is added successfully or not
					userDao.insertUserToDB(users);

					if (isAdmin) {
						System.out.println("\nAdmin added successfully!!!\n");
					} else {
						System.out.println("\nCustomer added successfully!!!\n");
					}
				} catch (Exception e) {
					System.out.println("Something went wrong!!! Please try again!!!");
				}

				break;
			}

			// EXIT from the App
			case 4: {
				isExitFromFirstLoop = false;
				break;
			}

			// If select another option that is not present
			default:
				System.out.println("\nInvalid option!!! Please try again!! \n");
				break;

			}
		}

		System.out.println("\nThank you for using the application" + "\n" + "See you soon bye bye..!! ");

	}
}