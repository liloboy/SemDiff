package za.ac.sun.cs.semdiff.ast.statements;

import org.eclipse.jdt.core.dom.ReturnStatement;

import za.ac.sun.cs.semdiff.ast.expressions.DiffExpression;
import za.ac.sun.cs.semdiff.jdtvisitors.ExpressionVisitor;
import za.ac.sun.cs.semdiff.matcher.DiffASTMatcher;
import za.ac.sun.cs.semdiff.visitors.DiffVisitor;

// ReturnStatement:
//    return [ Expression ] ;
public class DiffReturnStatement extends DiffStatement {

	private DiffExpression expression = null;

	public DiffReturnStatement(ReturnStatement stmt) {
		super(stmt);

		if (stmt.getExpression() != null) {
			stmt.getExpression().accept(
					ExpressionVisitor.getExpressionVisitor());
			this.expression = ExpressionVisitor.getExpressionVisitor()
					.getExpression();
		}

	}

	public DiffExpression getExpression() {
		return this.expression;
	}

	@Override
	public boolean subtreeMatch0(DiffASTMatcher matcher, Object other) {
		return matcher.match(this, other);
	}

	@Override
	public void accept0(DiffVisitor visitor) {
		boolean visitChildren = visitor.visit(this);
		if (visitChildren) {
			acceptChild(visitor, getExpression());
		}
	}

	@Override
	public String toString() {
		if (expression != null) {
			return "return: " + expression.toString();
		}
		return "return";
	}

}
