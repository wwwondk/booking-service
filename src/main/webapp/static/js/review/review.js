var Review = (function(){
	var header;
	var pid;
	var pname;
	var page;
	var maxPage;
	var source;
	var template;
	var photoViewer;

	function init(header, reviewPanel, reviewCount, source, photoViewer){
		this.header = header;
		this.reviewPanel = reviewPanel;
		this.pid = $(header).find('.title').data('product-id');
		this.pname = $(header).find('.title').text();
		this.page = 0;
		this.maxPage = parseInt((reviewCount%10===0) ? reviewCount/10 : reviewCount/10+1);
		this.source = $(source).html();
		this.template = Handlebars.compile(this.source);
		this.photoViewer = photoViewer;
		bindEvents.apply(this);
	}
	
	function bindEvents(){
		var thumb = this.reviewPanel+' .thumb_area';
		$(document).on('click', thumb, clickPhotoViewer.bind(this));	
	}
	
	function clickPhotoViewer(e){
		var commentId = $(e.currentTarget).data('comment-id');
		var photoViewer = this.photoViewer;
		$.ajax({
			url : '/comments/'+commentId+'/images',
			method : 'GET'
		}).done(function(res){
			photoViewer.setPhotos(res);
		});
	}
	
	function getReviewList(){
		var reviewPanel = this.reviewPanel;
		var template = this.template;
		var pname = this.pname;
		$.ajax({
			url : '/comments',
			method : 'GET',
			data : {'page' : this.page, 'pid' : this.pid}
		}).done(function(res){
			$(reviewPanel).append(template({reviews: res}));
			$(reviewPanel).find('.resoc_name').text(pname);
		});
	}

	return {
		init : init,
		page : page,
		maxPage : maxPage,
		getReviewList : getReviewList
	}
})();