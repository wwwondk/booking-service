$(function(){
	
	$('.header').attr('display', 'none');
	$('a.btn_back').on('click', () => history.back());
	
	var tickets = [];
    $(".qty").each(function (i, e) {
        tickets.push(new Ticket('#' + $(e).attr('id')));
    });
     
    Reserver.init(tickets);
	
});

