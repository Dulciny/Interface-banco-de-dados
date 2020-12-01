import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.sql.DatabaseMetaData;

public class Conector {
	public String x = "";

	String server = "DESKTOP-673CKKR\\SQLEXPRESS";
	int port = 51077;
	String user = "iwo";
	String pass = "12345";
	String database = "soparia";
	String jdbcurl = "jdbc:sqlserver://" + server + ":" + port + ";user=" + user + ";password=" + pass
			+ ";databasename=" + database + "";
	Connection con = null;
	public DefaultTableModel dtm, dtm2, dtm3, dtm4, dtm5;

	public String Conectar() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			x = "";
			con = DriverManager.getConnection(jdbcurl);
			DatabaseMetaData metaData = con.getMetaData();
			String[] types = { "TABLE" };
			// Retrieving the columns in the database
			ResultSet tables = metaData.getTables("Soparia", null, "%", types);
			while (tables.next()) {
				if (!"trace_xe_action_map".equals(tables.getString("TABLE_NAME"))
						&& !"trace_xe_event_map".equals(tables.getString("TABLE_NAME")))
					x += tables.getString("TABLE_NAME") + "\n";

			}

			con.close();

		} catch (SQLException e) {
		}

		return x;

	}

	public DefaultTableModel SelTab(String x) {
		try {
			con = DriverManager.getConnection(jdbcurl);
			Statement stmt = con.createStatement();
			Executor tab = new Executor();			

			if (x.equals("Bebidas")) {
				ResultSet rs = stmt.executeQuery("select * from " + x  + " order by IDBebida asc");
				dtm = (DefaultTableModel) tab.table.getModel();
				while (rs.next()) {
					dtm.addRow(new Object[] { rs.getInt("IDBebida"), rs.getString("Bebida"), rs.getString("PesoML"),
							rs.getString("Preço") });
				}
			} else if (x.equals("Clientes")) {
				ResultSet rs = stmt.executeQuery("select * from " + x  + " order by IDCliente asc");
				dtm = (DefaultTableModel) tab.table2.getModel();
				while (rs.next()) {
					dtm.addRow(new Object[] { rs.getInt("IDCliente"), rs.getString("Nome"), rs.getString("CPF"),
							rs.getString("Cidade"), rs.getString("CEP")

					});

				}
			} else if (x.equals("Vendedores")) {
				ResultSet rs = stmt.executeQuery("select * from " + x + " order by IDVendedor asc");
				dtm = (DefaultTableModel) tab.table5.getModel();
				while (rs.next()) {
					dtm.addRow(new Object[] { rs.getInt("IDVendedor"), rs.getString("Nome"), rs.getString("Salário")

					});
				}
			} else if (x.equals("Tijelas")) {
				ResultSet rs = stmt.executeQuery("select * from " + x  + " order by IDtijela asc");
				dtm = (DefaultTableModel) tab.table4.getModel();
				while (rs.next()) {
					dtm.addRow(new Object[] { rs.getInt("IDtijela"), rs.getString("Sabor"), rs.getString("PesoML"),
							rs.getString("Preço")

					});
				}
			} else if (x.equals("Pedidos")) {
				ResultSet rs = stmt.executeQuery("select * from " + x  + " order by IDPedido asc");
				dtm = (DefaultTableModel) tab.table3.getModel();
				while (rs.next()) {
					dtm.addRow(new Object[] { rs.getInt("IDPedido"), rs.getInt("IDVendedor"), rs.getString("IDCliente"),
							rs.getString("IDSopa"), rs.getString("Quantidade_sopa"), rs.getInt("IDBebida"),
							rs.getString("Quantidade_Bebida"), rs.getString("Preço")

					});
				}
			}

			con.close();
			stmt.close();

		} catch (SQLException e) {			
		}

		return dtm;

	}

	public void Deletar(String x, int y) {
		try {
			con = DriverManager.getConnection(jdbcurl);
			Statement stmt = con.createStatement();
			Executor tab = new Executor();

			if (x.equals("Bebidas")) {

				ResultSet rs = stmt.executeQuery("delete from Bebidas where IDBebida = " + y);

			} else if (x.equals("Clientes")) {

				ResultSet rs = stmt.executeQuery("delete from Clientes where IDCliente = " + y);

			} else if (x.equals("Vendedores")) {

				ResultSet rs = stmt.executeQuery("delete from Vendedores where IDVendedor = " + y);

			} else if (x.equals("Tijelas")) {

				ResultSet rs = stmt.executeQuery("delete from Tijelas where IDtijela = " + y);

			} else if (x.equals("Pedidos")) {

				ResultSet rs = stmt.executeQuery("delete from Pedidos where IDPedido = " + y);

			}

			SelTab(x);
			con.close();
			stmt.close();

		} catch (SQLException e) {
		}

	}

	public void Cadastrar(String x, String a, String b, String c, String d, String e, String f, String g, String h) {
		try {
			con = DriverManager.getConnection(jdbcurl);
			Statement stmt = con.createStatement();
			Executor tab = new Executor();
			if (x.equals("Bebidas")) {
				ResultSet rs = stmt.executeQuery("insert into Bebidas(IDBebida, Bebida, PesoML, Preço) Values(" + a
						+ "," + b + "," + c + "," + d + ")");

			} else if (x.equals("Clientes")) {

				ResultSet rs = stmt.executeQuery("insert into Clientes(IDCliente, Nome, CPF, Cidade, CEP) Values(" + a
						+ "," + b + "," + c + "," + d + "," + e + ")");

			} else if (x.equals("Vendedores")) {

				ResultSet rs = stmt.executeQuery(
						"insert into Vendedores(IDVendedor, Nome, Salário) Values(" + a + "," + b + "," + c + ")");

			} else if (x.equals("Tijelas")) {

				ResultSet rs = stmt.executeQuery("insert into Tijelas(IDtijela, Sabor, PesoML,Preço) Values(" + a + ","
						+ b + "," + c + "," + d + ")");

			} else if (x.equals("Pedidos")) {

				ResultSet rs = stmt.executeQuery(
						"insert into Pedidos(IDPedido, IDVendedor, IDCliente, IDSopa, Quantidade_Sopa, IDBebida,Quantidade_Bebida,Preço) Values("
								+ a + "," + b + "," + c + "," + d + "," + e + "," + f + "," + g + "," + h + ")");

			}

			con.close();
			stmt.close();

		} catch (SQLException e1) {
		}

	}

	public void Alterar(String u, int x, String y, String z) {
		try {
			con = DriverManager.getConnection(jdbcurl);
			Statement stmt = con.createStatement();
			Executor tab = new Executor();

			if (u.equals("Bebidas")) {

				ResultSet rs = stmt.executeQuery("update Bebidas set " + y + " = " + z + " where IDBebida = " + x);

			} else if (u.equals("Clientes")) {

				ResultSet rs = stmt.executeQuery("update Clientes set " + y + " = " + z + " where IDCliente = " + x);

			} else if (u.equals("Vendedores")) {

				ResultSet rs = stmt.executeQuery("update Vendedores set " + y + " = " + z + " where IDVendedor = " + x);

			} else if (u.equals("Tijelas")) {

				ResultSet rs = stmt.executeQuery("update Tijelas set " + y + " = " + z + " where IDtijela = " + x);

			} else if (u.equals("Pedidos")) {

				ResultSet rs = stmt.executeQuery("update Pedidos set " + y + " = " + z + " where IDPedido = " + x);

			}

			SelTab(u);
			con.close();
			stmt.close();

		} catch (SQLException e) {
		}
	}

}