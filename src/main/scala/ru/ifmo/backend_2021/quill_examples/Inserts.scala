package ru.ifmo.backend_2021.quill_examples

object Inserts extends App {
  val ctx = CreateCtx()

  import ctx._

  pprint.pprintln(ctx.translate(query[City].insert(City(10000, "test", "TST", "Test County", 0))))
  pprint.pprintln(ctx.run(query[City].insert(City(10000, "test", "TST", "Test County", 0))))

  pprint.pprintln(ctx.translate(query[City].filter(_.population == 0)))
  pprint.pprintln(ctx.run(query[City].filter(_.population == 0)))

  val cities = List(
    City(10001, "testville", "TSV", "Test County", 0),
    City(10002, "testopolis", "TSO", "Test County", 0),
    City(10003, "testberg", "TSB", "Test County", 0)
  )

  pprint.pprintln(ctx.translate(liftQuery(cities).foreach(e => query[City].insert(e))))
  pprint.pprintln(ctx.run(liftQuery(cities).foreach(e => query[City].insert(e))))
  pprint.pprintln(ctx.run(query[City].filter(_.population == 0)))
}
