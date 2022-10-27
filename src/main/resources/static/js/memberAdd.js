console.log("memberAdd");

$("#all").click(function(){
    console.log("ALL클릭");
    let ch = $(this).prop("checked");
    console.log("ch : ", ch);

    $(".check").prop("checked", ch);
});

$(".check").click(function(){

    // let flag = true;
    $("#all").prop("checked",true); //클래스에 check를 가진 엘리먼트 전부에 아래 코드를 실행해라
    
    $(".check").each(function(index, item){
        let ch = $(item).prop("checked")    // 엘리먼트의 checked 값을 ch에 저장하고
        if(!ch){
            // flag = false;
            $("#all").prop("checked",false);
            return false;
        }
        console.log(ch);
    });
});

// $("#all").prop("checked".flag);



// $("#inputID").blur(function(){
//     console.log("inputID");
//     //아이디가 2자리 이하라면 블러표시
//     if($("#inputID").val().length<=2){
//         $("#idHelp").text("아이디를 두글자 이상 입력하세요.")
//         $("#inputID").focus();
//     }else{
//         $("#idHelp").text("");
//         $("#inputID").focus();
//     }
// });


//id, pw, pwCheck, name, email
let results = [false, false, false, false, false];

//id Check
$("#inputID").blur(function(){
    let result = nullCheck(($("#inputID").val()));
    // let result = nullCheck(($("#inputID").val(), $("#idHelp"), "ID입력은"));
    console.log("result : ", result);
    results[0] = result;

    if(result){
        $("#idHelp").html("정상");
    }else{
        $("#idHelp").html("ID는 필수입니다")
    }

    //단 id가 비어있지 않을때
    $.get("./idCheck?id="+id, function(data){
        console.log("data : ", data);
        if(data == '0'){
            $("#idHelp").html("사용가능한 ID 입니다 .");
            results[0] = result;
        }else{
            $("#idHelp").html("이미 사용중인 ID 입니다. ");
            results[0] = reuslt;
        }
    })
});

// pw Check
// $("#inputPW1").blur(function(){
//     let result = nullCheck($("#inputPW1").val());
//     results[1] = result;
//     $("#pwHelp1").val("");
//     results[2] = false;
//     $("#pwHelp2").html("");
//     if(result){
//         $("#pwHelp1").html("정상");
//     }else{
//         $("#pwHelp1").html("PW는 필수입니다")
//     }
// });

$("#inputPW1").on({
    blur:function(){
        let result = nullCheck($("#inputPW1"));
        $("#pwHelp1").html("정상");
        results[1] = result;
       
    },
    change:function(){
        let result = equals($("#inputPW").val(), $("#inputPW2").val());
        if(result){
            $("#pwHelp2").html("");
        }else{
            $("#pwHelp2").html("비밀번호 틀리다~");
            $("#pwHelp1").val("");
        }
        results[1]=result;
    }

});

$("#inputPW2").blur(function(){
    let result = equals($("#inputPW1").val(), $("#inputPW2").val());
    results[2] = result;
    if(result){
        $("#pwHelp2").html("정상");
    }else{
        $("#pwHelp2").html("PW가 틀립니다.");
    }
});

$("#inputName").blur(function(){
    let result = nullCheck($("#inputName").val());
    results[3] = result;
    if(result){
        $("#nameHelp").html("정상");
    }else{
        $("#nameHelp").html("이름 입력은 필수입니다.")
    }
});

$("#inputEmail").blur(function(){
    let result = nullCheck($("#inputEmail").val());
    results[4] = result;
    if(result){
        $("#emailHelp").html("정상");
    }else{
        $("#emailHelp").html("이메일 입력은 필수입니다.")
    }
});

$("#joinBtn").click(function(){
    //event 강제실행    

    if(results.includes(false)){
        alert("필수 입력은 다 입력하고 누르세요^.^");

    }else{
        // alert("전송");
        $("#addForm").submit();
    }

    // let c = true;
    // $.each(results, function(idx, item){
    //     if(!item){
    //         alert("필수입력은 다 입력하고 누르세요^.^");
    //         c = false;
    //         return false;
    //     }
    // });
    // if(c){
    //     $("#addForm").submit();
    // }
});

$("#test").click(function(){

    let id = "123";
    let name = "iu";

    $.post("test", {
        id : id,
        name : name
    }, function(result){
        console.log("Result : " , result);
    });
});