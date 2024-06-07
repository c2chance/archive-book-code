(function($) {

	function getPath(obj) {
		if (obj) {
			if (window.navigator.userAgent.indexOf("MSIE") >= 1) {
				obj.select();
				return document.selection.createRange().text;
			}
			else if (window.navigator.userAgent.indexOf("Firefox") >= 1) {
				var ip = document.getElementById("filename");  
				if (ip.files) {  
				//ffx3 - try to have access to full path  
					return obj.files.item(0).getAsDataURL(); 
				};  
				alert(ip.value);
				return ip.value;  
			}
			return obj.value;
		}
	}
	
	
	
	function readFileFirefox(fileBrowser) { //FF�����
	    try { 
	        netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect"); 
	    }  
	    catch (e) { 
	        alert('·������!'); 
	        return; 
	    }

	    var fileName=fileBrowser.value; 
	    var file = Components.classes["@mozilla.org/file/local;1"] 
	        .createInstance(Components.interfaces.nsILocalFile); 
	    try { 
	        file.initWithPath( fileName.replace(/\//g, "\\\\") ); 
	    } 
	    catch(e) { 
	        if (e.result!=Components.results.NS_ERROR_FILE_UNRECOGNIZED_PATH) throw e; 
	        return; 
	    }

	    if ( file.exists() == false ) { 
	        alert("File '" + fileName + "' not found."); 
	        return; 
	    } 
	    alert(file.path); 
	}


	

	$(function() {

		//��ȡ����
		var state = JUDGE.getURLParameter("state");
		var updatetype = JUDGE.getURLParameter("updatetype");
		$("#btnCancel").click(function() {
			window.parent.$('#wedit').window('close');
		});

		$("#btnSave").click(function() {
			var filepath = $('#serpath').val();
			///alert(filepath);
			if (filepath== null || filepath == "") {
				$.messager.alert("��ʾ��Ϣ", "�ļ������ϴ����ȴ��ϴ��ɹ����ڽ��д˲���!", "info");
				return;
			}

			var filename = escape(encodeURIComponent(filepath));
			$.ajax({
				type : "post",
				url : "../pcard/readPcardCsv.action?csvpath=" + filename + "&state=" + state+"&updatetype="+updatetype,
				dataType : "json",
				//data : maindata,
				contentType : "text/html",
				error : function(event, request, settings) {
					//����ʧ��ʱ���ú�����   
					$.messager.alert("��ʾ��Ϣ", "����ʧ��!", "info");
				},
				success : function(data) {
					//if (data.status=="F") {
						//$.messager.alert("��ʾ��Ϣ", "���ݶ�ȡ�ɹ���û��ƥ������κ����ݣ���˲����ݺ��ڽ��д˲���!", "info");

					//} else {
						$.messager.alert("��ʾ��Ϣ", "���ݶ�ȡ�ɹ����ɹ�����["+data.returncount+"]����¼!��״̬��["+data.stat+"]", "info", function() {
							window.parent.$('#dataview').datagrid('reload');
							window.parent.$('#wedit').window('close');
						});
					//}
				}
			});

		});

	});
})(window.jQuery);