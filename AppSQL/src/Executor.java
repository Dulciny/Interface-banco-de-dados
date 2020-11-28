import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.JSeparator;

public class Executor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTable table, table2, table3, table4, table5;
	private JScrollPane scp, scp2, scp3, scp4, scp5;
	public String x;
	public JTextField text7, text4, text8, text5, txtDeletar, txtNomeTabela, text1, text3, text6, text2, textIDAltera,
			textColunaAltera, textValorAltera;
	private JLabel lbl1, lbl5, lbl2, lbl3, lbl6, lbl7, lbl4, lbl8;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Executor frame = new Executor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Executor() {
		Conector nec = new Conector();
		setTitle("SQLEditor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 175);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/* Tabelas */

		scp = new JScrollPane();
		scp.setBounds(456, 11, 873, 700);
		contentPane.add(scp);
		table = new JTable();
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "IDBebida", "Bebida", "PesoML", "Preço" }));
		scp.setViewportView(table);
		table.setVisible(false);
		scp.setVisible(false);

		scp2 = new JScrollPane();
		scp2.setBounds(456, 11, 873, 700);
		contentPane.add(scp2);
		table2 = new JTable();
		table2.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "IDCliente", "Nome", "CPF", "Cidade", "CEP" }));
		scp2.setViewportView(table2);
		table2.setVisible(false);
		scp2.setVisible(false);

		scp3 = new JScrollPane();
		scp3.setBounds(456, 11, 873, 700);
		contentPane.add(scp3);
		table3 = new JTable();
		table3.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "IDPedido", "IDVendedor", "IDCliente",
				"IDSopa", "Quantidade_Sopa", "IDBebida", "Quantidade_Bebida", "Preço" }));
		scp3.setViewportView(table3);
		table3.setVisible(false);
		scp3.setVisible(false);

		scp4 = new JScrollPane();
		scp4.setBounds(456, 11, 873, 700);
		contentPane.add(scp4);
		table4 = new JTable();
		table4.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "IDtijela", "Sabor", "PesoML", "Preço" }));
		scp4.setViewportView(table4);
		table4.setVisible(false);
		scp4.setVisible(false);

		scp5 = new JScrollPane();
		scp5.setBounds(456, 11, 873, 700);
		contentPane.add(scp5);
		table5 = new JTable();
		table5.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "IDVendedor", "Nome", "Salário" }));
		scp5.setViewportView(table5);
		table5.setVisible(false);
		scp5.setVisible(false);

		/* Tabelas */

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(310, 39, 136, 88);
		contentPane.add(scrollPane_1);

		JTextArea txtTabelas = new JTextArea();
		txtTabelas.setForeground(UIManager.getColor("SplitPaneDivider.draggingColor"));
		txtTabelas.setFont(new Font("Unispace", Font.PLAIN, 12));
		txtTabelas.setEditable(false);
		scrollPane_1.setViewportView(txtTabelas);
		txtTabelas.setText(nec.Conectar());

		JLabel lblNewLabel = new JLabel("SQLEditor");
		lblNewLabel.setBounds(10, 17, 290, 36);
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Unispace", Font.BOLD, 26));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tabelas dispon\u00EDveis");
		lblNewLabel_1.setBounds(308, 23, 136, 14);
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setFont(new Font("Unispace", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("Nome da tabela:");
		lblNewLabel_3.setBounds(10, 82, 176, 14);
		lblNewLabel_3.setForeground(UIManager.getColor("SplitPaneDivider.draggingColor"));
		lblNewLabel_3.setBackground(new Color(204, 102, 51));
		lblNewLabel_3.setFont(new Font("Unispace", Font.BOLD, 12));
		contentPane.add(lblNewLabel_3);

		txtNomeTabela = new JTextField();
		txtNomeTabela.setBounds(10, 96, 148, 20);
		txtNomeTabela.setForeground(UIManager.getColor("SplitPaneDivider.draggingColor"));
		contentPane.add(txtNomeTabela);
		txtNomeTabela.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 64, 290, 7);
		separator.setBackground(UIManager.getColor("ToggleButton.darkShadow"));
		separator.setForeground(UIManager.getColor("Viewport.background"));
		contentPane.add(separator);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 156, 436, 287);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Cadastrar");
		lblNewLabel_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Unispace", Font.BOLD, 25));
		lblNewLabel_2.setBounds(10, 11, 416, 40);
		panel.add(lblNewLabel_2);

		lbl1 = new JLabel("New label");
		lbl1.setForeground(UIManager.getColor("SplitPaneDivider.draggingColor"));
		lbl1.setFont(new Font("Unispace", Font.PLAIN, 11));
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setBounds(10, 62, 204, 14);
		panel.add(lbl1);

		lbl5 = new JLabel("New label");
		lbl5.setForeground(UIManager.getColor("SplitPaneDivider.draggingColor"));
		lbl5.setFont(new Font("Unispace", Font.PLAIN, 11));
		lbl5.setHorizontalAlignment(SwingConstants.CENTER);
		lbl5.setBounds(222, 62, 204, 14);
		panel.add(lbl5);

		text1 = new JTextField();
		text1.setBounds(10, 76, 204, 20);
		panel.add(text1);
		text1.setColumns(10);

		text2 = new JTextField();
		text2.setColumns(10);
		text2.setBounds(10, 121, 204, 20);
		panel.add(text2);

		lbl2 = new JLabel("New label");
		lbl2.setForeground(UIManager.getColor("SplitPaneDivider.draggingColor"));
		lbl2.setFont(new Font("Unispace", Font.PLAIN, 11));
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setBounds(10, 107, 204, 14);
		panel.add(lbl2);

		text3 = new JTextField();
		text3.setColumns(10);
		text3.setBounds(10, 166, 204, 20);
		panel.add(text3);

		lbl3 = new JLabel("New label");
		lbl3.setForeground(UIManager.getColor("SplitPaneDivider.draggingColor"));
		lbl3.setFont(new Font("Unispace", Font.PLAIN, 11));
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setBounds(10, 152, 204, 14);
		panel.add(lbl3);

		text6 = new JTextField();
		text6.setColumns(10);
		text6.setBounds(222, 121, 204, 20);
		panel.add(text6);

		lbl6 = new JLabel("New label");
		lbl6.setForeground(UIManager.getColor("SplitPaneDivider.draggingColor"));
		lbl6.setFont(new Font("Unispace", Font.PLAIN, 11));
		lbl6.setHorizontalAlignment(SwingConstants.CENTER);
		lbl6.setBounds(222, 107, 204, 14);
		panel.add(lbl6);

		text7 = new JTextField();
		text7.setColumns(10);
		text7.setBounds(222, 166, 204, 20);
		panel.add(text7);

		lbl7 = new JLabel("New label");
		lbl7.setForeground(UIManager.getColor("SplitPaneDivider.draggingColor"));
		lbl7.setFont(new Font("Unispace", Font.PLAIN, 11));
		lbl7.setHorizontalAlignment(SwingConstants.CENTER);
		lbl7.setBounds(222, 152, 204, 14);
		panel.add(lbl7);

		text4 = new JTextField();
		text4.setColumns(10);
		text4.setBounds(10, 211, 204, 20);
		panel.add(text4);

		lbl4 = new JLabel("New label");
		lbl4.setForeground(UIManager.getColor("SplitPaneDivider.draggingColor"));
		lbl4.setFont(new Font("Unispace", Font.PLAIN, 11));
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl4.setBounds(10, 197, 204, 14);
		panel.add(lbl4);

		text8 = new JTextField();
		text8.setColumns(10);
		text8.setBounds(222, 211, 204, 20);
		panel.add(text8);

		lbl8 = new JLabel("New label");
		lbl8.setForeground(UIManager.getColor("SplitPaneDivider.draggingColor"));
		lbl8.setFont(new Font("Unispace", Font.PLAIN, 11));
		lbl8.setHorizontalAlignment(SwingConstants.CENTER);
		lbl8.setBounds(222, 197, 204, 14);
		panel.add(lbl8);

		text5 = new JTextField();
		text5.setColumns(10);
		text5.setBounds(222, 76, 204, 20);
		panel.add(text5);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 623, 436, 88);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("Deletar");
		lblNewLabel_6.setFont(new Font("Unispace", Font.BOLD, 24));
		lblNewLabel_6.setForeground(SystemColor.textHighlight);
		lblNewLabel_6.setBackground(SystemColor.textHighlight);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(10, 11, 416, 26);
		panel_1.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("ID");
		lblNewLabel_7.setForeground(UIManager.getColor("SplitPaneDivider.draggingColor"));
		lblNewLabel_7.setFont(new Font("Unispace", Font.BOLD, 18));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setBounds(57, 42, 101, 25);
		panel_1.add(lblNewLabel_7);

		txtDeletar = new JTextField();
		txtDeletar.setHorizontalAlignment(SwingConstants.LEFT);
		txtDeletar.setBounds(168, 42, 48, 26);
		panel_1.add(txtDeletar);
		txtDeletar.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 454, 434, 158);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Alterar Dados");
		lblNewLabel_4.setForeground(SystemColor.textHighlight);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Unispace", Font.BOLD, 25));
		lblNewLabel_4.setBounds(10, 11, 414, 43);
		panel_2.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("ID");
		lblNewLabel_5.setForeground(UIManager.getColor("SplitPaneDivider.draggingColor"));
		lblNewLabel_5.setFont(new Font("Unispace", Font.BOLD, 20));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(69, 53, 46, 25);
		panel_2.add(lblNewLabel_5);

		textIDAltera = new JTextField();
		textIDAltera.setBounds(69, 79, 46, 20);
		panel_2.add(textIDAltera);
		textIDAltera.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Coluna");
		lblNewLabel_8.setForeground(UIManager.getColor("SplitPaneDivider.draggingColor"));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Unispace", Font.BOLD, 20));
		lblNewLabel_8.setBounds(125, 53, 93, 25);
		panel_2.add(lblNewLabel_8);

		textColunaAltera = new JTextField();
		textColunaAltera.setBounds(125, 79, 93, 20);
		panel_2.add(textColunaAltera);
		textColunaAltera.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Novo valor");
		lblNewLabel_9.setForeground(UIManager.getColor("SplitPaneDivider.draggingColor"));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Unispace", Font.BOLD, 20));
		lblNewLabel_9.setBounds(228, 55, 129, 21);
		panel_2.add(lblNewLabel_9);

		textValorAltera = new JTextField();
		textValorAltera.setBounds(228, 79, 129, 20);
		panel_2.add(textValorAltera);
		textValorAltera.setColumns(10);

		/* Botões */

		JButton btnSalvarCadastro = new JButton("Salvar");
		btnSalvarCadastro.setBackground(Color.PINK);
		btnSalvarCadastro.setForeground(UIManager.getColor("SplitPaneDivider.draggingColor"));
		btnSalvarCadastro.setFont(new Font("Unispace", Font.BOLD, 18));
		btnSalvarCadastro.setBounds(83, 242, 273, 34);
		panel.add(btnSalvarCadastro);
		btnSalvarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrar();
			}
		});

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBackground(Color.PINK);
		btnDeletar.setForeground(UIManager.getColor("SplitPaneDivider.draggingColor"));
		btnDeletar.setFont(new Font("Unispace", Font.BOLD, 12));
		btnDeletar.setBounds(226, 41, 89, 26);
		panel_1.add(btnDeletar);
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				del();
			}
		});

		JButton btnSalvaAltera = new JButton("Salvar");
		btnSalvaAltera.setBackground(Color.PINK);
		btnSalvaAltera.setFont(new Font("Unispace", Font.BOLD, 18));
		btnSalvaAltera.setForeground(UIManager.getColor("SplitPaneDivider.draggingColor"));
		btnSalvaAltera.setBounds(79, 110, 278, 37);
		panel_2.add(btnSalvaAltera);
		btnSalvaAltera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Alterar();
				} catch (Exception e2) {
				}

			}
		});

		JButton btnSelecionarTabela = new JButton("Selecionar");
		btnSelecionarTabela.setBounds(184, 95, 108, 20);
		btnSelecionarTabela.setFont(new Font("Unispace", Font.BOLD, 11));
		btnSelecionarTabela.setBackground(Color.PINK);
		contentPane.add(btnSelecionarTabela);
		btnSelecionarTabela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecTab();
			}
		});

	}

	public void tipoTabela() {
		setBounds(100, 100, 1355, 759);
		noLBL();
		if (txtNomeTabela.getText().equals("Bebidas")) {
			inv();
			scp.setVisible(true);
			table.setVisible(true);
			lbl1.setText("IDBebida");
			lbl1.setEnabled(true);
			lbl2.setText("Bebida");
			lbl2.setEnabled(true);
			lbl3.setText("PesoMl");
			lbl3.setEnabled(true);
			lbl4.setText("Preço");
			lbl4.setEnabled(true);
			text1.setEnabled(true);
			text2.setEnabled(true);
			text3.setEnabled(true);
			text4.setEnabled(true);
		} else if (txtNomeTabela.getText().equals("Clientes")) {
			inv();
			scp2.setVisible(true);
			table2.setVisible(true);
			lbl1.setText("IDCliente");
			lbl1.setEnabled(true);
			lbl2.setText("Nome");
			lbl2.setEnabled(true);
			lbl3.setText("CPF");
			lbl3.setEnabled(true);
			lbl4.setText("Cidade");
			lbl4.setEnabled(true);
			lbl5.setText("CEP");
			lbl5.setEnabled(true);
			text1.setEnabled(true);
			text2.setEnabled(true);
			text3.setEnabled(true);
			text4.setEnabled(true);
			text5.setEnabled(true);
		} else if (txtNomeTabela.getText().equals("Vendedores")) {
			inv();
			scp5.setVisible(true);
			table5.setVisible(true);
			lbl1.setText("IDVendedor");
			lbl1.setEnabled(true);
			lbl2.setText("Nome");
			lbl2.setEnabled(true);
			lbl3.setText("Salário");
			lbl3.setEnabled(true);
			text1.setEnabled(true);
			text2.setEnabled(true);
			text3.setEnabled(true);
		} else if (txtNomeTabela.getText().equals("Pedidos")) {
			inv();
			scp3.setVisible(true);
			table3.setVisible(true);
			lbl1.setText("IDPedido");
			lbl1.setEnabled(true);
			lbl2.setText("IDvendedor");
			lbl2.setEnabled(true);
			lbl3.setText("IDCliente");
			lbl3.setEnabled(true);
			lbl4.setText("IDSopa");
			lbl4.setEnabled(true);
			lbl5.setText("Quantidade Sopa");
			lbl5.setEnabled(true);
			lbl6.setText("IDBebida");
			lbl6.setEnabled(true);
			lbl7.setText("Quantidade Bebida");
			lbl7.setEnabled(true);
			lbl8.setText("Preço");
			lbl8.setEnabled(true);
			text1.setEnabled(true);
			text2.setEnabled(true);
			text3.setEnabled(true);
			text4.setEnabled(true);
			text5.setEnabled(true);
			text6.setEnabled(true);
			text7.setEnabled(true);
			text8.setEnabled(true);
		} else if (txtNomeTabela.getText().equals("Tijelas")) {
			inv();
			scp4.setVisible(true);
			table4.setVisible(true);
			lbl1.setText("IDTijela");
			lbl1.setEnabled(true);
			lbl2.setText("Sabor");
			lbl2.setEnabled(true);
			lbl3.setText("PesoML");
			lbl3.setEnabled(true);
			lbl4.setText("Preço");
			lbl4.setEnabled(true);
			text1.setEnabled(true);
			text2.setEnabled(true);
			text3.setEnabled(true);
			text4.setEnabled(true);
		}

	}

	public void inv() {
		scp.setVisible(false);
		scp2.setVisible(false);
		scp3.setVisible(false);
		scp4.setVisible(false);
		scp5.setVisible(false);
		table.setVisible(false);
		table2.setVisible(false);
		table3.setVisible(false);
		table4.setVisible(false);
		table5.setVisible(false);

	}

	public void noLBL() {

		lbl1.setText("-");
		lbl2.setText("-");
		lbl3.setText("-");
		lbl4.setText("-");
		lbl5.setText("-");
		lbl6.setText("-");
		lbl7.setText("-");
		lbl8.setText("-");
		lbl1.setEnabled(false);
		lbl2.setEnabled(false);
		lbl3.setEnabled(false);
		lbl4.setEnabled(false);
		lbl5.setEnabled(false);
		lbl6.setEnabled(false);
		lbl7.setEnabled(false);
		lbl8.setEnabled(false);
		text1.setEnabled(false);
		text2.setEnabled(false);
		text3.setEnabled(false);
		text4.setEnabled(false);
		text5.setEnabled(false);
		text6.setEnabled(false);
		text7.setEnabled(false);
		text8.setEnabled(false);
	}

	public void del() {
		x = txtNomeTabela.getText();
		Conector nec = new Conector();
		try {
			nec.Deletar(x, Integer.valueOf(txtDeletar.getText()));
			txtDeletar.setText("");
			selecTab();
		} catch (Exception e) {
		}

	}

	public void cadastrar() {
		Conector nec = new Conector();
		x = txtNomeTabela.getText();

		String a = text1.getText();
		String b = text2.getText();
		String c = text3.getText();
		String d = text4.getText();
		String e = text5.getText();
		String f = text6.getText();
		String g = text7.getText();
		String h = text8.getText();

		if (txtNomeTabela.getText().equals("Bebidas")) {

			nec.Cadastrar(x, a, "'" + b + "'", c, "'" + d + "'", null, null, null, null);

		} else if (txtNomeTabela.getText().equals("Clientes")) {

			nec.Cadastrar(x, a, "'" + b + "'", c, "'" + d + "'", e, null, null, null);

		} else if (txtNomeTabela.getText().equals("Vendedores")) {

			nec.Cadastrar(x, a, "'" + b + "'", "'" + c + "'", null, null, null, null, null);

		} else if (txtNomeTabela.getText().equals("Pedidos")) {

			nec.Cadastrar(x, a, b, c, d, e, f, g, "'" + h + "'");

		} else if (txtNomeTabela.getText().equals("Tijelas")) {

			nec.Cadastrar(x, a, "'" + b + "'", "'" + c + "'", "'" + d + "'", null, null, null, null);

		}
		text1.setText("");
		text2.setText("");
		text3.setText("");
		text4.setText("");
		text5.setText("");
		text6.setText("");
		text7.setText("");
		text8.setText("");

		selecTab();

	}

	public void selecTab() {
		Conector nec = new Conector();
		x = txtNomeTabela.getText();
		if (txtNomeTabela.getText().equals("Bebidas")) {
			table.setModel(nec.SelTab(x));
			tipoTabela();
		} else if (txtNomeTabela.getText().equals("Clientes")) {
			table2.setModel(nec.SelTab(x));
			tipoTabela();
		} else if (txtNomeTabela.getText().equals("Vendedores")) {
			table5.setModel(nec.SelTab(x));
			tipoTabela();
		} else if (txtNomeTabela.getText().equals("Pedidos")) {
			table3.setModel(nec.SelTab(x));
			tipoTabela();
		} else if (txtNomeTabela.getText().equals("Tijelas")) {
			table4.setModel(nec.SelTab(x));
			tipoTabela();
		}

	}

	public void Alterar() {
		Conector nec = new Conector();
		x = txtNomeTabela.getText();
		int y = Integer.valueOf(textIDAltera.getText());
		String z = textColunaAltera.getText();
		String v = " ' " + textValorAltera.getText() + " ' ";

		nec.Alterar(x, y, z, v);
		textColunaAltera.setText("");
		textValorAltera.setText("");
		textIDAltera.setText("");
		selecTab();

	}
}
