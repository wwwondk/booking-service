$(function(){

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

	class Popup {
		constructor(root){
			this.root = root;
			this.rid = 0;
			this.popupBtnYes = $(root).find('.btn_green');
			this.popupBtnNo = $(root).find('.btn_gray');
			this.popupBtnClose = $(root).find('.popup_btn_close');
			this.title = $(root).find('.pop_tit span');
			this.date = $(root).find('.sm');
			this.bindEvents();
		}
		
		bindEvents(){
			this.popupBtnYes.on('click', this.clickPopUpBtnYes.bind(this));
			this.popupBtnNo.on('click', this.closePopUp.bind(this));
			this.popupBtnClose.on('click', this.closePopUp.bind(this));
		}
		
		clickPopUpBtnYes(){
			var id = this.rid;
			$.ajax({
				method:'delete',
				url :'/appointments/'+id,
				success : function(res){
					alert('예약번호 \''+id+'\' 취소 되었습니다.');
					location.href = '/my-reservation';
				}
			});
		}
		
		openPopup(rid, title, date){		
			this.rid = rid;
			$(this.title).text(title);
			$(this.date).text(date);
			$(this.root).css('display', 'block');
		}
		
		closePopUp(){
			$(this.root).css('display', 'none');
		}
	}
	
	var popup = new Popup('.popup_booking_wrapper');
	
	var cards = [];
	$(".card_item").each(function (i, e) {
		var rid = $(e.currentTarget).data('reservation-id');
		cards.push(new Card('#' + $(e).attr('id'), popup));
	});
	
});