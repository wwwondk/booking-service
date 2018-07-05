$(function(){
	
	// 별점
	var starPoint = 0;
	var starIndex = 0;
	var preIndex = 0;
	$('.rating .rating_rdo').on('click', function(e){
		preIndex = starIndex;
		starIndex = $(e.currentTarget).val();
		
		var isChecked = $(e.currentTarget).prop('checked');

		if(starIndex === '1' && isChecked === false && preIndex === starIndex){
			$('.rating_rdo').prop('checked', false);
			starIndex--;
			$('.star_rank ').text(starIndex);
			return;
		}
		
		for(var i = 1; i <= 5; i++){	
			if(i <= starIndex){
				$('.rating_rdo[name=rating'+i+']').prop('checked', true);
			}else{
				$('.rating_rdo[name=rating'+i+']').prop('checked', false);
			}
		}
		
		$('.star_rank ').text(starIndex);
	
	});
	
	
	// 리뷰폼
	var limitTextLength = 400;
	$('.review_write_info').on('click', function(){
		$('.review_write_info').css('display', 'none');
		$('.review_textarea').focus();
	});
	
	$('.review_textarea').on('keyup', function(){
		var len = $('.review_textarea').val().length;
		if(len > limitTextLength){
			alert(limitTextLength+' 자를 넘을 수 없습니다.');
			$('.review_textarea').val($('.review_textarea').val().substr(0, limitTextLength));
			len = limitTextLength;
		}
		$('.guide_review_len').text(len);
	});
	
	// 포토
	$('ul.lst_thumb').on('click', '.anchor', function(e){
		var photoItem = $(e.currentTarget).parent();
		$(e.currentTarget).parent().remove();
	});
	
	var file = $('#reviewImageFileOpenInput');
	
	var source = $('#photo-template').html();
	var template = Handlebars.compile(source);
	
	var tempFileList = [];
	
	file.on('change', function(){
		var fileList = file.prop('files');
		var fileArray = Array.prototype.slice.call(fileList);
		var fileIndex = 0;
		
		fileArray.forEach(function(f){
			if(!f.type.match('image.*')){
				alert('이미지 파일만 업로드 가능합니다.');
				return;
			}
			tempFileList.push(f);
			var reader = new FileReader();
			reader.readAsDataURL(f);
			reader.onload = function(){
				var Photo = {'filePath' : reader.result}
				$(".lst_thumb").append(template({photos: Photo}));
				fileIndex++;
			}
		});
		
	});
	
	// 리뷰 등록 버튼
	$('#reviewForm').on('submit', function(e){
		e.preventDefault();

		var formData = new FormData();
		formData.append('starPoint', starIndex);
		formData.append('comment', $('.review_textarea').val());

		$($("#reviewImageFileOpenInput")[0].files).each(function(index, f) {
			formData.append("reviewFile", f);
		});

		var reqObject = new XMLHttpRequest();
		reqObject.open('post', '/comments', true);
		reqObject.send(formData);
		
	});
	
});