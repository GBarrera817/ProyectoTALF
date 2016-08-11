package vista;

import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import modelo.JSON2XML;
import modelo.JSONLexer;
import modelo.JSONParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.*;

/**
 * Creado por Gabriela Barrera el 20-07-2016.
 * Proyecto: ProyectoTALF2016
 */

public class VentanaPrincipal extends JFrame implements ActionListener {

	private JMenuBar menuBar;
	private JMenuItem mntmSalir;
	private JMenu mnNewMenu;
	private JMenuItem mntmAbrir;
	private JMenuItem mntmGuardarEntrada;
	private JPanel panelEntrada;
	private JPanel panelSalida;
	private JLabel lblEntrada;
	private JLabel lblSalida;
	private JTextArea txtAreaSalida;
	private JButton btnConvertir;

	private JFileChooser jfcExaminarEntrada, jfcGuardar;
	private JTextField txtRuta;
	private JLabel lblRutaDelArchivo;
	private JButton btnExaminar;
	private JTextArea txtAreaEntrada;
	private JScrollPane scrollPane;

	private int resultado;
	private JScrollPane scrollPane_1;
	private JMenuItem mntmGuardarSalida;
	private JButton btnVisualizar;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;

    private VentanaPrincipal(){
    	initComponents();
    }
    
