<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>www.jb51.net JS����ʱ</title>
</head>
<body>
<div id="div"></div>
<script type="text/javascript">
window.onload=clock;
function clock(){
var today=new Date(),//��ǰʱ��
    h=today.getHours(),
    m=today.getMinutes(),
    s=today.getSeconds();
  var stopTime=new Date("Feb 9 2019 00:00:00"),//����ʱ��
    stopH=stopTime.getHours(),
    stopM=stopTime.getMinutes(),
    stopS=stopTime.getSeconds();
  var shenyu=stopTime.getTime()-today.getTime(),//����ʱ������
    shengyuD=parseInt(shenyu/(60*60*24*1000)),//ת��Ϊ��
    D=parseInt(shenyu)-parseInt(shengyuD*60*60*24*1000),//��ȥ��ĺ�����
    shengyuH=parseInt(D/(60*60*1000)),//��ȥ��ĺ�����ת����Сʱ
    H=D-shengyuH*60*60*1000,//��ȥ�졢Сʱ�ĺ�����
    shengyuM=parseInt(H/(60*1000)),//��ȥ��ĺ�����ת���ɷ���
    M=H-shengyuM*60*1000;//��ȥ�졢Сʱ���ֵĺ�����
    S=parseInt((shenyu-shengyuD*60*60*24*1000-shengyuH*60*60*1000-shengyuM*60*1000)/1000)//��ȥ�졢Сʱ���ֵĺ�����ת��Ϊ��
    document.getElementById("div").innerHTML=(shengyuD+"��"+shengyuH+"Сʱ"+shengyuM+"��"+S+"��"+"<br>");
    // setTimeout("clock()",500);
    setTimeout(clock,500);
}
</script>
</body>
</html>