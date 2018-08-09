/*-------------------------------------
sourcemuch js
-------------------------------------*/

/*-----------------Msg--------------------*/
var Msg = {};

Msg.confirm = function(title, text, funOk, funCancel){
	
	layer.confirm(title || '操作确认', {
		  btn: ['是','否'], //按钮
		  icon: 7,
		}, function(){
			funOk && funOk();
		}, function(){
			funCancel && funCancel();
		});
	
}


Msg.success = function(title,text, fun){
	layer.alert(title||'操作成功', {
		  skin: 'layui-bg-blue', //样式类名
		  icon: 1,
		  closeBtn: 0,
		}, function(index){
			layer.close(index);
			fun && fun();
		});
}

Msg.error = function(title, text, fun){
	
	layer.alert(title||'操作失败', {
		  skin: 'layui-bg-red', //样式类名
		  icon: 2,
		  closeBtn: 1
		}, function(index){
			layer.close(index);
			fun && fun();
		});
	
}

Msg.alert = function(title,text, fun){
	
	layer.alert(title||'注意', {
		  skin: 'layui-bg-blue', //样式类名
		  icon: 1,
		  closeBtn: 0,
		}, function(index){
			layer.close(index);
			fun && fun();
		});
}

window.Msg = Msg;
/*-----------------Msg--------------------*/

var UploaderOperation = {};
var UploaderSeq = 0;
UploaderOperation.initUploader = function(settings){
	
	var uploaderId = settings.uploaderId;
	var filesUrlInputId = '#' + settings.filesUrlInputId;
	
	var pictureUrls = $(filesUrlInputId).val();
	
	$('#' + uploaderId).html(UploaderInnerTemplate);
	
	var options = {
			//staticFiles: null,
			url: UploadUrl,
			file_data_name: 'uploadFile', //上传文件name，对应controller的字段名称
			limitFilesCount: 1,//限制上传文件数
			//removeUploaded: false,//上传成功后自动从界面上移除
			deleteActionOnDone: function(file, doRemoveFile){
				//console.log('deleteActionOnDone.......',file)
				var url = file.url;
				
				var fileUrls = $(filesUrlInputId).val();
				if(fileUrls){
					fileUrls = fileUrls.split(',');
					$(filesUrlInputId).val(fileUrls.filter(x => url != x).join(","));
				}
				
				doRemoveFile()
			},//删除上传成功的文件
			
			filters:{
			    // 只允许上传图片
			    mime_types: [
			        {title: '图片', extensions: 'jpg,gif,png,jpeg'}
			    ],
			    // 最大上传文件为 大小
			    max_file_size: '10mb',
			    // 不允许上传重复文件
			    prevent_duplicates: true
			},
			chunk_size: 0, //不启用分片
			multi_selection: false, // 多选文件
			responseHandler: function(responseObject, file){
					if(responseObject.status == 200){
						var resp  = JSON.parse(responseObject.response);
						if(resp.success){
							file.uid = resp.data.uid;
							
							var fileUrls = $(filesUrlInputId).val();
							if(fileUrls && fileUrls != ''){
								$(filesUrlInputId).val(fileUrls + `,${resp.data.fullUrl}`);
							}else{
								$(filesUrlInputId).val(resp.data.fullUrl);
							}
						}
					}
				},
			multipart_params: {}, //	multipart 附加参数
			fileIconCreator: function(fileType, file, uploader){
				var temp = `
					<a target="_blank" href="${file.url}">
						<div class="file-icon-image" style="background-image: url(${file.url})"></div>
					</a>
				`;
				return temp;
			},
			staticFiles: function() {
			    	if(!pictureUrls || pictureUrls == '') {
			    		return null;
			    	}
		    		var fileUrlArr = pictureUrls.split(',');
		    		if(fileUrlArr && fileUrlArr.length > 0) {
			    		var staticFiles = [];
			    		for(var i = 0; i < fileUrlArr.length; i ++) {
			    			staticFiles[i] = {id: 'pic_' + (UploaderSeq++), url: fileUrlArr[i]};
			    		}
			    		console.log('staticFiles:', staticFiles)
			    		return staticFiles;
				    }
		    		return null;
		    	}(),  
			/*staticFiles:  
			[
				{
				    id: 1,              // 文件id
				    url: null,
				    name: 'dick.jpg',            // 文件名，例如"myfile.gif"
				    type: 'image/*',            // 文件类型，例如"image/jpeg"
				    size: 0,            // 文件大小，单位为字节，当启用了客户端压缩功能后，该值可能会改变
				    origSize: 0,        // 文件的原始大小，单位为字节
				    lastModifiedDate: null // 文件的最后修改时间
				}
			]
			*/
	}
	
	$.extend(options,settings);
	
	$('#' + uploaderId).uploader(options);
   	return $('#' + uploaderId).data('zui.uploader');
	
}

