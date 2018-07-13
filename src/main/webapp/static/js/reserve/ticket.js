class Ticket {
		constructor(id){
			this.id = id;
			this.count = 0;
			this.priceType = $(id).data('price-type');
		this.btnMinus = $(id).find('.ico_minus3');
		this.btnPlus = $(id).find('.ico_plus3');
		this.countInput = $(id).find('.count_control_input');
		this.priceInput = $(id).find('.total_price');
		this.price = parseInt($(id).find('.price').text().replace(',', ''));
		this.totalPrice = 0;
		this.bindEvents();
	}
	bindEvents(){
		this.btnMinus.on('click', this.clickMinus.bind(this));
		this.btnPlus.on('click', this.clickPlus.bind(this));
	}
	clickPlus(){
		this.count++;
		this.changeCountInput();
		this.changePrice();
		if(this.count > 0){
			$(this.id).find('.individual_price').addClass('on_color');
			this.btnMinus.removeClass('disabled');
			this.countInput.removeClass('disabled');
		}
		$('#booking_ticket_count').trigger('change');
	}
	clickMinus(){
		if(this.count <= 0)
			return;
		this.count--;
		this.changeCountInput();
		this.changePrice();
		if(this.count <= 0){
			$(this.id).find('.individual_price').removeClass('on_color');
			this.btnMinus.addClass('disabled');
			this.countInput.addClass('disabled');
		}
		$('#booking_ticket_count').trigger('change');
	}
	changeCountInput(){
		this.countInput.val(this.count);
	}
	changePrice(){
		var p = this.price * this.count;
		this.totalPrice = p;
		// 3자리마다 콤마찍기
		p = p.toString().replace(/(\d)(?=(?:\d{3})+(?!\d))/g,'$1,');
		this.priceInput.text(p);
	}
}