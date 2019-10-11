
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="S" %>
    <link rel="stylesheet" href="chart/css/common.css">
    <link rel="stylesheet" href="chart/css/data_text.css">
    <link rel="stylesheet" href="chart/css/foundation-datepicker.css">

<script src="chart/js/jquery-2.2.1.min.js"></script>
<script src="chart/js/bootstrap.min.js"></script>
<script src="chart/js/common.js"></script>
<script src="chart/js/echarts.min.js"></script>
<script src="chart/js/echart.js"></script>
<script src="chart/js/china.js"></script>
<script src="chart/js/foundation-datepicker.js"></script>
<script src="chart/js/foundation-datepicker.zh-CN.js"></script>
<!--content开始-->
<div class="data_content" style=" overflow:scroll; height:500px;">
    

    <div class="data_main">
        <div class="main_left fl">
            <div class="left_1">
                <div class="main_title">
                    <img src="img/title_1.png" alt="">
                    车辆类型统计
                </div>
                <div id="chart_1" class="chart" style="width:100%;height: 280px;"></div>
            </div>
            <div class="left_2">
                <div class="main_title">
                    <img src="img/title_2.png" alt="">
                    车辆状态统计
                </div>
                <div id="chart_2" class="chart" style="width:100%;height: 280px;"></div>
            </div>
        </div>
       
        <div class="main_right fr">
            <div class="right_1">
                <div class="main_title">
                    <img src="img/title_4.png" alt="">
                    车辆行驶数量
                </div>
                <div class="choice">
                    <label for="">类型：</label>
                    <select name="" id="">
                        <option value="">客车</option>
                        <option value="">轿车</option>
                        <option value="">飞机</option>
                    </select>
                </div>
                <div id="chart_3" class="echart" style="width:100%;height: 280px;"></div>
            </div>
            <div class="right_2">
                <div class="main_title">
                    <img src="img/title_5.png" alt="">
                    车辆报警统计
                </div>
                <div id="chart_4" class="echart fl" style="width:80%;height: 230px;"></div>
                <div class="fr chart_text">
                    <p>同比</p>
                    <p><img src="img/down.png" alt="">2%</p>
                    <p><img src="img/up.png" alt="">4%</p>
                    <p><img src="img/down.png" alt="">5%</p>
                    <p><img src="img/down.png" alt="">3%</p>
                </div>
                <div style="width: 80%;" class="text_sum">
                    <div class="fl" style="width:30%">332</div>
                    <div class="fl" style="width:40%">统计</div>
                    <div class="fr" style="width:30%">505</div>

                </div>
            </div>
        </div>
    </div>
    


</div>
<!--content结束-->
<!-- <script>
var a=${CarTypeCount}
jsonp = JSON.stringify(a);
var data = JSON.parse(jsonp);
console.log(data);
</script> -->
