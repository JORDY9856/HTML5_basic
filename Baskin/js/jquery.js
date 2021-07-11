/**
 * 
 */

$(function(){
		//JON 불러오기
		var requestURL = 'https://mdn.github.io/learning-area/javascript/oojs/json/superheroes.json';
		var request = new XMLHttpRequest();
		request.open('GET', requestURL);
		request.responseType = 'json';
		request.send();
		
		
		
		
		var list =[];// 장바구니 담긴 이름 리스트를 담기 위한 배열
		
		
		
		var iname = [];
		var inum = [];
		var i_price = [];
		var iprice = [];
		
		$('#submit').click(function(){
			for(var i = 0; i < list.length ;i++){
			iname[iname.length]= $('.tablesorter > tbody > tr').eq(i).find('.p_id').text()
			
			inum[inum.length]	=$('.tablesorter > tbody > tr').eq(i).find('.num_num').val()
			
			i_price[i_price.length]=$('.tablesorter > tbody > tr').eq(i).find('.p_price_location').text()
			
			iprice[iprice.length]=	$('.tablesorter > tbody > tr').eq(i).find('.price_location').text()
			
		}	
			
			
			/*var form = document.createElement('form');

			form.setAttribute('method', 'post');

			form.setAttribute('action', 'pay.jsp');

		

			for (var i=0;i<list.length ;i++) {

				var hiddenField = document.createElement('input');

				hiddenField.setAttribute('type', 'hidden');

				hiddenField.setAttribute('name', key);

				hiddenField.setAttribute('value', params[key]);

				form.appendChild(hiddenField);

			}

			document.body.appendChild(form);

			form.submit();*/
			
			localStorage.setItem("p_id", JSON.stringify(iname));
			localStorage.setItem("num", JSON.stringify(inum));
			localStorage.setItem("p_price", JSON.stringify(i_price));
			localStorage.setItem("price", JSON.stringify(iprice));
	/*		  $.jStorage.set("p_id",iname);
			  $.jStorage.set("num", inum);
			  $.jStorage.set("p_price", ip_price);
			  $.jStorage.set("price",iprice);
			location.replace('pay.html')	
			*/
			
		});
		
		
		$.fn.result = function(){
	
		var iname =		JSON.parse(localStorage.getItem('p_id'));
		var inum =		JSON.parse(localStorage.getItem('num'));
		var i_price=	JSON.parse(localStorage.getItem('p_price'));
		var iprice= 	JSON.parse(localStorage.getItem('price'));
		var sum=0;
		var  p=''
		/*	  var iname = ($.jStorage.get('p_id'));
			   var inum =val($.jStorage.get('num'));   
			  var i_price =($.jStorage.get('p_price'));
			  var price =($.jStorage.get('price')); 
		*/
		
	    for(var i = 0; i < iname.length ;i++){
	        var state ='<tr>';
	           state += '<td>'+iname[i]+'</td>';
	           state += '<td></td>';
	           state += '<td>'+inum[i]+'</td>';
	           state += '<td></td>';
	           state += '<td>'+i_price[i]+'</td>';
	           state += '<td>'+iprice[i]+'</td>';
	           state += '<td></td>';
	           state += '</tr>';
	           p= iprice[i].replace(',','');
	           p = p.slice(0,-1);
	           p= parseInt(p) ;
	           sum+= p;
	           
	         $('#res_insert').append(state);
	        
	        
	    }
		sum = sum + "원";
	    $('#final_r').val(sum)
	 }  
		
	
	
	
	
	
	
	//결제완료시 비우기
	
	
	// 이름 클릭 시 장바구니에 넣는 코드
	$('.service h2').on('click',function(){//동적 할당을 위해 on 함수 사용
		
		var name = '<td class="p_id" value="a" name="p_id">' + $(this).text() +'</td>'; 
		var name2 = $(this).text()  //이름만
		var p_price = '<td class="p_price_location" value="a" name= "p_price_location"  >' +$(this).next().text() +'</td>';//단가
		var price = '<td class="price_location" value="a" name = "price_location"  >' +$(this).next().text() +'</td>';//가격
		
		
		if(!(list.includes(name2))){  			//리스트 이름이 없으면 (장바구니 추가)
		var num =
			'<td><input type="text" name="num_num" class="num_num" value="1" style="text-align: right;  maxlength=3"/></td>';
		//수량
		var icon =
			"<td><img src='./image/plus-circle.svg' width='40px'></td>" +
			"<td>" +"<img src='./image/dash-circle.svg' width='40px'> </td>";
		//+ - 아이콘
		
		
		var menu ='<tr>';
		
		
		menu +=name;
		menu +=num;
		menu +=icon;
		menu +=p_price;
		menu += price;  
		menu +='</tr>';
		

		
		$('.tablesorter  tbody').append(menu);//tbody에 추가
		
		list[list.length]=name2;  //리스트 마지막에 추가
		/*var  tr_n  =list.length;
		
		$('.tablesorter > tbody > tr').eq(tr_n).first().addClss(id_num);*/
		
	/*	//post 전달을 위해서 value 값 넣을 준비 수량은 원래 value로 통제
		var na =$(this).text()
		var ppr = $(this).next().text();
		var pr =$(this).next().text();
		var n = list.length -1;//eq로 몇번째 tr인지 찾기 위해
		$('.tablesorter  tbody tr').eq(n).find('.p_id').val(na)
		
		$('.tablesorter  tbody tr').eq(n).find('.p_price_location').val(ppr)
		$('.tablesorter  tbody tr').eq(n).find('.price_location').val(pr)*/
		$.fn.sum();
		}else{//이름이 있으면 수량 늘리기
			var n =list.indexOf(name2); //해당 메뉴가  몇번째로 추가됬는지 찾기
			n=parseInt(n)
			
			
			var i= $('.tablesorter > tbody > tr').eq(n).find('.num_num');	//수량 위치
			var num=parseInt(i.val()) + 1
			i.val(num)
			
			var price_loction =$('.tablesorter > tbody > tr').eq(n).find('.price_location');//가격 위치
			var p = $(this).next().text().replace(',','');
			
			p = parseInt(p);
			
			p= p *num;
			p= p + "원"
			
			price_loction.text(p);
			$.fn.sum();
		}
		
	})

	// 상기 코드와 거의 동일하게 이미지 클릭시 장바구니 추가
	$('.service img').on('click',function(){
		
		var name = '<td class="p_id" name = "p_id">' + $(this).parent().next().text() +'</td>';//img에서 부모로 한번올라갔다가 이동
		var name2 =$(this).parent().next().text();
		var p_price = '<td class="p_price_location" name = "p_price_location">' +$(this).parent().next().next().text() +'</td>';//img에서 부모로 한번올라갔다가 이동
		var price =	'<td class ="price_location"  name="price_location">' +$(this).parent().next().next().text() +'</td>';
		 if(!(list.includes(name2))){
		var num =
			'<td><input type="text"  name="num_num" class="num_num" value="1" style="text-align: right;  maxlength=3"/></td>';
		
		
		var icon =
			"<td><img src='./image/plus-circle.svg' width='40px'></td>" +
			"<td>" +"<img src='./image/dash-circle.svg' width='40px'> </td>";
	
		var menu ='<tr>';
		
		
		menu +=name;
		menu +=num;
		menu +=icon;
		menu +=p_price;
		menu += price;
		menu +='</tr>';
		

		$('.tablesorter  tbody').append(menu);
		
		
		
		list[list.length]=name2;  //리스트 마지막에 추가
	/*	
		//post 전달을 위해서 value 값 넣을 준비 수량은 원래 value로 통제
		var na =$(this).parent().next().text();
		var ppr =$(this).parent().next().next().text();
		var pr =$(this).parent().next().next().text();
		
		var n = list.length -1;//eq로 몇번째 tr인지 찾기 위해
		
		$('.tablesorter  tbody tr').eq(n).find('.p_id').val(na)
		alert($('.tablesorter  tbody tr').eq(n).find('p_id').text())
		alert($('.tablesorter  tbody tr').eq(n).find('p_id').val())
		$('.tablesorter  tbody tr').eq(n).find('.p_price_location').val(ppr)
		$('.tablesorter  tbody tr').eq(n).find('.price_location').val(pr)
		*/
		
		$.fn.sum();// 총액
		 }else{
			 var n =list.indexOf(name2); //해당 메뉴가  몇번째로 추가됬는지 찾기
				n=parseInt(n)
				
				
				var i= $('.tablesorter > tbody > tr').eq(n).find('.num_num');	//수량 위치
				var num=parseInt(i.val() )+ 1
				i.val(num);//수량 입력
				var price_loction =$('.tablesorter > tbody > tr').eq(n).find('.price_location');//가격 위치
				var p = $(this).parent().next().next().text().replace(',','');
				p=	(parseInt(p) * num) + '원';
				
				price_loction.text(p);
				$.fn.sum();
			 
		 }
	})
	
	
	
	// + 버튼 코드
	
	$(document).on('click','.tablesorter>tbody>tr>td:nth-child(3) img',function(){
		var num_tag =$(this).parent().prev().children();
		var price =$(this).parent().next().next().next();
		var p_price =$(this).parent().prev().next().next().next().text().replace(',','').slice(0,-1);
		
		
		var num=parseInt(num_tag.val()) + 1;
		num_tag.val(num);  //수량저장
		var p = num*p_price;
		p = p + "원"
		price.text(p); //가격 저장
		
		$.fn.sum();
		
		
	})
	
	//-아이콘 누를시 수량과 가격이 내려가는 코드
		$(document).on('click','.tablesorter>tbody>tr>td:nth-child(4) img',function(){
		var num_tag =$(this).parent().prev().prev().children();
		var price =$(this).parent().next().next();
		var p_price =$(this).parent().prev().next().next().text().replace(',','').slice(0,-1);
		
		var num=parseInt(num_tag.val());
		if(num>0){
		num =num-1;
		num_tag.val(num);
		var p = num*p_price;
		p = p + "원"
		price.text(p); //가격 저장
		}
		$.fn.sum();
		
	})	
	
	
	//20시 49분
	
	// < > 스크롤 따라다니기
	var currentPosition_L = parseInt($(".left1").css("top"));
	var currentPosition_R = parseInt($(".right1").css("top"));
	var currentPosition_L = parseInt($(".left2").css("top"));
	var currentPosition_R = parseInt($(".right2").css("top"));
	$(window).scroll(function() {
		var move= $(this).scrollTop();
			
		$(".left1").stop().animate({top: currentPosition_L+ move}, 1);
		$(".right1").stop().animate({top: currentPosition_R+ move}, 1);
		$(".left2").stop().animate({top: currentPosition_L+ move}, 1);
		$(".right2").stop().animate({top: currentPosition_R+ move}, 1);
	});

	//종합 
	$.fn.sum = function(){
	var sum_result=0;
	
	for(var i=0;i <list.length;i++ ){
		
		var price =$('.tablesorter > tbody > tr').eq(i).find('.price_location').text().replace(',','');
		price = parseInt(price);
		sum_result = sum_result + price;
	}
		
		$('#services > div:nth-child(4) > div > form > table.sum_c > tbody > tr:nth-child(1) > td:nth-child(2)').text(sum_result );
		

	}

	
	

	$(".btn.btn-primary1").click(function(){
		$.fn.result()
	alert("결제가 완료되었습니다");
	});
	
	


	
	
})