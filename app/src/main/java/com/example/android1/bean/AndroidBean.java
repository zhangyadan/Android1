package com.example.android1.bean;

import java.util.List;

/**
 * Created by 张亚丹 on 2019/6/16.
 */

public class AndroidBean {

    /**
     * error : false
     * results : [{"_id":"5d0214689d212203197e0f1e","createdAt":"2019-06-13T09:16:24.944Z","desc":"自定义红点控件，不用修改之前的代码，完全解耦，可以支持设置在TextView，Button，LinearLayout，RelativeLayout，TabLayout等等控件上\u2026\u2026","images":["http://img.gank.io/be00e66e-cb86-4f46-8e92-47609045a571"],"publishedAt":"2019-06-13T09:16:45.189Z","source":"web","type":"Android","url":"https://github.com/yangchong211/YCRedDotView","used":true,"who":"潇湘剑雨"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 5d0214689d212203197e0f1e
         * createdAt : 2019-06-13T09:16:24.944Z
         * desc : 自定义红点控件，不用修改之前的代码，完全解耦，可以支持设置在TextView，Button，LinearLayout，RelativeLayout，TabLayout等等控件上……
         * images : ["http://img.gank.io/be00e66e-cb86-4f46-8e92-47609045a571"]
         * publishedAt : 2019-06-13T09:16:45.189Z
         * source : web
         * type : Android
         * url : https://github.com/yangchong211/YCRedDotView
         * used : true
         * who : 潇湘剑雨
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
