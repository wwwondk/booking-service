var Category = (function(){
	var categoryId;
	var page;
	var maxPage;
	var categoryTab;
	var box = {};
	var source;
	var templete;
	
	function init(categoryTab, box, source){
		this.categoryId = 0;
		this.page = 0;
		var categoryCount = $('#cate'+this.categoryId).val();
		this.maxPage = (categoryCount%10 === 0) ? categoryCount/10 : categoryCount/10+1;
		
		this.categoryTab = categoryTab;
		this.box = box;
		this.source = $(source).html();
		this.templete = Handlebars.compile(this.source);
		
		bindEvents.apply(this);
		setLazyLoad.apply(this);
	}
	
	function bindEvents(){
		$(this.categoryTab).on('click', 'li.item', clickCategory.bind(this));
		$(this.box).on('change', setLazyLoad.bind(this));
	}
	
	function clickCategory(e){
		this.categoryId = $(e.currentTarget).data('category');
		var categoryCount = $('#cate'+this.categoryId).val();
		$(this.categoryTab).find('a.active').removeClass('active');
		$(e.currentTarget).find('a').addClass('active');
		$('#product_count').text(categoryCount+'개');
		
		this.maxPage = (categoryCount%10 === 0) ? categoryCount/10 : categoryCount/10+1;
		// 새 카레고리에 관련 초기화
		this.page = 0;
		$(this.box.left).empty();
		$(this.box.right).empty();
		getProductList.call(this);
	}
	
	
	// 상품리스트 가져오기
	function getProductList(){
		var templete = this.templete;
		var box = $(this.box);
		var leftBox = $(this.box.left);
		var rightBox = $(this.box.right);
		
		$.ajax({
			url : '/categories/'+this.categoryId+'/products',
			method : 'GET',
			data : {'page' : this.page}
		}).done(function(res, callback){

			var leftItemList = [];
			var rightItemList = [];
			for (var i = 0, l = res.length; i < l; i++) {
	            if (i % 2) {
	            	rightItemList.push(res[i]);
	            } else {
	            	leftItemList.push(res[i]);
	            }
	        }
			$(leftBox).append(templete({products: leftItemList}));
			$(rightBox).append(templete({products: rightItemList}));
			$(box).trigger('change');
		});

	}
	
	function pagePlus(){
		this.page++;
	}
	
	function setLazyLoad(){

		$.each(this.box, function(i, v){
			$(v).find('.lazy').lazyload({
				threshold:199
			});
		});

	}

	return {
		init : init,
		page : this.page,
		maxPage : this.maxPage,
		pagePlus : pagePlus,
		getProductList : getProductList
	}
})();