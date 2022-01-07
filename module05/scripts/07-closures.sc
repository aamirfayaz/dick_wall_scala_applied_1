val incBy1 = (x: Int) => x + 1

var more = 10
val incByMore = (x: Int) => x + more

incBy1(10)

incByMore(12)

more = 14

incByMore(12)

val incByMoreM = (x: Int) => {
  more += 1
  x + more
}
incByMoreM(2)
incByMoreM(2)
incByMoreM(2)

//different result on each call, not functional