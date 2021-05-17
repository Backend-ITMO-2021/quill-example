package ru.ifmo.backend_2021.quill_examples

import ru.ifmo.backend_2021.utils.FinallyClose

import scala.io.Source


object Setup extends App {
  val ctx = CreateCtx()

  FinallyClose(Source.fromFile("./world.sql"))(source =>
    ctx.executeAction(source.toList.mkString(""))
  )
}
