package vista;

import de.javasoft.plaf.synthetica.*;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Creado por Gabriela Barrera el 20-07-2016.
 * Proyecto: ProyectoTALF2016
 */

public class VentanaPrincipal extends JFrame implements ActionListener {
	private JMenuBar menuBar;
	private JMenuItem mntmArchivo;
	private JMenu mnNewMenu;
	private JMenuItem mntmAbrir;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmGuardar;
	private JSeparator separator;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblEntrada;
	private JLabel lblSalida;
	private JTextArea textArea_1;
	private JButton btnConvertir;

	public JFileChooser jfcExaminarEntrada, jfcGuardar;
	private JTextField txtRuta;
	private JLabel lblRutaDelArchivo;
	private JButton btnExaminar;
	private JTextArea textArea;
	private JScrollPane scrollPane;

	private int resultado;

    public VentanaPrincipal(){

    	initComponents();
    }
    
    private void initComponents() {

        setVisible(true);
        setSize(800, 565);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	setTitle("Proyecto TALF 2016");
    	
    	menuBar = new JMenuBar();
    	setJMenuBar(menuBar);
    	
    	mnNewMenu = new JMenu("Archivo");
    	menuBar.add(mnNewMenu);
    	
    	mntmNewMenuItem = new JMenuItem("Nuevo archivo");
    	mntmNewMenuItem.setIcon(new ImageIcon("D:\\Workspace IntelliJ IDEA\\ProyectoTALF2016\\img\\icons\\tango-icon-theme-0.8.90\\16x16\\actions\\document-new.png"));
    	mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
    	mnNewMenu.add(mntmNewMenuItem);
    	
    	mntmAbrir = new JMenuItem("Abrir");
    	mntmAbrir.addActionListener(this);
    	mntmAbrir.setIcon(new ImageIcon("D:\\Workspace IntelliJ IDEA\\ProyectoTALF2016\\img\\icons\\tango-icon-theme-0.8.90\\16x16\\actions\\document-open.png"));
    	mntmAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
    	mnNewMenu.add(mntmAbrir);
    	
    	mntmGuardar = new JMenuItem("Guardar");
    	mntmGuardar.addActionListener(this);
    	mntmGuardar.setIcon(new ImageIcon("D:\\Workspace IntelliJ IDEA\\ProyectoTALF2016\\img\\icons\\tango-icon-theme-0.8.90\\16x16\\actions\\document-save.png"));
    	mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
    	mnNewMenu.add(mntmGuardar);
    	
    	separator = new JSeparator();
    	mnNewMenu.add(separator);
    	
    	mntmArchivo = new JMenuItem("Salir");
    	mntmArchivo.setIcon(new ImageIcon("D:\\Workspace IntelliJ IDEA\\ProyectoTALF2016\\img\\icons\\tango-icon-theme-0.8.90\\16x16\\emblems\\emblem-unreadable.png"));
    	mntmArchivo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
    	mnNewMenu.add(mntmArchivo);
    	getContentPane().setLayout(null);
    	
    	panel = new JPanel();
    	panel.setBounds(0, 0, 392, 505);
    	getContentPane().add(panel);
    	panel.setLayout(null);
    	
    	lblEntrada = new JLabel("Entrada");
    	lblEntrada.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
    	lblEntrada.setHorizontalAlignment(SwingConstants.CENTER);
    	lblEntrada.setBounds(104, 11, 168, 14);
    	panel.add(lblEntrada);

    	btnConvertir = new JButton("Convertir");
    	btnConvertir.setBounds(142, 454, 89, 23);
    	panel.add(btnConvertir);
    	
    	txtRuta = new JTextField();
    	txtRuta.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
    	txtRuta.setBounds(10, 63, 336, 23);
    	panel.add(txtRuta);
    	txtRuta.setColumns(10);
    	
    	lblRutaDelArchivo = new JLabel("Ruta del archivo");
    	lblRutaDelArchivo.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
    	lblRutaDelArchivo.setBounds(23, 38, 136, 14);
    	panel.add(lblRutaDelArchivo);
    	
    	btnExaminar = new JButton("...");
    	btnExaminar.addActionListener(this);
    	btnExaminar.setBounds(349, 63, 33, 23);
    	panel.add(btnExaminar);
    	
    	scrollPane = new JScrollPane();
    	scrollPane.setBounds(10, 97, 372, 331);
    	panel.add(scrollPane);
    	
    	textArea = new JTextArea();
    	textArea.setFont(new Font("Source Code Pro", Font.PLAIN, 15));
    	textArea.setWrapStyleWord(true);
    	scrollPane.setViewportView(textArea);
    	
    	panel_1 = new JPanel();
    	panel_1.setBounds(392, 0, 392, 505);
    	getContentPane().add(panel_1);
    	panel_1.setLayout(null);
    	
    	lblSalida = new JLabel("Salida");
    	lblSalida.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
    	lblSalida.setHorizontalAlignment(SwingConstants.CENTER);
    	lblSalida.setBounds(141, 11, 141, 14);
    	panel_1.add(lblSalida);
    	
    	textArea_1 = new JTextArea();
    	textArea_1.setForeground(new Color(0, 255, 0));
    	textArea_1.setFont(new Font("Source Code Pro", Font.PLAIN, 13));
    	textArea_1.setBackground(Color.BLACK);
    	textArea_1.setBounds(10, 98, 372, 329);
    	panel_1.add(textArea_1);

		paintComponents(getGraphics());
    }

    
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmGuardar) {
			mntmGuardarActionPerformed(arg0);
		}
		
		if (arg0.getSource() == mntmAbrir || arg0.getSource() == btnExaminar) {
			mntmAbrirActionPerformed(arg0);
		}
		
		if (arg0.getSource() == btnConvertir){
			mntmConvertirArchivoActionPerformed(arg0);
		}
	}
	
	protected void mntmConvertirArchivoActionPerformed(ActionEvent arg0){
		
	}
	
	
	protected void mntmAbrirActionPerformed(ActionEvent arg0) {

		jfcExaminarEntrada = new JFileChooser();
		resultado = jfcExaminarEntrada.showOpenDialog(panel);

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
				textArea.setText(cadena);
			}catch (IOException ioe){
				ioe.printStackTrace();
			}
		}

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
	protected void mntmGuardarActionPerformed(ActionEvent arg0) {
		
		jfcGuardar = new JFileChooser();
		resultado = jfcGuardar.showSaveDialog(panel_1);

		if(resultado == JFileChooser.APPROVE_OPTION){
			File file = jfcGuardar.getSelectedFile();

			try (FileWriter writer = new FileWriter(file)){
				 writer.write(textArea_1.getText());
			}catch (IOException ioe){
				ioe.printStackTrace();
			}
		}

	}
}
