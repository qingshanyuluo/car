
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="S" %>
<style>
  .fontCSS2 {
    font-family: "黑体";
	font-size: 20px;
	color:#000000;
	vertical-align:middle;
	text-align:center;
}
  </style>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="CarStatus" method="post" onreset="$(this).find('select.combox').comboxReset()">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td> 
					VIN码：<input type="text" name="C_VIN" />
				<input type="hidden" name="numPerPage" value="${param.numPerPage}" /> 
							
				</td>
			
			</tr>
		</table>
		<div class="subBar">
			<ul>
				<li><div class="button"><div class="buttonContent"><button type="reset">重置</button></div></div></li>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>
 <body>
<form >
<br>
<div class="fontCSS2">车辆数据统计</div><br>
<div id="pageContent" class="pageContent">
<center>
<table id="content_table" width="98%" targetType="navTab" layoutH="116">
  <tr>
    <td width="2%" height="1">&nbsp;</td>
    <td width="97%">&nbsp;</td>
    <td width="1%" >&nbsp;</td>
  </tr>

  <tr>
    <td height="30">&nbsp;</td>
    <td  valign="top"  bgcolor="#FFFFFF" class="fontCSS3"><font color="#004471">&nbsp;电压分布情况</font></td>
    <td>&nbsp;</td>
  </tr>
    <tr>
    <td height="16">&nbsp;</td>
    <td  valign="top" bgcolor="#FFFFFF">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td height="25">&nbsp;</td>
    <td  align="letf"  bgcolor="#FFFFFF"><div id="M_Voltage_Chart" style="width:500px;height:300px; "></div></td>
    <td  align="right"  bgcolor="#FFFFFF"><div id="B_Voltage_Chart" style="width:500px;height:300px;"></div></td>
    <td>&nbsp;</td>
  </tr>
 
  
    <tr>
    <td height="30">&nbsp;</td>
    <td  valign="top"  bgcolor="#FFFFFF" class="fontCSS3"><font color="#004471">&nbsp;车辆数据上传信息日统计</font></td>
    <td>&nbsp;</td>
  </tr>
    <tr>
    <td height="16">&nbsp;</td>
    <td  valign="top" bgcolor="#FFFFFF">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td height="25">&nbsp;</td>
    <td  align="letf"  bgcolor="#FFFFFF"><div id="M_Data_Chart" style="width:500px;height:300px; "></div></td>
    <td  align="right"  bgcolor="#FFFFFF"><div id="B_Data_Chart" style="width:500px;height:300px;"></div></td>
    <td>&nbsp;</td>
  </tr>
  
  
   <tr>
    <td height="30">&nbsp;</td>
    <td  valign="top"  bgcolor="#FFFFFF" class="fontCSS3"><font color="#004471">&nbsp;车辆电压电流统计</font></td>
    <td>&nbsp;</td>
  </tr>
    <tr>
    <td height="16">&nbsp;</td>
    <td  valign="top" bgcolor="#FFFFFF">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td height="25">&nbsp;</td>
    <td  align="letf"  bgcolor="#FFFFFF"><div id="M_VB_Chart" style="width:500px;height:300px; "></div></td>
    <td  align="right"  bgcolor="#FFFFFF"><div id="B_VB_Chart" style="width:500px;height:300px;"></div></td>
    <td>&nbsp;</td>
  </tr>
  
  
  
   <tr>
    <td height="30">&nbsp;</td>
    <td  valign="top"  bgcolor="#FFFFFF" class="fontCSS3"><font color="#004471">&nbsp;动态参数统计</font></td>
    <td>&nbsp;</td>
  </tr>
    <tr>
    <td height="16">&nbsp;</td>
    <td  valign="top" bgcolor="#FFFFFF">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td height="25">&nbsp;</td>
    <td  align="left"  bgcolor="#FFFFFF"><div id="demo1Chart" style="width:500px;height:300px;"></div></td>
    <td  align="right"  bgcolor="#FFFFFF"><div id="demo2Chart" style="width:500px;height:300px;"></div></td>
    <td>&nbsp;</td>
  </tr>
 
 
 
