/**
 * Created by tanjian on 2017/6/15.
 */
$(function () {
    console.log("loading Data...");
    var data_latestRelease_list = {
        "top_lr": [
            {
                "title": "1",
                "imgUrl": "http://oolx3565r.bkt.clouddn.com/Game-of-Thrones.jpg?imageView2/1/w/300/h/300/format/png/q/100|imageslim",
                "author": "tanjian"
            }, {
                "title": "1",
                "imgUrl": "http://oolx3565r.bkt.clouddn.com/Game-of-Thrones.jpg?imageView2/1/w/300/h/300/format/png/q/100|imageslim",
                "author": "tanjian"
            }, {
                "title": "1",
                "imgUrl": "http://oolx3565r.bkt.clouddn.com/Game-of-Thrones.jpg?imageView2/1/w/300/h/300/format/png/q/100|imageslim",
                "author": "tanjian"
            }, {
                "title": "1",
                "imgUrl": "http://oolx3565r.bkt.clouddn.com/Game-of-Thrones.jpg?imageView2/1/w/300/h/300/format/png/q/100|imageslim",
                "author": "tanjian"
            }, {
                "title": "1",
                "imgUrl": "http://oolx3565r.bkt.clouddn.com/Game-of-Thrones.jpg?imageView2/1/w/300/h/300/format/png/q/100|imageslim",
                "author": "tanjian"
            }, {
                "title": "1",
                "imgUrl": "http://oolx3565r.bkt.clouddn.com/Game-of-Thrones.jpg?imageView2/1/w/300/h/300/format/png/q/100|imageslim",
                "author": "tanjian"
            }, {
                "title": "1",
                "imgUrl": "http://oolx3565r.bkt.clouddn.com/Game-of-Thrones.jpg?imageView2/1/w/300/h/300/format/png/q/100|imageslim",
                "author": "tanjian"
            }, {
                "title": "1",
                "imgUrl": "http://oolx3565r.bkt.clouddn.com/Game-of-Thrones.jpg?imageView2/1/w/300/h/300/format/png/q/100|imageslim",
                "author": "tanjian"
            }, {
                "title": "1",
                "imgUrl": "http://oolx3565r.bkt.clouddn.com/Game-of-Thrones.jpg?imageView2/1/w/300/h/300/format/png/q/100|imageslim",
                "author": "tanjian"
            }, {
                "title": "1",
                "imgUrl": "http://oolx3565r.bkt.clouddn.com/Game-of-Thrones.jpg?imageView2/1/w/300/h/300/format/png/q/100|imageslim",
                "author": "tanjian"
            }, {
                "title": "1",
                "imgUrl": "http://oolx3565r.bkt.clouddn.com/Game-of-Thrones.jpg?imageView2/1/w/300/h/300/format/png/q/100|imageslim",
                "author": "tanjian"
            }
        ]
    };
    var bt = baidu.template;
    var html = bt('t:_latestRelease_list', data_latestRelease_list);
    //渲染
    document.getElementById('ul_result_lr').innerHTML = html;
    console.log("loading Data end !");
});
