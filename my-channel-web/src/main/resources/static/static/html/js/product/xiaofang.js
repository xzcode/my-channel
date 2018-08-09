function init(){
    var scrollHeight = $(document).scrollTop();
    if (scrollHeight > 0){
      $('.xf_second .xs_item').each(function(){
        $(this).find('.xi_content').addClass('animate');
        $(this).addClass('animate');
      });
    } 
  }
  !(function(){
    var before = $(document).scrollTop();
    init();
    $(window).scroll(function() {
      var scrollHeight = $(document).scrollTop();
      if (scrollHeight > before){
        if (scrollHeight >= 0 && scrollHeight <= 950){
          $('.xf_second .xs_item').each(function(){
            $(this).find('.xi_content').addClass('animate');
            $(this).addClass('animate');
          });
        }else if (scrollHeight >= 2900 && scrollHeight <= 3850){
          $('.xf_fifth .xf_left').addClass('animate');
        } else if (scrollHeight > 3850 && scrollHeight <= 4800){
          $('.xf_sixth .xs_right').addClass('animate');
        } else if (scrollHeight > 4800 && scrollHeight <= 5600){
          $('.xf_fifth .xf_left').removeClass('animate');
        } else {
          $('.xf_sixth .xs_right').removeClass('animate');
        }
      } else {
        if (scrollHeight <= 5600 && scrollHeight >= 4650){
          $('.xf_sixth .xs_right').addClass('animate');
        } else if (scrollHeight < 4650 && scrollHeight >= 3700){
          $('.xf_fifth .xf_left').addClass('animate');
        } else if(scrollHeight < 3700 && scrollHeight >= 2900){
          $('.xf_sixth .xs_right').removeClass('animate');
        } else {
          $('.xf_fifth .xf_left').removeClass('animate');
        }
      }
      before = scrollHeight;
    });
    var slider = new $('.xl_slider ul').slidesjs({
      width: 275,
      height: 490,
      play: {
        active: false,
        auto: true,
        interval: 3000,
        swap: false,
        restartDelay: 1000
      },
      navigation: {
        active: false
      },
      pagination: {
        active: true
      },
      effect: {
        slide: {
          speed: 1000
        }
      },
      callback: {
        complete: function(number) {
          switch(number){
            case 1:
              $('.xl_slider_txt').text('「掌握追剧的正确姿势」');
              $('.slidesjs-previous img').attr('src','//static.orvibo.com/html/images/products/xiaofang/arrow_left_default.png');
              $('.slidesjs-previous').addClass('disabled');
              if ($('.slidesjs-next').hasClass('disabled')){
                $('.slidesjs-next').removeClass('disabled');
                $('.slidesjs-next img').attr('src','//static.orvibo.com/html/images/products/xiaofang/arrow_right_active.png');
              }
              break;
            case 2:
              $('.xl_slider_txt').text('「一键开启家庭影院模式」');
              if ($('.slidesjs-previous').hasClass('disabled')){
                $('.slidesjs-previous').removeClass('disabled');
                $('.slidesjs-previous img').attr('src','//static.orvibo.com/html/images/products/xiaofang/arrow_left_active.png');
              }
              break;
            case 3:
              $('.xl_slider_txt').text('「立即播放所选节目」');
              break;
            case 4:
              $('.xl_slider_txt').text('「分类一览无余」');
              break;
            case 5:
              $('.xl_slider_txt').text('「追剧快人一步」');
              break;
            case 6:
              $('.xl_slider_txt').text('「提醒收看喜爱节目」');
              $('.slidesjs-next img').attr('src','//static.orvibo.com/html/images/products/xiaofang/arrow_right_default.png');
              $('.slidesjs-next').addClass('disabled');
              break;
          }
        }
      }
    });
})(jQuery);