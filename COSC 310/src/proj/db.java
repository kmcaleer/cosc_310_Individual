package proj;
import java.sql.*;
import java.text.SimpleDateFormat;

public class db {
    private Connection con;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	
	/**
	 * Creates a connection to the database
	 * @return
	 * the connection
	 * @throws SQLException
	 */


    public Connection connect() throws SQLException
	{
		String url = "jdbc:mysql://localhost/inventorySystem"; 
		String uid = "team22";        
		String pw = "310pw";

		System.out.println("Connecting to database.");
		con = DriverManager.getConnection(url, uid, pw);
		return con;		                       
	}
	/**
	 * Closes the connection to the database
	 */
	public void close()
	{
		System.out.println("Closing database connection.");
		try
		{
			if (con != null)
	            con.close();
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}
	/**
	 * Adds a product to the product table in the inventorySystem databse
	 * @param p
	 * Takes a product object as an argument
	 */
	public void addProduct(Product p){

		try{
			String sql = "INSERT INTO product VALUES (?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,p.getName());
			pstmt.setDate(2,new Date(sdf.parse(p.getExpDate()).getTime()));
			pstmt.setInt(3,p.getQuant());
			pstmt.setDouble(4, p.getValue());
			pstmt.executeUpdate();
			pstmt.close();


		}
		catch(Exception e){
			System.out.println(e);
		}

	}
	/**
	 * Adds a user to the user table in the inventorySystem database
	 * @param u
	 * Takes in a user object as an argument
	 */
	public void addUser(User u){

		try{
			String sql = "INSERT INTO user VALUES (?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,u.getUsername());
			pstmt.setString(2,u.getPassword());
			pstmt.setString(3,u.getEmail());
			pstmt.executeUpdate();
			pstmt.close();


		}
		catch(Exception e){
			System.out.println(e);
		}

	}
	/**
	 * Adds a supplier to the supplier table in the database
	 * @param s
	 * Takes a Supplier object as an argument
	 */
	public void addSupplier(Supplier s){
		try{
			String sql = "INSERT INTO supplier VALUES (?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,s.getSupplierName());
			pstmt.setString(2,s.getSupplierEmail());
			pstmt.setString(3,s.getProduct());
			pstmt.executeUpdate();
			pstmt.close();


		}
		catch(Exception e){
			System.out.println(e);
		}

	}
	/**
	 * Removes a product from the database
	 * @param productName
	 * Takes a string representing productName as an argument 
	 */	
	public void removeProduct(String productName){
		try{
			String sql = "DELETE FROM product WHERE productName=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,productName);
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch(Exception e){
			System.out.println(e);
		}

	}
	/**
	 * Removes a user from the database
	 * @param productName
	 * Takes a string representing username as an argument 
	 */	
	
	public void removeUser(String userName){
		try{
			String sql = "DELETE FROM user WHERE username=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,userName);
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch(Exception e){
			System.out.println(e);
		}

	}
	/**
	 * Removes a supplierfrom the database
	 * @param productName
	 * Takes a string representing supplierName as an argument 
	 */	
	public void removeSupplier(String supplierName){
		try{
			String sql = "DELETE FROM supplier WHERE supplierName=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,supplierName);
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch(Exception e){
			System.out.println(e);
		}

	}
	
	/**
	 * Returns a list of products in the database
	 * @return
	 * Returns a string representing products in the Product table
	 * 			Format
	 * productName,Expiry Date, Quantity, Value
	 */
	public String listProducts(){
		StringBuilder products = new StringBuilder();
		try{
			String sql="SELECT * FROM product";
			Statement stmt= con.createStatement();
			ResultSet rst = stmt.executeQuery(sql);
			System.out.println("Product Name,	Expiry Date,	Quantity,	Value");
			while(rst.next()){
				products.append(rst.getString("productName")+",	"+rst.getDate("expiryDate")+",	"+rst.getInt("quantity")+",	"+rst.getDouble("productValue")+"\n");
			}
				
			stmt.close();
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		return products.toString();
	}
	/**
	 * Returns a list of products low in quanitity in the database
	 * @return
	 * Returns a string representing products in the Product table
	 * 			Format
	 * productName,Expiry Date, Quantity, Value
	 */
	public String listLowInventryProducts(){
		StringBuilder products = new StringBuilder();
		try{
			String sql="SELECT * FROM product WHERE quantity<100";
			Statement stmt= con.createStatement();
			ResultSet rst = stmt.executeQuery(sql);
			System.out.println("Product Name,	Expiry Date,	Quantity,	Value");
			while(rst.next()){
				products.append(rst.getString("productName")+",	"+rst.getDate("expiryDate")+",	"+rst.getInt("quantity")+",	"+rst.getDouble("productValue")+"\n");
			}
				
			stmt.close();
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		return products.toString();

	}
	/**
	 * Modiifies the quantity of the product stored in the database
	 * @param productName
	 * takes a string as an argument representing productName of the product you want to modify quantity
	 * @param quantity
	 * takes an integer representing new quantity
	 * 
	 */
	public void modifyQuantity(String productName,int quantity){
		try{
			String sql = "UPDATE product SET quantity=? WHERE productName=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,quantity);
			pstmt.setString(2, productName);
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch(Exception e){
			System.out.println(e);
		}

	}
			


}
