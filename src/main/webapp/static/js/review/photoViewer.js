class PhotoViewer {
		constructor(root, imgRoot, btnPrev, btnNext, imgWidth, pagination,  btnClose, photoTemplate){
			this.root = root;
			this.imgRoot = imgRoot;
			this.pagination = pagination;
			this.btnPrev = btnPrev;
			this.btnNext = btnNext;
			this.btnClose = btnClose;
			this.IMG_WIDTH = imgWidth;
			this.index = 0;
			this.maxIndex = $(root).find(imgRoot).children().length-1;
			$(root).find(this.pagination).find('.total_count').text(this.maxIndex+1);
			this.photoTemplate = photoTemplate;
			this.bindEvents();
		}
		
		bindEvents(){
			$(this.root).find(this.btnPrev).on('click', this.prev.bind(this));
			$(this.root).find(this.btnNext).on('click', this.next.bind(this));
			if(this.btnClose != null)
				$(this.btnClose).on('click', this.close.bind(this));
		}
		
		prev(){
			if (this.index > 0) {
				this.index--;
	        	$(this.btnNext).find('.spr_book2').removeClass('off');        	
	        	$(this.root).find(this.pagination).find('.page_index').text(this.index+1);
	        	$(this.root).find(this.imgRoot).animate({left:(-(this.index)*this.IMG_WIDTH)+'px'}, 500);
	        	if (this.index === 0) {
        			$(this.btnPrev).find('.spr_book2').addClass('off');
        		}

	        } 
		}
		
		next(){
			if (this.index < this.maxIndex) {
				this.index++;
				$(this.root).find(this.pagination).find('.page_index').text(this.index+1);
				$(this.btnPrev).find('.spr_book2').removeClass('off');
				$(this.root).find(this.imgRoot).animate({left:(-(this.index)*this.IMG_WIDTH)+'px'}, 500);
				if (this.index === this.maxIndex){
					$(this.btnNext).find('.spr_book2').addClass('off');
				}

	        }
			
		}
		
		setPhotos(list){
			this.index = 0;
			this.maxIndex = list.length-1;
			
			$(this.root).find(this.pagination).find('.page_index').text(this.index+1);
			$(this.root).find(this.pagination).find('.total_count').text(this.maxIndex+1);
			$(this.root).find(this.imgRoot).empty();
			$(this.root).find(this.imgRoot).append(this.photoTemplate({photos: list}));
			$(this.root).find(this.imgRoot).animate({left:'0px'}, 0);
			console.log(this.index + " / "+this.maxIndex);
			this.open();
		}
		
		open(){
			$(this.root).css('display', 'block');
		}
		
		close(){
			$(this.root).css('display', 'none');
		}
	}