</table>
</center>
</div>
<script type="text/javascript">
	  setTimeout("M_VoltageChart()",500);//电机电压统计	
	  setTimeout("B_VoltageChart()",500);//电池电压统计
	  setTimeout("M_DataChart()",500);//电机上传数据日统计
	  setTimeout("B_DataChart()",500);//电磁上传数据日统计
	  setTimeout("M_VbChart()",500);//电机电压电流日统计
	  setTimeout("B_VbChart()",500);//电池电压电流日统计
	  
	
	  setTimeout("demo1chart()",500);
	   setTimeout("demo2chart()",500);
	   
	   
	   /*============电机电压分布===================================================================  */
	  function M_VoltageChart(){
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('M_Voltage_Chart'));


        // 指定图表的配置项和数据
      
	option = {
			title : {
				text : '电机一天电压分布',
				subtext : '纯属虚构'
			},
			tooltip : {
				trigger : 'axis',
				axisPointer : {
					type : 'cross'
				}
			},
			toolbox : {
				show : true,
				feature : {
					saveAsImage : {}
				}
			},
			xAxis : {
				type : 'category',
				boundaryGap : false,
				data : [ '00:00', '01:15', '02:30', '03:45', '05:00', '06:15',
						'07:30', '08:45', '10:00', '11:15', '12:30', '13:45',
						'15:00', '16:15', '17:30', '18:45', '20:00', '21:15',
						'22:30', '23:45' ]
			},
			yAxis : {
				type : 'value',
				axisLabel : {
					formatter : '{value} V'
				},
				axisPointer : {
					snap : true
				}
			},
			visualMap : {
				show : false,
				dimension : 0,
				pieces : [ {
					lte : 6,
					color : 'green'
				}, {
					gt : 6,
					lte : 8,
					color : 'red'
				}, {
					gt : 8,
					lte : 14,
					color : 'green'
				}, {
					gt : 14,
					lte : 17,
					color : 'red'
				}, {
					gt : 17,
					color : 'green'
				} ]
			},
			series : [ {
				name : '电机电压值',
				type : 'line',
				smooth : true,
				data : [ 0,1.0,2.2,3.3,4.4,5.5,6.6,7.7,6.6,5.5,4.4,3.3,2.2,2.2,3.2,3.2,3.2,3.2,3.2,3.5,2.0],
				markArea : {
					data : [ [ {
						name : '早高峰',
						xAxis : '07:30'
					}, {
						xAxis : '10:00'
					} ], [ {
						name : '晚高峰',
						xAxis : '17:30'
					}, {
						xAxis : '21:15'
					} ] ]
				}
			} ]
		};

		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	}
	/*============电池电压分布===========================================================  */
	function B_VoltageChart(){
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('B_Voltage_Chart'));


        // 指定图表的配置项和数据
      
	option = {
			title : {
				text : '电池一天电压分布',
				subtext : '纯属虚构'
			},
			tooltip : {
				trigger : 'axis',
				axisPointer : {
					type : 'cross'
				}
			},
			toolbox : {
				show : true,
				feature : {
					saveAsImage : {}
				}
			},
			xAxis : {
				type : 'category',
				boundaryGap : false,
				data : [ '00:00', '01:15', '02:30', '03:45', '05:00', '06:15',
						'07:30', '08:45', '10:00', '11:15', '12:30', '13:45',
						'15:00', '16:15', '17:30', '18:45', '20:00', '21:15',
						'22:30', '23:45' ]
			},
			yAxis : {
				type : 'value',
				axisLabel : {
					formatter : '{value} V'
				},
				axisPointer : {
					snap : true
				}
			},
			visualMap : {
				show : false,
				dimension : 0,
				pieces : [ {
					lte : 6,
					color : 'green'
				}, {
					gt : 6,
					lte : 8,
					color : 'red'
				}, {
					gt : 8,
					lte : 14,
					color : 'green'
				}, {
					gt : 14,
					lte : 17,
					color : 'red'
				}, {
					gt : 17,
					color : 'green'
				} ]
			},
			series : [ {
				name : '电池电压值',
				type : 'line',
				smooth : true,
					data : [ 0,1.0,2.2,3.3,4.4,5.5,6.6,7.7,6.6,5.5,4.4,3.3,2.2,2.2,3.2,3.2,3.2,3.2,3.2,3.5,2.0],
				markArea : {
					data : [ [ {
						name : '早高峰',
						xAxis : '07:30'
					}, {
						xAxis : '10:00'
					} ], [ {
						name : '晚高峰',
						xAxis : '17:30'
					}, {
						xAxis : '21:15'
					} ] ]
				}
			} ]
		};

		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	}
	
	/*=================电机上传数据日统计=========================================================================  */
	function M_DataChart() {
		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById('M_Data_Chart'));

		// 指定图表的配置项和数据
		var option = {

			tooltip : {},
			legend : {
				data : [ '电机上传数据统计' ]
			},
			xAxis : {
				data : [ "2018.4.1", "2018.4.2", "2018.4.3", "2018.4.4", "2018.4.5", "2018.4.6", "2018.4.7", "2018.4.8", "2018.4.9", "2018.4.10" ]
			},
			yAxis : {},
			series : [ {
				name : '电机上传数据统计',
				type : 'bar',
				data : [ 5, 20, 36, 10, 10, 20, 20, 36, 10, 10]
			} ]
		};

		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	}
	
	
	/*=================电池上传数据日统计=========================================================================  */
	function B_DataChart() {
		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById('B_Data_Chart'));

		// 指定图表的配置项和数据
		var option = {

			tooltip : {},
			legend : {
				data : [ '电池上传数据统计' ]
			},
			xAxis : {
				data : [ "2018.4.1", "2018.4.2", "2018.4.3", "2018.4.4", "2018.4.5", "2018.4.6", "2018.4.7", "2018.4.8", "2018.4.9", "2018.4.10" ]
			},
			yAxis : {},
			series : [ {
				name : '电池上传数据统计',
				type : 'bar',
				data : [ 5, 20, 36, 10, 10, 20, 20, 36, 10, 10 ]
			} ]
		};

		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	}
	/*============================电机电压电流日统计===============================================  */
	function M_VbChart() {
		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById('M_VB_Chart'));

		// 指定图表的配置项和数据
	var colors = ['#5793f3', '#d14a61', '#675bba'];


