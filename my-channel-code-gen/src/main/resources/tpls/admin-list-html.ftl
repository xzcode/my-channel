<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<!-- ${author} - ${.now?string("yyyy-MM-dd HH:mm:ss")} -->
<head>
<#noparse>
<title th:text="#{app.title}">管理系统</title>
</#noparse>

	<meta th:include="common :: head_common" th:remove="tag"></meta>
	
	<style th:include="common :: css_common" th:remove="tag"></style>
	
	<script th:include="common :: script_common" th:remove="tag"></script>
	
</head>
<body th:with="baseReqPath='/${packageModelName}/${entityClassName?lower_case}'">


	<ol class="breadcrumb">
	  <li>${modelNameCn}管理</li>
	  <li>${modelNameCn}列表</li>
	</ol>
	
    
    <div class="panel panel" style="margin-bottom: 5px;">
   	  <div class="panel-heading">
	         筛选条件
	  </div>
	  <div class="panel-body">
	    <form class="form-inline search-form" onsubmit="return false">
		  <div class="form-group ">
		    <label for="keyword">搜索:</label>
		    <input type="text" class="form-control" id="keyword" name="keyword" placeholder="搜索关键字"/>
		  </div>
		  <div class="form-group " style="display: none;">
		    <label for="keyword">隐藏字段:</label>
		    
		  </div>
		  
	      
		  <!--
		  <#list tableInfo.columns as col>  
		  <#if ( col.columnComment ?? && col.columnComment.enumProperties??)>
		  <div class="form-group ">
		    <label for="${col.propertyName}" class="col-sm-1"><#if col.columnComment??> ${col.columnComment.clearComment} <#else> ${col.comment} </#if>: </label>
		    <select class="form-control" name="${col.propertyName}" id="${col.propertyName}" >
			  	<option value="">全部</option>
			  	<#list col.columnComment.enumProperties as item>  
		      	<option th:selected="${"${"}${col.propertyName} == ${item.value} ${"}"}" value="${item.value}">${item.desc}</option>
		      	</#list>
			</select>
		  </div>
		  </#if>
	      </#list>
		  -->
		  
		  <button type="button" class="btn btn-primary search-btn"><i class="icon icon-search"></i> 搜索</button>
		  <button type="button" class="btn reset-btn"> 重置</button>
		</form>
	  </div>
	</div>
	
	
	
	<div class="panel panel" style="margin-bottom: 5px;">
	  <div class="panel-body">
		  <a type="button" th:href="@${"{"}|${"${"}baseReqPath${"}"}/view/add|${"}"}" class="btn btn-primary">
		  <i class="icon icon-plus-sign" style="vertical-align: middle;"></i>
		  	添加
		  </a>
	  </div>
	</div>
	
	<div style="padding: 10px;" class="dataTables_wrapper">
	
		<table id="data_table" class="display" style="width:100%;"></table>

	</div>
	

<script type="text/javascript" th:inline="javascript">
<#noparse>
//Thymeleaf内联区
var baseReqPath = [[${baseReqPath}]];
</#noparse>
</script>

