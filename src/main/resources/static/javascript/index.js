    // jQuery를 사용하여 요소의 가시성을 제어합니다.
    $(document).ready(function() {
        var userName = $(".user-name");
        var selectInfo = $(".select_info");

        // 사용자 이름 클릭 시
        userName.on("click", function() {
            selectInfo.css("display", "block");
        });

        // 다른 곳 클릭 시
        $(document).on("click", function(event) {
            if (!$(event.target).closest(".my_select").length) {
                selectInfo.css("display", "none");
            }
        });
    });