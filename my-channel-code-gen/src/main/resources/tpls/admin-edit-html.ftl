<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<!-- ${author} - ${.now?string("yyyy-MM-dd HH:mm:ss")} -->
<head>
<title>网站后台管理系统</title>
<meta charset="utf-8" />
	<meta th:include="common :: head_common" th:remove="tag"></meta>
	
	<style th:include="common :: css_common" th:remove="tag"></style>
	
	<script th:include="common :: script_common" th:remove="tag"></script>

</head>
<body  th:with="baseReqPath='/${packageModelName}/${entityClassName?lower_case}'">
	<ol class="breadcrumb">
	  <li>${modelNameCn}管理</li>
	  <li>${modelNameCn}列表</li>
	  <li>编辑</li>
	</ol>
	
	<form class="form-horizontal edit-form" th:action="${"@{"}|${"${"}baseReqPath${"}"}/ajax/edit/save|}">
		
		
	<#list tableInfo.columns as col>  

	<#assign requiredItem = (!col.nullable)?string("required=\"required\"" , "")>
	<#assign insertId = "id=\"" + col.propertyName + "\"">
	<#assign insertName = "name=\"" + col.propertyName + "\"">
	<#assign maxlength = "maxlength=\"" + (col.length == 0)?string("", col.length?string("#")) + "\"">
	   			
	<#assign insertCommon = insertId + " " + insertName + " " + " " + requiredItem + " " + maxlength>
	
	<#assign insertCommon_1 = insertId + " " + insertName + " " + " " + requiredItem>
	
	<#assign insertValue = "th:value=\""+ "${" +"editObj." + col.propertyName + "}\"">
	
	<#assign dateValue = "th:value="+ "\"${" +"editObj." + col.propertyName + " != null ? #dates.format(editObj. "+ col.propertyName +", 'yyyy-MM-dd HH:mm:ss') : ''}\"">
	
	<#if col.name != 'xxxxx'>

	<div class="form-group ${(col.name == idName)?string("hide" , "")}">
		<label for="${col.propertyName}" class="col-sm-1"><#if col.columnComment??> ${col.columnComment.clearComment} <#else> ${col.comment} </#if>: </label>
		<div class="col-md-4 col-sm-10">
		  
	      <#if col.name?starts_with('is_')>
		    <select class="form-control" ${insertCommon} >
		     <option th:selected="${"${"}editObj.${col.propertyName} == 0 ${"}"}" value="0">否</option>
		     <option th:selected="${"${"}editObj.${col.propertyName} == 1 ${"}"}" value="1">是</option>
		    </select>
		    
	     <#elseif col.name == 'user_id'>
	     <#noparse>
	       <input type="text" disabled="disabled" class="form-control" id="username" th:value="${editObj.username}"/>
	     </#noparse>
	     <#elseif col.name == 'admin_id'>
	     
	     <#noparse>
	       <input type="text" disabled="disabled" class="form-control" id="adminName" th:value="${editObj.adminName}"/>
	     </#noparse>
	     
	     <#elseif ( col.columnComment ?? && col.columnComment.enumProperties??)>
	      	  <select ${insertCommon} class="form-control">
	      	  	<#list col.columnComment.enumProperties as item>  
		      	<option th:selected="${"${"}editObj.${col.propertyName} == ${item.value} ${"}"}" value="${item.value}">${item.desc}</option>
		      	</#list>
		      </select>
	      <#elseif col.name?ends_with("link_url")>
	      <input type="text" class="form-control" ${insertCommon} th:value="${"${"}editObj.${col.propertyName}${"}"}"/>
		  <#elseif col.name?ends_with('url') || col.name?ends_with('picture')|| col.name?ends_with('avatar')|| col.name?ends_with('icon')>
		  	<input type="hidden" class="form-control" ${insertCommon} th:value="${"${"}editObj.${col.propertyName}${"}"}"/>
		  	<div id='${col.propertyName}_uploader' class="uploader" data-ride="uploader" ></div>
	  		<script th:inline="javascript">
			    /*<![CDATA[*/
	               	var ${col.propertyName}Uploader = UploaderOperation.initUploader({
	               		uploaderId: '${col.propertyName}_uploader',
	               		filesUrlInputId: '${col.propertyName}',
	   			    	limitFilesCount: 1,
	   			    });
				   	/*]]>*/
		    </script>
	  		
		  <#elseif col.name?ends_with("price") || col.name?ends_with("amount") || col.name?ends_with("balance") || col.name?ends_with("offer")>
	  	  
	  	  <input type="number" step="0.01" data-fv-regexp-message="格式错误" pattern="^\d+(\.\d{1,2})?$" class="form-control" ${insertCommon}  th:value="${"${"}@thAmounts.toYuan(editObj.${col.propertyName})${"}"}" />
	  	  
	  	  <#elseif col.name?ends_with("sort")>
	  	  <input type="number" step="1" class="form-control" ${insertCommon}   th:value="${"${"}editObj.${col.propertyName}${"}"}" />
	  	  
	  	  <#elseif col.name?ends_with("num")>
	  	  <input type="number" step="1" min="0" class="form-control" ${insertCommon} th:value="${"${"}editObj.${col.propertyName}${"}"}" />
	  	  
	  	  <#elseif col.name == "create_date">
	  	  <input type="text" disabled="disabled" class="form-control"  ${dateValue} />
	  	  
	  	  <#elseif col.type == "datetime">
	  	  <input type="text" readonly="readonly" ${insertCommon_1}  class="form-control"  ${dateValue} />
	  	  
	      <script type="text/javascript" th:inline="javascript">
			    $(function(){
			    	$("#${col.propertyName}").datetimepicker({
					    language:  "zh-CN",
					    weekStart: 1,
					    todayBtn:  1,
					    autoclose: 1,
					    todayHighlight: 1,
					    startView: 2, //'month',
					    minView: 2,
					    forceParse: 1,
					    format: "yyyy-mm-dd hh:ii:ss"
					});
			    })
		    </script>
	      
	      	
	      <#elseif col.type?ends_with("text")>	
	      	<textarea ${insertCommon}  style="width:100%; height:200px;" th:text="${"${"}editObj.${col.propertyName}${"}"}"></textarea>
		    <script type="text/javascript" th:inline="javascript">
			    $(function(){
			    	var ue = UE.getEditor('${col.propertyName}', {
						serverUrl: [[@{|${'${'}@uploadHelper.host${'}'}/files/ueditor/controller|}]],
						initialFrameHeight: 400,
						initialFrameWidth: '100%',
						scaleEnabled : true
					});
			    })
		    </script>
		   <#elseif col.name?contains("remark") || col.name?ends_with("text")>
			 <textarea class="form-control" style="width:100%; height: 100px;" ${insertCommon} th:text="${"${"}editObj.${col.propertyName}${"}"}"></textarea>
		     <div class="help-block">长度限制${col.length?string('#.##')}个字</div> 
	      <#else>
	      <input type="text" class="form-control" ${insertCommon} th:value="${"${"}editObj.${col.propertyName}${"}"}"/>
	      </#if>
	      <div class="help-block"></div> 
	    </div>
	</div>
	</#if>
  	</#list>
	  
	 
	  <div class="form-group">
	    <div class="col-sm-offset-1 col-sm-10">
	      <button type="submit" class="btn btn-primary">保存</button>
	      
	      <button type="button" class="btn btn-default" onclick="history.back()">返回</button>
	    </div>
	  </div>
	  
	</form>
	

</body>


<#noparse>
<script type="text/javascript" th:inline="javascript">
/*<![CDATA[*/

		
	
		var referer = [[${#httpServletRequest.getHeader('Referer')}]];
		
        var formValidation = $('.edit-form').formValidation();
        
        var formValidationPlugin = $('.edit-form').data('formValidation');
        
        formValidation.on('success.form.fv', function(e) {
            // Prevent form submission
            e.preventDefault();

            // Get the form instance
            var $form = $(e.target);

            // Get the FormValidation instance
            var bv = $form.data('formValidation');
            
            /*
            var params = $form.serializeArray().map(x => {
            	var v = x.value;
            	if(x.name === 'price'){
            		//console.log(parseInt(x.value * 100))
            		v = parseInt(x.value * 100)
                }
            	return `${x.name}=${v}`;

            }).join('&');
            */

            // Use Ajax to submit form data
            $.post($form.attr('action'), $form.serialize(), function(result) {
                
                if(result.success){
            		Msg.success('操作成功!',null,function(){
	            		location.href = referer;                		
                	});
				}else{
					Msg.error('提示消息：操作失败!');
					setTimeout(function(){
						formValidationPlugin.disableSubmitButtons(false);
					},1000);
				}
                
            }, 'json');
        });
    
	
	
	
	
	$(function(){
		$('#updateDate').attr('disabled','disabled');
		$('#createDate').attr('disabled','disabled');
		//$('#updateUserName').attr('disabled','disabled');
		//$('#createUserName').attr('disabled','disabled');
	})
/*]]>*/
</script>
</#noparse>

</html>