option = {
    color: colors,
     title : {
				text : '电压对比',
				
			},
    tooltip: {
        trigger: 'none',
        axisPointer: {
            type: 'cross'
        }
    },
    legend: {
        data:['电机电压', '电池电压']
    },
    grid: {
        top: 70,
        bottom: 50
    },
    xAxis: [
        {
            type: 'category',
            axisTick: {
                alignWithLabel: true
            },
            axisLine: {
                onZero: false,
                lineStyle: {
                    color: colors[1]
                }
            },
            axisPointer: {
                label: {
                    formatter: function (params) {
                        return '电压值  ' + params.value
                            + (params.seriesData.length ? '：' + params.seriesData[0].data : '');
                    }
                }
            },
            data: ["2016-1", "2016-2", "2016-3", "2016-4", "2016-5", "2016-6", "2016-7", "2016-8", "2016-9", "2016-10", "2016-11", "2016-12"]
        },
        {
            type: 'category',
            axisTick: {
                alignWithLabel: true
            },
            axisLine: {
                onZero: false,
                lineStyle: {
                    color: colors[0]
                }
            },
            axisPointer: {
                label: {
                    formatter: function (params) {
                        return '电压值  ' + params.value
                            + (params.seriesData.length ? '：' + params.seriesData[0].data : '');
                    }
                }
            },
            data: ["2016-1", "2016-2", "2016-3", "2016-4", "2016-5", "2016-6", "2016-7", "2016-8", "2016-9", "2016-10", "2016-11", "2016-12"]
        }
    ],
    yAxis: [
        {
            type: 'value'
        }
    ],
    series: [
        {
            name:'电机电压',
            type:'line',
            xAxisIndex: 1,
            smooth: true,
            data: [1.1, 2.2, 3.3, 4.4, 5.7, 6.7, 5.6, 4.2, 3.7, 2.8, 1.0, 7.3]
        },
        {
            name:'电池电压',
            type:'line',
            smooth: true,
            data: [7.9, 6.9, 5.1, 4.7, 3.3, 2.2, 1.6, 0.6, 5.4, 1.4, 3.3, 6.7]
        }
    ]
};


		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	}
	
	/*============================电池电压电流日统计===============================================  */
	function B_VbChart() {
		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById('B_VB_Chart'));

		// 指定图表的配置项和数据
	var colors = ['#5793f3', '#d14a61', '#675bba'];


