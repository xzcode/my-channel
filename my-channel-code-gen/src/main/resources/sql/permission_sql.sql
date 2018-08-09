
/*用户权限管理*/
INSERT INTO `admin_permission` (`uid`, `parent_id`, `permission`, `permission_name`, `deep`, `is_menu`, `url_pattern`, `menu_icon`, `sort_order`, `create_date`, `create_by`, `remark`) VALUES ('1000', '1', 'admin_manage', '用户权限管理', '1', '1', '', 'icon-list-ul', '1000', now(), '1', '用户权限管理');

/*用户权限列表*/
INSERT INTO `admin_permission` (`uid`, `parent_id`, `permission`, `permission_name`, `deep`, `is_menu`, `url_pattern`, `menu_icon`, `sort_order`, `create_date`, `create_by`, `remark`) VALUES ('1001', '1000', 'admin_manage_admin_permission_view_list', '用户权限列表', '2', '1', '/admin/adminpermission/view/list', 'icon-list-ul', '1001', now(), '1', '用户权限列表');

/*用户角色列表*/
INSERT INTO `admin_permission` (`uid`, `parent_id`, `permission`, `permission_name`, `deep`, `is_menu`, `url_pattern`, `menu_icon`, `sort_order`, `create_date`, `create_by`, `remark`) VALUES ('1002', '1000', 'admin_manage_admin_role_view_list', '用户角色列表', '2', '1', '/admin/adminrole/view/list', 'icon-list-ul', '1002', now(), '1', '用户角色列表');

/*用户权限角色对应关系列表*/
INSERT INTO `admin_permission` (`uid`, `parent_id`, `permission`, `permission_name`, `deep`, `is_menu`, `url_pattern`, `menu_icon`, `sort_order`, `create_date`, `create_by`, `remark`) VALUES ('1003', '1000', 'admin_manage_admin_role_permission_view_list', '用户权限角色对应关系列表', '2', '1', '/admin/adminrolepermission/view/list', 'icon-list-ul', '1003', now(), '1', '用户权限角色对应关系列表');

/*系统用户列表*/
INSERT INTO `admin_permission` (`uid`, `parent_id`, `permission`, `permission_name`, `deep`, `is_menu`, `url_pattern`, `menu_icon`, `sort_order`, `create_date`, `create_by`, `remark`) VALUES ('1004', '1000', 'admin_manage_admin_user_view_list', '系统用户列表', '2', '1', '/admin/adminuser/view/list', 'icon-list-ul', '1004', now(), '1', '系统用户列表');

/*系统用户角色列表*/
INSERT INTO `admin_permission` (`uid`, `parent_id`, `permission`, `permission_name`, `deep`, `is_menu`, `url_pattern`, `menu_icon`, `sort_order`, `create_date`, `create_by`, `remark`) VALUES ('1005', '1000', 'admin_manage_admin_user_role_view_list', '系统用户角色列表', '2', '1', '/admin/adminuserrole/view/list', 'icon-list-ul', '1005', now(), '1', '系统用户角色列表');

/*数据地域信息管理*/
INSERT INTO `admin_permission` (`uid`, `parent_id`, `permission`, `permission_name`, `deep`, `is_menu`, `url_pattern`, `menu_icon`, `sort_order`, `create_date`, `create_by`, `remark`) VALUES ('1006', '1', 'area_manage', '数据地域信息管理', '1', '1', '', 'icon-list-ul', '1006', now(), '1', '数据地域信息管理');

/*数据地域信息列表*/
INSERT INTO `admin_permission` (`uid`, `parent_id`, `permission`, `permission_name`, `deep`, `is_menu`, `url_pattern`, `menu_icon`, `sort_order`, `create_date`, `create_by`, `remark`) VALUES ('1007', '1006', 'area_manage_area_view_list', '数据地域信息列表', '2', '1', '/area/area/view/list', 'icon-list-ul', '1007', now(), '1', '数据地域信息列表');

/*轮播图信息管理*/
INSERT INTO `admin_permission` (`uid`, `parent_id`, `permission`, `permission_name`, `deep`, `is_menu`, `url_pattern`, `menu_icon`, `sort_order`, `create_date`, `create_by`, `remark`) VALUES ('1008', '1', 'banner_manage', '轮播图信息管理', '1', '1', '', 'icon-list-ul', '1008', now(), '1', '轮播图信息管理');

