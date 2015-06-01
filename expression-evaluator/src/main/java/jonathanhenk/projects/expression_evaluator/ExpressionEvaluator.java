package jonathanhenk.projects.expression_evaluator;

import jonathanhenk.sedgewick.algs.ResizingArrayStack;

public class ExpressionEvaluator
{
	public ExpressionEvaluator()
	{

	}
	public static Double eval_exp(String exp) throws Exception
	{
		if (exp.length() == 0)
			throw new Exception("Cannot evaluate empty string.");

		ResizingArrayStack<String> op_stack = new ResizingArrayStack<String>();
		ResizingArrayStack<Double> opands_stack = new ResizingArrayStack<Double>();

		String current_char;
		for (int j=0; j<exp.length(); j++)
		{
			// Read next character in expression
			current_char = String.valueOf(exp.charAt(j));

			// Check for (,),operation, number, or whitespace
			if (current_char.equals(")"))
			{
				String op;
				try { op = op_stack.pop(); } 
				catch (Exception e) { throw new Exception("Invalid expression."); }

				if (op.equals("sqrt")) // sqrt
				{
					try { opands_stack.push(eval_op(op, opands_stack.pop())); }
					catch (Exception e) { throw new Exception("Invalid expression."); }
					
				}
				else { // everything else: */+-^
					double arg1, arg2;
					try
					{
						arg2 = opands_stack.pop();
						arg1 = opands_stack.pop();
						opands_stack.push(eval_op(op, arg1, arg2));
					} catch (Exception e) { throw new Exception("Invalid expression.");}
				}
			}
			else if (current_char.equals(" ") || current_char.equals("("))
			{
				// ignore whitespace and left paren's
				continue;
			}
			else if (current_char.equals("+") ||
					 current_char.equals("-") ||
					 current_char.equals("/") ||
					 current_char.equals("*") ||
					 current_char.equals("^"))
			{
				op_stack.push(current_char);
			}
			else if (current_char.equals("s") && (j+4)<exp.length())
			{
				String sqrt_str = exp.substring(j,j+5);
				if (sqrt_str.equals("sqrt(")) {
					op_stack.push("sqrt");
					j+=4;
				}
				else
					throw new Exception("Invalid sqrt expression.");
			}
			else if (Character.isDigit(exp.charAt(j)) || exp.charAt(j) == '.')
			{
				try {
					opands_stack.push(parse_operand(exp, j));
				} catch (NumberFormatException e)
				{
					throw new Exception("Invalid expression.");
				}
			}
			else
			{
				throw new Exception("Invalid expression.");
			}


				
		}

		if (opands_stack.size() == 1)
			return opands_stack.pop();
		else
			throw new Exception("Invalid Expression. More than 1 operand left on stack.");


	}

	private static Double parse_operand(String exp, int start_index) throws NumberFormatException
	{
		int j = start_index;
		while (Character.isDigit(exp.charAt(j)) || exp.charAt(j) == '.' && j<exp.length())
		{
			j++;
		}

		String operand = exp.substring(start_index, j);
		try
		{
			return new Double(Double.parseDouble(operand));
		}
		catch (NumberFormatException e)
		{
			throw e;
		}
		catch (NullPointerException e)
		{
			throw e;
		}

	}

	private static Double eval_op(String op, Double arg1, Double arg2)
	{
		if (op.equals("^"))
		{
			return new Double(0.0);
		}
		else if (op.equals("+"))
		{
			return new Double(arg1 + arg2);
		}
		else if (op.equals("-"))
			return new Double(arg1 - arg2);
		else if (op.equals("*"))
			return new Double(arg1 * arg2);
		else if (op.equals("/"))
			return new Double(arg1 / arg2);
		else
		{
			return 0.0;
		}

	}

	private static Double eval_op(String op, Double arg)
	{
		if (op.equals("sqrt"))
			return new Double(Math.sqrt(arg));
		else
			return 0.0;
	}



}