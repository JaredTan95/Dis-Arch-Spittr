/**
 * Created by tanjian on 2017/6/15.
 */
$(function () {
    $.cookie("plamusicPage", 0);
    $.cookie("playLists", "[]");

    $.get("/LatestRelease/loadData/singleMusic", function (data) {
        $('#ul_result_lr').html("");
        for (var i = 0; i < data.length; i++) {
            var html = "<li> <a href='#!' class='img playMusic' data-songurl='" + data[i].url + "' data-songid='" + data[i].songId + "'><img src='" + data[i].cover + "?imageView2/1/w/300/h/300/format/png/q/100|imageslim' alt=''>" +
                "<span class='mask' data-songurl='" + data[i].url + "' data-songid='" + data[i].songId + "'></span><i class='icon-play'></i></a><div class='info'>" +
                "<div class='title'> <a href='#!' data-songid='" + data[i].songId + "'>" + data[i].title + "</a><i class='icon-sprite'></i> </div> " +
                "<a href='#!' class='author playMusic'>" + data[i].visitedTotal + "</a></div> </li>";
            $('#ul_result_lr').append(html);
        }
    });

    console.log("loading Data end !");
    $('#newSong').on('click', '.playMusic', function () {
        if (havaMusicPlayPage()) {
            alert("已经有打开的页面");
            console.log($.cookie("playLists"))
        } else {
            alert("没有打开的页面");
            window.open("/play_audio.html");
            $.cookie("plamusicPage", 1);
            console.log($.cookie("playLists"));
        }
    });


    function havaMusicPlayPage() {
        console.log($.cookie("plamusicPage"));
        return $.cookie("plamusicPage") != 0;
    }
});
