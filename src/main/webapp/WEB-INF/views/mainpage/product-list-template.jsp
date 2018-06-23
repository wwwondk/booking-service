<!DOCTYPE html>

<script id="product-template" type="text/x-handlebars-template">
	{{#products}}
         <li class="item">
             <a href="/product-detail/{{productId}}" class="item_book">
                 <div class="item_preview"> 
                 	<img alt="{{name}}" class="img_thumb" src="{{saveFileName}}">
                 	<span class="img_border"></span> 
                 </div>
                 <div class="event_txt">
                     <h4 class="event_txt_tit"> 
                     	<span>{{productName}}</span> 
                     	<small class="sm">{{placeName}}</small> 
                     </h4>
                     <p class="event_txt_dsc">{{productDescription}}</p>
                 </div>
             </a>
         </li>
	{{/products}}
</script>