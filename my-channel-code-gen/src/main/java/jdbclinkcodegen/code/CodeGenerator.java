package jdbclinkcodegen.code;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.xzcode.jdbclink.codegen.JdbcLinkGenerator;
import com.xzcode.jdbclink.codegen.config.JdbcLinkEntityGeneratorConfig;
import com.xzcode.jdbclink.codegen.model.ColumnInfo;
import com.xzcode.jdbclink.codegen.model.ExtraTemplateInfo;
import com.xzcode.jdbclink.codegen.model.TableEntityInfo;
import com.xzcode.jdbclink.core.JdbcLink;

import jdbclinkcodegen.util.ProjectPathUtil;

@Component
public class CodeGenerator {
	
	@Autowired
	private JdbcLink jdbcLink;
	
	private JdbcLinkGenerator generator;
	
	private JdbcLinkEntityGeneratorConfig config;
	
	@Value("${server.database.dbname}")
	private String dbname;
	
	@Value("${server.database.url}")
	private String dbUrl;
	
	@Value("${server.database.username}")
	private String dbUserName;
	
	@Value("${server.database.password}")
	private String dbPassword;
	
	private String rootproject = "zjwl";
	
	/**公共模块项目名称*/
	//String commonProjectName = rootproject+ "-code-gen";
	String commonProjectName = rootproject+ "-common";
	
	/**后台管理模块项目名称*/
	String adminProjectName = rootproject+ "-admin";
	//String adminProjectName = rootproject+ "-code-gen";
	
	
	private String javaCodeRescourcesPath = "src/main/java";
	private String configRescourcesPath = "src/main/resources";
	
	
	private String author = "jdbclink code generator";
	
	private String packageGroupName = "com.xzcode";
	
	String mapperPackageName = packageGroupName + ".product.app.dao";
	String serviceInterfacePackageName = packageGroupName + ".product.app.service.facade";
	String servicePackageName = packageGroupName + ".product.app.service.impl";
	
	String controllerPackageName = packageGroupName +".product.app.controller";
	
	/**统一主键名称*/
	private String idName = "uid";
	

	
	/**
	 * 初始化自定义模版通用参数
	 * @param data
	 * @param tableEntityInfo
	 * 
	 * @author zai
	 * 2018-04-20
	 */
	private Map<String, Object> getTemplateCommonData( TableEntityInfo tableEntityInfo) {
		
		Map<String, Object> data = new HashMap<>();
		
		data.put("author", author);
		data.put("packageGroupName", packageGroupName);
		
		data.put("tableInfo", tableEntityInfo);
		data.put("tableDesc", tableEntityInfo.getTableComment());
		
		
		data.put("packageModelName", tableEntityInfo.getModuleName());
		
		data.put("entityClassName", tableEntityInfo.getEntityClassName());
		data.put("fullEntityClassName", tableEntityInfo.getFullPackageClassName());
		
		data.put("serviceInterfacePackageName", serviceInterfacePackageName + "." + tableEntityInfo.getModuleName());
		data.put("fullServiceInterfaceName", serviceInterfacePackageName + "." + tableEntityInfo.getModuleName() + "." + "I" + tableEntityInfo.getEntityClassName() + "Service");
		data.put("serviceInterfaceName", "I" + tableEntityInfo.getEntityClassName() + "Service");
		
		data.put("mapperPackageName", mapperPackageName + "." + tableEntityInfo.getModuleName());
		data.put("fullMapperName", mapperPackageName + "." + tableEntityInfo.getModuleName() + "." +tableEntityInfo.getEntityClassName() + "Mapper");
		data.put("mapperName", tableEntityInfo.getEntityClassName() + "Mapper");
		
		data.put("servicePackageName", servicePackageName + "." + tableEntityInfo.getModuleName());
		data.put("serviceName", tableEntityInfo.getEntityClassName() + "Service");
		
		return data;
	}
	
	
	@PostConstruct
	public void init() {
		config = new JdbcLinkEntityGeneratorConfig();
		config.setEntityDatabaseName(dbname);
		config.setDbUrl(dbUrl);
		config.setDbUserName(dbUserName);
		config.setDbPassword(dbPassword);
		config.setEntityBasicPackage("com.xzcode.product.common.entity");
		
		String targetProjectPackagePath = ProjectPathUtil.getTargetProjectPackagePath(
				rootproject, 
				commonProjectName, 
				javaCodeRescourcesPath, 
				config.getEntityBasicPackage()
		);
		
		config.setEntityBasicOutputPath(targetProjectPackagePath);
		generator = new JdbcLinkGenerator(config, jdbcLink);
	}
	
	
	
