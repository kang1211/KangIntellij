

$(function(){
    $(".step1").css("color","#222");

    // 전체 동의 체크박스가 변경될 때 다른 체크박스들도 동일하게 변경되도록 이벤트를 추가
    $('#allAgree').change(function() {
        var isChecked = $(this).prop('checked');
        $('input[name="accept"]').prop('checked', isChecked);
    });

   // 정보입력 hover 이벤트 핸들러 추가
       $('#join_btn').hover(function() {
           // 필수 항목이 모두 체크되어 있다면 배경색 변경
           var isAgree1Checked = $('#agree1').prop('checked');
           var isAgree2Checked = $('#agree2').prop('checked');
           var isAgree3Checked = $('#agree3').prop('checked');
           if (isAgree1Checked && isAgree2Checked && isAgree3Checked) {
               $(this).css("background","yellow");
               $(this).css("color","black");
           }
       }, function() {
           // hover가 끝날 때 원래 배경색으로 복원
           $(this).css("background","");
           $(this).css("color","#c7c7c7");
       });
   // -----------------------------------------------------
   // 개인정보가 모두 입력되어야 활성화 되는 버튼
     $(".write_list input").on("keyup",function(){
        var isValue=true;
        $(".write_list input").each(function(i,v){
        if($(v).val()==''){
            isValue=false;
            return;
            }
        });

        if(isValue){
        $("#submit_btn").addClass("on");
        }else{
            $("#submit_btn").removeClass("on");
        }
        })
    // -----------------------------------------------------
    // 하나라도 체크 안되어있으면 전체동의 풀기
       $('input[name="accept"]').change(function() {
          var isAgree1Checked = $('#agree1').prop('checked');
          var isAgree2Checked = $('#agree2').prop('checked');
          var isAgree3Checked = $('#agree3').prop('checked');
          var isAgree4Checked = $('#agree4').prop('checked');
          var isAgree5Checked = $('#agree5').prop('checked');

          if(!isAgree1Checked || !isAgree2Checked || !isAgree3Checked || !isAgree4Checked || !isAgree5Checked){
            $('#allAgree').prop('checked',false);
          }else{
            $('#allAgree').prop('checked',true);
          }
        });
});

// 정보입력 버튼 클릭 시 실행되는 함수
function agreeBt() {
// agree1, agree2, agree3 체크박스의 상태 확인
    var isAgree1Checked = $('#agree1').prop('checked');
    var isAgree2Checked = $('#agree2').prop('checked');
    var isAgree3Checked = $('#agree3').prop('checked');
// agree4, agree5는 무시
    // agree1, agree2, agree3 중 하나라도 체크되어 있지 않은 경우 알림창 띄우기
    if (!isAgree1Checked || !isAgree2Checked || !isAgree3Checked){
        alert('필수 항목에 동의해주셔야 합니다.');
    }else{
        $('#signup_wrap').css("display","block");
        $('#agree_wrap').css("display","none");
        $(".step1").css("color","#b7b7b7");
        $(".step2").css("color","#222");
    }
}

function submit(){
    var hasOn = $("#submit_btn").hasClass("on");
    if(hasOn){
    $("#signFm").submit();
    }else{
        alert("양식을 모두 입력하세요");
    }
}