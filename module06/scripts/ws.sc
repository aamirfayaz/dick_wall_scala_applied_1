val line = "hi how are hee h you"
val letters: Seq[Char] = line.toLowerCase.filterNot(_ == ' ')
val grouped: Map[Char, Seq[Char]] = letters.groupBy(identity)
val y = grouped.reduce { (x, y) =>
  if(x._2.length > y._2.length) x else y
}._1



val result = grouped.maxBy { case (char, seq) => seq.length }._1