<!DOCTYPE html>

<script id="photo-template" type="text/x-handlebars-template">
	{{#photos}}
         <li class="item">
			<a href="#" class="anchor">
				<span class="spr_book ico_del">삭제</span>
			</a>
			<img src="{{filePath}}" name="reviewFile[]" width="130" alt="" class="item_thumb">
			<span class="img_border"></span>
		</li>
	{{/photos}}
</script>