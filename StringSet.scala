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
  def empty: StringSet = new StringSet()
  /** we need to implements those 4 methods */
  def +(t: String):StringSet = {set + t; this}
  def -(t: String):StringSet = {set - t; this}
  def +=(t: String):StringSet = {set += t; this}
  def -=(t: String):StringSet = {set -= t; this}
  def subsetOF(t:StringSet):Boolean = {set subsetOf t.set}
  def remove(s:String): StringSet = -=(s)
  def iterator() = set.iterator
  def contains(t: String) = set.exists(t.equals)
  def isEmpty() = set.size == 0
  def size		= set.size
  def &(ss:StringSet): StringSet = {
    var nss = new StringSet
    nss.set = set & ss.set 
    nss
  }
  def intersect(ss:StringSet) = &(ss)
  
  def |(ss:StringSet): StringSet = {
    var nss = new StringSet
    nss.set = set | ss.set
    nss
  }
  def union(ss: StringSet) = |(ss)
  def &~(ss:StringSet): StringSet = {
    var nss = new StringSet
    nss.set = set &~ ss.set
    nss
  }
  def diff(ss: StringSet) = &~(ss)
  def clear = new StringSet
  def enum  = set.toList
  
  def foreach[U](f: (String => U)):Unit = set.foreach(f)
}