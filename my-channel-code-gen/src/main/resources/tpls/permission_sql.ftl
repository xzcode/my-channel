
<#list moduleMap?keys as key>
	<#list moduleMap[key] as item>
/*${item.permission_name}*/
INSERT INTO `admin_permission` (`uid`, `parent_id`, `permission`, `permission_name`, `deep`, `is_menu`, `url_pattern`, `menu_icon`, `sort_order`, `create_date`, `create_by`, `remark`) VALUES ('${item.uid}', '${item.parent_id}', '${item.permission}', '${item.permission_name}', '${item.deep}', '1', '${item.url_pattern}', 'icon-list-ul', '${item.sort_order}', now(), '1', '${item.remark}');

	</#list>
</#list>