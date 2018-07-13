
$(function(){
	
	// slider
	var curImgIndex = 1;
	var imgCount = $('.visual_img').children().length;
	var maxImgIndex = imgCount;
	var imgWidth = 414;

	var isMoving = false;
	
	$('.btn_prev').on('click', clickBtnPre);
	$('.btn_nxt').on('click', clickBtnNext);
	
	
	function clickBtnPre(){
		
        if (curImgIndex > 1) {
        	curImgIndex--;
        	$('.btn_nxt').find('.spr_book2').removeClass('off');
        	console.log("click PRE " + curImgIndex);
        	$('.visual_img').stop().animate({left:-((curImgIndex-1)*imgWidth)+'px'}, 500, function(){
        		
        		if (curImgIndex === 1) {
        			$('.btn_prev').find('.spr_book2').addClass('off');
        			
        		}
        	});
        } 

	}
	
	function clickBtnNext(){
		
		if (curImgIndex < maxImgIndex) {
			curImgIndex++;
			console.log("click NEXT " + curImgIndex);
			$('.btn_prev').find('.spr_book2').removeClass('off');
			$('.visual_img').stop().animate({right:((curImgIndex-1)*imgWidth)+'px'}, 500, function(){
				
				if (curImgIndex === maxImgIndex) {
					$('.btn_nxt').find('.spr_book2').addClass('off');
					
				}
			});
        }else{
        	console.log("click NEXT222 " + curImgIndex);
        }

	}
	
	// 상세정보, 오시는길
	$('.info_tab_lst').on('click', 'li', function(e){
		var itemIndex = $(e.currentTarget).index();
		
		if(itemIndex === 0){
			$('.detail_location').addClass('hide');
			$('.detail_area_wrap').removeClass('hide');
			$('._detail .anchor').addClass('active');
			$('._path .anchor').removeClass('active');
		}else if(itemIndex === 1){
			$('.detail_location').removeClass('hide');
			$('.detail_area_wrap').addClass('hide');
			$('._detail .anchor').removeClass('active');
			$('._path .anchor').addClass('active');
		}

	});
	
	// 펼쳐보기
	$('.bk_more').on('click', function(){		
		var isOpend = $('.store_details').hasClass('close3');
		if(isOpend === false){
			$('.store_details').addClass('close3');
			$('._open').css('display', 'none');
			$('._close').css('display', 'block');
		}else{
			$('.store_details').removeClass('close3');
			$('._open').css('display', 'block');
			$('._close').css('display', 'none');
		}
	});
	
	var NaverMap = (function () {
	    var map = new naver.maps.Map('map');
	    var myAddress;
	    var pointX;
	    var pointY;

	    function init() {
	    	myAddress = $('.store_addr.store_addr_bold').text();
	        getPosition();
	    }

	    function getPosition() {
	        naver.maps.Service.geocode({address: myAddress}, setGeocode);
	    }

	    function setGeocode(status, response) {
	        if (status !== naver.maps.Service.Status.OK) {
	            return alert(myAddress + '의 검색 결과가 없습니다.');
	        }
	        var result = response.result;
	        var myaddr = new naver.maps.Point(result.items[0].point.x, result.items[0].point.y);
	        pointX = result.items[0].point.x;
	        pointY = result.items[0].point.y;
	        drawMap();
	    }

	    function drawMap() {
	        var mapSrc = 'https://openapi.naver.com/v1/map/staticmap.bin?clientId=CA09P0ovGU8wMELmLUNF&url=http://localhost&crs=EPSG:4326&center=' + pointX + ',' + pointY + '&level=11&w=300&h=250&baselayer=default&markers=' + pointX + ',' + pointY;
	        $('.store_map').attr('src', mapSrc);

	        var mapUrl = "http://map.naver.com/?lng=" + pointX + "&pinTitle=" + $('.addr_detail').text() + "&level=2&pinType=SITE&lat=" + pointY + "&enc=utf8";
	        $('.store_location').attr('href', mapUrl);
	    }

	    return {
	        init: init
	    }
	})();
	
	NaverMap.init();
	
});