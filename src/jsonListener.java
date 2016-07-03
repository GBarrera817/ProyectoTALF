// Generated from D:/Workspace IntelliJ IDEA/ProyectoTALF2016/src\json.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link jsonParser}.
 */
public interface jsonListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link jsonParser#json}.
	 * @param ctx the parse tree
	 */
	void enterJson(jsonParser.JsonContext ctx);
	/**
	 * Exit a parse tree produced by {@link jsonParser#json}.
	 * @param ctx the parse tree
	 */
	void exitJson(jsonParser.JsonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnObjecto}
	 * labeled alternative in {@link jsonParser#object}.
	 * @param ctx the parse tree
	 */
	void enterUnObjecto(jsonParser.UnObjectoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnObjecto}
	 * labeled alternative in {@link jsonParser#object}.
	 * @param ctx the parse tree
	 */
	void exitUnObjecto(jsonParser.UnObjectoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ObjectoVacio}
	 * labeled alternative in {@link jsonParser#object}.
	 * @param ctx the parse tree
	 */
	void enterObjectoVacio(jsonParser.ObjectoVacioContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ObjectoVacio}
	 * labeled alternative in {@link jsonParser#object}.
	 * @param ctx the parse tree
	 */
	void exitObjectoVacio(jsonParser.ObjectoVacioContext ctx);
	/**
	 * Enter a parse tree produced by {@link jsonParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterPair(jsonParser.PairContext ctx);
	/**
	 * Exit a parse tree produced by {@link jsonParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitPair(jsonParser.PairContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayDeValores}
	 * labeled alternative in {@link jsonParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArrayDeValores(jsonParser.ArrayDeValoresContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayDeValores}
	 * labeled alternative in {@link jsonParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArrayDeValores(jsonParser.ArrayDeValoresContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayVacio}
	 * labeled alternative in {@link jsonParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArrayVacio(jsonParser.ArrayVacioContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayVacio}
	 * labeled alternative in {@link jsonParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArrayVacio(jsonParser.ArrayVacioContext ctx);
	/**
	 * Enter a parse tree produced by the {@code STRING}
	 * labeled alternative in {@link jsonParser#value}.
	 * @param ctx the parse tree
	 */
	void enterSTRING(jsonParser.STRINGContext ctx);
	/**
	 * Exit a parse tree produced by the {@code STRING}
	 * labeled alternative in {@link jsonParser#value}.
	 * @param ctx the parse tree
	 */
	void exitSTRING(jsonParser.STRINGContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Atom}
	 * labeled alternative in {@link jsonParser#value}.
	 * @param ctx the parse tree
	 */
	void enterAtom(jsonParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Atom}
	 * labeled alternative in {@link jsonParser#value}.
	 * @param ctx the parse tree
	 */
	void exitAtom(jsonParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValorObjeto}
	 * labeled alternative in {@link jsonParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValorObjeto(jsonParser.ValorObjetoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValorObjeto}
	 * labeled alternative in {@link jsonParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValorObjeto(jsonParser.ValorObjetoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValorArray}
	 * labeled alternative in {@link jsonParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValorArray(jsonParser.ValorArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValorArray}
	 * labeled alternative in {@link jsonParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValorArray(jsonParser.ValorArrayContext ctx);
}