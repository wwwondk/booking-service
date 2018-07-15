class Slider {
	constructor(root, btnPrev, btnNext, imgWidth){
		this.root = root;
		this.btnPrev = btnPrev;
		this.btnNext = btnNext;
		this.IMG_WIDTH = imgWidth;
		this.index = 0;
		this.maxIndex = $(root).children().length - 2;
		this.isMoving = false;
		this.bindEvents();
	}
	
	bindEvents(){
		$(this.btnPrev).on('click', this.prev.bind(this));
		$(this.btnNext).on('click', this.next.bind(this));
	}

	prev(){
		if (this.index > 0) {
            this.index--;
        } else if(this.index === 0) {
            this.index = this.maxIndex;
        }
		this.moveImg();
	}
	
	next(){
		if (this.index < this.maxIndex) {
            this.index++;
        } else if(this.index === this.maxIndex) {
            this.index = 0;
        }
		this.moveImg();
	}
	
	moveImg(){
		if(this.isMoving)
			return;
		
		this.isMoving = true;
		$(this.root).animate({left:-(this.index*this.IMG_WIDTH)+'px'}, this.endMove.bind(this));
	}
	
	endMove(){
		this.isMoving = false;
	}
}