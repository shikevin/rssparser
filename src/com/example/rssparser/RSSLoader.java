package com.example.rssparser;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import com.example.rssparser.RSSItem;

public class RSSLoader {
	private String rssUrl;
	public RSSLoader(String rssUrl) {
		this.rssUrl = rssUrl;
	}
	public List<RSSItem> getItems() throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();
		RSSHandler handler = new RSSHandler();
		saxParser.parse(rssUrl, handler);
		return handler.getItems();
	}
}