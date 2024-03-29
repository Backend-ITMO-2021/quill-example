package ru.ifmo.backend_2021.crawler

object FetchLinks extends App {
  def fetchLinks(title: String): Seq[String] = {
    val resp = requests.get(
      "https://en.wikipedia.org/w/api.php",
      params = Seq(
        "action" -> "query",
        "titles" -> title,
        "prop" -> "links",
        "format" -> "json"
      )
    )
    for{
      page <- ujson.read(resp)("query")("pages").obj.values.toSeq
      links <- page.obj.get("links").toSeq
      link <- links.arr
    } yield link("title").str
  }

  pprint.pprintln(fetchLinks("Albert Einstein"))
}