	/**
	 * 生成实体类文件
	 * 
	 * 
	 * @author zai
	 * 2018-04-19
	 */
	@PostConstruct
	public void generateEntities() {
		generator.generateEntities();
	}
	
	/**
	 * 生成公共代码
	 * 
	 * 
	 * @author zai
	 * 2018-04-19
	 */
	@PostConstruct
	public void generateCommonCode() {
		List<ExtraTemplateInfo> templateInfos = new LinkedList<>();
		
		
		
		
		
		templateInfos.add(
				ExtraTemplateInfo.create()
				.setTemplate("mapper-java.ftl")
				.setOutputFilenameGenerator((template, tableEntityInfo) -> {
					return tableEntityInfo.getEntityClassName() + "Mapper.java";
				})
				.setDataGenerator((tableEntityInfo) -> {
					Map<String, Object> data = getTemplateCommonData(tableEntityInfo);
					return data;
				})
				.setBasicOutputPath(ProjectPathUtil.getTargetProjectPackagePath(rootproject, commonProjectName,javaCodeRescourcesPath, mapperPackageName)));
		
		templateInfos.add(
				ExtraTemplateInfo.create()
				.setTemplate("mapper-xml.ftl")
				.setOutputFilenameGenerator((template, tableEntityInfo) -> {
					return tableEntityInfo.getEntityClassName() + "Mapper.xml";
				})
				.setDataGenerator((tableEntityInfo) -> {
					Map<String, Object> data = getTemplateCommonData(tableEntityInfo);
					
					//生成表别名
					String[] tbNameArr  = tableEntityInfo.getTableName().split("_");
					String tableAliasName = "";
					for (String str : tbNameArr) {
						tableAliasName += str.substring(0,1);
					}
					
					data.put("tableAliasName", tableAliasName);
					data.put("idName", "uid");
					
					return data;
				})
				.setBasicOutputPath(ProjectPathUtil.getTargetProjectPackagePath(rootproject, commonProjectName,configRescourcesPath,"mappers")));
		
		
		
		templateInfos.add(
				ExtraTemplateInfo.create()
				.setTemplate("i-service-java.ftl")
				.setOutputFilenameGenerator((template, tableEntityInfo) -> {
					return "I" + tableEntityInfo.getEntityClassName()  + "Service.java";
				})
				.setDataGenerator((tableEntityInfo) -> {
					
					Map<String, Object> data = getTemplateCommonData(tableEntityInfo);
					
					return data;
				})
				.setBasicOutputPath(ProjectPathUtil.getTargetProjectPackagePath(rootproject, commonProjectName,javaCodeRescourcesPath,"com.xzcode.product.app.service.facade")));
		
		
		templateInfos.add(
				ExtraTemplateInfo.create()
				.setTemplate("service-java.ftl")
				.setOutputFilenameGenerator((template, tableEntityInfo) -> {
					return tableEntityInfo.getEntityClassName() + "Service.java";
				})
				.setDataGenerator((tableEntityInfo) -> {
					Map<String, Object> data = getTemplateCommonData(tableEntityInfo);
					
					return data;
				})
				.setBasicOutputPath(ProjectPathUtil.getTargetProjectPackagePath(rootproject, commonProjectName, javaCodeRescourcesPath, servicePackageName)));
		
		Map<String, Object> extraData = new LinkedHashMap<>();
		
		generator.generateTableInfosExtra("/tpls", this.getClass(), templateInfos, extraData);
		
	}
	
