$(function(){
	
	var pid = $('.review_header').find('.title').data('product-id');
	var pname = $('.review_header').find('.title').text();
	
	var page = 0;
	var reviewCount = $('.join_count .green').data('review-count');
	var maxPage = parseInt((reviewCount%10===0) ? reviewCount/10 : reviewCount/10+1);
	
	$(window).scroll(function(){
		var height = $(document).scrollTop();
		if($(window).scrollTop() === $(document).height() - $(window).height()){
			if(page < maxPage){
				page++;
				getReviewList();
			}
		}
	});
	
	var source = $('#review-template').html();
	var template = Handlebars.compile(source);
	
	function getReviewList(){
		$.ajax({
			url : '/comments',
			method : 'GET',
			data : {'page' : page, 'pid' : pid}
		}).done(function(res){
			$('.list_short_review').append(template({reviews: res}));
			$('.resoc_name').text(pname);
			console.log('A');
		});
	}

	Handlebars.registerHelper('isThumbnail', function(options) {
	  if (this.thumbnailFileId != 0) {
	    return options.fn(this);
	  } else {
	    return options.inverse(this);
	  }
	});	
	

	var photoViewer = new PhotoViewer('#photoViewer', '.visual_img', '.prev_inn', '.nxt_inn', 500, '.pagination', '.popup_btn_close');
	var photoSource = $('#photo-template').html();
	var photoTemplate = Handlebars.compile(photoSource);
	
	$(document).on('click', '.thumb_area', function(e){
		console.log('B');
		console.log($(e.currentTarget));
		var commentId = $(e.currentTarget).data('comment-id');
		console.log('commentId '+commentId);
		
		$.ajax({
			url : '/comments/'+commentId+'/images',
			method : 'GET'
		}).done(function(res){
			photoViewer.setPhotos(res, photoTemplate);
		});

	});
	
});