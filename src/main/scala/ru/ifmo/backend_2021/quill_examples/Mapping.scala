package ru.ifmo.backend_2021.quill_examples

object Mapping extends App {
  val ctx = CreateCtx()

  import ctx._


  pprint.pprintln(ctx.translate(query[Country].map(c => (c.name, c.continent))))
  pprint.pprintln(ctx.run(query[Country].map(c => (c.name, c.continent))))

  pprint.pprintln(ctx.translate(query[Country].map(c => (c.name, c.continent, c.population))))
  pprint.pprintln(ctx.run(query[Country].map(c => (c.name, c.continent, c.population))))

  def findName(cityId: Int): List[String] = {
    pprint.pprintln(ctx.translate(query[City].filter(_.id == lift(cityId)).map(_.name)))
    ctx.run(query[City].filter(_.id == lift(cityId)).map(_.name))
  }
  pprint.pprintln(findName(3208))
  pprint.pprintln(findName(3209))
}
