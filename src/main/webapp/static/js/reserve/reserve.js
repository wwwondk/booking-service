console.log('RESERVE JS');

$(function(){
	
	$('.header').attr('display', 'none');
	$('a.btn_back').on('click', () => history.back());

	class Ticket {
		constructor(id){
			this.id = id;
			this.count = 0;
			this.btnMinus = $(id).find('.ico_minus3');
			this.btnPlus = $(id).find('.ico_plus3');
			this.countInput = $(id).find('.count_control_input');
			this.priceInput = $(id).find('.total_price');
			this.price = parseInt($(id).find('.price').text().replace(',', ''));

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
		}
		changeCountInput(){
			this.countInput.val(this.count);
		}
		changePrice(){
			var p = this.price * this.count;
			// 3자리마다 콤마찍기
			p = p.toString().replace(/(\d)(?=(?:\d{3})+(?!\d))/g,'$1,');
			this.priceInput.text(p);
		}
	}
	
	var tickets = [];
    $(".qty").each(function (i, e) {
        tickets.push(new Ticket('#' + $(e).attr('id')));
    });
    
    
    var Reserver = (function(){
    	var validation = {
    		name : false,
    		email : false,
    		tel : false,
    		agreement : false,
    		totalCount : false
    	};
    	var totalCount = 0;
    	var tickets;
    	
    	function init(tickets){
    		this.tickets = tickets;
    		bindEvents(tickets);
            checkName.apply($('#name').get(0));
            checkTel.apply($('#tel').get(0));
            checkEmail.apply($('#email').get(0));
            checkAgreement.apply($('#agreement').get(0));
    	}
    	
    	function bindEvents(tickets){
    		$('#name').on('keyup', checkName);
    	    $('#tel').on('keyup', checkTel);
    	    $('#email').on('keyup', checkEmail);
    	    $('#checkagree').on('click', checkAgreement);
            $('a.btn_agreement').on('click', toggleOpen);
            $('button.bk_btn').on('click', checkButton)
            $('.count_control_input').on('change', changeTotalCount); 
    	    //$(tickets).each((i, v) => v.on('change', changeTotalCount)); 
    	}
    	
    	function changeTotalCount() {
    		console.log('1');
	        totalCount = ticketArray.reduce((a, v) => a + v.count, 0);
	        $('#booking_ticket_count').text(totalCount);
	        totalCountCheck();
	    }
    	
    	function toggleOpen() {
	        $(this).find('i').toggleClass('fn-up2 fn-down2');
	        $(this).closest('div.agreement').toggleClass('open');
	    }
    	
    	function checkName(){
    		if($(this).val()) {
                validation['name'] = true;
            }else{
                validation['name'] = false;
            }
    		checkAll();
    	}
    	
    	function checkTel(){
            var regNum = /^[0-9]+$/;
            var regDash = /[\-]/gi;
            var regTelNum = /(^02.{0}|^01.{1}|[0-9]{3})([0-9]+)([0-9]{4})/;
            var regTel = /^\d{2,3}-\d{3,4}-\d{4}$/;
            var num = $(this).val();
            if (!regNum.test(num)) {
                num = num.replace(regDash, '');
            }
            num = num.replace(regTelNum, "$1-$2-$3");
            $(this).val(num);
            validation['tel'] = regTel.test($(this).val());
            checkAll();
    	}
    	
    	function checkEmail(){
    		 var reg = /^[\w]([-_\.]?[\w])*@[\w]([-_\.]?[\w])*\.[a-zA-Z]{2,3}$/i;
    	     validation['email'] = reg.test($(this).val());
    	     checkAll();
    	}
    	
    	function checkAgreement(){
            validation['agreement'] = $(this).prop('checked');
            checkAll();
    	}
    	
    	function checkTotalCount(){
    		 validation['totalCount'] = parseInt($('#total_count').text()) !== 0;
    		 checkAll();
    	}
    	
    	function checkAll() {
            if (validation['agreement'] && validation['email'] && validation['tel'] && validation['name'] && validation['totalCount']) {
                $('div.bk_btn_wrap').removeClass('disable');
            } else {
                $('div.bk_btn_wrap').addClass('disable');
            }
        }
    	
    	function checkButton() {
            if ($('div.bk_btn_wrap').hasClass('disable')) {
                return;
            } else {
                makeReservation();
            }
        }
    	
    	function makeReservation() {
            var obj = {
                productId: $('.ct').data('product-id'),
                generalTicketCount: ticketArray[0].count,
                youthTicketCount: ticketArray[1].count,
                childTicketCount: ticketArray[2].count,
                reservationName: $('#name').val(),
                reservationEmail: $('#email').val(),
                reservationTel: $('#tel').val(),
                reservationDate: $('#reservation_date').text(),
                reservationType: 1,
                totalPrice: ticketArray.reduce((a, v) => a + parseInt(v.totalPrice), 0)
            };
            /*
            $.ajax({
                method: 'post',
                data: JSON.stringify(obj),
                contentType: 'application/json; charset=utf-8',
                url: '/api/booking',
                success: response => {
                    if (response === 1) {
                        location.href = '/my-reservation';
                    } else {
                        alert('뭔가 잘못되었습니다. ^^;');
                    }
                },
                error: (request, status, error) => {
                    console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
                }
            });
            */
        }
    	
    	return {
    		init : init
    	}
    	
    })();
    
    Reserver.init(tickets);
	
});

