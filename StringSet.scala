/**
 * MethTest
 * mt.ss
 * StringSet.scala
 * (c)JC on 18 oct. 2013 11:54:45
 *
 */

/**
 * @author JC
 *
 */
package mt.ss
import scala.collection.mutable.Set

class StringSet(as: String*){
  var set:Set[String] = init_set
  def init_set = {
    var s = Set[String]()
    if(!as.isEmpty)
    as.foreach(e => s += e)
    s
  }
}