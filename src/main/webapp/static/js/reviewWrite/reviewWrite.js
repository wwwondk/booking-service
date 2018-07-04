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
	//$('.box_bk_btn').on('click', function(e){
	$('#reviewForm').on('submit', function(e){
		e.preventDefault();
		console.log('리뷰클릭!');
		console.log($('#reviewForm').serializeArray());
//		var review = new Object();
//		review.starPoint = starIndex;
//		review.comment = $('.review_textarea').val();
//		review.files = tempFileList;
		//var formData = new FormData($('#reviewForm'));
		//formData.append('starPoint', starIndex);
		//formData.append('comment', $('.review_textarea').val());
		//formData.append('starPoint', 3);
		//formData.append('comment', 'abced');
		//formData.append('fi', tempFileList);
		//formData.append('files', review.files);
		

		var formData = new FormData();
		formData.append('starPoint', 3);
		formData.append('comment', 'abced');


		//formData.append("files", $("#soloFile")[0].files[0]); // 파일 한개

		// file multiple 전송시 다음과 같이 반복문으로 추가한다. //파일 여러개

		$($("#reviewImageFileOpenInput")[0].files).each(function(index, f) {

			formData.append("multi_file[]", f);

		});



		
		
		var reqObject = new XMLHttpRequest();
		reqObject.open('post', '/comments', true);
		reqObject.send(formData);
		console.log(formData);
	});
	
});