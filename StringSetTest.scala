/**
 * MethTest
 *
 * StringSetTest.scala
 * (c)JC on 18 oct. 2013 14:23:34
 *
 */
/**
 * @author JC
 *
 */
package mt.ss

import org.scalatest._
import scala.collection.mutable.Stack

class StringSetTest extends FlatSpec with BeforeAndAfterEach {

  private var gss:StringSet = _
  private var inner:StringSet = _
  private var outer:StringSet = _
  private var inter:StringSet = _
     // Set up the temp file needed by the test
   override def beforeEach() {
    gss   = new StringSet("Element", "String", "Other", "", "Soon")
    inner = new StringSet("", "String", "Soon")
    outer = new StringSet("Oof", "Rab", "Zab")
    inter = new StringSet("Foo", "Bar", "Other", "Baz")
   }

   // Close and delete the temp file
   override def afterEach() {
    gss   = null
    inner = null
    outer = null
    inter = null
   }

   
   "A Set of String" should " have length equal to zero if its empty" in {
    val ss = new StringSet()
    assert(ss.size == 0)
  }

  it should " have size = size + 1 after a new string insertion" in {
    val i = gss.size
    gss += "New Element"
    val j = gss.size
    assert((i + 1) == j)
  }

  it should " have same size after a duplicate string insertion" in {
    val i 	= gss.size
    gss		+= "Soon"
    val j 	= gss.size
    assert(j == i)
  }

  it should " contains a added value" in {
    val str	= "My String"
    assert(!(gss.contains(str)))
    gss		+= str
    assert(gss contains str)
  }
  
  it should " not containts a deleted value" in {
    val str = "Other"
    assert(gss contains str)
    gss -= str
    assert(!(gss contains str))
  }
  
  it should " have size decrease by one after a delete action" in {
    val str = "Other"
    assert(gss contains str)
    val s = gss.size
    gss -= str
    assert(s == gss.size + 1)
  }
  
  it should " have same size after a delete action on inexisting item" in {
    val str = "_Other_"
    assert(!(gss contains str))
    val s = gss.size
    gss -= str
    assert(s == gss.size)
  }

  it should " have null intersection with a strickly distinct String Set " in {
    val m_null 	= gss & outer
    val i		= m_null.size
    for(e <- m_null)
      assert(!(gss contains e))
  }
  
  it should " have size equals to zero after an intersect operation with a strickly distinct String Set " in {
    val m_null 	= gss & outer
    val i		= m_null.size
    assert(i == 0)
  }

  it should " have intersection with a String Set which contains common strings" in {
    val m_nnull = gss & inter
    val str		= "Other"
    assert(m_nnull contains str)
  }
  
  it should " be the inner sub String Set when apply intersection with an inner sub String Set " in {
    val m_inner 	= gss & inner
    assert(m_inner.size == inner.size)
    assert(List.forall2(m_inner.enum, inner.enum)((a,b) => a == b))
    
  } 

  it should " have size different to zero after a intersection with an other String Set witch contains common element " in {
    val m_nnull 	= gss & inter
    val i		= m_nnull.size
    assert(i > 0)
  }
  
  it should " be the same when apply union with an inner sub String Set " in {
    val m_null 	= gss | inner
    assert(List.forall2(m_null.enum, gss.enum)((a,b) => a == b))
  }
  
  it should " have same size after apply union with an inner sub String Set " in {
    val m_null 	= gss | inner
    assert(m_null.size == gss.size)
  }
      
  it should " contains both String Set A and String Set B after a A Union B" in {
    val m_union 	= gss | outer
    m_union.enum.foreach(e => assert((gss contains e) || (outer contains e)))
  } 
  
  it should " have strickly A size + B size after a A Union B distinct String Set" in {
    val m_union 	= gss | outer
    assert(m_union.size == outer.size + gss.size)
  } 
  
  it should " be fully enumerable " in {
    val ar	= gss.enum
    ar.foreach(e => assert(gss contains e) )
  }
  
  it should " have enumaration lenth equals to the size set " in {
    val s 	= gss.size
    val ar	= gss.enum
    val sar = ar.length
    assert(sar == s)
  }

}
