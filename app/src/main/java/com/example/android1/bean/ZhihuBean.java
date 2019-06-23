package com.example.android1.bean;

import java.util.List;

/**
 * Created by 张亚丹 on 2019/6/8.
 */

public class ZhihuBean {

    /**
     * date : 20190608
     * stories : [{"images":["https://pic4.zhimg.com/v2-e580f27c746ad99d58e66276066bba03.jpg"],"type":0,"id":9712339,"ga_prefix":"060822","title":"小事 · 参加 2019 年高考是一种怎样的体验？"},{"images":["https://pic1.zhimg.com/v2-5b7d52784bcb3439bfab3f2fe0f0075c.jpg"],"type":0,"id":9712194,"ga_prefix":"060820","title":"作为导演，如何引导演员表演？"},{"images":["https://pic4.zhimg.com/v2-87be8ea01c86821bd2853ba39e67eccf.jpg"],"type":0,"id":9712166,"ga_prefix":"060816","title":"光刻技术为什么对芯片制造至关重要？"},{"images":["https://pic3.zhimg.com/v2-c19d8944e8dc4233480569827387cc7a.jpg"],"type":0,"id":9712188,"ga_prefix":"060809","title":"工作后，你悟出什么职场道理？"},{"images":["https://pic2.zhimg.com/v2-890698a8fc9b75f81036c360a98a3171.jpg"],"type":0,"id":9712179,"ga_prefix":"060807","title":"千万别让我喜欢的乐队火了"},{"images":["https://pic1.zhimg.com/v2-5b12f855abdb014a301771c756a15db0.jpg"],"type":0,"id":9712128,"ga_prefix":"060806","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic1.zhimg.com/v2-af99447ded7fe236a2113bfae6f3aad8.jpg","type":0,"id":9712095,"ga_prefix":"060407","title":"Uniqlo x KAWS 的发售「乱象」，是怎么出现的？"},{"image":"https://pic1.zhimg.com/v2-cbc334204e7ffb639735367122eff48c.jpg","type":0,"id":9712142,"ga_prefix":"060408","title":"旗帜鲜明地反对断骨增高手术"},{"image":"https://pic1.zhimg.com/v2-96666b0894871ab0dbcf76dcccac6c40.jpg","type":0,"id":9712046,"ga_prefix":"060308","title":"结婚 5 年，双方父母没见面，过年各回各家，Papi 酱的婚姻模式适合你吗？"},{"image":"https://pic3.zhimg.com/v2-c041e9c1e28edc3100309532742509f2.jpg","type":0,"id":9712013,"ga_prefix":"053108","title":"百度最难捱的一夜：五名高管闪电辞职内幕"},{"image":"https://pic1.zhimg.com/v2-548d3d615b68aa27421475875d2b410c.jpg","type":0,"id":9711876,"ga_prefix":"053008","title":"高铁这么好的东西，美国人为什么不大力发展？"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic4.zhimg.com/v2-e580f27c746ad99d58e66276066bba03.jpg"]
         * type : 0
         * id : 9712339
         * ga_prefix : 060822
         * title : 小事 · 参加 2019 年高考是一种怎样的体验？
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic1.zhimg.com/v2-af99447ded7fe236a2113bfae6f3aad8.jpg
         * type : 0
         * id : 9712095
         * ga_prefix : 060407
         * title : Uniqlo x KAWS 的发售「乱象」，是怎么出现的？
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
