$(function(){
	
	var photoSource = $('#photo-template').html();
	var photoTemplate = Handlebars.compile(photoSource);
	var photoViewer = new PhotoViewer('#photoViewer', '.visual_img', '.prev_inn', '.nxt_inn', 500, '.pagination', '.popup_btn_close', photoTemplate);
	Handlebars.registerHelper('isThumbnail', function(options) {
		if (this.thumbnailFileId != 0) {
			return options.fn(this);
		} else {
			return options.inverse(this);
		}
	});	
	
	var review = new Review('.review_header', '.list_short_review', $('.join_count .green').data('review-count'), '#review-template', photoViewer);
	
	$(window).scroll(function(){
		var height = $(document).scrollTop();
		if($(window).scrollTop() === $(document).height() - $(window).height()){
			if(review.page < review.maxPage){
				review.page++;
				review.getReviewList();
			}
		}
	});
	
});