/*轮播图信息列表*/
INSERT INTO `admin_permission` (`uid`, `parent_id`, `permission`, `permission_name`, `deep`, `is_menu`, `url_pattern`, `menu_icon`, `sort_order`, `create_date`, `create_by`, `remark`) VALUES ('1009', '1008', 'banner_manage_banner_info_view_list', '轮播图信息列表', '2', '1', '/banner/bannerinfo/view/list', 'icon-list-ul', '1009', now(), '1', '轮播图信息列表');

/*用户反馈信息管理*/
INSERT INTO `admin_permission` (`uid`, `parent_id`, `permission`, `permission_name`, `deep`, `is_menu`, `url_pattern`, `menu_icon`, `sort_order`, `create_date`, `create_by`, `remark`) VALUES ('1010', '1', 'feedback_manage', '用户反馈信息管理', '1', '1', '', 'icon-list-ul', '1010', now(), '1', '用户反馈信息管理');

/*用户反馈信息列表*/
INSERT INTO `admin_permission` (`uid`, `parent_id`, `permission`, `permission_name`, `deep`, `is_menu`, `url_pattern`, `menu_icon`, `sort_order`, `create_date`, `create_by`, `remark`) VALUES ('1011', '1010', 'feedback_manage_feedback_view_list', '用户反馈信息列表', '2', '1', '/feedback/feedback/view/list', 'icon-list-ul', '1011', now(), '1', '用户反馈信息列表');

/*行业资讯信息管理*/
INSERT INTO `admin_permission` (`uid`, `parent_id`, `permission`, `permission_name`, `deep`, `is_menu`, `url_pattern`, `menu_icon`, `sort_order`, `create_date`, `create_by`, `remark`) VALUES ('1012', '1', 'info_manage', '行业资讯信息管理', '1', '1', '', 'icon-list-ul', '1012', now(), '1', '行业资讯信息管理');

/*行业资讯信息列表*/
INSERT INTO `admin_permission` (`uid`, `parent_id`, `permission`, `permission_name`, `deep`, `is_menu`, `url_pattern`, `menu_icon`, `sort_order`, `create_date`, `create_by`, `remark`) VALUES ('1013', '1012', 'info_manage_info_view_list', '行业资讯信息列表', '2', '1', '/info/info/view/list', 'icon-list-ul', '1013', now(), '1', '行业资讯信息列表');

/*留言信息管理*/
INSERT INTO `admin_permission` (`uid`, `parent_id`, `permission`, `permission_name`, `deep`, `is_menu`, `url_pattern`, `menu_icon`, `sort_order`, `create_date`, `create_by`, `remark`) VALUES ('1014', '1', 'message_manage', '留言信息管理', '1', '1', '', 'icon-list-ul', '1014', now(), '1', '留言信息管理');

/*留言信息列表*/
INSERT INTO `admin_permission` (`uid`, `parent_id`, `permission`, `permission_name`, `deep`, `is_menu`, `url_pattern`, `menu_icon`, `sort_order`, `create_date`, `create_by`, `remark`) VALUES ('1015', '1014', 'message_manage_message_view_list', '留言信息列表', '2', '1', '/message/message/view/list', 'icon-list-ul', '1015', now(), '1', '留言信息列表');

/*产品信息管理*/
INSERT INTO `admin_permission` (`uid`, `parent_id`, `permission`, `permission_name`, `deep`, `is_menu`, `url_pattern`, `menu_icon`, `sort_order`, `create_date`, `create_by`, `remark`) VALUES ('1016', '1', 'product_manage', '产品信息管理', '1', '1', '', 'icon-list-ul', '1016', now(), '1', '产品信息管理');

/*产品信息列表*/
INSERT INTO `admin_permission` (`uid`, `parent_id`, `permission`, `permission_name`, `deep`, `is_menu`, `url_pattern`, `menu_icon`, `sort_order`, `create_date`, `create_by`, `remark`) VALUES ('1017', '1016', 'product_manage_product_view_list', '产品信息列表', '2', '1', '/product/product/view/list', 'icon-list-ul', '1017', now(), '1', '产品信息列表');

