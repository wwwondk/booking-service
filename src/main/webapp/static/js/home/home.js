
$(function(){
	console.log('load home.js');

	// 카테고리
	var categoryId = 0;
	$('ul.event_tab_lst').on('click', 'li.item', clickCategory);
	
	function clickCategory(e){
		categoryId = $(e.currentTarget).data('category');
		console.log('click category '+ categoryId );
		var categoryCount = $('#cate'+categoryId).val();
		
		$('ul.event_tab_lst li.item a.active').removeClass('active');
		$(e.currentTarget).find('a').addClass('active');
		$('#product_count').text(categoryCount+'개');
	}
})

