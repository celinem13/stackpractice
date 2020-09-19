public interface ExpressionConverterInterface {
    /** The convert method converts one type of expression format to another
     * @param expression The expression to be converted
     * @return The expression in the new format
     * @throws InvalidExpressionException If the expression to be converted has syntax errors
     */
    String convert(String expression) throws InvalidExpressionException;
}