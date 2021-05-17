package ru.ifmo.backend_2021.quill_examples

object Lifting extends App {
  val ctx = CreateCtx()

  import ctx._

  val stub = 1

  pprint.pprintln(ctx.translate(query[City].filter(_.id == lift(stub))))
  def find(cityId: Int): List[City] = {
    ctx.run(query[City].filter(_.id == lift(cityId)))
  }
  pprint.pprintln(find(3208))
  pprint.pprintln(find(3209))

  //ctx.run(query[City].filter(_.name.length == 1))
}
