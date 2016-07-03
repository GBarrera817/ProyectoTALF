// Generated from D:/Workspace IntelliJ IDEA/ProyectoTALF2016/src\json.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link jsonParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface jsonVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link jsonParser#json}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJson(jsonParser.JsonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnObjecto}
	 * labeled alternative in {@link jsonParser#object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnObjecto(jsonParser.UnObjectoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectoVacio}
	 * labeled alternative in {@link jsonParser#object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectoVacio(jsonParser.ObjectoVacioContext ctx);
	/**
	 * Visit a parse tree produced by {@link jsonParser#pair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair(jsonParser.PairContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayDeValores}
	 * labeled alternative in {@link jsonParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDeValores(jsonParser.ArrayDeValoresContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayVacio}
	 * labeled alternative in {@link jsonParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayVacio(jsonParser.ArrayVacioContext ctx);
	/**
	 * Visit a parse tree produced by the {@code STRING}
	 * labeled alternative in {@link jsonParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSTRING(jsonParser.STRINGContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Atom}
	 * labeled alternative in {@link jsonParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(jsonParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValorObjeto}
	 * labeled alternative in {@link jsonParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValorObjeto(jsonParser.ValorObjetoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValorArray}
	 * labeled alternative in {@link jsonParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValorArray(jsonParser.ValorArrayContext ctx);
}