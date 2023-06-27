<%@page import="bitedu.bipa.member.vo.User"%>
<%@page import="bitedu.bipa.member.vo.TestVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Registration</title>
    <style>
        table, td, th {
            border : 1px solid black;
            border-collapse: collapse;
            margin: 20px auto;
        }
        td {
            width: 150px;
            height: 50px;
            padding: 5px;
            font-size: 20px;
            /* text-align: center; */
        }

        input , select {
            font-size: 20px;
        }
        .data_ui {
            /* width: 250px; */
            height: 50px;
        }

        button {
            font-size: 15px;
            margin: 5px;
        }
        
        
        #sending {
        	text-align: center;
        }
        
        input.poster :disabled {
        	background: gray;
        }
        
        #form {
        	font-size: 30px;
        }
        
        #message {
        	color: red;
        }
    </style>
    <script type="text/javascript" src="//t1.daumcdn.net/mapjsap/bundle/postcode/prod/postcode.v2.js"></script>
    <script type="text/javascript" src="https://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#month').on('change',function(){
				alert('a');
				let year = $('#year').val();
				let month = $('#month').val();
				let days = new Date(parseInt(year),month,0).getDate();
				alert(days);
				let day_of_month = "<select id='' name='days'><option>--일--</option>"
				for(let i=0;i<days;i++){
					day_of_month += `<option value='${i+1}'>${i+1}</option>`;
				}
				day_of_month += '</select>';
				alert(day_of_month);
				$('#days').html(day_of_month);
			});
			$('#btn_check_id').on('click',function(e){
				let user_id = $('#user_id').val();
				let alpha = 'abcdefghijklmnopqrstuvwxyz';
				let message = "";
				if(user_id!=''&&user_id.length<=8&&alpha.indexOf(user_id.charAt(0))>=0){
					alert(user_id);
					$.ajax({
						url : "/MemberSample/memberController",
						type : 'get',
						data : {'user_id':user_id},
						success : function(data){
							let flag = JSON.parse(data).result;
							if(flag){
								$('#message').html('사용할 수 없는 아이디입니다.');
							} else {
								$('#message').html('사용할 수 있는 아이디입니다.');
							}
							$('#flag').val("true");
						},
						error : function(){
							
						},
						complete : function(){
							
						}
					});
				} else {
					message += 'id가 비어있거나 형식에 맞지 않습니다.';
					$('#message').html(message);
				}
				e.preventDefault();
			});
			let checkId = function(){
				return $('#flag').val();
			}
			let validateData = function(){
				let flag = false;
				if(checkId()=='true'){
					flag = true;
				}
				return flag;
			}
			$('#sending').on('click',function(e){
							
				let result = validateData();
				result = false;
				if(!result){
					e.preventDefault();
				}
			});
			
			$('#find_zipcode').on('click',function(e){
				$('#postal').val("12345");
				$('#addr1').val('부산시 해운대구 좌동');
				$('#addr2').attr('disabled',false);
				$('#addr2').val('부산산업진흥원 5층 금강산');
				
				e.preventDefault();
			});
		});
	</script>
</head>
<body>
<%
	User user = (User)request.getAttribute("user");
	System.out.println(user);
%>
<form action="/MemberSample/memberController" method="get">
    <table>
        <tr><th colspan="4" id="form">회원가입수정</th></tr>
        <tr><th>구분</th><th class="data_ui" colspan="2">데이터입력</th><th>메시지</th></tr>
        <tr>
            <td>아이디</td>
            <td colspan="2">
            	<input type="text" id="user_id" name="userId" value="admin">
            	<button id="btn_check_id">아이디확인</button>
            </td>
            <td id="message"></td></tr>
        <tr><td>비밀번호</td><td colspan="2"><input type="text" id="pwd1" name="pwd1"></td><td rowspan="2"><input type="hidden" id="flag" value="false"></td></tr>
        <tr><td>비번확인</td><td colspan="2"><input type="text" id="pwd2" name="pwd2"></td></tr>
        <tr><td>이름</td><td colspan="2"><input type="text" id="user_name" name="userName"></td><td></td></tr>
        <tr><td>우편번호</td><td colspan="2"><input type="text" id="postal" name="postal" disabled><button id="find_zipcode">우편번호찾기</button></td><td rowspan="3"></td></tr>
        <tr><td>주소1</td><td colspan="2"><input type="text" id="addr1" size="35" name="addr1" disabled></td></tr>
        <tr><td>주소2</td><td colspan="2"><input type="text" id="addr2" size="35" name="addr2" disabled></td><tr>
        <tr>
            <td>생년월일</td>
            <td colspan="2">
            
            	<input type="text" id="" placeholder="년도" size="5" readonly="readonly">-
                <input type="text" id="" placeholder="월" size="5" readonly>-
                <input type="text" id="" placeholder="일" size="5" readonly>
                <br><br>
                <input type="text" placeholder="년도" size="5" id="year" name="year">
                -
                <select id="month" name="month">
                    <option>-- 월 --</option>
                    <option value='1'>1</option>
                    <option value='2'>2</option>
                    <option value='3' <%="selected"%>>3</option>
                    <option value='4'>4</option>
                    <option value='5'>5</option>
                </select>
                -
                <span id="days"></span>

            </td><td></td></tr>
        <tr>
            <td>성별</td>
            <td colspan="2">
                <input type="radio" name="gender" value="0" <%="checked" %>>남
                <input type="radio" name="gender" value="1">여
            </td><td></td>></tr>
        <tr>
            <td>관심분야</td>
            <td colspan="2">
                <input type="checkbox" name="interests" value="0">문학
                <input type="checkbox" name="interests" value="1">어학
                <input type="checkbox" name="interests" value="2" <%="checked" %>>정보IT<br>
                <input type="checkbox" name="interests" value="3">과학
                <input type="checkbox" name="interests" value="4" <%="checked" %>>수학
                <input type="checkbox" name="interests" value="5">예술
            </td><td></td>
        </tr>
        <tr><td>자기소개</td>
        <td colspan="2">
        	<textarea cols="50" rows="5" name="introduce"><%="안녕하세요"%></textarea>
        </td><td></td></tr>    
        <tr><td colspan="4" id="sending"><input type="submit" value="수정"> <input type="reset"></td></tr>
    </table>
</form>
</body> 
</html>





