<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<ul class="list_short_review">
<c:forEach var="ritem" items="${product.reviews }">
	<li class="list_item">
        <div>
           	<c:if test="${ritem.thumbnailFileId ne 0 }">
            <div class="review_area">
               	<div class="thumb_area" data-comment-id="${ritem.id}">
                   <a class="thumb" title="이미지 크게 보기"> <img width="90" height="90" class="img_vertical_top" src="/files/${ritem.thumbnailFileId}" alt="리뷰이미지"> </a> <span class="img_count">${ritem.thumbnailCount }</span>                                                
                   </div>

               	<h4 class="resoc_name title" data-product-id="${product.id}">${product.name }</h4>
               	<p class="review">${ritem.comment }</p>
            </div>
           	</c:if>
           	<c:if test="${ritem.thumbnailFileId eq 0 }">
           	<div class="review_area no_img">
                <h4 class="resoc_name title" data-product-id="${product.id}" >${product.name }</h4>
                <p class="review">${ritem.comment }</p>
            </div>
           	</c:if>
            <div class="info_area">
                <div class="review_info"> <span class="grade">${ritem.score }</span> <span class="name">${ritem.nickname }****</span> <span class="date">${ritem.createDate }</span> </div>
            </div>
        </div>
    </li>
</c:forEach>
<!-- 
    <li class="list_item">
        <div>
            <div class="review_area no_img">
                <h4 class="resoc_name">뮤지컬_드림걸즈(DREAMGIRLS)_최초_내한</h4>
                <p class="review">2층에 있었어도 목소리에 압도당한 느낌!<br>너무 재미있었어요^^!!!!!!</p>
            </div>
            <div class="info_area">
                <div class="review_info"> <span class="grade">5.0</span> <span class="name">vida****</span> <span class="date">2017.4.9. 방문</span> </div>
            </div>
        </div>
    </li>
    <li class="list_item">
        <div>
            <div class="review_area no_img">
                <h4 class="resoc_name">뮤지컬_드림걸즈(DREAMGIRLS)_최초_내한</h4>
                <p class="review">최고. 체고...!!!!최고 ㅠㅠㅠ</p>
            </div>
            <div class="info_area">
                <div class="review_info"> <span class="grade">5.0</span> <span class="name">sh67****</span> <span class="date">2017.4.9. 방문</span> </div>
            </div>
        </div>
    </li>
    <li class="list_item">
        <div>
            <div class="review_area no_img">
                <h4 class="resoc_name">뮤지컬_드림걸즈(DREAMGIRLS)_최초_내한</h4>
                <p class="review">너무재미있고 감동적이었어요<br>최고에요</p>
            </div>
            <div class="info_area">
                <div class="review_info"> <span class="grade">5.0</span> <span class="name">sadc****</span> <span class="date">2017.4.9. 방문</span> </div>
            </div>
        </div>
    </li>
    <li class="list_item">
        <div>
            <div class="review_area no_img">
                <h4 class="resoc_name">뮤지컬_드림걸즈(DREAMGIRLS)_최초_내한</h4>
                <p class="review">주연배우 중 디나역이 원캐스팅이었는데 더블로 바뀌었는지 다른 사람이더라고요;; 방송에서 보고 일부러 간건데 뭔가 속은 느낌, 알아보니 배우들 중에서도 미국 드림걸즈 무대에 섰던 사람은 1명뿐이던데.. 뭐가 오리지널멤버 최초 내한인지 모르겠네요 ;;<br>다른 배우들은 다 좋았는데 디나역이 리슨부를 때 가창력이 떨어져서 좀 그랬네요</p>
            </div>
            <div class="info_area">
                <div class="review_info"> <span class="grade">4.0</span> <span class="name">appl****</span> <span class="date">2017.4.9. 방문</span> </div>
            </div>
        </div>
    </li>
    <li class="list_item">
        <div>
            <div class="review_area">
                <div class="thumb_area">
                    <a href="#" class="thumb" title="이미지 크게 보기"> <img width="90" height="90" class="img_vertical_top" src="https://ssl.phinf.net/naverbooking/20170410_7/1491785083711GqT4T_PNG/image.png?type=f300_300" alt="리뷰이미지"> </a> <span class="img_count">1</span>                                                </div>
                <h4 class="resoc_name">뮤지컬_드림걸즈(DREAMGIRLS)_최초_내한</h4>
                <p class="review">넘넘 재밌었어요!!!에피랑 지미 짱!!!!!</p>
            </div>
            <div class="info_area">
                <div class="review_info"> <span class="grade">5.0</span> <span class="name">tnql****</span> <span class="date">2017.4.9. 방문</span> </div>
            </div>
        </div>
    </li>
    <li class="list_item">
        <div>
            <div class="review_area no_img">
                <h4 class="resoc_name">뮤지컬_드림걸즈(DREAMGIRLS)_최초_내한</h4>
                <p class="review">최고예요!! 기회가 된다면 내한 공연 중 한 번 더 보고싶어요...</p>
            </div>
            <div class="info_area">
                <div class="review_info"> <span class="grade">5.0</span> <span class="name">dnql****</span> <span class="date">2017.4.8. 방문</span> </div>
            </div>
        </div>
    </li>
    <li class="list_item">
        <div>
            <div class="review_area no_img">
                <h4 class="resoc_name">뮤지컬_드림걸즈(DREAMGIRLS)_최초_내한</h4>
                <p class="review">정말 너무 멋진 공연 이었어요<br>감사합니다~~<br>나중에 또 보러갈거예요**^^**</p>
            </div>
            <div class="info_area">
                <div class="review_info"> <span class="grade">5.0</span> <span class="name">buk1****</span> <span class="date">2017.4.8. 방문</span> </div>
            </div>
        </div>
    </li>
    <li class="list_item">
        <div>
            <div class="review_area no_img">
                <h4 class="resoc_name">뮤지컬_드림걸즈_최초_내한_타임세일</h4>
                <p class="review">전 뮤지컬이 처음이었는데....너무 감동해서 눈물까지 흘렸네요 엄청난 사운드와 배우들의 연기 모두 최고였습니다</p>
            </div>
            <div class="info_area">
                <div class="review_info"> <span class="grade">5.0</span> <span class="name">pcd2****</span> <span class="date">2017.4.8. 방문</span> </div>
            </div>
        </div>
    </li>
    <li class="list_item">
        <div>
            <div class="review_area">
                <div class="thumb_area">
                    <a href="#" class="thumb" title="이미지 크게 보기"> <img width="90" height="90" class="img_vertical_top" src="https://ssl.phinf.net/naverbooking/20170409_273/1491699111250gxiyJ_JPEG/image.jpg?type=f300_300" alt="리뷰이미지"> </a> <span class="img_count">1</span>                                                </div>
                <h4 class="resoc_name">뮤지컬_드림걸즈(DREAMGIRLS)_최초_내한</h4>
                <p class="review">작품이 너무 좋았어요 .</p>
            </div>
            <div class="info_area">
                <div class="review_info"> <span class="grade">5.0</span> <span class="name">ljhy****</span> <span class="date">2017.4.8. 방문</span> </div>
            </div>
        </div>
    </li>
    <li class="list_item">
        <div>
            <div class="review_area no_img">
                <h4 class="resoc_name">뮤지컬_드림걸즈(DREAMGIRLS)_최초_내한</h4>
                <p class="review">극 구성과 무대는 말할것도 없고 노래 실력이 와우 소름이 끼치네요 ㅎㅎㅎ 특히 에피역 배우의 원 나잇온리는 정말 녹음 까지 하고싶었습니다ㅎㅎㅎ 정말 강추에요. 꼭보세요 두번보세요ㅎㅎㅎ</p>
            </div>
            <div class="info_area">
                <div class="review_info"> <span class="grade">5.0</span> <span class="name">khw5****</span> <span class="date">2017.4.8. 방문</span> </div>
            </div>
        </div>
    </li>
     -->
</ul>