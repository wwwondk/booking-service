
$(function(){
	
	var titlePhotoViewer = new PhotoViewer('.main', '.visual_img', '.btn_prev', '.btn_nxt', 414, '.pagination', null, null);
	

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
	
	NaverMap.init();
	
	var photoSource = $('#photo-template').html();
	var photoTemplate = Handlebars.compile(photoSource);
	var reviewPhotoViewer = new PhotoViewer('#photoViewer', '.visual_img', '.prev_inn', '.nxt_inn', 500, '.pagination', '.popup_btn_close', photoTemplate);


	new Review('.review_area', '.list_short_review', $('.join_count .green').data('review-count'), null, reviewPhotoViewer);
	
});