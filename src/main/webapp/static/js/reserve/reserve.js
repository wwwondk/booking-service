console.log('RESERVE JS');

$(function(){
	
	$('.header').attr('display', 'none');
	
	//var ticket = $('.qty');
	//console.log(ticket);
	function Ticket(){
		var count;
		function init(){
			this.count = 0;
			bindEvents();
			console.log(this);
		}
		function bindEvents(){
			$('.ico_minus3').on('click', minus);
		}
		function plus(){
			console.log('plus!');
			return ++count;
		}
		function minus(){
			console.log('minus!');
			return --count;
		}
		return {
			init : init
		}
	}
	
	
	var tickets = [];
    $(".qty").each(function (i, e) {
    	var v = new Ticket('#' + $(e).attr('id'));
        tickets.push(v);
        v.init();
    });
	
});

