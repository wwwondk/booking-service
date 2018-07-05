console.log('myreservation load js');

$(function(){
	$('.card_body').on('click', '.btn', function(e){
		
		var reservationId = $(e.currentTarget).parent().data('reservation-id');
		var productId = $(e.currentTarget).parent().data('product-id');
		var productName = $(e.currentTarget).parent().data('product-name');

		window.location.href='/reviews/write?rid='+reservationId+'&pid='+productId+'&pname='+productName;
	});
});