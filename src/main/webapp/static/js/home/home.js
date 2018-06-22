
$(function(){

	// 카테고리
	var categoryId = 0;
	var page = 0;
	var maxPage = 1;
	
	// 상품리스트
	var source = $('#product-template').html();
	var templete = Handlebars.compile(source);
	
	// 이벤트 바인딩
	$('ul.event_tab_lst').on('click', 'li.item', clickCategory);
	
	function clickCategory(e){
		categoryId = $(e.currentTarget).data('category');
		console.log('click category '+ categoryId );
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
	
});

