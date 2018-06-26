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
        } 
        $('.visual_img').stop().animate({left:-((curImgIndex-1)*imgWidth)+'px'}, 500, function(){
			
			if (curImgIndex === 1) {
				$('.btn_prev').find('.spr_book2').addClass('off');
				
			}
		});

	}
	
	function clickBtnNext(){
		if (curImgIndex < maxImgIndex) {
			curImgIndex++;
			console.log("click NEXT " + curImgIndex);
			$('.btn_prev').find('.spr_book2').removeClass('off');
        } 
		$('.visual_img').stop().animate({right:((curImgIndex-1)*imgWidth)+'px'}, 500, function(){
			
			if (curImgIndex === maxImgIndex) {
				$('.btn_nxt').find('.spr_book2').addClass('off');
				
			}
		});

	}
	
});