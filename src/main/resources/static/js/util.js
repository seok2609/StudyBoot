function nullCheck(data, dest, kind){
    if(data == null || data == ''){
        $(dest)
        return false;
    }else{
        return true;
    }
}

// function nullCheck(data, dest, kind){
//     if(data == null || data ==''){
//         $(dest).html(kind+"필수입니다.");
//         return false;
//     }else{
//         $(dest).html("정상");
//         return true;
//     }
// }

function equals (data, checkDate) {
    if(data == checkDate) {
        return true;
    } else {
        return false;
    }
}