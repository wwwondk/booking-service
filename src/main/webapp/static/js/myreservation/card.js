class Card {
	constructor(root, popup){
		this.root = root;
		this.rid = $(root).find('.booking_cancel').data('reservation-id');
		this.title = $(root).find('.tit').text();
		this.date = $(root).find('.item_reservation_date').text();
		this.bookingCancelUsed = $(root).find('.booking_cancel');
		this.popup = popup;
		this.bindEvents();
	}
	
	bindEvents(){
		if(this.bookingCancelUsed.hasClass('used')){
			this.bookingCancelUsed.on('click', this.writeReview.bind(this));
		}else if(this.bookingCancelUsed.hasClass('cancel')){
			this.bookingCancelUsed.on('click', this.popupCancel.bind(this));
		}
	}
	
	writeReview(e){
		var productId = $(e.currentTarget).data('product-id');
		window.location.href='/reviews/write?rid='+this.rid+'&pid='+productId+'&pname='+this.title;
	}
	
	popupCancel(){
		this.popup.openPopup(this.rid, this.title, this.date);
	}
	
}