<script type="text/javascript" th:inline="none">
	
	
	
	var dataTableUrl = baseReqPath + '/ajax/list';
    
    var table = 
   	DataTableErrorHandle($('#data_table'))
    .DataTable(
    		DataTableOperation.initDatatablesOptions({
    			ajax: function (data, callback, settings) {
    				DataTableOperation.datatableAjax(dataTableUrl, data, callback);
    			},
    		   stateSave: true,//是否保存当前表状态
        	   order: [[ 0, 'desc' ]],//默认排序
               columns : [
                   {//id列，默认隐藏
                	   title: "uid",//表头标题
                       data:"uid", //数据对应key
                       name : "uid", //对应字段名称
                       visible: false, //是否可视
                       orderable: true, //是否可排序
                       render : function(data, type, row) { //渲染单元格
                           return data;
                       },
                   },
                   {//序号列
                	   title: "#", 
                       width: 30,
                       visible: true, 
                       orderable: false,
                       render : function(data, type, row, meta) { //渲染单元格
                    	   //console.log(meta)
                    	   return meta.row + 1 + meta.settings._iDisplayStart;
                       },
                   },
                   <#list tableInfo.columns as col>  
                   <#if col.name != 'uid'>
           		   {
           		   
           		    <#if col.name == 'user_id'>
           		       title: "用户名",
           		    <#elseif col.name == 'user_id'>
           		       title: "管理员",
           			<#elseif (col.comment?? && col.columnComment?? )> 
					   title: "${col.columnComment.clearComment}", 
					<#else> 
					   title: "[空列名]",
					</#if>
					
					<#if col.name == 'user_id'>
					   data:"username", 
                       name : "username",
					<#elseif col.name == 'admin_id'>
					   data:"adminName", 
                       name : "adminName",
					<#else>
					   data:"${col.propertyName}", 
                       name : "${col.propertyName}",
					</#if>
                       visible: true,                       
                       width: 100,
                       orderable: false,
                       //responsivePriority: 1,
                       render : function(data, type, row, meta) {
					<#if col.name == idName>
						
					<#elseif col.javaType?contains('Date')>
                           return Util.longToDateTime(data);
						<#elseif col.name?starts_with('is_')>
							if(data == 1){
                    		   return `<span class="label label-badge label-success">是</span>`
                    	   }
                           return `<span class="label label-badge label-danger">否</span>`;
						<#elseif col.name?ends_with('url') || col.name?ends_with('picture')|| col.name?ends_with('avatar')>
							<#noparse>
							if(!data || data == ''){
                    		   return '';
                    	    }
							return `
                      		<a href="${Util.emptyDefault(data, 'javascript:;')}" target="_blank">
                      			<img src="${Util.getMiniPic(data)}" style="width:50px; height:50px; object-fit: contain;" class=""/>
                      		</a>
                      		`;
                      		</#noparse>
						<#elseif col.name?ends_with("price") || col.name?ends_with("amount") || col.name?ends_with("balance") || col.name?ends_with("offer")>
							return data && Util.toYuan(data) || '';
						<#elseif (col.columnComment?? && col.columnComment.enumProperties??)>
							
					      	
					      	<#if col.name == "enabled">
					      	return `
					      		${'${'}!(data === 0)?"":`<span class="label label-badge label-danger" >禁用</span>`${'}'}
					      		${'${'}!(data === 1)?"":`<span class="label label-badge label-success" >启用</span>`${'}'}
					      	`;
					      	
					      	<#else>
					      	return `
				      	  	<#list col.columnComment.enumProperties as enum>  
					      		<#-- <span class="label label-badge label-" th:if="${"${"}item.${col.propertyName} == ${enum.value}${"}"}" th:text="${enum.desc}"></span> -->
					      		${'${'}!(data === ${enum.value})?"":`<span class="label label-badge label-info" >${enum.desc}</span>`${'}'}
					      	</#list>
					      	`;
					      	</#if>
					      	
					      	
						<#else>
							return data;
						</#if>
						},
                   },
                   
                   </#if>
					</#list>
                   
                   {
                	   title: "操作",
                       data:"uid", 
                       name : "uid",
                       width: 100,
                       visible: true,
                       responsivePriority: 1,
                       orderable: false,
                       render : function(data, type, row) {
                    	   return `
	                           ${'${'}!true ? '' : `<a class="btn btn-mini btn-primary" href="${'${'}baseReqPath${'}'}/view/edit?uid=${'${'}row.uid${'}'}">编辑</a>`${'}'}
	                           <br/>
	                           <#if hasEnabled>
	                           ${'${'}!row.enabled == 1  ? '' : `<a class="btn btn-mini btn-danger " onclick="clickToUpdateStatus(this)" data-uid="${'${'}row.uid${'}'}"  data-value="0"  data-url="${'${'}baseReqPath${'}'}/ajax/delete">禁用</a>`${'}'}
	                           ${'${'}!row.enabled == 0  ? '' : `<a class="btn btn-mini btn-success " onclick="clickToUpdateStatus(this)" data-uid="${'${'}row.uid${'}'}"  data-value="1"  data-url="${'${'}baseReqPath${'}'}/ajax/delete">启用</a>`${'}'}
	                           <br/>
	                           </#if>
                           `
                       },
                       
                   },
                ]
           			
           })
           );
    
    
    $('.search-btn').click(function(){
    	table.draw();
    })
    
    //清除数据表记录
    $('.reset-btn').click(function() {
    	$('input').val('');
    	table.state.clear();
    	window.location.reload();
    })
    
    //搜索框下，按下ESC触发清除搜索框
    $("#keyword").keydown(function(event){
    	
    	if(event.keyCode == 13 ){ //enter
    		$(".search-btn").click();
    	}else if(event.keyCode == 27 ){//esc
       		$("#keyword").val('');
       	}
    	
	});
    
           
</script>

<#noparse>
</#noparse>

</body>
</html>