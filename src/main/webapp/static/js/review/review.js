class Review {
	constructor(header, reviewPanel, reviewCount, source, photoViewer){
		this.header = header;
		this.reviewPanel = reviewPanel;
		this.pid = $(header).find('.title').data('product-id');
		this.pname = $(header).find('.title').text();
		this.page = 0;
		this.maxPage = parseInt((reviewCount%10===0) ? reviewCount/10 : reviewCount/10+1);
		if(source != null){
			this.source = $(source).html();
			this.template = Handlebars.compile(this.source);
		}
		this.photoViewer = photoViewer;
		this.bindEvents();
	}
	
	bindEvents(){
		var thumb = this.reviewPanel+' .thumb_area';
		$(document).on('click', thumb, this.clickPhotoViewer.bind(this));	
	}
	
	clickPhotoViewer(e){
		var commentId = $(e.currentTarget).data('comment-id');
		var pv = this.photoViewer;
		$.ajax({
			url : '/comments/'+commentId+'/images',
			method : 'GET'
		}).done(function(res){
			pv.setPhotos(res);
		});
	}
	
	getReviewList(){
		if(this.source === null)
			return;
		
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
}