package ${classPackageName};

import ${packageGroupName}.commons.jdbclink.core.annotations.Column;
import ${packageGroupName}.commons.jdbclink.core.annotations.Id;
import ${packageGroupName}.commons.jdbclink.core.annotations.Table;
import ${packageGroupName}.commons.jdbclink.core.annotations.Entity;

<#list dataTypesImports as attr>
${attr}
</#list>

/**
 * ${tableDesc} 实体类
 * 
 * @author ${author}
 * ${datetime}
 */
@Entity
@Table(name = "${tableName}")
public class ${className} {

	/**
	 * ${tableDesc} 表名
	 */
	public static final String __ = "${tableName}";

	//列名常量
	
	<#list columns as attr>  
	/**
	 * ${comments[attr_index]}
	 */
	public static final String ${attr?upper_case} = "${attr}";
	
	</#list>
	
	/**
	 * 属性名称
	 */
	public static class PropName {
		<#list  columns as attr>  
		/**
		 * ${comments[attr_index]} -- (属性名称) 
		 */
		public static final String ${attr?upper_case} = "${properties[attr_index]}";
		</#list>
	};
	
<#list columns as attr>  
	<#if columnComments[attr_index]??>
	/**
	 * ${columnComments[attr_index].comment} 常量类 
	 */
	public static class ${properties[attr_index]?cap_first}Constant {
		<#list columnComments[attr_index].items as item>  
		/**
		 * ${item.name}   
		 */
		public static final int ${item.tag?upper_case} = ${item.num};
		</#list>
	};
	</#if>
</#list>
	


<#list columns as attr>  
	/**
	 * ${comments[attr_index]}
	 */
	<#if attr == idName>@Id</#if>
	@Column(name = ${attr?upper_case})
	private ${dataTypes[attr_index]} ${properties[attr_index]};
	
</#list>



<#list columns as attr>  
	
	
	/**
	 * ${comments[attr_index]}
	 */
	public ${dataTypes[attr_index]} get${properties[attr_index]?cap_first}() {
		return this.${properties[attr_index]};	
	}
	
	/**
	 * ${comments[attr_index]}
	 */
	public void set${properties[attr_index]?cap_first}(${dataTypes[attr_index]} ${properties[attr_index]}) {
		this.${properties[attr_index]} = ${properties[attr_index]};
		return this;	
	}
	
</#list>
	
	

}
