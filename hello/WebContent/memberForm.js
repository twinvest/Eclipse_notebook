function insertCheck() {
	if (document.memberForm.id.value == null) {
		alert("id�� �Է��� �ּ���.");
		document.memberForm.id.focus();
		return;
	}
	if (document.memberForm.passwd.value == "") {
		alert("��ȣ�� �Է��� �ּ���.");
		document.memberForm.passwd.focus();
		return;
	}
	if (document.memberForm.name.value == "") {
		alert("�̸��� �Է��� �ּ���.");
		document.memberForm.name.focus();
		return;
	}
	if (document.memberForm.jnum.value == "") {
		alert("�ֹι�ȣ�� �Է��� �ּ���.");
		document.boardForm.jnum.focus();
		return;
	}
	if (document.memberForm.cnum.value == "") {
		alert("��ȭ��ȣ�� �Է��� �ּ���.");
		document.boardForm.cnum.focus();
		return;
	}
	if (document.memberForm.anum.value == "") {
		alert("�ּҸ� �Է����ּ���..");
		document.memberForm.focus();
		return;
	}

	document.memberForm.submit();
}
