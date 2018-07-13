
$(function(){

	// 카테고리
	var categoryId = 0;
	var page = 0;
	var maxPage = 1; // '전체' 카테고리 탭일 때, 초기화 필요
	
	// 상품리스트
	var source = $('#product-template').html();
	var templete = Handlebars.compile(source);
	
	// 이벤트 바인딩
	$('ul.event_tab_lst').on('click', 'li.item', clickCategory);
	
	function clickCategory(e){
		categoryId = $(e.currentTarget).data('category');
		var categoryCount = $('#cate'+categoryId).val();
		
		$('ul.event_tab_lst li.item a.active').removeClass('active');
		$(e.currentTarget).find('a').addClass('active');
		$('#product_count').text(categoryCount+'개');
		
		maxPage = (categoryCount%10 === 0) ? categoryCount%10 : categoryCount%10+1;
		
		// 새 카레고리에 관련 초기화
		page = 0;
		$("#left_event_box").empty();
		$("#right_event_box").empty();
		getProductList();
	}
	
	// 상품리스트 가져오기
	function getProductList(){
		$.ajax({
			url : '/categories/'+categoryId+'/products',
			method : 'GET',
			data : {'page' : page}
		}).done(function(res){

			var leftItemList = [];
			var rightItemList = [];
			
			for (var i = 0, l = res.length; i < l; i++) {
	            if (i % 2) {
	            	rightItemList.push(res[i]);
	            } else {
	            	leftItemList.push(res[i]);
	            }
	        }

			$("#left_event_box").append(templete({products: leftItemList}));
			$("#right_event_box").append(templete({products: rightItemList}));
		});
	}
	
	// 스크롤
	$(window).scroll(function(){
		var height = $(document).scrollTop();
		if($(window).scrollTop() === $(document).height() - $(window).height()){
			if(page < maxPage){
				page++;
				getProductList();
			}
		}
	});
	
	// slider
	class Slider {
		constructor(root, btnPrev, btnNext, imgWidth){
			this.root = root;
			this.btnPrev = btnPrev;
			this.btnNext = btnNext;
			this.IMG_WIDTH = imgWidth;
			this.index = 0;
			this.maxIndex = $(root).children().length - 2;
			this.isMoving = false;
			this.bindEvents();
		}
		
		bindEvents(){
			$(this.btnPrev).on('click', this.prev.bind(this));
			$(this.btnNext).on('click', this.next.bind(this));
		}
		
		prev(){
			if (this.index > 0) {
	            this.index--;
	        } else if(this.index === 0) {
	            this.index = this.maxIndex;
	        }
			this.moveImg();
		}
		
		next(){
			if (this.index < this.maxIndex) {
	            this.index++;
	        } else if(this.index === this.maxIndex) {
	            this.index = 0;
	        }
			this.moveImg();
		}
		
		moveImg(){
			if(this.isMoving)
				return;
			
			this.isMoving = true;
			$(this.root).animate({left:-(this.index*this.IMG_WIDTH)+'px'}, this.endMove.bind(this));
		}
		
		endMove(){
			this.isMoving = false;
		}
	}
	
	var slider = new Slider('.visual_img', '#btn_prev', '#btn_nxt', 338);

	class SlideTimer {
	    constructor(slider) {
	        this.slider = slider;
	        this.interval;
	        this.timeout;
	        this.startTimer();
	        this.bindEvents();
	    }

	    bindEvents() {
	        $(window).on('blur', this.pauseTimer.bind(this))
	            	 .on('focus', this.startTimer.bind(this));
	    }

	    pauseTimer() {
	        clearTimeout(this.timeout);
	        clearInterval(this.interval);
	    }

	    startTimer() {
	        this.interval = setInterval(this.slider.next.bind(this.slider), 2000);
	    }

	    resetTimer() {
	        this.timeout = setTimeout(this.startTimer.bind(this), 2000);
	    }

	    clearAndResetTimer() {
	        this.pauseTimer();
	        this.resetTimer();
	    }
	};
	
	new SlideTimer(slider);
	
});

