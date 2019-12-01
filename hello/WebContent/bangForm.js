function insertCheck() {
	if (document.bangForm.name.value == "") {
		alert("�̸��� �Է��� �ּ���.");
		document.bangForm.name.focus();
		return;
	}
	if (document.bangForm.passwd.value == "") {
		alert("��ȣ�� �Է��� �ּ���.");
		document.bangForm.passwd.focus();
		return;
	}
	if (document.bangForm.title.value == "") {
		alert("������ �Է��� �ּ���.");
		document.bangForm.title.focus();
		return;
	}
	document.bangForm.menu.value = 'insert';
	document.bangForm.submit();
}

function updateCheck() {
	if (document.bangForm.name.value == "") {
		alert("�̸��� �Է��� �ּ���.");
		document.bangForm.name.focus();
		return;
	}
	if (document.bangForm.passwd.value == "") {
		alert("��ȣ�� �Է��� �ּ���.");
		document.bangForm.passwd.focus();
		return;
	}
	if (document.bangForm.title.value == "") {
		alert("������ �Է��� �ּ���.");
		document.bangForm.title.focus();
		return;
	}
	document.bangForm.menu.value = 'update';
	document.bangForm.submit();
}