/**
 * MethTest
 * mt.te
 * TEngine.scala
 * (c)JC on 21 oct. 2013 00:32:16
 *
 */
package mt.te

import scala.util.matching.Regex
/**
 * @author JC
 *
 */
class TEngine(tpl:String = null, ev: Map[String, String] = null){
	var template = tpl
	var env  = ev
	var hasVar = false

	def lookUpVar(name: String) = {
	  var v = template.replace("{${" + name + "}}", env(name))
	  if (v equals template) {
	    v = template.replace("{$" + name + "}", env(name))
	    if (v equals template) {
     	  v = template.replace("$"+name, env(name))
 	      if (v.equals(template)) v else env = env - name
 	    } else env = env - name
	  }else
	    env = env - name
	  v
	}
	

	def checkVarDecl = {
	  var reg = new Regex("([{]{0,1}\\$([a-zA-Z0-9_]+)[}]{0,1})")
	  (reg findAllIn template).toList
	}
	
	def checkSyntax = {
	  var ct = ' '
	  var i  = 0
	  hasVar = false
	  for(c <- template) {
	    if(c == '$')
	      hasVar = true
	    if(ct == '$' && c.isSpaceChar) {
	      i += 5
	    }
	    if (c == '{' && ct == '$') {
	      i += 1
	      hasVar = true
	    }
	    if (c == '}' && ct != ' ' && i > 0)
	      i -= 1
	    ct = c
	  }
	  i == 0
	}
	
	def perform() = {
	  if (!checkSyntax)
	    throw new Exception("Le template est mal formé")
	  var ndvar = checkVarDecl
	  do {
	   if (!( env.find(p => (ndvar.find(s => s.contains(p._1))) match {case Some(_) => true  case _ => false}) match{
	     case Some(_) => true
	     case _ => false
	   }) ) throw new VarNotFoundException("Il existe encore des variables non définis")
	   env.foreach(e => template = lookUpVar(e._1))
	   if (!checkSyntax)
	    throw new Exception("Le template est mal formé")
	   ndvar = checkVarDecl
	  }while(!env.isEmpty && hasVar && !(ndvar.isEmpty))

	  if (hasVar) {
	    throw new VarNotFoundException("Il existe encore des variables non définis")
	  }
	true;
	}
}