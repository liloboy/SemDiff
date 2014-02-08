package za.ac.sun.cs.semdiff.ast.expressions;

import org.eclipse.jdt.core.dom.NumberLiteral;

import za.ac.sun.cs.semdiff.matcher.DiffASTMatcher;
import za.ac.sun.cs.semdiff.visitors.DiffVisitor;

public class DiffNumberLiteral extends DiffExpression {

	private String literal = null;

	public DiffNumberLiteral(NumberLiteral exp) {
		super(exp);
		this.literal = exp.toString();
	}

	public String getLiteral() {
		return this.literal;
	}

	@Override
	public boolean subtreeMatch0(DiffASTMatcher matcher, Object other) {
		return matcher.match(this, other);
	}

	@Override
	public void accept0(DiffVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String toString() {
		return literal;
	}

}
