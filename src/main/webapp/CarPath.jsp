<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

		 <script src="http://webapi.amap.com/maps?v=1.4.3&key=7ed9aa5ed0853a5c91c04bb6dcc5d2c6"></script>
		 <script src="//webapi.amap.com/ui/1.0/main.js?v=1.0.11"></script>
         <script src="http://cache.amap.com/lbs/static/es5.min.js"></script>
         <script type="text/javascript" src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
<style type="text/css">
		.page{height: 100%;}
		#Amap{height: 100%;}
		
        #tip1 {
            height: 50px;
            background-color: #fff;
            padding-left: 10px;
            padding-right: 10px;
            border: 1px solid #969696;
            position: absolute;
            font-size: 12px;
            left: 10px;
            bottom: 20px;
            border-radius: 3px;
            line-height: 45px;
        }
         #tip {
           /*  height: 50px; */
            background-color: #fff;
            padding-left: 10px;
            padding-right: 10px;
            border: 1px solid #969696;
            position: absolute;
            font-size: 12px;
            right: 10px;
            bottom: 300px;
            border-radius: 3px;
            line-height: 40px;
        }

        #tip1 input[type='button'] {
            margin-left: 10px;
            margin-right: 10px;
            margin-top: 10px;
            background-color: #0D9BF2;
            height: 30px;
            text-align: center;
            line-height: 30px;
            color: #fff;
            font-size: 12px;
            border-radius: 3px;
            outline: none;
            border: 0;
            float: right;
        }
    #tip1 input[type='submit'] {
            margin-left: 10px;
            margin-right: 10px;
            margin-top: 10px;
            background-color: #0D9BF2;
            height: 30px;
            text-align: center;
            line-height: 30px;
            color: #fff;
            font-size: 12px;
            border-radius: 3px;
            outline: none;
            border: 0;
            float: right;
        }
</style>
<div id="Amap" ></div>
<div id="tip">
</div>

<div id="tip1">
    <form action="CarPathInfo" method="post"  onsubmit="return validateCallback(this, dialogAjaxDone)">  
    
     <input type="hidden" id="C_VIN" name="C_VIN" value="${param.C_VIN}" />
   
          日期：<input name=dateStart type="text" class="date"  style="width:100px;height:20px"  readonly="true" />
     --   <input name=dateEnd type="text" class="date"  style="width:100px;height:20px" readonly="true" />
 
		<input type="button" value="开始定位" onClick="javascript:CurrentLocation()"/>
	    <input type="submit" value="轨迹查看"  name="submit" onClick="javascript:GetRoute()" />				
   </form>
</div>


<script>

 
	function CurrentLocation() {
		var toolBar;
		//初始化地图对象，加载地图
		console.log(lng + "----" + lat)
		var map = new AMap.Map('Amap', {
			resizeEnable : true,//鼠标滚动大小
			zoom : 15,
			center : new AMap.LngLat(lng, lat)
		});
		var customMarker = new AMap.Marker({
			offset : new AMap.Pixel(-14, -34),//相对于基点的位置
			icon : new AMap.Icon({ //复杂图标
				size : new AMap.Size(50, 80),//图标大小
				image : "./images/car.png", //大图地址
				//imageOffset : new AMap.Pixel(-28, 0)
			//相对于大图的取图位置
			}),
			map : map

		});
		//地图中添加地图操作ToolBar插件
		map.plugin([ "AMap.ToolBar" ], function() {
			toolBar = new AMap.ToolBar({
				locationMarker : customMarker
			}); //设置地位标记为自定义标记
			map.addControl(toolBar);
		});
	}

	var josnp = "";
	var C_VIN = '${param.C_VIN}';

/* 	function dialogAjaxDone(json) {

		//DWZ.ajaxDone(json);
		//alert(json);
		jsonp = JSON.stringify(json);
		var dialog = $.pdialog.getCurrent();
		$.pdialog.reload(dialog.data("url"));
          
	} */
function dialogAjaxDone(json){
	DWZ.ajaxDone(json);
	jsonp = JSON.stringify(json);
	var dialog = $.pdialog.getCurrent();
		$.pdialog.reload(dialog.data("url"));      
	if (json[DWZ.keys.statusCode] == DWZ.statusCode.ok){
		if (json.navTabId){
			navTab.reload(json.forwardUrl, {navTabId: json.navTabId});
		} else {
			var $pagerForm = $("#pagerForm", navTab.getCurrentPanel());
			var args = $pagerForm.size()>0 ? $pagerForm.serializeArray() : {}
			navTabPageBreak(args, json.rel);
		}
		if ("closeCurrent" == json.callbackType) {
			$.pdialog.closeCurrent();
		}
	}
}
	
	function GetRoute(){
	AMapUI.load([ 'ui/misc/PathSimplifier', 'lib/$' ], function(PathSimplifier,
			$) {
		if (!PathSimplifier.supportCanvas) {
			alert('当前环境不支持 Canvas！');
			return;
		}

		var pathSimplifierIns = new PathSimplifier({
			zIndex : 100,
			//autoSetFitView:false,
			map : map, //所属的地图实例

			getPath : function(pathData, pathIndex) {

				return pathData.path;
			},
			getHoverTitle : function(pathData, pathIndex, pointIndex) {

				if (pointIndex >= 0) {
					//point 
					return pathData.name + '，点：' + pointIndex + '/'
							+ pathData.path.length;
				}

				return pathData.name + '，点数量' + pathData.path.length;
			},
			renderOptions : {

				renderAllPointsIfNumberBelow : 100
			//绘制路线节点，如不需要可设置为-1
			}
		});

		window.pathSimplifierIns = pathSimplifierIns;

		//设置数据
		var data = JSON.parse(jsonp);
		console.log(data);

		pathSimplifierIns.setData(data);

		//对第一条线路（即索引 0）创建一个巡航器
		var navg1 = pathSimplifierIns.createPathNavigator(0, {
			loop : true, //循环播放
			speed : 500,//巡航速度，单位千米/小时
		    autoRotation: true,
			pathNavigatorStyle : {
				width : 26,
				height : 50,
				//使用图片
				content : PathSimplifier.Render.Canvas.getImageContent('./images/car.png', onload, onerror),
				strokeStyle : null,
				fillStyle : null,
			//经过路径的样式
			/* pathLinePassedStyle: {
			    lineWidth: 6,
			    strokeStyle: null,
			    dirArrowStyle: {
			        stepSpace: 15,
			        strokeStyle: 'blue'
			    }
			} */
			}
		});

		navg1.start();

		function onload() {
			pathSimplifierIns.renderLater();
		}

		function onerror(e) {
			alert('图片加载失败！');
		}

	});
	}
	
 	var lng = '${lng}';
	var lat = '${lat}';

	var map = new AMap.Map('Amap', {
		resizeEnable : true,//鼠标滚动大小
		zoom : 10,
		center : new AMap.LngLat(lng, lat)
	}); 
</script>
