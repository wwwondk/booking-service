var NaverMap = (function () {
	    var map = new naver.maps.Map('map');
    var myAddress;
    var pointX;
    var pointY;

    function init() {
    	myAddress = $('.store_addr.store_addr_bold').text();
        getPosition();
    }

    function getPosition() {
        naver.maps.Service.geocode({address: myAddress}, setGeocode);
    }

    function setGeocode(status, response) {
        if (status !== naver.maps.Service.Status.OK) {
        	console.log(myAddress + '의 검색 결과가 없습니다.');
            return;
        }
        var result = response.result;
        var myaddr = new naver.maps.Point(result.items[0].point.x, result.items[0].point.y);
        pointX = result.items[0].point.x;
        pointY = result.items[0].point.y;
        drawMap();
    }

    function drawMap() {
    	var mapSrc = '';
    	$.ajax({
			url : '/files/maps',
			method : 'GET',
			data : {'pointX' : pointX, 'pointY' : pointY}
		}).done(function(res){
			$('.store_map').attr('src', res);
		});

        var mapUrl = "http://map.naver.com/?lng=" + pointX + "&pinTitle=" + $('.addr_detail').text() + "&level=2&pinType=SITE&lat=" + pointY + "&enc=utf8";
        $('.store_location').attr('href', mapUrl);
    }

    return {
        init: init
    }
})();