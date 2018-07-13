$(function(){

	var popup = new Popup('.popup_booking_wrapper');
	
	var cards = [];
	$(".card_item").each(function (i, e) {
		var rid = $(e.currentTarget).data('reservation-id');
		cards.push(new Card('#' + $(e).attr('id'), popup));
	});
	
});