package modelo;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class JSON2XML {

    public static class XMLEmitter extends JSONBaseListener{

        ParseTreeProperty<String> xml = new ParseTreeProperty<>();

        String getXML(ParseTree ctx) {
            return xml.get(ctx);
        }

        void setXML(ParseTree ctx, String s) {
            xml.put(ctx, s);
        }


        /* ACCIONES PARA LOS NODOS QUE COMPONEN EL ARCHIVO JSON */

        public void exitJson(JSONParser.JsonContext ctx){
            setXML(ctx, getXML(ctx.getChild(0)));
        }

        public void exitAnObject(JSONParser.AnObjectContext ctx){

            StringBuilder builder = new StringBuilder();
            builder.append("\n");


            for (JSONParser.PairContext pctx : ctx.pair()) {

                builder.append(getXML(pctx));
            }

            setXML(ctx, builder.toString());
        }

        public void exitEmptyObject(JSONParser.EmptyObjectContext ctx){
            setXML(ctx, "");
        }

        public void exitArrayOfValues(JSONParser.ArrayOfValuesContext ctx) {
            StringBuilder buf = new StringBuilder();
            buf.append("\n");
            for (JSONParser.ValueContext vctx : ctx.value()) {
                buf.append("\t<element>"); // conjure up element for valid XML
                buf.append(getXML(vctx));
                buf.append("</element>");
                buf.append("\n");
            }
            setXML(ctx, buf.toString());
        }

        public void exitEmptyArray(JSONParser.EmptyArrayContext ctx){
            setXML(ctx, "");
        }

        public void exitPair(JSONParser.PairContext ctx){

            String tag = stripQuotes(ctx.STRING().getText());
            JSONParser.ValueContext vctx = ctx.value();
            String x = String.format("<%s>%s</%s>\n", tag, getXML(vctx), tag);

            setXML(ctx, x);
        }

        public void exitObjectValue(JSONParser.ObjectValueContext ctx){
            setXML(ctx, getXML(ctx.object()));
        }

        public void exitArrayValue(JSONParser.ArrayValueContext ctx){
            setXML(ctx, getXML(ctx.array()));
        }

        public void exitAtom(JSONParser.AtomContext ctx){
            setXML(ctx, ctx.getText());
        }

        public void exitString(JSONParser.StringContext ctx){
            setXML(ctx, stripQuotes(ctx.getText()));
        }

        public static String stripQuotes(String s){

            if( (s == null) || s.charAt(0) != '"') return s;

            return s.substring(1, s.length() -1 );
        }

    }

    public static void main(String[] args) throws Exception {

        //String inputFile = null;

        String path = "D:\\Workspace IntelliJ IDEA\\ProyectoTALF2016\\src\\";
        String content = new Scanner(new File(path+"test3.json")).useDelimiter("\\Z").next();

        //if ( args.length>0 ) inputFile = args[0];

        //InputStream is = System.in;

        /*if ( inputFile!=null ) {
            is = new FileInputStream(inputFile);
        }
*/
        ANTLRInputStream input = new ANTLRInputStream(content);
        JSONLexer lexer = new JSONLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JSONParser parser = new JSONParser(tokens);
        parser.setBuildParseTree(true);
        ParseTree tree = parser.json();

        // show tree in text form
//        System.out.println(tree.toStringTree(parser));

        ParseTreeWalker walker = new ParseTreeWalker();
        XMLEmitter converter = new XMLEmitter();
        walker.walk(converter, tree);
        System.out.println(converter.getXML(tree));
    }

}