option = {
    color: colors,
     title : {
				text : '电流对比',
				
			},
    tooltip: {
        trigger: 'none',
        axisPointer: {
            type: 'cross'
        }
    },
    legend: {
        data:['电机电流', '电池电流']
    },
    grid: {
        top: 70,
        bottom: 50
    },
    xAxis: [
        {
            type: 'category',
            axisTick: {
                alignWithLabel: true
            },
            axisLine: {
                onZero: false,
                lineStyle: {
                    color: colors[1]
                }
            },
            axisPointer: {
                label: {
                    formatter: function (params) {
                        return '电压值  ' + params.value
                            + (params.seriesData.length ? '：' + params.seriesData[0].data : '');
                    }
                }
            },
            data: ["2016-1", "2016-2", "2016-3", "2016-4", "2016-5", "2016-6", "2016-7", "2016-8", "2016-9", "2016-10", "2016-11", "2016-12"]
        },
        {
            type: 'category',
            axisTick: {
                alignWithLabel: true
            },
            axisLine: {
                onZero: false,
                lineStyle: {
                    color: colors[0]
                }
            },
            axisPointer: {
                label: {
                    formatter: function (params) {
                        return '电压值  ' + params.value
                            + (params.seriesData.length ? '：' + params.seriesData[0].data : '');
                    }
                }
            },
            data: ["2016-1", "2016-2", "2016-3", "2016-4", "2016-5", "2016-6", "2016-7", "2016-8", "2016-9", "2016-10", "2016-11", "2016-12"]
        }
    ],
    yAxis: [
        {
            type: 'value'
        }
    ],
    series: [
        {
            name:'电机电流',
            type:'line',
            xAxisIndex: 1,
            smooth: true,
            data: [1.1, 2.2, 3.3, 4.4, 5.7, 6.7, 5.6, 4.2, 3.7, 2.8, 1.0, 7.3]
        },
        {
            name:'电池电流',
            type:'line',
            smooth: true,
            data: [7.9, 6.9, 5.1, 4.7, 3.3, 2.2, 1.6, 0.6, 5.4, 1.4, 3.3, 6.7]
        }
    ]
};


		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	}
	/*=======================================================================================================  */
	
	function demo1chart() {
		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById('demo1Chart'));

		// 指定图表的配置项和数据
        function randomData() {
    now = new Date(+now + oneDay);
    value = value + Math.random() * 21 - 10;
    return {
        name: now.toString(),
        value: [
            [now.getFullYear(), now.getMonth() + 1, now.getDate()].join('/'),
            Math.round(value)
        ]
    }
}

var data = [];
var now = +new Date(1997, 9, 3);
var oneDay = 24 * 3600 * 1000;
var value = Math.random() * 1000;
for (var i = 0; i < 1000; i++) {
    data.push(randomData());
}

option = {
    title: {
        text: '动态数据 + 时间坐标轴'
    },
    tooltip: {
        trigger: 'axis',
        formatter: function (params) {
            params = params[0];
            var date = new Date(params.name);
            return date.getDate() + '/' + (date.getMonth() + 1) + '/' + date.getFullYear() + ' : ' + params.value[1];
        },
        axisPointer: {
            animation: false
        }
    },
    xAxis: {
        type: 'time',
        splitLine: {
            show: false
        }
    },
    yAxis: {
        type: 'value',
        boundaryGap: [0, '100%'],
        splitLine: {
            show: false
        }
    },
    series: [{
        name: '模拟数据',
        type: 'line',
        showSymbol: false,
        hoverAnimation: false,
        data: data
    }]
};

setInterval(function () {

    for (var i = 0; i < 5; i++) {
        data.shift();
        data.push(randomData());
    }

    myChart.setOption({
        series: [{
            data: data
        }]
    });
}, 1000);

		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	}
	/*===========================================================================  */
		function demo2chart() {
		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById('demo2Chart'));

		// 指定图表的配置项和数据
        function randomData() {
    now = new Date(+now + oneDay);
    value = value + Math.random() * 21 - 10;
    return {
        name: now.toString(),
        value: [
            [now.getFullYear(), now.getMonth() + 1, now.getDate()].join('/'),
            Math.round(value)
        ]
    }
}

var data = [];
var now = +new Date(1997, 9, 3);
var oneDay = 24 * 3600 * 1000;
var value = Math.random() * 1000;
for (var i = 0; i < 1000; i++) {
    data.push(randomData());
}

option = {
    title: {
        text: '动态数据 + 时间坐标轴'
    },
    tooltip: {
        trigger: 'axis',
        formatter: function (params) {
            params = params[0];
            var date = new Date(params.name);
            return date.getDate() + '/' + (date.getMonth() + 1) + '/' + date.getFullYear() + ' : ' + params.value[1];
        },
        axisPointer: {
            animation: false
        }
    },
    xAxis: {
        type: 'time',
        splitLine: {
            show: false
        }
    },
    yAxis: {
        type: 'value',
        boundaryGap: [0, '100%'],
        splitLine: {
            show: false
        }
    },
    series: [{
        name: '模拟数据',
        type: 'line',
        showSymbol: false,
        hoverAnimation: false,
        data: data
    }]
};

setInterval(function () {

    for (var i = 0; i < 5; i++) {
        data.shift();
        data.push(randomData());
    }

    myChart.setOption({
        series: [{
            data: data
        }]
    });
}, 1000);

		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	}
</script>
 <br>
             
</form>
  </body>
