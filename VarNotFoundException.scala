/**
 * MethTest
 * mt.te
 * VarNotFoundException.scala
 * (c)JC on 23 oct. 2013 15:04:02
 * 
 */
package mt.te

import scala.util.control.Exception

/**
 * @author JC
 *
 */
class VarNotFoundException(mss:String) extends Exception {
var msg = mss
}