	/**
	 * 生成admin后台代码
	 * 
	 * 
	 * @author zai
	 * 2018-04-19
	 */
	@PostConstruct
	public void generateAdminCode() {
		List<ExtraTemplateInfo> templateInfos = new LinkedList<>();
		
		
		
		templateInfos.add(
				ExtraTemplateInfo.create()
				.setTemplate("admin-controller-java.ftl")
				.setOutputFilenameGenerator((template, tableEntityInfo) -> {
					return tableEntityInfo.getEntityClassName() + "Controller.java";
				})
				.setDataGenerator((tableEntityInfo) -> {
					Map<String, Object> data = getTemplateCommonData(tableEntityInfo);
					
					data.put("controllerPackageName", controllerPackageName + "." + tableEntityInfo.getModuleName() );
					addHasParams(data, tableEntityInfo);
					
					return data;
				})
				.setBasicOutputPath(ProjectPathUtil.getTargetProjectPackagePath(rootproject, adminProjectName,javaCodeRescourcesPath, controllerPackageName)));
		
		
		templateInfos.add(
				ExtraTemplateInfo.create()
				.setTemplate("admin-list-html.ftl")
				.setDirPartGenerator((template, tableEntityInfo) -> {
					return tableEntityInfo.getEntityClassName().toLowerCase();
				})
				.setOutputFilenameGenerator((template, tableEntityInfo) -> {
					return "list.html";
				})
				.setDataGenerator((tableEntityInfo) -> {
					Map<String, Object> data = getTemplateCommonData(tableEntityInfo);
					
					data.put("idName", idName);
					addHasParams(data, tableEntityInfo);
					data.put("modelNameCn", getAdminModelNameCn(tableEntityInfo.getTableComment()));
					
					return data;
				})
				.setBasicOutputPath(ProjectPathUtil.getTargetProjectPackagePath(rootproject, adminProjectName,configRescourcesPath,"templates")));
		
		
		templateInfos.add(
				ExtraTemplateInfo.create()
				.setTemplate("admin-add-html.ftl")
				.setDirPartGenerator((template, tableEntityInfo) -> {
					return tableEntityInfo.getEntityClassName().toLowerCase();
				})
				.setOutputFilenameGenerator((template, tableEntityInfo) -> {
					return "add.html";
				})
				.setDataGenerator((tableEntityInfo) -> {
					Map<String, Object> data = getTemplateCommonData(tableEntityInfo);
					
					addHasParams(data, tableEntityInfo);
					data.put("idName", idName);
					data.put("modelNameCn", getAdminModelNameCn(tableEntityInfo.getTableComment()));
					
					
					return data;
				})
				.setBasicOutputPath(ProjectPathUtil.getTargetProjectPackagePath(rootproject, adminProjectName,configRescourcesPath,"templates")));
		
		templateInfos.add(
				ExtraTemplateInfo.create()
				.setTemplate("admin-edit-html.ftl")
				.setDirPartGenerator((template, tableEntityInfo) -> {
					return tableEntityInfo.getEntityClassName().toLowerCase();
				})
				.setOutputFilenameGenerator((template, tableEntityInfo) -> {
					return "edit.html";
				})
				.setDataGenerator((tableEntityInfo) -> {
					Map<String, Object> data = getTemplateCommonData(tableEntityInfo);
					
					addHasParams(data, tableEntityInfo);
					data.put("idName", idName);
					data.put("modelNameCn", getAdminModelNameCn(tableEntityInfo.getTableComment()));
					
					return data;
				})
				.setBasicOutputPath(ProjectPathUtil.getTargetProjectPackagePath(rootproject, adminProjectName,configRescourcesPath,"templates")));
		
		templateInfos.add(
				ExtraTemplateInfo.create()
				.setTemplate("admin-show-html.ftl")
				.setDirPartGenerator((template, tableEntityInfo) -> {
					return tableEntityInfo.getEntityClassName().toLowerCase();
				})
				.setOutputFilenameGenerator((template, tableEntityInfo) -> {
					return "show.html";
				})
				.setDataGenerator((tableEntityInfo) -> {
					Map<String, Object> data = getTemplateCommonData(tableEntityInfo);
					
					addHasParams(data, tableEntityInfo);
					data.put("idName", idName);
					data.put("modelNameCn", getAdminModelNameCn(tableEntityInfo.getTableComment()));
					
					return data;
				})
				.setBasicOutputPath(ProjectPathUtil.getTargetProjectPackagePath(rootproject, adminProjectName,configRescourcesPath,"templates")));
		
		Map<String, Object> extraData = new LinkedHashMap<>();
		
		generator.generateTableInfosExtra("/tpls", this.getClass(), templateInfos, extraData);
		
	}
	
	
	/**
	 * 生成后台权限语句
	 * 
	 * @author zai
	 * 2018-04-22
	 */
	@PostConstruct
	public void generateAdminPermissionSql() {
		List<TableEntityInfo> tableEntityInfos = generator.getTableEntityInfos();
		Map<String, Object> data = new LinkedHashMap<>();
		data.put("tableEntityInfos", tableEntityInfos);
		
		int start_id = 1000;
		int sort_id = 1000;
		
		Map<String, List<Map<String, String>>> moduleMap = new TreeMap<>();
		data.put("moduleMap", moduleMap);
		
		for (TableEntityInfo info : tableEntityInfos) {
			String module = info.getTableName().split("_")[0];
			
			Map<String, String> paramMap = new TreeMap<>();
			
			List<Map<String, String>> moduleList = moduleMap.get(module);
			if (moduleList == null) {
				moduleList= new LinkedList<>();
				moduleMap.put(module, moduleList);
			}
			
			String tableComment = info.getTableComment();
			if (tableComment.endsWith("表")) {
				tableComment = tableComment.substring(0, tableComment.lastIndexOf("表"));
			}
			
			if (moduleList.size() == 0) {
				
				paramMap.put("permission", module + "_manage");
				paramMap.put("permission_name", tableComment + "管理");
				paramMap.put("deep", "1");
				paramMap.put("url_pattern", "");
				paramMap.put("parent_id", "1");
				paramMap.put("remark", paramMap.get("permission_name"));
				paramMap.put("uid", String.valueOf(start_id));
				start_id++;
				
				paramMap.put("sort_order", String.valueOf(sort_id));
				sort_id++;
				moduleList.add(paramMap);
				
				paramMap = new TreeMap<>();
			}
			
			
				
			Map<String, String> rootParamMap = moduleList.get(0);
			paramMap.put("permission",  rootParamMap.get("permission")+ "_" + info.getTableName() + "_view_list");
			paramMap.put("permission_name", tableComment + "列表");
			paramMap.put("deep", "2");
			paramMap.put("url_pattern", "/" + module + "/" + info.getEntityClassName().toLowerCase() + "/view/list");
			paramMap.put("parent_id", rootParamMap.get("uid"));
			paramMap.put("remark", paramMap.get("permission_name"));
			paramMap.put("uid", String.valueOf(start_id));
			start_id++;
			paramMap.put("sort_order", String.valueOf(sort_id));
			sort_id++;
			moduleList.add(paramMap);
		}
		
		
		
		generator.generateCustom(
				ProjectPathUtil.getTargetProjectSourceCodePath(
						rootproject, 
						rootproject + "-code-gen", 
						"src/main/resources"
						) + "/sql", 
				"/tpls", 
				"permission_sql.ftl", 
				this.getClass(), 
				"permission_sql.sql", 
				data
				);
		
	}
	
	
	
	
	/**
	 * 获取后台模块名称
	 * @param tableComment
	 * @return
	 * 
	 * @author zai
	 * 2018-04-20
	 */
	private String getAdminModelNameCn(String tableComment) {
		String modelNameCn = tableComment;
		if (tableComment != null && modelNameCn.endsWith("表")) {
			modelNameCn = modelNameCn.substring(0, modelNameCn.indexOf("表"));						
		}
		return modelNameCn;
	}
	
	
	/**
	 * 判断是否存在 某些 字段
	 * @param tableEntityInfo
	 * @return
	 * 
	 * @author zai
	 * 2018-04-20
	 */
	private void addHasParams(Map<String, Object> data, TableEntityInfo tableEntityInfo) {

		data.put("hasEnabled", hasColumn("enabled", tableEntityInfo));
		data.put("hasCreateDate", hasColumn("create_date", tableEntityInfo));
		data.put("hasAdminId", hasColumn("admin_id", tableEntityInfo));
		data.put("hasUserId", hasColumn("user_id", tableEntityInfo));
	}
	
	/**
	 * 判断是否存在某列
	 * @param columnName
	 * @param tableEntityInfo
	 * @return
	 * 
	 * @author zai
	 * 2018-05-17
	 */
	private boolean hasColumn(String columnName, TableEntityInfo tableEntityInfo) {

		List<ColumnInfo> columns = tableEntityInfo.getColumns();
		for (ColumnInfo col : columns) {
			if (col.getName().equalsIgnoreCase(columnName)) {
				return true;
			}
		}
		return false;
	}
	
}
