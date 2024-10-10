<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Bootstrap Example</title>
</head>
<body>

<div class="container mt-3">
		<h2>중고상품 목록 Table</h2>
  <input class="form-control" id="myInput" type="text" placeholder="Search..">
  <br>
  <table class="table table-bordered">
    <thead>
      <tr>
    		<th>상품이름</th>
					<th>가격</th>
					<th>제조사</th>
      </tr>
    </thead>
    <tbody id="myTable">
      <tr>
      	<td>삼성 갤럭시 울트라</td>
		<td>1000</td>
		<td>삼성</td>
      </tr>
      <tr>
		<td>LG 그램 울트라 pc</td>
		<td>1000</td>
		<td>LG</td>
      </tr>
      <tr>
		<td>폴더블 폰</td>
		<td>700</td>
		<td>삼성</td>
      </tr>
      <tr>
        <td>Anja</td>
        <td>Ravendale</td>
        <td>a_r@test.com</td>
      </tr>
    </tbody>
  </table>
</div>
	<script>
	$("#myInput").on("keyup", function() {
		const value = $(this).val().toLowerCase();
		$("#myTable tr").each(function(){
			console.log($(this).text().toLowerCase().indexOf(value) > -1);
			
			// toggle(true) 이면 해당 엘리먼트가 보이고 false면 숨긴다.
			$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
		});
	});
	</script>
</body>
</html>