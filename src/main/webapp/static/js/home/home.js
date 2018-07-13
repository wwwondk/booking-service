
$(function(){

	Category.init('ul.event_tab_lst', {'left':'#left_event_box', 'right':'#right_event_box'},'#product-template');
	
	// 스크롤
	$(window).scroll(function(){
		var height = $(document).scrollTop();
		if($(window).scrollTop() === $(document).height() - $(window).height()){
			if(Category.page < Category.maxPage){
				Category.pagePlus();
				Category.getProductList();
			}
		}
	});
	
	var slider = new Slider('.visual_img', '#btn_prev', '#btn_nxt', 338);

	new SliderTimer(slider);
	
});

