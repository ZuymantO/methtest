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

   	assert(false)   
  }

  it should " have size = size + 1 after a new string insertion" in {

   	assert(false)   
  }

  it should " have same size after a duplicate string insertion" in {

   	assert(false)   
  }

  it should " contains a added value" in {

   	assert(false)   
  }
  
  it should " not containts a deleted value" in {

   	assert(false)   
  }
  
  it should " have size decrease by one after a delete string action" in {

   	assert(false)   
  }
  
  it should " have same size after a delete action on inexisting item" in {

   	assert(false)   
  }

  it should " have null intersection with a strickly distinct String Set " in {

   	assert(false)   
  }
  
  it should " have size equals to zero after an intersect operation with a strickly distinct String Set " in {

   	assert(false)   
  }

  it should " have intersection with a String Set which contains common strings" in {

   	assert(false)   
  }
  
  it should " be the inner sub String Set when apply intersection with an inner sub String Set " in {

   	assert(false)   

  } 

  it should " have size different to zero after a intersection with an other String Set witch contains common element " in {

   	assert(false)   
  }
  
  it should " be the same when apply union with an inner sub String Set " in {

   	assert(false)   
  }
  
  it should " have same size after apply union with an inner sub String Set " in {

   	assert(false)   
  }
      
  it should " contains both String Set A and String Set B after a A Union B" in {

   	assert(false)   
  } 
  
  it should " have strickly A size + B size after a A Union B distinct String Set" in {

   	assert(false)   
  } 
  
  it should " be fully enumerable " in {

   	assert(false)   
  }
  
  it should " have enumaration lenth equals to the size set " in {

   	assert(false)   
  }
   
}
