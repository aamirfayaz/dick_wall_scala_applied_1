import java.io.File
import scala.io.Source
//loan pattern
//we are processing file as resource and loaning it to fn for usage
def withFileContents[A](file: File, default: A)(fn: String => A): A = {
  val source = Source.fromFile(file)

  try {
    source.getLines().toSeq.headOption.map { line =>
      fn(line)
    }.getOrElse(default)
  } finally source.close()
}

// change this to the location of your project files
val projectDir = "/home/dwall/dev/Scala/Training/scala-advanced-training/exercises-applied"

val fileLoc = new File(projectDir)
val hamlet = new File(fileLoc, "hamlet.shkspr")

withFileContents(hamlet, false)(_.trim.endsWith("?"))

withFileContents(hamlet, "")(_.trim.toUpperCase)

// find most common letter
//this syntax with currying is better than previous on,
//its more readible, like here is file and default, now if it
//has a line, do this with the line
withFileContents(file = hamlet, default = 'e') { line =>
  val letters = line.toLowerCase.filterNot(_ == ' ').toSeq
  val grouped = letters.groupBy(identity)
  grouped.maxBy { case (char, seq) => seq.length }._1
}


//It works, but that syntax is awkward to both write and read, use currying