/**
 * Created by tanjian on 2017/6/15.
 */
$(document).ready(function () {
    console.log("=============Spittr==By==谭建===============");
    console.log("^_^,哈哈，欢迎访问Spittr音乐网站。制作者：谭建");
    console.log("注：严禁将本网站所有内容用于商业用途，否则后果自负！");
    console.log("=============Spittr==By==谭建===============");
    console.log("=============目前状态：DeBug...===============");
    $(function () {
        $.cookie("plamusicPage", 0);
        $.cookie("playLists", "[]");

        $.get("/LatestRelease/loadData/singleMusic", function (data) {
            $('#ul_result_lr').html("");
            for (var i = 0; i < data.length; i++) {
                var html = "<li> <a href='#!' class='img playMusic' data-songurl='" + data[i].url + "' data-songid='" + data[i].songId + "' data-title='"+data[i].title+"'><img src='" + data[i].cover + "?imageView2/1/w/300/h/300/format/png/q/100|imageslim' alt=''>" +
                    "<span class='mask' data-songurl='" + data[i].url + "' data-songid='" + data[i].songId + "'></span><i class='icon-play'></i></a><div class='info'>" +
                    "<div class='title'> <a href='#!' data-songid='" + data[i].songId + "'>" + data[i].title + "</a><i class='icon-sprite'></i> </div> " +
                    "<a href='#!' class='author playMusic'>" + data[i].visitedTotal + "</a></div> </li>";
                $('#ul_result_lr').append(html);
            }
        });

        console.log("loading Data end !");
        $('#newSong').on('click', '.playMusic', function () {
            $.SpittrParseData.playParse($(this));
        });
        $('#newSong').on('click', '.title a', function () {
            console.log("songid:"+$(this).attr("data-songid"));
            $.SpittrParseData.jumpParse('song',$(this));
        });
        $('#jquery_jplayer_1').on('click','.songName',function () {

            console.log("点击了播放控件上面正在播放歌曲的Id:"+$(this).attr('data-songId'));
            var state={
                title:'',
                url:''
            };
            window.history.pushState(state,document.title,"#!songdtail/"+$(this).attr('data-songId'));
        });
    });
});
window.addEventListener('popstate',function (e) {
   if(history.state){
       var state=e.state;
       alert(state.title+" "+state.url);
   }
},false);

var playLists = [{
    id: 123456,
    title: "Never Back Down",
    mp3: 'http://oolw6on5m.bkt.clouddn.com/Never-Back-Down.mp3'
}, {
    id: 123343456,
    title: "Star Sky",
    mp3: "http://oolw6on5m.bkt.clouddn.com/Star-Sky.mp3"
}];
/*$('#jp_container_1').jPlayer({
 ready: function (event) {
 $(this).jPlayer("setMedia", {
 title: "Star Sky",
 mp3: "http://oolw6on5m.bkt.clouddn.com/Star-Sky.mp3"
 });
 },
 swfPath: '/js/',
 solution: 'html, flash',
 supplied: 'm4a, oga,mp3',
 preload: 'metadata',
 volume: 0.8,
 muted: false,
 backgroundColor: '#000000',
 cssSelectorAncestor: '#jquery_jplayer_1',
 cssSelector: {
 videoPlay: '.jp-video-play',
 play: '.jp-play',
 pause: '.jp-pause',
 stop: '.jp-stop',
 seekBar: '.jp-seek-bar',
 playBar: '.jp-play-bar',
 mute: '.jp-mute',
 unmute: '.jp-unmute',
 volumeBar: '.jp-volume-bar',
 volumeBarValue: '.jp-volume-bar-value',
 volumeMax: '.jp-volume-max',
 playbackRateBar: '.jp-playback-rate-bar',
 playbackRateBarValue: '.jp-playback-rate-bar-value',
 currentTime: '.jp-current-time',
 duration: '.jp-duration',
 title: '.jp-title',
 fullScreen: '.jp-full-screen',
 restoreScreen: '.jp-restore-screen',
 repeat: '.jp-repeat',
 repeatOff: '.jp-repeat-off',
 gui: '.jp-gui',
 noSolution: '.jp-no-solution'
 },
 errorAlerts: true,
 warningAlerts: true
 });*/

