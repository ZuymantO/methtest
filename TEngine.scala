/**
 * MethTest
 * mt.te
 * TEngine.scala
 * (c)JC on 21 oct. 2013 00:32:16
 *
 */
package mt.te

/**
 * @author JC
 *
 */
class TEngine(tpl:String = null, ev: Map[String, String] = null){
	var template = tpl
	var env  = ev
	var hasVar = false

	def lookUpVar(name: String) = {
	  var v = template.replace("$"+name, env(name))
	  if (v == template) {
	    v = template.replace("${" + name + "}", env(name))
	    if (v == template)
	      v
	      //throw new Exception("Erreur: " + name + " n'est pas une variable valide")
	  }
	  env = env - name
	  v
	}
	
	def checkSyntax = {
	  var ct = ' '
	  var i  = 0
	  hasVar = false
	  for(c <- template) {
	    if (c == '{' && ct == '$') {
	      i += 1
	      hasVar = true
	    }
	    if (c == '}' && ct != ' ')
	      i -= 1
	    ct = c
	  }
	  i == 0
	}
	
	def perform() = {
	  if (!checkSyntax)
	    throw new Exception("Le template est mal formé")
	  var envc = env.toMap
	  do {
	   env.foreach(e => template = lookUpVar(e._1))
	   if (!checkSyntax)
	    throw new Exception("Le template est mal formé")
	  }while(!envc.isEmpty && hasVar)
	true;
	}
}