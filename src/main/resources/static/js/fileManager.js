console.log("FileManger");

//파일의 갯수를 지정하는 변수
let count=0;

$("#fileAdd").click(function(){
    
    if(count<5){
        let r = '<div class="mb-3">';
        r = r+'<label for="contents" class="form-label">File</label>';
        r = r+'<input type="file" name="files">';
        r = r+'<button type="button" class="del">X</button>'
        r = r+'</div>';
        $("#fileAddResult").append(r);
        count++;
    }else {
        alert("최대 5개만 가능합니다.")
    }


    
});

//수정페이지에서 X버튼을 누르면 삭제하는 <div>의 js
$("#fileAddResult").on("click", ".del", function(){
    $(this).parent().remove();
    count--;
});


/// 글 수정시 첨부파일 삭제
$(".deleteFile").click(function(){
    //DB, HDD에 파일 삭제
    let check = confirm("삭제가 되면 복구가 불가능합니다.");

    if(check){
        //post
        // /qna/fileDelete
        //파라미터 fileNum
        let fileNum = $(this).attr("data-file-num");
        console.log("Before Result This", $(this));
        const btn = $(this);
        $.ajax({
            type:"POST",
            url :"fileDelete",
            data:{
                fileNum:fileNum
            },
            success:function(result){
                console.log("Result : ",result)
                console.log("After Result This", $(this));
                $(btn).parent().remove();
            },
            error:function(){
                console.log("Error 발생");
            }

        });

    }

});