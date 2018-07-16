<!DOCTYPE html>

<script id="review-template" type="text/x-handlebars-template">
{{#reviews}}
	<li class="list_item">
        <div>
			{{#isThumbnail}}
            <div class="review_area">
               	<div class="thumb_area" data-comment-id="{{id}}">
                   <a class="thumb" title="이미지 크게 보기"> <img width="90" height="90" class="img_vertical_top" src="/files/{{thumbnailFileId}}" alt="리뷰이미지"> </a> <span class="img_count">{{thumbnailCount }}</span>
                </div>

               	<h4 class="resoc_name">{{id}}</h4>
               	<p class="review">{{comment}}</p>
            </div>
			{{else}}
			<div class="review_area no_img">
                <h4 class="resoc_name">{{id}}</h4>
                <p class="review">{{comment}}!</p>
            </div>
			{{/isThumbnail}}
            <div class="info_area">
                <div class="review_info"> <span class="grade">{{score}}.0</span> <span class="name">{{nickname}}****</span> <span class="date">{{createDate}}</span> </div>
            </div>
        </div>
    </li>
{{/reviews}}

</script>