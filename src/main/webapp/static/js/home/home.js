
$(function(){
	console.log('load home.js');

	// 카테고리
	var categoryId = 0;
	var page = 0;
	
	$('ul.event_tab_lst').on('click', 'li.item', clickCategory);
	
	function clickCategory(e){
		categoryId = $(e.currentTarget).data('category');
		console.log('click category '+ categoryId );
		var categoryCount = $('#cate'+categoryId).val();
		
		$('ul.event_tab_lst li.item a.active').removeClass('active');
		$(e.currentTarget).find('a').addClass('active');
		$('#product_count').text(categoryCount+'개');
		getProductList();
	}
	
	// 상품리스트 가져오기
	function getProductList(){
		page = 0;
		$.ajax({
			url : '/categories/'+categoryId+'/products',
			method : 'GET',
			data : {'page' : page}
		}).done(function(res){

			var source = $('#product-template').html();
			var templete = Handlebars.compile(source);
			
			var leftItemList = [];
			var rightItemList = [];
			
			$("#left_event_box").empty();
			$("#right_event_box").empty();
			
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
	
})

