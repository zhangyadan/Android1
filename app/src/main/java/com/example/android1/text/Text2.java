package com.example.android1.text;

import android.os.Build;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 张亚丹 on 2019/6/19.
 */

public class Text2 {
    public static void main(String[] args) {

        try {
            final Document document = Jsoup.connect("https://www.v2ex.com/?tab=tech").get();

            ArrayList<Bean> list = new ArrayList<>();
            final Elements select = document.select("div.cell.item");

            for (Element element:select) {

                Bean bean = new Bean();
                //取头像
                final Elements img = element.select("table tr td a img.avatar");
                if (img.size() > 0){
                    final String src = img.attr("src");
                  //  System.out.println(src);
                    bean.setImg(src);
                }
                //获取标题
                final Elements titles = element.select("table tr td span.item_titles a");
                if (titles.size() > 0){
                    final String title = titles.get(0).text();
                  //  System.out.println(title);
                    bean.setTitle(title);
                }
                //评价
                final Elements count_livid = element.select("table tr td a.count_livid");
                if (count_livid.size() > 0){
                    final String ping = count_livid.get(0).text();
                    System.out.println(ping);
                    bean.setCount(Integer.valueOf(ping));
                }
                list.add(bean);
                final Elements select1 = element.select("table tr td span.topic_info strong a");
                if (select1.size() > 0){
                    final String text = select1.get(0).text();
                    //System.out.println(text);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ABC();
    }

    private static void ABC() {
        try {
            final Document document = Jsoup.connect("https://www.v2ex.com/?tab=tech").get();

            final Elements cell_item = document.getElementsByClass("cell item");

            for (Element element:cell_item){
                //取头像
                final Elements avatar = element.getElementsByClass("avatar");
                if (avatar.size() > 0){
                    final String src = avatar.get(0).attr("src");
                    System.out.println(src);
                }
                //取标题
                final Elements item_title = element.getElementsByClass("item_title");
                if (item_title.size() > 0){
                    final Elements a = item_title.get(0).getElementsByTag("a");
                    if (a.size() > 0){
                        final String text = a.get(0).text();
                        System.out.println(text);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static class Bean{
        private String title;
        private String img;
        private int count;
        private String avator;

        public Bean() {
        }

        public Bean(String title, String img, int count, String avator) {
            this.title = title;
            this.img = img;
            this.count = count;
            this.avator = avator;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getAvator() {
            return avator;
        }

        public void setAvator(String avator) {
            this.avator = avator;
        }

        @Override
        public String toString() {
            return "Bean{" +
                    "title='" + title + '\'' +
                    ", img='" + img + '\'' +
                    ", count=" + count +
                    ", avator='" + avator + '\'' +
                    '}';
        }
    }
}
