/* 母版页JS */
// Cookies 插件

// Cookies 插件
(function ($, document, undefined) {
    var pluses = /\+/g;

    function raw(s) {
        return s;
    }

    function decoded(s) {
        return unRfc2068(decodeURIComponent(s.replace(pluses, ' ')));
    }

    function unRfc2068(value) {
        if (value.indexOf('"') === 0) {
            // This is a quoted cookie as according to RFC2068, unescape
            value = value.slice(1, -1).replace(/\\"/g, '"').replace(/\\\\/g, '\\');
        }
        return value;
    }

    function fromJSON(value) {
        return config.json ? JSON.parse(value) : value;
    }

    var config = $.cookie = function (key, value, options) {

        // write
        if (value !== undefined) {
            options = $.extend({}, config.defaults, options);

            if (value === null) {
                options.expires = -1;
            }

            if (typeof options.expires === 'number') {
                var days = options.expires, t = options.expires = new Date();
                t.setDate(t.getDate() + days);
            }

            value = config.json ? JSON.stringify(value) : String(value);

            return (document.cookie = [
				encodeURIComponent(key), '=', config.raw ? value : encodeURIComponent(value),
				options.expires ? '; expires=' + options.expires.toUTCString() : '', // use expires attribute, max-age is not supported by IE
				options.path ? '; path=' + options.path : '',
				options.domain ? '; domain=' + options.domain : '',
				options.secure ? '; secure' : ''
            ].join(''));
        }

        // read
        var decode = config.raw ? raw : decoded;
        var cookies = document.cookie.split('; ');
        var result = key ? null : {};
        for (var i = 0, l = cookies.length; i < l; i++) {
            var parts = cookies[i].split('=');
            var name = decode(parts.shift());
            var cookie = decode(parts.join('='));

            if (key && key === name) {
                result = fromJSON(cookie);
                break;
            }

            if (!key) {
                result[name] = fromJSON(cookie);
            }
        }

        return result;
    };

    config.defaults = {};

    $.removeCookie = function (key, options) {
        if ($.cookie(key) !== null) {
            $.cookie(key, null, options);
            return true;
        }
        return false;
    };

})(jQuery, document);


$().ready(function(){
$(".leftsidebar_box dt").css({"background-color":"#3992d0"});
$(".leftsidebar_box dt img").attr("src",_MVC_BASEPATH+"/meun/images/left/select_xl01.png");
$(function(){
	$(".leftsidebar_box dd").hide();
	$(".leftsidebar_box dt").click(function(){
		$(".leftsidebar_box dt").css({"background-color":"#3992d0"})
		$(this).css({"background-color": "#317eb4"});
		$(this).parent().find('dd').removeClass("menu_chioce");
		$(".leftsidebar_box dt img").attr("src",_MVC_BASEPATH+"/menu/images/left/select_xl01.png");
		$(this).parent().find('img').attr("src",_MVC_BASEPATH+"/menu/images/left/select_xl.png");
		$(".menu_chioce").slideUp();
		$(this).parent().find('dd').slideToggle();
		$(this).parent().find('dd').addClass("menu_chioce");
		
		////点击dl的时候，将dl的class属性保存到cookie中
		var ddclass=$(this).attr("class");
		$.cookie("lastClick",ddclass,{path:'/'});
	});
	
	////点击dd的时候，获取dd所在同一级的dl的class保存到cookie中
	$(".leftsidebar_box dd").click(function(){
		var ddclass=$(this).parent().find('dt').attr("class");
		$.cookie("lastClick",ddclass,{ path: '/' });
	});
	
	////获取保存在cookie中的dl的class，模拟点击一次
	var cookieValue=$.cookie("lastClick");
	if(cookieValue !== "" && typeof cookieValue !== "undefined" && cookieValue != null){
		cookieValue="."+cookieValue;
		$(cookieValue).click();
	}
	
})});