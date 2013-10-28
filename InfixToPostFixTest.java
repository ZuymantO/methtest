import static org.junit.Assert.*;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.textui.*;
import junit.framework.TestCase;

public class InfixToPostFixTest extends TestCase {
	
	InfixToPostFix Exp;
	List infix = null;
	List postfix = null;

	@Before
	public void setUp() throws Exception {
		
		 Exp = new InfixToPostFix ();
		 infix = new LinkedList ();
		 postfix = new LinkedList ();
		 infix.add(3); infix.add('*'); infix.add('('); infix.add(2); infix.add('+'); infix.add(5); infix.add(')');
		 postfix.add(3); postfix.add(2); postfix.add(5); postfix.add('+'); postfix.add('*');
	}

	@After
	public void tearDown() throws Exception {
		
		Exp = null;
		infix = null;
		postfix=null;
	}

	@Test
	public final void testConvertireInfixEnPostfix() {
		
	   assertEquals("L’expression  infix devrait être transformé à postfix", postfix, Exp.ConvertireInfixEnPostfix(infix));
	}

	@Test
	public final void testVerifierProprite ( ){
		
		char op1 = '*'; char op2 = '+'; 
		boolean propriete = false;
		if ((op1 == '*' && op2 == '+') || (op1 == '*' && op2 == '-') || (op1 == '/' && op2 == '+') || (op1 == '/' && op1 == '-')){
		 propriete = true;
		}else{
			propriete = false;
		}
		assertTrue("vérifier la prioreté entre deux operateur", propriete == Exp.verifierProprite( op1, op2));
	}

	@Test
	public final void testCalculePfix() {
		int resultatPostfix = 21;
		
		assertEquals("evalué de l'éxpréssion postfix" , resultatPostfix , Exp.calculePfix(infix ));
	}
	
	@Test
	public final void testréaliserOperation() {
		
		int op1 = 2; int op2 = 8;
		
		int resultatDePlus = 10;
		
		assertEquals("l'opperation devrait etre returnné la somme des deux opperandes" , resultatDePlus , Exp.réaliserOperation(op1, op2));
	}

}