/*产品分类信息列表*/
INSERT INTO `admin_permission` (`uid`, `parent_id`, `permission`, `permission_name`, `deep`, `is_menu`, `url_pattern`, `menu_icon`, `sort_order`, `create_date`, `create_by`, `remark`) VALUES ('1018', '1016', 'product_manage_product_category_view_list', '产品分类信息列表', '2', '1', '/product/productcategory/view/list', 'icon-list-ul', '1018', now(), '1', '产品分类信息列表');

/*成功案例信息管理*/
INSERT INTO `admin_permission` (`uid`, `parent_id`, `permission`, `permission_name`, `deep`, `is_menu`, `url_pattern`, `menu_icon`, `sort_order`, `create_date`, `create_by`, `remark`) VALUES ('1019', '1', 'successful_manage', '成功案例信息管理', '1', '1', '', 'icon-list-ul', '1019', now(), '1', '成功案例信息管理');

/*成功案例信息列表*/
INSERT INTO `admin_permission` (`uid`, `parent_id`, `permission`, `permission_name`, `deep`, `is_menu`, `url_pattern`, `menu_icon`, `sort_order`, `create_date`, `create_by`, `remark`) VALUES ('1020', '1019', 'successful_manage_successful_case_view_list', '成功案例信息列表', '2', '1', '/successful/successfulcase/view/list', 'icon-list-ul', '1020', now(), '1', '成功案例信息列表');

/*系统配置管理*/
INSERT INTO `admin_permission` (`uid`, `parent_id`, `permission`, `permission_name`, `deep`, `is_menu`, `url_pattern`, `menu_icon`, `sort_order`, `create_date`, `create_by`, `remark`) VALUES ('1021', '1', 'system_manage', '系统配置管理', '1', '1', '', 'icon-list-ul', '1021', now(), '1', '系统配置管理');

/*系统配置列表*/
INSERT INTO `admin_permission` (`uid`, `parent_id`, `permission`, `permission_name`, `deep`, `is_menu`, `url_pattern`, `menu_icon`, `sort_order`, `create_date`, `create_by`, `remark`) VALUES ('1022', '1021', 'system_manage_system_config_view_list', '系统配置列表', '2', '1', '/system/systemconfig/view/list', 'icon-list-ul', '1022', now(), '1', '系统配置列表');

/*用户基本信息管理*/
INSERT INTO `admin_permission` (`uid`, `parent_id`, `permission`, `permission_name`, `deep`, `is_menu`, `url_pattern`, `menu_icon`, `sort_order`, `create_date`, `create_by`, `remark`) VALUES ('1023', '1', 'user_manage', '用户基本信息管理', '1', '1', '', 'icon-list-ul', '1023', now(), '1', '用户基本信息管理');

/*用户基本信息列表*/
INSERT INTO `admin_permission` (`uid`, `parent_id`, `permission`, `permission_name`, `deep`, `is_menu`, `url_pattern`, `menu_icon`, `sort_order`, `create_date`, `create_by`, `remark`) VALUES ('1024', '1023', 'user_manage_user_info_view_list', '用户基本信息列表', '2', '1', '/user/userinfo/view/list', 'icon-list-ul', '1024', now(), '1', '用户基本信息列表');

/*版本信息管理*/
INSERT INTO `admin_permission` (`uid`, `parent_id`, `permission`, `permission_name`, `deep`, `is_menu`, `url_pattern`, `menu_icon`, `sort_order`, `create_date`, `create_by`, `remark`) VALUES ('1025', '1', 'version_manage', '版本信息管理', '1', '1', '', 'icon-list-ul', '1025', now(), '1', '版本信息管理');

/*版本信息列表*/
INSERT INTO `admin_permission` (`uid`, `parent_id`, `permission`, `permission_name`, `deep`, `is_menu`, `url_pattern`, `menu_icon`, `sort_order`, `create_date`, `create_by`, `remark`) VALUES ('1026', '1025', 'version_manage_version_view_list', '版本信息列表', '2', '1', '/version/version/view/list', 'icon-list-ul', '1026', now(), '1', '版本信息列表');

