!function(e){e.fn.fullpage=function(i){function t(t){if(i.autoScrolling){t=window.event||t,t=Math.max(-1,Math.min(1,t.wheelDelta||-t.detail));var n;if(n=e(".section.active"),!k)if(n=n.find(".slides").length?n.find(".slide.active").find(".scrollable"):n.find(".scrollable"),0>t)if(0<n.length){if(!d("bottom",n))return!0;e.fn.fullpage.moveSectionDown()}else e.fn.fullpage.moveSectionDown();else if(0<n.length){if(!d("top",n))return!0;e.fn.fullpage.moveSectionUp()}else e.fn.fullpage.moveSectionUp();return!1}}function n(){document.addEventListener?(document.addEventListener("mousewheel",t,!1),document.addEventListener("DOMMouseScroll",t,!1)):document.attachEvent("onmousewheel",t)}function a(t,n){var a,s={},o=t.position(),o=null!==o?o.top:null,l=p(t),d=t.data("anchor"),f=t.index(".section"),u=t.find(".slide.active");if(u.length){a=u.data("anchor");var m=u.index()}u=e(".section.active").index(".section")+1,t.addClass("active").siblings().removeClass("active"),k=!0,"undefined"!=typeof d?w(m,a,d):location.hash="",i.autoScrolling?(s.top=-o,a="#superContainer"):(s.scrollTop=o,a="html, body"),i.css3&&i.autoScrolling?(e.isFunction(i.onLeave)&&i.onLeave.call(this,u,l),v("translate3d(0px, -"+o+"px, 0px)",!0),setTimeout(function(){e.isFunction(i.afterLoad)&&i.afterLoad.call(this,d,f+1),setTimeout(function(){k=!1,e.isFunction(n)&&n.call(this)},b)},i.scrollingSpeed)):(e.isFunction(i.onLeave)&&i.onLeave.call(this,u,l),e(a).animate(s,i.scrollingSpeed,i.easing,function(){e.isFunction(i.afterLoad)&&i.afterLoad.call(this,d,f+1),setTimeout(function(){k=!1,e.isFunction(n)&&n.call(this)},b)})),j=d,i.autoScrolling&&(c(d),r(d,f))}function s(t,n){var a=n.position(),s=t.find(".slidesContainer").parent(),o=n.index(),l=t.closest(".section"),r=l.index(".section"),c=l.data("anchor"),d=l.find(".fullPage-slidesNav"),p=n.data("anchor");if(i.onSlideLeave){var f,u=l.find(".slide.active").index();f=u>o?"left":"right",e.isFunction(i.onSlideLeave)&&i.onSlideLeave.call(this,c,r+1,u,f)}n.addClass("active").siblings().removeClass("active"),"undefined"==typeof p&&(p=o),l.hasClass("active")&&(i.loopHorizontal||(l.find(".controlArrow.prev").toggle(0!=o),l.find(".controlArrow.next").toggle(!n.is(":last-child"))),w(o,p,c)),i.css3?(a="translate3d(-"+a.left+"px, 0px, 0px)",t.find(".slidesContainer").addClass("easing").css({"-webkit-transform":a,"-moz-transform":a,"-ms-transform":a,transform:a}),setTimeout(function(){e.isFunction(i.afterSlideLoad)&&i.afterSlideLoad.call(this,c,r+1,p,o),x=!1},i.scrollingSpeed)):s.animate({scrollLeft:a.left},i.scrollingSpeed,function(){e.isFunction(i.afterSlideLoad)&&i.afterSlideLoad.call(this,c,r+1,p,o),x=!1}),d.find(".active").removeClass("active"),d.find("li").eq(o).find("a").addClass("active")}function o(){var t=e(window).width();S=e(window).height(),i.resize&&l(S,t),e(".section").each(function(){if(parseInt(e(this).css("padding-bottom")),parseInt(e(this).css("padding-top")),i.scrollOverflow){var t=e(this).find(".slide");t.length?t.each(function(){f(e(this))}):f(e(this))}i.verticalCentered&&e(this).find(".tableCell").css("height",S+"px"),e(this).css("height",S+"px"),t=e(this).find(".slides"),t.length&&s(t,t.find(".slide.active"))}),e(".section.active").position(),t=e(".section.active"),t.index(".section")&&a(t)}function l(i,t){var n=825,a=i;825>i||900>t?(900>t&&(a=t,n=900),n=(100*a/n).toFixed(2),e("body").css("font-size",n+"%")):e("body").css("font-size","100%")}function r(t,n){i.navigation&&(e("#fullPage-nav").find(".active").removeClass("active"),t?e("#fullPage-nav").find('a[href="#'+t+'"]').addClass("active"):e("#fullPage-nav").find("li").eq(n).find("a").addClass("active"))}function c(t){i.menu&&(e(i.menu).find(".active").removeClass("active"),e(i.menu).find('[data-menuanchor="'+t+'"]').addClass("active"))}function d(e,i){return"top"===e?!i.scrollTop():"bottom"===e?i.scrollTop()+i.innerHeight()>=i[0].scrollHeight:void 0}function p(i){var t=e(".section.active").index(".section");return i=i.index(".section"),t>i?"up":"down"}function f(e){e.css("overflow","hidden");var t=e.closest(".section"),n=e.find(".scrollable");(n.length?e.find(".scrollable").get(0).scrollHeight-parseInt(t.css("padding-bottom"))-parseInt(t.css("padding-top")):e.get(0).scrollHeight-parseInt(t.css("padding-bottom"))-parseInt(t.css("padding-top")))>S?(t=S-parseInt(t.css("padding-bottom"))-parseInt(t.css("padding-top")),n.length?n.css("height",t+"px").parent().css("height",t+"px"):(i.verticalCentered?e.find(".tableCell").wrapInner('<div class="scrollable" />'):e.wrapInner('<div class="scrollable" />'),e.find(".scrollable").slimScroll({height:t+"px",size:"10px",alwaysVisible:!0}))):(e.find(".scrollable").children().first().unwrap().unwrap(),e.find(".slimScrollBar").remove(),e.find(".slimScrollRail").remove()),e.css("overflow","")}function u(e){e.addClass("table").wrapInner('<div class="tableCell" style="height:'+S+'px;" />')}function v(i,t){e("#superContainer").toggleClass("easing",t),e("#superContainer").css({"-webkit-transform":i,"-moz-transform":i,"-ms-transform":i,transform:i})}function m(i,t){var n=isNaN(i)?e('[data-anchor="'+i+'"]'):e(".section").eq(i-1);i===j||n.hasClass("active")?g(n,t):a(n,function(){g(n,t)})}function g(e,i){if("undefined"!=typeof i){var t=e.find(".slides"),n=t.find('[data-anchor="'+i+'"]');n.length||(n=t.find(".slide").eq(i)),n.length&&s(t,n)}}function h(e,t){e.append('<div class="fullPage-slidesNav"><ul></ul></div>');var n=e.find(".fullPage-slidesNav");n.addClass(i.slidesNavPosition);for(var a=0;a<t;a++)n.find("ul").append('<li><a href="#"><span></span></a></li>');n.css("margin-left","-"+n.width()/2+"px"),n.find("li").first().find("a").addClass("active")}function w(e,i,t){var n="";e?("undefined"!=typeof t&&(n=t),"undefined"==typeof i&&(i=e),C=i,location.hash=n+"/"+i):location.hash=t}function _(){var e,i=document.createElement("p"),t={webkitTransform:"-webkit-transform",OTransform:"-o-transform",msTransform:"-ms-transform",MozTransform:"-moz-transform",transform:"transform"};document.body.insertBefore(i,null);for(var n in t)void 0!==i.style[n]&&(i.style[n]="translate3d(1px,1px,1px)",e=window.getComputedStyle(i).getPropertyValue(t[n]));return document.body.removeChild(i),void 0!==e&&0<e.length&&"none"!==e}i=e.extend({verticalCentered:!0,resize:!0,slidesColor:[],anchors:[],scrollingSpeed:700,easing:"easeInQuart",menu:!1,navigation:!1,navigationPosition:"right",navigationColor:"#000",navigationTooltips:[],slidesNavigation:!1,slidesNavPosition:"bottom",controlArrowColor:"#fff",loopBottom:!1,loopTop:!1,loopHorizontal:!0,autoScrolling:!0,scrollOverflow:!1,css3:!1,paddingTop:0,paddingBottom:0,fixedElements:null,normalScrollElements:null,afterLoad:null,onLeave:null,afterRender:null,afterSlideLoad:null,onSlideLeave:null},i);var b=700;e.fn.fullpage.setAutoScrolling=function(t){i.autoScrolling=t,t=e(".section.active"),i.autoScrolling?(e("html, body").css({overflow:"hidden",height:"100%"}),t.length&&(i.css3?(t="translate3d(0px, -"+t.position().top+"px, 0px)",v(t,!1)):e("#superContainer").css("top","-"+t.position().top+"px"))):(e("html, body").css({overflow:"auto",height:"auto"}),i.css3?v("translate3d(0px, 0px, 0px)",!1):e("#superContainer").css("top","0px"),e("html, body").scrollTop(t.position().top))};var j,C,x=!1,$=navigator.userAgent.match(/(iPhone|iPod|iPad|Android|BlackBerry|Windows Phone)/),S=e(window).height(),k=!1;if(n(),i.css3&&(i.css3=_()),e("body").wrapInner('<div id="superContainer" />'),i.navigation){e("body").append('<div id="fullPage-nav"><ul></ul></div>');var y=e("#fullPage-nav");y.css("color",i.navigationColor),y.addClass(i.navigationPosition)}e(".section").each(function(t){var n=e(this).find(".slide"),a=n.length;if(t||e(this).addClass("active"),e(this).css("height",S+"px"),(i.paddingTop||i.paddingBottom)&&e(this).css("padding",i.paddingTop+" 0 "+i.paddingBottom+" 0"),"undefined"!=typeof i.slidesColor[t]&&e(this).css("background-color",i.slidesColor[t]),"undefined"!=typeof i.anchors[t]&&e(this).attr("data-anchor",i.anchors[t]),i.navigation){var s="";i.anchors.length&&(s=i.anchors[t]),t=i.navigationTooltips[t],"undefined"==typeof t&&(t=""),y.find("ul").append('<li data-tooltip="'+t+'"><a href="#'+s+'"><span></span></a></li>')}if(0<a){var s=100*a,o=100/a;n.wrapAll('<div class="slidesContainer" />'),n.parent().wrap('<div class="slides" />'),e(this).find(".slidesContainer").css("width",s+"%"),e(this).find(".slides").after('<div class="controlArrow prev"></div><div class="controlArrow next"></div>'),e(this).find(".controlArrow.next").css("border-color","transparent transparent transparent "+i.controlArrowColor),e(this).find(".controlArrow.prev").css("border-color","transparent "+i.controlArrowColor+" transparent transparent"),i.loopHorizontal||e(this).find(".controlArrow.prev").hide(),i.slidesNavigation&&h(e(this),a),n.each(function(t){t||e(this).addClass("active"),e(this).css("width",o+"%"),i.verticalCentered&&u(e(this))})}else i.verticalCentered&&u(e(this))}).promise().done(function(){e.fn.fullpage.setAutoScrolling(i.autoScrolling),e.isFunction(i.afterRender)&&i.afterRender.call(this),i.fixedElements&&i.css3&&e(i.fixedElements).appendTo("body"),i.navigation&&(y.css("margin-top","-"+y.height()/2+"px"),y.find("li").first().find("a").addClass("active")),i.menu&&i.css3&&e(i.menu).appendTo("body"),i.scrollOverflow&&e(window).on("load",function(){e(".section").each(function(){var i=e(this).find(".slide");i.length?i.each(function(){f(e(this))}):f(e(this))})}),e(window).on("load",function(){var e=window.location.hash.replace("#","").split("/"),i=e[0],e=e[1];i&&m(i,e)})});var T,L=!1;e(window).scroll(function(t){if(!i.autoScrolling){var n=e(window).scrollTop();if(t=e(".section").map(function(){if(e(this).offset().top<n+100)return e(this)}),t=t[t.length-1],!t.hasClass("active")){L=!0;var a=p(t);e(".section.active").removeClass("active"),t.addClass("active");var s=t.data("anchor");e.isFunction(i.onLeave)&&i.onLeave.call(this,t.index(".section"),a),e.isFunction(i.afterLoad)&&i.afterLoad.call(this,s,t.index(".section")+1),c(s),r(s,0),i.anchors.length&&!k&&(j=s,location.hash=s),clearTimeout(T),T=setTimeout(function(){L=!1},100)}}});var P=0,q=0,N=0,A=0;if(e(document).on("touchmove",function(t){if(i.autoScrolling&&$){t.preventDefault(),t=t.originalEvent;var n=e(".section.active");if(!k&&!x)if(N=t.touches[0].pageY,A=t.touches[0].pageX,n.find(".slides").length&&Math.abs(q-A)>Math.abs(P-N))q>A?n.find(".controlArrow.next").trigger("click"):q<A&&n.find(".controlArrow.prev").trigger("click");else if(t=n.find(".slides").length?n.find(".slide.active").find(".scrollable"):n.find(".scrollable"),P>N)if(0<t.length){if(!d("bottom",t))return!0;e.fn.fullpage.moveSectionDown()}else e.fn.fullpage.moveSectionDown();else if(0<t.length){if(!d("top",t))return!0;e.fn.fullpage.moveSectionUp()}else e.fn.fullpage.moveSectionUp()}}),e(document).on("touchstart",function(e){i.autoScrolling&&$&&(e=e.originalEvent,P=e.touches[0].pageY,q=e.touches[0].pageX)}),e.fn.fullpage.moveSectionUp=function(){var t=e(".section.active").prev(".section");i.loopTop&&!t.length&&(t=e(".section").last()),(0<t.length||!t.length&&i.loopTop)&&a(t)},e.fn.fullpage.moveSectionDown=function(){var t=e(".section.active").next(".section");i.loopBottom&&!t.length&&(t=e(".section").first()),(0<t.length||!t.length&&i.loopBottom)&&a(t)},e.fn.fullpage.moveTo=function(i,t){var n="",n=isNaN(i)?e('[data-anchor="'+i+'"]'):e(".section").eq(i-1);"undefined"!==t?m(i,t):0<n.length&&a(n)},e(window).on("hashchange",function(){if(!L){var e=window.location.hash.replace("#","").split("/"),i=e[0],e=e[1],t="undefined"==typeof j,n="undefined"==typeof j&&"undefined"==typeof e;(i&&i!==j&&!t||n||"undefined"!=typeof e&&!x&&C!=e)&&m(i,e)}}),e(document).keydown(function(i){if(!k)switch(i.which){case 38:case 33:e.fn.fullpage.moveSectionUp();break;case 40:case 34:e.fn.fullpage.moveSectionDown();break;case 37:e(".section.active").find(".controlArrow.prev").trigger("click");break;case 39:e(".section.active").find(".controlArrow.next").trigger("click")}}),e(document).on("click","#fullPage-nav a",function(i){i.preventDefault(),i=e(this).parent().index(),a(e(".section").eq(i))}),e(document).on({mouseenter:function(){var t=e(this).data("tooltip");e('<div class="fullPage-tooltip '+i.navigationPosition+'">'+t+"</div>").hide().appendTo(e(this)).fadeIn(200)},mouseleave:function(){e(this).find(".fullPage-tooltip").fadeOut().remove()}},"#fullPage-nav li"),i.normalScrollElements&&(e(document).on("mouseover",i.normalScrollElements,function(){document.addEventListener?(document.removeEventListener("mousewheel",t,!1),document.removeEventListener("DOMMouseScroll",t,!1)):document.detachEvent("onmousewheel",t)}),e(document).on("mouseout",i.normalScrollElements,function(){n()})),e(".section").on("click",".controlArrow",function(){if(!x){x=!0;var i=e(this).closest(".section").find(".slides"),t=i.find(".slide.active"),n=null,n=e(this).hasClass("prev")?t.prev(".slide"):t.next(".slide");n.length||(n=e(this).hasClass("prev")?t.siblings(":last"):t.siblings(":first")),s(i,n)}}),e(".section").on("click",".toSlide",function(i){i.preventDefault(),i=e(this).closest(".section").find(".slides"),i.find(".slide.active");var t=null,t=i.find(".slide").eq(e(this).data("index")-1);0<t.length&&s(i,t)}),!$){var E;e(window).resize(function(){clearTimeout(E),E=setTimeout(o,500)})}e(window).bind("orientationchange",function(){o()}),e(document).on("click",".fullPage-slidesNav a",function(i){i.preventDefault(),i=e(this).closest(".section").find(".slides");var t=i.find(".slide").eq(e(this).closest("li").index());s(i,t)})}}(jQuery),function(e){var i=function(e){return e.split("").reverse().join("")},t={numberStep:function(i,t){var n=Math.floor(i);e(t.elem).text(n)}},n=function(e){var i=e.elem;i.nodeType&&i.parentNode&&(i=i._animateNumberSetter,i||(i=t.numberStep),i(e.now,e))};e.Tween&&e.Tween.propHooks?e.Tween.propHooks.number={set:n}:e.fx.step.number=n,e.animateNumber={numberStepFactories:{append:function(i){return function(t,n){var a=Math.floor(t);e(n.elem).prop("number",t).text(a+i)}},separator:function(t,n){return t=t||" ",n=n||3,function(a,s){var o=Math.floor(a).toString(),l=e(s.elem);if(o.length>n){for(var r,c,d,p=o,f=n,u=p.split("").reverse(),o=[],v=0,m=Math.ceil(p.length/f);v<m;v++){for(r="",d=0;d<f&&(c=v*f+d,c!==p.length);d++)r+=u[c];o.push(r)}p=o.length-1,f=i(o[p]),o[p]=i(parseInt(f,10).toString()),o=o.join(t),o=i(o)}l.prop("number",a).text(o)}}}},e.fn.animateNumber=function(){for(var i=arguments[0],n=e.extend({},t,i),a=e(this),s=[n],o=1,l=arguments.length;o<l;o++)s.push(arguments[o]);if(i.numberStep){var r=this.each(function(){this._animateNumberSetter=i.numberStep}),c=n.complete;n.complete=function(){r.each(function(){delete this._animateNumberSetter}),c&&c.apply(this,arguments)}}return a.animate.apply(a,s)}}(jQuery),$(document).ready(function(){function e(){var e=!0;new $(".jirui_page1 .ib_slider").slidesjs({height:a,event:"click",play:{active:!1,auto:!0,interval:5e3,restartDelay:5e3,swap:!0},navigation:{active:!1},pagination:{active:!0},effect:{slide:{speed:1200}},callback:{complete:function(i){switch($(".jp1_text .slidesjs-pagination-item").removeClass("active"),i){case 1:$(".slides1").addClass("active");break;case 2:$(".slides2").addClass("active");break;case 3:$(".slides3").addClass("active")}var t=0;if(e)t=1==i?$(".jirui_page1 .ib_mark .slidesjs-pagination-item").length-1:i-2,$(".jirui_page1 .ib_mark .slidesjs-pagination-item").eq(t).find(".im_progress").css({width:"0"}),$(".jirui_page1 .ib_mark .slidesjs-pagination-item").each(function(){var e=$(this).find("a");parseInt(e.attr("html"))==i&&n(i-1,"jirui_page1","im_progress","im_active")});else{var a=$(".jirui_page1 .slidesjs-pagination-item a").find(".im_progress"),s=$(".jirui_page1 .slidesjs-pagination-item a").find(".im_active");a.stop(!0,!0).css({width:"0"}),s.css({width:"50px"}),$(".jirui_page1 .ib_mark .slidesjs-pagination-item").eq(i-1).find(".im_progress").stop(!0,!0).css({width:"50px"}),$(".jirui_page1 .ib_mark .slidesjs-pagination-item").eq(i-1).find(".im_active").css({width:"0"})}}}});n(0,"jirui_page1","im_progress","im_active"),$(".jirui_page1 .slidesjs-pagination-item a").click(function(){e=!1})}function i(){var e=!0;new $(".jirui_page3 .ib_slider").slidesjs({height:a,event:"click",play:{active:!1,auto:!0,interval:5e3,restartDelay:5e3,swap:!0},navigation:{active:!1},pagination:{active:!0},effect:{slide:{speed:1200}},callback:{complete:function(i){switch($(".jp3_text p").removeClass("active"),i){case 1:$(".text1").addClass("active");break;case 2:$(".text2").addClass("active");break;case 3:$(".text3").addClass("active")}var t=0;if(e)t=1==i?$(".jirui_page3 .ib_mark .slidesjs-pagination-item").length-1:i-2,$(".jirui_page3 .ib_mark .slidesjs-pagination-item").eq(t).find(".im_progress").css({width:"0"}),$(".jirui_page3 .ib_mark .slidesjs-pagination-item").each(function(){var e=$(this).find("a");parseInt(e.attr("html"))==i&&n(i-1,"jirui_page3","im_progress","im_active")});else{var a=$(".jirui_page3 .slidesjs-pagination-item a").find(".im_progress"),s=$(".jirui_page3 .slidesjs-pagination-item a").find(".im_active");a.stop(!0,!0).css({width:"0"}),s.css({width:"50px"}),$(".jirui_page3 .ib_mark .slidesjs-pagination-item").eq(i-1).find(".im_progress").stop(!0,!0).css({width:"50px"}),$(".jirui_page3 .ib_mark .slidesjs-pagination-item").eq(i-1).find(".im_active").css({width:"0"})}}}});n(0,"jirui_page3","im_progress","im_active"),$(".jirui_page3 .slidesjs-pagination-item a").click(function(){e=!1})}function t(){var e=!0;new $(".jirui_page9 .ib_slider").slidesjs({height:a,event:"click",play:{active:!1,auto:!0,interval:5e3,restartDelay:5e3,swap:!0},navigation:{active:!1},pagination:{active:!0},effect:{slide:{speed:1200}},callback:{complete:function(i){var t=0;if(e)t=1==i?$(".jirui_page9 .ib_mark .slidesjs-pagination-item").length-1:i-2,$(".jirui_page9 .ib_mark .slidesjs-pagination-item").eq(t).find(".im_progress").css({width:"0"}),$(".jirui_page9 .ib_mark .slidesjs-pagination-item").each(function(){var e=$(this).find("a");parseInt(e.attr("html"))==i&&n(i-1,"jirui_page9","im_progress","im_active")});else{var a=$(".jirui_page9 .slidesjs-pagination-item a").find(".im_progress"),s=$(".jirui_page9 .slidesjs-pagination-item a").find(".im_active");a.stop(!0,!0).css({width:"0"}),s.css({width:"50px"}),$(".jirui_page9 .ib_mark .slidesjs-pagination-item").eq(i-1).find(".im_progress").stop(!0,!0).css({width:"50px"}),$(".jirui_page9 .ib_mark .slidesjs-pagination-item").eq(i-1).find(".im_active").css({width:"0"})}}}});n(0,"jirui_page9","im_progress","im_active"),$(".jirui_page9 .slidesjs-pagination-item a").click(function(){e=!1})}function n(e,i,t,n){var a=4500;if(void 0==e||void 0==t||void 0==n)return!1;if("number"!=typeof e&&"string"!=typeof e)return!1;if("string"==typeof e&&(e=parseInt(e),NaN==e))return!1;var s=$("."+i+" .ib_mark .slidesjs-pagination-item").eq(e).find("."+t),o=$("."+i+" .ib_mark .slidesjs-pagination-item").eq(e).find("."+n);return void 0!=s&&void 0!=o&&void s.stop(!0,!0).animate({width:"50px"},a)}var a=window.innerHeight||document.documentElement&&document.documentElement.clientHeight||document.body.clientHeight;$("#nav_txt").find("li").eq(0).css("opacity",1),$.fn.fullpage({anchors:["page1","page2","page3","page4","page5","page6","page7","page8","page9","page10"],navigation:!0,afterLoad:function(n,a){$("#nav_txt").find("li").eq(a-1).css("opacity",1),$("#nav_txt").find("li").eq(a-1).siblings().css("opacity",0),$(".jp4_mask").removeClass("animate"),$(".jp4_lights li").removeClass("animate"),$(".jp7_item").removeClass("animate"),$(".jp6_pro>div").removeClass("animate"),$(".jp8_item").removeClass("animate"),$(".jp8_line").removeClass("animate"),1!=a?($(".header").hide(),$(".getTop").css({display:"block"}),$(".getTop").attr({href:"#page1"})):($(".header").show(),e()),3==a?i():4==a?$(".jp4_btn").click(function(){$(this).hasClass("jp4_back")?($(".jp4_mask").removeClass("animate"),$(".jp4_lights li").removeClass("animate"),setTimeout(function(){$(".jp4_btn").removeClass("jp4_back"),$(".jp4_btn").text("隐藏式状态灯 >")},1e3)):($(".jp4_mask").addClass("animate"),$(".jp4_lights li").addClass("animate"),setTimeout(function(){$(".jp4_btn").addClass("jp4_back"),$(".jp4_btn").text("显示正常状态 >")},1e3))}):5==a?$(".jp5_left span").each(function(){$(this).animateNumber({number:parseInt($(this).attr("data-id"))},1e3)}):6==a?$(".jp6_pro>div").addClass("animate"):7==a?$(".jp7_item").addClass("animate"):8==a?($(".jp8_item").addClass("animate"),$(".jp8_line").addClass("animate")):9==a&&t()}}),e()});