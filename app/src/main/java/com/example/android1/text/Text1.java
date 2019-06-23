package com.example.android1.text;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 张亚丹 on 2019/6/19.
 */

public class Text1 {

    public static void main(String[] args) {

        try {
            final Document document = Jsoup.connect("https://www.v2ex.com/").get();

            final ArrayList<Bean> list = new ArrayList<>();
/*
            final Element tabs = document.getElementById("Tabs");

            final Elements allElements = tabs.getAllElements();

            for (Element element:allElements){
                final String text = element.text();
                final String href = element.attr("href");
                System.out.println(text+":"+href);
                list.add(new Bean(text,href));
            }*/

            //2>

            final Elements select = document.select("div#Tabs > a");

            for (Element element:select) {
                final String text = element.text();
                final String href = element.attr("href");
                System.out.println(text + ":" + href);
                list.add(new Bean(text, href));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static class Bean {
        private String text;
        private String href;

        public Bean(String text, String href) {
            this.text = text;
            this.href = href;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        @Override
        public String toString() {
            return "Bean{" +
                    "text='" + text + '\'' +
                    ", href='" + href + '\'' +
                    '}';
        }
    }
}
