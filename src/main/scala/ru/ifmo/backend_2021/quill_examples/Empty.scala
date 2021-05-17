package ru.ifmo.backend_2021.quill_examples

object Empty extends App {
  val ctx = CreateCtx()

  import ctx._

  pprint.pprintln(ctx.translate(query[City]))
  pprint.pprintln(ctx.run(query[City]))
}
