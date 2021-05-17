package ru.ifmo.backend_2021.quill_examples

object Querying extends App {
  val ctx = CreateCtx()

  import ctx._

  pprint.pprintln(ctx.translate(query[City].filter(_.name == "Singapore")))
  pprint.pprintln(ctx.run(query[City].filter(_.name == "Singapore")))

  pprint.pprintln(ctx.translate(query[City].filter(_.id == 3208)))
  pprint.pprintln(ctx.run(query[City].filter(_.id == 3208)))

  pprint.pprintln(ctx.translate(query[City].filter(_.population > 9000000)))
  pprint.pprintln(ctx.run(query[City].filter(_.population > 9000000)))

  pprint.pprintln(ctx.translate(query[City].filter(c => c.population > 9000000 && c.countryCode == "CHN")))
  pprint.pprintln(ctx.run(query[City].filter(c => c.population > 9000000 && c.countryCode == "CHN")))
}
