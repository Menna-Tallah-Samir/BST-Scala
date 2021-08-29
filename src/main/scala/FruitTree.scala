class FruitTree {
  var tree : BinarySearchTree = new BinarySearchTree

  def insertFruit(fruit : Fruit): Unit ={
    tree.insert(fruit)
  }

  def deleteFruit(fruit: Fruit): Unit={
    tree.delete(fruit)
  }

  def Iterate():Unit={
    tree.getElements.foreach(x => x.printFruit())
  }

  def filterByType[T](t : Class[T]):Unit={
    tree.getElements.filter(x => t.isAssignableFrom(x.getClass)).foreach(x => x.printFruit())
  }

  def filterByWeight(weight : Int):Unit={
    tree.getElements.filter(_.weight > weight).foreach(x => x.printFruit())
  }

  def magnifyByType[T](t:Class[T],weight:Int):Unit={
    val list = tree.getElements.collect{case x if t.isAssignableFrom(x.getClass) => x}

    list.foreach(x => this.tree.delete(x))
    list.foreach(x => x.weight = x.weight + weight)
    list.foreach(x => this.insertFruit(x))
  }

  def findHeaviest(): Fruit={
    tree.getLargestWeight
  }

  def findLightest(): Fruit={
    tree.getLeastWeight
  }

  def getNode(weight:Int): Fruit={
    tree.getElements.find(x=>x.weight==weight).get
  }
}
