<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="../theme.css">
</head>

<body>
  <nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container"> <a class="navbar-brand" href="#">
        <i class="fa d-inline fa-lg fa-stop-circle"></i>
        <b>Cake House後台管理系統</b>
    </a> <button class="navbar-toggler navbar-toggler-right border-0" type="button" data-toggle="collapse" data-target="#navbar10">
        <span class="navbar-toggler-icon"></span>
    </button>
        <div class="collapse navbar-collapse" id="navbar10">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item"> <a class="nav-link" href="list.html">使用者管理</a> </li>
            <li class="nav-item"> <a class="nav-link" href="../news/list.html">最新消息管理</a> </li>
            <li class="nav-item"> <a class="nav-link" href="../products/list.html">產品管理</a> </li>
          </ul>
        </div>
    </div>
</nav>

  <div class="text-center py-2">
    <div class="container">
      <div class="row">
        <div class="col-md-12 p-3">
          <h1 class="mb-0 text-left">最新消息管理</h1>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12">
          <ul class="breadcrumb">
            <li class="breadcrumb-item"> <a href="#">首頁</a> </li>
            <li class="breadcrumb-item active">最新消息管理</li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  <div class="pb-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <a href="form.html" class="btn btn-primary btn-sm my-3">新增</a>
          <div class="table-responsive">
            <table class="table table-bordered ">
              <thead class="thead-dark">
                <tr>
                  <th>發佈日期</th>
                  <th>標題</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
              
                <tr>
                  <td>2020-10-20</td>
                  <td>萬聖節DIY活動</td>
                  <td style=""><a class="btn btn-link p-0" href="">編輯</a>&nbsp;&nbsp;&nbsp;
                    <a class="btn btn-link p-0" onclick="return confirm('確定刪除此筆資料?刪除後無法回復')" href="">刪除</a></td>
                </tr>
                <tr>
                  <td>2020-10-11</td>
                  <td>新品上市</td>
                  <td style=""><a class="btn btn-link p-0" href="">編輯</a>&nbsp;&nbsp;&nbsp;
                    <a class="btn btn-link p-0" onclick="return confirm('確定刪除此筆資料?刪除後無法回復')" href="">刪除</a></td>
                </tr>
                <tr>
                  <td>2020-10-02</td>
                  <td>杯子蛋糕教學</td>
                  <td style=""><a class="btn btn-link p-0" href="">編輯</a>&nbsp;&nbsp;&nbsp;
                    <a class="btn btn-link p-0" onclick="return confirm('確定刪除此筆資料?刪除後無法回復')" href="">刪除</a></td>
                </tr>

              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="py-3">
    <div class="container">
      <div class="row">
        <div class="col-md-12 text-center">
          <p class="mb-0">© 2014-2018 MacroViz. All rights reserved</p>
        </div>
      </div>
    </div>
  </div>
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>

</html>