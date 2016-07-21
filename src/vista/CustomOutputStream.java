package vista;

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Creado por Gabriela Barrera el 20-07-2016.
 * Proyecto: ProyectoTALF2016
 */
public class CustomOutputStream extends OutputStream{

    private JTextArea textArea = null;

    public CustomOutputStream(JTextArea textArea){
        this.textArea = textArea;
    }


    @Override
    public void write(int b) throws IOException {
        //redirecciona los datos al textArea

        textArea.append(String.valueOf((char)b));

        //scroll el text area al final de los datos

        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}
