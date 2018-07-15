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
		});
	}

	
	$('.thumb_area').on('click', function(){
		console.log('click');
		$('#photoViewer').css('display', 'block');
	});
});