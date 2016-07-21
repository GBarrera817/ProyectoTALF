package modelo;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Creado por Gabriela Barrera el 03-07-2016.
 * Proyecto: ProyectoTALF2016
 */
public class JSONParserTest {

    public static void main(String[] args) throws IOException {

        String path = "D:\\Workspace IntelliJ IDEA\\ProyectoTALF2016\\src\\";

        String content = new Scanner(new File(path+"test.json")).useDelimiter("\\Z").next();
        System.out.println("Archivo JSON:\n " + content + "\n\n");

        ANTLRInputStream input = new ANTLRInputStream(content);

        JSONLexer lexer = new JSONLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        JSONParser parser = new JSONParser(tokens);

        ParseTree tree = parser.json();

        AST ast = new AST(tree);

        System.out.println("AST:\n"+ast.toString());
        System.out.println("ParseTree:\n"+tree.toStringTree(parser)+"\n\n");

    }
}
