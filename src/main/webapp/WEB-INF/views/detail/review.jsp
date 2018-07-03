<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
                <div class="section_review_list">
                    <div class="review_box">
                        <h3 class="title_h3">예매자 한줄평</h3>
                        <div class="short_review_area">
                            <div class="grade_area">
                                <!-- [D] 별점 graph_value는 퍼센트 환산하여 width 값을 넣어줌 -->
                                <span class="graph_mask"> <em class="graph_value" style="width: 84%;"></em> </span>
                                <strong class="text_value"> <span>${product.avgScore }</span> <em class="total">5.0</em> </strong>
                                <span class="join_count"><em class="green">${product.reviewCount }건</em> 등록</span>
                            </div>
                            <ul class="list_short_review">
                            	<c:forEach var="ritem" items="${reviews }">
                            	<li class="list_item">
                                    <div>
                                        <div class="review_area">
                                            <div class="thumb_area">
                                                <a href="#" class="thumb" title="이미지 크게 보기"> <img width="90" height="90" class="img_vertical_top" src="/files/${ritem.thumbnailFileId}" alt="리뷰이미지"> </a> <span class="img_count">${ritem.thumbnailCount }</span>                                                </div>
                                            <h4 class="resoc_name">${product.name }</h4>
                                            <p class="review">${ritem.comment }</p>
                                        </div>
                                        <div class="info_area">
                                            <div class="review_info"> <span class="grade">${ritem.score }</span> <span class="name">${ritem.nickname }****</span> <span class="date">${ritem.createDate }</span> </div>
                                        </div>
                                    </div>
                                </li>
                            	</c:forEach>
                                <li class="list_item">
                                    <div>
                                        <div class="review_area">
                                            <div class="thumb_area">
                                                <a href="#" class="thumb" title="이미지 크게 보기"> <img width="90" height="90" class="img_vertical_top" src="http://naverbooking.phinf.naver.net/20170306_3/1488772023601A4195_JPEG/image.jpg?type=f300_300" alt="리뷰이미지"> </a> <span class="img_count">1</span>                                                </div>
                                            <h4 class="resoc_name">뮤지컬 로미오와 줄리엣</h4>
                                            <p class="review">2층이어서 걱정했는데 꽤잘보여서 좋았습니다 고미오 너무 멋있었습니다 사진은 커튼콜때 찍었습니다 끝나고 퇴근길도 봐서 너무 좋았어요</p>
                                        </div>
                                        <div class="info_area">
                                            <div class="review_info"> <span class="grade">4.0</span> <span class="name">dbfl****</span> <span class="date">2017.3.5. 방문</span> </div>
                                        </div>
                                    </div>
                                </li>
                                <li class="list_item">
                                    <div>
                                        <div class="review_area no_img">
                                            <h4 class="resoc_name">뮤지컬 로미오와 줄리엣</h4>
                                            <p class="review">너무 재밌게봤구요~<br>마지막공연 후 뒷풀이도 잘봤습니다</p>
                                        </div>
                                        <div class="info_area">
                                            <div class="review_info"> <span class="grade">5.0</span> <span class="name">yyck****</span> <span class="date">2017.3.5. 방문</span> </div>
                                        </div>
                                    </div>
                                </li>
                                <li class="list_item">
                                    <div>
                                        <div class="review_area no_img">
                                            <h4 class="resoc_name">뮤지컬 로미오와 줄리엣</h4>
                                            <p class="review">좋은 공연이었습니다. <br>머큐쇼역활 하신분의 열창이 기억에 남는 반면에,,, 로미오는 별로 기억에 남지 않네요..</p>
                                        </div>
                                        <div class="info_area">
                                            <div class="review_info"> <span class="grade">4.0</span> <span class="name">xero****</span> <span class="date">2017.3.4. 방문</span> </div>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <p class="guide"> <i class="spr_book2 ico_bell"></i> <span>네이버 예약을 통해 실제 방문한 이용자가 남긴 평가입니다.</span> </p>
                    </div>
                    <a class="btn_review_more" href="/reviews?pid=${product.id }"> <span>예매자 한줄평 더보기</span> <i class="fn fn-forward1"></i> </a>
                </div>