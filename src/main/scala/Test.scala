object Test {
  def main(args: Array[String]): Unit = {
    var tree = new FruitTree

    println("----------------------------------------------------------------------test insert")
    tree.insertFruit(new Apples(10));
    tree.insertFruit(new Grapes(20))
    tree.insertFruit(new BlackBerries(5))
    tree.insertFruit(new BlackBerries(3))
    tree.insertFruit(new BlackBerries(2))
    tree.insertFruit(new BlackBerries(30))
    tree.insertFruit(new Apples(80))
    tree.insertFruit(new BlackBerries(15))
    tree.insertFruit(new Avocado(18))
    tree.insertFruit(new BerryFruit(13))
    tree.insertFruit(new Grapes(14))
    tree.Iterate

    println("----------------------------------------------------------------------test lightest")
    tree.findLightest().printFruit()

    println("----------------------------------------------------------------------test heaviest")
    tree.findHeaviest().printFruit()

    println("----------------------------------------------------------------------test filter by type")
    tree.filterByType(classOf[Grapes])

    println("----------------------------------------------------------------------test filter by weight")
    tree.filterByWeight(10)

    println("----------------------------------------------------------------------test delete")
    tree.deleteFruit(tree.getNode(20))
    tree.deleteFruit(tree.getNode(10))
    tree.Iterate

    println("----------------------------------------------------------------------test magnify")
    tree.magnifyByType(classOf[BlackBerries], 5)
    tree.Iterate

    println("----------------------------------------------------------------------")
  }
}
