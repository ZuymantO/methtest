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
	var env:Map[String, String] = ev
}