<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${fullMapperName}" >

	<!-- 基础结果集-->
    <resultMap id="BaseResultMap" type="${fullEntityClassName}" >
        
	<#list tableInfo.columns as col>  
		<!-- ${col.comment} -->
		<#if col.isPrimaryKey >
			<id column="${col.name}" property="${col.propertyName}"/>
		<#else>
			<result column="${col.name}" property="${col.propertyName}"/>
		</#if>     
	</#list>
    </resultMap>
    

    
<!-- ///////////////////////////// -->


	<!-- 表名 -->
  <sql id="Table_Name" >
    ${tableInfo.tableName}
  </sql>
  
  <!-- 表别名 -->
  <sql id="Table_Alias_Name">
    ${tableAliasName}
  </sql>
  
  <!-- 用于查询的表名 -->
  <sql id="Select_Table_Name" >
    	<include refid="Table_Name"/>
    as 
    	<include refid="Table_Alias_Name"/>
  </sql>

  
  <!-- 查询列sql -->
  <sql id="Base_Select_Column_List" >
  <trim prefix="" suffix="" suffixOverrides="," >
  		<#list tableInfo.columns as col>
  			${tableAliasName}.${col.name},
  		</#list>
	</trim>
  </sql>
  
  <!-- 根据id查询字句 -->
  <sql id="Uid_Where">
  	where ${tableAliasName}.${idName} = ${"#{"}${idName}${"}"}
  </sql>
  
   <!-- 根据id查询字句 用于update-->
  <sql id="Uid_Where_Update">
  	where ${idName} = ${"#{"}${idName}}
  </sql>
  
  
  <!-- 插入列sql -->
  <sql id="Insert_Column_Trim_List">
  		<trim prefix="(" suffix=")" suffixOverrides=",">
  			<#list tableInfo.columns as col>
	  			<if test="${col.propertyName} != null" >
		    		${col.name},
		   		</if>
	  		</#list>
    	</trim>
  </sql>
  
  <!-- 插入值sql -->
  <sql id="Insert_Values_Trim_List">
  	<trim prefix="(" suffix=")" suffixOverrides="," >
  			<#list tableInfo.columns as col>
	  			<if test="${col.propertyName} != null" >
		    		${"#{"}${col.propertyName}${"}"},
		   		</if>
	  		</#list>
    	</trim>
  </sql>
  
  <!-- 更新列sql -->
  <sql id="Update_Columns_Set_List">
  	<set> 		
      <trim prefix="" suffix="" suffixOverrides="," >
      		<#list tableInfo.columns as col>
      			<if test="${col.propertyName} != null">
					${col.name} = ${"#{"}${col.propertyName}${"}"},
	    		</if>
      		</#list>
      </trim>
    </set>
  </sql>
  
  <!-- ///////////////////////////// -->
  <select id="selectByPrimaryKey"  resultMap="BaseResultMap">
    select 
    	<include refid="Base_Select_Column_List" />
    from 
    	<include refid="Select_Table_Name" />
    	<include refid="Uid_Where"/>
  </select>
  
  
  
  <select id="list" resultMap="BaseResultMap">
    select 
    	<include refid="Base_Select_Column_List" />
    from 
    	<include refid="Select_Table_Name" />
  </select>
  
  
  <select id="count" resultType="int">
    	select 
    		count(*) as count 
    	from 
    		<include refid="Select_Table_Name" />
    </select>
    
    
  <delete id="deleteByPrimaryKey">
    delete from 
    	<include refid="Table_Name" />
    	<include refid="Uid_Where_Update"/>
  </delete>
  
  <insert id="insert"  >
    insert into 
       	<include refid="Table_Name" />
    	<include refid="Insert_Column_Trim_List"/>
    values 
    	<include refid="Insert_Values_Trim_List"/>
  </insert>
  
  <insert id="insertSelective" keyColumn="${tableInfo.columns[0].name}" keyProperty="${tableInfo.columns[0].propertyName}" useGeneratedKeys="true" >
    insert into 
    	<include refid="Table_Name" />
    	<include refid="Insert_Column_Trim_List"/>
    values 
    	<include refid="Insert_Values_Trim_List"/>
  </insert>
  
  <update id="updateByPrimaryKey">
    update
    	<include refid="Table_Name" />
    	<include refid="Update_Columns_Set_List"/>
    	<include refid="Uid_Where_Update"/>
  </update>
  
  <update id="updateDelFlag">
    	update
    	<include refid="Table_Name" />
    	set
    		enabled = ${"#{"}enabled${"}"}
    	<include refid="Uid_Where_Update"/>
	</update>
    
  
  <!-- ///////////////////////////// -->
  
  
  
 </mapper>
