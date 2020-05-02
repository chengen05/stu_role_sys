<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--360浏览器优先以webkit内核解析-->
    <title>若依介绍</title>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css"  rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/font-awesome.min.css"  rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/main/animate.min.css"  rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/main/style.min862f.css"  rel="stylesheet"/>
</head>

<body class="gray-bg">
    <div class="row  border-bottom white-bg dashboard-header">
        <div class="col-sm-12">
            <blockquote class="text-warning" style="font-size:14px">
                                           领取阿里云通用云产品1888优惠券
                <br><a target="_blank" href="https://promotion.aliyun.com/ntms/yunparter/invite.html?userCode=brki8iof">https://promotion.aliyun.com/ntms/yunparter/invite.html?userCode=brki8iof</a><br>
                                           领取腾讯云通用云产品2860优惠券
                <br><a target="_blank" href="https://cloud.tencent.com/redirect.php?redirect=1025&cps_key=198c8df2ed259157187173bc7f4f32fd&from=console">https://cloud.tencent.com/redirect.php?redirect=1025&cps_key=198c8df2ed259157187173bc7f4f32fd&from=console</a><br>
                                           阿里云Hi拼购 限量爆款 低至199元/年
                <br><a target="_blank" href="https://www.aliyun.com/acts/hi-group-buying?userCode=brki8iof">https://www.aliyun.com/acts/hi-group-buying?userCode=brki8iof</a>
                <h4 class="text-danger">云产品通用红包，可叠加官网常规优惠使用。(仅限新用户)</h4>
            </blockquote>

            <hr>
        </div>
        <div class="col-sm-3">
            <h2>Hello,Guest</h2>
            <small>移动设备访问请扫描以下二维码：</small>
            <br>
            <br>
            <img src="/img/qr_code.png" width="100%" style="max-width:264px;">
            <br>
        </div>
        <div class="col-sm-5">
            <h2>若依后台管理框架</h2>
            <p>一直想做一款后台管理系统，看了很多优秀的开源项目但是发现没有合适自己的。于是利用空闲休息时间开始自己写一套后台系统。如此有了若依管理系统。，她可以用于所有的Web应用程序，如<b>网站管理后台</b>，<b>网站会员中心</b>，<b>CMS</b>，<b>CRM</b>，<b>OA</b>等等，当然，您也可以对她进行深度定制，以做出更强系统。所有前端后台代码封装过后十分精简易上手，出错概率低。同时支持移动客户端访问。系统会陆续更新一些实用功能。</p>
            <p>
                <b>当前版本：</b><span>v[[${version}]]</span>
            </p>
            <p>
                <span class="label label-warning">&yen;免费开源</span>
            </p>
            <br>
          
        </div>
        <div class="col-sm-4">
            <h4>技术选型：</h4>
            <ol>
                <li>核心框架：Spring Boot。</li>
                <li>安全框架：Apache Shiro。</li>
                <li>模板引擎：Thymeleaf。</li>
                <li>持久层框架：MyBatis。</li>
				<li>定时任务:Quartz。</li>
                <li>数据库连接池：Druid。</li>
                <li>工具类：Fastjson。</li>
                <li>更多……</li>
            </ol>
        </div>

    </div>
    <div class="wrapper wrapper-content">
        <div class="row">
            <div class="col-sm-4">

                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>联系信息</h5>

                    </div>
                    <div class="ibox-content">
                        <p><i class="fa fa-qq"></i> QQ群：<s>满1389287</s> <s>满1679294</s> <s>满1529866</s> <s>满1772718</s> <s>满1366522</s> <a href="https://jq.qq.com/?_wv=1027&k=5Ofd4Pb" target="_blank">1382251</a>
                        </p>
                        <p><i class="fa fa-weixin"></i> 微信：<a href="javascript:;">/ *若依</a>
                        </p>
                        <p><i class="fa fa-credit-card"></i> 支付宝：<a href="javascript:;" class="支付宝信息">/ *若依</a>
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>更新日志</h5>
                    </div>
                    <div class="ibox-content no-padding">
                        <div class="panel-body">
                            <div class="panel-group" id="version">
							<div class="panel panel-default">
								<div class="panel-heading">
								   <h5 class="panel-title">
									   <a data-toggle="collapse" data-parent="#version" href="#v30">v3.0.0</a><code class="pull-right">2018.10.08</code>
								   </h5>
								</div>
								<div id="v30" class="panel-collapse collapse">
									<div class="panel-body">
									   <ol>
											<li>升级poi到最新版3.17</li>
											<li>导出修改临时目录绝对路径</li>
											<li>升级laydate到最新版5.0.9</li>
											<li>升级SpringBoot到最新版本2.0.5</li>
											<li>优化开始/结束时间校验限制</li>
											<li>重置密码参数表中获取默认值</li>
											<li>修复头像修改显示问题</li>
											<li>新增数据权限过滤注解</li>
											<li>新增表格检索折叠按钮</li>
											<li>新增清空（登录、操作、调度）日志</li>
											<li>固定按钮位置（提交/关闭）</li>
											<li>部门/菜单支持（展开/折叠）</li>
											<li>部分细节调整优化</li>
											<li>项目采用分模块</li>
										</ol>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
									<div class="panel-heading">
									   <h5 class="panel-title">
										   <a data-toggle="collapse" data-parent="#version" href="#v20">v2.0.0</a><code class="pull-right">2018.07.02</code>
									   </h5>
									</div>
									<div id="v20" class="panel-collapse collapse">
										<div class="panel-body">
										   <ol>
										        <li>升级SpringBoot到最新版本2.0.3</li>
										        <li>新增公告管理</li>
												<li>表单校验示提体验优化</li>
												<li>前端通用方法封装调整</li>
												<li>前端去除js文件，合并到html</li>
												<li>操作加载遮罩层</li>
												<li>支持全屏模式操作</li>
												<li>支持注解导出数据</li>
												<li>系统支持多查询&下载</li>
												<li>系统样式调整</li>
											</ol>
										</div>
									</div>
								</div>
                                <div class="panel panel-default">
									<div class="panel-heading">
									   <h5 class="panel-title">
										   <a data-toggle="collapse" data-parent="#version" href="#v16">v1.1.6</a><code class="pull-right">2018.06.04</code>
									   </h5>
									</div>
									<div id="v16" class="panel-collapse collapse">
										<div class="panel-body">
										   <ol>
												<li>新增用户列表部门列</li>
												<li>新增登录地点</li>
												<li>新增swagger</li>
												<li>修复排序数字校验</li>
												<li>优化头像上传文件类型限定为图片</li>
												<li>新增XSS过滤</li>
												<li>新增热部署提高开发效率</li>
												<li>修复treegrid居中无效</li>
												<li>角色多条件查询</li>
											</ol>
										</div>
									</div>
								</div>
								 <div class="panel panel-default">
									<div class="panel-heading">
                                        <h5 class="panel-title">
											<a data-toggle="collapse" data-parent="#version" href="#v09">v1.0.9</a><code class="pull-right">2018.04.14</code>
										</h5>
                                    </div>
                                    <div id="v09" class="panel-collapse collapse">
                                        <div class="panel-body">
                                            <ol>
                                            	<li>新增代码生成(生成包括 java、html、js、xml、sql)</li>
												<li>新增按钮权限控制隐藏(若依首创)</li>
                                            </ol>
                                        </div>
                                    </div>
                                </div>
						
                        
                            </div>
                        </div>
                    </div>
                </div>
            </div>
           
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/ajax/libs/layer/layer.min.js"></script>
    <script type="text/javascript">
	    $('#pay-qrcode').click(function(){
	        var html=$(this).html();
	        parent.layer.open({
	            title: false,
	            type: 1,
	            closeBtn:false,
	            shadeClose:true,
	            area: ['600px', 'auto'],
	            content: html
	        });
	    });
    </script>
</body>
</html>
