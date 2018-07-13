<!DOCTYPE html>

<script id="review-template" type="text/x-handlebars-template">
{{#reviews}}
	<li class="list_item">
        <div>
            <div class="review_area no_img">
                <h4 class="resoc_name">{{id}}</h4>
                <p class="review">{{comment}}!</p>
            </div>
            <div class="info_area">
                <div class="review_info"> <span class="grade">{{score}}.0</span> <span class="name">{{nickname}}****</span> <span class="date">{{createDate}} 방문</span> </div>
            </div>
        </div>
    </li>
{{/reviews}}
</script>