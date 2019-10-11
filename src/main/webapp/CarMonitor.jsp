<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<style type="text/css">
		.page{height: 100%;}
		#Amap{height: 100%;}
</style>
 <style>
    html,
    body,
    #container {
        width: 100%;
        height: 100%;
        margin: 0px;
    }
    
    #loadingTip {
        position: absolute;
        z-index: 9999;
        top: 0;
        right: 0;
        padding: 3px 10px;
        background: red;
        color: #fff;
        font-size: 13px;
    }
    /**
     * 定义my-hover-title 
     */
    
    .amap-ui-pointsimplifier-container .overlay-title.my-hover-title {
        font-size: 14px;
        line-height: 200%;
        font-style: italic;
        padding: 0 10px;
    }
    
.button-group {
	position: absolute;
	bottom: 20px;
	right: 20px;
	font-size: 12px;
	padding: 10px;
}

.button-group .button {
	height: 28px;
	line-height: 28px;
	background-color: #0D9BF2;
	color: #FFF;
	border: 0;
	outline: none;
	padding-left: 5px;
	padding-right: 5px;
	border-radius: 3px;
	margin-bottom: 4px;
	cursor: pointer;
}
.button-group .inputtext {
	height: 26px;
	line-height: 26px;
	border: 1px;
	outline: none;
	padding-left: 5px;
	padding-right: 5px;
	border-radius: 3px;
	margin-bottom: 4px;
	cursor: pointer;
}

#tip {
	background-color: #fff;
	padding-left: 10px;
	padding-right: 10px;
	position: absolute;
	font-size: 12px;
	right: 10px;
	top: 20px;
	border-radius: 3px;
	border: 1px solid #ccc;
	line-height: 30px;
}


.amap-info-content {
	font-size: 12px;
}

#myPageTop {
	position: absolute;
	top: 5px;
	right: 10px;
	background: #fff none repeat scroll 0 0;
	border: 1px solid #ccc;
	margin: 10px auto;
	padding:6px;
	font-family: "Microsoft Yahei", "微软雅黑", "Pinghei";
	font-size: 14px;
}
#myPageTop label {
	margin: 0 20px 0 0;
	color: #666666;
	font-weight: normal;
}
#myPageTop input {
	width: 170px;
}
#myPageTop .column2{
	padding-left: 25px;
}
    </style>
<div id="Amap" ></div>
<div id="myPageTop">
   <table>
        <tr>
            <td>
                <label>按关键字搜索：</label>
            </td>
            <td class="column2">
                <label>左击获取经纬度：</label>
            </td>
        </tr>
        <tr>
            <td>
                <input type="text" placeholder="请输入关键字进行搜索" id="tipinput">
            </td>
            <td class="column2">
                <input type="text" readonly="true" id="lnglat">
            </td>
        </tr>
    </table>
</div>
<script>
    //创建地图
    var map = new AMap.Map('Amap', {
        zoom: 4
    });

    AMapUI.load(['ui/misc/PointSimplifier', 'lib/$'], function(PointSimplifier, $) {

        if (!PointSimplifier.supportCanvas) {
            alert('当前环境不支持 Canvas！');
            return;
        }

        var pointSimplifierIns = new PointSimplifier({

            zIndex: 300,
            map: map,
            //maxChildrenOfQuadNode:3,

            getPosition: function(item) {

                if (!item) {
                    return null;
                }

                var parts = item.split(',');

                return [parseFloat(parts[0]), parseFloat(parts[1])];
            },
            compareDataItem: function(a, b, aIndex, bIndex) {

                if (aIndex === bIndex) {
                    return 0;
                }

                return aIndex > bIndex ? -1 : 1;
            },
            getHoverTitle: function(dataItem, idx) {
                return '编号: ' + idx+':'+dataItem;
            },
            renderOptions: {
                //点的样式
                pointStyle: {
                    //绘制点占据的矩形区域
                    content: function(ctx, x, y, width, height) {

                        //注意，这里的width和height可能不同于pointStyle里面的width/height， 高清屏幕下会存在比例缩放

                        //这里绘制一个圆顶锥形

                        var yPos = 1 / 3;

                        var top = [x + width / 2, y],
                            right = [x + width, y + height * yPos],
                            bottom = [x + width / 2, y + height],
                            left = [x, y + height * yPos];

                        ctx.moveTo(left[0], left[1]);
                        ctx.arcTo(top[0], top[1], right[0], right[1], width / 3);
                        ctx.lineTo(right[0], right[1]);
                        ctx.lineTo(bottom[0], bottom[1]);
                        ctx.lineTo(left[0], left[1]);

                    },
                    //宽度
                    width: 15,
                    //高度
                    height: 24,
                    offset: ['-50%', '-100%'],
                    fillStyle: '#316395',
                    lineWidth: 1,
                    strokeStyle: 'gray'
                },
                topNAreaStyle: {
                    content: function(ctx, x, y, width, height) {

                        //绘制一个连接矩形四边中点的菱形

                        var top = [x + width / 2, y],
                            right = [x + width, y + height * 1 / 2],
                            bottom = [x + width / 2, y + height],
                            left = [x, y + height * 1 / 2];

                        ctx.moveTo(top[0], top[1]);
                        ctx.lineTo(right[0], right[1]);
                        ctx.lineTo(bottom[0], bottom[1]);
                        ctx.lineTo(left[0], left[1]);
                        ctx.lineTo(top[0], top[1]);

                    },
                },
                //鼠标hover时，绘制的叠加点的样式
                pointHoverStyle: {
                    width: 10,
                    height: 10,
                    content: 'circle'
                },
                //鼠标hover时显示的title样式
                hoverTitleStyle: {
                    classNames: 'my-hover-title',
                    offset: [0, -15],
                    position: 'top'
                }
            }
        });

        window.pointSimplifierIns = pointSimplifierIns;

        $('<div id="loadingTip">加载数据，请稍候...</div>').appendTo(document.body);
        $.get('./datafile/10w.txt', function(csv) {

            var data = csv.split('\n');

            pointSimplifierIns.setData(data);

            $('#loadingTip').remove();
        });
    });
    
 //为地图注册click事件获取鼠标点击出的经纬度坐标
    var clickEventListener = map.on('click', function(e) {
        document.getElementById("lnglat").value = e.lnglat.getLng() + ',' + e.lnglat.getLat()
    });
    var auto = new AMap.Autocomplete({
        input: "tipinput"
    });
    AMap.event.addListener(auto, "select", select);//注册监听，当选中某条记录时会触发
    function select(e) {
        if (e.poi && e.poi.location) {
            map.setZoom(15);
            map.setCenter(e.poi.location);
        }
    }
</script>
