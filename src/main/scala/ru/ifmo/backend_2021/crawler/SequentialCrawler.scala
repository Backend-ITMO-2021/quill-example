package ru.ifmo.backend_2021.crawler

import ru.ifmo.backend_2021.crawler.FetchLinks.fetchLinks

object SequentialCrawler extends App {
  def fetchAllLinks(startTitle: String, depth: Int): Set[String] = {
    var seen = Set(startTitle)
    var current = Set(startTitle)
    for (i <- Range(0, depth)) {
      val nextTitleLists = for (title <- current) yield fetchLinks(title)
      current = nextTitleLists.flatten.filter(!seen.contains(_))
      seen = seen ++ current
    }
    seen
  }
  TimeColored {
    pprint.pprintln(fetchAllLinks("Albert Einstein", 2))
  }
}