    private void initComponents() {
    	setResizable(false);

    	setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Workspace IntelliJ IDEA\\ProyectoTALF2016\\img\\icons\\json.png"));
        setVisible(true);
        setSize(960, 640);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	setTitle("JSON Converter - Proyecto TALF 2016");
    	
    	menuBar = new JMenuBar();
    	setJMenuBar(menuBar);
    	
    	mnNewMenu = new JMenu("Archivo");
    	menuBar.add(mnNewMenu);
    	
    	mntmSalir = new JMenuItem("Salir");
    	mntmSalir.addActionListener(this);
    	mntmSalir.setIcon(new ImageIcon("D:\\Workspace IntelliJ IDEA\\ProyectoTALF2016\\img\\icons\\tango-icon-theme-0.8.90\\16x16\\emblems\\emblem-unreadable.png"));
    	mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
    	mnNewMenu.add(mntmSalir);
    	
    	mnNewMenu_1 = new JMenu("Abrir");
    	menuBar.add(mnNewMenu_1);
    	
    	mntmAbrir = new JMenuItem("Abrir");
    	mnNewMenu_1.add(mntmAbrir);
    	mntmAbrir.addActionListener(this);
    	mntmAbrir.setIcon(new ImageIcon("D:\\Workspace IntelliJ IDEA\\ProyectoTALF2016\\img\\icons\\tango-icon-theme-0.8.90\\16x16\\actions\\document-open.png"));
    	mntmAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
    	
    	mnNewMenu_2 = new JMenu("Guardar");
    	menuBar.add(mnNewMenu_2);
    	
    	mntmGuardarEntrada = new JMenuItem("Guardar Entrada");
    	mnNewMenu_2.add(mntmGuardarEntrada);
    	mntmGuardarEntrada.addActionListener(this);
    	mntmGuardarEntrada.setIcon(new ImageIcon("D:\\Workspace IntelliJ IDEA\\ProyectoTALF2016\\img\\icons\\tango-icon-theme-0.8.90\\16x16\\actions\\document-save.png"));
    	mntmGuardarEntrada.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
    	
    	mntmGuardarSalida = new JMenuItem("Guardar Salida");
    	mnNewMenu_2.add(mntmGuardarSalida);
    	mntmGuardarSalida.addActionListener(this);
    	mntmGuardarSalida.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
    	mntmGuardarSalida.setIcon(new ImageIcon("D:\\Workspace IntelliJ IDEA\\ProyectoTALF2016\\img\\icons\\tango-icon-theme-0.8.90\\16x16\\actions\\document-save-as.png"));
    	getContentPane().setLayout(null);
    	
    	panelEntrada = new JPanel();
    	panelEntrada.setBounds(0, 0, 470, 580);
    	getContentPane().add(panelEntrada);
    	panelEntrada.setLayout(null);

    	btnConvertir = new JButton("Convertir");
    	btnConvertir.addActionListener(this);
    	btnConvertir.setBounds(187, 521, 89, 23);
    	panelEntrada.add(btnConvertir);
    	
    	txtRuta = new JTextField();
    	txtRuta.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
    	txtRuta.setBounds(10, 36, 406, 23);
    	panelEntrada.add(txtRuta);
    	txtRuta.setColumns(10);
    	
    	lblRutaDelArchivo = new JLabel("Ruta del archivo");
    	lblRutaDelArchivo.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
    	lblRutaDelArchivo.setBounds(10, 11, 136, 14);
    	panelEntrada.add(lblRutaDelArchivo);
    	
    	btnExaminar = new JButton("...");
    	btnExaminar.addActionListener(this);
    	btnExaminar.setBounds(426, 36, 33, 23);
    	panelEntrada.add(btnExaminar);
    	
    	scrollPane = new JScrollPane();
    	scrollPane.setBounds(10, 97, 449, 413);
    	panelEntrada.add(scrollPane);
    	
    	txtAreaEntrada = new JTextArea();
    	txtAreaEntrada.setFont(new Font("Source Code Pro", Font.PLAIN, 13));
    	txtAreaEntrada.setWrapStyleWord(true);
    	scrollPane.setViewportView(txtAreaEntrada);
    	
    	lblEntrada = new JLabel("Entrada");
    	lblEntrada.setBounds(174, 70, 117, 23);
    	panelEntrada.add(lblEntrada);
    	lblEntrada.setFont(new Font("Source Code Pro", Font.PLAIN, 15));
    	lblEntrada.setHorizontalAlignment(SwingConstants.CENTER);
    	
    	panelSalida = new JPanel();
    	panelSalida.setBounds(474, 0, 470, 580);
    	getContentPane().add(panelSalida);
    	panelSalida.setLayout(null);
    	
    	lblSalida = new JLabel("Salida");
    	lblSalida.setFont(new Font("Source Code Pro", Font.PLAIN, 14));
    	lblSalida.setHorizontalAlignment(SwingConstants.CENTER);
    	lblSalida.setBounds(199, 60, 103, 27);
    	panelSalida.add(lblSalida);

    	
    	scrollPane_1 = new JScrollPane();
    	scrollPane_1.setBounds(10, 98, 449, 415);
    	panelSalida.add(scrollPane_1);
    	
    	txtAreaSalida = new JTextArea();
    	scrollPane_1.setViewportView(txtAreaSalida);
    	txtAreaSalida.setForeground(new Color(0, 255, 0));
    	txtAreaSalida.setFont(new Font("Source Code Pro", Font.PLAIN, 13));
    	txtAreaSalida.setBackground(Color.BLACK);
    	PrintStream stream = new PrintStream(new CustomOutputStream(txtAreaSalida));
    	
    	btnVisualizar = new JButton("Visualizar");
    	btnVisualizar.addActionListener(this);
    	btnVisualizar.setBounds(199, 524, 89, 23);
    	panelSalida.add(btnVisualizar);

		System.setOut(stream);
		System.setErr(stream);

		txtAreaSalida.setText("");

		paintComponents(getGraphics());
    }

    
	public void actionPerformed(ActionEvent arg0) {

		Object objeto = arg0.getSource();

		if (objeto == btnVisualizar) {
			btnVisualizarActionPerformed();
		}

		if (objeto == mntmGuardarEntrada) {
			mntmGuardarActionPerformed( 1 );
		}

		if(objeto == mntmGuardarSalida){
			mntmGuardarActionPerformed( 2);
		}

		if(objeto == mntmAbrir || objeto == btnExaminar) {
			mntmAbrirActionPerformed();
		}
		
		if (objeto == btnConvertir){
			mntmConvertirArchivoActionPerformed();
		}
		
		if( objeto == mntmSalir){
			mntmSalirActionPerformed();
		}
	}