var cssSelector = {jPlayer: "#jp_container_1", cssSelectorAncestor: "#jquery_jplayer_1"};
var playlist = playLists; // Empty playlist
var options = {
    swfPath: '/js/',
    solution: 'html, flash',
    supplied: 'm4a, oga,mp3',
    preload: 'metadata',
    volume: 0.6,
    muted: false,
    backgroundColor: '#000000',
    playlistOptions: {
        enableRemoveControls: true
    },
    cssSelector: {
        videoPlay: '.jp-video-play',
        play: '.jp-play',
        pause: '.jp-pause',
        stop: '.jp-stop',
        seekBar: '.jp-seek-bar',
        playBar: '.jp-play-bar',
        mute: '.jp-mute',
        unmute: '.jp-unmute',
        volumeBar: '.jp-volume-bar',
        volumeBarValue: '.jp-volume-bar-value',
        volumeMax: '.jp-volume-max',
        playbackRateBar: '.jp-playback-rate-bar',
        playbackRateBarValue: '.jp-playback-rate-bar-value',
        currentTime: '.jp-current-time',
        duration: '.jp-duration',
        title: '.songName',
        fullScreen: '.jp-full-screen',
        restoreScreen: '.jp-restore-screen',
        repeat: '.jp-repeat',
        repeatOff: '.jp-repeat-off',
        gui: '.jp-gui',
        noSolution: '.jp-no-solution'
    },
    errorAlerts: true,
    warningAlerts: true
};
var myPlaylist = new jPlayerPlaylist(cssSelector, playlist, options);
$('#jquery_jplayer_1').find('.jp-title').removeAttr("display");

jQuery.SpittrJplayer = {
    getPlaylist: function () {
        return myPlaylist;
    },
    itemPlay: function (data) {
        console.log("准备播放:"+data.title);
        $.SpittrJplayer.getPlaylist().add(data);
        $.SpittrJplayer.getPlaylist().play(-1);
        $(document).attr('title', "▶ 正在播放:" + $.SpittrJplayer.getCurPlayTitle());
        //设置当前播放歌曲名的 data-songId 属性；
        $('#jquery_jplayer_1').find('.songName').attr('data-songId',$.SpittrJplayer.getCurPlayId());
    },
    getCurPlayId: function () {
        var current = myPlaylist.current;
        playlist = myPlaylist.playlist;
        var curId = "";
        jQuery.each(playlist, function (index, obj) {
            if (index == current) {
                curId = obj.id;
            } // if condition end
        });
        if (curId != "") {
            return curId;//返回当前播放器正在播放的单曲id}
        } else {
            console.log("curid==null");
        }
    },
    getCurPlayTitle: function () {
        var current = myPlaylist.current;
        playlist = myPlaylist.playlist;
        var curTitle = "";
        jQuery.each(playlist, function (index, obj) {
            if (index == current) {
                curTitle = obj.title;
            } // if condition end
        });
        if (curTitle != "") {
            return curTitle;//返回当前播放器正在播放的单曲 标题}
        } else {
            console.log("curTitle==null");
        }
    }
};

jQuery.SpittrParseData = {
    playParse:function (e) {
        var songId=e.attr("data-songid");
        var url=e.attr("data-songurl");
        var tit=e.attr("data-title");
        $.SpittrJplayer.itemPlay({id:songId,title:tit,artist:null,mp3:url,poster:""});
    },
    jumpParse:function (type,e) {
        switch (type){
            //TODO:待完善不同业务
            case 'song':{e.attr("data-songid")}break;
            case 'album':{e.attr('')}break;
        }

    }
};
