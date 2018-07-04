$(function(){
	
	// 별점
	var starPoint = 0;
	var starIndex = 0;
	var preIndex = 0;
	$('.rating .rating_rdo').on('click', function(e){
		preIndex = starIndex;
		starIndex = $(e.currentTarget).val();
		
		var isChecked = $(e.currentTarget).prop('checked');

		if(starIndex === '1' && isChecked === false && preIndex === starIndex){
			$('.rating_rdo').prop('checked', false);
			starIndex--;
			$('.star_rank ').text(starIndex);
			return;
		}
		
		for(var i = 1; i <= 5; i++){	
			if(i <= starIndex){
				$('.rating_rdo[name=rating'+i+']').prop('checked', true);
			}else{
				$('.rating_rdo[name=rating'+i+']').prop('checked', false);
			}
		}
		
		$('.star_rank ').text(starIndex);
	
	});
});