window.UploaderOperation = UploaderOperation;

window.UploaderInnerTemplate = 
				`
				<div class="uploader-message text-center">
				  <div class="content"></div>
				  <button type="button" class="close">×</button>
				</div>
				<div class="uploader-files file-list file-list-grid"></div>
				<div>
				  <hr class="divider"/>
				  <button type="button" class="btn btn-link uploader-btn-browse"><i class="icon icon-plus"></i> 选择文件</button>
				  <button type="button" class="btn btn-link uploader-btn-start"><i class="icon icon-cloud-upload"></i> 开始上传</button>
				  <div class="uploader-status text-muted"></div>
				</div>
				`;


window.DataTableOperation = {
		initDatatablesOptions: function(settings) {
			
			var options = {
		        	   ajax: function (data, callback, settings) {
		        		   DataTableOperation.datatableAjax(
		   	   					dataTableUrl, 
		   	   					data,
		   	    				callback,
		   	   					{
		   	    					keyword: $('#keyword').val()
		   	    				}
	      					)
		        	   },
		        	   //dom: '<<"float_left"f>l<B><t>ip>',//datatables表格相关元素添加样式和顺序，详见：https://datatables.net/examples/basic_init/dom.html
		        	   /* buttons: [
		                   {
		                       text: 'My button',
		                       action: function ( e, dt, node, config ) {
		                           alert( 'Button activated' );
		                       }
		                   }
		               ], */
		       		   language: { //国际化
		       			 infoFiltered: '',
		       			 url: '/plugins/DataTables/DataTables-1.10.15/media/chinese.json',
		       		   },
		       		   /*
			       	   fixedColumns: { //列固定
				       		//leftColumns: 0,
				            //rightColumns: 1
			       	   },
			       	   */
		       		   autoWidth: false,
			       	   searching : false,
		       		   processing: true, //是否显示加载中文字
		       		   responsive: true,//是否开启响应式
		       		   lengthChange: false,//是否可修改每页显示的记录数
		       		   pageLength: 10,//每页记录数
		       		   pagingType: "full_numbers", //分页模式，当前全按钮
		        	   serverSide: true, //是否开启服务端模式
		               ordering: true, //是否开启排序功能
		               // order: [[ 0, 'desc' ]], //默认排序
		               paging: true,//是否开启分页
		               //scrollX: true, //是否可X轴滚动
		               /*
				       select: {
				            style:    'multi',
				            selector: 'td:first-child'
				        },
				       */
				       
		               stateSave: true,//是否保存当前表状态
		               stateSaveParams: function (settings, data) { //状态存储参数，此处默认自动添加搜索表单数据
		   					
		      				//console.log('stateSaveParams:')
		      				   if(!$('.search-form')[0]){
		      					   console.error('DataTables: Selector ".search-form" is not defined !')
		   					   return;
		   				   }
		      				   data.custom = {};
		      					$('.search-form').find('input,select').each(function(i,o){
		      						data.custom[$(o).attr('id')] = $(o).val();
		      					})
		   				   
		      			   },
		      			   stateLoadParams: function (settings, data) { //状态参数读取，此处默认读取参数并自动注入到搜索表单
		      				   
		      				//console.log('stateLoadParams:')
		      				   if(!$('.search-form')[0]){
		      					   console.error('DataTables: Selector ".search-form" is not defined !')
		      					   return;
		      				   }
		      					if(!data.custom){
		      						data.custom = {};
		      					}
		      				   $('.search-form').find('input,select').each(function(i,o){
		      						var e = $('#' + $(o).attr('id'));
		      						var id = e.attr('id');
		      						var initVal = e.val();
		      						var loadedVal = data.custom[id];
		      						
		      						//console.log('initVal:',initVal)
		      						
		      						if(loadedVal != 0 && (!loadedVal || loadedVal == '')){
		      							e.val(initVal);
		      						}else{
		   	   						e.val(data.custom[id]);   							
		      						}
		      						
		      					})
		   			   },
		               initComplete: function () {
		                   //console.log('initComplete');
		               },
		               /*
		               columns : [
		                   {
		                       data:"uid", //数据对应key
		                       name : "uid", //对应字段名称
		                       visible: false, //是否可视
		                       orderable: true, //是否可排序
		                       orderData: [0], //排序列与次排序列，
		                       searchable: false, //该列是否参与搜索
		                       responsivePriority: 1,//响应式，优先级，数值越小，越优先显示
		                       render : function(data, type, row) { //渲染单元格
		                           return data;
		                       },
		                   },
		                   { //select 模式模版
		                	   title: "#",
		                       data:"uid", 
		                       name : "uid",
		                       width: 30,
		                       className: 'select-checkbox',
		                       visible: true,
		                       orderable: false,
		                       searchable: false,
		                       //orderData: [1,0],
		                       render : function(data, type, row) {
		                           return '';
		                       },
                   		   }, 
	                   ]
	                   */
		       		   
			}
			
			return $.extend(options,settings);
		},
		
		datatableAjax: function(dataTableUrl, requestData,  callback, extraData) {
			if(!extraData){
				var extraData = {};
				$('.search-form').find('input,select').each(function(i,o){
					extraData[$(o).attr('id')] = $(o).val();
				})
			}
			$.ajax({
	    	      type: "post",
	    	      dataType: 'json',
	    	      url: dataTableUrl,
	    	      //contentType: 'application/json; charset=utf-8',
	    	      data: DataTableOperation.createAjaxData(requestData, extraData),
	    	      success: function (data) {
	    	    	  callback(data);
	    	      }
	    	    });
		},
		createAjaxData: function(tabledata, extraData) {
			var orderBy = null;
			var sorting = null;
			if(tabledata.order && tabledata.order[0]){
				var colIndex = tabledata.order[0].column;
				var colSorting = tabledata.order[0].dir;
				var col = tabledata.columns[colIndex];
				if(col){
					orderBy = col.name;
					sorting = colSorting;
				}
			}
			
			var data = {
				draw: tabledata.draw,    	
				start: tabledata.start,   	
				pageSize: tabledata.length,	
				keyword : tabledata.search.value, 	
				orderBy: orderBy, 	
				sorting: sorting  	
			};
			data = $.extend(data, extraData);
			console.log(extraData)
			return data;
		}
}
window.DataTableErrorHandle = function($table) {
	$.fn.dataTable.ext.errMode = 'none';
	$table.on( 'error.dt', function ( e, settings, techNote, message ){
	    console.error(  message );
	})
	return $table;
}


window.clickToUpdateStatus = function (_this) {
	var uid = $(_this).data("uid");
	var statusValue = $(_this).data("value");
	var cmdname = $(_this).text();
	var _url = $(_this).data("url");
	Msg.confirm(`你确定对该数据进行[${cmdname || '状态变更'}]操作吗?`, null,
	function(){
		$.get(
				_url, 
				{uid: uid, statusValue: statusValue},
				function(result){
					if(result.success){
						Msg.success('操作成功!',null,function(){ location.reload()});
					}else{
						Msg.error('操作失败!');
					}
				}
		)
	}
	);
	
}


