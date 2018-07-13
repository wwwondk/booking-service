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
    	var ticketArray;
    	
    	function init(tickets){
    		this.tickets = tickets;
    		ticketArray = tickets;
    		bindEvents(this.tickets);
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
        $('button.bk_btn').on('click', checkButton);
        $('#booking_ticket_count').on('change', {tickets:tickets}, changeTotalCount);
	}
	
	function changeTotalCount(e) {
        totalCount = e.data.tickets.reduce((a, v) => a + v.count, 0);
        $('#booking_ticket_count').text(totalCount);
        checkTotalCount();
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

		var obj = {};
		obj.productId=$('.ct').data('product-id');
		
		$.each(ticketArray, function(i, v){
			if(v.priceType === 1){
				obj.generalTicketCount = v.count;
			}else if(v.priceType === 2){
				obj.youthTicketCount = v.count;
			}else if(v.priceType === 3){
				obj.childTicketCount = v.count;
			}
		})
		
		obj.reservationName = $('#name').val();
		obj.reservationEmail = $('#email').val();
		obj.reservationTel = $('#tel').val();
		obj.reservationDate = $('#reservation_date').text();
		obj.reservationType = 1;
		obj.totalPrice=ticketArray.reduce((a, v) => a + parseInt(v.totalPrice), 0);
		
        $.ajax({
            method: 'post',
            data: JSON.stringify(obj),
            contentType: 'application/json;charset=utf-8',
            url: '/appointments',
            success: response => {
                if (response != 0) {
                	alert('예약완료되었습니다.\n예약번호 : '+response);
                    location.href = '/my-reservation';
                } else {
                    alert('오류발생! 잠시 후 다시 예매해주세요.');
                }
            },
            error: (request, status, error) => {
            	alert('오류발생! 잠시 후 다시 예매해주세요.\n'+'error code:' + request.status+'\n message:' + request.responseText +'\n error:' + error);
            }
        });
       
    }
	
	return {
		init : init
	}
	
})();