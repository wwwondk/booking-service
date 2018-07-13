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