
import java.util.LinkedList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

public class InfixToPostFix {
    
    private Stack<Character> pile = null;
    
    List Pfix = null;
    
    public  InfixToPostFix (){
	
	pile = new Stack<Character> ();
	Pfix = new LinkedList ();
    }
    
    public List ConvertireInfixEnPostfix (List Ifix ) {
	Pfix.add(3); Pfix.add(2); Pfix.add(5); Pfix.add('+'); Pfix.add('*');
	return Pfix;		    
    }   
    
    public boolean verifierProprite (char opr1, char opr2 ) {
	
	boolean propriete = false;
	
	if ((opr1 == '+' && opr2 == '*') || (opr1 == '-' && opr2 == '*') || (opr1 == '+' && opr2 == '/') || (opr1 == '-' && opr2 == '/') ){
	    
	    propriete = false; // + et - ne sont pas les plus proprietaire
	}else{
	    if ((opr1 == '*' && opr2 == '+') || (opr1 == '*' && opr2 == '-') || (opr1 == '/' && opr2 == '+') || (opr1 == '/' && opr2 == '-')){
		propriete = true;	 // * et / sont les plus proprietaire
	    }else{
		if ((opr1 == '*' && opr2 == '/') || (opr1 == '+' && opr2 == '-')){
		    propriete = true; // proprieté egale
		}
	    }
	}
	return propriete;
    }    
    
    public int calculePfix (List Pfix ){
	int resultatDePostfix = 3 * (2+5);
	return resultatDePostfix ;
	
    }
    
    
    public int réaliserOperation (int opr1, int opr2 ){
	
	char operation = '+';
	int result = 0;
	
	if (operation == '+'){
	    
	    result = opr1 + opr2;
	}
	
	return result;
    }
    
}
