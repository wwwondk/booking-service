<!DOCTYPE html>

<script id="photo-template" type="text/x-handlebars-template">
{{#photos}}
	<li class="item" style="width: 500px;"> 
		<img alt="" class="img_thumb" src="/files/{{this}}"> <span class="img_bg"></span>
	</li>
{{/photos}}
</script>