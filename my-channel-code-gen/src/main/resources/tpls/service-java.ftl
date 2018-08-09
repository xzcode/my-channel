package ${servicePackageName};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ${packageGroupName}.jdbclink.core.JdbcLink;
import javax.annotation.PostConstruct;
import ${packageGroupName}.product.app.service.impl.BaseService;
import ${fullMapperName};
import ${fullEntityClassName};
import ${fullServiceInterfaceName};




/**
 * ${tableDesc} service
 * 
 * @author ${author} & code generator
 * ${.now?string("yyyy-MM-dd HH:mm:ss")}
 */
@Service
public class ${serviceName} extends BaseService<${entityClassName}> implements ${serviceInterfaceName}{
	
	@Autowired
	private ${mapperName} mapper;
	
	@Autowired
	private JdbcLink jdbcLink;
	
	@PostConstruct
	public void setBaseMapper() {
		super.setBaseMapper(mapper);
	}

}

	


