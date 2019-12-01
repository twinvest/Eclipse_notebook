function insertCheck() {
	if (document.boardForm.name.value == "") {
		alert("�̸��� �Է��� �ּ���.");
		document.boardForm.name.focus();
		return;
	}
	if (document.boardForm.passwd.value == "") {
		alert("��ȣ�� �Է��� �ּ���.");
		document.boardForm.passwd.focus();
		return;
	}
	if (document.boardForm.title.value == "") {
		alert("������ �Է��� �ּ���.");
		document.boardForm.title.focus();
		return;
	}
	document.boardForm.menu.value = 'insert';
	document.boardForm.submit();
}

function updateCheck() {
	if (document.boardForm.name.value == "") {
		alert("�̸��� �Է��� �ּ���.");
		document.boardForm.name.focus();
		return;
	}
	if (document.boardForm.passwd.value == "") {
		alert("��ȣ�� �Է��� �ּ���.");
		document.boardForm.passwd.focus();
		return;
	}
	if (document.boardForm.title.value == "") {
		alert("������ �Է��� �ּ���.");
		document.boardForm.title.focus();
		return;
	}
	document.boardForm.menu.value = 'update';
	document.boardForm.submit();
}