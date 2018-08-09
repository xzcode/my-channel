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
	  <li>查看</li>
	</ol>
	
	<form class="form-horizontal edit-form" th:action="${"@{"}|${"${"}baseReqPath${"}"}/ajax/edit/save|}">
		
		
	<#list tableInfo.columns as col>  
		
		<#assign dateValue = "th:value="+ "\"${" +"editObj." + col.propertyName + " != null ? #dates.format(editObj. "+ col.propertyName +", 'yyyy-MM-dd HH:mm:ss') : ''}\"">
	
	<div class="form-group ${(col.name == idName)?string("hide" , "")}">
		<label for="${col.propertyName}" class="col-sm-1"><#if col.columnComment??> ${col.columnComment.clearComment} <#else> ${col.comment} </#if>: </label>
		<div class="col-md-4 col-sm-10">
		
      <#if col.name?starts_with('is_')>
		    <select class="form-control" name="${col.propertyName}" id="${col.propertyName}" >
		     <option th:selected="${"${"}editObj.${col.propertyName} == 0 ${"}"}" value="0">否</option>
		     <option th:selected="${"${"}editObj.${col.propertyName} == 1 ${"}"}" value="1">是</option>
		    </select>
	     <#elseif ( col.columnComment ?? && col.columnComment.enumProperties??)>
	      	  <select name="${col.propertyName}" id="${col.propertyName}" class="form-control">
	      	  	<#list col.columnComment.enumProperties as item>  
		      	<option th:selected="${"${"}editObj.${col.propertyName} == ${item.value} ${"}"}" value="${item.value}">${item.desc}</option>
		      	</#list>
		      </select>
	      <#elseif col.name == "create_date">
	      
	      <input type="text"  class="form-control"  ${dateValue} />
	      	
      	  <#elseif col.name == "update_date">
      	  
      	  <input type="text"  class="form-control"  ${dateValue} />
      	
      	  <#elseif col.name?ends_with("_date")>
      	  
      	  <input type="text" readonly="readonly" name="${col.propertyName}" id="${col.propertyName}"  class="form-control"  ${dateValue} />
      	  
      	  <#elseif col.name?ends_with("price") || col.name?ends_with("amount") || col.name?ends_with("balance") || col.name?ends_with("offer")>
      	  
      	  <input type="text"  class="form-control"  th:value="${"${"}@thAmounts.toYuan(editObj.${col.propertyName})${"}"}" />
      	  <#elseif col.name?ends_with("link_url")>
	      <input type="text" class="form-control" name="${col.propertyName}" id="${col.propertyName}"   th:value="${"${"}editObj.${col.propertyName}${"}"}"/>
      	  <#elseif col.name?ends_with('url') || col.name?ends_with('picture')|| col.name?ends_with('avatar')>
      	  
      	  <a th:href="${'${'}editObj.${col.propertyName}${'}'}" target="_blank">
			<img th:src="${'${'}@uploadHelper.getMini(editObj.${col.propertyName})${'}'}" width="50" height="50" class=""/>
		  </a>
      	  
	      <#elseif col.type?contains("text") || col.name?ends_with("text")>
	      	
	      <textarea name="${col.propertyName}"  style="width:100%; height:100px;" id="${col.propertyName}" th:text="${"${"}editObj.${col.propertyName}${"}"}"></textarea>
	      
		  <#elseif col.name?contains("remark")>
		  
		  <textarea class="form-control" style="width:100%; height: 100px;" th:text="${"${"}editObj.${col.propertyName}${"}"}"></textarea>
	      	
	      <#else>
	      
	      <input type="text" class="form-control" name="${col.propertyName}" id="${col.propertyName}"   th:value="${"${"}editObj.${col.propertyName}${"}"}"/>
	      
	      </#if>
	      
	      <!-- <div class="help-block"></div> -->
	      
	    </div>
	</div>
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
		$('input').attr('disabled','disabled');
		$('textarea').attr('disabled','disabled');
		$('select').attr('disabled','disabled');
	})
/*]]>*/
</script>
</#noparse>

</html>