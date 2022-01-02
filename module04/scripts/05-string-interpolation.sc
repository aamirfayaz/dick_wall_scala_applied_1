val x = 10

val y = 2.12

val name = "Fred"

s"$name $x $y"

s"$name is ${x * y}"

f"$name is ${x * y}%08.4f"
//8 means, string shall be 8 digit long including decimal,
// and 4 after decimal

//s"$names"
s"${name}s"

"\thi\nhe"
raw"\t\n"

"""hi\tho\n"""

"""fred took a "dive"
  | yo yo""".stripMargin

/**
 * f interpolation follows the printf notation
* raw does not escape literals in the string
 */