	private void mntmSalirActionPerformed() {

		int respuesta = JOptionPane.showConfirmDialog(null, "¿Est\u00e1 seguro que desea salir?", "Salida", JOptionPane.OK_CANCEL_OPTION);

		if(respuesta == JOptionPane.OK_OPTION)
			System.exit(0);
	}

	protected void mntmConvertirArchivoActionPerformed(){

		//txtAreaJSON.setText("");

		if(!txtRuta.getText().isEmpty()) {
			if (!txtAreaEntrada.getText().isEmpty()) {
				try {
					String linea = txtAreaEntrada.getText();
					escribirTextArea(linea);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else if(!txtAreaEntrada.getText().isEmpty()){

			try{
				String linea = txtAreaEntrada.getText();
				escribirTextArea(linea);
			}catch (Exception e){
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "La ruta no debe estar vac\u00eda ni el cuadro de texto", "Error de entrada", JOptionPane.ERROR_MESSAGE);
		}

	}

	protected void escribirTextArea(String texto){

		limpiarConsola();

		ANTLRInputStream input = new ANTLRInputStream(texto);
		JSONLexer lexer = new JSONLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		JSONParser parser = new JSONParser(tokens);
		parser.setBuildParseTree(true);
		ParseTree tree = parser.json();
		ParseTreeWalker walker = new ParseTreeWalker();
		JSON2XML.XMLEmitter converter = new JSON2XML.XMLEmitter();
		walker.walk(converter, tree);

		System.out.println(converter.getXML(tree));

	}


	protected void mntmAbrirActionPerformed() {

		jfcExaminarEntrada = new JFileChooser();
		resultado = jfcExaminarEntrada.showOpenDialog(panelEntrada);

		if(resultado == JFileChooser.APPROVE_OPTION){
			File file = jfcExaminarEntrada.getSelectedFile();
			txtRuta.setText(file.getAbsolutePath());

			try (FileReader fr = new FileReader(file)){
				String cadena = "";
				int valor = fr.read();

				while(valor != -1){
					cadena = cadena+(char)valor;
					valor = fr.read();
				}
				txtAreaEntrada.setText(cadena);
			}catch (IOException ioe){
				ioe.printStackTrace();
			}
		}

	}


	protected void mntmGuardarActionPerformed(int opcion) {

		String extension = "";
		String texto = "";
		jfcGuardar = new JFileChooser();

		if(opcion == 1)
			jfcGuardar.setSelectedFile(new File("*.json"));
		else
			jfcGuardar.setSelectedFile(new File("*.xml"));

		jfcGuardar.showSaveDialog(this);
		File archivo = jfcGuardar.getSelectedFile();

		extension = (opcion == 1) ? ".json" : ".xml";
		texto = (opcion == 1) ? txtAreaEntrada.getText() : txtAreaSalida.getText();


		// System.out.println("Valor extension: "+extension);

		try{
			if (archivo != null){
				FileWriter guardar = new FileWriter(archivo+extension);
				guardar.write(texto);
				guardar.close();
				JOptionPane.showMessageDialog(null, "El archivo se ha guardado exitosamente", "Informaci\u00f3n", JOptionPane.INFORMATION_MESSAGE);
			}
		}catch(IOException e){
			JOptionPane.showMessageDialog(null,"Su archivo no se ha guardado", "Error al guardar", JOptionPane.ERROR_MESSAGE);
		}
	}

	protected void btnVisualizarActionPerformed() {

		String nombre = "web.xml"; //Archivo temporal para visualizar

		if(!txtAreaSalida.getText().isEmpty()){
			try {

				FileWriter guardar = new FileWriter(nombre);

				guardar.write("<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"no\"?>");
				guardar.write("\n");
				guardar.write(txtAreaSalida.getText());
				guardar.close();

				File file = new File(nombre);
				Desktop.getDesktop().open(file);

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "La salida no puede estar vac\u00eda", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}
	}


	private void limpiarConsola() {
		if(!txtAreaSalida.getText().isEmpty())
			txtAreaSalida.setText("");
	}

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(SyntheticaAluOxideLookAndFeel.class.getName());
			VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		}catch (final Exception e){
			e.printStackTrace();
			System.exit(0);
		}
	}
}
