console.log('LOAD DETAIL JS');

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
	
});