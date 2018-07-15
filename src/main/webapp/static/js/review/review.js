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

		
	
	class PhotoViewer {
		constructor(root,imgRoot, btnPrev, btnNext, imgWidth, pagination,  btnClose){
			this.root = root;
			this.imgRoot = imgRoot;
			this.pagination = pagination;
			this.btnPrev = btnPrev;
			this.btnNext = btnNext;
			this.btnClose = btnClose;
			this.IMG_WIDTH = imgWidth;
			this.index = 0;
			this.maxIndex = $(imgRoot).children().length;
			$(this.pagination).find('.total_count').text(this.maxIndex);
			this.bindEvents();
		}
		
		bindEvents(){
			$(this.btnPrev).on('click', this.prev.bind(this));
			$(this.btnNext).on('click', this.next.bind(this));
			if(this.btnClose != null)
				$(this.btnClose).on('click', this.close.bind(this));
		}
		
		prev(){
			if (this.index > 0) {
				this.index--;
	        	$(this.btnNext).find('.spr_book2').removeClass('off');
	        	
	        	$(this.pagination).find('.page_index').text(this.index+1);

	        	$(this.imgRoot).animate({left:(-(this.index)*this.IMG_WIDTH)+'px'}, 500);
	        	if (this.index === 0) {
        			$(this.btnPrev).find('.spr_book2').addClass('off');
        		}

	        } 
		}
		
		next(){
			if (this.index < this.maxIndex-1) {
				this.index++;
				console.log("click NEXT " + this.index);
				$(this.pagination).find('.page_index').text(this.index+1);
				$(this.btnPrev).find('.spr_book2').removeClass('off');
				$(this.imgRoot).animate({left:(-(this.index)*this.IMG_WIDTH)+'px'}, 500);
				if (this.index === this.maxIndex){
					$(this.btnNext).find('.spr_book2').addClass('off');
				}

	        }
			
		}
		
		open(){
			$(this.root).css('display', 'block');
		}
		
		close(){
			$(this.root).css('display', 'none');
		}
	}
	
	var photoViewer = new PhotoViewer('#photoViewer', '.visual_img', '.prev_inn', '.nxt_inn', 500, '.pagination', '.popup_btn_close');
	$('.thumb_area').on('click', function(){
		photoViewer.open();
	});
	
});