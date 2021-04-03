'use strict';

$('.main_img').slick({
	infinite: true, 			//무한 반복옵션
	autoplay : true,			// 자동 스크롤 사용 여부
	speed:1000,
	autoplaySpeed : 5000, 		// 자동 스크롤 시 다음으로 넘어가는데 걸리는 시간 (ms)
	 pauseOnHover : true,		// 슬라이드 이동	시 마우스 호버하면 슬라이더 멈추게 설정
	draggable :false

});
      
  $('.goods-list ').slick({
      dots: false,
      
      infinite: false,
      slidesToShow: 4,
      slidesToScroll: 4,
	  speed : 1000,
	responsive: [
	    {
	      breakpoint: 1400,
	      settings: {
	        slidesToShow: 3,
	        slidesToScroll: 3,
	        infinite: false,
	        dots: false
	      }
	    },
	    {
	      breakpoint: 990,
	      settings: {
	        slidesToShow: 2,
	        slidesToScroll: 2
	      }
	    },
	    {
	      breakpoint: 480,
	      settings: {
	        slidesToShow: 1,
	        slidesToScroll: 1
	      }
	    }
	  ]
	});

  $('.evt-goods').slick({
  	  
	  dots: false,
	  infinite: false,
	  slidesToShow: 5,
	  slidesToScroll: 5,
	  speed : 1000,
responsive: [
	    {
	      breakpoint: 987,
	      settings: {
		 	
	        slidesToShow: 4,
	        slidesToScroll: 4,
	        infinite: false,
	        dots: false,
			
	      }
	    }
	  
	    
	  ]

  	});